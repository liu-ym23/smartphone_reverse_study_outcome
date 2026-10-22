package com.bytedance.apm.block;

import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class LooperObserverMonitor {
    public static final char END = '<';
    public static final char START = '>';
    public static Method dispatchingThrewException = null;
    private static volatile boolean isInited = false;
    public static volatile boolean isUsePrinter = false;
    public static Method messageDispatchStarting = null;
    public static Method messageDispatched = null;
    public static final String sEnd = "<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee";
    public static final Thread sMainThread = null;
    public static BaseObserver sObserverWrapper = null;
    public static Object sOriginObserver = null;
    public static final String sStart = ">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0";

    public static class BaseObserver {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<ILooperObserver> mAddObservers;
        final List<ILooperObserver> mObservers;
        List<ILooperObserver> mRemoveObservers;

        protected void setup(Object r1) {
        }

        public BaseObserver() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        protected void messageDispatchStarting(String r5) {
            if (this.haveAdd == false) goto L18;
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            Iterator<ILooperObserver> r1 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r1.hasNext() == false) goto L12;
            ILooperObserver r2 = r1.next();     // Catch: Throwable -> L15
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
            Iterator<ILooperObserver> r4 = this.mObservers.iterator();
        L20:
            if (r4.hasNext() == false) goto L24;
            ILooperObserver r3 = r4.next();
            if (r3 == null) goto L20;
            r3.messageDispatchStarting(r5);
            goto L20
        }

        public void messageDispatched(String r3, Message r4) {
            Iterator<ILooperObserver> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ILooperObserver r1 = r0.next();
            if (r1 == null) goto L4;
            r1.messageDispatched(r3, r4);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<ILooperObserver> r5 = this.mObservers;
            monitor-enter(r5);
            Iterator<ILooperObserver> r6 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r6.hasNext() == false) goto L16;
            ILooperObserver r2 = r6.next();     // Catch: Throwable -> L19
            this.mObservers.remove(r2);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r2);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void addMessageObserver(ILooperObserver r3) {
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r3) == true) goto L8;
            this.mAddObservers.add(r3);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void removeMessageObserver(ILooperObserver r3) {
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r3) == true) goto L8;
            this.mRemoveObservers.add(r3);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }
    }

    static {
        sMainThread = Looper.getMainLooper().getThread();
    }

    private LooperObserverMonitor() {
    }

    public static synchronized boolean init(Printer r9) {
        monitor-enter(LooperObserverMonitor.class);
    L29:
        th = move-exception;
        throw th;
    L6:
        if (isInited == false) goto L32;
        monitor-exit(LooperObserverMonitor.class);
        return true;
    L32:
        Object r3 = reflectHideObject(Looper.class, null, "sObserver");     // Catch: Throwable -> L26
        sOriginObserver = r3;     // Catch: Throwable -> L26
        if (r3 == null) goto L14;
        messageDispatchStarting = reflectHideMethod(r3.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L26
        messageDispatched = reflectHideMethod(sOriginObserver.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L26
        dispatchingThrewException = reflectHideMethod(sOriginObserver.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L26
    L14:
        if (messageDispatchStarting != null) goto L16;
    L19:
        sOriginObserver = null;     // Catch: Throwable -> L26
    L20:
        sObserverWrapper = (BaseObserver) Class.forName("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L26
        if (sOriginObserver == null) goto L23;
        System.out.println("LooperObserverMonitor.init: " + sOriginObserver);     // Catch: Throwable -> L26
        sObserverWrapper.setup(sOriginObserver);     // Catch: Throwable -> L26
    L23:
        reflectHideMethod(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{sObserverWrapper});     // Catch: Throwable -> L26
        isInited = true;     // Catch: Throwable -> L26
        boolean r10 = isInited;     // Catch: Throwable -> L26
        monitor-exit(LooperObserverMonitor.class);
        return r10;
    L16:
        if (messageDispatched == null) goto L19;
        if (dispatchingThrewException != null) goto L20;
    L26:
        sOriginObserver = null;     // Catch: Throwable -> L29
        sObserverWrapper = new BaseObserver();     // Catch: Throwable -> L29
        sOriginObserver = null;     // Catch: Throwable -> L29
        isUsePrinter = true;     // Catch: Throwable -> L29
        isInited = true;     // Catch: Throwable -> L29
        return isInited;
    }

    public static void messageDispatchStarting(String r1) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatchStarting(r1);
    }

    public static void messageDispatched(String r1, Message r2) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatched(r1, r2);
    }

    public static void addMessageObserver(ILooperObserver r1) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 == null) goto L6;
        r0.addMessageObserver(r1);
        return;
    }

    public static void removeMessageObserverWrapper() {
        if (isInited == true) goto L5;
        return;
    L5:
        if (sObserverWrapper == null) goto L16;
        Method r0 = reflectHideMethod(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")});     // Catch: Throwable -> L11
        Object r1 = sOriginObserver;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        r0.invoke(null, new Object[]{null});     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        r0.invoke(null, new Object[]{r1});     // Catch: Throwable -> L11
    L17:
        return;
    }

    public static void addMessageObserverWrapper() {
        if (isInited == true) goto L5;
        return;
    L5:
        if (sObserverWrapper == null) goto L12;
        reflectHideMethod(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{sObserverWrapper});     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static void removeMessageObserver(ILooperObserver r1) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 == null) goto L6;
        r0.removeMessageObserver(r1);
        return;
    }

    public static Method reflectHideMethod(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private static <T> T reflectHideObject(Class r6, Object r7, String r8) {
        Field r9 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r8});     // Catch: Exception -> L4
        r9.setAccessible(true);     // Catch: Exception -> L4
        return (T) r9.get(r7);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static List<ILooperObserver> getObservers() {
        BaseObserver r0 = sObserverWrapper;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.mObservers;
    }
}
