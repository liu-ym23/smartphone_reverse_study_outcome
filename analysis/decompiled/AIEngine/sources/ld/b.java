package ld;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends od.c {

    /* renamed from: a, reason: collision with root package name */
    public final X509TrustManager f10417a;

    /* renamed from: b, reason: collision with root package name */
    public final X509TrustManagerExtensions f10418b;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f10417a = x509TrustManager;
        this.f10418b = x509TrustManagerExtensions;
    }

    @Override // od.c
    public final List a(String hostname, List chain) throws CertificateException, SSLPeerUnverifiedException {
        kotlin.jvm.internal.g.f(chain, "chain");
        kotlin.jvm.internal.g.f(hostname, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f10418b.checkServerTrusted((X509Certificate[]) chain.toArray(new X509Certificate[0]), "RSA", hostname);
            kotlin.jvm.internal.g.e(listCheckServerTrusted, "checkServerTrusted(...)");
            return listCheckServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f10417a == this.f10417a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f10417a);
    }
}
