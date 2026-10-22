package io.ktor.network.tls;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/network/tls/CertificateAndKey;", "", "", "Ljava/security/cert/X509Certificate;", "certificateChain", "Ljava/security/PrivateKey;", "key", "<init>", "([Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;)V", "[Ljava/security/cert/X509Certificate;", "getCertificateChain", "()[Ljava/security/cert/X509Certificate;", "Ljava/security/PrivateKey;", "getKey", "()Ljava/security/PrivateKey;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CertificateAndKey {
    private final X509Certificate[] certificateChain;
    private final PrivateKey key;

    public CertificateAndKey(X509Certificate[] certificateChain, PrivateKey key) {
        p.i(certificateChain, "certificateChain");
        p.i(key, "key");
        this.certificateChain = certificateChain;
        this.key = key;
    }

    public final X509Certificate[] getCertificateChain() {
        return this.certificateChain;
    }

    public final PrivateKey getKey() {
        return this.key;
    }
}
