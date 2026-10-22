package okhttp3.internal.platform;

import Fb.f;
import Fb.g;
import Fb.h;
import Fb.j;
import Ib.e;
import Z8.C1173v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
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

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010)J)\u0010.\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00122\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/R$\u00106\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b1\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002070\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00108¨\u0006;"}, d2 = {"Lokhttp3/internal/platform/a;", "Lokhttp3/internal/platform/c;", "LEb/a;", "<init>", "()V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "LIb/e;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)LIb/e;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "LY8/t;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "closer", "", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "message", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "LIb/c;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)LIb/c;", "", "level", "", "t", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "(Ljava/lang/String;ILjava/lang/Throwable;)V", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "LFb/j;", "Ljava/util/List;", "socketAdapters", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a extends c implements Eb.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f37732d = c.INSTANCE.f();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context applicationContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<j> socketAdapters;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lokhttp3/internal/platform/a$a;", "", "<init>", "()V", "Lokhttp3/internal/platform/c;", Const.INTENT_KEY_APIKEY, "()Lokhttp3/internal/platform/c;", "", "isSupported", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.platform.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final c a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f37732d;
        }

        public Companion() {
        }
    }

    public a() {
        List listR = C1173v.r(Fb.a.INSTANCE.a(), new Fb.i(f.INSTANCE.d()), new Fb.i(h.INSTANCE.b()), new Fb.i(g.INSTANCE.a()));
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
    public e buildTrustRootIndex(X509TrustManager trustManager) {
        p.i(trustManager, "trustManager");
        StrictMode.noteSlowCall("buildTrustRootIndex");
        return super.buildTrustRootIndex(trustManager);
    }

    @Override // okhttp3.internal.platform.c
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) {
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
    public Object getStackTraceForCloseable(String closer) {
        p.i(closer, "closer");
        CloseGuard closeGuard = new CloseGuard();
        closeGuard.open(closer);
        return closeGuard;
    }

    @Override // okhttp3.internal.platform.c
    @SuppressLint({"NewApi"})
    public boolean isCleartextTrafficPermitted(String hostname) {
        p.i(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.c
    public void log(String message, int level, Throwable t10) {
        p.i(message, "message");
        if (level == 5) {
            Log.w(b.INSTANCE.b(), message, t10);
        } else {
            Log.i(b.INSTANCE.b(), message, t10);
        }
    }

    @Override // okhttp3.internal.platform.c
    public void logCloseableLeak(String message, Object stackTrace) {
        p.i(message, "message");
        p.g(stackTrace, "null cannot be cast to non-null type android.util.CloseGuard");
        ((CloseGuard) stackTrace).warnIfOpen();
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
