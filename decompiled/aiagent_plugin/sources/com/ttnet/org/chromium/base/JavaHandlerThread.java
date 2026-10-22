package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes4.dex */
public class JavaHandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37635a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f37636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Throwable f37637c;

    interface a {
        void a(long r1);

        void a(long r1, long r3);
    }

    static {
    }

    static /* synthetic */ HandlerThread a(JavaHandlerThread r0) {
        return r0.f37636b;
    }

    static /* synthetic */ Throwable a(JavaHandlerThread r0, Throwable r1) {
        r0.f37637c = r1;
        return r1;
    }

    public JavaHandlerThread(String r2, int r3) {
        this.f37636b = new HandlerThread(r2, r3);
    }

    private static JavaHandlerThread create(String r1, int r2) {
        return new JavaHandlerThread(r1, r2);
    }

    public void a() {
        if (b() == false) goto L5;
        return;
    L5:
        this.f37636b.start();
    }

    private void startAndInitialize(final long r9, final long r11) {
        a();
        new Handler(this.f37636b.getLooper()).post(new AnonymousClass1(this, r9, r11));
    }

    private void quitThreadSafely(final long r3) {
        new Handler(this.f37636b.getLooper()).post(new AnonymousClass2(this, r3));
        this.f37636b.getLooper().quitSafely();
    }

    private void joinThread() {
        boolean r0 = false;
    L3:
        if (r0 == true) goto L6;
        this.f37636b.join();     // Catch: InterruptedException -> L7
        r0 = true;
        goto L3
    }

    private boolean b() {
        if (this.f37636b.getState() == Thread.State.NEW) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAlive() {
        return this.f37636b.isAlive();
    }

    private void listenForUncaughtExceptionsForTesting() {
        this.f37636b.setUncaughtExceptionHandler(new AnonymousClass3(this));
    }

    private Throwable getUncaughtExceptionIfAny() {
        return this.f37637c;
    }
}
