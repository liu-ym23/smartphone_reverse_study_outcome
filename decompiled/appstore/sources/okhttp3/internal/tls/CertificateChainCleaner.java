package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CertificateChainCleaner {
    public CertificateChainCleaner() {
    }

    public static CertificateChainCleaner get(X509TrustManager r10) {
        return Platform.get().buildCertificateChainCleaner(r10);
    }

    public abstract List<Certificate> clean(List<Certificate> r10, String r11) throws SSLPeerUnverifiedException;

    public static CertificateChainCleaner get(X509Certificate... r10) {
        return new BasicCertificateChainCleaner(new BasicTrustRootIndex(r10));
    }
}
