package okhttp3.internal.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: compiled from: OpenJSSEPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40143a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f40144d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f40145c;

    /* JADX INFO: compiled from: OpenJSSEPlatform.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            return g.c();
        }

        public final g b() {
            d.h.b.h r0 = null;
            if (a() == true) goto L5;
            return null;
        L5:
            return new g(r0);
        }
    }

    public /* synthetic */ g(d.h.b.h r1) {
        this();
    }

    private g() {
        this.f40145c = (Provider) ZeusTransformUtils.preCheckCast(new OpenJSSE(), Provider.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ boolean c() {
        return f40144d;
    }

    @Override // okhttp3.internal.i.h
    public SSLContext z_() {
        SSLContext r1 = SSLContext.getInstance("TLSv1.3", this.f40145c);
        o.c(r1, "getInstance(\"TLSv1.3\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.i.h
    public X509TrustManager b() {
        TrustManagerFactory r4 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f40145c);
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

    @Override // okhttp3.internal.i.h
    public X509TrustManager a(SSLSocketFactory r1) {
        o.e(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    @Override // okhttp3.internal.i.h
    public void a(SSLSocket r3, String r4, List<aa> r5) {
        List<aa> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "sslSocket");
        o.e(r6, "protocols");
        if (ZeusTransformUtils.instanceOf(r3, org.openjsse.javax.net.ssl.SSLSocket.class) == false) goto L7;
        SSLParameters r2 = ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r3, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.aiagent.plugin")).getSSLParameters();
        if (ZeusTransformUtils.instanceOf(r2, org.openjsse.javax.net.ssl.SSLParameters.class) == false) goto L9;
        List<String> r7 = h.f40147b.a(r6);
        ((org.openjsse.javax.net.ssl.SSLParameters) ZeusTransformUtils.preCheckCast(r2, org.openjsse.javax.net.ssl.SSLParameters.class, "com.obric.aiagent.plugin")).setApplicationProtocols((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r3, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.aiagent.plugin")).setSSLParameters(r2);
        return;
    L9:
        return;
    L7:
        super.a(r3, r4, r6);
    }

    @Override // okhttp3.internal.i.h
    public String a(SSLSocket r2) {
        o.e(r2, "sslSocket");
        if (ZeusTransformUtils.instanceOf(r2, org.openjsse.javax.net.ssl.SSLSocket.class) == false) goto L11;
        String r1 = ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r2, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.aiagent.plugin")).getApplicationProtocol();
        if (r1 != null) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return null;
    L12:
        return r1;
    L7:
        r3 = o.a(r1, "");
        goto L8
    L11:
        return super.a(r2);
    }

    static {
        a r0 = new a(null);
        f40143a = r0;
        boolean r1 = false;
        Class.forName("org.openjsse.net.ssl.OpenJSSE", false, r0.getClass().getClassLoader());     // Catch: ClassNotFoundException -> L7
        r1 = true;
    L5:
        f40144d = r1;
    }
}
