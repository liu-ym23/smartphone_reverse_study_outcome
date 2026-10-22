package com.stepos.aicgroup;

import android.os.Process;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.internal.SvipBridge;
import com.stepos.aicgroup.internal.strategy.NativeCGroupStrategy;
import com.stepos.cpuset.CoreTier;
import com.stepos.cpuset.CpuCore;
import com.stepos.cpuset.CpuSetManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiDispatchers {
    public static final AiDispatchers INSTANCE = new AiDispatchers();

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5596a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, DispatcherState> f5597b;

    /* renamed from: c, reason: collision with root package name */
    public static final lb.d f5598c;

    /* renamed from: d, reason: collision with root package name */
    public static final lb.d f5599d;

    /* renamed from: e, reason: collision with root package name */
    public static final lb.d f5600e;

    /* renamed from: f, reason: collision with root package name */
    public static final lb.d f5601f;

    /* renamed from: g, reason: collision with root package name */
    public static final lb.d f5602g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AiThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final DispatcherPriority f5603a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5604b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f5605c;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DispatcherPriority.values().length];
                try {
                    iArr[DispatcherPriority.REALTIME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DispatcherPriority.IMPORTANT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DispatcherPriority.NORMAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DispatcherPriority.BACKGROUND.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AiThreadFactory(DispatcherPriority policy, String namePrefix) {
            kotlin.jvm.internal.g.f(policy, "policy");
            kotlin.jvm.internal.g.f(namePrefix, "namePrefix");
            this.f5603a = policy;
            this.f5604b = namePrefix;
            this.f5605c = new AtomicInteger(0);
        }

        public final boolean a() throws SecurityException, IllegalArgumentException {
            int i10 = WhenMappings.$EnumSwitchMapping$0[this.f5603a.ordinal()];
            if (i10 == 1) {
                int iMyTid = Process.myTid();
                Process.setThreadPriority(iMyTid, -2);
                return AiCGroupManager.INSTANCE.setTaskProfiles(iMyTid, b1.P(AiCGroupManagerKt.CPUSET_SP_AI_REALTIME));
            }
            if (i10 == 2) {
                int iMyTid2 = Process.myTid();
                Process.setThreadPriority(iMyTid2, -3);
                return AiCGroupManager.INSTANCE.setTaskProfiles(iMyTid2, b1.P(AiCGroupManagerKt.CPUSET_SP_AI_IMPORTANT));
            }
            if (i10 == 3) {
                return AiCGroupManager.INSTANCE.setTaskProfiles(Process.myTid(), b1.P(AiCGroupManagerKt.CPUSET_SP_AI_NORMAL));
            }
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int iMyTid3 = Process.myTid();
            Process.setThreadPriority(iMyTid3, 10);
            return AiCGroupManager.INSTANCE.setTaskProfiles(iMyTid3, b1.P(AiCGroupManagerKt.CPUSET_SP_AI_BACKGROUND));
        }

        public final String getDispatcherStates() {
            StringBuilder sb2 = new StringBuilder("=== 调度器状态 ===\n\n");
            for (Map.Entry entry : AiDispatchers.f5597b.entrySet()) {
                String str = (String) entry.getKey();
                PausableCoroutineDispatcher pausableDispatcher = ((DispatcherState) entry.getValue()).getPausableDispatcher();
                sb2.append(str + ":\n");
                sb2.append("  状态: " + ((pausableDispatcher == null || !pausableDispatcher.isPaused()) ? "运行中" : "已暂停") + "\n");
                int pendingCount = 0;
                sb2.append("  活跃协程: " + (pausableDispatcher != null ? pausableDispatcher.getActiveJobCount() : 0) + "\n");
                if (pausableDispatcher != null) {
                    pendingCount = pausableDispatcher.getPendingCount();
                }
                sb2.append("  排队任务: " + pendingCount + "\n");
                sb2.append("\n");
            }
            String string = sb2.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            return string;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            kotlin.jvm.internal.g.f(runnable, "runnable");
            final String str = this.f5604b + "-" + this.f5605c.incrementAndGet();
            Thread thread = new Thread(new Runnable() { // from class: com.stepos.aicgroup.c
                @Override // java.lang.Runnable
                public final void run() {
                    AiDispatchers.AiThreadFactory aiThreadFactory = this.f5689a;
                    String str2 = str;
                    Runnable runnable2 = runnable;
                    int iMyTid = Process.myTid();
                    boolean zAcquire$default = false;
                    try {
                        try {
                            boolean zA = aiThreadFactory.a();
                            AiDispatchers.DispatcherPriority dispatcherPriority = aiThreadFactory.f5603a;
                            if (zA) {
                                Log.d("AIDispatchers", "线程 " + str2 + " 成功绑定到策略 " + dispatcherPriority.name());
                            } else {
                                Log.w("AIDispatchers", "线程 " + str2 + " 绑核失败，将使用系统默认调度");
                            }
                            if (dispatcherPriority == AiDispatchers.DispatcherPriority.REALTIME && (zAcquire$default = SvipBridge.acquire$default(SvipBridge.INSTANCE, iMyTid, str2, 0, 0, 12, null))) {
                                Log.d("AIDispatchers", "线程 " + str2 + " 已标记 SVIP");
                            }
                            runnable2.run();
                            if (zAcquire$default) {
                                SvipBridge.INSTANCE.release(iMyTid);
                            }
                        } catch (Exception e10) {
                            Log.e("AIDispatchers", "线程 " + str2 + " 执行异常", e10);
                            if (zAcquire$default) {
                                SvipBridge.INSTANCE.release(iMyTid);
                            }
                        }
                    } finally {
                    }
                }
            });
            thread.setName(str);
            thread.setDaemon(false);
            return thread;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DispatcherPriority {
        public static final DispatcherPriority BACKGROUND;
        public static final DispatcherPriority IMPORTANT;
        public static final DispatcherPriority NORMAL;
        public static final DispatcherPriority REALTIME;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ DispatcherPriority[] f5606b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ sb.a f5607c;

        /* renamed from: a, reason: collision with root package name */
        public final int f5608a;

        static {
            DispatcherPriority dispatcherPriority = new DispatcherPriority("REALTIME", 0, 4);
            REALTIME = dispatcherPriority;
            DispatcherPriority dispatcherPriority2 = new DispatcherPriority("IMPORTANT", 1, 3);
            IMPORTANT = dispatcherPriority2;
            DispatcherPriority dispatcherPriority3 = new DispatcherPriority("NORMAL", 2, 2);
            NORMAL = dispatcherPriority3;
            DispatcherPriority dispatcherPriority4 = new DispatcherPriority("BACKGROUND", 3, 1);
            BACKGROUND = dispatcherPriority4;
            DispatcherPriority[] dispatcherPriorityArr = {dispatcherPriority, dispatcherPriority2, dispatcherPriority3, dispatcherPriority4};
            f5606b = dispatcherPriorityArr;
            f5607c = kotlin.enums.a.a(dispatcherPriorityArr);
        }

        public DispatcherPriority(String str, int i10, int i11) {
            this.f5608a = i11;
        }

        public static sb.a<DispatcherPriority> getEntries() {
            return f5607c;
        }

        public static DispatcherPriority valueOf(String str) {
            return (DispatcherPriority) Enum.valueOf(DispatcherPriority.class, str);
        }

        public static DispatcherPriority[] values() {
            return (DispatcherPriority[]) f5606b.clone();
        }

        public final int getLevel() {
            return this.f5608a;
        }
    }

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
        Map<String, DispatcherState> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.g.e(mapSynchronizedMap, "synchronizedMap(...)");
        f5597b = mapSynchronizedMap;
        f5598c = kotlin.b.b(new a9.b(6));
        f5599d = kotlin.b.b(new a9.a(5));
        f5600e = kotlin.b.b(new a9.b(7));
        f5601f = kotlin.b.b(new a9.a(6));
        f5602g = kotlin.b.b(new a9.b(8));
    }

    public static PausableCoroutineDispatcher a(int i10, String str, String str2, DispatcherPriority dispatcherPriority) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i10, new AiThreadFactory(dispatcherPriority, str));
        String strName = dispatcherPriority.name();
        StringBuilder sbF = h0.e.f("创建协程调度器: ", str, ", 线程数: ", i10, ", 策略: ");
        sbF.append(strName);
        Log.i("AIDispatchers", sbF.toString());
        kotlin.jvm.internal.g.c(executorServiceNewFixedThreadPool);
        CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        if (f5596a) {
            coroutineDispatcherFrom = new TrackedCoroutineDispatcher(coroutineDispatcherFrom, str2);
        }
        PausableCoroutineDispatcher pausableCoroutineDispatcher = new PausableCoroutineDispatcher(coroutineDispatcherFrom, str2, i10);
        f5597b.put(str2, new DispatcherState(str2, dispatcherPriority, executorServiceNewFixedThreadPool, pausableCoroutineDispatcher));
        return pausableCoroutineDispatcher;
    }

    public static /* synthetic */ void cancelDispatcher$default(AiDispatchers aiDispatchers, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "调度器被取消";
        }
        aiDispatchers.cancelDispatcher(str, str2);
    }

    public final boolean canUseRealTime() {
        return canUseRealTime(Process.myPid());
    }

    public final void cancelDispatcher(String dispatcherName, String reason) {
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        kotlin.jvm.internal.g.f(reason, "reason");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null) {
            ai.onnxruntime.a.x("取消失败：调度器 ", dispatcherName, " 不存在或未初始化", "AIDispatchers");
            return;
        }
        PausableCoroutineDispatcher pausableDispatcher = dispatcherState.getPausableDispatcher();
        if (pausableDispatcher == null) {
            ai.onnxruntime.a.x("取消失败：调度器 ", dispatcherName, " 无 PausableDispatcher", "AIDispatchers");
        } else {
            pausableDispatcher.cancelAll(reason);
        }
    }

    public final int getActiveCoroutineCount(String dispatcherName) {
        PausableCoroutineDispatcher pausableDispatcher;
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null || (pausableDispatcher = dispatcherState.getPausableDispatcher()) == null) {
            return 0;
        }
        return pausableDispatcher.getActiveJobCount();
    }

    public final List<DispatcherState> getAllDispatcherStates$aicgroup_release() {
        return kotlin.collections.a.O0(f5597b.values());
    }

    public final CoroutineDispatcher getBackground() {
        return (CoroutineDispatcher) f5601f.getValue();
    }

    public final String getDispatcherInfo() {
        String str;
        StringBuilder sb2 = new StringBuilder("=== AI协程调度器信息 ===\n\nCPU核心分类：\n");
        for (Map.Entry<CoreTier, List<CpuCore>> entry : CpuSetManager.INSTANCE.getClassifiedCores().entrySet()) {
            CoreTier key = entry.getKey();
            List<CpuCore> value = entry.getValue();
            int i10 = WhenMappings.$EnumSwitchMapping$0[key.ordinal()];
            if (i10 == 1) {
                str = "超大核";
            } else if (i10 == 2) {
                str = "大核";
            } else if (i10 == 3) {
                str = "中核";
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "小核";
            }
            ArrayList arrayList = new ArrayList(m.Z(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((CpuCore) it.next()).getCoreId()));
            }
            sb2.append("  " + str + ": " + arrayList + "\n");
        }
        sb2.append("\n调度器配置（Realtime/Background=2，Important/Normal=3，固定常驻；并发硬上限）：\n  1. Realtime - 2线程，绑定 /dev/cpuset/ai-realtime（含大核）\n  2. Important - 3线程，绑定 /dev/cpuset/ai-important\n  3. Normal - 3线程，绑定 /dev/cpuset/ai-normal\n  4. Background - 2线程，绑定 /dev/cpuset/ai-background（小核）\n");
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final List<String> getDispatcherNamesByPriorities$aicgroup_release(List<? extends DispatcherPriority> priorities) {
        kotlin.jvm.internal.g.f(priorities, "priorities");
        Collection<DispatcherState> collectionValues = f5597b.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (priorities.contains(((DispatcherState) obj).getPriority())) {
                arrayList.add(obj);
            }
        }
        List listI0 = kotlin.collections.a.I0(arrayList, new Comparator() { // from class: com.stepos.aicgroup.AiDispatchers$getDispatcherNamesByPriorities$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Integer.valueOf(((AiDispatchers.DispatcherState) t10).getPriority().getLevel()), Integer.valueOf(((AiDispatchers.DispatcherState) t8).getPriority().getLevel()));
            }
        });
        ArrayList arrayList2 = new ArrayList(m.Z(listI0, 10));
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            arrayList2.add(((DispatcherState) it.next()).getName());
        }
        return arrayList2;
    }

    public final boolean getEnableTaskTracking() {
        return f5596a;
    }

    public final CoroutineDispatcher getImportant() {
        return (CoroutineDispatcher) f5599d.getValue();
    }

    public final CoroutineDispatcher getNormal() {
        return (CoroutineDispatcher) f5600e.getValue();
    }

    public final int getPendingCount(String dispatcherName) {
        PausableCoroutineDispatcher pausableDispatcher;
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null || (pausableDispatcher = dispatcherState.getPausableDispatcher()) == null) {
            return 0;
        }
        return pausableDispatcher.getPendingCount();
    }

    public final CoroutineDispatcher getRealtime() {
        return (CoroutineDispatcher) f5598c.getValue();
    }

    public final boolean isAvailable(String dispatcherName) {
        PausableCoroutineDispatcher pausableDispatcher;
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        return !((dispatcherState == null || (pausableDispatcher = dispatcherState.getPausableDispatcher()) == null) ? true : pausableDispatcher.isPaused());
    }

    public final boolean isDispatcherPaused(String dispatcherName) {
        PausableCoroutineDispatcher pausableDispatcher;
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null || (pausableDispatcher = dispatcherState.getPausableDispatcher()) == null) {
            return false;
        }
        return pausableDispatcher.isPaused();
    }

    public final boolean pauseDispatcher(String dispatcherName) {
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null) {
            ai.onnxruntime.a.x("暂停失败：调度器 ", dispatcherName, " 不存在或未初始化", "AIDispatchers");
            return false;
        }
        PausableCoroutineDispatcher pausableDispatcher = dispatcherState.getPausableDispatcher();
        if (pausableDispatcher == null) {
            ai.onnxruntime.a.x("暂停失败：调度器 ", dispatcherName, " 无 PausableDispatcher", "AIDispatchers");
            return false;
        }
        boolean zPause = pausableDispatcher.pause();
        if (!zPause) {
            ai.onnxruntime.a.x("调度器 ", dispatcherName, " 已处于暂停状态", "AIDispatchers");
            return zPause;
        }
        Log.i("AIDispatchers", "调度器 " + dispatcherName + " 已暂停（新任务将入队等待）");
        return zPause;
    }

    public final boolean recoverOneThread$aicgroup_release(String dispatcherName) {
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        PausableCoroutineDispatcher pausableDispatcher = dispatcherState != null ? dispatcherState.getPausableDispatcher() : null;
        if (pausableDispatcher == null) {
            ai.onnxruntime.a.x("逐条恢复失败：调度器 ", dispatcherName, " 不存在或未初始化", "AIDispatchers");
            return true;
        }
        boolean zResumeOneSlot = pausableDispatcher.resumeOneSlot();
        ai.onnxruntime.a.y(h0.e.f("调度器 ", dispatcherName, " 恢复一条线程（当前并发 ", pausableDispatcher.currentConcurrency(), "）"), zResumeOneSlot ? "，已满" : "", "AIDispatchers");
        return zResumeOneSlot;
    }

    public final boolean resumeDispatcher(String dispatcherName) {
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        DispatcherState dispatcherState = f5597b.get(dispatcherName);
        if (dispatcherState == null) {
            ai.onnxruntime.a.x("恢复失败：调度器 ", dispatcherName, " 不存在或未初始化", "AIDispatchers");
            return false;
        }
        PausableCoroutineDispatcher pausableDispatcher = dispatcherState.getPausableDispatcher();
        if (pausableDispatcher == null) {
            ai.onnxruntime.a.x("恢复失败：调度器 ", dispatcherName, " 无 PausableDispatcher", "AIDispatchers");
            return false;
        }
        boolean zResume = pausableDispatcher.resume();
        if (!zResume) {
            ai.onnxruntime.a.x("调度器 ", dispatcherName, " 未处于暂停状态", "AIDispatchers");
            return zResume;
        }
        Log.i("AIDispatchers", "调度器 " + dispatcherName + " 已恢复");
        return zResume;
    }

    public final void setEnableTaskTracking(boolean z) {
        f5596a = z;
        Log.i("AIDispatchers", "任务追踪已".concat(z ? "启用" : "禁用"));
    }

    public final boolean canUseRealTime(int i10) {
        try {
            Integer oomScoreAdj = ((NativeCGroupStrategy) f5602g.getValue()).getOomScoreAdj(i10);
            if (oomScoreAdj == null) {
                Log.w("AIDispatchers", "无法获取进程 " + i10 + " 的 oom_score_adj，默认允许使用 Realtime");
                return true;
            }
            if (oomScoreAdj.intValue() > 100) {
                Log.i("AIDispatchers", "进程 " + i10 + " 的 oom_score_adj=" + oomScoreAdj + " > 100，不建议使用 Realtime 调度器");
                return false;
            }
            Log.d("AIDispatchers", "进程 " + i10 + " 的 oom_score_adj=" + oomScoreAdj + " <= 100，可以使用 Realtime 调度器");
            return true;
        } catch (Exception e10) {
            Log.e("AIDispatchers", "检查进程 " + i10 + " 的 canUseRealTime 异常", e10);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DispatcherState {

        /* renamed from: a, reason: collision with root package name */
        public final String f5609a;

        /* renamed from: b, reason: collision with root package name */
        public final DispatcherPriority f5610b;

        /* renamed from: c, reason: collision with root package name */
        public final ExecutorService f5611c;

        /* renamed from: d, reason: collision with root package name */
        public final PausableCoroutineDispatcher f5612d;

        public DispatcherState(String name, DispatcherPriority priority, ExecutorService executorService, PausableCoroutineDispatcher pausableCoroutineDispatcher) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(priority, "priority");
            this.f5609a = name;
            this.f5610b = priority;
            this.f5611c = executorService;
            this.f5612d = pausableCoroutineDispatcher;
        }

        public static /* synthetic */ DispatcherState copy$default(DispatcherState dispatcherState, String str, DispatcherPriority dispatcherPriority, ExecutorService executorService, PausableCoroutineDispatcher pausableCoroutineDispatcher, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = dispatcherState.f5609a;
            }
            if ((i10 & 2) != 0) {
                dispatcherPriority = dispatcherState.f5610b;
            }
            if ((i10 & 4) != 0) {
                executorService = dispatcherState.f5611c;
            }
            if ((i10 & 8) != 0) {
                pausableCoroutineDispatcher = dispatcherState.f5612d;
            }
            return dispatcherState.copy(str, dispatcherPriority, executorService, pausableCoroutineDispatcher);
        }

        public final String component1() {
            return this.f5609a;
        }

        public final DispatcherPriority component2() {
            return this.f5610b;
        }

        public final ExecutorService component3() {
            return this.f5611c;
        }

        public final PausableCoroutineDispatcher component4() {
            return this.f5612d;
        }

        public final DispatcherState copy(String name, DispatcherPriority priority, ExecutorService executorService, PausableCoroutineDispatcher pausableCoroutineDispatcher) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(priority, "priority");
            return new DispatcherState(name, priority, executorService, pausableCoroutineDispatcher);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DispatcherState)) {
                return false;
            }
            DispatcherState dispatcherState = (DispatcherState) obj;
            return kotlin.jvm.internal.g.b(this.f5609a, dispatcherState.f5609a) && this.f5610b == dispatcherState.f5610b && kotlin.jvm.internal.g.b(this.f5611c, dispatcherState.f5611c) && kotlin.jvm.internal.g.b(this.f5612d, dispatcherState.f5612d);
        }

        public final ExecutorService getExecutor() {
            return this.f5611c;
        }

        public final String getName() {
            return this.f5609a;
        }

        public final PausableCoroutineDispatcher getPausableDispatcher() {
            return this.f5612d;
        }

        public final DispatcherPriority getPriority() {
            return this.f5610b;
        }

        public int hashCode() {
            int iHashCode = (this.f5610b.hashCode() + (this.f5609a.hashCode() * 31)) * 31;
            ExecutorService executorService = this.f5611c;
            int iHashCode2 = (iHashCode + (executorService == null ? 0 : executorService.hashCode())) * 31;
            PausableCoroutineDispatcher pausableCoroutineDispatcher = this.f5612d;
            return iHashCode2 + (pausableCoroutineDispatcher != null ? pausableCoroutineDispatcher.hashCode() : 0);
        }

        public String toString() {
            return "DispatcherState(name=" + this.f5609a + ", priority=" + this.f5610b + ", executor=" + this.f5611c + ", pausableDispatcher=" + this.f5612d + ")";
        }

        public /* synthetic */ DispatcherState(String str, DispatcherPriority dispatcherPriority, ExecutorService executorService, PausableCoroutineDispatcher pausableCoroutineDispatcher, int i10, kotlin.jvm.internal.e eVar) {
            this(str, dispatcherPriority, (i10 & 4) != 0 ? null : executorService, (i10 & 8) != 0 ? null : pausableCoroutineDispatcher);
        }
    }
}
