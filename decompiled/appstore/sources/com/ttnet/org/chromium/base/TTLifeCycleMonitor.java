package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.constant.PerfTraceConsts;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TTLifeCycleMonitor implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f18301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static TTWeakHandler f18302e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppStateListener f18304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f18305c;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();

        void onInstantEnterToBackground();

        void onInstantEnterToForeground();
    }

    public class a implements TTWeakHandler.IHandler {
        public a() {
        }

        @Override // com.ttnet.org.chromium.base.TTWeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTLifeCycleMonitor f18306a;

        public b(TTLifeCycleMonitor r10) {
            this.f18306a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTLifeCycleMonitor.a() == false) goto L8;
            TTLifeCycleMonitor.b(false);
            if (TTLifeCycleMonitor.c(this.f18306a) == null) goto L9;
            TTLifeCycleMonitor.c(this.f18306a).onEnterToBackground();
            return;
        L9:
            return;
        }
    }

    static {
        f18302e = new TTWeakHandler(Looper.getMainLooper(), new a());
    }

    public TTLifeCycleMonitor() {
        this.f18305c = new b(this);
        if (d() == null) goto L5;
        f18301d = true;
    L5:
        this.f18303a = 0;
        List r10 = e();
        if (r10 == null) goto L9;
        this.f18303a = r10.size();
        return;
    }

    public static /* synthetic */ boolean a() {
        return f18301d;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f18301d = r10;
        return r10;
    }

    public static /* synthetic */ AppStateListener c(TTLifeCycleMonitor r10) {
        return r10.f18304b;
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

    public static List e() {
        ArrayList r10 = new ArrayList();
        Class<?> r11 = Class.forName("android.app.ActivityThread");     // Catch: Exception -> L11
        Method r12 = r11.getDeclaredMethod("currentActivityThread", null);     // Catch: Exception -> L11
        r12.setAccessible(true);     // Catch: Exception -> L11
        Object r13 = r12.invoke(null, null);     // Catch: Exception -> L11
        Field r14 = r11.getDeclaredField("mActivities");     // Catch: Exception -> L11
        r14.setAccessible(true);     // Catch: Exception -> L11
        Map r15 = (Map) r14.get(r13);     // Catch: Exception -> L11
        if (r15 != null) goto L6;
        return null;
    L6:
        Iterator r16 = r15.entrySet().iterator();     // Catch: Exception -> L11
    L8:
        if (r16.hasNext() == false) goto L13;
        Object r17 = ((Map.Entry) r16.next()).getValue();     // Catch: Exception -> L11
        Field r18 = r17.getClass().getDeclaredField("activity");     // Catch: Exception -> L11
        r18.setAccessible(true);     // Catch: Exception -> L11
        r10.add((Activity) r18.get(r17));     // Catch: Exception -> L11
        goto L8
    L13:
        return r10;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void f(AppStateListener r10) {
        this.f18304b = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f18301d == false) goto L6;
        f18302e.postDelayed(this.f18305c, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f18301d == true) goto L7;
        f18301d = true;
        AppStateListener r11 = this.f18304b;
        if (r11 == null) goto L7;
        r11.onEnterToForeground();
    L7:
        f18302e.removeCallbacks(this.f18305c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        if (this.f18303a != 0) goto L7;
        AppStateListener r11 = this.f18304b;
        if (r11 == null) goto L7;
        r11.onInstantEnterToForeground();
    L7:
        this.f18303a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        int r11 = this.f18303a - 1;
        this.f18303a = r11;
        if (r11 != 0) goto L8;
        AppStateListener r12 = this.f18304b;
        if (r12 == null) goto L9;
        r12.onInstantEnterToBackground();
        return;
    L9:
        return;
    }
}
