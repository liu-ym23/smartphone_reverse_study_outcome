package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements IHostAppMonitorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f108697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.api.a f108698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f108699c;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bundle");
    }

    public final Context getContext() {
        return this.f108699c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r101 = this.f108698b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r101 = this.f108698b;
        if (r101 == null) goto L6;
        r101.onPause(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r101 = this.f108698b;
        if (r101 == null) goto L6;
        r101.onResume(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r101 = this.f108698b;
        if (r101 == null) goto L6;
        r101.onStart(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r101 = this.f108698b;
        if (r101 == null) goto L6;
        r101.onStop(r100);
        return;
    }

    public n(Context r100, ReplayFloatWindowManager.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f108699c = r100;
        this.f108698b = r101;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
    public final void appEnterBackground(boolean r100, boolean r101) {
        this.f108697a = r100;
        if (r100 == false) goto L9;
        if (r101 == true) goto L10;
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r102 = this.f108698b;
        if (r102 == null) goto L11;
        r102.b();
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.bytedance.android.livesdk.chatroom.vs_base.api.a r102 = this.f108698b;
        if (r102 == null) goto L6;
        r102.onCreate(r100);
        return;
    }
}
