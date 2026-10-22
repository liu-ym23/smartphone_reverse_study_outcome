package okhttp3.internal.platform;

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
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes4.dex */
class AndroidPlatform extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final CloseGuard closeGuard;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;

    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public AndroidCertificateChainCleaner(Object r10, Method r11) {
            this.x509TrustManagerExtensions = r10;
            this.checkServerTrusted = r11;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<Certificate> r10, String r11) throws SSLPeerUnverifiedException {
            X509Certificate[] r12 = (X509Certificate[]) r10.toArray(new X509Certificate[r10.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6
            return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{r12, "RSA", r11});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L6:
            e = move-exception;
            SSLPeerUnverifiedException r13 = new SSLPeerUnverifiedException(e.getMessage());
            r13.initCause(e);
            throw r13;
        }

        public boolean equals(Object r10) {
            return r10 instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class AndroidTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public AndroidTrustRootIndex(X509TrustManager r10, Method r11) {
            this.findByIssuerAndSignatureMethod = r11;
            this.trustManager = r10;
        }

        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof AndroidTrustRootIndex) == true) goto L8;
            return false;
        L8:
            AndroidTrustRootIndex r11 = (AndroidTrustRootIndex) r10;
            if (this.trustManager.equals(r11.trustManager) == false) goto L14;
            if (this.findByIssuerAndSignatureMethod.equals(r11.findByIssuerAndSignatureMethod) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate r10) {
            TrustAnchor r11 = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{r10});     // Catch: IllegalAccessException -> L7 InvocationTargetException -> L12
            if (r11 == null) goto L9;
            goto L16
        L15:
            return r11.getTrustedCert();
        L9:
            return null;
        L7:
            e = move-exception;
            throw Util.assertionError("unable to get issues and signature", e);
        L16:
            return null;
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    public static final class CloseGuard {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        public CloseGuard(Method r10, Method r11, Method r12) {
            this.getMethod = r10;
            this.openMethod = r11;
            this.warnIfOpenMethod = r12;
        }

        public static CloseGuard get() {
            Method r10 = null;
            Class<?> r11 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
            Method r12 = r11.getMethod("get", null);     // Catch: Exception -> L5
            Method r13 = r11.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r14 = r11.getMethod("warnIfOpen", null);     // Catch: Exception -> L5
            r10 = r12;
        L7:
            return new CloseGuard(r10, r13, r14);
        L5:
            r14 = null;
            r13 = null;
            goto L7
        }

        public Object createAndOpen(String r10) {
            Method r11 = this.getMethod;
            if (r11 != null) goto L8;
        L6:
            return null;
        L8:
            Object r12 = r11.invoke(null, null);     // Catch: Exception -> L7
            this.openMethod.invoke(r12, new Object[]{r10});     // Catch: Exception -> L7
            return r12;
        }

        public boolean warnIfOpen(Object r10) {
            if (r10 != null) goto L8;
        L5:
            return false;
        L8:
            this.warnIfOpenMethod.invoke(r10, null);     // Catch: Exception -> L7
            return true;
        }
    }

    public AndroidPlatform(Class<?> r10, OptionalMethod<Socket> r11, OptionalMethod<Socket> r12, OptionalMethod<Socket> r13, OptionalMethod<Socket> r14) {
        this.closeGuard = CloseGuard.get();
        this.sslParametersClass = r10;
        this.setUseSessionTickets = r11;
        this.setHostname = r12;
        this.getAlpnSelectedProtocol = r13;
        this.setAlpnProtocols = r14;
    }

    private boolean api23IsCleartextTrafficPermitted(String r10, Class<?> r11, Object r12) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r11.getMethod("isCleartextTrafficPermitted", null).invoke(r12, null)).booleanValue();
    L5:
        return super.isCleartextTrafficPermitted(r10);
    }

    private boolean api24IsCleartextTrafficPermitted(String r10, Class<?> r11, Object r12) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r11.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r12, new Object[]{r10})).booleanValue();
    L5:
        return api23IsCleartextTrafficPermitted(r10, r11, r12);
    }

    public static Platform buildIfSupported() {
        Class<?> r10 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L5
    L4:
        Class<?> r11 = r10;
        OptionalMethod r12 = new OptionalMethod(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L12
        OptionalMethod r13 = new OptionalMethod(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L12
        if (supportsAlpn() == false) goto L9;
        OptionalMethod r14 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L12
        OptionalMethod r15 = new OptionalMethod(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L12
    L10:
        return new AndroidPlatform(r11, r12, r13, r14, r15);
    L9:
        r14 = null;
        r15 = null;
        goto L10
    L12:
        return null;
    L5:
        r10 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L12
        goto L4
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
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r10) {
        Class<?> r11 = Class.forName("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L5
        return new AndroidCertificateChainCleaner(r11.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r10}), r11.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L6:
        return super.buildCertificateChainCleaner(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager r10) {
        Method r11 = r10.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r11.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new AndroidTrustRootIndex(r10, r11);
    L5:
        return super.buildTrustRootIndex(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r10, String r11, List<Protocol> r12) {
        if (r11 == null) goto L4;
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(r10, new Object[]{Boolean.TRUE});
        this.setHostname.invokeOptionalWithoutCheckedException(r10, new Object[]{r11});
    L4:
        OptionalMethod<Socket> r13 = this.setAlpnProtocols;
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.isSupported(r10) == false) goto L11;
        Object[] r14 = {Platform.concatLengthPrefixed(r12)};
        this.setAlpnProtocols.invokeWithoutCheckedException(r10, r14);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket r10, InetSocketAddress r11, int r12) throws IOException {
        r10.connect(r11, r12);     // Catch: Exception -> L5 ClassCastException -> L8 SecurityException -> L10 AssertionError -> L13
        return;
    L13:
        e = move-exception;
        if (Util.isAndroidGetsocknameError(e) == true) goto L17;
        throw e;
    L17:
        throw new IOException(e);
    L8:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        IOException r13 = new IOException("Exception in connect");
        r13.initCause(e);
        throw r13;
    L5:
        e = move-exception;
        IOException r14 = new IOException("Exception in connect");
        r14.initCause(e);
        throw r14;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r10) {
        OptionalMethod<Socket> r11 = this.getAlpnSelectedProtocol;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.isSupported(r10) == true) goto L8;
        return null;
    L8:
        byte[] r12 = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(r10, new Object[0]);
        if (r12 != null) goto L11;
        return null;
    L11:
        return new String(r12, Util.UTF_8);
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String r10) {
        return this.closeGuard.createAndOpen(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String r10) {
        Class<?> r11 = Class.forName("android.security.NetworkSecurityPolicy");     // Catch: Throwable -> L4 Throwable -> L7
        return api24IsCleartextTrafficPermitted(r10, r11, r11.getMethod("getInstance", null).invoke(null, null));
    L4:
        e = move-exception;
        throw Util.assertionError("unable to determine cleartext support", e);
    L8:
        return super.isCleartextTrafficPermitted(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int r10, String r11, Throwable r12) {
        int r13 = 5;
        if (r10 == 5) goto L7;
        r13 = 3;
    L7:
        if (r12 == null) goto L9;
        r11 = r11 + '\n' + Log.getStackTraceString(r12);
    L9:
        int r14 = r11.length();
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L19;
        int r16 = r11.indexOf(10, r15);
        if (r16 != (-1)) goto L15;
        r16 = r14;
    L15:
        int r17 = Math.min(r16, r15 + MAX_LOG_LENGTH);
        Log.println(r13, "OkHttp", r11.substring(r15, r17));
        if (r17 >= r16) goto L17;
        r15 = r17;
        goto L15
    L17:
        r15 = r17 + 1;
        goto L10
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String r10, Object r11) {
        if (this.closeGuard.warnIfOpen(r11) == true) goto L6;
        log(5, r10, null);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r10) {
        Object r11 = Platform.readFieldOrNull(r10, this.sslParametersClass, "sslParameters");
        if (r11 == null) goto L13;
    L8:
        X509TrustManager r12 = (X509TrustManager) Platform.readFieldOrNull(r11, X509TrustManager.class, "x509TrustManager");
        if (r12 == null) goto L12;
        return r12;
    L12:
        return (X509TrustManager) Platform.readFieldOrNull(r11, X509TrustManager.class, "trustManager");
    L13:
        r11 = Platform.readFieldOrNull(r10, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r10.getClass().getClassLoader()), "sslParameters");     // Catch: ClassNotFoundException -> L6
    L7:
        return super.trustManager(r10);
    }
}
