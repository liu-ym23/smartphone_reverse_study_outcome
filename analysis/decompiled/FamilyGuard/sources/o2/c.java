package o2;

import L4.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0901b f19067a;

    static class a implements InterfaceC0901b {

        /* renamed from: a, reason: collision with root package name */
        private final SSLContext f19068a;

        /* renamed from: b, reason: collision with root package name */
        private final X509TrustManager f19069b;

        a(InterfaceC0900a interfaceC0900a) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.f19068a = sSLContext;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate certificateB = b(certificateFactory, interfaceC0900a.a());
            Certificate certificateB2 = b(certificateFactory, interfaceC0900a.b());
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", certificateB);
            keyStore.setCertificateEntry("ca2", certificateB2);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            this.f19069b = (X509TrustManager) trustManagers[0];
            sSLContext.init(null, trustManagers, null);
        }

        private Certificate b(CertificateFactory certificateFactory, String str) throws IOException {
            InputStream inputStreamX0 = new e().write(str.getBytes()).x0();
            try {
                Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(inputStreamX0);
                if (inputStreamX0 != null) {
                    inputStreamX0.close();
                }
                return certificateGenerateCertificate;
            } catch (Throwable th) {
                if (inputStreamX0 != null) {
                    try {
                        inputStreamX0.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // o2.InterfaceC0901b
        public X509TrustManager a() {
            return this.f19069b;
        }

        @Override // o2.InterfaceC0901b
        public SSLContext getContext() {
            return this.f19068a;
        }
    }

    public static final synchronized InterfaceC0901b a() {
        try {
            if (f19067a == null) {
                f19067a = new a(new d());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f19067a;
    }
}
