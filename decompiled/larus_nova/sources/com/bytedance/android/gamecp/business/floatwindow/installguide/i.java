package com.bytedance.android.gamecp.business.floatwindow.installguide;

import android.app.Activity;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements dw.d {
    public i() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // dw.d
    public final void appEnterBackground(boolean r100, boolean r101) {
        if (r101 == true) goto L8;
        if (r100 == true) goto L8;
        yr.c.b("InstallGuideFloatWindowManager", "onDesktopToForeground");
        ss.b r102 = ss.i.a();
        if (r102 == null) goto L8;
        r102.a();
    L8:
        if (r101 == true) goto L12;
        if (r100 == false) goto L13;
        yr.c.b("InstallGuideFloatWindowManager", "onForegroundToDesktop");
        return;
    L13:
        return;
    }
}
