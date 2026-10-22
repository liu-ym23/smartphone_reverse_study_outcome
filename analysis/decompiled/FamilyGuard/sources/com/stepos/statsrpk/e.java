package com.stepos.statsrpk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f15953a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static Handler f15954b;

    static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 5) {
                Log.w(e.f15953a, "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                synchronized (e.class) {
                    Handler unused = e.f15954b = null;
                    try {
                        Looper.myLooper().quit();
                    } catch (NullPointerException e6) {
                        Log.w(e.f15953a, "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
                    }
                }
            }
        }
    }

    e() {
    }

    private static Handler c() {
        if (f15954b == null) {
            synchronized (e.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f15954b = new a(handlerThread.getLooper());
            }
        }
        return f15954b;
    }

    public static void d(Runnable runnable) {
        c().post(runnable);
    }
}
