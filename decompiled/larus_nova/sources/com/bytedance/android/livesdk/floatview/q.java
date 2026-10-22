package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements IHostAppMonitorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f125265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nz.s f125266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f125267c;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bundle");
    }

    public final Context getContext() {
        return this.f125267c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        nz.s r101 = this.f125266b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        nz.s r101 = this.f125266b;
        if (r101 == null) goto L6;
        r101.onPause(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        nz.s r101 = this.f125266b;
        if (r101 == null) goto L6;
        r101.onResume(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        nz.s r101 = this.f125266b;
        if (r101 == null) goto L6;
        r101.onStart(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (this.f125265a == false) goto L7;
        nz.s r101 = this.f125266b;
        if (r101 == null) goto L7;
        r101.c(r100);
    L7:
        nz.s r102 = this.f125266b;
        if (r102 == null) goto L11;
        r102.onStop(r100);
        return;
    }

    public q(Context r100, nz.s r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f125267c = r100;
        this.f125266b = r101;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
    public final void appEnterBackground(boolean r100, boolean r101) {
        this.f125265a = r100;
        if (r101 == true) goto L8;
        if (r100 == true) goto L8;
        nz.s r102 = this.f125266b;
        if (r102 == null) goto L8;
        r102.b();
    L8:
        if (r101 == true) goto L14;
        if (r100 == false) goto L15;
        nz.s r103 = this.f125266b;
        if (r103 == null) goto L16;
        r103.c(null);
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        nz.s r102 = this.f125266b;
        if (r102 == null) goto L6;
        r102.onCreate(r100);
        return;
    }
}
