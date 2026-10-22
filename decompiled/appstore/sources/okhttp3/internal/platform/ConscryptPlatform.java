package okhttp3.internal.platform;

import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* JADX INFO: loaded from: classes4.dex */
public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    public static Platform buildIfSupported() {
        Class.forName("org.conscrypt.ConscryptEngineSocket");     // Catch: ClassNotFoundException -> L8
        if (Conscrypt.isAvailable() == true) goto L6;
        return null;
    L6:
        Conscrypt.setUseEngineSocketByDefault(true);     // Catch: ClassNotFoundException -> L8
        return new ConscryptPlatform();
    L8:
        return null;
    }

    private Provider getProvider() {
        return new OpenSSLProvider();
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r10, String r11, List<Protocol> r12) {
        if (Conscrypt.isConscrypt(r10) == false) goto L7;
        if (r11 == null) goto L6;
        Conscrypt.setUseSessionTickets(r10, true);
        Conscrypt.setHostname(r10, r11);
    L6:
        Conscrypt.setApplicationProtocols(r10, (String[]) Platform.alpnProtocolNames(r12).toArray(new String[0]));
        return;
    L7:
        super.configureTlsExtensions(r10, r11, r12);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        return SSLContext.getInstance("TLS", getProvider());
    L4:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r10) {
        if (Conscrypt.isConscrypt(r10) == false) goto L7;
        return Conscrypt.getApplicationProtocol(r10);
    L7:
        return super.getSelectedProtocol(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r10) {
        if (Conscrypt.isConscrypt(r10) == false) goto L5;
        Object r11 = Platform.readFieldOrNull(r10, Object.class, "sslParameters");     // Catch: Exception -> L10
        if (r11 == null) goto L12;
        return (X509TrustManager) Platform.readFieldOrNull(r11, X509TrustManager.class, "x509TrustManager");
    L12:
        return null;
    L10:
        e = move-exception;
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
    L5:
        return super.trustManager(r10);
    }
}
