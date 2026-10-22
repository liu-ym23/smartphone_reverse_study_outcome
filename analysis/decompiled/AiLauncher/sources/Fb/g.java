package Fb;

import Fb.i;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LFb/g;", "LFb/j;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", Const.INTENT_KEY_PKGNAME, "()Z", "", "c", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "hostname", "", "Lokhttp3/Protocol;", "protocols", "LY8/t;", "f", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    public static final i.a f2755b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2756c;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Fb/g$a", "LFb/i$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "LFb/j;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSocket;)LFb/j;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements i.a {
        @Override // Fb.i.a
        public boolean a(SSLSocket sslSocket) {
            p.i(sslSocket, "sslSocket");
            g.INSTANCE.b();
            return false;
        }

        @Override // Fb.i.a
        public j b(SSLSocket sslSocket) {
            p.i(sslSocket, "sslSocket");
            return new g();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LFb/g$b;", "", "<init>", "()V", "LFb/i$a;", "factory", "LFb/i$a;", Const.INTENT_KEY_APIKEY, "()LFb/i$a;", "", "isSupported", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Fb.g$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final i.a a() {
            return g.f2755b;
        }

        public final boolean b() {
            return g.f2756c;
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f2755b = new a();
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, companion.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f2756c = z10;
    }

    @Override // Fb.j
    public boolean a(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        return false;
    }

    @Override // Fb.j
    public boolean b() {
        return f2756c;
    }

    @Override // Fb.j
    public String c(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || p.d(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // Fb.j
    public void f(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) {
        p.i(sslSocket, "sslSocket");
        p.i(protocols, "protocols");
        if (a(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) okhttp3.internal.platform.c.INSTANCE.b(protocols).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
