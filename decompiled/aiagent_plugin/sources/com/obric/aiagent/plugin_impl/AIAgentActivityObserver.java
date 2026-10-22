package com.obric.aiagent.plugin_impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.sharedstate.SharedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: AIAgentActivityObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AIAgentActivityObserver implements Application.ActivityLifecycleCallbacks {
    public static final a Companion = null;
    private static final String KEY_ACTIVE = null;
    private static final String TAG = "AIAgentActivityObserver";
    private static final AtomicInteger count = null;
    private static final AtomicInteger originActive = null;

    /* JADX INFO: compiled from: AIAgentActivityObserver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin"), "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        o.e(r3, "outState");
    }

    public AIAgentActivityObserver() {
        SharedState.INSTANCE.putBoolean(KEY_ACTIVE, false);
    }

    static {
        Companion = new a(null);
        count = new AtomicInteger(0);
        originActive = new AtomicInteger(-1);
        KEY_ACTIVE = "oauto_active_state";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        o.e(r7, "activity");
        String r8 = r7.getClass().getName();     // Catch: Exception -> L14
        o.a(r8);     // Catch: Exception -> L14
        if (shouldIgnore(r8) == false) goto L7;
        ILogDepend.Companion.i(TAG, "onActivityStarted ignore: " + r8);     // Catch: Exception -> L14
        return;
    L7:
        ILogDepend.Companion.i(TAG, "onActivityStarted: " + r8);     // Catch: Exception -> L14
        if (count.getAndIncrement() != 0) goto L12;
        String r9 = getLaunchService(r8);     // Catch: Exception -> L14
        if (r9 == null) goto L12;
        ILogDepend.Companion.i(TAG, "setLaunchService: " + r9);     // Catch: Exception -> L14
        com.obric.aiagent.flow.applog.a.f18577a.b(r9);     // Catch: Exception -> L14
    L12:
        onActiveChange();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onActivityStarted error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        o.e(r7, "activity");
        String r1 = r7.getClass().getName();     // Catch: Exception -> L9
        o.a(r1);     // Catch: Exception -> L9
        if (shouldIgnore(r1) == false) goto L7;
        ILogDepend.Companion.i(TAG, "onActivityResumed ignore: " + r1);     // Catch: Exception -> L9
        return;
    L7:
        ILogDepend.Companion.i(TAG, "onActivityResumed: " + r1);     // Catch: Exception -> L9
        com.obric.aiagent.flow.applog.a.f18577a.a(r1, r7.hashCode());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onActivityResumed error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        o.e(r6, "activity");
        String r7 = r6.getClass().getName();     // Catch: Exception -> L9
        o.a(r7);     // Catch: Exception -> L9
        if (shouldIgnore(r7) == false) goto L7;
        ILogDepend.Companion.i(TAG, "onActivityPaused ignore: " + r7);     // Catch: Exception -> L9
        return;
    L7:
        ILogDepend.Companion.i(TAG, "onActivityPaused: " + r7);     // Catch: Exception -> L9
        com.obric.aiagent.flow.applog.a.f18577a.a();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onActivityPaused error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        o.e(r7, "activity");
        String r8 = r7.getClass().getName();     // Catch: Exception -> L12
        o.a(r8);     // Catch: Exception -> L12
        if (shouldIgnore(r8) == false) goto L7;
        ILogDepend.Companion.i(TAG, "onActivityStopped ignore: " + r8);     // Catch: Exception -> L12
        return;
    L7:
        ILogDepend.Companion.i(TAG, "onActivityStopped: " + r8);     // Catch: Exception -> L12
        com.obric.aiagent.flow.applog.a.f18577a.b();     // Catch: Exception -> L12
        if (count.decrementAndGet() != 0) goto L10;
        ILogDepend.Companion.i(TAG, "clearLaunchService");     // Catch: Exception -> L12
        com.obric.aiagent.flow.applog.a.f18577a.c();     // Catch: Exception -> L12
    L10:
        onActiveChange();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onActivityStopped error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final String getLaunchService(String r4) {
        if (d.o.o.b(r4, com.obric.autoaction.app.launcherpage.BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, null) == false) goto L6;
        return "open_oauto_task_page";
    L6:
        if (o.a(r4, "com.obric.autoaction.vdplayer.VDPlayerActivity") == false) goto L8;
    L9:
        return "open_oauto_virtual_player";
    L8:
        if (o.a(r4, "com.obric.autoaction.presentation.SurfaceCardActivity") == true) goto L9;
        return null;
    }

    private final boolean shouldIgnore(String r1) {
        return o.a(r1, "com.obric.autoaction.app.launcherpage.PinShortCutActivity");
    }

    public final void onActiveChange() {
        boolean r0 = false;
        if (count.get() <= 0) goto L5;
        int r4 = 1;
    L7:
        if (originActive.getAndSet(r4) == r4) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L16;
        SharedState r3 = SharedState.INSTANCE;
        String r5 = KEY_ACTIVE;
        if (r4 != 1) goto L14;
        r0 = true;
    L14:
        r3.putBoolean(r5, r0);
        return;
    L16:
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = 0;
        goto L7
    }
}
