package x3;

import c5.n;
import java.util.List;
import k4.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f6268a;

    static {
        w wVar = w.f3637b;
        f6268a = n.k0(w.f3637b, w.d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        if (x.f.A(r8, r9, org.tukaani.xz.common.Util.VLI_MAX, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(n4.e r8, java.io.OutputStream r9, f5.h r10, h5.c r11) {
        /*
            boolean r0 = r11 instanceof x3.e
            if (r0 == 0) goto L13
            r0 = r11
            x3.e r0 = (x3.e) r0
            int r1 = r0.f6267c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6267c = r1
            goto L18
        L13:
            x3.e r0 = new x3.e
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f6266b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f6267c
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L2a
            if (r2 == r3) goto L2a
            r8 = 3
            if (r2 != r8) goto L32
        L2a:
            java.io.OutputStream r9 = r0.f6265a
            a.a.c0(r11)     // Catch: java.lang.Throwable -> L30
            goto L87
        L30:
            r8 = move-exception
            goto L93
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            a.a.c0(r11)
            boolean r11 = r8 instanceof n4.c     // Catch: java.lang.Throwable -> L30
            if (r11 == 0) goto L4b
            n4.c r8 = (n4.c) r8     // Catch: java.lang.Throwable -> L30
            byte[] r8 = r8.d()     // Catch: java.lang.Throwable -> L30
            r9.write(r8)     // Catch: java.lang.Throwable -> L30
            goto L87
        L4b:
            boolean r11 = r8 instanceof z3.i     // Catch: java.lang.Throwable -> L30
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r11 == 0) goto L65
            z3.i r8 = (z3.i) r8     // Catch: java.lang.Throwable -> L30
            io.ktor.utils.io.p r8 = r8.d()     // Catch: java.lang.Throwable -> L30
            r0.f6265a = r9     // Catch: java.lang.Throwable -> L30
            r0.f6267c = r4     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = x.f.A(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L87
            goto L82
        L65:
            boolean r11 = r8 instanceof n4.d     // Catch: java.lang.Throwable -> L30
            if (r11 == 0) goto L83
            a6.c1 r11 = a6.c1.f144a     // Catch: java.lang.Throwable -> L30
            c4.c r2 = new c4.c     // Catch: java.lang.Throwable -> L30
            r4 = 9
            r2.<init>(r8, r4, r5)     // Catch: java.lang.Throwable -> L30
            io.ktor.utils.io.q0 r8 = io.ktor.utils.io.h0.v(r11, r10, r2, r3)     // Catch: java.lang.Throwable -> L30
            io.ktor.utils.io.m r8 = r8.f3233a     // Catch: java.lang.Throwable -> L30
            r0.f6265a = r9     // Catch: java.lang.Throwable -> L30
            r0.f6267c = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = x.f.A(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L87
        L82:
            return r1
        L83:
            boolean r8 = r8 instanceof i4.b     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L8d
        L87:
            k4.z.h(r9, r5)
            b5.a0 r8 = b5.a0.f883a
            return r8
        L8d:
            a6.w r8 = new a6.w     // Catch: java.lang.Throwable -> L30
            r8.<init>()     // Catch: java.lang.Throwable -> L30
            throw r8     // Catch: java.lang.Throwable -> L30
        L93:
            throw r8     // Catch: java.lang.Throwable -> L94
        L94:
            r10 = move-exception
            k4.z.h(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.f.a(n4.e, java.io.OutputStream, f5.h, h5.c):java.lang.Object");
    }
}
