package F9;

import java.util.LinkedHashMap;

/* renamed from: F9.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0232j {
    public static final C0237o b;
    public static final C0231i c;
    public static final LinkedHashMap d;
    public static final C0232j e;
    public static final C0232j f;
    public static final C0232j g;
    public static final C0232j h;
    public static final C0232j i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0232j f642j;
    public static final C0232j k;
    public static final C0232j l;
    public static final C0232j m;
    public static final C0232j n;
    public static final C0232j o;
    public static final C0232j p;

    /* renamed from: q, reason: collision with root package name */
    public static final C0232j f643q;

    /* renamed from: r, reason: collision with root package name */
    public static final C0232j f644r;

    /* renamed from: s, reason: collision with root package name */
    public static final C0232j f645s;

    /* renamed from: t, reason: collision with root package name */
    public static final C0232j f646t;

    /* renamed from: a, reason: collision with root package name */
    public final String f647a;

    static {
        C0237o c0237o = new C0237o();
        b = c0237o;
        c = new C0231i();
        d = new LinkedHashMap();
        C0237o.b(c0237o, "SSL_RSA_WITH_NULL_MD5");
        C0237o.b(c0237o, "SSL_RSA_WITH_NULL_SHA");
        C0237o.b(c0237o, "SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        C0237o.b(c0237o, "SSL_RSA_WITH_RC4_128_MD5");
        C0237o.b(c0237o, "SSL_RSA_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        C0237o.b(c0237o, "SSL_RSA_WITH_DES_CBC_SHA");
        e = C0237o.b(c0237o, "SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_DSS_WITH_DES_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_RSA_WITH_DES_CBC_SHA");
        C0237o.b(c0237o, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        C0237o.b(c0237o, "SSL_DH_anon_WITH_RC4_128_MD5");
        C0237o.b(c0237o, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        C0237o.b(c0237o, "SSL_DH_anon_WITH_DES_CBC_SHA");
        C0237o.b(c0237o, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_KRB5_WITH_DES_CBC_SHA");
        C0237o.b(c0237o, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_KRB5_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_KRB5_WITH_DES_CBC_MD5");
        C0237o.b(c0237o, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        C0237o.b(c0237o, "TLS_KRB5_WITH_RC4_128_MD5");
        C0237o.b(c0237o, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        C0237o.b(c0237o, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        C0237o.b(c0237o, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        C0237o.b(c0237o, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f = C0237o.b(c0237o, "TLS_RSA_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_128_CBC_SHA");
        g = C0237o.b(c0237o, "TLS_RSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_RSA_WITH_NULL_SHA256");
        C0237o.b(c0237o, "TLS_RSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_RSA_WITH_AES_256_CBC_SHA256");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        C0237o.b(c0237o, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_PSK_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_PSK_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_PSK_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_RSA_WITH_SEED_CBC_SHA");
        h = C0237o.b(c0237o, "TLS_RSA_WITH_AES_128_GCM_SHA256");
        i = C0237o.b(c0237o, "TLS_RSA_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        C0237o.b(c0237o, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        C0237o.b(c0237o, "TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        C0237o.b(c0237o, "TLS_FALLBACK_SCSV");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_NULL_SHA");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_NULL_SHA");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_NULL_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        f642j = C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        k = C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_anon_WITH_NULL_SHA");
        C0237o.b(c0237o, "TLS_ECDH_anon_WITH_RC4_128_SHA");
        C0237o.b(c0237o, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        l = C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        m = C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        C0237o.b(c0237o, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        n = C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        o = C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        C0237o.b(c0237o, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        C0237o.b(c0237o, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        C0237o.b(c0237o, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        p = C0237o.b(c0237o, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        f643q = C0237o.b(c0237o, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        C0237o.b(c0237o, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        C0237o.b(c0237o, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        f644r = C0237o.b(c0237o, "TLS_AES_128_GCM_SHA256");
        f645s = C0237o.b(c0237o, "TLS_AES_256_GCM_SHA384");
        f646t = C0237o.b(c0237o, "TLS_CHACHA20_POLY1305_SHA256");
        C0237o.b(c0237o, "TLS_AES_128_CCM_SHA256");
        C0237o.b(c0237o, "TLS_AES_128_CCM_8_SHA256");
    }

    public C0232j(String str) {
        this.f647a = str;
    }

    public final String toString() {
        return this.f647a;
    }
}
