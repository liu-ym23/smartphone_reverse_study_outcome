package com.android.ttcjpaysdk.base.paymentbasis;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activityName", "", "onAppStatusListener", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks$OnAppStatusListener;", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks$OnAppStatusListener;)V", "activityStartCount", "", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "OnAppStatusListener", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final String activityName;
    private int activityStartCount;
    private final OnAppStatusListener onAppStatusListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks$OnAppStatusListener;", "", "onForeground", "", "activity", "Landroid/app/Activity;", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnAppStatusListener {
        void onForeground(Activity r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (TextUtils.equals(r100.getClass().getName(), this.activityName) == false) goto L6;
        this.onAppStatusListener.onForeground(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.activityStartCount++;
    }

    public CJPayLifecycleCallbacks(String r100, OnAppStatusListener r101) {
        Intrinsics.checkNotNullParameter(r100, "activityName");
        Intrinsics.checkNotNullParameter(r101, "onAppStatusListener");
        this.activityName = r100;
        this.onAppStatusListener = r101;
    }
}
