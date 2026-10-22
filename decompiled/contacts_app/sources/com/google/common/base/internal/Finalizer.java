package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    private static final Field inheritableThreadLocals = null;
    private static final Logger logger = null;
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        logger = Logger.getLogger(Finalizer.class.getName());
        inheritableThreadLocals = getInheritableThreadLocalsField();
    }

    public static void startFinalizer(Class<?> r2, ReferenceQueue<Object> r3, PhantomReference<Object> r4) {
        if (r2.getName().equals(FINALIZABLE_REFERENCE) == false) goto L14;
        Thread r5 = new Thread(new Finalizer(r2, r3, r4));
        r5.setName(Finalizer.class.getName());
        r5.setDaemon(true);
        Field r6 = inheritableThreadLocals;     // Catch: Throwable -> L9
        if (r6 == null) goto L11;
        r6.set(r5, null);     // Catch: Throwable -> L9
    L11:
        r5.start();
        return;
    L9:
        th = move-exception;
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th);
        goto L11
    L14:
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    private Finalizer(Class<?> r1, ReferenceQueue<Object> r2, PhantomReference<Object> r3) {
        this.queue = r2;
        this.finalizableReferenceClassReference = new WeakReference(r1);
        this.frqReference = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
    L6:
        if (cleanUp(this.queue.remove()) == true) goto L6;
    }

    private boolean cleanUp(Reference<?> r6) {
        Method r0 = getFinalizeReferentMethod();
        if (r0 != null) goto L5;
        return false;
    L5:
        r6.clear();
        if (r6 == this.frqReference) goto L7;
        r0.invoke(r6, new Object[0]);     // Catch: Throwable -> L10
    L12:
        r6 = this.queue.poll();
        if (r6 != null) goto L5;
        return true;
    L10:
        th = move-exception;
        logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
        goto L12
    L7:
        return false;
    }

    private Method getFinalizeReferentMethod() {
        Class<?> r2 = this.finalizableReferenceClassReference.get();
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getMethod("finalizeReferent", new Class[0]);
    L8:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static Field getInheritableThreadLocalsField() {
        Field r0 = Thread.class.getDeclaredField("inheritableThreadLocals");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
        return null;
    }
}
