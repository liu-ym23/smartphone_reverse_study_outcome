package io.ktor.network.tls;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/ktor/network/tls/TLSConfigBuilder;", "", "<init>", "()V", "Lio/ktor/network/tls/TLSConfig;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lio/ktor/network/tls/TLSConfig;", "", "Lio/ktor/network/tls/CertificateAndKey;", "certificates", "Ljava/util/List;", "getCertificates", "()Ljava/util/List;", "Ljava/security/SecureRandom;", "random", "Ljava/security/SecureRandom;", "getRandom", "()Ljava/security/SecureRandom;", "setRandom", "(Ljava/security/SecureRandom;)V", "Ljavax/net/ssl/TrustManager;", UxipConstants.f30680s, "trustManager", "Ljavax/net/ssl/TrustManager;", "getTrustManager", "()Ljavax/net/ssl/TrustManager;", "setTrustManager", "(Ljavax/net/ssl/TrustManager;)V", "", "Lio/ktor/network/tls/CipherSuite;", "cipherSuites", "getCipherSuites", "setCipherSuites", "(Ljava/util/List;)V", "", "serverName", "Ljava/lang/String;", "getServerName", "()Ljava/lang/String;", "setServerName", "(Ljava/lang/String;)V", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSConfigBuilder {
    private final List<CertificateAndKey> certificates = new ArrayList();
    private List<CipherSuite> cipherSuites = CIOCipherSuites.INSTANCE.getSupportedSuites();
    private SecureRandom random;
    private String serverName;
    private TrustManager trustManager;

    public final TLSConfig build() throws NoSuchAlgorithmException, KeyStoreException {
        SecureRandom secureRandom = this.random;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        List<CertificateAndKey> list = this.certificates;
        TrustManager trustManager = this.trustManager;
        X509TrustManager x509TrustManagerFindTrustManager = trustManager instanceof X509TrustManager ? (X509TrustManager) trustManager : null;
        if (x509TrustManagerFindTrustManager == null) {
            x509TrustManagerFindTrustManager = TLSConfigBuilderKt.findTrustManager();
        }
        return new TLSConfig(secureRandom, list, x509TrustManagerFindTrustManager, this.cipherSuites, this.serverName);
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

    public final TrustManager getTrustManager() {
        return this.trustManager;
    }

    public final void setCipherSuites(List<CipherSuite> list) {
        p.i(list, "<set-?>");
        this.cipherSuites = list;
    }

    public final void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public final void setServerName(String str) {
        this.serverName = str;
    }

    public final void setTrustManager(TrustManager trustManager) {
        if (trustManager == null || (trustManager instanceof X509TrustManager)) {
            this.trustManager = trustManager;
            return;
        }
        throw new IllegalStateException(("Failed to set [trustManager]: " + trustManager + ". Only [X509TrustManager] supported.").toString());
    }
}
