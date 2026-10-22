package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"com/stepos/core/ota/confirmui/InProcessConfirmHost$registerDeathWatcher$watcher$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "destroyed", "LY8/t;", "onActivityDestroyed", "(Landroid/app/Activity;)V", "activity", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InProcessConfirmHost$registerDeathWatcher$watcher$1 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ InProcessConfirmHost this$0;

    public InProcessConfirmHost$registerDeathWatcher$watcher$1(InProcessConfirmHost inProcessConfirmHost) {
        this.this$0 = inProcessConfirmHost;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(final Activity activity, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(activity, "activity");
        String str = this.this$0.rehostFromClass;
        if (str != null && kotlin.jvm.internal.p.d(activity.getClass().getName(), str)) {
            Handler handler = this.this$0.main;
            final InProcessConfirmHost inProcessConfirmHost = this.this$0;
            handler.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.h
                @Override // java.lang.Runnable
                public final void run() {
                    InProcessConfirmHost.access$rehostOn(inProcessConfirmHost, activity);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity destroyed) {
        kotlin.jvm.internal.p.i(destroyed, "destroyed");
        Activity activity = this.this$0.hostActivity;
        if (activity != null && destroyed == activity) {
            if (!destroyed.isChangingConfigurations()) {
                Handler handler = this.this$0.main;
                final InProcessConfirmHost inProcessConfirmHost = this.this$0;
                handler.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        inProcessConfirmHost.dismissPending();
                    }
                });
            } else {
                this.this$0.rehostFromClass = destroyed.getClass().getName();
                Handler handler2 = this.this$0.main;
                final InProcessConfirmHost inProcessConfirmHost2 = this.this$0;
                handler2.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        InProcessConfirmHost.access$onHostRecreating(inProcessConfirmHost2, destroyed);
                    }
                });
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
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
