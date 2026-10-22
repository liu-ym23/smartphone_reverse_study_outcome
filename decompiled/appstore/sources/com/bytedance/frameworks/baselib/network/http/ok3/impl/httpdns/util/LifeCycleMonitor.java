package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f7414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakHandler f7415d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppStateListener f7416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f7417b;

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
        public final /* synthetic */ LifeCycleMonitor f7418a;

        public b(LifeCycleMonitor r10) {
            this.f7418a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LifeCycleMonitor.a() == false) goto L8;
            LifeCycleMonitor.b(false);
            if (LifeCycleMonitor.c(this.f7418a) == null) goto L9;
            LifeCycleMonitor.c(this.f7418a).onEnterToBackground();
            return;
        L9:
            return;
        }
    }

    static {
        f7415d = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public LifeCycleMonitor() {
        this.f7417b = new b(this);
        if (d() == null) goto L6;
        f7414c = true;
        return;
    }

    public static /* synthetic */ boolean a() {
        return f7414c;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f7414c = r10;
        return r10;
    }

    public static /* synthetic */ AppStateListener c(LifeCycleMonitor r10) {
        return r10.f7416a;
    }

    public static Activity d() {
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L13
        Object r11 = r10.getMethod("currentActivityThread", null).invoke(null, null);     // Catch: Throwable -> L13
        Field r12 = r10.getDeclaredField("mActivities");     // Catch: Throwable -> L13
        r12.setAccessible(true);     // Catch: Throwable -> L13
        Map r13 = (Map) r12.get(r11);     // Catch: Throwable -> L13
        if (r13 != null) goto L6;
        return null;
    L6:
        Iterator r14 = r13.values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r14.hasNext() == false) goto L15;
        Object r15 = r14.next();     // Catch: Throwable -> L13
        Class<?> r16 = r15.getClass();     // Catch: Throwable -> L13
        Field r17 = r16.getDeclaredField("paused");     // Catch: Throwable -> L13
        r17.setAccessible(true);     // Catch: Throwable -> L13
        if (r17.getBoolean(r15) == true) goto L8;
        Field r18 = r16.getDeclaredField("activity");     // Catch: Throwable -> L13
        r18.setAccessible(true);     // Catch: Throwable -> L13
        return (Activity) r18.get(r15);
    L15:
        return null;
    L13:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void e(AppStateListener r10) {
        this.f7416a = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f7414c == false) goto L6;
        f7415d.postDelayed(this.f7417b, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f7414c == true) goto L7;
        f7414c = true;
        AppStateListener r11 = this.f7416a;
        if (r11 == null) goto L7;
        r11.onEnterToForeground();
    L7:
        f7415d.removeCallbacks(this.f7417b);
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
