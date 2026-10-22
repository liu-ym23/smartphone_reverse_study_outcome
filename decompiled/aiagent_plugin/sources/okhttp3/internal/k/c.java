package okhttp3.internal.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: CertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40153b = null;

    /* JADX INFO: compiled from: CertificateChainCleaner.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(X509TrustManager r2) {
            X509TrustManager r1 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r2, X509TrustManager.class, "com.obric.aiagent.plugin");
            o.e(r1, "trustManager");
            return okhttp3.internal.i.h.f40147b.a().a(r1);
        }
    }

    static {
        f40153b = new a(null);
    }

    public abstract List<Certificate> a(List<? extends Certificate> r1, String r2);

    public c() {
    }
}
