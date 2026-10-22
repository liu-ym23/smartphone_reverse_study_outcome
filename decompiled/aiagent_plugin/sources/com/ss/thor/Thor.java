package com.ss.thor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class Thor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f37578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThorHandler f37579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f37580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f37581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AtomicInteger f37582e;

    private static class ThorHandler extends Handler {
        public ThorHandler(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            if (Thor.b() != null) goto L5;
            return;
        L5:
            int r0 = r7.what;
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(r7.obj, Context.class, "com.obric.aiagent.plugin");
            if (r0 != 1) goto L8;
            Thor.b().a(b.b(r8), -1.0f, -1);     // Catch: Exception -> L23
        L24:
            goto L21
        L8:
            if (r0 != 2) goto L10;
            Thor.b().a(-1.0f, b.a(r8), -1);     // Catch: Exception -> L23
            goto L24
        L10:
            if (r0 != 3) goto L12;
            Thor.b().a(-1.0f, -1.0f, b.c(r8));     // Catch: Exception -> L23
            goto L24
        L12:
            if (r0 != 4) goto L14;
            Thor.b().a(b.b(r8), b.a(r8), -1);     // Catch: Exception -> L23
            goto L24
        L14:
            if (r0 != 5) goto L21;
            Thor.b().a(b.b(r8), b.a(r8), b.c(r8));     // Catch: Exception -> L23
        L21:
            sendMessageDelayed(obtainMessage(r0, r8), Thor.c());
        }
    }

    static /* synthetic */ a b() {
        return f37580c;
    }

    static /* synthetic */ int c() {
        return f37581d;
    }

    public static void a() {
        HandlerThread r0 = f37578a;
        if (r0 == null) goto L6;
        r0.quit();
        f37580c.a();
        f37578a = null;
        f37579b = null;
        f37580c = null;
        return;
    }

    static {
        f37582e = new AtomicInteger(0);
    }
}
