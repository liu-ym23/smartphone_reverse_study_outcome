package okhttp3.internal.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40118b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f40119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f40120d;

    /* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ k a(a r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "com.android.org.conscrypt";
        L6:
            return r0.a(r1);
        }

        public final k a(String r5) {
            o.e(r5, "packageName");
            Class r0 = ZeusTransformUtils.forName(r5 + ".OpenSSLSocketImpl", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            o.a(r0, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");     // Catch: Exception -> L5
            Class r1 = ZeusTransformUtils.forName(r5 + ".OpenSSLSocketFactoryImpl", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            o.a(r1, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");     // Catch: Exception -> L5
            Class r6 = ZeusTransformUtils.forName(r5 + ".SSLParametersImpl", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            o.c(r6, "paramsClass");     // Catch: Exception -> L5
            return (k) ZeusTransformUtils.preCheckCast(new l(r0, r1, r6), k.class, "com.obric.aiagent.plugin");
        L5:
            e = move-exception;
            okhttp3.internal.i.h.f40147b.a().a("unable to load android socket classes", 5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }
    }

    static {
        f40118b = new a(null);
    }

    public l(Class<? super SSLSocket> r2, Class<? super SSLSocketFactory> r3, Class<?> r4) {
        o.e(r2, "sslSocketClass");
        o.e(r3, "sslSocketFactoryClass");
        o.e(r4, "paramClass");
        super(r2);
        this.f40119c = r3;
        this.f40120d = r4;
    }

    @Override // okhttp3.internal.i.a.f, okhttp3.internal.i.a.k
    public boolean b(SSLSocketFactory r2) {
        o.e(r2, "sslSocketFactory");
        return ZeusTransformUtils.instanceOf(this.f40119c, r2);
    }

    @Override // okhttp3.internal.i.a.f, okhttp3.internal.i.a.k
    public X509TrustManager a(SSLSocketFactory r3) {
        o.e(r3, "sslSocketFactory");
        Object r2 = okhttp3.internal.c.a(r3, this.f40120d, "sslParameters");
        o.a(r2);
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.preCheckCast(okhttp3.internal.c.a(r2, X509TrustManager.class, "x509TrustManager"), X509TrustManager.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(okhttp3.internal.c.a(r2, X509TrustManager.class, "trustManager"), X509TrustManager.class, "com.obric.aiagent.plugin");
    }
}
