package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ApplifecycleManager implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f38274b;

    public final WindowHelper a() {
        return (WindowHelper) this.f38274b.getValue();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    public ApplifecycleManager() {
        this.f38273a = LazyKt.lazy(ApplifecycleManager$lifecycle$2.INSTANCE);
        this.f38274b = LazyKt.lazy(ApplifecycleManager$windowHelper$2.INSTANCE);
    }
}
