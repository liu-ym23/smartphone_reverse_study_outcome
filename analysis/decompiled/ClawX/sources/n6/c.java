package n6;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f3997n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3998a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3999b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4000c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4001e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4002f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4003g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4004h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4005i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4006j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4007k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4008l;

    /* renamed from: m, reason: collision with root package name */
    public String f4009m;

    static {
        long j4;
        y5.a aVar = y5.b.f6335b;
        y5.d unit = y5.d.d;
        kotlin.jvm.internal.p.e(unit, "unit");
        if (unit.compareTo(unit) <= 0) {
            j4 = y5.g.b(Integer.MAX_VALUE, unit, y5.d.f6340b) << 1;
            int i8 = y5.c.f6339a;
        } else {
            j4 = y5.g.j(Integer.MAX_VALUE, unit);
        }
        long jF = y5.b.f(j4, unit);
        if (jF < 0) {
            throw new IllegalArgumentException(a8.b.l(jF, "maxStale < 0: ").toString());
        }
    }

    public c(boolean z, boolean z2, int i8, int i9, boolean z8, boolean z9, boolean z10, int i10, int i11, boolean z11, boolean z12, boolean z13, String str) {
        this.f3998a = z;
        this.f3999b = z2;
        this.f4000c = i8;
        this.d = i9;
        this.f4001e = z8;
        this.f4002f = z9;
        this.f4003g = z10;
        this.f4004h = i10;
        this.f4005i = i11;
        this.f4006j = z11;
        this.f4007k = z12;
        this.f4008l = z13;
        this.f4009m = str;
    }

    public final String toString() {
        String str = this.f4009m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3998a) {
            sb.append("no-cache, ");
        }
        if (this.f3999b) {
            sb.append("no-store, ");
        }
        int i8 = this.f4000c;
        if (i8 != -1) {
            sb.append("max-age=");
            sb.append(i8);
            sb.append(", ");
        }
        int i9 = this.d;
        if (i9 != -1) {
            sb.append("s-maxage=");
            sb.append(i9);
            sb.append(", ");
        }
        if (this.f4001e) {
            sb.append("private, ");
        }
        if (this.f4002f) {
            sb.append("public, ");
        }
        if (this.f4003g) {
            sb.append("must-revalidate, ");
        }
        int i10 = this.f4004h;
        if (i10 != -1) {
            sb.append("max-stale=");
            sb.append(i10);
            sb.append(", ");
        }
        int i11 = this.f4005i;
        if (i11 != -1) {
            sb.append("min-fresh=");
            sb.append(i11);
            sb.append(", ");
        }
        if (this.f4006j) {
            sb.append("only-if-cached, ");
        }
        if (this.f4007k) {
            sb.append("no-transform, ");
        }
        if (this.f4008l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        kotlin.jvm.internal.p.d(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String string = sb.toString();
        this.f4009m = string;
        return string;
    }
}
