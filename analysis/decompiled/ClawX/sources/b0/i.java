package b0;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final j.i f829a = new j.i(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f830b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f831c;
    public static final j.j d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new m());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f830b = threadPoolExecutor;
        f831c = new Object();
        d = new j.j(0);
    }

    public static String a(int i8, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < list.size(); i9++) {
            sb.append(((e) list.get(i9)).f820g);
            sb.append("-");
            sb.append(i8);
            if (i9 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b0.h b(java.lang.String r8, android.content.Context r9, java.util.List r10, int r11) {
        /*
            j.i r0 = b0.i.f829a
            java.lang.String r1 = "getFontSync"
            x.e.k(r1)
            java.lang.Object r1 = r0.c(r8)     // Catch: java.lang.Throwable -> La0
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L18
            b0.h r8 = new b0.h     // Catch: java.lang.Throwable -> La0
            r8.<init>(r1)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.endSection()
            return r8
        L18:
            b0.j r10 = b0.d.a(r9, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L96 java.lang.Throwable -> La0
            java.lang.Object r1 = r10.f833b     // Catch: java.lang.Throwable -> La0
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> La0
            int r10 = r10.f832a     // Catch: java.lang.Throwable -> La0
            r2 = 1
            r3 = -3
            r4 = 0
            if (r10 == 0) goto L2d
            if (r10 == r2) goto L2b
        L29:
            r10 = r3
            goto L4e
        L2b:
            r10 = -2
            goto L4e
        L2d:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La0
            b0.k[] r10 = (b0.k[]) r10     // Catch: java.lang.Throwable -> La0
            if (r10 == 0) goto L4d
            int r5 = r10.length     // Catch: java.lang.Throwable -> La0
            if (r5 != 0) goto L39
            goto L4d
        L39:
            int r5 = r10.length     // Catch: java.lang.Throwable -> La0
            r6 = r4
        L3b:
            if (r6 >= r5) goto L4b
            r7 = r10[r6]     // Catch: java.lang.Throwable -> La0
            int r7 = r7.f838f     // Catch: java.lang.Throwable -> La0
            if (r7 == 0) goto L48
            if (r7 >= 0) goto L46
            goto L29
        L46:
            r10 = r7
            goto L4e
        L48:
            int r6 = r6 + 1
            goto L3b
        L4b:
            r10 = r4
            goto L4e
        L4d:
            r10 = r2
        L4e:
            if (r10 == 0) goto L59
            b0.h r8 = new b0.h     // Catch: java.lang.Throwable -> La0
            r8.<init>(r10)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.endSection()
            return r8
        L59:
            int r10 = r1.size()     // Catch: java.lang.Throwable -> La0
            if (r10 <= r2) goto L75
            x.e r10 = x.d.f6237a     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = "TypefaceCompat.createFromFontInfoWithFallback"
            x.e.k(r10)     // Catch: java.lang.Throwable -> La0
            x.e r10 = x.d.f6237a     // Catch: java.lang.Throwable -> L70
            android.graphics.Typeface r9 = r10.t(r9, r1, r11)     // Catch: java.lang.Throwable -> L70
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La0
            goto L7f
        L70:
            r8 = move-exception
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La0
            throw r8     // Catch: java.lang.Throwable -> La0
        L75:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La0
            b0.k[] r10 = (b0.k[]) r10     // Catch: java.lang.Throwable -> La0
            android.graphics.Typeface r9 = x.d.a(r9, r10, r11)     // Catch: java.lang.Throwable -> La0
        L7f:
            if (r9 == 0) goto L8d
            r0.f(r8, r9)     // Catch: java.lang.Throwable -> La0
            b0.h r8 = new b0.h     // Catch: java.lang.Throwable -> La0
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.endSection()
            return r8
        L8d:
            b0.h r8 = new b0.h     // Catch: java.lang.Throwable -> La0
            r8.<init>(r3)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.endSection()
            return r8
        L96:
            b0.h r8 = new b0.h     // Catch: java.lang.Throwable -> La0
            r9 = -1
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.endSection()
            return r8
        La0:
            r8 = move-exception
            android.os.Trace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.i.b(java.lang.String, android.content.Context, java.util.List, int):b0.h");
    }
}
