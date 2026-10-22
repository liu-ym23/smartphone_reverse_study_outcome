package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6866c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakHandler f6867d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppStateListener f6868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f6869b;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    public static class a implements WeakHandler.IHandler {
        public a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifeCycleMonitor f6870a;

        public b(LifeCycleMonitor r10) {
            this.f6870a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug() == false) goto L6;
            Logger.d("WsChannelSdk", "sRunnable AppAlive = " + LifeCycleMonitor.a());
        L6:
            if (LifeCycleMonitor.a() == false) goto L11;
            LifeCycleMonitor.b(false);
            if (LifeCycleMonitor.c(this.f6870a) == null) goto L12;
            LifeCycleMonitor.c(this.f6870a).onEnterToBackground();
            return;
        L12:
            return;
        }
    }

    static {
        f6867d = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public LifeCycleMonitor() {
        this.f6869b = new b(this);
    }

    public static /* synthetic */ boolean a() {
        return f6866c;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f6866c = r10;
        return r10;
    }

    public static /* synthetic */ AppStateListener c(LifeCycleMonitor r10) {
        return r10.f6868a;
    }

    public void d(AppStateListener r10) {
        this.f6868a = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f6866c == false) goto L6;
        f6867d.postDelayed(this.f6869b, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f6866c == true) goto L8;
        f6866c = true;
        AppStateListener r11 = this.f6868a;
        if (r11 == null) goto L8;
        r11.onEnterToForeground();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + f6866c);
    L10:
        f6867d.removeCallbacks(this.f6869b);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
    }
}
