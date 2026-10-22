package com.stepos.cpuset.internal;

import a0.a;
import android.util.Log;
import com.stepos.cpuset.AffinityPolicy;
import com.stepos.perfsched.AiCpuSetConfig;
import com.stepos.perfsched.PerfSchedServiceStub;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiCpuSetBridge {
    private static final String TAG = "AiCpuSetBridge";
    public static final AiCpuSetBridge INSTANCE = new AiCpuSetBridge();
    private static final ConcurrentHashMap<Integer, Integer> handleByTid = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AffinityPolicy.values().length];
            try {
                iArr[AffinityPolicy.POWER_SAVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AffinityPolicy.POWER_LOWEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AiCpuSetBridge() {
    }

    public static /* synthetic */ boolean acquire$default(AiCpuSetBridge aiCpuSetBridge, int i10, AffinityPolicy affinityPolicy, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return aiCpuSetBridge.acquire(i10, affinityPolicy, str);
    }

    private final PerfSchedServiceStub obtainStub() {
        try {
            return PerfSchedServiceStub.get();
        } catch (Throwable th) {
            a.w("PerfSchedServiceStub.get() unavailable: ", th.getClass().getSimpleName(), ": ", th.getMessage(), TAG);
            return null;
        }
    }

    private final boolean safeRelease(PerfSchedServiceStub perfSchedServiceStub, int i10) {
        try {
            return perfSchedServiceStub.releaseAiCpuSet(i10) >= 0;
        } catch (Throwable th) {
            Log.w(TAG, "releaseAiCpuSet threw for handle=" + i10, th);
            return false;
        }
    }

    private final int toStubPolicy(AffinityPolicy affinityPolicy) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[affinityPolicy.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean acquire(int i10, AffinityPolicy policy, String requestTag) {
        PerfSchedServiceStub perfSchedServiceStubObtainStub;
        g.f(policy, "policy");
        g.f(requestTag, "requestTag");
        if (i10 <= 0 || (perfSchedServiceStubObtainStub = obtainStub()) == null) {
            return false;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = handleByTid;
        Integer numRemove = concurrentHashMap.remove(Integer.valueOf(i10));
        if (numRemove != null) {
            INSTANCE.safeRelease(perfSchedServiceStubObtainStub, numRemove.intValue());
        }
        try {
            try {
                int iAcquireAiCpuSet = perfSchedServiceStubObtainStub.acquireAiCpuSet(new AiCpuSetConfig.Builder().setTid(i10).setPolicy(toStubPolicy(policy)).setResetAffinityOnRelease(true).setRequestTag(requestTag).build());
                if (iAcquireAiCpuSet <= 0) {
                    Log.w(TAG, "acquireAiCpuSet failed, tid=" + i10 + " policy=" + policy + " handle=" + iAcquireAiCpuSet);
                    return false;
                }
                concurrentHashMap.put(Integer.valueOf(i10), Integer.valueOf(iAcquireAiCpuSet));
                Log.d(TAG, "acquired tid=" + i10 + " policy=" + policy + " handle=" + iAcquireAiCpuSet);
                return true;
            } catch (Throwable th) {
                Log.w(TAG, "acquireAiCpuSet threw for tid=" + i10, th);
                return false;
            }
        } catch (Throwable th2) {
            Log.w(TAG, "build AiCpuSetConfig failed", th2);
            return false;
        }
    }

    public final boolean release(int i10) {
        Integer numRemove = handleByTid.remove(Integer.valueOf(i10));
        if (numRemove == null) {
            return true;
        }
        int iIntValue = numRemove.intValue();
        PerfSchedServiceStub perfSchedServiceStubObtainStub = obtainStub();
        if (perfSchedServiceStubObtainStub == null) {
            return false;
        }
        return safeRelease(perfSchedServiceStubObtainStub, iIntValue);
    }

    public final boolean releaseAll() {
        PerfSchedServiceStub perfSchedServiceStubObtainStub = obtainStub();
        if (perfSchedServiceStubObtainStub == null) {
            handleByTid.clear();
            return false;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = handleByTid;
        Map mapN0 = b.n0(concurrentHashMap);
        concurrentHashMap.clear();
        Iterator it = mapN0.values().iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!INSTANCE.safeRelease(perfSchedServiceStubObtainStub, ((Number) it.next()).intValue())) {
                z = false;
            }
        }
        return z;
    }
}
