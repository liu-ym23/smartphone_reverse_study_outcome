package N9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* loaded from: classes4.dex */
public class m {
    public static final l Companion = new l();
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile m platform;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[PHI: r0
      0x0073: PHI (r0v38 N9.m) = (r0v16 N9.m), (r0v18 N9.m), (r0v28 N9.m), (r0v32 N9.m), (r0v36 N9.m), (r0v47 N9.m) binds: [B:52:0x00e1, B:64:0x0155, B:46:0x00d3, B:38:0x00b3, B:30:0x0093, B:21:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    static {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N9.m.<clinit>():void");
    }

    public static final m get() {
        Companion.getClass();
        return platform;
    }

    public static /* synthetic */ void log$default(m mVar, String str, int i, Throwable th, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i6 & 2) != 0) {
            i = 4;
        }
        if ((i6 & 4) != 0) {
            th = null;
        }
        mVar.log(str, i, th);
    }

    public void afterHandshake(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
    }

    public S9.c buildCertificateChainCleaner(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.f(trustManager, "trustManager");
        return new S9.a(buildTrustRootIndex(trustManager));
    }

    public S9.e buildTrustRootIndex(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.f(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        kotlin.jvm.internal.k.e(acceptedIssuers, "trustManager.acceptedIssuers");
        return new S9.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.f(protocols, "protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int i) throws IOException {
        kotlin.jvm.internal.k.f(address, "address");
        socket.connect(address, i);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String closer) {
        kotlin.jvm.internal.k.f(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        kotlin.jvm.internal.k.f(hostname, "hostname");
        return true;
    }

    public void log(String message, int i, Throwable th) {
        kotlin.jvm.internal.k.f(message, "message");
        logger.log(i == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void logCloseableLeak(String message, Object obj) {
        kotlin.jvm.internal.k.f(message, "message");
        if (obj == null) {
            message = message.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(message, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        kotlin.jvm.internal.k.e(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager trustManager) throws KeyManagementException {
        kotlin.jvm.internal.k.f(trustManager, "trustManager");
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
            kotlin.jvm.internal.k.e(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        kotlin.jvm.internal.k.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                kotlin.jvm.internal.k.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        kotlin.jvm.internal.k.e(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) throws IllegalAccessException, NoSuchFieldException {
        kotlin.jvm.internal.k.f(sslSocketFactory, "sslSocketFactory");
        try {
            Object objR = G9.b.r(Class.forName("sun.security.ssl.SSLContextImpl"), sslSocketFactory, "context");
            if (objR == null) {
                return null;
            }
            return (X509TrustManager) G9.b.r(X509TrustManager.class, objR, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e) {
            if (!e.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
            return null;
        }
    }
}
