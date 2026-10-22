package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InProcessConfirmHost$registerDeathWatcher$watcher$1 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ InProcessConfirmHost this$0;

    public InProcessConfirmHost$registerDeathWatcher$watcher$1(InProcessConfirmHost inProcessConfirmHost) {
        this.this$0 = inProcessConfirmHost;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.g.f(activity, "activity");
        String str = this.this$0.rehostFromClass;
        if (str != null && activity.getClass().getName().equals(str)) {
            this.this$0.main.post(new androidx.room.o(10, this.this$0, activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity destroyed) {
        Activity activity;
        kotlin.jvm.internal.g.f(destroyed, "destroyed");
        WeakReference weakReference = this.this$0.hostActivityRef;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null || destroyed != activity) {
            return;
        }
        if (!destroyed.isChangingConfigurations()) {
            this.this$0.main.post(new c(this.this$0, 1));
        } else {
            this.this$0.rehostFromClass = destroyed.getClass().getName();
            this.this$0.main.post(new androidx.appcompat.app.l(12, this.this$0, destroyed));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.g.f(activity, "activity");
        kotlin.jvm.internal.g.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
    }
}
