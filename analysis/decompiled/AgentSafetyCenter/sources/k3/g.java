package k3;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p.p;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final p f7228a = new p(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f7229b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7230c;

    /* renamed from: d, reason: collision with root package name */
    public static final p0 f7231d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new j());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f7229b = threadPoolExecutor;
        f7230c = new Object();
        f7231d = new p0(0);
    }

    public static String a(int i, List list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb2.append(((c) list.get(i3)).f7219g);
            sb2.append("-");
            sb2.append(i);
            if (i3 < list.size() - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k3.f b(java.lang.String r8, android.content.Context r9, java.util.List r10, int r11) {
        /*
            p.p r0 = k3.g.f7228a
            java.lang.String r1 = "getFontSync"
            java.lang.String r1 = com.stepos.statsrpk.h.J(r1)
            android.os.Trace.beginSection(r1)
            java.lang.Object r1 = r0.b(r8)     // Catch: java.lang.Throwable -> La8
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L1c
            k3.f r8 = new k3.f     // Catch: java.lang.Throwable -> La8
            r8.<init>(r1)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.endSection()
            return r8
        L1c:
            wd.a r10 = k3.b.a(r9, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L9e java.lang.Throwable -> La8
            java.lang.Object r1 = r10.f15390g     // Catch: java.lang.Throwable -> La8
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> La8
            int r10 = r10.f15389f     // Catch: java.lang.Throwable -> La8
            r2 = 1
            r3 = -3
            r4 = 0
            if (r10 == 0) goto L31
            if (r10 == r2) goto L2f
        L2d:
            r10 = r3
            goto L52
        L2f:
            r10 = -2
            goto L52
        L31:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La8
            k3.h[] r10 = (k3.h[]) r10     // Catch: java.lang.Throwable -> La8
            if (r10 == 0) goto L51
            int r5 = r10.length     // Catch: java.lang.Throwable -> La8
            if (r5 != 0) goto L3d
            goto L51
        L3d:
            int r5 = r10.length     // Catch: java.lang.Throwable -> La8
            r6 = r4
        L3f:
            if (r6 >= r5) goto L4f
            r7 = r10[r6]     // Catch: java.lang.Throwable -> La8
            int r7 = r7.f7237f     // Catch: java.lang.Throwable -> La8
            if (r7 == 0) goto L4c
            if (r7 >= 0) goto L4a
            goto L2d
        L4a:
            r10 = r7
            goto L52
        L4c:
            int r6 = r6 + 1
            goto L3f
        L4f:
            r10 = r4
            goto L52
        L51:
            r10 = r2
        L52:
            if (r10 == 0) goto L5d
            k3.f r8 = new k3.f     // Catch: java.lang.Throwable -> La8
            r8.<init>(r10)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.endSection()
            return r8
        L5d:
            int r10 = r1.size()     // Catch: java.lang.Throwable -> La8
            if (r10 <= r2) goto L7d
            f7.f r10 = f3.d.f3906a     // Catch: java.lang.Throwable -> La8
            java.lang.String r10 = "TypefaceCompat.createFromFontInfoWithFallback"
            java.lang.String r10 = com.stepos.statsrpk.h.J(r10)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.beginSection(r10)     // Catch: java.lang.Throwable -> La8
            f7.f r10 = f3.d.f3906a     // Catch: java.lang.Throwable -> L78
            android.graphics.Typeface r9 = r10.f(r9, r1, r11)     // Catch: java.lang.Throwable -> L78
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La8
            goto L87
        L78:
            r8 = move-exception
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La8
            throw r8     // Catch: java.lang.Throwable -> La8
        L7d:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La8
            k3.h[] r10 = (k3.h[]) r10     // Catch: java.lang.Throwable -> La8
            android.graphics.Typeface r9 = f3.d.a(r9, r10, r11)     // Catch: java.lang.Throwable -> La8
        L87:
            if (r9 == 0) goto L95
            r0.c(r8, r9)     // Catch: java.lang.Throwable -> La8
            k3.f r8 = new k3.f     // Catch: java.lang.Throwable -> La8
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.endSection()
            return r8
        L95:
            k3.f r8 = new k3.f     // Catch: java.lang.Throwable -> La8
            r8.<init>(r3)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.endSection()
            return r8
        L9e:
            k3.f r8 = new k3.f     // Catch: java.lang.Throwable -> La8
            r9 = -1
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La8
            android.os.Trace.endSection()
            return r8
        La8:
            r8 = move-exception
            android.os.Trace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.g.b(java.lang.String, android.content.Context, java.util.List, int):k3.f");
    }
}
