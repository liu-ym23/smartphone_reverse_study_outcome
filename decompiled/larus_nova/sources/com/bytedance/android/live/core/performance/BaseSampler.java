package com.bytedance.android.live.core.performance;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseSampler<T> implements LifecycleObserver, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f65103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f65104c;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Handler r100 = this.f65103b;
        if (r100 == null) goto L6;
        r100.removeCallbacks(this);
        this.f65103b = null;
        return;
    }

    public BaseSampler() {
        this.f65104c = new ArrayList();
        this.f65102a = 300;
    }

    static {
    }
}
