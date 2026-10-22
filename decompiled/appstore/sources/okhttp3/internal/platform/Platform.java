package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
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
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* JADX INFO: loaded from: classes4.dex */
public class Platform {
    public static final int INFO = 4;
    private static final Platform PLATFORM = null;
    public static final int WARN = 5;
    private static final Logger logger = null;

    static {
        PLATFORM = findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public Platform() {
    }

    public static List<String> alpnProtocolNames(List<Protocol> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Protocol r14 = r10.get(r13);
        if (r14 == Protocol.HTTP_1_0) goto L8;
        r11.add(r14.toString());
    L8:
        r13 = r13 + 1;
        goto L3
    L9:
        return r11;
    }

    public static byte[] concatLengthPrefixed(List<Protocol> r10) {
        Buffer r11 = new Buffer();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        Protocol r14 = r10.get(r13);
        if (r14 == Protocol.HTTP_1_0) goto L8;
        r11.t(r14.toString().length());
        r11.E(r14.toString());
    L8:
        r13 = r13 + 1;
        goto L3
    L10:
        return r11.readByteArray();
    }

    private static Platform findPlatform() {
        Platform r10 = AndroidPlatform.buildIfSupported();
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (isConscryptPreferred() == false) goto L10;
        Platform r11 = ConscryptPlatform.buildIfSupported();
        if (r11 == null) goto L10;
        return r11;
    L10:
        Jdk9Platform r12 = Jdk9Platform.buildIfSupported();
        if (r12 == null) goto L13;
        return r12;
    L13:
        Platform r13 = JdkWithJettyBootPlatform.buildIfSupported();
        if (r13 == null) goto L17;
        return r13;
    L17:
        return new Platform();
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L7;
        return true;
    L7:
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static <T> T readFieldOrNull(Object r10, Class<T> r11, String r12) {
        Class<?> r13 = r10.getClass();
    L4:
        if (r13 == Object.class) goto L17;
        Field r14 = r13.getDeclaredField(r12);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        r14.setAccessible(true);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        Object r15 = r14.get(r10);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r15 == null) goto L12;
        if (r11.isInstance(r15) == false) goto L12;
        goto L14
    L11:
        return r11.cast(r15);
    L12:
        return null;
    L15:
        r13 = r13.getSuperclass();
    L14:
        throw new AssertionError();
    L17:
        if (r12.equals("delegate") == true) goto L22;
        Object r16 = readFieldOrNull(r10, Object.class, "delegate");
        if (r16 == null) goto L22;
        return (T) readFieldOrNull(r16, r11, r12);
    L22:
        return null;
    }

    public void afterHandshake(SSLSocket r10) {
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r10) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(r10));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager r10) {
        return new BasicTrustRootIndex(r10.getAcceptedIssuers());
    }

    public void configureTlsExtensions(SSLSocket r10, String r11, List<Protocol> r12) {
    }

    public void connectSocket(Socket r10, InetSocketAddress r11, int r12) throws IOException {
        r10.connect(r11, r12);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public SSLContext getSSLContext() {
        return SSLContext.getInstance("TLS");
    L4:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket r10) {
        return null;
    }

    public Object getStackTraceForCloseable(String r10) {
        if (logger.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable(r10);
    }

    public boolean isCleartextTrafficPermitted(String r10) {
        return true;
    }

    public void log(int r10, String r11, Throwable r12) {
        if (r10 != 5) goto L5;
        Level r13 = Level.WARNING;
    L6:
        logger.log(r13, r11, r12);
        return;
    L5:
        r13 = Level.INFO;
        goto L6
    }

    public void logCloseableLeak(String r10, Object r11) {
        if (r11 != null) goto L4;
        r10 = r10 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L4:
        log(5, r10, (Throwable) r11);
    }

    public X509TrustManager trustManager(SSLSocketFactory r10) {
        Object r11 = readFieldOrNull(r10, Class.forName("sun.security.ssl.SSLContextImpl"), "context");     // Catch: ClassNotFoundException -> L8
        if (r11 != null) goto L6;
        return null;
    L6:
        return (X509TrustManager) readFieldOrNull(r11, X509TrustManager.class, "trustManager");
    L8:
        return null;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory r10) {
        X509TrustManager r11 = trustManager(r10);
        if (r11 == null) goto L7;
        return buildCertificateChainCleaner(r11);
    L7:
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + r10.getClass());
    }
}
