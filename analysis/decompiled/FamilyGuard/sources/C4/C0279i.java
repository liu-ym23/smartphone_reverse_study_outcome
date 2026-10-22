package C4;

import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: C4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0279i {

    /* renamed from: a, reason: collision with root package name */
    final String f905a;

    /* renamed from: b, reason: collision with root package name */
    static final Comparator<String> f838b = new Comparator() { // from class: C4.h
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C0279i.a((String) obj, (String) obj2);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, C0279i> f841c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final C0279i f844d = d("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: e, reason: collision with root package name */
    public static final C0279i f847e = d("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: f, reason: collision with root package name */
    public static final C0279i f850f = d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: g, reason: collision with root package name */
    public static final C0279i f853g = d("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: h, reason: collision with root package name */
    public static final C0279i f856h = d("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: i, reason: collision with root package name */
    public static final C0279i f859i = d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: j, reason: collision with root package name */
    public static final C0279i f862j = d("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: k, reason: collision with root package name */
    public static final C0279i f865k = d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: l, reason: collision with root package name */
    public static final C0279i f868l = d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: m, reason: collision with root package name */
    public static final C0279i f871m = d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: n, reason: collision with root package name */
    public static final C0279i f874n = d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: o, reason: collision with root package name */
    public static final C0279i f877o = d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: p, reason: collision with root package name */
    public static final C0279i f880p = d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: q, reason: collision with root package name */
    public static final C0279i f883q = d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: r, reason: collision with root package name */
    public static final C0279i f886r = d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: s, reason: collision with root package name */
    public static final C0279i f889s = d("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: t, reason: collision with root package name */
    public static final C0279i f891t = d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: u, reason: collision with root package name */
    public static final C0279i f893u = d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: v, reason: collision with root package name */
    public static final C0279i f895v = d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: w, reason: collision with root package name */
    public static final C0279i f897w = d("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: x, reason: collision with root package name */
    public static final C0279i f899x = d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: y, reason: collision with root package name */
    public static final C0279i f901y = d("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: z, reason: collision with root package name */
    public static final C0279i f903z = d("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: A, reason: collision with root package name */
    public static final C0279i f784A = d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: B, reason: collision with root package name */
    public static final C0279i f786B = d("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: C, reason: collision with root package name */
    public static final C0279i f788C = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: D, reason: collision with root package name */
    public static final C0279i f790D = d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: E, reason: collision with root package name */
    public static final C0279i f792E = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: F, reason: collision with root package name */
    public static final C0279i f794F = d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: G, reason: collision with root package name */
    public static final C0279i f796G = d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: H, reason: collision with root package name */
    public static final C0279i f798H = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: I, reason: collision with root package name */
    public static final C0279i f800I = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: J, reason: collision with root package name */
    public static final C0279i f802J = d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: K, reason: collision with root package name */
    public static final C0279i f804K = d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: L, reason: collision with root package name */
    public static final C0279i f806L = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: M, reason: collision with root package name */
    public static final C0279i f808M = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: N, reason: collision with root package name */
    public static final C0279i f810N = d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: O, reason: collision with root package name */
    public static final C0279i f812O = d("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: P, reason: collision with root package name */
    public static final C0279i f814P = d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: Q, reason: collision with root package name */
    public static final C0279i f816Q = d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: R, reason: collision with root package name */
    public static final C0279i f818R = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: S, reason: collision with root package name */
    public static final C0279i f820S = d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: T, reason: collision with root package name */
    public static final C0279i f822T = d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: U, reason: collision with root package name */
    public static final C0279i f824U = d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: V, reason: collision with root package name */
    public static final C0279i f826V = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", CategoryEntity.NEWS);

    /* renamed from: W, reason: collision with root package name */
    public static final C0279i f828W = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", CategoryEntity.SOCIAL);

    /* renamed from: X, reason: collision with root package name */
    public static final C0279i f830X = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: Y, reason: collision with root package name */
    public static final C0279i f832Y = d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Z, reason: collision with root package name */
    public static final C0279i f834Z = d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: a0, reason: collision with root package name */
    public static final C0279i f836a0 = d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: b0, reason: collision with root package name */
    public static final C0279i f839b0 = d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* renamed from: c0, reason: collision with root package name */
    public static final C0279i f842c0 = d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: d0, reason: collision with root package name */
    public static final C0279i f845d0 = d("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: e0, reason: collision with root package name */
    public static final C0279i f848e0 = d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: f0, reason: collision with root package name */
    public static final C0279i f851f0 = d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: g0, reason: collision with root package name */
    public static final C0279i f854g0 = d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: h0, reason: collision with root package name */
    public static final C0279i f857h0 = d("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: i0, reason: collision with root package name */
    public static final C0279i f860i0 = d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: j0, reason: collision with root package name */
    public static final C0279i f863j0 = d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: k0, reason: collision with root package name */
    public static final C0279i f866k0 = d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: l0, reason: collision with root package name */
    public static final C0279i f869l0 = d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m0, reason: collision with root package name */
    public static final C0279i f872m0 = d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n0, reason: collision with root package name */
    public static final C0279i f875n0 = d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o0, reason: collision with root package name */
    public static final C0279i f878o0 = d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p0, reason: collision with root package name */
    public static final C0279i f881p0 = d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: q0, reason: collision with root package name */
    public static final C0279i f884q0 = d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: r0, reason: collision with root package name */
    public static final C0279i f887r0 = d("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s0, reason: collision with root package name */
    public static final C0279i f890s0 = d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t0, reason: collision with root package name */
    public static final C0279i f892t0 = d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u0, reason: collision with root package name */
    public static final C0279i f894u0 = d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v0, reason: collision with root package name */
    public static final C0279i f896v0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w0, reason: collision with root package name */
    public static final C0279i f898w0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x0, reason: collision with root package name */
    public static final C0279i f900x0 = d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y0, reason: collision with root package name */
    public static final C0279i f902y0 = d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z0, reason: collision with root package name */
    public static final C0279i f904z0 = d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: A0, reason: collision with root package name */
    public static final C0279i f785A0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B0, reason: collision with root package name */
    public static final C0279i f787B0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C0, reason: collision with root package name */
    public static final C0279i f789C0 = d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D0, reason: collision with root package name */
    public static final C0279i f791D0 = d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E0, reason: collision with root package name */
    public static final C0279i f793E0 = d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F0, reason: collision with root package name */
    public static final C0279i f795F0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G0, reason: collision with root package name */
    public static final C0279i f797G0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H0, reason: collision with root package name */
    public static final C0279i f799H0 = d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I0, reason: collision with root package name */
    public static final C0279i f801I0 = d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J0, reason: collision with root package name */
    public static final C0279i f803J0 = d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K0, reason: collision with root package name */
    public static final C0279i f805K0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L0, reason: collision with root package name */
    public static final C0279i f807L0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M0, reason: collision with root package name */
    public static final C0279i f809M0 = d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N0, reason: collision with root package name */
    public static final C0279i f811N0 = d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O0, reason: collision with root package name */
    public static final C0279i f813O0 = d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P0, reason: collision with root package name */
    public static final C0279i f815P0 = d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q0, reason: collision with root package name */
    public static final C0279i f817Q0 = d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R0, reason: collision with root package name */
    public static final C0279i f819R0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S0, reason: collision with root package name */
    public static final C0279i f821S0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T0, reason: collision with root package name */
    public static final C0279i f823T0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U0, reason: collision with root package name */
    public static final C0279i f825U0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V0, reason: collision with root package name */
    public static final C0279i f827V0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W0, reason: collision with root package name */
    public static final C0279i f829W0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X0, reason: collision with root package name */
    public static final C0279i f831X0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y0, reason: collision with root package name */
    public static final C0279i f833Y0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z0, reason: collision with root package name */
    public static final C0279i f835Z0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a1, reason: collision with root package name */
    public static final C0279i f837a1 = d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b1, reason: collision with root package name */
    public static final C0279i f840b1 = d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c1, reason: collision with root package name */
    public static final C0279i f843c1 = d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d1, reason: collision with root package name */
    public static final C0279i f846d1 = d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e1, reason: collision with root package name */
    public static final C0279i f849e1 = d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f1, reason: collision with root package name */
    public static final C0279i f852f1 = d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g1, reason: collision with root package name */
    public static final C0279i f855g1 = d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h1, reason: collision with root package name */
    public static final C0279i f858h1 = d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i1, reason: collision with root package name */
    public static final C0279i f861i1 = d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j1, reason: collision with root package name */
    public static final C0279i f864j1 = d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k1, reason: collision with root package name */
    public static final C0279i f867k1 = d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l1, reason: collision with root package name */
    public static final C0279i f870l1 = d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: m1, reason: collision with root package name */
    public static final C0279i f873m1 = d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: n1, reason: collision with root package name */
    public static final C0279i f876n1 = d("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: o1, reason: collision with root package name */
    public static final C0279i f879o1 = d("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: p1, reason: collision with root package name */
    public static final C0279i f882p1 = d("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: q1, reason: collision with root package name */
    public static final C0279i f885q1 = d("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: r1, reason: collision with root package name */
    public static final C0279i f888r1 = d("TLS_AES_128_CCM_8_SHA256", 4869);

    private C0279i(String str) {
        str.getClass();
        this.f905a = str;
    }

    public static /* synthetic */ int a(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i5 = 4; i5 < iMin; i5++) {
            char cCharAt = str.charAt(i5);
            char cCharAt2 = str2.charAt(i5);
            if (cCharAt != cCharAt2) {
                return cCharAt < cCharAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    public static synchronized C0279i b(String str) {
        C0279i c0279i;
        try {
            Map<String, C0279i> map = f841c;
            c0279i = map.get(str);
            if (c0279i == null) {
                c0279i = map.get(e(str));
                if (c0279i == null) {
                    c0279i = new C0279i(str);
                }
                map.put(str, c0279i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0279i;
    }

    static List<C0279i> c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(b(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static C0279i d(String str, int i5) {
        C0279i c0279i = new C0279i(str);
        f841c.put(str, c0279i);
        return c0279i;
    }

    private static String e(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String toString() {
        return this.f905a;
    }
}
