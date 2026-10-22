package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes5.dex */
class AndroidPlatform extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final CloseGuard closeGuard;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public int hashCode() {
            return 0;
        }

        AndroidCertificateChainCleaner(Object r1, Method r2) {
            this.x509TrustManagerExtensions = r1;
            this.checkServerTrusted = r2;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<Certificate> r4, String r5) throws SSLPeerUnverifiedException {
            X509Certificate[] r6 = (X509Certificate[]) r4.toArray(new X509Certificate[r4.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
            return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{r6, "RSA", r5});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            e = move-exception;
            SSLPeerUnverifiedException r7 = new SSLPeerUnverifiedException(e.getMessage());
            r7.initCause(e);
            throw r7;
        }

        public boolean equals(Object r1) {
            return r1 instanceof AndroidCertificateChainCleaner;
        }
    }

    static final class AndroidTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        AndroidTrustRootIndex(X509TrustManager r1, Method r2) {
            this.findByIssuerAndSignatureMethod = r2;
            this.trustManager = r1;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate r5) {
            TrustAnchor r4 = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{r5});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L7
            if (r4 == null) goto L13;
            return r4.getTrustedCert();
            goto L14
        L13:
            return null;
        L7:
            e = move-exception;
            throw Util.assertionError("unable to get issues and signature", e);
        L14:
            return null;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof AndroidTrustRootIndex) == true) goto L8;
            return false;
        L8:
            AndroidTrustRootIndex r6 = (AndroidTrustRootIndex) r5;
            if (this.trustManager.equals(r6.trustManager) == false) goto L14;
            if (this.findByIssuerAndSignatureMethod.equals(r6.findByIssuerAndSignatureMethod) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    static final class CloseGuard {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        CloseGuard(Method r1, Method r2, Method r3) {
            this.getMethod = r1;
            this.openMethod = r2;
            this.warnIfOpenMethod = r3;
        }

        Object createAndOpen(String r5) {
            Method r0 = this.getMethod;
            if (r0 != null) goto L9;
        L7:
            return null;
        L9:
            Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
            this.openMethod.invoke(r1, new Object[]{r5});     // Catch: Exception -> L8
            return r1;
        }

        boolean warnIfOpen(Object r3) {
            if (r3 == null) goto L10;
            this.warnIfOpenMethod.invoke(r3, new Object[0]);     // Catch: Exception -> L7
            return true;
        L11:
            return false;
        L10:
            return false;
        }

        static CloseGuard get() {
            Class<?> r0 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L4
            Method r1 = r0.getMethod("get", new Class[0]);     // Catch: Exception -> L4
            Method r3 = r0.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L4
            Method r2 = r0.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L4
        L6:
            return new CloseGuard(r1, r3, r2);
        L4:
            r1 = null;
            r2 = null;
            r3 = null;
            goto L6
        }
    }

    AndroidPlatform(Class<?> r2, OptionalMethod<Socket> r3, OptionalMethod<Socket> r4, OptionalMethod<Socket> r5, OptionalMethod<Socket> r6) {
        this.closeGuard = CloseGuard.get();
        this.sslParametersClass = r2;
        this.setUseSessionTickets = r3;
        this.setHostname = r4;
        this.getAlpnSelectedProtocol = r5;
        this.setAlpnProtocols = r6;
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket r1, InetSocketAddress r2, int r3) throws IOException {
        r1.connect(r2, r3);     // Catch: ClassCastException -> L4 SecurityException -> L6 AssertionError -> L9
        return;
    L9:
        e = move-exception;
        if (Util.isAndroidGetsocknameError(e) == true) goto L13;
        throw e;
    L13:
        throw new IOException(e);
    L4:
        e = move-exception;
        throw e;
    L6:
        e = move-exception;
        IOException r4 = new IOException("Exception in connect");
        r4.initCause(e);
        throw r4;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    protected X509TrustManager trustManager(SSLSocketFactory r5) {
        Object r0 = readFieldOrNull(r5, this.sslParametersClass, "sslParameters");
        if (r0 == null) goto L13;
    L8:
        X509TrustManager r4 = (X509TrustManager) readFieldOrNull(r0, X509TrustManager.class, "x509TrustManager");
        if (r4 == null) goto L12;
        return r4;
    L12:
        return (X509TrustManager) readFieldOrNull(r0, X509TrustManager.class, "trustManager");
    L13:
        r0 = readFieldOrNull(r5, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r5.getClass().getClassLoader()), "sslParameters");     // Catch: ClassNotFoundException -> L6
    L7:
        return super.trustManager(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r6, String r7, List<Protocol> r8) throws IOException {
        if (r7 == null) goto L5;
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(r6, new Object[]{true});
        this.setHostname.invokeOptionalWithoutCheckedException(r6, new Object[]{r7});
    L5:
        OptionalMethod<Socket> r9 = this.setAlpnProtocols;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.isSupported(r6) == false) goto L12;
        this.setAlpnProtocols.invokeWithoutCheckedException(r6, new Object[]{concatLengthPrefixed(r8)});
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r3) {
        OptionalMethod<Socket> r0 = this.getAlpnSelectedProtocol;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isSupported(r3) == true) goto L8;
        return null;
    L8:
        byte[] r2 = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(r3, new Object[0]);
        if (r2 != null) goto L11;
        return null;
    L11:
        return new String(r2, Util.UTF_8);
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int r5, String r6, @Nullable Throwable r7) {
        int r4 = 5;
        if (r5 == 5) goto L7;
        r4 = 3;
    L7:
        if (r7 == null) goto L9;
        r6 = r6 + '\n' + Log.getStackTraceString(r7);
    L9:
        int r8 = r6.length();
        int r0 = 0;
    L10:
        if (r0 >= r8) goto L19;
        int r1 = r6.indexOf(10, r0);
        if (r1 != (-1)) goto L15;
        r1 = r8;
    L15:
        int r2 = Math.min(r1, r0 + MAX_LOG_LENGTH);
        Log.println(r4, "OkHttp", r6.substring(r0, r2));
        if (r2 >= r1) goto L17;
        r0 = r2;
        goto L15
    L17:
        r0 = r2 + 1;
        goto L10
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String r1) {
        return this.closeGuard.createAndOpen(r1);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String r2, Object r3) {
        if (this.closeGuard.warnIfOpen(r3) == true) goto L6;
        log(5, r2, null);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String r5) {
        Class<?> r0 = Class.forName("android.security.NetworkSecurityPolicy");     // Catch: Throwable -> L4 Throwable -> L7
        return api24IsCleartextTrafficPermitted(r5, r0, r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
    L4:
        e = move-exception;
        throw Util.assertionError("unable to determine cleartext support", e);
    L8:
        return super.isCleartextTrafficPermitted(r5);
    }

    private boolean api24IsCleartextTrafficPermitted(String r6, Class<?> r7, Object r8) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r7.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r8, new Object[]{r6})).booleanValue();
    L5:
        return api23IsCleartextTrafficPermitted(r6, r7, r8);
    }

    private boolean api23IsCleartextTrafficPermitted(String r4, Class<?> r5, Object r6) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r5.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r6, new Object[0])).booleanValue();
    L5:
        return super.isCleartextTrafficPermitted(r4);
    }

    private static boolean supportsAlpn() {
        if (Security.getProvider("GMSCore_OpenSSL") == null) goto L9;
        return true;
    L9:
        Class.forName("android.net.Network");     // Catch: ClassNotFoundException -> L7
        return true;
    L7:
        return false;
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r8) {
        Class<?> r0 = Class.forName("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L4
        return new AndroidCertificateChainCleaner(r0.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r8}), r0.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L5:
        return super.buildCertificateChainCleaner(r8);
    }

    public static Platform buildIfSupported() {
        if (Platform.isAndroid() == true) goto L15;
        return null;
    L15:
        Class<?> r1 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L7
    L6:
        Class<?> r4 = r1;
        OptionalMethod r5 = new OptionalMethod(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L14
        OptionalMethod r6 = new OptionalMethod(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L14
        if (supportsAlpn() == false) goto L11;
        OptionalMethod r2 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L14
        OptionalMethod r8 = new OptionalMethod(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L14
        OptionalMethod r7 = r2;
    L12:
        return new AndroidPlatform(r4, r5, r6, r7, r8);
    L11:
        r7 = null;
        r8 = null;
        goto L12
    L7:
        r1 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L14
    L14:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager r7) {
        Method r0 = r7.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new AndroidTrustRootIndex(r7, r0);
    L5:
        return super.buildTrustRootIndex(r7);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        return SSLContext.getInstance("TLS");
    L4:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    L4:
        return 0;
    }
}
