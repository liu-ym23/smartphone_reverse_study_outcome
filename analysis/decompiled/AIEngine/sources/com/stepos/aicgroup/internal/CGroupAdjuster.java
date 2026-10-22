package com.stepos.aicgroup.internal;

import a6.f;
import android.app.ActivityThread;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.internal.os.BinderInternal;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.TrackedCoroutineDispatcher;
import com.stepos.aicgroup.internal.strategy.SceneDonate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CGroupAdjuster {
    public static final String ACTION_PROCESS_GROUP_STATE_CHANGED = "com.stepos.aicgroup.ACTION_PROCESS_GROUP_STATE_CHANGED";
    public static final String EXTRA_NEW_STATE = "new_state";
    public static final String EXTRA_NEW_STATE_LEVEL = "new_state_level";
    public static final String EXTRA_OLD_STATE = "old_state";
    public static final String EXTRA_OLD_STATE_LEVEL = "old_state_level";

    /* renamed from: e, reason: collision with root package name */
    public static p<? super ProcessGroupState, ? super ProcessGroupState, n> f5704e;

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f5706g;

    /* renamed from: i, reason: collision with root package name */
    public static volatile long f5707i;

    /* renamed from: l, reason: collision with root package name */
    public static f f5710l;
    public static final CGroupAdjuster INSTANCE = new CGroupAdjuster();

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f5700a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f5701b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f5702c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f5703d = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    public static volatile ProcessGroupState f5705f = ProcessGroupState.BACKGROUND;
    public static final Handler h = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f5708j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReference<Pair<ProcessGroupState, ProcessGroupState>> f5709k = new AtomicReference<>(null);

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AiDispatchers.DispatcherPriority> f5711m = new ConcurrentHashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ProcessGroupState {
        public static final ProcessGroupState BACKGROUND;
        public static final ProcessGroupState IMPORTANT;
        public static final ProcessGroupState NORMAL;
        public static final ProcessGroupState REALTIME;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ProcessGroupState[] f5712b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ sb.a f5713c;

        /* renamed from: a, reason: collision with root package name */
        public final int f5714a;

        static {
            ProcessGroupState processGroupState = new ProcessGroupState("REALTIME", 0, 4);
            REALTIME = processGroupState;
            ProcessGroupState processGroupState2 = new ProcessGroupState("IMPORTANT", 1, 3);
            IMPORTANT = processGroupState2;
            ProcessGroupState processGroupState3 = new ProcessGroupState("NORMAL", 2, 2);
            NORMAL = processGroupState3;
            ProcessGroupState processGroupState4 = new ProcessGroupState("BACKGROUND", 3, 1);
            BACKGROUND = processGroupState4;
            ProcessGroupState[] processGroupStateArr = {processGroupState, processGroupState2, processGroupState3, processGroupState4};
            f5712b = processGroupStateArr;
            f5713c = kotlin.enums.a.a(processGroupStateArr);
        }

        public ProcessGroupState(String str, int i10, int i11) {
            this.f5714a = i11;
        }

        public static sb.a<ProcessGroupState> getEntries() {
            return f5713c;
        }

        public static ProcessGroupState valueOf(String str) {
            return (ProcessGroupState) Enum.valueOf(ProcessGroupState.class, str);
        }

        public static ProcessGroupState[] values() {
            return (ProcessGroupState[]) f5712b.clone();
        }

        public final int getLevel() {
            return this.f5714a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AiDispatchers.DispatcherPriority.values().length];
            try {
                iArr[AiDispatchers.DispatcherPriority.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiDispatchers.DispatcherPriority.IMPORTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiDispatchers.DispatcherPriority.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiDispatchers.DispatcherPriority.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static Application a(String str) {
        Application applicationCurrentApplication;
        try {
            applicationCurrentApplication = ActivityThread.currentApplication();
        } catch (Throwable th) {
            Log.w("CGroupAdjuster", "ActivityThread.currentApplication() failed at stage=" + str + "; framework.jar may be incompatible", th);
            applicationCurrentApplication = null;
        }
        if (applicationCurrentApplication != null) {
            return applicationCurrentApplication;
        }
        ai.onnxruntime.a.x("ActivityThread.currentApplication() returned null at stage=", str, "; broadcast skipped", "CGroupAdjuster");
        return null;
    }

    public static void b(Application application, ProcessGroupState processGroupState, ProcessGroupState processGroupState2) {
        String strName = processGroupState.name();
        String strName2 = processGroupState2.name();
        String packageName = application.getPackageName();
        StringBuilder sbS = ai.onnxruntime.a.s("sendBroadcastNow: ", strName, " -> ", strName2, ", pkg=");
        sbS.append(packageName);
        Log.d("CGroupAdjuster", sbS.toString());
        try {
            Intent intent = new Intent(ACTION_PROCESS_GROUP_STATE_CHANGED);
            intent.putExtra(EXTRA_OLD_STATE, processGroupState.name());
            intent.putExtra(EXTRA_NEW_STATE, processGroupState2.name());
            intent.putExtra(EXTRA_OLD_STATE_LEVEL, processGroupState.getLevel());
            intent.putExtra(EXTRA_NEW_STATE_LEVEL, processGroupState2.getLevel());
            intent.setPackage(application.getPackageName());
            if (processGroupState == ProcessGroupState.REALTIME) {
                try {
                    BinderInternal.forceGc("background");
                } catch (Throwable th) {
                    Log.w("CGroupAdjuster", "BinderInternal.forceGc failed; framework.jar may be incompatible", th);
                }
            }
            try {
                SceneDonate.INSTANCE.donateSceneByProcessGroupState(processGroupState2.name(), "TRIGGERED");
            } catch (Throwable th2) {
                Log.w("CGroupAdjuster", "SceneDonate.donateSceneByProcessGroupState threw unexpectedly", th2);
            }
            application.sendBroadcast(intent);
            Log.i("CGroupAdjuster", "广播已发送: " + processGroupState.name() + " -> " + processGroupState2.name());
        } catch (Throwable th3) {
            Log.e("CGroupAdjuster", ai.onnxruntime.a.l("发送广播失败: ", processGroupState.name(), " -> ", processGroupState2.name()), th3);
        }
    }

    public final ProcessGroupState getCurrentState() {
        return f5705f;
    }

    public final String getStatusInfo() {
        StringBuilder sb2 = new StringBuilder("=== CGroupAdjuster 状态 ===\n");
        sb2.append("当前状态: " + f5705f.name() + "\n");
        sb2.append("活跃任务数:\n");
        sb2.append("  REALTIME: " + f5700a.get() + "\n");
        sb2.append("  IMPORTANT: " + f5701b.get() + "\n");
        sb2.append("  NORMAL: " + f5702c.get() + "\n");
        sb2.append("  BACKGROUND: " + f5703d.get() + "\n");
        sb2.append("已初始化: " + f5706g + "\n");
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final Map<AiDispatchers.DispatcherPriority, Integer> getTaskCounts() {
        return kotlin.collections.b.g0(new Pair(AiDispatchers.DispatcherPriority.REALTIME, Integer.valueOf(f5700a.get())), new Pair(AiDispatchers.DispatcherPriority.IMPORTANT, Integer.valueOf(f5701b.get())), new Pair(AiDispatchers.DispatcherPriority.NORMAL, Integer.valueOf(f5702c.get())), new Pair(AiDispatchers.DispatcherPriority.BACKGROUND, Integer.valueOf(f5703d.get())));
    }

    public final synchronized void initialize() {
        if (f5706g) {
            Log.w("CGroupAdjuster", "CGroupAdjuster 已经初始化过了");
            return;
        }
        ConcurrentHashMap<String, AiDispatchers.DispatcherPriority> concurrentHashMap = f5711m;
        concurrentHashMap.put("Realtime", AiDispatchers.DispatcherPriority.REALTIME);
        concurrentHashMap.put("Important", AiDispatchers.DispatcherPriority.IMPORTANT);
        concurrentHashMap.put("Normal", AiDispatchers.DispatcherPriority.NORMAL);
        concurrentHashMap.put("Background", AiDispatchers.DispatcherPriority.BACKGROUND);
        TrackedCoroutineDispatcher.Companion.setGlobalListener(new a());
        f5706g = true;
        Log.i("CGroupAdjuster", "CGroupAdjuster 初始化完成");
    }

    public final boolean isInBackgroundState() {
        return f5705f == ProcessGroupState.BACKGROUND;
    }

    public final boolean isInImportantOrHigher() {
        return f5705f.getLevel() >= ProcessGroupState.IMPORTANT.getLevel();
    }

    public final boolean isInRealtimeState() {
        return f5705f == ProcessGroupState.REALTIME;
    }

    public final void reset$aicgroup_release() {
        f fVar = f5710l;
        if (fVar != null) {
            h.removeCallbacks(fVar);
        }
        f5710l = null;
        f5708j.set(false);
        f5709k.set(null);
        f5707i = 0L;
        f5700a.set(0);
        f5701b.set(0);
        f5702c.set(0);
        f5703d.set(0);
        f5705f = ProcessGroupState.BACKGROUND;
        f5704e = null;
        f5706g = false;
        f5711m.clear();
        TrackedCoroutineDispatcher.Companion.setGlobalListener(null);
        Log.i("CGroupAdjuster", "CGroupAdjuster 已重置");
    }

    public final void setStateChangeListener(p<? super ProcessGroupState, ? super ProcessGroupState, n> pVar) {
        f5704e = pVar;
        Log.i("CGroupAdjuster", "状态变化监听器已".concat(pVar != null ? "设置" : "清除"));
    }
}
