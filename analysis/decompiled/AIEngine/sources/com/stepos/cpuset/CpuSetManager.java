package com.stepos.cpuset;

import android.os.Process;
import android.util.Log;
import com.stepos.core.ota.d;
import com.stepos.cpuset.internal.CpuSetHelper;
import com.stepos.cpuset.internal.CpuSetNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuSetManager {
    public static final CpuSetManager INSTANCE;
    private static final String TAG = "CpuSetManager";
    private static Map<CoreTier, ? extends List<CpuCore>> classifiedCores;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoreTier.values().length];
            try {
                iArr[CoreTier.ULTRA_BIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoreTier.BIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoreTier.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoreTier.SMALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        CpuSetManager cpuSetManager = new CpuSetManager();
        INSTANCE = cpuSetManager;
        classifiedCores = CpuInfo.INSTANCE.classifyCores();
        cpuSetManager.logCpuInfo();
    }

    private CpuSetManager() {
    }

    private final String getTierName(CoreTier coreTier) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[coreTier.ordinal()];
        if (i10 == 1) {
            return "超大核";
        }
        if (i10 == 2) {
            return "大核";
        }
        if (i10 == 3) {
            return "中核";
        }
        if (i10 == 4) {
            return "小核";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void logCpuInfo() {
        Log.i(TAG, "=== CPU 核心信息 ===");
        Map<CoreTier, ? extends List<CpuCore>> map = classifiedCores;
        if (map != null) {
            for (Map.Entry<CoreTier, ? extends List<CpuCore>> entry : map.entrySet()) {
                CoreTier key = entry.getKey();
                List<CpuCore> value = entry.getValue();
                String tierName = INSTANCE.getTierName(key);
                ArrayList arrayList = new ArrayList(m.Z(value, 10));
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((CpuCore) it.next()).getCoreId()));
                }
                Log.i(TAG, tierName + ": " + arrayList);
            }
        }
        Log.i(TAG, "Native 库加载状态: " + CpuSetNative.INSTANCE.isNativeLibraryLoaded());
    }

    public static /* synthetic */ boolean setProcessAffinity$cpuset_release$default(CpuSetManager cpuSetManager, int i10, AffinityPolicy affinityPolicy, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return cpuSetManager.setProcessAffinity$cpuset_release(i10, affinityPolicy, str);
    }

    private final boolean setThreadAffinity(AffinityPolicy affinityPolicy) {
        return setThreadAffinity$cpuset_release$default(this, Process.myTid(), affinityPolicy, null, 4, null);
    }

    public static /* synthetic */ boolean setThreadAffinity$cpuset_release$default(CpuSetManager cpuSetManager, int i10, AffinityPolicy affinityPolicy, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return cpuSetManager.setThreadAffinity$cpuset_release(i10, affinityPolicy, str);
    }

    public final String getAffinityInfoString() {
        StringBuilder sb2 = new StringBuilder("=== CPU 亲和性管理器 ===\n\n");
        Map<CoreTier, ? extends List<CpuCore>> mapD0 = classifiedCores;
        if (mapD0 == null) {
            mapD0 = kotlin.collections.b.d0();
        }
        for (Map.Entry<CoreTier, ? extends List<CpuCore>> entry : mapD0.entrySet()) {
            CoreTier key = entry.getKey();
            List<CpuCore> value = entry.getValue();
            String tierName = INSTANCE.getTierName(key);
            ArrayList arrayList = new ArrayList(m.Z(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((CpuCore) it.next()).getCoreId()));
            }
            sb2.append(tierName + ": " + arrayList + "\n");
        }
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final Map<CoreTier, List<CpuCore>> getClassifiedCores() {
        Map map = classifiedCores;
        return map == null ? kotlin.collections.b.d0() : map;
    }

    public final int getCurrentRunningCpu() {
        return getCurrentRunningCpu(Process.myTid());
    }

    public final List<Integer> getCurrentThreadAffinity() {
        return getCurrentThreadAffinity(Process.myTid());
    }

    public final void refreshCpuInfo() {
        classifiedCores = CpuInfo.INSTANCE.classifyCores();
        logCpuInfo();
    }

    public final boolean resetThreadAffinity() {
        return resetThreadAffinity(Process.myTid());
    }

    public final boolean setPowerSaving() {
        return setThreadAffinity(AffinityPolicy.POWER_LOWEST);
    }

    public final boolean setProcessAffinity$cpuset_release(AffinityPolicy policy) {
        g.f(policy, "policy");
        return setProcessAffinity$cpuset_release$default(this, Process.myPid(), policy, null, 4, null);
    }

    public final boolean setThreadAffinity$cpuset_release(int i10, AffinityPolicy policy, String requestTag) {
        g.f(policy, "policy");
        g.f(requestTag, "requestTag");
        return CpuSetHelper.INSTANCE.setThreadAffinity(i10, policy, requestTag);
    }

    public final int getCurrentRunningCpu(int i10) {
        int currentRunningCpu = CpuSetHelper.INSTANCE.getCurrentRunningCpu(i10);
        if (currentRunningCpu >= 0) {
            Log.d(TAG, d.e(i10, "线程 ", currentRunningCpu, " 当前运行在 CPU ", " 上"));
            return currentRunningCpu;
        }
        Log.w(TAG, "无法获取线程 " + i10 + " 的当前 CPU");
        return currentRunningCpu;
    }

    public final List<Integer> getCurrentThreadAffinity(int i10) {
        return CpuSetHelper.INSTANCE.getThreadAffinity(i10);
    }

    public final boolean resetThreadAffinity(int i10) {
        return CpuSetHelper.INSTANCE.releaseThreadAffinity(i10);
    }

    public final boolean setProcessAffinity$cpuset_release(int i10, AffinityPolicy policy, String requestTag) {
        g.f(policy, "policy");
        g.f(requestTag, "requestTag");
        return CpuSetHelper.INSTANCE.setProcessAffinity(i10, policy, requestTag);
    }
}
