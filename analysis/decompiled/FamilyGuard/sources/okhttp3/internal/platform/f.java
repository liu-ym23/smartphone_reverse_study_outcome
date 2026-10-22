package okhttp3.internal.platform;

import C4.A;
import C4.B;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class f {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final f PLATFORM = findPlatform();
    private static final Logger logger = Logger.getLogger(A.class.getName());

    public static List<String> alpnProtocolNames(List<B> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            B b6 = list.get(i5);
            if (b6 != B.HTTP_1_0) {
                arrayList.add(b6.toString());
            }
        }
        return arrayList;
    }

    static byte[] concatLengthPrefixed(List<B> list) {
        L4.e eVar = new L4.e();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            B b6 = list.get(i5);
            if (b6 != B.HTTP_1_0) {
                eVar.writeByte(b6.toString().length());
                eVar.H(b6.toString());
            }
        }
        return eVar.E();
    }

    private static f findAndroidPlatform() {
        f fVarC = a.c();
        if (fVarC != null) {
            return fVarC;
        }
        f fVarC2 = b.c();
        if (fVarC2 != null) {
            return fVarC2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    private static f findJvmPlatform() {
        c cVarA;
        if (isConscryptPreferred() && (cVarA = c.a()) != null) {
            return cVarA;
        }
        e eVarA = e.a();
        if (eVarA != null) {
            return eVarA;
        }
        f fVarA = d.a();
        return fVarA != null ? fVarA : new f();
    }

    private static f findPlatform() {
        return isAndroid() ? findAndroidPlatform() : findJvmPlatform();
    }

    public static f get() {
        return PLATFORM;
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(D4.e.r("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    @Nullable
    static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object fieldOrNull;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(fieldOrNull, cls, str);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public K4.c buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new K4.a(buildTrustRootIndex(x509TrustManager));
    }

    public K4.e buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new K4.b(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, @Nullable String str, List<B> list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i5) throws IOException {
        socket.connect(inetSocketAddress, i5);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e6) {
            throw new IllegalStateException("No TLS provider", e6);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    @Nullable
    public Object getStackTraceForCloseable(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void log(int i5, String str, @Nullable Throwable th) {
        logger.log(i5 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Nullable
    protected X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Object fieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public K4.c buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        X509TrustManager x509TrustManagerTrustManager = trustManager(sSLSocketFactory);
        if (x509TrustManagerTrustManager != null) {
            return buildCertificateChainCleaner(x509TrustManagerTrustManager);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }
}
