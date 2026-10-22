package com.bytedance.android.gamecp.business.download;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/AppLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppLifecycleObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f52305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f52306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52309e;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f52307c = true;
        yr.c.a("gamecp_InstallChainReporter", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.f52306b = true;
        this.f52309e = false;
        yr.c.a("gamecp_InstallChainReporter", "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.f52308d == false) goto L6;
        yr.c.a("gamecp_InstallChainReporter", "isFirst，设置监听时回调先忽略");
        this.f52308d = false;
        return;
    L6:
        this.f52305a = true;
        this.f52309e = true;
        yr.c.a("gamecp_InstallChainReporter", "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        yr.c.a("gamecp_InstallChainReporter", "onStop");
    }

    public AppLifecycleObserver() {
        this.f52308d = true;
        this.f52309e = true;
    }
}
