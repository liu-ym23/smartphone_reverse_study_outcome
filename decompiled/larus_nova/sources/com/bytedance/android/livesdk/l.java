package com.bytedance.android.livesdk;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements IHostAppMonitorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HostAppMonitorService f146983a;

    public l(HostAppMonitorService r100) {
        this.f146983a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f146983a.f102947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r101.next()).onActivityDestroyed(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f146983a.f102947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r101.next()).onActivityPaused(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f146983a.f102947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r101.next()).onActivityResumed(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f146983a.f102947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r101.next()).onActivityStarted(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f146983a.f102947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r101.next()).onActivityStopped(r100);
        goto L4
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
    public final void appEnterBackground(boolean r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f146983a.getClass();
    L4:
        this.f146983a.getClass();
        Iterator<T> r102 = this.f146983a.f102947a.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((IHostAppMonitorListener) r102.next()).appEnterBackground(r100, r101);
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r102 = this.f146983a.f102947a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r102.next()).onActivityCreated(r100, r101);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
        Iterator<T> r102 = this.f146983a.f102947a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IHostAppMonitorListener) r102.next()).onActivitySaveInstanceState(r100, r101);
        goto L4
    }
}
