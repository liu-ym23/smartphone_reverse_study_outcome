package com.bytedance.applet.task;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.applet.view.AppletActivity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Application.ActivityLifecycleCallbacks {
    public q() {
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
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((r100 instanceof AppletActivity) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((AppletActivity) r100).getAppId(), "com.flow.locallife") == false) goto L9;
        FLogger.f375446a.i("NavigationControlTask", "onActivityResumed: appId = com.flow.locallife");
        p.a(false);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((r100 instanceof AppletActivity) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((AppletActivity) r100).getAppId(), "com.flow.locallife") == false) goto L9;
        FLogger.f375446a.i("NavigationControlTask", "onActivityStopped: appId = com.flow.locallife");
        p.a(true);
        return;
    }
}
