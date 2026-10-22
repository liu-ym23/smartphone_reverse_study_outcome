package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0006\u0010\u0016\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingViewAppLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activity", "Landroid/app/Activity;", "floatingView", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView;)V", "getActivity", "()Landroid/app/Activity;", "getFloatingView", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "release", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloatingViewAppLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Activity activity;
    private final FloatingView floatingView;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public final void release() {
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final FloatingView getFloatingView() {
        return this.floatingView;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Intrinsics.areEqual(r100, this.activity) == false) goto L6;
        this.floatingView.onHide();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Intrinsics.areEqual(r100, this.activity) == false) goto L6;
        this.floatingView.onShow();
        return;
    }

    public FloatingViewAppLifecycleCallbacks(Activity r100, FloatingView r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "floatingView");
        this.activity = r100;
        this.floatingView = r101;
    }
}
