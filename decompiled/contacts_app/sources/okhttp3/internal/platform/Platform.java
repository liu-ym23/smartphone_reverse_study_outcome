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

/* JADX INFO: loaded from: classes5.dex */
public class Platform {
    public static final int INFO = 4;
    private static final Platform PLATFORM = null;
    public static final int WARN = 5;
    private static final Logger logger = null;

    public void afterHandshake(SSLSocket r1) {
    }

    public void configureSslSocketFactory(SSLSocketFactory r1) {
    }

    public void configureTlsExtensions(SSLSocket r1, @Nullable String r2, List<Protocol> r3) throws IOException {
    }

    public String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket r1) {
        return null;
    }

    public boolean isCleartextTrafficPermitted(String r1) {
        return true;
    }

    public Platform() {
    }

    static {
        PLATFORM = findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static Platform get() {
        return PLATFORM;
    }

    @Nullable
    protected X509TrustManager trustManager(SSLSocketFactory r3) {
        Object r4 = readFieldOrNull(r3, Class.forName("sun.security.ssl.SSLContextImpl"), "context");     // Catch: ClassNotFoundException -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return (X509TrustManager) readFieldOrNull(r4, X509TrustManager.class, "trustManager");
    L8:
        return null;
    }

    public void connectSocket(Socket r1, InetSocketAddress r2, int r3) throws IOException {
        r1.connect(r2, r3);
    }

    public void log(int r1, String r2, @Nullable Throwable r3) {
        if (r1 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        logger.log(r0, r2, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public Object getStackTraceForCloseable(String r2) {
        if (logger.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable(r2);
    }

    public void logCloseableLeak(String r2, Object r3) {
        if (r3 != null) goto L4;
        r2 = r2 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L4:
        log(5, r2, (Throwable) r3);
    }

    public static List<String> alpnProtocolNames(List<Protocol> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Protocol r3 = r5.get(r2);
        if (r3 == Protocol.HTTP_1_0) goto L8;
        r0.add(r3.toString());
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r2) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(r2));
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory r3) {
        X509TrustManager r0 = trustManager(r3);
        if (r0 == null) goto L7;
        return buildCertificateChainCleaner(r0);
    L7:
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + r3.getClass());
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L7;
        return true;
    L7:
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static Platform findPlatform() {
        if (isAndroid() == false) goto L7;
        return findAndroidPlatform();
    L7:
        return findJvmPlatform();
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    private static Platform findJvmPlatform() {
        if (isConscryptPreferred() == false) goto L7;
        ConscryptPlatform r0 = ConscryptPlatform.buildIfSupported();
        if (r0 == null) goto L7;
        return r0;
    L7:
        Jdk9Platform r1 = Jdk9Platform.buildIfSupported();
        if (r1 == null) goto L10;
        return r1;
    L10:
        Platform r2 = JdkWithJettyBootPlatform.buildIfSupported();
        if (r2 == null) goto L14;
        return r2;
    L14:
        return new Platform();
    }

    private static Platform findAndroidPlatform() {
        Platform r0 = Android10Platform.buildIfSupported();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Platform r1 = AndroidPlatform.buildIfSupported();
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new NullPointerException("No platform found on Android");
    }

    static byte[] concatLengthPrefixed(List<Protocol> r5) {
        Buffer r0 = new Buffer();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Protocol r3 = r5.get(r2);
        if (r3 == Protocol.HTTP_1_0) goto L8;
        r0.writeByte(r3.toString().length());
        r0.writeUtf8(r3.toString());
    L8:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0.readByteArray();
    }

    @Nullable
    static <T> T readFieldOrNull(Object r4, Class<T> r5, String r6) {
        Class<?> r0 = r4.getClass();
    L4:
        if (r0 == Object.class) goto L17;
        Field r1 = r0.getDeclaredField(r6);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        Object r2 = r1.get(r4);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r2 == null) goto L12;
        if (r5.isInstance(r2) == false) goto L12;
        goto L14
    L11:
        return r5.cast(r2);
    L12:
        return null;
    L15:
        r0 = r0.getSuperclass();
    L14:
        throw new AssertionError();
    L17:
        if (r6.equals("delegate") == true) goto L22;
        Object r7 = readFieldOrNull(r4, Object.class, "delegate");
        if (r7 == null) goto L22;
        return (T) readFieldOrNull(r7, r5, r6);
    L22:
        return null;
    }

    public SSLContext getSSLContext() {
        if ("1.7".equals(System.getProperty("java.specification.version")) == false) goto L14;
        return SSLContext.getInstance("TLSv1.2");
    L14:
        return SSLContext.getInstance("TLS");
    L8:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager r1) {
        return new BasicTrustRootIndex(r1.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
