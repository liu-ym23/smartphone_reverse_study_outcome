package io.ktor.network.tls;

import java.security.SecureRandom;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/network/tls/TLSConfig;", "", "Ljava/security/SecureRandom;", "random", "", "Lio/ktor/network/tls/CertificateAndKey;", "certificates", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lio/ktor/network/tls/CipherSuite;", "cipherSuites", "", "serverName", "<init>", "(Ljava/security/SecureRandom;Ljava/util/List;Ljavax/net/ssl/X509TrustManager;Ljava/util/List;Ljava/lang/String;)V", "Ljava/security/SecureRandom;", "getRandom", "()Ljava/security/SecureRandom;", "Ljava/util/List;", "getCertificates", "()Ljava/util/List;", "Ljavax/net/ssl/X509TrustManager;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "getCipherSuites", "Ljava/lang/String;", "getServerName", "()Ljava/lang/String;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSConfig {
    private final List<CertificateAndKey> certificates;
    private final List<CipherSuite> cipherSuites;
    private final SecureRandom random;
    private final String serverName;
    private final X509TrustManager trustManager;

    public TLSConfig(SecureRandom random, List<CertificateAndKey> certificates, X509TrustManager trustManager, List<CipherSuite> cipherSuites, String str) {
        p.i(random, "random");
        p.i(certificates, "certificates");
        p.i(trustManager, "trustManager");
        p.i(cipherSuites, "cipherSuites");
        this.random = random;
        this.certificates = certificates;
        this.trustManager = trustManager;
        this.cipherSuites = cipherSuites;
        this.serverName = str;
    }

    public final List<CertificateAndKey> getCertificates() {
        return this.certificates;
    }

    public final List<CipherSuite> getCipherSuites() {
        return this.cipherSuites;
    }

    public final SecureRandom getRandom() {
        return this.random;
    }

    public final String getServerName() {
        return this.serverName;
    }

    public final X509TrustManager getTrustManager() {
        return this.trustManager;
    }
}
