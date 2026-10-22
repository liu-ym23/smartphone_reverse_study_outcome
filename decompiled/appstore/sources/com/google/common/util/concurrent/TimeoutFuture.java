package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    @NullableDecl
    private ListenableFuture<V> delegateRef;

    @NullableDecl
    private ScheduledFuture<?> timer;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.TimeoutFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Fire<V> implements Runnable {

        @NullableDecl
        TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> r10) {
            this.timeoutFutureRef = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            TimeoutFuture<V> r10 = this.timeoutFutureRef;
            if (r10 != null) goto L5;
            return;
        L5:
            ListenableFuture<? extends V> r11 = TimeoutFuture.access$000(r10);
            if (r11 != null) goto L8;
            return;
        L8:
            AnonymousClass1 r12 = null;
            this.timeoutFutureRef = null;
            if (r11.isDone() == false) goto L29;
            r10.setFuture(r11);
            return;
        L29:
            ScheduledFuture r13 = TimeoutFuture.access$100(r10);     // Catch: Throwable -> L23
            TimeoutFuture.access$102(r10, null);     // Catch: Throwable -> L23
            String r14 = "Timed out";
            if (r13 != null) goto L30;
        L19:
            r10.setException(new TimeoutFutureException(r14 + ": " + r11, r12));     // Catch: Throwable -> L23
            r11.cancel(true);
            return;
        L17:
            th = move-exception;
            r10.setException(new TimeoutFutureException(r14, r12));     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L23
        L30:
            long r15 = Math.abs(r13.getDelay(TimeUnit.MILLISECONDS));     // Catch: Throwable -> L17
            if (r15 <= 10) goto L19;
            r14 = "Timed out (timeout delayed by " + r15 + " ms after scheduled time)";     // Catch: Throwable -> L17
        L23:
            th = move-exception;
            r11.cancel(true);
            throw th;
        }
    }

    public static final class TimeoutFutureException extends TimeoutException {
        public /* synthetic */ TimeoutFutureException(String r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            setStackTrace(new StackTraceElement[0]);     // Catch: Throwable -> L7
            monitor-exit(this);
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        private TimeoutFutureException(String r10) {
            super(r10);
        }
    }

    private TimeoutFuture(ListenableFuture<V> r10) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ ListenableFuture access$000(TimeoutFuture r10) {
        return r10.delegateRef;
    }

    public static /* synthetic */ ScheduledFuture access$100(TimeoutFuture r10) {
        return r10.timer;
    }

    public static /* synthetic */ ScheduledFuture access$102(TimeoutFuture r10, ScheduledFuture r11) {
        r10.timer = r11;
        return r11;
    }

    public static <V> ListenableFuture<V> create(ListenableFuture<V> r10, long r11, TimeUnit r12, ScheduledExecutorService r13) {
        TimeoutFuture r14 = new TimeoutFuture(r10);
        Fire r15 = new Fire(r14);
        r14.timer = r13.schedule(r15, r11, r12);
        r10.addListener(r15, MoreExecutors.directExecutor());
        return r14;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> r10 = this.timer;
        if (r10 == null) goto L5;
        r10.cancel(false);
    L5:
        this.delegateRef = null;
        this.timer = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<V> r10 = this.delegateRef;
        ScheduledFuture<?> r11 = this.timer;
        if (r10 == null) goto L10;
        String r12 = "inputFuture=[" + r10 + "]";
        if (r11 == null) goto L12;
        long r13 = r11.getDelay(TimeUnit.MILLISECONDS);
        if (r13 > 0) goto L9;
        return r12;
    L9:
        return r12 + ", remaining delay=[" + r13 + " ms]";
    L12:
        return r12;
    L10:
        return null;
    }
}
