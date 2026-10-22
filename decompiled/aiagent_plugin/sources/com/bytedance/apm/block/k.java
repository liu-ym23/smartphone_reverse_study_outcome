package com.bytedance.apm.block;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LooperObserverMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f4367a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f4368b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f4369c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f4370d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f4371e = null;
    public static final Thread f = null;
    public static a g = null;
    private static volatile boolean h = false;

    /* JADX INFO: compiled from: LooperObserverMonitor.java */
    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<j> mAddObservers;
        final List<j> mObservers;
        List<j> mRemoveObservers;

        public void setup(Object r1) {
        }

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void messageDispatchStarting(String r6) {
            if (this.haveAdd == false) goto L18;
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            Iterator<j> r1 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r1.hasNext() == false) goto L12;
            j r2 = (j) ZeusTransformUtils.preCheckCast(r1.next(), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            if (this.mObservers.contains(r2) == true) goto L8;
            this.mObservers.add(r2);     // Catch: Throwable -> L15
            goto L8
        L12:
            this.mAddObservers.clear();     // Catch: Throwable -> L15
            this.haveAdd = false;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            Iterator<j> r5 = this.mObservers.iterator();
        L20:
            if (r5.hasNext() == false) goto L24;
            j r3 = (j) ZeusTransformUtils.preCheckCast(r5.next(), j.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L20;
            r3.a(r6);
            goto L20
        }

        public void messageDispatched(String r5, Message r6) {
            Iterator<j> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            j r1 = (j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L4;
            r1.a(r5, r6);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<j> r7 = this.mObservers;
            monitor-enter(r7);
            Iterator<j> r8 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r8.hasNext() == false) goto L16;
            j r2 = (j) ZeusTransformUtils.preCheckCast(r8.next(), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            this.mObservers.remove(r2);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r2);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r7);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void addMessageObserver(j r3) {
            j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            if (r4 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r4) == true) goto L8;
            this.mAddObservers.add(r4);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void removeMessageObserver(j r3) {
            j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            if (r4 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r4) == true) goto L8;
            this.mRemoveObservers.add(r4);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }
    }

    static {
        f = Looper.getMainLooper().getThread();
    }

    public static synchronized boolean a(Printer r8) {
        monitor-enter(k.class);
        Printer r9 = (Printer) ZeusTransformUtils.wrapperContextForParams(r8, Printer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (h == false) goto L11;
        monitor-exit(k.class);
        return true;
    L11:
        if (Build.VERSION.SDK_INT >= 29) goto L35;
    L29:
        g = new a();     // Catch: Throwable -> L32
        f4368b = null;     // Catch: Throwable -> L32
        f4367a = true;     // Catch: Throwable -> L32
        h = true;     // Catch: Throwable -> L32
        boolean r10 = h;     // Catch: Throwable -> L32
        monitor-exit(k.class);
        return r10;
    L35:
        Object r11 = a(Looper.class, null, "sObserver");     // Catch: Throwable -> L28
        f4368b = r11;     // Catch: Throwable -> L28
        if (r11 == null) goto L16;
        f4369c = a(r11.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L28
        f4370d = a(f4368b.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L28
        f4371e = a(f4368b.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L28
    L16:
        if (f4369c != null) goto L18;
    L21:
        f4368b = null;     // Catch: Throwable -> L28
    L22:
        g = (a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.observer.ObserverWrapper", "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (f4368b == null) goto L25;
        System.out.println("LooperObserverMonitor.init: " + f4368b);     // Catch: Throwable -> L28
        g.setup(f4368b);     // Catch: Throwable -> L28
    L25:
        a(Looper.class, "setObserver", new Class[]{ZeusTransformUtils.forName("android.os.Looper$Observer", "com.obric.aiagent.plugin")}).invoke(null, new Object[]{g});     // Catch: Throwable -> L28
        h = true;     // Catch: Throwable -> L28
        boolean r12 = h;     // Catch: Throwable -> L28
        monitor-exit(k.class);
        return r12;
    L18:
        if (f4370d == null) goto L21;
        if (f4371e != null) goto L22;
    L28:
        f4368b = null;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public static void a(String r1) {
        a r0 = g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatchStarting(r1);
    }

    public static void a(String r1, Message r2) {
        a r0 = g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatched(r1, r2);
    }

    public static void a(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        a r0 = g;
        if (r0 == null) goto L6;
        r0.addMessageObserver(r3);
        return;
    }

    public static void a() {
        if (h == true) goto L5;
        return;
    L5:
        if (g == null) goto L16;
        Method r0 = a(Looper.class, "setObserver", new Class[]{ZeusTransformUtils.forName("android.os.Looper$Observer", "com.obric.aiagent.plugin")});     // Catch: Throwable -> L11
        Object r1 = f4368b;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        r0.invoke(null, new Object[]{null});     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        r0.invoke(null, new Object[]{r1});     // Catch: Throwable -> L11
    L17:
        return;
    }

    public static void b() {
        if (h == true) goto L5;
        return;
    L5:
        if (g == null) goto L12;
        a(Looper.class, "setObserver", new Class[]{ZeusTransformUtils.forName("android.os.Looper$Observer", "com.obric.aiagent.plugin")}).invoke(null, new Object[]{g});     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static void b(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        a r0 = g;
        if (r0 == null) goto L6;
        r0.removeMessageObserver(r3);
        return;
    }

    public static Method a(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private static <T> T a(Class r6, Object r7, String r8) {
        Field r9 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r8}), Field.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        r9.setAccessible(true);     // Catch: Exception -> L4
        return (T) r9.get(r7);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static List<j> c() {
        a r0 = g;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.mObservers;
    }
}
