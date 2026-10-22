package okhttp3.internal.platform;

import C4.B;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public class c extends f {
    private c() {
    }

    public static c a() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new c();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider b() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.platform.f
    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.f
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<B> list) {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.configureTlsExtensions(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) f.alpnProtocolNames(list).toArray(new String[0]));
    }

    @Override // okhttp3.internal.platform.f
    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLSv1.3", b());
        } catch (NoSuchAlgorithmException e6) {
            try {
                return SSLContext.getInstance("TLS", this.b());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e6);
            }
        }
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            Object fieldOrNull = f.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
            if (fieldOrNull != null) {
                return (X509TrustManager) f.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e6) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e6);
        }
    }
}
