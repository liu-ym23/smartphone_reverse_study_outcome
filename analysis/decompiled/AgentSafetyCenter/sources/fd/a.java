package fd;

import ad.e0;
import ad.r;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4057a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4058b;

    public /* synthetic */ a(int i) {
        this.f4057a = i;
    }

    public static int d(e0 e0Var, int i) throws NumberFormatException {
        String strD = e0.d(e0Var, "Retry-After");
        if (strD == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        patternCompile.getClass();
        if (!patternCompile.matcher(strD).matches()) {
            return Reader.READ_DONE;
        }
        Integer numValueOf = Integer.valueOf(strD);
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        od.f.c(k0.a.j(r12, "unexpected port: "));
     */
    @Override // ad.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ad.e0 a(fd.f r24) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.a.a(fd.f):ad.e0");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ad.z b(ad.e0 r11, ed.e r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.a.b(ad.e0, ed.e):ad.z");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(java.io.IOException r3, ed.j r4, ad.z r5, boolean r6) {
        /*
            r2 = this;
            java.lang.Object r2 = r2.f4058b
            ad.w r2 = (ad.w) r2
            boolean r2 = r2.f607j
            r5 = 0
            if (r2 != 0) goto Lb
            goto L9d
        Lb:
            if (r6 == 0) goto L12
            boolean r2 = r3 instanceof java.io.FileNotFoundException
            if (r2 == 0) goto L12
            return r5
        L12:
            boolean r2 = r3 instanceof java.net.ProtocolException
            if (r2 == 0) goto L17
            return r5
        L17:
            boolean r2 = r3 instanceof java.io.InterruptedIOException
            if (r2 == 0) goto L22
            boolean r2 = r3 instanceof java.net.SocketTimeoutException
            if (r2 == 0) goto L9d
            if (r6 != 0) goto L9d
            goto L35
        L22:
            boolean r2 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r2 == 0) goto L30
            java.lang.Throwable r2 = r3.getCause()
            boolean r2 = r2 instanceof java.security.cert.CertificateException
            if (r2 == 0) goto L30
            goto L9d
        L30:
            boolean r2 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r2 == 0) goto L35
            return r5
        L35:
            ed.f r2 = r4.f3806k
            r2.getClass()
            int r3 = r2.f3793f
            r4 = 1
            if (r3 != 0) goto L49
            int r6 = r2.f3794g
            if (r6 != 0) goto L49
            int r6 = r2.f3795h
            if (r6 != 0) goto L49
            r2 = r5
            goto L9b
        L49:
            ad.i0 r6 = r2.i
            if (r6 == 0) goto L4e
            goto L96
        L4e:
            r6 = 0
            if (r3 > r4) goto L81
            int r3 = r2.f3794g
            if (r3 > r4) goto L81
            int r3 = r2.f3795h
            if (r3 <= 0) goto L5a
            goto L81
        L5a:
            ed.j r3 = r2.f3790c
            ed.m r3 = r3.f3807l
            if (r3 != 0) goto L61
            goto L81
        L61:
            monitor-enter(r3)
            int r0 = r3.f3829k     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L68
            monitor-exit(r3)
            goto L81
        L68:
            ad.i0 r0 = r3.f3820a     // Catch: java.lang.Throwable -> L7e
            ad.a r0 = r0.f518a     // Catch: java.lang.Throwable -> L7e
            ad.q r0 = r0.f428h     // Catch: java.lang.Throwable -> L7e
            ad.a r1 = r2.f3789b     // Catch: java.lang.Throwable -> L7e
            ad.q r1 = r1.f428h     // Catch: java.lang.Throwable -> L7e
            boolean r0 = bd.b.a(r0, r1)     // Catch: java.lang.Throwable -> L7e
            if (r0 != 0) goto L7a
            monitor-exit(r3)
            goto L81
        L7a:
            ad.i0 r6 = r3.f3820a     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r3)
            goto L81
        L7e:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L81:
            if (r6 == 0) goto L87
            r2.i = r6
        L85:
            r2 = r4
            goto L9b
        L87:
            wd.a r3 = r2.f3791d
            if (r3 == 0) goto L92
            boolean r3 = r3.g()
            if (r3 != r4) goto L92
            goto L96
        L92:
            ed.o r2 = r2.f3792e
            if (r2 != 0) goto L97
        L96:
            goto L85
        L97:
            boolean r2 = r2.d()
        L9b:
            if (r2 != 0) goto L9e
        L9d:
            return r5
        L9e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.a.c(java.io.IOException, ed.j, ad.z, boolean):boolean");
    }
}
