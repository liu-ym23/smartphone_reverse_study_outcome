package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallDeliveryLifecycleGeneralCallback implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f170338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f170339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f170340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 f170341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f170342e;

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
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public MallDeliveryLifecycleGeneralCallback(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f170342e = r100;
        MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 r101 = new MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1(this);
        this.f170341d = r101;
        t93.a.b().postDelayed(r101, 10000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Integer r101 = this.f170338a;
        int r102 = r100.hashCode();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.intValue() != r102) goto L9;
        this.f170341d.run();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Integer r101 = this.f170338a;
        int r102 = r100.hashCode();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.intValue() != r102) goto L9;
        d.c(new AnonymousClass1(this, r100));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (this.f170338a != null) goto L6;
        this.f170338a = Integer.valueOf(r100.hashCode());
        return;
    }
}
