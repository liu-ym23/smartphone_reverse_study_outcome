package o4;

import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class e implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    public final String f7332a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7333b;

    /* renamed from: c, reason: collision with root package name */
    public final b0.b2 f7334c;

    public e(String str, boolean z4, b0.b2 b2Var) {
        this.f7332a = str;
        this.f7333b = z4;
        this.f7334c = b2Var;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        X509Certificate x509Certificate;
        if (x509CertificateArr == null || (x509Certificate = (X509Certificate) d7.n.h0(x509CertificateArr)) == null) {
            throw new CertificateException("empty cert chain");
        }
        byte[] encoded = x509Certificate.getEncoded();
        q7.k.d(encoded, "getEncoded(...)");
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(encoded);
        q7.k.b(bArrDigest);
        String strN0 = d7.n.n0(bArrDigest, "", new b(6), 30);
        this.f7334c.invoke(strN0);
        String str2 = this.f7332a;
        if (str2 != null) {
            if (!str2.equalsIgnoreCase(strN0)) {
                throw new CertificateException(a1.a.k("OpenClaw TLS fingerprint mismatch: expected=", str2, " actual=", strN0));
            }
        } else if (!this.f7333b) {
            throw new CertificateException(a1.a.j("OpenClaw TLS fingerprint not configured and TOFU disabled (observed=", strN0, ")"));
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
