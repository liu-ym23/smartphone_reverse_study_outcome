package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f22829n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f22830o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f22838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f22839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f22840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f22841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f22842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22843m;

    /* JADX INFO: renamed from: okhttp3.a$a, reason: collision with other inner class name */
    public static final class C0331a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22848e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22849f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f22850g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f22851h;

        public C0331a() {
            this.f22846c = -1;
            this.f22847d = -1;
            this.f22848e = -1;
        }

        public a a() {
            return new a(this);
        }

        public C0331a b(int r10, TimeUnit r11) {
            if (r10 < 0) goto L10;
            long r12 = r11.toSeconds(r10);
            if (r12 <= 2147483647L) goto L6;
            int r13 = Channel.UNLIMITED;
        L7:
            this.f22847d = r13;
            return this;
        L6:
            r13 = (int) r12;
            goto L7
        L10:
            throw new IllegalArgumentException("maxStale < 0: " + r10);
        }

        public C0331a c() {
            this.f22844a = true;
            return this;
        }

        public C0331a d() {
            this.f22849f = true;
            return this;
        }
    }

    static {
        f22829n = new C0331a().c().a();
        f22830o = new C0331a().d().b(Channel.UNLIMITED, TimeUnit.SECONDS).a();
    }

    public a(boolean r10, boolean r11, int r12, int r13, boolean r14, boolean r15, boolean r16, int r17, int r18, boolean r19, boolean r110, boolean r111, String r112) {
        this.f22831a = r10;
        this.f22832b = r11;
        this.f22833c = r12;
        this.f22834d = r13;
        this.f22835e = r14;
        this.f22836f = r15;
        this.f22837g = r16;
        this.f22838h = r17;
        this.f22839i = r18;
        this.f22840j = r19;
        this.f22841k = r110;
        this.f22842l = r111;
        this.f22843m = r112;
    }

    public static a l(Headers r22) {
        int r10 = r22.h();
        int r11 = 0;
        boolean r12 = true;
        String r13 = null;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = -1;
        int r17 = -1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r110 = false;
        int r111 = -1;
        int r112 = -1;
        boolean r113 = false;
        boolean r114 = false;
        boolean r20 = false;
    L3:
        if (r11 >= r10) goto L67;
        String r21 = r22.d(r11);
        String r23 = r22.j(r11);
        if (r21.equalsIgnoreCase("Cache-Control") == false) goto L10;
        if (r13 == null) goto L8;
    L7:
        r12 = false;
    L12:
        int r24 = 0;
    L14:
        if (r24 >= r23.length()) goto L66;
        int r25 = HttpHeaders.skipUntil(r23, r24, "=,;");
        String r26 = r23.substring(r24, r25).trim();
        if (r25 == r23.length()) goto L28;
        if (r23.charAt(r25) == ',') goto L28;
        if (r23.charAt(r25) == ';') goto L28;
        int r27 = HttpHeaders.skipWhitespace(r23, r25 + 1);
        if (r27 < r23.length()) goto L25;
    L27:
        int r28 = HttpHeaders.skipUntil(r23, r27, ",;");
        String r29 = r23.substring(r27, r28).trim();
    L30:
        if ("no-cache".equalsIgnoreCase(r26) == false) goto L33;
        r14 = true;
    L65:
        r24 = r28;
        goto L14
    L33:
        if ("no-store".equalsIgnoreCase(r26) == false) goto L36;
        r15 = true;
        goto L65
    L36:
        if ("max-age".equalsIgnoreCase(r26) == false) goto L39;
        r16 = HttpHeaders.parseSeconds(r29, -1);
        goto L65
    L39:
        if ("s-maxage".equalsIgnoreCase(r26) == false) goto L42;
        r17 = HttpHeaders.parseSeconds(r29, -1);
        goto L65
    L42:
        if ("private".equalsIgnoreCase(r26) == false) goto L45;
        r18 = true;
        goto L65
    L45:
        if ("public".equalsIgnoreCase(r26) == false) goto L48;
        r19 = true;
        goto L65
    L48:
        if ("must-revalidate".equalsIgnoreCase(r26) == false) goto L51;
        r110 = true;
        goto L65
    L51:
        if ("max-stale".equalsIgnoreCase(r26) == false) goto L54;
        r111 = HttpHeaders.parseSeconds(r29, Channel.UNLIMITED);
        goto L65
    L54:
        if ("min-fresh".equalsIgnoreCase(r26) == false) goto L57;
        r112 = HttpHeaders.parseSeconds(r29, -1);
        goto L65
    L57:
        if ("only-if-cached".equalsIgnoreCase(r26) == false) goto L60;
        r113 = true;
        goto L65
    L60:
        if ("no-transform".equalsIgnoreCase(r26) == false) goto L63;
        r114 = true;
        goto L65
    L63:
        if ("immutable".equalsIgnoreCase(r26) == false) goto L65;
        r20 = true;
        goto L65
    L25:
        if (r23.charAt(r27) != '\"') goto L27;
        int r30 = r27 + 1;
        int r31 = HttpHeaders.skipUntil(r23, r30, "\"");
        r29 = r23.substring(r30, r31);
        r28 = r31 + 1;
    L28:
        r28 = r25 + 1;
        r29 = null;
    L66:
        r11 = r11 + 1;
        goto L3
    L8:
        r13 = r23;
        goto L12
    L10:
        if (r21.equalsIgnoreCase("Pragma") == false) goto L66;
    L67:
        if (r12 == true) goto L69;
        String r210 = null;
    L71:
        return new a(r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r210);
    L69:
        r210 = r13;
        goto L71
    }

    public final String a() {
        StringBuilder r10 = new StringBuilder();
        if (this.f22831a == false) goto L6;
        r10.append("no-cache, ");
    L6:
        if (this.f22832b == false) goto L9;
        r10.append("no-store, ");
    L9:
        if (this.f22833c == (-1)) goto L12;
        r10.append("max-age=");
        r10.append(this.f22833c);
        r10.append(", ");
    L12:
        if (this.f22834d == (-1)) goto L15;
        r10.append("s-maxage=");
        r10.append(this.f22834d);
        r10.append(", ");
    L15:
        if (this.f22835e == false) goto L18;
        r10.append("private, ");
    L18:
        if (this.f22836f == false) goto L21;
        r10.append("public, ");
    L21:
        if (this.f22837g == false) goto L24;
        r10.append("must-revalidate, ");
    L24:
        if (this.f22838h == (-1)) goto L27;
        r10.append("max-stale=");
        r10.append(this.f22838h);
        r10.append(", ");
    L27:
        if (this.f22839i == (-1)) goto L30;
        r10.append("min-fresh=");
        r10.append(this.f22839i);
        r10.append(", ");
    L30:
        if (this.f22840j == false) goto L33;
        r10.append("only-if-cached, ");
    L33:
        if (this.f22841k == false) goto L36;
        r10.append("no-transform, ");
    L36:
        if (this.f22842l == false) goto L39;
        r10.append("immutable, ");
    L39:
        if (r10.length() != 0) goto L42;
        return "";
    L42:
        r10.delete(r10.length() - 2, r10.length());
        return r10.toString();
    }

    public boolean b() {
        return this.f22842l;
    }

    public boolean c() {
        return this.f22835e;
    }

    public boolean d() {
        return this.f22836f;
    }

    public int e() {
        return this.f22833c;
    }

    public int f() {
        return this.f22838h;
    }

    public int g() {
        return this.f22839i;
    }

    public boolean h() {
        return this.f22837g;
    }

    public boolean i() {
        return this.f22831a;
    }

    public boolean j() {
        return this.f22832b;
    }

    public boolean k() {
        return this.f22840j;
    }

    public String toString() {
        String r10 = this.f22843m;
        if (r10 != null) goto L7;
        String r11 = a();
        this.f22843m = r11;
        return r11;
    L7:
        return r10;
    }

    public a(C0331a r10) {
        this.f22831a = r10.f22844a;
        this.f22832b = r10.f22845b;
        this.f22833c = r10.f22846c;
        this.f22834d = -1;
        this.f22835e = false;
        this.f22836f = false;
        this.f22837g = false;
        this.f22838h = r10.f22847d;
        this.f22839i = r10.f22848e;
        this.f22840j = r10.f22849f;
        this.f22841k = r10.f22850g;
        this.f22842l = r10.f22851h;
    }
}
