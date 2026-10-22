package com.bytedance.apm.block;

import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.bytedance.observer.ObserverWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6401a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f6402b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f6403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f6404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f6405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f6406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Thread f6407g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f6408h;

    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<ILooperObserver> mAddObservers;
        final List<ILooperObserver> mObservers;
        List<ILooperObserver> mRemoveObservers;

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(ILooperObserver r10) {
            List<ILooperObserver> r11 = this.mObservers;
            monitor-enter(r11);
            if (r10 != null) goto L14;
        L10:
            monitor-exit(r11);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (this.mAddObservers.contains(r10) == true) goto L10;
            this.mAddObservers.add(r10);     // Catch: Throwable -> L8
            this.haveAdd = true;     // Catch: Throwable -> L8
            goto L10
        }

        public void messageDispatchStarting(String r10) {
            if (this.haveAdd == false) goto L19;
            List<ILooperObserver> r11 = this.mObservers;
            monitor-enter(r11);
            Iterator<ILooperObserver> r12 = this.mAddObservers.iterator();     // Catch: Throwable -> L12
        L8:
            if (r12.hasNext() == false) goto L14;
            ILooperObserver r13 = r12.next();     // Catch: Throwable -> L12
            if (this.mObservers.contains(r13) == true) goto L8;
            this.mObservers.add(r13);     // Catch: Throwable -> L12
            goto L8
        L14:
            this.mAddObservers.clear();     // Catch: Throwable -> L12
            this.haveAdd = false;     // Catch: Throwable -> L12
            monitor-exit(r11);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L19:
            Iterator<ILooperObserver> r14 = this.mObservers.iterator();
        L21:
            if (r14.hasNext() == false) goto L25;
            ILooperObserver r15 = r14.next();
            if (r15 == null) goto L21;
            r15.messageDispatchStarting(r10);
            goto L21
        }

        public void messageDispatched(String r10, Message r11) {
            Iterator<ILooperObserver> r12 = this.mObservers.iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            ILooperObserver r13 = r12.next();
            if (r13 == null) goto L4;
            r13.messageDispatched(r10, r11);
            goto L4
        L9:
            if (this.haveRemove == false) goto L23;
            List<ILooperObserver> r14 = this.mObservers;
            monitor-enter(r14);
            Iterator<ILooperObserver> r15 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L16
        L14:
            if (r15.hasNext() == false) goto L18;
            ILooperObserver r16 = r15.next();     // Catch: Throwable -> L16
            this.mObservers.remove(r16);     // Catch: Throwable -> L16
            this.mAddObservers.remove(r16);     // Catch: Throwable -> L16
            goto L14
        L18:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L16
            this.haveRemove = false;     // Catch: Throwable -> L16
            monitor-exit(r14);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void removeMessageObserver(ILooperObserver r10) {
            List<ILooperObserver> r11 = this.mObservers;
            monitor-enter(r11);
            if (r10 != null) goto L14;
        L10:
            monitor-exit(r11);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (this.mRemoveObservers.contains(r10) == true) goto L10;
            this.mRemoveObservers.add(r10);     // Catch: Throwable -> L8
            this.haveRemove = true;     // Catch: Throwable -> L8
            goto L10
        }

        public void setup(Object r10) {
        }
    }

    static {
        f6407g = Looper.getMainLooper().getThread();
    }

    public static void a(ILooperObserver r10) {
        a r11 = f6408h;
        if (r11 == null) goto L6;
        r11.addMessageObserver(r10);
        return;
    }

    public static void b() {
        if (f6401a == true) goto L5;
        return;
    L5:
        if (f6408h == null) goto L12;
        g(Looper.class, "setObserver", new Class[]{Looper.Observer.class}).invoke(null, new Object[]{f6408h});     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static List c() {
        a r10 = f6408h;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.mObservers;
    }

    public static synchronized boolean d(Printer r10) {
        monitor-enter(i.class);
    L29:
        th = move-exception;
        throw th;
    L6:
        if (f6401a == false) goto L32;
        monitor-exit(i.class);
        return true;
    L32:
        Object r11 = h(Looper.class, null, "sObserver");     // Catch: Throwable -> L26
        f6403c = r11;     // Catch: Throwable -> L26
        if (r11 == null) goto L14;
        f6404d = g(r11.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L26
        f6405e = g(f6403c.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L26
        f6406f = g(f6403c.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L26
    L14:
        if (f6404d != null) goto L16;
    L19:
        f6403c = null;     // Catch: Throwable -> L26
    L20:
        int r12 = ObserverWrapper.f7860a;     // Catch: Throwable -> L26
        f6408h = (a) ObserverWrapper.class.getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L26
        if (f6403c == null) goto L23;
        System.out.println("LooperObserverMonitor.init: " + f6403c);     // Catch: Throwable -> L26
        f6408h.setup(f6403c);     // Catch: Throwable -> L26
    L23:
        g(Looper.class, "setObserver", new Class[]{Looper.Observer.class}).invoke(null, new Object[]{f6408h});     // Catch: Throwable -> L26
        f6401a = true;     // Catch: Throwable -> L26
        boolean r13 = f6401a;     // Catch: Throwable -> L26
        monitor-exit(i.class);
        return r13;
    L16:
        if (f6405e == null) goto L19;
        if (f6406f != null) goto L20;
    L26:
        f6403c = null;     // Catch: Throwable -> L29
        f6408h = new a();     // Catch: Throwable -> L29
        f6403c = null;     // Catch: Throwable -> L29
        f6402b = true;     // Catch: Throwable -> L29
        f6401a = true;     // Catch: Throwable -> L29
        return f6401a;
    }

    public static void e(String r10) {
        a r11 = f6408h;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.messageDispatchStarting(r10);
    }

    public static void f(String r10, Message r11) {
        a r12 = f6408h;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.messageDispatched(r10, r11);
    }

    public static Method g(Class r10, String r11, Class... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    public static Object h(Class r10, Object r11, String r12) {
        Field r13 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10, new Object[]{r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13.get(r11);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void i(ILooperObserver r10) {
        a r11 = f6408h;
        if (r11 == null) goto L6;
        r11.removeMessageObserver(r10);
        return;
    }

    public static void j() {
        if (f6401a == true) goto L5;
        return;
    L5:
        if (f6408h == null) goto L16;
        Method r10 = g(Looper.class, "setObserver", new Class[]{Looper.Observer.class});     // Catch: Throwable -> L11
        Object r11 = f6403c;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        r10.invoke(null, new Object[]{null});     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        r10.invoke(null, new Object[]{r11});     // Catch: Throwable -> L11
    L17:
        return;
    }
}
