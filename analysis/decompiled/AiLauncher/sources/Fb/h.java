package Fb;

import Fb.i;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LFb/h;", "LFb/j;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", Const.INTENT_KEY_PKGNAME, "()Z", "", "c", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "hostname", "", "Lokhttp3/Protocol;", "protocols", "LY8/t;", "f", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    public static final i.a f2758b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2759c;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Fb/h$a", "LFb/i$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "LFb/j;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSocket;)LFb/j;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements i.a {
        @Override // Fb.i.a
        public boolean a(SSLSocket sslSocket) {
            p.i(sslSocket, "sslSocket");
            return h.INSTANCE.c() && Conscrypt.isConscrypt(sslSocket);
        }

        @Override // Fb.i.a
        public j b(SSLSocket sslSocket) {
            p.i(sslSocket, "sslSocket");
            return new h();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LFb/h$b;", "", "<init>", "()V", "", "major", "minor", "patch", "", Const.INTENT_KEY_APIKEY, "(III)Z", "LFb/i$a;", "factory", "LFb/i$a;", Const.INTENT_KEY_PKGNAME, "()LFb/i$a;", "isSupported", "Z", "c", "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Fb.h$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(int major, int minor, int patch) {
            Conscrypt.Version version = Conscrypt.version();
            if (version == null) {
                return false;
            }
            return version.major() != major ? version.major() > major : version.minor() != minor ? version.minor() > minor : version.patch() >= patch;
        }

        public final i.a b() {
            return h.f2758b;
        }

        public final boolean c() {
            return h.f2759c;
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f2758b = new a();
        boolean z10 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (companion.a(2, 1, 0)) {
                    z10 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f2759c = z10;
    }

    @Override // Fb.j
    public boolean a(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    @Override // Fb.j
    public boolean b() {
        return f2759c;
    }

    @Override // Fb.j
    public String c(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        if (a(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // Fb.j
    public void f(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) {
        p.i(sslSocket, "sslSocket");
        p.i(protocols, "protocols");
        if (a(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) okhttp3.internal.platform.c.INSTANCE.b(protocols).toArray(new String[0]));
        }
    }
}
