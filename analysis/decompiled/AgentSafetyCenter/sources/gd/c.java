package gd;

import ad.q;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: h, reason: collision with root package name */
    public final q f4718h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4719j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g f4720k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, q qVar) {
        super(gVar);
        qVar.getClass();
        this.f4720k = gVar;
        this.f4718h = qVar;
        this.i = -1L;
        this.f4719j = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f4713f) {
            return;
        }
        if (this.f4719j) {
            byte[] bArr = bd.b.f2074a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = bd.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                this.f4720k.f4727b.j();
                d();
            }
        }
        this.f4713f = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r11.f4719j == false) goto L27;
     */
    @Override // gd.a, od.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l(od.i r12, long r13) throws java.io.IOException {
        /*
            r11 = this;
            gd.g r0 = r11.f4720k
            od.k r1 = r0.f4728c
            r12.getClass()
            r2 = 0
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 < 0) goto Lce
            boolean r4 = r11.f4713f
            if (r4 != 0) goto Lc6
            boolean r4 = r11.f4719j
            r5 = -1
            if (r4 != 0) goto L18
            goto L7a
        L18:
            long r7 = r11.i
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 == 0) goto L22
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L7b
        L22:
            java.lang.String r4 = "expected chunk size and optional extensions but was \""
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L2b
            r1.D()
        L2b:
            long r7 = r1.J()     // Catch: java.lang.NumberFormatException -> Lbb
            r11.i = r7     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r1 = r1.D()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.CharSequence r1 = hc.h.w0(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            long r7 = r11.i     // Catch: java.lang.NumberFormatException -> Lbb
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 < 0) goto L9f
            int r7 = r1.length()     // Catch: java.lang.NumberFormatException -> Lbb
            r8 = 0
            if (r7 <= 0) goto L52
            java.lang.String r7 = ";"
            boolean r7 = hc.o.U(r1, r7, r8)     // Catch: java.lang.NumberFormatException -> Lbb
            if (r7 == 0) goto L9f
        L52:
            long r9 = r11.i
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 != 0) goto L76
            r11.f4719j = r8
            b8.r r1 = r0.f4731f
            ad.n r1 = r1.a()
            r0.f4732g = r1
            ad.w r1 = r0.f4726a
            r1.getClass()
            ad.b r1 = r1.f611n
            ad.n r2 = r0.f4732g
            r2.getClass()
            ad.q r3 = r11.f4718h
            fd.e.b(r1, r3, r2)
            r11.d()
        L76:
            boolean r1 = r11.f4719j
            if (r1 != 0) goto L7b
        L7a:
            return r5
        L7b:
            long r1 = r11.i
            long r13 = java.lang.Math.min(r13, r1)
            long r12 = super.l(r12, r13)
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 == 0) goto L8f
            long r0 = r11.i
            long r0 = r0 - r12
            r11.i = r0
            return r12
        L8f:
            ed.m r12 = r0.f4727b
            r12.j()
            java.net.ProtocolException r12 = new java.net.ProtocolException
            java.lang.String r13 = "unexpected end of stream"
            r12.<init>(r13)
            r11.d()
            throw r12
        L9f:
            java.net.ProtocolException r12 = new java.net.ProtocolException     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbb
            r13.<init>(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            long r2 = r11.i     // Catch: java.lang.NumberFormatException -> Lbb
            r13.append(r2)     // Catch: java.lang.NumberFormatException -> Lbb
            r13.append(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            r11 = 34
            r13.append(r11)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r11 = r13.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            r12.<init>(r11)     // Catch: java.lang.NumberFormatException -> Lbb
            throw r12     // Catch: java.lang.NumberFormatException -> Lbb
        Lbb:
            r11 = move-exception
            java.net.ProtocolException r12 = new java.net.ProtocolException
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r11)
            throw r12
        Lc6:
            java.lang.String r11 = "closed"
            od.f.e(r11)
        Lcb:
            r11 = 0
            return r11
        Lce:
            java.lang.String r11 = "byteCount < 0: "
            java.lang.String r11 = k0.a.m(r11, r13)
            od.f.c(r11)
            goto Lcb
        */
        throw new UnsupportedOperationException("Method not decompiled: gd.c.l(od.i, long):long");
    }
}
