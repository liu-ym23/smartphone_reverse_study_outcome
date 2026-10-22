package id;

import b8.z;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f5949b;

    /* renamed from: a, reason: collision with root package name */
    public final Provider f5950a = new BouncyCastleJsseProvider();

    static {
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, c.class.getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f5949b = z10;
    }

    @Override // id.n
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        sSLSocket.getClass();
        list.getClass();
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    @Override // id.n
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        sSLSocket.getClass();
        return super.getSelectedProtocol(sSLSocket);
    }

    @Override // id.n
    public final SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f5950a);
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // id.n
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        z.j("Unexpected default trust managers: ".concat(string));
        return null;
    }

    @Override // id.n
    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        sSLSocketFactory.getClass();
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}
