package com.android.server.timezonedetector.location;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class HandlerThreadingDomain extends ThreadingDomain {
    private final Handler mHandler;

    /* JADX INFO: renamed from: $r8$lambda$RNWujQtOBdem2p3TK6tQfd-x4_E, reason: not valid java name */
    public static /* synthetic */ void m8600$r8$lambda$RNWujQtOBdem2p3TK6tQfdx4_E(AtomicReference r0, Callable r1, AtomicReference r2, CountDownLatch r3) {
        lambda$postAndWait$0(r0, r1, r2, r3);
    }

    HandlerThreadingDomain(Handler handler) {
        handler.getClass();
        this.mHandler = handler;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    Thread getThread() {
        return getHandler().getLooper().getThread();
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    void post(Runnable r) {
        getHandler().post(r);
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    <V> V postAndWait(final Callable<V> callable, long durationMillis) throws Exception {
        assertNotCurrentThread();
        final AtomicReference<V> resultReference = new AtomicReference();
        final AtomicReference<Exception> exceptionReference = new AtomicReference();
        final CountDownLatch latch = new CountDownLatch(1);
        post(new HandlerThreadingDomain$$ExternalSyntheticLambda0(resultReference, callable, exceptionReference, latch));
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (latch.await(durationMillis, TimeUnit.MILLISECONDS) == false) goto L12;
        if (exceptionReference.get() != null) goto L10;
        return resultReference.get();
    L10:
        throw exceptionReference.get();
    L12:
        throw new RuntimeException("Timed out");     // Catch: InterruptedException -> L13
    }

    private static /* synthetic */ void lambda$postAndWait$0(AtomicReference resultReference, Callable callable, AtomicReference exceptionReference, CountDownLatch latch) {
        resultReference.set(callable.call());     // Catch: Throwable -> L4 Exception -> L6
    L3:
        latch.countDown();
        return;
    L6:
        e = move-exception;
        exceptionReference.set(e);     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        latch.countDown();
        throw th;
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    void postDelayed(Runnable r, long delayMillis) {
        getHandler().postDelayed(r, delayMillis);
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    void postDelayed(Runnable r, Object token, long delayMillis) {
        getHandler().postDelayed(r, token, delayMillis);
    }

    @Override // com.android.server.timezonedetector.location.ThreadingDomain
    void removeQueuedRunnables(Object token) {
        getHandler().removeCallbacksAndMessages(token);
    }
}
