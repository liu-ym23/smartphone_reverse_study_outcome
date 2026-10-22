package l4;

import java.io.IOException;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final k6.a f3836a;

    /* renamed from: b, reason: collision with root package name */
    public static final k6.a f3837b;

    static {
        byte[] bArrX0 = x.e.x0("\r\n", x5.a.f6276a);
        f3836a = new k6.a(bArrX0, 0, bArrX0.length);
        f3837b = new k6.a(new byte[]{45, 45});
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ac, code lost:
    
        if (((io.ktor.utils.io.m) r3).g(r6) != r7) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(k6.a r27, io.ktor.utils.io.n0 r28, io.ktor.utils.io.m r29, l4.d r30, long r31, h5.c r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.m.a(k6.a, io.ktor.utils.io.n0, io.ktor.utils.io.m, l4.d, long, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.utils.io.n0 r9, h5.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof l4.k
            if (r0 == 0) goto L13
            r0 = r10
            l4.k r0 = (l4.k) r0
            int r1 = r0.f3832c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3832c = r1
            goto L18
        L13:
            l4.k r0 = new l4.k
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f3831b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3832c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            m4.c r9 = r0.f3830a
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L2a
            goto L55
        L2a:
            r10 = move-exception
            goto L68
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            a.a.c0(r10)
            m4.c r10 = new m4.c
            r10.<init>()
            r0.f3830a = r10     // Catch: java.lang.Throwable -> L66
            r0.f3832c = r4     // Catch: java.lang.Throwable -> L66
            java.util.Set r2 = l4.g.f3814a     // Catch: java.lang.Throwable -> L66
            e0.j r2 = new e0.j     // Catch: java.lang.Throwable -> L66
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L66
            r2.f2311b = r3     // Catch: java.lang.Throwable -> L66
            r2.f2312c = r3     // Catch: java.lang.Throwable -> L66
            java.lang.Object r9 = l4.g.c(r9, r10, r2, r0)     // Catch: java.lang.Throwable -> L66
            if (r9 != r1) goto L52
            return r1
        L52:
            r8 = r10
            r10 = r9
            r9 = r8
        L55:
            l4.d r10 = (l4.d) r10     // Catch: java.lang.Throwable -> L2a
            if (r10 == 0) goto L5a
            return r10
        L5a:
            java.io.EOFException r10 = new java.io.EOFException     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = "Failed to parse multipart headers: unexpected end of stream"
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L2a
            throw r10     // Catch: java.lang.Throwable -> L2a
        L62:
            r8 = r10
            r10 = r9
            r9 = r8
            goto L68
        L66:
            r9 = move-exception
            goto L62
        L68:
            a5.e r0 = r9.f3900a
            java.util.ArrayList r1 = r9.f3901b
            r2 = 0
            if (r1 == 0) goto L82
            r9.f3902c = r2
            int r5 = r1.size()
            r6 = r3
        L76:
            if (r6 >= r5) goto L8b
            java.lang.Object r7 = r1.get(r6)
            r0.y(r7)
            int r6 = r6 + 1
            goto L76
        L82:
            char[] r1 = r9.f3902c
            if (r1 == 0) goto L89
            r0.y(r1)
        L89:
            r9.f3902c = r2
        L8b:
            r9.f3903e = r4
            r9.f3901b = r2
            r9.d = r2
            r9.f3905g = r3
            r9.f3904f = r3
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.m.b(io.ktor.utils.io.n0, h5.c):java.lang.Object");
    }

    public static final void c(w wVar, byte[] bArr, byte b9) throws IOException {
        int i8 = wVar.f3684a;
        if (i8 >= bArr.length) {
            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
        }
        wVar.f3684a = i8 + 1;
        bArr[i8] = b9;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(io.ktor.utils.io.p r4, k6.a r5, h5.c r6) {
        /*
            boolean r0 = r6 instanceof l4.l
            if (r0 == 0) goto L13
            r0 = r6
            l4.l r0 = (l4.l) r0
            int r1 = r0.f3835c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3835c = r1
            goto L18
        L13:
            l4.l r0 = new l4.l
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3834b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3835c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            k6.a r5 = r0.f3833a
            a.a.c0(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r6)
            r0.f3833a = r5
            r0.f3835c = r3
            java.lang.Object r6 = io.ktor.utils.io.h0.r(r4, r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L4c
            byte[] r4 = r5.f3656a
            int r4 = r4.length
            long r4 = (long) r4
            goto L4e
        L4c:
            r4 = 0
        L4e:
            java.lang.Long r6 = new java.lang.Long
            r6.<init>(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.m.d(io.ktor.utils.io.p, k6.a, h5.c):java.lang.Object");
    }
}
