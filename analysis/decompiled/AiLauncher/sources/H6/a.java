package H6;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import tb.z;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: H6.a$a, reason: collision with other inner class name */
    public class C0046a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static z a() throws KeyManagementException {
        try {
            SSLContext.getInstance("SSL").init(null, new TrustManager[]{new C0046a()}, new SecureRandom());
        } catch (KeyManagementException e10) {
            e10.printStackTrace();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
        }
        return new z.a().U(true).g(30L, TimeUnit.SECONDS).d();
    }
}
