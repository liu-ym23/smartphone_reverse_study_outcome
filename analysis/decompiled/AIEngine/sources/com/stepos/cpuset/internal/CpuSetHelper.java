package com.stepos.cpuset.internal;

import android.util.Log;
import com.stepos.cpuset.AffinityPolicy;
import gc.a;
import gc.n;
import gc.o;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.l;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuSetHelper {
    public static final CpuSetHelper INSTANCE = new CpuSetHelper();
    private static final String TAG = "CpuSetHelper";

    private CpuSetHelper() {
    }

    private final int getCurrentRunningCpuFromProc(int i10) {
        Integer numC0;
        try {
            File file = new File("/proc/" + i10 + "/stat");
            if (file.exists()) {
                List listD0 = q.D0(d.Z(file, a.f9106b), new String[]{" "}, 6);
                if (listD0.size() >= 39 && (numC0 = n.c0((String) listD0.get(38))) != null) {
                    return numC0.intValue();
                }
            }
            return -1;
        } catch (Exception e10) {
            Log.e(TAG, "从 /proc 获取当前 CPU 失败", e10);
            return -1;
        }
    }

    private final List<Integer> getThreadAffinityFromProc(int i10) {
        Object next;
        try {
            File file = new File("/proc/" + i10 + "/status");
            if (file.exists()) {
                Iterator it = q.w0(d.Z(file, a.f9106b)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (o.k0((String) next, "Cpus_allowed_list:", false)) {
                        break;
                    }
                }
                String str = (String) next;
                if (str != null) {
                    return parseCoreList(q.L0(q.G0(str, ":")).toString());
                }
            }
            return null;
        } catch (Exception e10) {
            Log.e(TAG, "从 /proc 获取线程亲和性失败", e10);
            return null;
        }
    }

    private final List<Integer> parseCoreList(String str) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        for (String str2 : q.D0(str, new String[]{","}, 6)) {
            if (q.l0(str2, "-", false)) {
                List listD0 = q.D0(str2, new String[]{"-"}, 6);
                int i10 = Integer.parseInt(q.L0((String) listD0.get(0)).toString());
                int i11 = Integer.parseInt(q.L0((String) listD0.get(1)).toString());
                if (i10 <= i11) {
                    while (true) {
                        arrayList.add(Integer.valueOf(i10));
                        if (i10 != i11) {
                            i10++;
                        }
                    }
                }
            } else {
                arrayList.add(Integer.valueOf(Integer.parseInt(q.L0(str2).toString())));
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean setProcessAffinity$default(CpuSetHelper cpuSetHelper, int i10, AffinityPolicy affinityPolicy, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return cpuSetHelper.setProcessAffinity(i10, affinityPolicy, str);
    }

    public static /* synthetic */ boolean setThreadAffinity$default(CpuSetHelper cpuSetHelper, int i10, AffinityPolicy affinityPolicy, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return cpuSetHelper.setThreadAffinity(i10, affinityPolicy, str);
    }

    public final int getCurrentRunningCpu(int i10) {
        int currentCpu = CpuSetNative.INSTANCE.getCurrentCpu(i10);
        return currentCpu >= 0 ? currentCpu : getCurrentRunningCpuFromProc(i10);
    }

    public final List<Integer> getThreadAffinity(int i10) {
        int[] affinity = CpuSetNative.INSTANCE.getAffinity(i10);
        return affinity != null ? l.p0(affinity) : getThreadAffinityFromProc(i10);
    }

    public final boolean releaseThreadAffinity(int i10) {
        return AiCpuSetBridge.INSTANCE.release(i10);
    }

    public final boolean resetThreadAffinity(int i10) {
        return AiCpuSetBridge.INSTANCE.release(i10);
    }

    public final boolean setProcessAffinity(int i10, AffinityPolicy policy, String requestTag) {
        g.f(policy, "policy");
        g.f(requestTag, "requestTag");
        try {
            File file = new File("/proc/" + i10 + "/task");
            if (!file.exists()) {
                Log.w(TAG, "进程 " + i10 + " 不存在");
                return false;
            }
            File[] fileArrListFiles = file.listFiles();
            boolean z = true;
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    String name = file2.getName();
                    g.e(name, "getName(...)");
                    Integer numC0 = n.c0(name);
                    if (numC0 != null) {
                        if (!INSTANCE.setThreadAffinity(numC0.intValue(), policy, requestTag)) {
                            z = false;
                        }
                    }
                }
            }
            return z;
        } catch (Exception e10) {
            Log.e(TAG, "设置进程亲和性异常", e10);
            return false;
        }
    }

    public final boolean setThreadAffinity(int i10, AffinityPolicy policy, String requestTag) {
        g.f(policy, "policy");
        g.f(requestTag, "requestTag");
        boolean zAcquire = AiCpuSetBridge.INSTANCE.acquire(i10, policy, requestTag);
        if (!zAcquire) {
            Log.w(TAG, "PerfSchedServiceStub 绑核失败，线程 " + i10 + " 将使用系统默认调度");
            return zAcquire;
        }
        Log.i(TAG, "通过 PerfSchedServiceStub 成功绑定线程 " + i10 + "，策略 " + policy);
        return zAcquire;
    }
}
