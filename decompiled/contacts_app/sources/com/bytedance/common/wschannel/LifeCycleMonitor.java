package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes2.dex */
class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static WeakHandler sHandler;
    private boolean mAppAlive;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
    }

    LifeCycleMonitor() {
        this.mAppAlive = false;
        this.mRunnable = new AnonymousClass2(this);
    }

    static /* synthetic */ boolean access$000(LifeCycleMonitor r0) {
        return r0.mAppAlive;
    }

    static /* synthetic */ boolean access$002(LifeCycleMonitor r0, boolean r1) {
        r0.mAppAlive = r1;
        return r1;
    }

    static /* synthetic */ AppStateListener access$100(LifeCycleMonitor r0) {
        return r0.mListener;
    }

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (this.mAppAlive == true) goto L8;
        this.mAppAlive = true;
        AppStateListener r3 = this.mListener;
        if (r3 == null) goto L8;
        r3.onEnterToForeground();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + this.mAppAlive);
    L10:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        if (this.mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    public void setAppStateChangedListener(AppStateListener r1) {
        this.mListener = r1;
    }
}
