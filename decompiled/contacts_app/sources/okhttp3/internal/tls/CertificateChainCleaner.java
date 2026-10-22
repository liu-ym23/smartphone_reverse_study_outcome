package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CertificateChainCleaner {
    public abstract List<Certificate> clean(List<Certificate> r1, String r2) throws SSLPeerUnverifiedException;

    public CertificateChainCleaner() {
    }

    public static CertificateChainCleaner get(X509TrustManager r1) {
        return Platform.get().buildCertificateChainCleaner(r1);
    }

    public static CertificateChainCleaner get(X509Certificate... r2) {
        return new BasicCertificateChainCleaner(new BasicTrustRootIndex(r2));
    }
}
