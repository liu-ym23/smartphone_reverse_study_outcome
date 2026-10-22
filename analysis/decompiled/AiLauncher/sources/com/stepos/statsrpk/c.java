package com.stepos.statsrpk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f31036a = "d";

    /* renamed from: b, reason: collision with root package name */
    public static Handler f31037b;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 5) {
                Log.w(c.f31036a, "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                synchronized (c.class) {
                    Handler unused = c.f31037b = null;
                    try {
                        Looper.myLooper().quit();
                    } catch (NullPointerException e10) {
                        Log.w(c.f31036a, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
                    }
                }
            }
        }
    }

    public static Handler c() {
        if (f31037b == null) {
            synchronized (c.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f31037b = new a(handlerThread.getLooper());
            }
        }
        return f31037b;
    }

    public static void d(Runnable runnable) {
        c().post(runnable);
    }
}
