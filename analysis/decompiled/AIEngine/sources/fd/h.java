package fd;

import ad.k;
import ad.n;
import ad.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.text.Regex;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    public final n f8846a;

    public h(n nVar) {
        this.f8846a = nVar;
    }

    public static int c(Response response, int i10) throws NumberFormatException {
        String strA = Response.a("Retry-After", response);
        if (strA == null) {
            return i10;
        }
        if (!new Regex("\\d+").c(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        kotlin.jvm.internal.g.e(numValueOf, "valueOf(...)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.h a(okhttp3.Response r11, ed.d r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.h.a(okhttp3.Response, ed.d):okhttp3.h");
    }

    public final boolean b(IOException iOException, okhttp3.internal.connection.d dVar, okhttp3.h hVar, boolean z) {
        s sVar;
        if (!this.f8846a.f121e) {
            return false;
        }
        if ((z && (((sVar = hVar.f10995d) != null && sVar.isOneShot()) || (iOException instanceof FileNotFoundException))) || (iOException instanceof ProtocolException)) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        ed.d dVar2 = dVar.f11054t;
        if (dVar2 == null || !dVar2.f8638f) {
            return false;
        }
        ed.e eVar = dVar.f11047l;
        kotlin.jvm.internal.g.c(eVar);
        okhttp3.internal.connection.h hVarB = eVar.b();
        ed.d dVar3 = dVar.f11054t;
        return hVarB.e(dVar3 != null ? dVar3.c() : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
    
        r5 = new okhttp3.Response.Builder(r2.b(r4));
        r5.f10901a = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
    
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
    
        r0 = bd.h.b(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        r5.f10909j = r0;
        r9 = r5.a();
        r0 = r3.f11050o;
        r4 = a(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ef, code lost:
    
        if (r4 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f1, code lost:
    
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f5, code lost:
    
        if (r0.f8637e == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        if (r3.f11049n != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
    
        r3.f11049n = true;
        r3.h.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010c, code lost:
    
        throw new java.lang.IllegalStateException("Check failed.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010d, code lost:
    
        r3.e(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0110, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0112, code lost:
    
        r0 = r4.f10995d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0114, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011a, code lost:
    
        if (r0.isOneShot() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011c, code lost:
    
        r3.e(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011f, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0120, code lost:
    
        bd.i.b(r9.f10893j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0125, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0129, code lost:
    
        if (r10 > 20) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0147, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r10);
     */
    @Override // ad.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response intercept(ad.k.a r38) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.h.intercept(ad.k$a):okhttp3.Response");
    }
}
