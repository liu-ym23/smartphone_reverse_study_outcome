package okhttp3.internal.i;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.z;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f40146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f40148c = null;

    /* JADX INFO: compiled from: Platform.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ h a(a r0) {
            return r0.f();
        }

        public final h a() {
            return h.e();
        }

        public final List<String> a(List<? extends aa> r5) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "protocols");
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            Object r1 = r8.next();
            if (((aa) ZeusTransformUtils.preCheckCast(r1, aa.class, "com.obric.aiagent.plugin")) == aa.f39694b) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
            r7.add(r1);
            goto L4
        L8:
            r2 = false;
            goto L9
        L11:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r11 = r9.iterator();
        L13:
            if (r11.hasNext() == false) goto L16;
            r10.add(((aa) ZeusTransformUtils.preCheckCast(r11.next(), aa.class, "com.obric.aiagent.plugin")).toString());
            goto L13
        L16:
            return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        }

        public final boolean b() {
            return o.a("Dalvik", System.getProperty("java.vm.name"));
        }

        private final boolean c() {
            return o.a("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean d() {
            return o.a("OpenJSSE", Security.getProviders()[0].getName());
        }

        private final boolean e() {
            return o.a("BC", Security.getProviders()[0].getName());
        }

        private final h f() {
            if (b() == false) goto L6;
            return g();
        L6:
            return h();
        }

        private final h g() {
            okhttp3.internal.i.a.c.f40098a.a();
            h r0 = okhttp3.internal.i.a.f40091a.b();
            if (r0 != null) goto L6;
            h r1 = b.f40121a.b();
            o.a(r1);
            return r1;
        L6:
            return r0;
        }

        private final h h() {
            if (c() == false) goto L9;
            d r0 = d.f40130a.b();
            if (r0 == null) goto L9;
            return (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.aiagent.plugin");
        L9:
            if (e() == false) goto L15;
            c r1 = c.f40127a.b();
            if (r1 == null) goto L15;
            return (h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.aiagent.plugin");
        L15:
            if (d() == false) goto L20;
            g r2 = g.f40143a.b();
            if (r2 == null) goto L20;
            return (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        L20:
            f r3 = f.f40141a.b();
            if (r3 != null) goto L23;
            h r4 = e.f40134a.a();
            if (r4 == null) goto L28;
            return r4;
        L28:
            return new h();
        L23:
            return (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        }

        public final byte[] b(List<? extends aa> r4) {
            List<? extends aa> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "protocols");
            e.e r0 = new e.e();
            Iterator<String> r3 = a(r5).iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
            r0.b(r6.length());
            r0.a(r6);
            goto L4
        L7:
            return r0.w();
        }
    }

    public String a(SSLSocket r1) {
        o.e(r1, "sslSocket");
        return null;
    }

    public void a(SSLSocket r1, String r2, List<aa> r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "sslSocket");
        o.e(r0, "protocols");
    }

    public boolean a(String r1) {
        o.e(r1, "hostname");
        return true;
    }

    public void b(SSLSocket r1) {
        o.e(r1, "sslSocket");
    }

    public final String d() {
        return "OkHttp";
    }

    public h() {
    }

    public static final /* synthetic */ h e() {
        return f40146a;
    }

    public SSLContext z_() {
        SSLContext r1 = SSLContext.getInstance("TLS");
        o.c(r1, "getInstance(\"TLS\")");
        return r1;
    }

    public X509TrustManager b() {
        TrustManagerFactory r4 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r4.init(null);
        TrustManager[] r5 = r4.getTrustManagers();
        o.a(r5);
        boolean r1 = true;
        if (r5.length == 1) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        TrustManager r6 = r5[0];
        o.a(r6, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(r6, X509TrustManager.class, "com.obric.aiagent.plugin");
    L11:
        StringBuilder r0 = new StringBuilder().append("Unexpected default trust managers: ");
        String r7 = Arrays.toString(r5);
        o.c(r7, "toString(this)");
        throw new IllegalStateException(r0.append(r7).toString().toString());
    L5:
        if (ZeusTransformUtils.instanceOf(r5[0], X509TrustManager.class) == false) goto L7;
        goto L7
    }

    public X509TrustManager a(SSLSocketFactory r4) {
        o.e(r4, "sslSocketFactory");
        Class r1 = ZeusTransformUtils.forName("sun.security.ssl.SSLContextImpl", "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        o.c(r1, "sslContextClass");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        Object r5 = okhttp3.internal.c.a(r4, r1, "context");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        if (r5 != null) goto L6;
        return null;
    L6:
        goto L18
    L13:
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(okhttp3.internal.c.a(r5, X509TrustManager.class, "trustManager"), X509TrustManager.class, "com.obric.aiagent.plugin");
    L8:
        e = move-exception;
        if (o.a(e.getClass().getName(), "java.lang.reflect.InaccessibleObjectException") == true) goto L17;
        throw e;
    L17:
        return null;
    L18:
        return null;
    }

    public void a(Socket r2, InetSocketAddress r3, int r4) {
        o.e(r2, "socket");
        o.e(r3, SensitiveType.ADDRESS);
        r2.connect((SocketAddress) ZeusTransformUtils.preCheckCast(r3, SocketAddress.class, "com.obric.aiagent.plugin"), r4);
    }

    public static /* synthetic */ void a(h r1, String r2, int r3, Throwable r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = 4;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.a(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void a(String r1, int r2, Throwable r3) {
        o.e(r1, "message");
        if (r2 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        f40148c.log(r0, r1, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public Object b(String r2) {
        o.e(r2, "closer");
        if (f40148c.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r2);
    }

    public void a(String r4, Object r5) {
        o.e(r4, "message");
        if (r5 != null) goto L5;
        r4 = r4 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L5:
        a(r4, 5, (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public okhttp3.internal.k.c a(X509TrustManager r3) {
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r4, "trustManager");
        return (okhttp3.internal.k.c) ZeusTransformUtils.preCheckCast(new okhttp3.internal.k.a(b(r4)), okhttp3.internal.k.c.class, "com.obric.aiagent.plugin");
    }

    public okhttp3.internal.k.e b(X509TrustManager r3) {
        X509TrustManager r2 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r2, "trustManager");
        X509Certificate[] r4 = r2.getAcceptedIssuers();
        o.c(r4, "trustManager.acceptedIssuers");
        return (okhttp3.internal.k.e) ZeusTransformUtils.preCheckCast(new okhttp3.internal.k.b((X509Certificate[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), X509Certificate[].class, "com.obric.aiagent.plugin")), okhttp3.internal.k.e.class, "com.obric.aiagent.plugin");
    }

    public SSLSocketFactory c(X509TrustManager r4) {
        X509TrustManager r5 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r4, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r5, "trustManager");
        SSLContext r3 = z_();     // Catch: GeneralSecurityException -> L5
        r3.init(null, new TrustManager[]{r5}, null);     // Catch: GeneralSecurityException -> L5
        SSLSocketFactory r6 = r3.getSocketFactory();     // Catch: GeneralSecurityException -> L5
        o.c(r6, "newSSLContext().apply {\n…ll)\n      }.socketFactory");     // Catch: GeneralSecurityException -> L5
        return r6;
    L5:
        e = move-exception;
        throw new AssertionError("No System TLS: " + e, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public String toString() {
        String r1 = getClass().getSimpleName();
        o.c(r1, "javaClass.simpleName");
        return r1;
    }

    static {
        a r0 = new a(null);
        f40147b = r0;
        f40146a = a.a(r0);
        f40148c = Logger.getLogger(z.class.getName());
    }
}
