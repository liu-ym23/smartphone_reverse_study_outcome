package okhttp3;

import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static final i A = null;
    public static final i B = null;
    public static final i C = null;
    public static final i D = null;
    public static final i E = null;
    public static final i F = null;
    public static final i G = null;
    public static final i H = null;
    public static final i I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final i f39783J = null;
    public static final i K = null;
    public static final i L = null;
    public static final i M = null;
    public static final i N = null;
    public static final i O = null;
    public static final i P = null;
    public static final i Q = null;
    public static final i R = null;
    public static final i S = null;
    public static final i T = null;
    public static final i U = null;
    public static final i V = null;
    public static final i W = null;
    public static final i X = null;
    public static final i Y = null;
    public static final i Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39784a = null;
    public static final i aA = null;
    public static final i aB = null;
    public static final i aC = null;
    public static final i aD = null;
    public static final i aE = null;
    public static final i aF = null;
    public static final i aG = null;
    public static final i aH = null;
    public static final i aI = null;
    public static final i aJ = null;
    public static final i aK = null;
    public static final i aL = null;
    public static final i aM = null;
    public static final i aN = null;
    public static final i aO = null;
    public static final i aP = null;
    public static final i aQ = null;
    public static final i aR = null;
    public static final i aS = null;
    public static final i aT = null;
    public static final i aU = null;
    public static final i aV = null;
    public static final i aW = null;
    public static final i aX = null;
    public static final i aY = null;
    public static final i aZ = null;
    public static final i aa = null;
    public static final i ab = null;
    public static final i ac = null;
    public static final i ad = null;
    public static final i ae = null;
    public static final i af = null;
    public static final i ag = null;
    public static final i ah = null;
    public static final i ai = null;
    public static final i aj = null;
    public static final i ak = null;
    public static final i al = null;
    public static final i am = null;
    public static final i an = null;
    public static final i ao = null;
    public static final i ap = null;
    public static final i aq = null;
    public static final i ar = null;
    public static final i as = null;
    public static final i at = null;
    public static final i au = null;
    public static final i av = null;
    public static final i aw = null;
    public static final i ax = null;
    public static final i ay = null;
    public static final i az = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f39785b = null;
    public static final i ba = null;
    public static final i bb = null;
    public static final i bc = null;
    public static final i bd = null;
    public static final i be = null;
    public static final i bf = null;
    public static final i bg = null;
    public static final i bh = null;
    public static final i bi = null;
    public static final i bj = null;
    public static final i bk = null;
    public static final i bl = null;
    public static final i bm = null;
    public static final i bn = null;
    public static final i bo = null;
    public static final i bp = null;
    private static final Comparator<String> br = null;
    private static final Map<String, i> bs = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f39786c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f39787d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f39788e = null;
    public static final i f = null;
    public static final i g = null;
    public static final i h = null;
    public static final i i = null;
    public static final i j = null;
    public static final i k = null;
    public static final i l = null;
    public static final i m = null;
    public static final i n = null;
    public static final i o = null;
    public static final i p = null;
    public static final i q = null;
    public static final i r = null;
    public static final i s = null;
    public static final i t = null;
    public static final i u = null;
    public static final i v = null;
    public static final i w = null;
    public static final i x = null;
    public static final i y = null;
    public static final i z = null;
    private final String bq;

    /* JADX INFO: compiled from: CipherSuite.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ i a(a r0, String r1, int r2) {
            return r0.a(r1, r2);
        }

        public final Comparator<String> a() {
            return i.b();
        }

        public final synchronized i a(String r4) {
            monitor-enter(this);
            d.h.b.o.e(r4, "javaName");     // Catch: Throwable -> L11
            i r0 = (i) ZeusTransformUtils.preCheckCast(i.c().get(r4), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (r0 != null) goto L9;
            r0 = (i) ZeusTransformUtils.preCheckCast(i.c().get(b(r4)), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (r0 != null) goto L8;
            r0 = new i(r4, null);     // Catch: Throwable -> L11
        L8:
            i.c().put(r4, r0);     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
            return r0;
        L11:
            th = move-exception;
            throw th;
        }

        private final String b(String r8) {
            if (d.o.o.b(r8, "TLS_", false, 2, null) == false) goto L6;
            StringBuilder r7 = new StringBuilder().append("SSL_");
            String r9 = r8.substring(4);
            d.h.b.o.c(r9, "this as java.lang.String).substring(startIndex)");
            return r7.append(r9).toString();
        L6:
            if (d.o.o.b(r8, "SSL_", false, 2, null) == false) goto L10;
            StringBuilder r10 = new StringBuilder().append("TLS_");
            String r11 = r8.substring(4);
            d.h.b.o.c(r11, "this as java.lang.String).substring(startIndex)");
            return r10.append(r11).toString();
        L10:
            return r8;
        }

        private final i a(String r1, int r2) {
            i r0 = new i(r1, null);
            i.c().put(r1, r0);
            return r0;
        }
    }

    /* JADX INFO: compiled from: CipherSuite.kt */
    public static final class b implements Comparator<String> {
        b() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(String r3, String r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        }

        public int a(String r6, String r7) {
            d.h.b.o.e(r6, "a");
            d.h.b.o.e(r7, "b");
            int r5 = Math.min(r6.length(), r7.length());
            int r0 = 4;
        L4:
            if (r0 >= r5) goto L13;
            char r3 = r6.charAt(r0);
            char r4 = r7.charAt(r0);
            if (r3 != r4) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            if (d.h.b.o.a(r3, r4) >= 0) goto L11;
            return -1;
        L11:
            return 1;
        L13:
            int r8 = r6.length();
            int r9 = r7.length();
            if (r8 == r9) goto L19;
            if (r8 >= r9) goto L18;
            return -1;
        L18:
            return 1;
        L19:
            return 0;
        }
    }

    public /* synthetic */ i(String r1, d.h.b.h r2) {
        this(r1);
    }

    private i(String r1) {
        this.bq = r1;
    }

    public static final /* synthetic */ Comparator b() {
        return br;
    }

    public static final /* synthetic */ Map c() {
        return bs;
    }

    public final String a() {
        return this.bq;
    }

    public String toString() {
        return this.bq;
    }

    static {
        a r0 = new a(null);
        f39784a = r0;
        br = (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin");
        bs = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f39785b = a.a(r0, "SSL_RSA_WITH_NULL_MD5", 1);
        f39786c = a.a(r0, "SSL_RSA_WITH_NULL_SHA", 2);
        f39787d = a.a(r0, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        f39788e = a.a(r0, "SSL_RSA_WITH_RC4_128_MD5", 4);
        f = a.a(r0, "SSL_RSA_WITH_RC4_128_SHA", 5);
        g = a.a(r0, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        h = a.a(r0, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        i = a.a(r0, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        j = a.a(r0, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        k = a.a(r0, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        l = a.a(r0, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m = a.a(r0, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        n = a.a(r0, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        o = a.a(r0, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        p = a.a(r0, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        q = a.a(r0, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        r = a.a(r0, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        s = a.a(r0, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        t = a.a(r0, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        u = a.a(r0, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        v = a.a(r0, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        w = a.a(r0, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        x = a.a(r0, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        y = a.a(r0, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        z = a.a(r0, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        A = a.a(r0, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        B = a.a(r0, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        C = a.a(r0, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        D = a.a(r0, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        E = a.a(r0, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        F = a.a(r0, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        G = a.a(r0, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        H = a.a(r0, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        I = a.a(r0, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        f39783J = a.a(r0, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        K = a.a(r0, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        L = a.a(r0, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        M = a.a(r0, "TLS_RSA_WITH_NULL_SHA256", 59);
        N = a.a(r0, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        O = a.a(r0, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        P = a.a(r0, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        Q = a.a(r0, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        R = a.a(r0, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        S = a.a(r0, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        T = a.a(r0, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        U = a.a(r0, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        V = a.a(r0, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        W = a.a(r0, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a r1 = f39784a;
        X = a.a(r1, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        Y = a.a(r1, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        Z = a.a(r1, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        aa = a.a(r1, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        ab = a.a(r1, "TLS_PSK_WITH_RC4_128_SHA", 138);
        ac = a.a(r1, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        ad = a.a(r1, "TLS_PSK_WITH_AES_128_CBC_SHA", ApWakeEvent.OTHER_START);
        ae = a.a(r1, "TLS_PSK_WITH_AES_256_CBC_SHA", ApWakeEvent.OTHER_END);
        af = a.a(r1, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        ag = a.a(r1, "TLS_RSA_WITH_AES_128_GCM_SHA256", AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT);
        ah = a.a(r1, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        ai = a.a(r1, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        aj = a.a(r1, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        ak = a.a(r1, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        al = a.a(r1, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        am = a.a(r1, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        an = a.a(r1, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        ao = a.a(r1, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        ap = a.a(r1, "TLS_FALLBACK_SCSV", 22016);
        aq = a.a(r1, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        ar = a.a(r1, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        as = a.a(r1, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        at = a.a(r1, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        au = a.a(r1, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        av = a.a(r1, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        aw = a.a(r1, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        ax = a.a(r1, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        ay = a.a(r1, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        az = a.a(r1, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        aA = a.a(r1, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        aB = a.a(r1, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        aC = a.a(r1, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        aD = a.a(r1, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        aE = a.a(r1, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        aF = a.a(r1, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        aG = a.a(r1, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        aH = a.a(r1, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        aI = a.a(r1, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        aJ = a.a(r1, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        aK = a.a(r1, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        aL = a.a(r1, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        aM = a.a(r1, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        aN = a.a(r1, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        aO = a.a(r1, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        aP = a.a(r1, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        aQ = a.a(r1, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        aR = a.a(r1, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        aS = a.a(r1, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        aT = a.a(r1, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        aU = a.a(r1, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        a r2 = f39784a;
        aV = a.a(r2, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        aW = a.a(r2, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        aX = a.a(r2, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        aY = a.a(r2, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        aZ = a.a(r2, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        ba = a.a(r2, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        bb = a.a(r2, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        bc = a.a(r2, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        bd = a.a(r2, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        be = a.a(r2, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        bf = a.a(r2, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        bg = a.a(r2, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        bh = a.a(r2, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        bi = a.a(r2, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        bj = a.a(r2, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        bk = a.a(r2, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        bl = a.a(r2, "TLS_AES_128_GCM_SHA256", 4865);
        bm = a.a(r2, "TLS_AES_256_GCM_SHA384", 4866);
        bn = a.a(r2, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        bo = a.a(r2, "TLS_AES_128_CCM_SHA256", 4868);
        bp = a.a(r2, "TLS_AES_128_CCM_8_SHA256", 4869);
    }
}
