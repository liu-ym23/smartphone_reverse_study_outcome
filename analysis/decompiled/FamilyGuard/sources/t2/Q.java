package t2;

import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import g2.C0736f;
import java.util.List;
import v2.AbstractC1182a;

/* loaded from: classes.dex */
public abstract class Q extends AbstractC1182a implements Y {

    /* renamed from: n, reason: collision with root package name */
    private static final boolean f22521n = R1.a.f("PackageLimitProxy", R1.a.f4966b);

    /* renamed from: o, reason: collision with root package name */
    private static final long f22522o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f22523p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f22524q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f22525r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f22526s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f22527t;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22528b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22529c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22530d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22531e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22532f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22533g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22534h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.lifecycle.B<String> f22535i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.lifecycle.B<Integer> f22536j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22537k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.lifecycle.B<List<RawPeriodInfo>> f22538l;

    /* renamed from: m, reason: collision with root package name */
    private final long f22539m;

    static {
        boolean z5 = C0736f.f17231b;
        f22522o = z5 ? 180000L : 1800000L;
        f22523p = z5 ? 360000L : 3600000L;
        f22524q = z5 ? 720000L : 7200000L;
        f22525r = z5 ? 360000L : 3600000L;
        f22526s = z5 ? 360000L : 3600000L;
        f22527t = z5 ? 720000L : 7200000L;
    }

    public Q(v2.e eVar, int i5, long j5) {
        super(eVar);
        androidx.lifecycle.B<Long> b6 = new androidx.lifecycle.B<>();
        this.f22528b = b6;
        androidx.lifecycle.B<Long> b7 = new androidx.lifecycle.B<>();
        this.f22529c = b7;
        androidx.lifecycle.B<Boolean> b8 = new androidx.lifecycle.B<>();
        this.f22530d = b8;
        androidx.lifecycle.B<Boolean> b9 = new androidx.lifecycle.B<>();
        this.f22531e = b9;
        androidx.lifecycle.B<Boolean> b10 = new androidx.lifecycle.B<>();
        this.f22532f = b10;
        androidx.lifecycle.B<Boolean> b11 = new androidx.lifecycle.B<>();
        this.f22533g = b11;
        androidx.lifecycle.B<Boolean> b12 = new androidx.lifecycle.B<>();
        this.f22534h = b12;
        androidx.lifecycle.B<String> b13 = new androidx.lifecycle.B<>();
        this.f22535i = b13;
        this.f22536j = new androidx.lifecycle.B<>();
        androidx.lifecycle.B<Boolean> b14 = new androidx.lifecycle.B<>();
        this.f22537k = b14;
        androidx.lifecycle.B<List<RawPeriodInfo>> b15 = new androidx.lifecycle.B<>();
        this.f22538l = b15;
        this.f22539m = j5;
        if (i5 < 5) {
            b6.n(Long.valueOf(f22523p));
            b7.n(Long.valueOf(f22526s));
        } else {
            b6.n(Long.valueOf(f22524q));
            b7.n(Long.valueOf(f22527t));
        }
        Boolean bool = Boolean.FALSE;
        b8.n(bool);
        b9.n(bool);
        b10.n(bool);
        b11.n(Boolean.TRUE);
        b12.n(bool);
        b13.n(null);
        b14.n(bool);
        b15.n(null);
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22530d;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22532f;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22538l;
    }

    public abstract void i();

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22533g;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22535i;
    }

    public abstract void m();

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22537k;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22531e;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22528b;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22534h;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22529c;
    }
}
