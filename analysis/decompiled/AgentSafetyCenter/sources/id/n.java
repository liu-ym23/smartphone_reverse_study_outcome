package id;

import ad.x;
import b8.z;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class n {
    public static final m Companion = new m();
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile n platform;

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013d  */
    static {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.n.<clinit>():void");
    }

    public static final n get() {
        Companion.getClass();
        return platform;
    }

    public static /* synthetic */ void log$default(n nVar, String str, int i, Throwable th, int i3, Object obj) {
        if (obj != null) {
            g5.f.o("Super calls with default arguments not supported in this target, function: log");
            return;
        }
        if ((i3 & 2) != 0) {
            i = 4;
        }
        if ((i3 & 4) != 0) {
            th = null;
        }
        nVar.log(str, i, th);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        sSLSocket.getClass();
    }

    public md.c buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        x509TrustManager.getClass();
        md.e eVarBuildTrustRootIndex = buildTrustRootIndex(x509TrustManager);
        eVarBuildTrustRootIndex.getClass();
        md.a aVar = new md.a();
        aVar.f8606a = eVarBuildTrustRootIndex;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public md.e buildTrustRootIndex(X509TrustManager x509TrustManager) {
        x509TrustManager.getClass();
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        acceptedIssuers.getClass();
        X509Certificate[] x509CertificateArr = (X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length);
        md.b bVar = new md.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            subjectX500Principal.getClass();
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        bVar.f8607a = linkedHashMap;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<x> list) {
        sSLSocket.getClass();
        list.getClass();
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        sSLSocket.getClass();
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        str.getClass();
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        str.getClass();
        return true;
    }

    public void log(String str, int i, Throwable th) {
        str.getClass();
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        str.getClass();
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(str, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) throws KeyManagementException {
        x509TrustManager.getClass();
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
            socketFactory.getClass();
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException {
        sSLSocketFactory.getClass();
        try {
            Object objS = bd.b.s(Class.forName("sun.security.ssl.SSLContextImpl"), sSLSocketFactory, "context");
            if (objS == null) {
                return null;
            }
            return (X509TrustManager) bd.b.s(X509TrustManager.class, objS, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e10) {
            if (!e10.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e10;
            }
            return null;
        }
    }
}
