package Fb;

import Fb.i;
import La.C0953c;
import La.D;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u000bB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u001c\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019¨\u0006!"}, d2 = {"LFb/f;", "LFb/j;", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;)V", "", Const.INTENT_KEY_PKGNAME, "()Z", "sslSocket", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "LY8/t;", "f", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "c", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "setUseSessionTickets", "kotlin.jvm.PlatformType", "setHostname", Const.INTENT_KEY_UMID, "getAlpnSelectedProtocol", "e", "setAlpnProtocols", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class f implements j {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    public static final i.a f2747g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Class<? super SSLSocket> sslSocketClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Method setUseSessionTickets;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Method setHostname;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Method getAlpnSelectedProtocol;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Method setAlpnProtocols;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LFb/f$a;", "", "<init>", "()V", "", "packageName", "LFb/i$a;", "c", "(Ljava/lang/String;)LFb/i$a;", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "LFb/f;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;)LFb/f;", "playProviderFactory", "LFb/i$a;", Const.INTENT_KEY_UMID, "()LFb/i$a;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Fb.f$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Fb/f$a$a", "LFb/i$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "LFb/j;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSocket;)LFb/j;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: Fb.f$a$a, reason: collision with other inner class name */
        public static final class C0035a implements i.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f2753a;

            public C0035a(String str) {
                this.f2753a = str;
            }

            @Override // Fb.i.a
            public boolean a(SSLSocket sslSocket) {
                p.i(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                p.h(name, "getName(...)");
                return D.X(name, this.f2753a + '.', false, 2, null);
            }

            @Override // Fb.i.a
            public j b(SSLSocket sslSocket) {
                p.i(sslSocket, "sslSocket");
                return f.INSTANCE.b(sslSocket.getClass());
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final f b(Class<? super SSLSocket> actualSSLSocketClass) {
            Class<? super SSLSocket> superclass = actualSSLSocketClass;
            while (superclass != null && !p.d(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + actualSSLSocketClass);
                }
            }
            p.f(superclass);
            return new f(superclass);
        }

        public final i.a c(String packageName) {
            p.i(packageName, "packageName");
            return new C0035a(packageName);
        }

        public final i.a d() {
            return f.f2747g;
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f2747g = companion.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> sslSocketClass) throws NoSuchMethodException, SecurityException {
        p.i(sslSocketClass, "sslSocketClass");
        this.sslSocketClass = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        p.h(declaredMethod, "getDeclaredMethod(...)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = sslSocketClass.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // Fb.j
    public boolean a(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
    }

    @Override // Fb.j
    public boolean b() {
        return okhttp3.internal.platform.b.INSTANCE.c();
    }

    @Override // Fb.j
    public String c(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, null);
            if (bArr != null) {
                return new String(bArr, C0953c.UTF_8);
            }
            return null;
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if ((cause instanceof NullPointerException) && p.d(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e11);
        }
    }

    @Override // Fb.j
    public void f(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p.i(sslSocket, "sslSocket");
        p.i(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.setUseSessionTickets.invoke(sslSocket, Boolean.TRUE);
                this.setAlpnProtocols.invoke(sslSocket, okhttp3.internal.platform.c.INSTANCE.c(protocols));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
