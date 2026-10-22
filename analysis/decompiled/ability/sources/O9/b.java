package O9;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class b extends S9.c {

    /* renamed from: a, reason: collision with root package name */
    public final X509TrustManager f1045a;
    public final X509TrustManagerExtensions b;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f1045a = x509TrustManager;
        this.b = x509TrustManagerExtensions;
    }

    @Override // S9.c
    public final List a(String hostname, List chain) throws CertificateException, SSLPeerUnverifiedException {
        kotlin.jvm.internal.k.f(chain, "chain");
        kotlin.jvm.internal.k.f(hostname, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.b.checkServerTrusted((X509Certificate[]) chain.toArray(new X509Certificate[0]), "RSA", hostname);
            kotlin.jvm.internal.k.e(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f1045a == this.f1045a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f1045a);
    }
}
