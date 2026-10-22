package L9;

import F9.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class d extends b {
    public final y d;
    public long e;
    public boolean f;
    public final /* synthetic */ A8.a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(A8.a aVar, y url) {
        super(aVar);
        k.f(url, "url");
        this.g = aVar;
        this.d = url;
        this.e = -1L;
        this.f = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zT;
        if (this.b) {
            return;
        }
        if (this.f) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = G9.b.f704a;
            k.f(timeUnit, "timeUnit");
            try {
                zT = G9.b.t(this, 100);
            } catch (IOException unused) {
                zT = false;
            }
            if (!zT) {
                ((okhttp3.internal.connection.a) this.g.d).k();
                b();
            }
        }
        this.b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r9.f == false) goto L25;
     */
    @Override // L9.b, V9.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long e(V9.g r10, long r11) throws java.io.IOException {
        /*
            r9 = this;
            A8.a r11 = r9.g
            java.lang.Object r12 = r11.e
            V9.i r12 = (V9.i) r12
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.k.f(r10, r0)
            boolean r0 = r9.b
            if (r0 != 0) goto Ld0
            boolean r0 = r9.f
            r1 = -1
            if (r0 != 0) goto L16
            goto L80
        L16:
            long r3 = r9.e
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L22
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L81
        L22:
            java.lang.String r0 = "expected chunk size and optional extensions but was \""
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L2b
            r12.q()
        L2b:
            long r3 = r12.C()     // Catch: java.lang.NumberFormatException -> Lc5
            r9.e = r3     // Catch: java.lang.NumberFormatException -> Lc5
            java.lang.String r12 = r12.q()     // Catch: java.lang.NumberFormatException -> Lc5
            java.lang.CharSequence r12 = j9.m.R0(r12)     // Catch: java.lang.NumberFormatException -> Lc5
            java.lang.String r12 = r12.toString()     // Catch: java.lang.NumberFormatException -> Lc5
            long r3 = r9.e     // Catch: java.lang.NumberFormatException -> Lc5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto La9
            int r3 = r12.length()     // Catch: java.lang.NumberFormatException -> Lc5
            r4 = 0
            if (r3 <= 0) goto L52
            java.lang.String r3 = ";"
            boolean r3 = j9.t.e0(r12, r3, r4)     // Catch: java.lang.NumberFormatException -> Lc5
            if (r3 == 0) goto La9
        L52:
            long r7 = r9.e
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 != 0) goto L7c
            r9.f = r4
            java.lang.Object r12 = r11.g
            L9.a r12 = (L9.a) r12
            F9.w r12 = r12.f()
            r11.h = r12
            java.lang.Object r12 = r11.c
            F9.F r12 = (F9.F) r12
            kotlin.jvm.internal.k.c(r12)
            F9.o r12 = r12.f617j
            java.lang.Object r0 = r11.h
            F9.w r0 = (F9.w) r0
            kotlin.jvm.internal.k.c(r0)
            F9.y r3 = r9.d
            K9.f.b(r12, r3, r0)
            r9.b()
        L7c:
            boolean r12 = r9.f
            if (r12 != 0) goto L81
        L80:
            return r1
        L81:
            long r3 = r9.e
            r5 = 8192(0x2000, double:4.0474E-320)
            long r3 = java.lang.Math.min(r5, r3)
            long r3 = super.e(r10, r3)
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 == 0) goto L97
            long r10 = r9.e
            long r10 = r10 - r3
            r9.e = r10
            return r3
        L97:
            java.lang.Object r10 = r11.d
            okhttp3.internal.connection.a r10 = (okhttp3.internal.connection.a) r10
            r10.k()
            java.net.ProtocolException r10 = new java.net.ProtocolException
            java.lang.String r11 = "unexpected end of stream"
            r10.<init>(r11)
            r9.b()
            throw r10
        La9:
            java.net.ProtocolException r10 = new java.net.ProtocolException     // Catch: java.lang.NumberFormatException -> Lc5
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lc5
            r11.<init>(r0)     // Catch: java.lang.NumberFormatException -> Lc5
            long r0 = r9.e     // Catch: java.lang.NumberFormatException -> Lc5
            r11.append(r0)     // Catch: java.lang.NumberFormatException -> Lc5
            r11.append(r12)     // Catch: java.lang.NumberFormatException -> Lc5
            r9 = 34
            r11.append(r9)     // Catch: java.lang.NumberFormatException -> Lc5
            java.lang.String r9 = r11.toString()     // Catch: java.lang.NumberFormatException -> Lc5
            r10.<init>(r9)     // Catch: java.lang.NumberFormatException -> Lc5
            throw r10     // Catch: java.lang.NumberFormatException -> Lc5
        Lc5:
            r9 = move-exception
            java.net.ProtocolException r10 = new java.net.ProtocolException
            java.lang.String r9 = r9.getMessage()
            r10.<init>(r9)
            throw r10
        Ld0:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: L9.d.e(V9.g, long):long");
    }
}
