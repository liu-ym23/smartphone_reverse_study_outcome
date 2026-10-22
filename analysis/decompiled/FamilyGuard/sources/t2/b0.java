package t2;

import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import g2.C0736f;
import java.util.List;
import v2.AbstractC1182a;

/* loaded from: classes.dex */
public abstract class b0 extends AbstractC1182a implements Y {

    /* renamed from: o, reason: collision with root package name */
    private static final boolean f22556o = R1.a.f("PackageLimitProxy", R1.a.f4966b);

    /* renamed from: p, reason: collision with root package name */
    private static final long f22557p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f22558q;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22559b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22560c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22561d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22562e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22563f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22564g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22565h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.lifecycle.B<String> f22566i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.lifecycle.B<Integer> f22567j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22568k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.lifecycle.B<List<RawPeriodInfo>> f22569l;

    /* renamed from: m, reason: collision with root package name */
    private final String f22570m;

    /* renamed from: n, reason: collision with root package name */
    private final long f22571n;

    static {
        boolean z5 = C0736f.f17231b;
        f22557p = z5 ? 180000L : 1800000L;
        f22558q = z5 ? 360000L : 3600000L;
    }

    public b0(String str, v2.e eVar, long j5) {
        super(eVar);
        androidx.lifecycle.B<Long> b6 = new androidx.lifecycle.B<>();
        this.f22559b = b6;
        androidx.lifecycle.B<Long> b7 = new androidx.lifecycle.B<>();
        this.f22560c = b7;
        androidx.lifecycle.B<Boolean> b8 = new androidx.lifecycle.B<>();
        this.f22561d = b8;
        androidx.lifecycle.B<Boolean> b9 = new androidx.lifecycle.B<>();
        this.f22562e = b9;
        androidx.lifecycle.B<Boolean> b10 = new androidx.lifecycle.B<>();
        this.f22563f = b10;
        androidx.lifecycle.B<Boolean> b11 = new androidx.lifecycle.B<>();
        this.f22564g = b11;
        androidx.lifecycle.B<Boolean> b12 = new androidx.lifecycle.B<>();
        this.f22565h = b12;
        androidx.lifecycle.B<String> b13 = new androidx.lifecycle.B<>();
        this.f22566i = b13;
        this.f22567j = new androidx.lifecycle.B<>();
        androidx.lifecycle.B<Boolean> b14 = new androidx.lifecycle.B<>();
        this.f22568k = b14;
        androidx.lifecycle.B<List<RawPeriodInfo>> b15 = new androidx.lifecycle.B<>();
        this.f22569l = b15;
        this.f22570m = str;
        b6.n(Long.valueOf(f22557p));
        b7.n(Long.valueOf(f22558q));
        Boolean bool = Boolean.FALSE;
        b8.n(bool);
        b9.n(bool);
        b10.n(bool);
        b11.n(Boolean.TRUE);
        b12.n(bool);
        b13.n(null);
        b14.n(bool);
        b15.n(null);
        this.f22571n = j5;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22561d;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22563f;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22569l;
    }

    public long J() {
        return this.f22571n;
    }

    public String K() {
        return this.f22570m;
    }

    public androidx.lifecycle.B<Integer> L() {
        return this.f22567j;
    }

    public abstract void i();

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22564g;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22566i;
    }

    public abstract void m();

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22568k;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22562e;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22559b;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22565h;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22560c;
    }
}
