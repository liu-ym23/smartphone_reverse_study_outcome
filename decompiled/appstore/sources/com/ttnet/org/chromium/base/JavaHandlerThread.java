package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class JavaHandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f18261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f18262b;

    public interface Natives {
        void initializeThread(long r10, long r11);

        void onLooperStopped(long r10);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f18263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f18265c;

        public a(JavaHandlerThread r10, long r11, long r12) {
            this.f18265c = r10;
            this.f18263a = r11;
            this.f18264b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b().initializeThread(this.f18263a, this.f18264b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f18266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f18267b;

        public b(JavaHandlerThread r10, long r11) {
            this.f18267b = r10;
            this.f18266a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.a(this.f18267b).quit();
            h.b().onLooperStopped(this.f18266a);
        }
    }

    public class c implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f18268a;

        public c(JavaHandlerThread r10) {
            this.f18268a = r10;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread r10, Throwable r11) {
            JavaHandlerThread.b(this.f18268a, r11);
        }
    }

    static {
    }

    public JavaHandlerThread(String r10, int r11) {
        this.f18261a = new HandlerThread(r10, r11);
    }

    public static /* synthetic */ HandlerThread a(JavaHandlerThread r10) {
        return r10.f18261a;
    }

    public static /* synthetic */ Throwable b(JavaHandlerThread r10, Throwable r11) {
        r10.f18262b = r11;
        return r11;
    }

    @CalledByNative
    private static JavaHandlerThread create(String r10, int r11) {
        return new JavaHandlerThread(r10, r11);
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.f18262b;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.f18261a.isAlive();
    }

    @CalledByNative
    private void joinThread() {
        boolean r10 = false;
    L3:
        if (r10 == true) goto L6;
        this.f18261a.join();     // Catch: InterruptedException -> L7
        r10 = true;
        goto L3
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.f18261a.setUncaughtExceptionHandler(new c(this));
    }

    @CalledByNative
    private void quitThreadSafely(long r10) {
        new Handler(this.f18261a.getLooper()).post(new b(this, r10));
        this.f18261a.getLooper().quitSafely();
    }

    @CalledByNative
    private void startAndInitialize(long r10, long r11) {
        d();
        new Handler(this.f18261a.getLooper()).post(new a(this, r10, r11));
    }

    public final boolean c() {
        if (this.f18261a.getState() == Thread.State.NEW) goto L5;
        return true;
    L5:
        return false;
    }

    public void d() {
        if (c() == false) goto L5;
        return;
    L5:
        this.f18261a.start();
    }
}
