package com.stepos.statsrpk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static a f8074a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 5) {
                Log.w("d", "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                synchronized (d.class) {
                    d.f8074a = null;
                    try {
                        Looper.myLooper().quit();
                    } catch (NullPointerException e10) {
                        Log.w("d", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
                    }
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        if (f8074a == null) {
            synchronized (d.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f8074a = new a(handlerThread.getLooper());
            }
        }
        f8074a.post(runnable);
    }
}
