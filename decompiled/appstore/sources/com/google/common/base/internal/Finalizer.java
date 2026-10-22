package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10335a = 0;

    @NullableDecl
    private static final Constructor<Thread> bigThreadConstructor = null;

    @NullableDecl
    private static final Field inheritableThreadLocals = null;
    private static final Logger logger = null;
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        logger = Logger.getLogger(Finalizer.class.getName());
        Constructor<Thread> r10 = getBigThreadConstructor();
        bigThreadConstructor = r10;
        if (r10 != null) goto L5;
        Field r11 = getInheritableThreadLocalsField();
    L6:
        inheritableThreadLocals = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    private Finalizer(Class<?> r10, ReferenceQueue<Object> r11, PhantomReference<Object> r12) {
        this.queue = r11;
        this.finalizableReferenceClassReference = new WeakReference(r10);
        this.frqReference = r12;
    }

    private boolean cleanUp(Reference<?> r10) {
        Method r11 = getFinalizeReferentMethod();
        if (r11 != null) goto L5;
        return false;
    L5:
        r10.clear();
        if (r10 == this.frqReference) goto L7;
        r11.invoke(r10, null);     // Catch: Throwable -> L11
    L13:
        r10 = this.queue.poll();
        if (r10 != null) goto L5;
        return true;
    L11:
        th = move-exception;
        logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
        goto L13
    L7:
        return false;
    }

    @NullableDecl
    private static Constructor<Thread> getBigThreadConstructor() {
        return Thread.class.getConstructor(new Class[]{ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE});
    L4:
        return null;
    }

    @NullableDecl
    private Method getFinalizeReferentMethod() {
        Class<?> r10 = this.finalizableReferenceClassReference.get();
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.getMethod("finalizeReferent", null);
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    @NullableDecl
    private static Field getInheritableThreadLocalsField() {
        Field r10 = Thread.class.getDeclaredField("inheritableThreadLocals");     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
        return null;
    }

    public static void startFinalizer(Class<?> r10, ReferenceQueue<Object> r11, PhantomReference<Object> r12) {
        if (r10.getName().equals(FINALIZABLE_REFERENCE) == false) goto L24;
        Finalizer r13 = new Finalizer(r10, r11, r12);
        String r14 = Finalizer.class.getName();
        Constructor<Thread> r15 = bigThreadConstructor;
        if (r15 != null) goto L27;
    L11:
        Thread r16 = null;
    L12:
        if (r16 != null) goto L14;
        r16 = new Thread(null, r13, r14);
    L14:
        r16.setDaemon(true);
        Field r17 = inheritableThreadLocals;     // Catch: Throwable -> L19
        if (r17 == null) goto L21;
        r17.set(r16, null);     // Catch: Throwable -> L19
    L21:
        r16.start();
        return;
    L19:
        th = move-exception;
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th);
        goto L21
    L27:
        r16 = r15.newInstance(new Object[]{null, r13, r14, 0L, Boolean.FALSE});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
        goto L11
    L24:
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    @Override // java.lang.Runnable
    public void run() {
    L6:
        if (cleanUp(this.queue.remove()) == true) goto L6;
    }
}
