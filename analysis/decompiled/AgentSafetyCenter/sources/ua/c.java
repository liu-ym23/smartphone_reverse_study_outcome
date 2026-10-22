package ua;

import android.os.Handler;
import android.util.Log;
import d1.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static f f14286a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f14287b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f14288c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    static {
        /*
            java.lang.String r0 = "persist.stepos.usagestats.log"
            java.lang.String r1 = "false"
            java.lang.String r0 = t1.e.g(r0, r1)     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L2c
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L2c
            r0 = 1
            goto L2d
        L14:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "isPrintLog error "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "CommonUtils"
            android.util.Log.e(r1, r0)
        L2c:
            r0 = 0
        L2d:
            ua.c.f14288c = r0
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r1 = "UsageStats_Logger"
            r0.<init>(r1)
            r0.start()
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r0 = r0.getLooper()
            r1.<init>(r0)
            ua.c.f14287b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.c.<clinit>():void");
    }

    public static void a(String str, String str2) {
        Log.d("[Cloud]Data", c(str, str2));
        f14287b.post(new b(2, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void b(String str, String str2) {
        Log.e("[Cloud]Data", c(str, str2));
        f14287b.post(new b(5, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static String c(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(threadCurrentThread.getName());
        sb2.append("-");
        sb2.append(threadCurrentThread.getId());
        sb2.append("][");
        sb2.append(str);
        return androidx.activity.b.n(sb2, "] ", str2);
    }

    public static void d(String str, String str2) {
        Log.i("[Cloud]Data", c(str, str2));
        f14287b.post(new b(3, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void e(String str, String str2) {
        Log.v("[Cloud]Data", c(str, str2));
        f14287b.post(new b(1, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void f(String str, String str2) {
        Log.w("[Cloud]Data", c(str, str2));
        f14287b.post(new b(4, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }
}
