package T2;

import B0.g;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static b f1872a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f1873b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f1874c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    static {
        /*
            java.lang.String r0 = "persist.stepos.usagestats.log"
            java.lang.String r1 = "false"
            java.lang.String r0 = com.stepos.statsrpk.c.u(r0, r1)     // Catch: java.lang.Exception -> L14
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
            T2.d.f1874c = r0
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r1 = "UsageStats_Logger"
            r0.<init>(r1)
            r0.start()
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r0 = r0.getLooper()
            r1.<init>(r0)
            T2.d.f1873b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T2.d.<clinit>():void");
    }

    public static void a(String str, String str2) {
        Log.d("[Cloud]Data", c(str, str2));
        f1873b.post(new c(2, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void b(String str, String str2) {
        Log.e("[Cloud]Data", c(str, str2));
        f1873b.post(new c(5, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static String c(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder("[");
        sb.append(threadCurrentThread.getName());
        sb.append("-");
        sb.append(threadCurrentThread.getId());
        sb.append("][");
        sb.append(str);
        return g.r(sb, "] ", str2);
    }

    public static void d(String str, String str2) {
        Log.i("[Cloud]Data", c(str, str2));
        f1873b.post(new c(3, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void e(String str, String str2) {
        Log.v("[Cloud]Data", c(str, str2));
        f1873b.post(new c(1, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void f(String str, String str2) {
        Log.w("[Cloud]Data", c(str, str2));
        f1873b.post(new c(4, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }
}
