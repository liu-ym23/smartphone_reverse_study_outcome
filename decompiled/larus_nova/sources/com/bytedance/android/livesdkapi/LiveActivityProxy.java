package com.bytedance.android.livesdkapi;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public class LiveActivityProxy implements LifecycleObserver {
    private static WeakReference<FragmentActivity> topActivity;
    protected FragmentActivity mActivity;

    public void onActivityResult(int r100, int r101, Intent r102) {
    }

    public boolean onBackPressed() {
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    public void onResume() {
    }

    public static boolean isLiveSdkForeground() {
        WeakReference<FragmentActivity> r100 = topActivity;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.get() == null) goto L7;
        return true;
    }

    public Intent getIntent() {
        FragmentActivity r100 = this.mActivity;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getIntent();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        FragmentActivity r100 = this.mActivity;
        if (r100 == null) goto L6;
        r100.getLifecycle().removeObserver(this);
        this.mActivity = null;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        topActivity = new WeakReference(this.mActivity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        WeakReference<FragmentActivity> r100 = topActivity;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() != this.mActivity) goto L9;
        topActivity = null;
        return;
    }

    public LiveActivityProxy(FragmentActivity r100) {
        this.mActivity = r100;
        r100.getLifecycle().addObserver(this);
    }
}
