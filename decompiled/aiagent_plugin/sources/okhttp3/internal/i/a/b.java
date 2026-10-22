package okhttp3.internal.i.a;

import android.net.http.X509TrustManagerExtensions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends okhttp3.internal.k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40095a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X509TrustManager f40096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final X509TrustManagerExtensions f40097d;

    /* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final b a(X509TrustManager r2) {
            X509TrustManager r1 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r2, X509TrustManager.class, "com.obric.aiagent.plugin");
            o.e(r1, "trustManager");
            X509TrustManagerExtensions r0 = new X509TrustManagerExtensions(r1);     // Catch: IllegalArgumentException -> L5
        L6:
            if (r0 != null) goto L8;
            return null;
        L8:
            return new b(r1, r0);
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        f40095a = new a(null);
    }

    public b(X509TrustManager r3, X509TrustManagerExtensions r4) {
        X509TrustManager r5 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r5, "trustManager");
        o.e(r4, "x509TrustManagerExtensions");
        this.f40096c = r5;
        this.f40097d = r4;
    }

    @Override // okhttp3.internal.k.c
    public List<Certificate> a(List<? extends Certificate> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "chain");
        o.e(r4, "hostname");
        X509Certificate[] r6 = (X509Certificate[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).toArray(new X509Certificate[0]), X509Certificate[].class, "com.obric.aiagent.plugin");
        List<X509Certificate> r2 = this.f40097d.checkServerTrusted(r6, "RSA", r4);     // Catch: CertificateException -> L5
        o.c(r2, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");     // Catch: CertificateException -> L5
        return r2;
    L5:
        e = move-exception;
        SSLPeerUnverifiedException r7 = new SSLPeerUnverifiedException(e.getMessage());
        r7.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).f40096c != this.f40096c) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f40096c);
    }
}
