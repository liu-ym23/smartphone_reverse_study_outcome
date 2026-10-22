package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR = null;
    private final Deque<Closeable> stack;
    final Suppressor suppressor;
    private Throwable thrown;

    static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = null;

        LoggingSuppressor() {
        }

        static {
            INSTANCE = new LoggingSuppressor();
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable r3, Throwable r4, Throwable r5) {
            Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + r3, r5);
        }
    }

    static final class SuppressingSuppressor implements Suppressor {
        static final SuppressingSuppressor INSTANCE = null;
        static final Method addSuppressed = null;

        SuppressingSuppressor() {
        }

        static {
            INSTANCE = new SuppressingSuppressor();
            addSuppressed = getAddSuppressed();
        }

        static boolean isAvailable() {
            if (addSuppressed == null) goto L5;
            return true;
        L5:
            return false;
        }

        private static Method getAddSuppressed() {
            return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
        L4:
            return null;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable r3, Throwable r4, Throwable r5) {
            if (r4 != r5) goto L8;
            return;
        L8:
            addSuppressed.invoke(r4, new Object[]{r5});     // Catch: Throwable -> L6
            return;
        L6:
            LoggingSuppressor.INSTANCE.suppress(r3, r4, r5);
        }
    }

    interface Suppressor {
        void suppress(Closeable r1, Throwable r2, Throwable r3);
    }

    static {
        if (SuppressingSuppressor.isAvailable() == false) goto L5;
        Suppressor r0 = SuppressingSuppressor.INSTANCE;
    L6:
        SUPPRESSOR = r0;
        return;
    L5:
        r0 = LoggingSuppressor.INSTANCE;
        goto L6
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    Closer(Suppressor r3) {
        this.stack = new ArrayDeque(4);
        this.suppressor = (Suppressor) Preconditions.checkNotNull(r3);
    }

    public <C extends Closeable> C register(@Nullable C r1) {
        if (r1 == null) goto L4;
        this.stack.addFirst(r1);
    L4:
        return r1;
    }

    public RuntimeException rethrow(Throwable r1) throws IOException {
        Preconditions.checkNotNull(r1);
        this.thrown = r1;
        Throwables.propagateIfPossible(r1, IOException.class);
        throw new RuntimeException(r1);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable r1, Class<X> r2) throws IOException, Exception {
        Preconditions.checkNotNull(r1);
        this.thrown = r1;
        Throwables.propagateIfPossible(r1, IOException.class);
        Throwables.propagateIfPossible(r1, r2);
        throw new RuntimeException(r1);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable r1, Class<X1> r2, Class<X2> r3) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(r1);
        this.thrown = r1;
        Throwables.propagateIfPossible(r1, IOException.class);
        Throwables.propagateIfPossible(r1, r2, r3);
        throw new RuntimeException(r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable r0 = this.thrown;
    L4:
        if (this.stack.isEmpty() == true) goto L13;
        Closeable r1 = this.stack.removeFirst();
        r1.close();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r0 == null) goto L10;
        this.suppressor.suppress(r1, r0, th);
        goto L4
    L10:
        r0 = th;
        goto L4
    L13:
        if (this.thrown != null) goto L18;
        if (r0 == null) goto L28;
        Throwables.propagateIfPossible(r0, IOException.class);
        throw new AssertionError(r0);
    L28:
        return;
    }
}
