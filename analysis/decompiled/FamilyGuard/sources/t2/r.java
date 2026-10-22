package t2;

import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import g2.C0736f;
import java.util.List;
import v2.AbstractC1182a;

/* loaded from: classes.dex */
public abstract class r extends AbstractC1182a implements InterfaceC1136p {

    /* renamed from: p, reason: collision with root package name */
    private static final boolean f22614p = R1.a.f("CategoryLimitProxy", R1.a.f4966b);

    /* renamed from: q, reason: collision with root package name */
    private static final long f22615q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f22616r;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22617b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.lifecycle.B<Long> f22618c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22619d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22620e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.lifecycle.B<List<RawPeriodInfo>> f22621f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22622g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.lifecycle.B<Category> f22623h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22624i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22625j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.lifecycle.B<String> f22626k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.lifecycle.B<Boolean> f22627l;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.lifecycle.B<Integer> f22628m;

    /* renamed from: n, reason: collision with root package name */
    private final int f22629n;

    /* renamed from: o, reason: collision with root package name */
    private final long f22630o;

    static {
        boolean z5 = C0736f.f17231b;
        f22615q = z5 ? 360000L : 3600000L;
        f22616r = z5 ? 720000L : 7200000L;
    }

    public r(int i5, v2.e eVar, long j5) {
        super(eVar);
        androidx.lifecycle.B<Long> b6 = new androidx.lifecycle.B<>();
        this.f22617b = b6;
        androidx.lifecycle.B<Long> b7 = new androidx.lifecycle.B<>();
        this.f22618c = b7;
        androidx.lifecycle.B<Boolean> b8 = new androidx.lifecycle.B<>();
        this.f22619d = b8;
        androidx.lifecycle.B<Boolean> b9 = new androidx.lifecycle.B<>();
        this.f22620e = b9;
        androidx.lifecycle.B<List<RawPeriodInfo>> b10 = new androidx.lifecycle.B<>();
        this.f22621f = b10;
        androidx.lifecycle.B<Boolean> b11 = new androidx.lifecycle.B<>();
        this.f22622g = b11;
        this.f22623h = new androidx.lifecycle.B<>();
        androidx.lifecycle.B<Boolean> b12 = new androidx.lifecycle.B<>();
        this.f22624i = b12;
        androidx.lifecycle.B<Boolean> b13 = new androidx.lifecycle.B<>();
        this.f22625j = b13;
        androidx.lifecycle.B<String> b14 = new androidx.lifecycle.B<>();
        this.f22626k = b14;
        androidx.lifecycle.B<Boolean> b15 = new androidx.lifecycle.B<>();
        this.f22627l = b15;
        this.f22628m = new androidx.lifecycle.B<>();
        this.f22629n = i5;
        b6.n(Long.valueOf(f22615q));
        b7.n(Long.valueOf(f22616r));
        Boolean bool = Boolean.FALSE;
        b8.n(bool);
        b9.n(bool);
        b10.n(null);
        b11.n(bool);
        b15.n(bool);
        b12.n(Boolean.TRUE);
        b13.n(bool);
        b14.n(null);
        this.f22630o = j5;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22619d;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22622g;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22621f;
    }

    public androidx.lifecycle.B<Category> J() {
        return this.f22623h;
    }

    public int K() {
        return this.f22629n;
    }

    public long L() {
        return this.f22630o;
    }

    public androidx.lifecycle.B<Integer> M() {
        return this.f22628m;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22624i;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22626k;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22627l;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22620e;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22617b;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22625j;
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22618c;
    }
}
