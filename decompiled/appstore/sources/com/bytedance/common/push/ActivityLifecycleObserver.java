package com.bytedance.common.push;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Message;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifecycleObserver extends Observable implements Application.ActivityLifecycleCallbacks, WeakHandler.IHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ActivityLifecycleObserver f6824g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f6825h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f6826i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f6827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f6829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppStateListener f6830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakHandler f6831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f6832f;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityLifecycleObserver f6833a;

        public a(ActivityLifecycleObserver r10) {
            this.f6833a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityLifecycleObserver.a(this.f6833a) == false) goto L8;
            ActivityLifecycleObserver.b(this.f6833a, false);
            Logger.d("ActivityLifecycleObserver", "sAppAlive = false");
            if (ActivityLifecycleObserver.c(this.f6833a) == null) goto L9;
            ActivityLifecycleObserver.c(this.f6833a).onEnterToBackground();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public ActivityLifecycleObserver() {
        this.f6829c = new a(this);
        this.f6831e = new WeakHandler(this);
        this.f6832f = new ArrayList();
    }

    public static /* synthetic */ boolean a(ActivityLifecycleObserver r10) {
        return r10.f6828b;
    }

    public static /* synthetic */ boolean b(ActivityLifecycleObserver r10, boolean r11) {
        r10.f6828b = r11;
        return r11;
    }

    public static /* synthetic */ AppStateListener c(ActivityLifecycleObserver r10) {
        return r10.f6830d;
    }

    public static synchronized ActivityLifecycleObserver e() {
        monitor-enter(ActivityLifecycleObserver.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f6824g != null) goto L9;
        f6824g = new ActivityLifecycleObserver();     // Catch: Throwable -> L7
    L9:
        ActivityLifecycleObserver r10 = f6824g;     // Catch: Throwable -> L7
        monitor-exit(ActivityLifecycleObserver.class);
        return r10;
    }

    public final Object[] d() {
        List r10 = this.f6832f;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f6832f.size() <= 0) goto L9;
        Object[] r11 = this.f6832f.toArray();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L9:
        r11 = null;
        goto L10
    }

    public boolean f() {
        return this.f6828b;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10.what == 1) goto L6;
        return;
    L6:
        if (f6826i == false) goto L9;
        setChanged();
        notifyObservers(Boolean.valueOf(f6826i));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
        Object[] r12 = d();
        if (r12 == null) goto L7;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        ((Application.ActivityLifecycleCallbacks) r12[r14]).onActivityCreated(r10, r11);
        r14 = r14 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
        Object[] r11 = d();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityDestroyed(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (this.f6828b == false) goto L5;
        this.f6831e.postDelayed(this.f6829c, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
    L5:
        Object[] r11 = d();
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L12;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityPaused(r10);
        r13 = r13 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        this.f6827a = new WeakReference(r10);
        if (this.f6828b == true) goto L7;
        this.f6828b = true;
        Logger.d("ActivityLifecycleObserver", "onResume sAppAlive = true");
        AppStateListener r11 = this.f6830d;
        if (r11 == null) goto L7;
        r11.onEnterToForeground();
    L7:
        this.f6831e.removeCallbacks(this.f6829c);
        Object[] r12 = d();
        if (r12 == null) goto L12;
        int r13 = r12.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L14;
        ((Application.ActivityLifecycleCallbacks) r12[r14]).onActivityResumed(r10);
        r14 = r14 + 1;
        goto L10
    L14:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Object[] r12 = d();
        if (r12 == null) goto L7;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        ((Application.ActivityLifecycleCallbacks) r12[r14]).onActivitySaveInstanceState(r10, r11);
        r14 = r14 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        Object[] r11 = d();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityStarted(r10);
        r13 = r13 + 1;
    L7:
        this.f6831e.removeMessages(1);
        int r14 = f6825h;
        if (r14 != 0) goto L10;
        f6826i = false;
    L10:
        f6825h = r14 + 1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        Object[] r11 = d();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        ((Application.ActivityLifecycleCallbacks) r11[r13]).onActivityStopped(r10);
        r13 = r13 + 1;
    L7:
        int r14 = f6825h - 1;
        f6825h = r14;
        if (r14 != 0) goto L12;
        f6826i = true;
        this.f6831e.sendEmptyMessageDelayed(1, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        return;
    }
}
