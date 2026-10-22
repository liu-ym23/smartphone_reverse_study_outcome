package s0;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final p.g<String, Typeface> f11853a = new p.g<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f11854b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f11855c;

    /* renamed from: d, reason: collision with root package name */
    public static final p.o<String, ArrayList<u0.a<a>>> f11856d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new m());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f11854b = threadPoolExecutor;
        f11855c = new Object();
        f11856d = new p.o<>();
    }

    public static String a(int i10, List list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(((e) list.get(i11)).f11842g);
            sb2.append("-");
            sb2.append(i10);
            if (i11 < list.size() - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s0.j.a b(java.lang.String r8, android.content.Context r9, java.util.List<s0.e> r10, int r11) {
        /*
            p.g<java.lang.String, android.graphics.Typeface> r0 = s0.j.f11853a
            java.lang.String r1 = "getFontSync"
            java.lang.String r1 = c2.a.a(r1)
            android.os.Trace.beginSection(r1)
            java.lang.Object r1 = r0.a(r8)     // Catch: java.lang.Throwable -> La6
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L1c
            s0.j$a r8 = new s0.j$a     // Catch: java.lang.Throwable -> La6
            r8.<init>(r1)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.endSection()
            return r8
        L1c:
            s0.k r10 = s0.d.a(r9, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L9c java.lang.Throwable -> La6
            java.util.List<s0.l[]> r1 = r10.f11860b     // Catch: java.lang.Throwable -> La6
            int r10 = r10.f11859a     // Catch: java.lang.Throwable -> La6
            r2 = 1
            r3 = -3
            r4 = 0
            if (r10 == 0) goto L2f
            if (r10 == r2) goto L2d
        L2b:
            r10 = r3
            goto L50
        L2d:
            r10 = -2
            goto L50
        L2f:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La6
            s0.l[] r10 = (s0.l[]) r10     // Catch: java.lang.Throwable -> La6
            if (r10 == 0) goto L4f
            int r5 = r10.length     // Catch: java.lang.Throwable -> La6
            if (r5 != 0) goto L3b
            goto L4f
        L3b:
            int r5 = r10.length     // Catch: java.lang.Throwable -> La6
            r6 = r4
        L3d:
            if (r6 >= r5) goto L4d
            r7 = r10[r6]     // Catch: java.lang.Throwable -> La6
            int r7 = r7.f11866f     // Catch: java.lang.Throwable -> La6
            if (r7 == 0) goto L4a
            if (r7 >= 0) goto L48
            goto L2b
        L48:
            r10 = r7
            goto L50
        L4a:
            int r6 = r6 + 1
            goto L3d
        L4d:
            r10 = r4
            goto L50
        L4f:
            r10 = r2
        L50:
            if (r10 == 0) goto L5b
            s0.j$a r8 = new s0.j$a     // Catch: java.lang.Throwable -> La6
            r8.<init>(r10)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.endSection()
            return r8
        L5b:
            int r10 = r1.size()     // Catch: java.lang.Throwable -> La6
            if (r10 <= r2) goto L7b
            n0.f r10 = n0.e.f10595a     // Catch: java.lang.Throwable -> La6
            java.lang.String r10 = "TypefaceCompat.createFromFontInfoWithFallback"
            java.lang.String r10 = c2.a.a(r10)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.beginSection(r10)     // Catch: java.lang.Throwable -> La6
            n0.f r10 = n0.e.f10595a     // Catch: java.lang.Throwable -> L76
            android.graphics.Typeface r9 = r10.a(r9, r1, r11)     // Catch: java.lang.Throwable -> L76
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La6
            goto L85
        L76:
            r8 = move-exception
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> La6
            throw r8     // Catch: java.lang.Throwable -> La6
        L7b:
            java.lang.Object r10 = r1.get(r4)     // Catch: java.lang.Throwable -> La6
            s0.l[] r10 = (s0.l[]) r10     // Catch: java.lang.Throwable -> La6
            android.graphics.Typeface r9 = n0.e.a(r9, r10, r11)     // Catch: java.lang.Throwable -> La6
        L85:
            if (r9 == 0) goto L93
            r0.b(r8, r9)     // Catch: java.lang.Throwable -> La6
            s0.j$a r8 = new s0.j$a     // Catch: java.lang.Throwable -> La6
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.endSection()
            return r8
        L93:
            s0.j$a r8 = new s0.j$a     // Catch: java.lang.Throwable -> La6
            r8.<init>(r3)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.endSection()
            return r8
        L9c:
            s0.j$a r8 = new s0.j$a     // Catch: java.lang.Throwable -> La6
            r9 = -1
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La6
            android.os.Trace.endSection()
            return r8
        La6:
            r8 = move-exception
            android.os.Trace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.j.b(java.lang.String, android.content.Context, java.util.List, int):s0.j$a");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f11857a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11858b;

        public a(int i10) {
            this.f11857a = null;
            this.f11858b = i10;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f11857a = typeface;
            this.f11858b = 0;
        }
    }
}
