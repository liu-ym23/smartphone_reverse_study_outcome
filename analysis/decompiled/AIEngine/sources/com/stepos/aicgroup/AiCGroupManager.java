package com.stepos.aicgroup;

import android.os.Process;
import android.util.Log;
import com.stepos.aicgroup.internal.CGroupAdjuster;
import com.stepos.aicgroup.internal.strategy.CGroupStrategy;
import com.stepos.aicgroup.internal.strategy.CGroupStrategyManager;
import com.stepos.cpuset.internal.CpuSetNativeKt;
import gc.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiCGroupManager {
    public static final AiCGroupManager INSTANCE = new AiCGroupManager();

    /* renamed from: a, reason: collision with root package name */
    public static final CGroupStrategyManager f5593a = CGroupStrategyManager.Companion.getInstance();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f5594b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5595c;

    static {
        CGroupAdjuster.INSTANCE.initialize();
        f5595c = kotlin.collections.b.g0(new Pair(AiCGroupManagerKt.CPUSET_SP_AI_REALTIME, "/ai-realtime"), new Pair(AiCGroupManagerKt.CPUSET_SP_AI_IMPORTANT, "/ai-important"), new Pair(AiCGroupManagerKt.CPUSET_SP_AI_NORMAL, "/ai-normal"), new Pair(AiCGroupManagerKt.CPUSET_SP_AI_BACKGROUND, "/ai-background"));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.Map] */
    public static void a(String str, zb.a aVar, List list) {
        String str2;
        if (f5594b) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                } else {
                    str2 = (String) f5595c.get((String) it.next());
                    if (str2 != null) {
                        break;
                    }
                }
            }
            if (str2 == null) {
                return;
            }
            try {
                String str3 = (String) aVar.invoke();
                if (str3 == null) {
                    CGroupStrategy currentStrategy = f5593a.getCurrentStrategy();
                    Log.w("AiCGroupManager", "verifyCpusetMatches[" + str + "] profiles=" + list + ": setTaskProfiles 返回成功但无法读出 cpuset；策略=" + (currentStrategy != null ? currentStrategy.getName() : null));
                    return;
                }
                if (str3.equals(str2)) {
                    return;
                }
                String strP0 = q.P0(str2, '/');
                String strP02 = q.P0(str2, '/');
                StringBuilder sb2 = new StringBuilder("verifyCpusetMatches[");
                sb2.append(str);
                sb2.append("] profiles=");
                sb2.append(list);
                sb2.append(": setTaskProfiles 返回成功但 cpuset=");
                ai.onnxruntime.a.z(sb2, str3, " (期望 ", str2, ")；ROM task_profiles.json 或 cgroup 运行时状态可能不完整。请依次检查：(1) /system/etc/task_profiles.json 是否含 *Capacity 系列 profile 且被引用；(2) /dev/cpuset/");
                Log.w("AiCGroupManager", com.stepos.core.ota.d.j(sb2, strP0, "/cpus 与 cpuset.mems 是否非空；(3) selinux 是否允许写 /dev/cpuset/", strP02, "/tasks（dmesg | grep avc）"));
            } catch (Throwable th) {
                Log.w("AiCGroupManager", "verifyCpusetMatches: read cpuset for " + str + " threw, skip", th);
            }
        }
    }

    public static /* synthetic */ String getCurrentProcessCGroup$default(AiCGroupManager aiCGroupManager, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.getCurrentProcessCGroup(str);
    }

    public static /* synthetic */ String getCurrentThreadCGroup$default(AiCGroupManager aiCGroupManager, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.getCurrentThreadCGroup(str);
    }

    public static /* synthetic */ String getProcessCGroup$default(AiCGroupManager aiCGroupManager, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.getProcessCGroup(i10, str);
    }

    public static /* synthetic */ String getThreadCGroup$default(AiCGroupManager aiCGroupManager, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.getThreadCGroup(i10, str);
    }

    public static /* synthetic */ boolean setCurrentProcessCGroup$default(AiCGroupManager aiCGroupManager, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.setCurrentProcessCGroup(str, str2);
    }

    public static /* synthetic */ boolean setCurrentThreadCGroup$default(AiCGroupManager aiCGroupManager, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.setCurrentThreadCGroup(str, str2);
    }

    public static /* synthetic */ boolean setProcessCGroup$default(AiCGroupManager aiCGroupManager, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.setProcessCGroup(i10, str, str2);
    }

    public static /* synthetic */ boolean setThreadCGroup$default(AiCGroupManager aiCGroupManager, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = CpuSetNativeKt.LIBRARY_NAME_CPU_SET;
        }
        return aiCGroupManager.setThreadCGroup(i10, str, str2);
    }

    public final List<String> getAvailableStrategies() {
        return f5593a.getAvailableStrategies();
    }

    public final String getCGroupInfoString() {
        String name;
        StringBuilder sb2 = new StringBuilder("=== CGroup 管理器 ===\n\n");
        int iMyPid = Process.myPid();
        int iMyTid = Process.myTid();
        sb2.append("当前进程 PID: " + iMyPid + "\n");
        sb2.append("当前线程 TID: " + iMyTid + "\n\n");
        CGroupStrategyManager cGroupStrategyManager = f5593a;
        CGroupStrategy currentStrategy = cGroupStrategyManager.getCurrentStrategy();
        List<String> availableStrategies = cGroupStrategyManager.getAvailableStrategies();
        if (currentStrategy == null || (name = currentStrategy.getName()) == null) {
            name = "无";
        }
        sb2.append("当前策略: " + name + "\n");
        sb2.append("可用策略: " + availableStrategies + "\n\n");
        sb2.append("当前进程的 CGroup 信息：\n");
        Map<String, String> currentProcessAllCGroups = getCurrentProcessAllCGroups();
        if (currentProcessAllCGroups.isEmpty()) {
            sb2.append("  无法读取 CGroup 信息\n");
        } else {
            for (Map.Entry<String, String> entry : currentProcessAllCGroups.entrySet()) {
                sb2.append(h0.e.c("  ", entry.getKey(), ": ", entry.getValue(), "\n"));
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final Map<String, String> getCurrentProcessAllCGroups() {
        return getProcessAllCGroups(Process.myPid());
    }

    public final String getCurrentProcessCGroup(String controller) {
        kotlin.jvm.internal.g.f(controller, "controller");
        return getProcessCGroup(Process.myPid(), controller);
    }

    public final String getCurrentStrategyName() {
        CGroupStrategy currentStrategy = f5593a.getCurrentStrategy();
        if (currentStrategy != null) {
            return currentStrategy.getName();
        }
        return null;
    }

    public final String getCurrentThreadCGroup(String controller) {
        kotlin.jvm.internal.g.f(controller, "controller");
        return getThreadCGroup(Process.myTid(), controller);
    }

    public final Map<String, String> getProcessAllCGroups(int i10) {
        return f5593a.getAllCGroups(i10);
    }

    public final String getProcessCGroup(int i10, String controller) {
        kotlin.jvm.internal.g.f(controller, "controller");
        return f5593a.getCGroup(i10, controller);
    }

    public final String getThreadCGroup(int i10, String controller) {
        kotlin.jvm.internal.g.f(controller, "controller");
        return f5593a.getCGroup(i10, controller);
    }

    public final boolean getVerifyCpusetAfterSetProfile() {
        return f5594b;
    }

    public final void registerStrategy(CGroupStrategy strategy, int i10) {
        kotlin.jvm.internal.g.f(strategy, "strategy");
        f5593a.registerStrategy(strategy, i10);
    }

    public final boolean setCurrentProcessCGroup(String cgroupPath, String controller) {
        kotlin.jvm.internal.g.f(cgroupPath, "cgroupPath");
        kotlin.jvm.internal.g.f(controller, "controller");
        return setProcessCGroup(Process.myPid(), cgroupPath, controller);
    }

    public final boolean setCurrentProcessProfiles(List<String> profiles) {
        kotlin.jvm.internal.g.f(profiles, "profiles");
        return setProcessProfiles(Process.myUid(), Process.myPid(), profiles);
    }

    public final boolean setCurrentTaskProfiles(List<String> profiles) {
        kotlin.jvm.internal.g.f(profiles, "profiles");
        return setTaskProfiles(Process.myPid(), profiles);
    }

    public final boolean setCurrentThreadCGroup(String cgroupPath, String controller) {
        kotlin.jvm.internal.g.f(cgroupPath, "cgroupPath");
        kotlin.jvm.internal.g.f(controller, "controller");
        return setThreadCGroup(Process.myTid(), cgroupPath, controller);
    }

    public final boolean setProcessCGroup(int i10, String cgroupPath, String controller) {
        kotlin.jvm.internal.g.f(cgroupPath, "cgroupPath");
        kotlin.jvm.internal.g.f(controller, "controller");
        return f5593a.setCGroup(i10, controller, cgroupPath);
    }

    public final boolean setProcessProfiles(int i10, final int i11, List<String> profiles) {
        kotlin.jvm.internal.g.f(profiles, "profiles");
        if (profiles.isEmpty()) {
            Log.w("AiCGroupManager", com.stepos.core.ota.d.e(i11, "Empty profiles list for PID ", i10, " (UID ", ")"));
            return false;
        }
        try {
            boolean processProfiles = f5593a.setProcessProfiles(i10, i11, profiles);
            if (!processProfiles) {
                Log.w("AiCGroupManager", "为进程 " + i11 + " (UID " + i10 + ") 设置配置文件失败: " + profiles);
                return processProfiles;
            }
            Log.i("AiCGroupManager", "成功为进程 " + i11 + " (UID " + i10 + ") 设置配置文件: " + profiles);
            StringBuilder sb2 = new StringBuilder("pid=");
            sb2.append(i11);
            sb2.append(" uid=");
            sb2.append(i10);
            a(sb2.toString(), new zb.a() { // from class: com.stepos.aicgroup.a
                @Override // zb.a
                public final Object invoke() {
                    return AiCGroupManager.f5593a.getCGroup(i11, CpuSetNativeKt.LIBRARY_NAME_CPU_SET);
                }
            }, profiles);
            return processProfiles;
        } catch (Exception e10) {
            Log.e("AiCGroupManager", "设置进程配置文件异常", e10);
            return false;
        }
    }

    public final boolean setTaskProfiles(int i10, List<String> profiles) {
        kotlin.jvm.internal.g.f(profiles, "profiles");
        if (profiles.isEmpty()) {
            Log.w("AiCGroupManager", "Empty profiles list for TID " + i10);
            return false;
        }
        try {
            boolean taskProfiles = f5593a.setTaskProfiles(i10, profiles);
            if (!taskProfiles) {
                Log.w("AiCGroupManager", "为线程 " + i10 + " 设置配置文件失败: " + profiles);
                return taskProfiles;
            }
            Log.i("AiCGroupManager", "成功为线程 " + i10 + " 设置配置文件: " + profiles);
            StringBuilder sb2 = new StringBuilder("tid=");
            sb2.append(i10);
            a(sb2.toString(), new b(i10, 0), profiles);
            return taskProfiles;
        } catch (Exception e10) {
            Log.e("AiCGroupManager", "设置线程配置文件异常", e10);
            return false;
        }
    }

    public final boolean setThreadCGroup(int i10, String cgroupPath, String controller) {
        kotlin.jvm.internal.g.f(cgroupPath, "cgroupPath");
        kotlin.jvm.internal.g.f(controller, "controller");
        return f5593a.setCGroup(i10, controller, cgroupPath);
    }

    public final void setVerifyCpusetAfterSetProfile(boolean z) {
        f5594b = z;
    }

    public final boolean unregisterStrategy(String strategyName) {
        kotlin.jvm.internal.g.f(strategyName, "strategyName");
        return f5593a.unregisterStrategy(strategyName);
    }
}
