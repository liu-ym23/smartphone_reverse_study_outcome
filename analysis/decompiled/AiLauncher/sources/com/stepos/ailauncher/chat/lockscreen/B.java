package com.stepos.ailauncher.chat.lockscreen;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/B;", "", "<init>", "()V", "", "f", "()Z", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;", "lockActivity", "LY8/t;", "c", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;)V", "", "TAG", "Ljava/lang/String;", "", "FINISH_FALLBACK_MS", "J", "HANDOFF_GUARD_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "handoffGuardUntil", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    private static final long FINISH_FALLBACK_MS = 800;
    private static final long HANDOFF_GUARD_MS = 1500;
    private static final String TAG = "LockScreenHandoffTransition";
    private static volatile long handoffGuardUntil;
    public static final B INSTANCE = new B();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/B$a;", "", "<init>", "()V", "", "finished", "Z", "c", "()Z", "f", "(Z)V", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", Const.INTENT_KEY_APIKEY, "()Landroid/app/Application$ActivityLifecycleCallbacks;", Const.INTENT_KEY_UMID, "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "Ljava/lang/Runnable;", "fallbackRunnable", "Ljava/lang/Runnable;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Runnable;", "e", "(Ljava/lang/Runnable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private Application.ActivityLifecycleCallbacks callbacks;
        public Runnable fallbackRunnable;
        private boolean finished;

        /* renamed from: a, reason: from getter */
        public final Application.ActivityLifecycleCallbacks getCallbacks() {
            return this.callbacks;
        }

        public final Runnable b() {
            Runnable runnable = this.fallbackRunnable;
            if (runnable != null) {
                return runnable;
            }
            kotlin.jvm.internal.p.A("fallbackRunnable");
            return null;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void d(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            this.callbacks = activityLifecycleCallbacks;
        }

        public final void e(Runnable runnable) {
            kotlin.jvm.internal.p.i(runnable, "<set-?>");
            this.fallbackRunnable = runnable;
        }

        public final void f(boolean z10) {
            this.finished = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/B$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityResumed", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ Runnable $finishLockTask;

        public b(Runnable runnable) {
            this.$finishLockTask = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            View decorView;
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity instanceof ChatMainActivity) {
                C4148a.d(B.TAG, "ChatMainActivity resumed -> finish lock screen task", false, 4, null);
                Window window = ((ChatMainActivity) activity).getWindow();
                if (window == null || (decorView = window.getDecorView()) == null) {
                    return;
                }
                decorView.post(this.$finishLockTask);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }
    }

    public static final void d(a aVar, LockScreenChatActivity lockScreenChatActivity, Application application) {
        if (aVar.getFinished()) {
            return;
        }
        aVar.f(true);
        Application.ActivityLifecycleCallbacks callbacks = aVar.getCallbacks();
        if (callbacks != null) {
            application.unregisterActivityLifecycleCallbacks(callbacks);
        }
        mainHandler.removeCallbacks(aVar.b());
        lockScreenChatActivity.J();
    }

    public static final void e(Runnable runnable) {
        C4148a.u(TAG, "fallback finish lock screen chat", false, 4, null);
        runnable.run();
    }

    public final void c(final LockScreenChatActivity lockActivity) {
        kotlin.jvm.internal.p.i(lockActivity, "lockActivity");
        handoffGuardUntil = SystemClock.elapsedRealtime() + 1500;
        lockActivity.N();
        final Application applicationA = C3197a.INSTANCE.a();
        kotlin.jvm.internal.p.g(applicationA, "null cannot be cast to non-null type android.app.Application");
        final a aVar = new a();
        final Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.z
            @Override // java.lang.Runnable
            public final void run() {
                B.d(aVar, lockActivity, applicationA);
            }
        };
        aVar.e(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.A
            @Override // java.lang.Runnable
            public final void run() {
                B.e(runnable);
            }
        });
        aVar.d(new b(runnable));
        Application.ActivityLifecycleCallbacks callbacks = aVar.getCallbacks();
        kotlin.jvm.internal.p.f(callbacks);
        applicationA.registerActivityLifecycleCallbacks(callbacks);
        mainHandler.postDelayed(aVar.b(), 800L);
    }

    public final boolean f() {
        return SystemClock.elapsedRealtime() < handoffGuardUntil;
    }
}
