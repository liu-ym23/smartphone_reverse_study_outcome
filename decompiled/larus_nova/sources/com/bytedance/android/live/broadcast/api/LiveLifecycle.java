package com.bytedance.android.live.broadcast.api;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Deprecated(message = "这个判断退后台的方法问题太多，使用HostAppMonitorService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/LiveLifecycle;", "Landroid/content/BroadcastReceiver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifecycle extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f58967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f58969c;

    public static final class a {
    }

    static {
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
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bundle");
    }

    public LiveLifecycle() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = this.f58968b;
        if (r101 <= 0) goto L5;
        this.f58968b = r101 - 1;
    L5:
        Intrinsics.checkNotNull(null);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f58968b++;
        if (this.f58969c == false) goto L6;
        this.f58969c = false;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f58967a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = this.f58967a;
        if (r101 <= 0) goto L6;
        this.f58967a = r101 - 1;
    L6:
        if (this.f58968b <= 0) goto L9;
        return;
    L9:
        if (this.f58967a == 0) goto L11;
        return;
    L11:
        if (this.f58969c == true) goto L16;
        IHostApp r102 = (IHostApp) k.f(IHostApp.class);
        if (r102 == null) goto L16;
        r102.getCurrentActivity();
    L16:
        this.f58969c = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r101, "intent");
        if (puc.a.isOppoDevice() == false) goto L5;
        return;
    L5:
        if (puc.a.isVivoDevice() == true) goto L19;
        String r102 = r101.getAction();
        if (r102 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r102, "android.intent.action.CLOSE_SYSTEM_DIALOGS") == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual("homekey", r101.getStringExtra("reason")) == false) goto L18;
        boolean r103 = this.f58969c;
        this.f58969c = true;
        return;
    L18:
        return;
    }
}
