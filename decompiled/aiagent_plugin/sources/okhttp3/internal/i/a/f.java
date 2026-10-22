package okhttp3.internal.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;

/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40102a = null;
    private static final j.a g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? super SSLSocket> f40103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f40104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f40105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f40106e;
    private final Method f;

    /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
    public static final class a {

        /* JADX INFO: renamed from: okhttp3.internal.i.a.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
        public static final class C1085a implements j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f40107a;

            C1085a(String r1) {
                this.f40107a = r1;
            }

            @Override // okhttp3.internal.i.a.j.a
            public boolean a(SSLSocket r4) {
                o.e(r4, "sslSocket");
                String r5 = r4.getClass().getName();
                o.c(r5, "sslSocket.javaClass.name");
                return d.o.o.b(r5, this.f40107a + '.', false, 2, null);
            }

            @Override // okhttp3.internal.i.a.j.a
            public k b(SSLSocket r2) {
                o.e(r2, "sslSocket");
                return (k) ZeusTransformUtils.preCheckCast(a.a(f.f40102a, r2.getClass()), k.class, "com.obric.aiagent.plugin");
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ f a(a r0, Class r1) {
            return r0.a(r1);
        }

        public final j.a a() {
            return f.b();
        }

        private final f a(Class<? super SSLSocket> r3) {
            Class<? super SSLSocket> r2 = r3;
        L3:
            if (r2 == null) goto L11;
            if (o.a(r2.getSimpleName(), "OpenSSLSocketImpl") == true) goto L11;
            r2 = r2.getSuperclass();
            if (r2 != null) goto L3;
            throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + r3);
        L11:
            o.a(r2);
            return new f(r2);
        }

        public final j.a a(String r2) {
            o.e(r2, "packageName");
            return (j.a) ZeusTransformUtils.preCheckCast(new C1085a(r2), j.a.class, "com.obric.aiagent.plugin");
        }
    }

    public f(Class<? super SSLSocket> r5) {
        o.e(r5, "sslSocketClass");
        this.f40103b = r5;
        Method r1 = r5.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        o.c(r1, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f40104c = r1;
        this.f40105d = r5.getMethod("setHostname", new Class[]{String.class});
        this.f40106e = r5.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f = r5.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ j.a b() {
        return g;
    }

    @Override // okhttp3.internal.i.a.k
    public X509TrustManager a(SSLSocketFactory r1) {
        return k.a.a(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean b(SSLSocketFactory r1) {
        return k.a.b(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a() {
        return okhttp3.internal.i.b.f40121a.a();
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a(SSLSocket r2) {
        o.e(r2, "sslSocket");
        return ZeusTransformUtils.instanceOf(this.f40103b, r2);
    }

    @Override // okhttp3.internal.i.a.k
    public void a(SSLSocket r6, String r7, List<? extends aa> r8) {
        List<? extends aa> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "sslSocket");
        o.e(r9, "protocols");
        if (a(r6) == true) goto L16;
        return;
    L16:
        this.f40104c.invoke(r6, new Object[]{true});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        if (r7 == null) goto L7;
        this.f40105d.invoke(r6, new Object[]{r7});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L7:
        this.f.invoke(r6, new Object[]{okhttp3.internal.i.h.f40147b.b(r9)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L18:
        return;
    L12:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.i.a.k
    public String b(SSLSocket r4) {
        o.e(r4, "sslSocket");
        if (a(r4) == true) goto L20;
        return null;
    L20:
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(this.f40106e.invoke(r4, new Object[0]), byte[].class, "com.obric.aiagent.plugin");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L17
        if (r3 == null) goto L14;
    L22:
        return new String(r3, d.o.d.f38623b);
    L14:
        return null;
    L17:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        Throwable r5 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r5, NullPointerException.class) == false) goto L16;
        if (o.a(((NullPointerException) ZeusTransformUtils.preCheckCast(r5, NullPointerException.class, "com.obric.aiagent.plugin")).getMessage(), "ssl == null") == false) goto L16;
        return null;
    L16:
        throw new AssertionError(e);
    }

    static {
        a r0 = new a(null);
        f40102a = r0;
        g = r0.a("com.google.android.gms.org.conscrypt");
    }
}
