package K9;

import F9.A;
import F9.C0237o;
import F9.M;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

/* loaded from: classes4.dex */
public final class a implements A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f911a;
    public final Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f911a = i;
        this.b = obj;
    }

    public static int c(M m, int i) throws NumberFormatException {
        String strB = M.b(m, "Retry-After");
        if (strB == null) {
            return i;
        }
        if (!new Regex("\\d+").d(strB)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strB);
        k.e(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public F9.G a(F9.M r11, G6.c r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.a.a(F9.M, G6.c):F9.G");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(java.io.IOException r3, J9.i r4, F9.G r5, boolean r6) {
        /*
            r2 = this;
            java.lang.Object r2 = r2.b
            F9.F r2 = (F9.F) r2
            boolean r2 = r2.f
            r0 = 0
            if (r2 != 0) goto Lb
            goto Lb1
        Lb:
            if (r6 == 0) goto L1c
            F9.K r2 = r5.d
            if (r2 == 0) goto L17
            boolean r2 = r2.isOneShot()
            if (r2 != 0) goto Lb1
        L17:
            boolean r2 = r3 instanceof java.io.FileNotFoundException
            if (r2 == 0) goto L1c
            return r0
        L1c:
            boolean r2 = r3 instanceof java.net.ProtocolException
            if (r2 == 0) goto L21
            return r0
        L21:
            boolean r2 = r3 instanceof java.io.InterruptedIOException
            if (r2 == 0) goto L2c
            boolean r2 = r3 instanceof java.net.SocketTimeoutException
            if (r2 == 0) goto Lb1
            if (r6 != 0) goto Lb1
            goto L3f
        L2c:
            boolean r2 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r2 == 0) goto L3a
            java.lang.Throwable r2 = r3.getCause()
            boolean r2 = r2 instanceof java.security.cert.CertificateException
            if (r2 == 0) goto L3a
            goto Lb1
        L3a:
            boolean r2 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r2 == 0) goto L3f
            return r0
        L3f:
            J9.e r2 = r4.h
            kotlin.jvm.internal.k.c(r2)
            int r3 = r2.f893a
            r4 = 1
            if (r3 != 0) goto L53
            int r5 = r2.b
            if (r5 != 0) goto L53
            int r5 = r2.c
            if (r5 != 0) goto L53
            r2 = r0
            goto Laf
        L53:
            java.lang.Object r5 = r2.f894j
            F9.Q r5 = (F9.Q) r5
            if (r5 == 0) goto L5a
            goto Laa
        L5a:
            r5 = 0
            if (r3 > r4) goto L91
            int r3 = r2.b
            if (r3 > r4) goto L91
            int r3 = r2.c
            if (r3 <= 0) goto L66
            goto L91
        L66:
            java.lang.Object r3 = r2.f
            J9.i r3 = (J9.i) r3
            okhttp3.internal.connection.a r3 = r3.i
            if (r3 != 0) goto L6f
            goto L91
        L6f:
            monitor-enter(r3)
            int r6 = r3.l     // Catch: java.lang.Throwable -> L8e
            if (r6 == 0) goto L76
            monitor-exit(r3)
            goto L91
        L76:
            F9.Q r6 = r3.b     // Catch: java.lang.Throwable -> L8e
            F9.a r6 = r6.f635a     // Catch: java.lang.Throwable -> L8e
            F9.y r6 = r6.i     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r1 = r2.e     // Catch: java.lang.Throwable -> L8e
            F9.a r1 = (F9.C0223a) r1     // Catch: java.lang.Throwable -> L8e
            F9.y r1 = r1.i     // Catch: java.lang.Throwable -> L8e
            boolean r6 = G9.b.a(r6, r1)     // Catch: java.lang.Throwable -> L8e
            if (r6 != 0) goto L8a
            monitor-exit(r3)
            goto L91
        L8a:
            F9.Q r5 = r3.b     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r3)
            goto L91
        L8e:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L91:
            if (r5 == 0) goto L97
            r2.f894j = r5
        L95:
            r2 = r4
            goto Laf
        L97:
            java.lang.Object r3 = r2.h
            H4.t r3 = (H4.t) r3
            if (r3 == 0) goto La4
            boolean r3 = r3.a()
            if (r3 != r4) goto La4
            goto Laa
        La4:
            java.lang.Object r2 = r2.i
            F9.x r2 = (F9.x) r2
            if (r2 != 0) goto Lab
        Laa:
            goto L95
        Lab:
            boolean r2 = r2.g()
        Laf:
            if (r2 != 0) goto Lb2
        Lb1:
            return r0
        Lb2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.a.b(java.io.IOException, J9.i, F9.G, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0122, code lost:
    
        r3.e(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0132, code lost:
    
        return r9;
     */
    @Override // F9.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final F9.M intercept(F9.z r26) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.a.intercept(F9.z):F9.M");
    }

    public a(C0237o cookieJar) {
        this.f911a = 0;
        k.f(cookieJar, "cookieJar");
        this.b = cookieJar;
    }
}
