package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayTlsConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "<init>", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;Ljavax/net/ssl/HostnameVerifier;)V", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayTlsConfig {
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager trustManager;

    public GatewayTlsConfig(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager, HostnameVerifier hostnameVerifier) {
        p.e(sslSocketFactory, "sslSocketFactory");
        p.e(trustManager, "trustManager");
        p.e(hostnameVerifier, "hostnameVerifier");
        this.sslSocketFactory = sslSocketFactory;
        this.trustManager = trustManager;
        this.hostnameVerifier = hostnameVerifier;
    }

    public static /* synthetic */ GatewayTlsConfig copy$default(GatewayTlsConfig gatewayTlsConfig, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, HostnameVerifier hostnameVerifier, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            sSLSocketFactory = gatewayTlsConfig.sslSocketFactory;
        }
        if ((i8 & 2) != 0) {
            x509TrustManager = gatewayTlsConfig.trustManager;
        }
        if ((i8 & 4) != 0) {
            hostnameVerifier = gatewayTlsConfig.hostnameVerifier;
        }
        return gatewayTlsConfig.copy(sSLSocketFactory, x509TrustManager, hostnameVerifier);
    }

    /* renamed from: component1, reason: from getter */
    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: component2, reason: from getter */
    public final X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    /* renamed from: component3, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final GatewayTlsConfig copy(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager, HostnameVerifier hostnameVerifier) {
        p.e(sslSocketFactory, "sslSocketFactory");
        p.e(trustManager, "trustManager");
        p.e(hostnameVerifier, "hostnameVerifier");
        return new GatewayTlsConfig(sslSocketFactory, trustManager, hostnameVerifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayTlsConfig)) {
            return false;
        }
        GatewayTlsConfig gatewayTlsConfig = (GatewayTlsConfig) other;
        return p.a(this.sslSocketFactory, gatewayTlsConfig.sslSocketFactory) && p.a(this.trustManager, gatewayTlsConfig.trustManager) && p.a(this.hostnameVerifier, gatewayTlsConfig.hostnameVerifier);
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    public int hashCode() {
        return this.hostnameVerifier.hashCode() + ((this.trustManager.hashCode() + (this.sslSocketFactory.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "GatewayTlsConfig(sslSocketFactory=" + this.sslSocketFactory + ", trustManager=" + this.trustManager + ", hostnameVerifier=" + this.hostnameVerifier + ")";
    }
}
