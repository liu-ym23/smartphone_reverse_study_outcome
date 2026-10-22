package ib;

import com.stepos.account.oauth.OAuthConstants;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import w7.e0;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static volatile m f5049a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f5050b;

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c A[PHI: r0
      0x006c: PHI (r0v37 ib.m) = (r0v15 ib.m), (r0v17 ib.m), (r0v27 ib.m), (r0v31 ib.m), (r0v35 ib.m), (r0v46 ib.m) binds: [B:52:0x00da, B:64:0x014e, B:46:0x00cc, B:38:0x00ac, B:30:0x008c, B:21:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    static {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.m.<clinit>():void");
    }

    public static void g(int i2, String str, Throwable th) {
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        f5050b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public e0 b(X509TrustManager x509TrustManager) {
        return new mb.a(c(x509TrustManager));
    }

    public mb.b c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        q7.k.d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new mb.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        q7.k.e(list, "protocols");
    }

    public String e(SSLSocket sSLSocket) {
        return null;
    }

    public boolean f(String str) {
        q7.k.e(str, "hostname");
        return true;
    }

    public SSLContext h() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        q7.k.d(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory i(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextH = h();
            sSLContextH.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextH.getSocketFactory();
            q7.k.d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager j() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        q7.k.b(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                q7.k.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        q7.k.d(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
