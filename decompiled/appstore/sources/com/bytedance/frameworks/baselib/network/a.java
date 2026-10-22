package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakHandler f7131c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f7132a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.a$a, reason: collision with other inner class name */
    public static class C0091a implements WeakHandler.IHandler {
        public C0091a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f7134b;

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.a$b$a, reason: collision with other inner class name */
        public class RunnableC0092a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f7135a;

            public RunnableC0092a(b r10) {
                this.f7135a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.a() == false) goto L6;
                a.b(false);
                this.f7135a.c();
                return;
            }
        }

        public b(int r10) {
            this.f7133a = 30000;
            this.f7134b = new RunnableC0092a(this);
            this.f7133a = r10;
        }

        public Runnable a() {
            return this.f7134b;
        }

        public int b() {
            return this.f7133a;
        }

        public abstract void c();

        public abstract void d();

        public void e(int r10) {
            this.f7133a = r10;
        }
    }

    static {
        f7131c = new WeakHandler(Looper.getMainLooper(), new C0091a());
    }

    public a() {
        this.f7132a = new CopyOnWriteArrayList();
        if (d() == null) goto L6;
        f7130b = true;
        return;
    }

    public static /* synthetic */ boolean a() {
        return f7130b;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f7130b = r10;
        return r10;
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

    public void c(b r10) {
        this.f7132a.add(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f7130b == false) goto L8;
        Iterator r11 = this.f7132a.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        b r12 = (b) r11.next();
        f7131c.postDelayed(r12.a(), r12.b());
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f7130b == true) goto L8;
        f7130b = true;
        Iterator r11 = this.f7132a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((b) r11.next()).d();
    L8:
        f7131c.removeCallbacksAndMessages(null);
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
