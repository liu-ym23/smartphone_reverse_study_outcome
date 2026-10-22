package K4;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.f;

/* loaded from: classes.dex */
public abstract class c {
    public static c b(X509TrustManager x509TrustManager) {
        return f.get().buildCertificateChainCleaner(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str);
}
