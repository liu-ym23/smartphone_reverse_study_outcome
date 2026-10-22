package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class SystemThread {
    private Thread mAndroidThread;
    private long mNativeThread;

    private static native void nativeRun(long r0);

    static /* synthetic */ long access$000(SystemThread r2) {
        return r2.mNativeThread;
    }

    static /* synthetic */ void access$100(long r0) {
        nativeRun(r0);
    }

    private SystemThread(long r1, String r3, int r4) {
        this.mNativeThread = r1;
        createAndroidThread(r3, r4);
    }

    private void createAndroidThread(String r3, int r4) {
        Thread r0 = new Thread(new AnonymousClass1(this), r3);
        this.mAndroidThread = r0;
        r0.setPriority(r4);
        this.mAndroidThread.start();
    }

    public static SystemThread create(long r1, String r3, int r4) {
        return new SystemThread(r1, r3, r4);
    }

    public static void attachMainThread(final long r2) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        nativeRun(r2);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new AnonymousClass2(r2));
    }

    public void stop() {
        Looper r0 = Looper.myLooper();
        if (Thread.currentThread() != this.mAndroidThread) goto L7;
        if (r0 == null) goto L8;
        r0.quit();
        return;
    L8:
        return;
    }

    public void join() {
        this.mAndroidThread.join();     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
