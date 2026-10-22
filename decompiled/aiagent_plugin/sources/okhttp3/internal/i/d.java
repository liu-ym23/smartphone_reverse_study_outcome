package okhttp3.internal.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40130a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f40131d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f40132c;

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            return d.c();
        }

        public final d b() {
            d.h.b.h r0 = null;
            if (a() == true) goto L5;
            return null;
        L5:
            return new d(r0);
        }

        public final boolean a(int r4, int r5, int r6) {
            Conscrypt.Version r3 = Conscrypt.version();
            if (r3.major() == r4) goto L10;
            if (r3.major() <= r4) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (r3.minor() == r5) goto L17;
            if (r3.minor() <= r5) goto L15;
            return true;
        L15:
            return false;
        L17:
            if (r3.patch() < r6) goto L20;
            return true;
        L20:
            return false;
        }
    }

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class b implements ConscryptHostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f40133a = null;

        static {
            f40133a = new b();
        }

        private b() {
        }
    }

    public /* synthetic */ d(d.h.b.h r1) {
        this();
    }

    @Override // okhttp3.internal.i.h
    public X509TrustManager a(SSLSocketFactory r1) {
        o.e(r1, "sslSocketFactory");
        return null;
    }

    private d() {
        Provider r0 = Conscrypt.newProvider();
        o.c(r0, "newProvider()");
        this.f40132c = r0;
    }

    public static final /* synthetic */ boolean c() {
        return f40131d;
    }

    @Override // okhttp3.internal.i.h
    public SSLContext z_() {
        SSLContext r1 = SSLContext.getInstance("TLS", this.f40132c);
        o.c(r1, "getInstance(\"TLS\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.i.h
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
        X509TrustManager r7 = (X509TrustManager) ZeusTransformUtils.preCheckCast(r6, X509TrustManager.class, "com.obric.aiagent.plugin");
        Conscrypt.setHostnameVerifier((TrustManager) ZeusTransformUtils.preCheckCast(r7, TrustManager.class, "com.obric.aiagent.plugin"), (ConscryptHostnameVerifier) ZeusTransformUtils.preCheckCast(b.f40133a, ConscryptHostnameVerifier.class, "com.obric.aiagent.plugin"));
        return r7;
    L11:
        StringBuilder r0 = new StringBuilder().append("Unexpected default trust managers: ");
        String r8 = Arrays.toString(r5);
        o.c(r8, "toString(this)");
        throw new IllegalStateException(r0.append(r8).toString().toString());
    L5:
        if (ZeusTransformUtils.instanceOf(r5[0], X509TrustManager.class) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.i.h
    public void a(SSLSocket r3, String r4, List<aa> r5) {
        List<aa> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "sslSocket");
        o.e(r6, "protocols");
        if (Conscrypt.isConscrypt(r3) == false) goto L5;
        Conscrypt.setUseSessionTickets(r3, true);
        Conscrypt.setApplicationProtocols(r3, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(h.f40147b.a(r6), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        return;
    L5:
        super.a(r3, r4, r6);
    }

    @Override // okhttp3.internal.i.h
    public String a(SSLSocket r2) {
        o.e(r2, "sslSocket");
        if (Conscrypt.isConscrypt(r2) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r2);
    L6:
        return super.a(r2);
    }

    @Override // okhttp3.internal.i.h
    public SSLSocketFactory c(X509TrustManager r3) {
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r4, "trustManager");
        SSLContext r2 = z_();
        r2.init(null, new TrustManager[]{r4}, null);
        SSLSocketFactory r5 = r2.getSocketFactory();
        o.c(r5, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return r5;
    }

    static {
        a r0 = new a(null);
        f40130a = r0;
        boolean r1 = false;
        Class.forName("org.conscrypt.Conscrypt$Version", false, r0.getClass().getClassLoader());     // Catch: Throwable -> L10
        if (Conscrypt.isAvailable() == false) goto L8;
        if (r0.a(2, 1, 0) == false) goto L8;
        r1 = true;
    L8:
        f40131d = r1;
    }
}
