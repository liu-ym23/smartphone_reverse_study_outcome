package id;

import b8.z;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f5965b;

    /* renamed from: a, reason: collision with root package name */
    public final Provider f5966a = new OpenJSSE();

    static {
        boolean z10 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, k.class.getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f5965b = z10;
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
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f5966a);
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // id.n
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f5966a);
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
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }
}
