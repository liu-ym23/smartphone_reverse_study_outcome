package okhttp3.internal.platform;

import Fb.f;
import Fb.g;
import Fb.h;
import Fb.j;
import Fb.k;
import Ib.e;
import Z8.C1173v;
import android.content.Context;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u000253B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010+J)\u00100\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101R$\u00108\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b3\u00107R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002090\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010:¨\u0006="}, d2 = {"Lokhttp3/internal/platform/b;", "Lokhttp3/internal/platform/c;", "LEb/a;", "<init>", "()V", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", Const.JSON_KEY_ADDRESS, "", "connectTimeout", "LY8/t;", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "LIb/c;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)LIb/c;", "LIb/e;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)LIb/e;", "getHandshakeServerNames", "(Ljavax/net/ssl/SSLSocket;)Ljava/util/List;", "message", "level", "", "t", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "(Ljava/lang/String;ILjava/lang/Throwable;)V", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "LFb/j;", "Ljava/util/List;", "socketAdapters", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b extends c implements Eb.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final String f37736d = "OkHttp";

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f37737e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context applicationContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<j> socketAdapters;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/platform/b$a;", "", "<init>", "()V", "Lokhttp3/internal/platform/c;", Const.INTENT_KEY_APIKEY, "()Lokhttp3/internal/platform/c;", "", "Tag", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "", "isSupported", "Z", "c", "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.platform.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final c a() {
            if (c()) {
                return new b();
            }
            return null;
        }

        public final String b() {
            return b.f37736d;
        }

        public final boolean c() {
            return b.f37737e;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/b$b;", "LIb/e;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "Ljava/security/cert/X509Certificate;", "cert", Const.INTENT_KEY_APIKEY, "(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljavax/net/ssl/X509TrustManager;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/reflect/Method;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.platform.b$b, reason: collision with other inner class name and from toString */
    public static final /* data */ class CustomTrustRootIndex implements e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final X509TrustManager trustManager;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Method findByIssuerAndSignatureMethod;

        public CustomTrustRootIndex(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            p.i(trustManager, "trustManager");
            p.i(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.trustManager = trustManager;
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        }

        @Override // Ib.e
        public X509Certificate a(X509Certificate cert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            p.i(cert, "cert");
            try {
                Object objInvoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, cert);
                p.g(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) other;
            return p.d(this.trustManager, customTrustRootIndex.trustManager) && p.d(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        public int hashCode() {
            return (this.trustManager.hashCode() * 31) + this.findByIssuerAndSignatureMethod.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        c.INSTANCE.f();
        f37737e = false;
    }

    public b() {
        List listR = C1173v.r(k.Companion.b(k.INSTANCE, null, 1, null), new Fb.i(f.INSTANCE.d()), new Fb.i(h.INSTANCE.b()), new Fb.i(g.INSTANCE.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((j) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // Eb.a
    public void a(Context context) {
        this.applicationContext = context;
    }

    @Override // Eb.a
    /* renamed from: b, reason: from getter */
    public Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // okhttp3.internal.platform.c
    public Ib.c buildCertificateChainCleaner(X509TrustManager trustManager) {
        p.i(trustManager, "trustManager");
        Fb.b bVarA = Fb.b.INSTANCE.a(trustManager);
        return bVarA != null ? bVarA : super.buildCertificateChainCleaner(trustManager);
    }

    @Override // okhttp3.internal.platform.c
    public e buildTrustRootIndex(X509TrustManager trustManager) throws NoSuchMethodException, SecurityException {
        p.i(trustManager, "trustManager");
        try {
            StrictMode.noteSlowCall("buildTrustRootIndex");
            Method declaredMethod = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            p.f(declaredMethod);
            return new CustomTrustRootIndex(trustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.c
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) {
        Object next;
        p.i(sslSocket, "sslSocket");
        p.i(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((j) next).a(sslSocket)) {
                    break;
                }
            }
        }
        j jVar = (j) next;
        if (jVar != null) {
            jVar.f(sslSocket, hostname, protocols);
        }
    }

    @Override // okhttp3.internal.platform.c
    public void connectSocket(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        p.i(socket, "socket");
        p.i(address, "address");
        socket.connect(address, connectTimeout);
    }

    @Override // okhttp3.internal.platform.c
    public List<String> getHandshakeServerNames(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        return super.getHandshakeServerNames(sslSocket);
    }

    @Override // okhttp3.internal.platform.c
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Object next;
        p.i(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((j) next).a(sslSocket)) {
                break;
            }
        }
        j jVar = (j) next;
        if (jVar != null) {
            return jVar.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.c
    public boolean isCleartextTrafficPermitted(String hostname) {
        p.i(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.c
    public void log(String message, int level, Throwable t10) {
        p.i(message, "message");
        if (level == 5) {
            Log.w(f37736d, message, t10);
        } else {
            Log.i(f37736d, message, t10);
        }
    }

    @Override // okhttp3.internal.platform.c
    public SSLContext newSSLContext() {
        StrictMode.noteSlowCall("newSSLContext");
        return super.newSSLContext();
    }

    @Override // okhttp3.internal.platform.c
    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Object next;
        p.i(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((j) next).e(sslSocketFactory)) {
                break;
            }
        }
        j jVar = (j) next;
        if (jVar != null) {
            return jVar.d(sslSocketFactory);
        }
        return null;
    }
}
