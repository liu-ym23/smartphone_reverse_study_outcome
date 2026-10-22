package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.observer.ForegroundAppFilter;
import com.mdisdk.observer.ForegroundAppInfo;
import com.stepos.taskrobot.common.bean.MainDisplayTopAppHistory;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher;", "", AppAgent.CONSTRUCT, "()V", "Lcom/mdisdk/observer/ForegroundAppInfo;", "info", "LC7/r;", "onForegroundAppChange", "(Lcom/mdisdk/observer/ForegroundAppInfo;)V", "armSettleTimeoutLocked", "cancelSettleTimeoutLocked", "teardownLocked", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "releasedTask", "onTaskReleased", "(Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;)V", "onTaskStarting", "reset", "Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", RequestInfo.FUNCTION_SNAPSHOT, "()Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", "stateLock", "Ljava/lang/Object;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher$State;", "state", "Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher$State;", "", "baselinePackage", "Ljava/lang/String;", "currentPackage", "", "baselineAt", "J", "lastChangeAt", "", "changed", "Z", "chatSessionId", "Lcom/mdisdk/Task;", "watchTask", "Lcom/mdisdk/Task;", "observerRegId", "Ljava/lang/Runnable;", "settleTimeout", "Ljava/lang/Runnable;", "Companion", "State", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainDisplayWatcher {
    private static final String TAG = "MainDisplayWatcher";
    private static final String WATCH_TASK_ID = "__main_display_watcher__";
    private long baselineAt;
    private boolean changed;
    private long lastChangeAt;
    private String observerRegId;
    private Runnable settleTimeout;
    private Task watchTask;
    private final Object stateLock = new Object();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private State state = State.IDLE;
    private String baselinePackage = "";
    private String currentPackage = "";
    private String chatSessionId = "";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher$State;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "IDLE", "SETTLING", "WATCHING", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State IDLE = new State("IDLE", 0);
        public static final State SETTLING = new State("SETTLING", 1);
        public static final State WATCHING = new State("WATCHING", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{IDLE, SETTLING, WATCHING};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.SETTLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.WATCHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void armSettleTimeoutLocked() {
        cancelSettleTimeoutLocked();
        D6.b bVar = new D6.b(this, 26);
        this.settleTimeout = bVar;
        this.handler.postDelayed(bVar, 3000L);
        AbstractC1436a.a(TAG, "armSettleTimeout: posted 3000ms", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void armSettleTimeoutLocked$lambda$0(MainDisplayWatcher mainDisplayWatcher) {
        synchronized (mainDisplayWatcher.stateLock) {
            if (mainDisplayWatcher.state != State.SETTLING) {
                return;
            }
            mainDisplayWatcher.state = State.WATCHING;
            AbstractC1436a.e(TAG, "settle timeout (3000ms) in SETTLING (lastPkg=" + mainDisplayWatcher.currentPackage + " baseline=" + mainDisplayWatcher.baselinePackage + "), force WATCHING(armed)", true);
        }
    }

    private final void cancelSettleTimeoutLocked() {
        Runnable runnable = this.settleTimeout;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.settleTimeout = null;
    }

    private final void onForegroundAppChange(ForegroundAppInfo info) {
        String packageName = info.getPackageName();
        if (packageName == null) {
            packageName = "";
        }
        if (packageName.length() == 0) {
            return;
        }
        String previousPackageName = info.getPreviousPackageName();
        synchronized (this.stateLock) {
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        this.currentPackage = packageName;
                        if (packageName.equals(this.baselinePackage)) {
                            cancelSettleTimeoutLocked();
                            this.state = State.WATCHING;
                            AbstractC1436a.d(TAG, "SETTLING settled: pkg=" + packageName + " == baseline -> WATCHING(armed) at=" + SystemClock.elapsedRealtime(), true);
                        } else {
                            AbstractC1436a.a(TAG, "SETTLING ignore pkg=" + packageName + " (prev=" + previousPackageName + ") != baseline=" + this.baselinePackage, true);
                        }
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.currentPackage = packageName;
                        if (packageName.equals(this.baselinePackage)) {
                            AbstractC1436a.a(TAG, "WATCHING pkg=" + packageName + " == baseline, no change", true);
                        } else {
                            if (!this.changed) {
                                this.changed = true;
                            }
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            this.lastChangeAt = jElapsedRealtime;
                            AbstractC1436a.d(TAG, "WATCHING pkg=" + packageName + " (prev=" + previousPackageName + ") baseline=" + this.baselinePackage + " -> changed=true at=" + jElapsedRealtime, true);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onTaskReleased$lambda$1$0$0(ForegroundAppFilter.Builder registerForegroundAppObserver) {
        kotlin.jvm.internal.k.f(registerForegroundAppObserver, "$this$registerForegroundAppObserver");
        registerForegroundAppObserver.forDisplay(0);
        registerForegroundAppObserver.onAppChange(true);
        registerForegroundAppObserver.onActivityChange(false);
        registerForegroundAppObserver.onLeave(false);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTaskReleased$lambda$1$0$1(MainDisplayWatcher mainDisplayWatcher, ForegroundAppInfo info) {
        kotlin.jvm.internal.k.f(info, "info");
        mainDisplayWatcher.onForegroundAppChange(info);
    }

    private final void teardownLocked() {
        Object objA;
        cancelSettleTimeoutLocked();
        Task task = this.watchTask;
        String str = this.observerRegId;
        Object objA2 = r.f317a;
        if (task != null && str != null) {
            try {
                task.unregisterForegroundAppObserver(str);
                objA = objA2;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.e(TAG, "unregister observer failed: " + thA.getMessage(), true);
            }
        }
        if (task != null) {
            try {
                task.finish(true);
            } catch (Throwable th2) {
                objA2 = kotlin.b.a(th2);
            }
            Throwable thA2 = Result.a(objA2);
            if (thA2 != null) {
                AbstractC1436a.e(TAG, "watch task finish failed: " + thA2.getMessage(), true);
            }
        }
        this.watchTask = null;
        this.observerRegId = null;
        this.baselinePackage = "";
        this.currentPackage = "";
        this.baselineAt = 0L;
        this.lastChangeAt = 0L;
        this.changed = false;
        this.chatSessionId = "";
        this.state = State.IDLE;
    }

    public final void onTaskReleased(ZyqlGuiAgentTask releasedTask) {
        Object objA;
        String targetPackageName = releasedTask != null ? releasedTask.getTargetPackageName() : null;
        if (targetPackageName == null) {
            targetPackageName = "";
        }
        String chatSessionId = releasedTask != null ? releasedTask.getChatSessionId() : null;
        if (chatSessionId == null) {
            chatSessionId = "";
        }
        if (targetPackageName.length() == 0) {
            AbstractC1436a.e(TAG, "onTaskReleased: targetPackageName empty, skip opening window", true);
            synchronized (this.stateLock) {
                teardownLocked();
            }
            return;
        }
        synchronized (this.stateLock) {
            try {
                State state = this.state;
                if (state == State.SETTLING || state == State.WATCHING) {
                    AbstractC1436a.e(TAG, "onTaskReleased while already active (state=" + state + "), reset previous first", true);
                    teardownLocked();
                }
                this.baselinePackage = targetPackageName;
                this.currentPackage = targetPackageName;
                this.baselineAt = SystemClock.elapsedRealtime();
                this.lastChangeAt = 0L;
                this.changed = false;
                this.chatSessionId = chatSessionId;
                try {
                    Task taskCreate$default = TaskManager.create$default(WATCH_TASK_ID, null, false, 4, null);
                    objA = new Pair(taskCreate$default, taskCreate$default != null ? taskCreate$default.registerForegroundAppObserver(new n(6), new c(this, 1)) : null);
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    AbstractC1436a.c(TAG, "onTaskReleased register observer failed: " + thA.getMessage(), thA);
                    objA = new Pair(null, null);
                }
                Pair pair = (Pair) objA;
                Task task = (Task) pair.f4886a;
                String str = (String) pair.b;
                if (task != null && str != null) {
                    this.watchTask = task;
                    this.observerRegId = str;
                    this.state = State.SETTLING;
                    armSettleTimeoutLocked();
                    AbstractC1436a.d(TAG, "onTaskReleased baseline=" + this.baselinePackage + "(target) state=SETTLING at=" + this.baselineAt + " regId=" + str, true);
                    return;
                }
                this.watchTask = task;
                this.observerRegId = str;
                this.state = State.IDLE;
                AbstractC1436a.e(TAG, "onTaskReleased: watch task or observer is null, stay IDLE", true);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void onTaskStarting() {
        synchronized (this.stateLock) {
            if (this.state == State.IDLE && this.watchTask == null && this.observerRegId == null && this.baselinePackage.length() == 0 && !this.changed) {
                return;
            }
            AbstractC1436a.d(TAG, "onTaskStarting reset (prev state=" + this.state + ", changed=" + this.changed + ")", true);
            teardownLocked();
        }
    }

    public final void reset() {
        synchronized (this.stateLock) {
            State state = this.state;
            if (state == State.IDLE && this.watchTask == null && this.observerRegId == null) {
                return;
            }
            AbstractC1436a.d(TAG, "reset (prev state=" + state + ", changed=" + this.changed + ")", true);
            teardownLocked();
        }
    }

    public final MainDisplayTopAppHistory snapshot() {
        MainDisplayTopAppHistory mainDisplayTopAppHistory;
        synchronized (this.stateLock) {
            try {
                State state = this.state;
                mainDisplayTopAppHistory = new MainDisplayTopAppHistory(state == State.SETTLING || state == State.WATCHING, this.changed, this.baselinePackage, this.currentPackage, this.baselineAt, this.lastChangeAt, this.chatSessionId);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mainDisplayTopAppHistory;
    }
}
