package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.internal.Finalizer;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public class FinalizableReferenceQueue implements Closeable {
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Logger logger = null;
    private static final Method startFinalizer = null;
    final PhantomReference<Object> frqRef;
    final ReferenceQueue<Object> queue;
    final boolean threadStarted;

    public static class DecoupledLoader implements FinalizerLoader {
        private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        public DecoupledLoader() {
        }

        public URL getBaseUrl() throws IOException {
            String r10 = FinalizableReferenceQueue.FINALIZER_CLASS_NAME.replace('.', '/') + ".class";
            URL r11 = getClass().getClassLoader().getResource(r10);
            if (r11 == null) goto L11;
            String r12 = r11.toString();
            if (r12.endsWith(r10) == false) goto L9;
            return new URL(r11, r12.substring(0, r12.length() - r10.length()));
        L9:
            throw new IOException("Unsupported path style: " + r12);
        L11:
            throw new FileNotFoundException(r10);
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            return newLoader(getBaseUrl()).loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
        L4:
            e = move-exception;
            FinalizableReferenceQueue.access$000().log(Level.WARNING, LOADING_ERROR, e);
            return null;
        }

        public URLClassLoader newLoader(URL r10) {
            return new URLClassLoader(new URL[]{r10}, null);
        }
    }

    public static class DirectLoader implements FinalizerLoader {
        public DirectLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class<?> loadFinalizer() {
            int r10 = Finalizer.f10335a;     // Catch: ClassNotFoundException -> L4
            return Finalizer.class;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public interface FinalizerLoader {
        @NullableDecl
        Class<?> loadFinalizer();
    }

    public static class SystemLoader implements FinalizerLoader {

        @VisibleForTesting
        static boolean disabled;

        public SystemLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            if (disabled == false) goto L13;
            return null;
        L13:
            ClassLoader r10 = ClassLoader.getSystemClassLoader();     // Catch: SecurityException -> L10
            if (r10 != null) goto L15;
        L9:
            return null;
        L15:
            return r10.loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
        L10:
            FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
            return null;
        }
    }

    static {
        logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
        startFinalizer = getStartFinalizer(loadFinalizer(new FinalizerLoader[]{new SystemLoader(), new DecoupledLoader(), new DirectLoader()}));
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> r10 = new ReferenceQueue();
        this.queue = r10;
        PhantomReference<Object> r11 = new PhantomReference(this, r10);
        this.frqRef = r11;
        startFinalizer.invoke(null, new Object[]{FinalizableReference.class, r10, r11});     // Catch: Throwable -> L5 IllegalAccessException -> L7
        boolean r12 = true;
    L10:
        this.threadStarted = r12;
        return;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    L5:
        th = move-exception;
        logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        r12 = false;
        goto L10
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    public static Method getStartFinalizer(Class<?> r10) {
        return r10.getMethod("startFinalizer", new Class[]{Class.class, ReferenceQueue.class, PhantomReference.class});
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    private static Class<?> loadFinalizer(FinalizerLoader... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Class<?> r13 = r10[r12].loadFinalizer();
        if (r13 != null) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void cleanUp() {
        if (this.threadStarted == false) goto L5;
        return;
    L5:
        Reference<? extends Object> r10 = this.queue.poll();
        if (r10 == 0) goto L12;
        r10.clear();
        ((FinalizableReference) r10).finalizeReferent();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
        goto L5
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frqRef.enqueue();
        cleanUp();
    }
}
