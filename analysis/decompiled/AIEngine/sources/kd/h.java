package kd;

import android.annotation.SuppressLint;
import bd.l;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.EmptyList;
import mb.m;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class h {
    public static final a Companion = new a();
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile h platform;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static ArrayList a(List list) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.f10880c) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                arrayList2.add(((Protocol) obj2).f10887a);
            }
            return arrayList2;
        }

        public static byte[] b(List list) {
            sd.e eVar = new sd.e();
            ArrayList arrayListA = a(list);
            int size = arrayListA.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayListA.get(i10);
                i10++;
                String str = (String) obj;
                eVar.O0(str.length());
                eVar.U0(str);
            }
            return eVar.G0(eVar.f11926b);
        }

        public static boolean c() {
            return "Dalvik".equals(System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[PHI: r0
      0x0073: PHI (r0v33 kd.h) = (r0v16 kd.h), (r0v18 kd.h), (r0v23 kd.h), (r0v27 kd.h), (r0v31 kd.h), (r0v42 kd.h) binds: [B:52:0x00e1, B:64:0x0149, B:46:0x00d3, B:38:0x00b3, B:30:0x0093, B:21:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    static {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kd.h.<clinit>():void");
    }

    public static final h get() {
        Companion.getClass();
        return platform;
    }

    public static /* synthetic */ void log$default(h hVar, String str, int i10, Throwable th, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i11 & 2) != 0) {
            i10 = 4;
        }
        if ((i11 & 4) != 0) {
            th = null;
        }
        hVar.log(str, i10, th);
    }

    public void afterHandshake(SSLSocket sslSocket) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
    }

    public od.c buildCertificateChainCleaner(X509TrustManager trustManager) {
        kotlin.jvm.internal.g.f(trustManager, "trustManager");
        return new od.a(buildTrustRootIndex(trustManager));
    }

    public od.e buildTrustRootIndex(X509TrustManager trustManager) {
        kotlin.jvm.internal.g.f(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        kotlin.jvm.internal.g.e(acceptedIssuers, "getAcceptedIssuers(...)");
        return new od.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.g.f(protocols, "protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int i10) throws IOException {
        kotlin.jvm.internal.g.f(socket, "socket");
        kotlin.jvm.internal.g.f(address, "address");
        socket.connect(address, i10);
    }

    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public List<String> getHandshakeServerNames(SSLSocket sslSocket) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        SSLSession session = sslSocket.getSession();
        ExtendedSSLSession extendedSSLSession = session instanceof ExtendedSSLSession ? (ExtendedSSLSession) session : null;
        if (extendedSSLSession == null) {
            return EmptyList.f10001a;
        }
        List<SNIServerName> requestedServerNames = extendedSSLSession.getRequestedServerNames();
        kotlin.jvm.internal.g.e(requestedServerNames, "getRequestedServerNames(...)");
        ArrayList arrayList = new ArrayList();
        for (SNIServerName sNIServerName : requestedServerNames) {
            SNIHostName sNIHostName = sNIServerName instanceof SNIHostName ? (SNIHostName) sNIServerName : null;
            String asciiName = sNIHostName != null ? sNIHostName.getAsciiName() : null;
            if (asciiName != null) {
                arrayList.add(asciiName);
            }
        }
        return arrayList;
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sslSocket) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String closer) {
        kotlin.jvm.internal.g.f(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        kotlin.jvm.internal.g.f(hostname, "hostname");
        return true;
    }

    public void log(String message, int i10, Throwable th) {
        kotlin.jvm.internal.g.f(message, "message");
        logger.log(i10 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void logCloseableLeak(String message, Object obj) {
        kotlin.jvm.internal.g.f(message, "message");
        if (obj == null) {
            message = message.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(message, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        kotlin.jvm.internal.g.e(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager trustManager) throws KeyManagementException {
        kotlin.jvm.internal.g.f(trustManager, "trustManager");
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
            kotlin.jvm.internal.g.e(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        kotlin.jvm.internal.g.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                kotlin.jvm.internal.g.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        kotlin.jvm.internal.g.e(string, "toString(...)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        kotlin.jvm.internal.g.f(sslSocketFactory, "sslSocketFactory");
        try {
            Object objH = l.h(sslSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objH == null) {
                return null;
            }
            return (X509TrustManager) l.h(objH, X509TrustManager.class, "trustManager");
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
