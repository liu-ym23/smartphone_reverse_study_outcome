package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class x7 extends r7 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static x7 f28337e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z8 f28338d;

    public static class a extends Handler {
        public a() {
        }

        private a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;     // Catch: Throwable -> L11
            if (r101 != 0) goto L5;
            ((c8) r100.obj).getClass();     // Catch: Throwable -> L11
            throw null;     // Catch: Throwable -> L11
        L5:
            if (r101 == 1) goto L7;
            return;
        L7:
            ((c8) r100.obj).getClass();     // Catch: Throwable -> L11
            throw null;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.printStackTrace();
        }

        public /* synthetic */ a(Looper r100, byte r101) {
            this(r100);
        }
    }

    public static x7 b() {
        return a(true);
    }

    private x7(boolean r100) {
        if (r100 == false) goto L6;
        this.f28338d = z8.a(new y8.a().a("amap-netmanger-threadpool-%d").a());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        t6.a(th, "NetManger", "NetManger1");
        th.printStackTrace();
        return;
    L6:
        if (Looper.myLooper() != null) goto L9;
        new a(Looper.getMainLooper(), 0);     // Catch: Throwable -> L11
        return;
    L9:
        new a();     // Catch: Throwable -> L11
    }

    private static synchronized x7 a(boolean r100) {
        monitor-enter(x7.class);
        x7 r101 = f28337e;     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
        f28337e = new x7(r100);     // Catch: Throwable -> L12
    L22:
    L14:
        x7 r102 = f28337e;     // Catch: Throwable -> L17
        monitor-exit(x7.class);
        return r102;
    L7:
        if (r100 == false) goto L22;
        if (r101.f28338d != null) goto L22;
        r101.f28338d = z8.a(new y8.a().a("amap-netmanger-threadpool-%d").a());     // Catch: Throwable -> L12
    L17:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L14
    }

    public static x7 b(boolean r100) {
        return a(r100);
    }

    public z7 e(y7 r100) throws k5 {
        boolean r101 = r100.isHttps();
        d(r100);
        if (r101 == false) goto L5;
        y7.c r102 = y7.c.f28468b;
    L6:
        r100.setHttpProtocol(r102);
        z7 r103 = null;
        long r104 = 0;
        if (c(r100) == false) goto L21;
        boolean r105 = b(r100);
        r104 = SystemClock.elapsedRealtime();     // Catch: k5 -> L11
        r103 = c(r100, b(r100, r105), c(r100, r105));     // Catch: k5 -> L11
    L11:
        e = move-exception;
        if (e.c() == 21) goto L15;
    L18:
        if (r105 == false) goto L20;
        boolean r106 = true;
    L22:
        if (r103 == null) goto L33;
        byte[] r107 = r103.f28591a;
        if (r107 == null) goto L33;
        if (r107.length <= 0) goto L33;
        return r103;
    L33:
        return c(r100, a(r100, r106), a(r100, r104));
    L29:
        e = move-exception;
        throw e;
    L20:
        throw e;
    L15:
        if (r100.getDegradeAbility() != y7.a.f28453b) goto L18;
        throw e;
    L21:
        r106 = false;
        goto L22
    L5:
        r102 = y7.c.f28467a;
        goto L6
    }

    public Map<String, String> d(y7 r100, boolean r101) throws k5 {
        d(r100);
        if (r101 == false) goto L5;
        y7.c r102 = y7.c.f28468b;
    L6:
        r100.setHttpProtocol(r102);
        Map<String, String> r103 = null;
        long r104 = 0;
        if (c(r100) == false) goto L15;
        boolean r105 = b(r100);
        r104 = SystemClock.elapsedRealtime();     // Catch: k5 -> L11
        r103 = b(r100, b(r100, r105), c(r100, r105));     // Catch: k5 -> L11
    L11:
        e = move-exception;
        if (r105 == false) goto L14;
        boolean r106 = true;
    L16:
        if (r103 == null) goto L22;
        return r103;
    L22:
        return b(r100, a(r100, r106), a(r100, r104));
    L19:
        e = move-exception;
        throw e;
    L14:
        throw e;
    L15:
        r106 = false;
        goto L16
    L5:
        r102 = y7.c.f28467a;
        goto L6
    }

    private Map<String, String> b(y7 r100, y7.b r101, int r102) throws k5 {
        d(r100);     // Catch: Throwable -> L4 k5 -> L7
        r100.setDegradeType(r101);     // Catch: Throwable -> L4 k5 -> L7
        r100.setReal_max_timeout(r102);     // Catch: Throwable -> L4 k5 -> L7
        return new v7().a(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new k5("未知的错误");
    }

    private z7 c(y7 r100, y7.b r101, int r102) throws k5 {
        d(r100);     // Catch: Throwable -> L4 k5 -> L7
        r100.setDegradeType(r101);     // Catch: Throwable -> L4 k5 -> L7
        r100.setReal_max_timeout(r102);     // Catch: Throwable -> L4 k5 -> L7
        return new v7().b(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new k5("未知的错误");
    }
}
