package okhttp3.internal.platform;

import C4.B;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
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

/* loaded from: classes.dex */
class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f19081a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f19082b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f19083c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f19084d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f19085e;

    /* renamed from: f, reason: collision with root package name */
    private final Method f19086f;

    /* renamed from: g, reason: collision with root package name */
    private final C0228b f19087g = C0228b.b();

    static final class a extends K4.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f19088a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f19089b;

        a(Object obj, Method method) {
            this.f19088a = obj;
            this.f19089b = method;
        }

        @Override // K4.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f19089b.invoke(this.f19088a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (InvocationTargetException e7) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e7.getMessage());
                sSLPeerUnverifiedException.initCause(e7);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: okhttp3.internal.platform.b$b, reason: collision with other inner class name */
    static final class C0228b {

        /* renamed from: a, reason: collision with root package name */
        private final Method f19090a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f19091b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f19092c;

        C0228b(Method method, Method method2, Method method3) {
            this.f19090a = method;
            this.f19091b = method2;
            this.f19092c = method3;
        }

        static C0228b b() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C0228b(method3, method2, method);
        }

        Object a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f19090a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, null);
                    this.f19091b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f19092c.invoke(obj, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    static final class c implements K4.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f19093a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f19094b;

        c(X509TrustManager x509TrustManager, Method method) {
            this.f19094b = method;
            this.f19093a = x509TrustManager;
        }

        @Override // K4.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f19094b.invoke(this.f19093a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e6) {
                throw new AssertionError("unable to get issues and signature", e6);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f19093a.equals(cVar.f19093a) && this.f19094b.equals(cVar.f19094b);
        }

        public int hashCode() {
            return this.f19093a.hashCode() + (this.f19094b.hashCode() * 31);
        }
    }

    b(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f19081a = cls;
        this.f19082b = cls2;
        this.f19083c = method;
        this.f19084d = method2;
        this.f19085e = method3;
        this.f19086f = method4;
    }

    private boolean a(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.a(str, cls, obj);
        }
    }

    @Nullable
    public static f c() {
        if (!f.isAndroid()) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            try {
                return new b(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", null), cls2.getMethod("setAlpnProtocols", byte[].class));
            } catch (NoSuchMethodException unused) {
                throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    @Override // okhttp3.internal.platform.f
    public K4.c buildCertificateChainCleaner(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.f
    public K4.e buildTrustRootIndex(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.f
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<B> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f19082b.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f19083c.invoke(sSLSocket, Boolean.TRUE);
                    this.f19084d.invoke(sSLSocket, str);
                } catch (IllegalAccessException | InvocationTargetException e6) {
                    throw new AssertionError(e6);
                }
            }
            this.f19086f.invoke(sSLSocket, f.concatLengthPrefixed(list));
        }
    }

    @Override // okhttp3.internal.platform.f
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i5) throws IOException {
        try {
            socket.connect(inetSocketAddress, i5);
        } catch (AssertionError e6) {
            if (!D4.e.A(e6)) {
                throw e6;
            }
            throw new IOException(e6);
        } catch (ClassCastException e7) {
            throw e7;
        }
    }

    @Override // okhttp3.internal.platform.f
    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e6) {
            throw new IllegalStateException("No TLS provider", e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        if (!this.f19082b.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f19085e.invoke(sSLSocket, null);
            if (bArr != null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public Object getStackTraceForCloseable(String str) {
        return this.f19087g.a(str);
    }

    @Override // okhttp3.internal.platform.f
    public boolean isCleartextTrafficPermitted(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e6) {
            throw new AssertionError("unable to determine cleartext support", e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    public void log(int i5, String str, @Nullable Throwable th) {
        int iMin;
        int i6 = i5 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int iIndexOf = str.indexOf(10, i7);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i7 + 4000);
                Log.println(i6, "OkHttp", str.substring(i7, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i7 = iMin;
                }
            }
            i7 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.platform.f
    public void logCloseableLeak(String str, Object obj) {
        if (this.f19087g.c(obj)) {
            return;
        }
        log(5, str, null);
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    protected X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object fieldOrNull = f.readFieldOrNull(sSLSocketFactory, this.f19081a, "sslParameters");
        if (fieldOrNull == null) {
            try {
                fieldOrNull = f.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) f.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) f.readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
    }
}
