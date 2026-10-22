package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR = null;
    private final Deque<Closeable> stack;

    @VisibleForTesting
    final Suppressor suppressor;

    @MonotonicNonNullDecl
    private Throwable thrown;

    @VisibleForTesting
    public static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = null;

        static {
            INSTANCE = new LoggingSuppressor();
        }

        public LoggingSuppressor() {
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable r10, Throwable r11, Throwable r12) {
            Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + r10, r12);
        }
    }

    @VisibleForTesting
    public static final class SuppressingSuppressor implements Suppressor {
        static final SuppressingSuppressor INSTANCE = null;
        static final Method addSuppressed = null;

        static {
            INSTANCE = new SuppressingSuppressor();
            addSuppressed = getAddSuppressed();
        }

        public SuppressingSuppressor() {
        }

        private static Method getAddSuppressed() {
            return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
        L5:
            return null;
        }

        public static boolean isAvailable() {
            if (addSuppressed == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable r10, Throwable r11, Throwable r12) {
            if (r11 != r12) goto L8;
            return;
        L8:
            addSuppressed.invoke(r11, new Object[]{r12});     // Catch: Throwable -> L6
            return;
        L6:
            LoggingSuppressor.INSTANCE.suppress(r10, r11, r12);
        }
    }

    @VisibleForTesting
    public interface Suppressor {
        void suppress(Closeable r10, Throwable r11, Throwable r12);
    }

    static {
        if (SuppressingSuppressor.isAvailable() == false) goto L5;
        Suppressor r10 = SuppressingSuppressor.INSTANCE;
    L6:
        SUPPRESSOR = r10;
        return;
    L5:
        r10 = LoggingSuppressor.INSTANCE;
        goto L6
    }

    @VisibleForTesting
    public Closer(Suppressor r10) {
        this.stack = new ArrayDeque(4);
        this.suppressor = (Suppressor) Preconditions.checkNotNull(r10);
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable r10 = this.thrown;
    L4:
        if (this.stack.isEmpty() == true) goto L13;
        Closeable r11 = this.stack.removeFirst();
        r11.close();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r10 == null) goto L10;
        this.suppressor.suppress(r11, r10, th);
        goto L4
    L10:
        r10 = th;
        goto L4
    L13:
        if (this.thrown != null) goto L18;
        if (r10 == null) goto L28;
        Throwables.propagateIfPossible(r10, IOException.class);
        throw new AssertionError(r10);
    L28:
        return;
    }

    @CanIgnoreReturnValue
    public <C extends Closeable> C register(@NullableDecl C r10) {
        if (r10 == null) goto L4;
        this.stack.addFirst(r10);
    L4:
        return r10;
    }

    public RuntimeException rethrow(Throwable r10) throws IOException {
        Preconditions.checkNotNull(r10);
        this.thrown = r10;
        Throwables.propagateIfPossible(r10, IOException.class);
        throw new RuntimeException(r10);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable r10, Class<X> r11) throws IOException, Exception {
        Preconditions.checkNotNull(r10);
        this.thrown = r10;
        Throwables.propagateIfPossible(r10, IOException.class);
        Throwables.propagateIfPossible(r10, r11);
        throw new RuntimeException(r10);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable r10, Class<X1> r11, Class<X2> r12) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(r10);
        this.thrown = r10;
        Throwables.propagateIfPossible(r10, IOException.class);
        Throwables.propagateIfPossible(r10, r11, r12);
        throw new RuntimeException(r10);
    }
}
