package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class DoFrameBooster {
    private static final String TAG = "doFrameBooster";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8924a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f8925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ProxyFrameHandler f8926c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f8927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f8928e;
    private static int f;
    private static int g;

    private static class ProxyFrameHandler extends Handler {
        public ProxyFrameHandler(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            DoFrameBooster.a().handleMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r5, long r6) {
            if (r5.getCallback() != DoFrameBooster.b()) goto L17;
            if (DoFrameBooster.c() == false) goto L17;
            if (DoFrameBooster.d() == 0) goto L9;
            Message r0 = i.a(i.a());
            if (r0 != null) goto L15;
            return sendMessageAtFrontOfQueue(r5);
        L15:
            return super.sendMessageAtTime(r5, Math.min(r0.getWhen() + ((long) DoFrameBooster.e()), r6));
        L9:
            return sendMessageAtFrontOfQueue(r5);
        L17:
            return super.sendMessageAtTime(r5, r6);
        }
    }

    static /* synthetic */ Handler a() {
        return f8925b;
    }

    static /* synthetic */ Object b() {
        return f8927d;
    }

    static /* synthetic */ boolean c() {
        return f8928e;
    }

    static /* synthetic */ int d() {
        return g;
    }

    static /* synthetic */ int e() {
        return f;
    }

    static {
        f8926c = new ProxyFrameHandler(Looper.getMainLooper());
        f8927d = null;
        f8928e = false;
        f = 0;
        g = 1;
    }
}
