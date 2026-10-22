package jb;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final X509TrustManager f5426c;

    /* renamed from: d, reason: collision with root package name */
    public final X509TrustManagerExtensions f5427d;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        super(28);
        this.f5426c = x509TrustManager;
        this.f5427d = x509TrustManagerExtensions;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f5426c == this.f5426c;
    }

    @Override // w7.e0
    public final List h(String str, List list) throws CertificateException, SSLPeerUnverifiedException {
        q7.k.e(list, "chain");
        q7.k.e(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f5427d.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            q7.k.d(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5426c);
    }
}
