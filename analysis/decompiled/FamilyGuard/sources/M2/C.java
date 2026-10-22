package M2;

/* loaded from: classes.dex */
public final class C extends C0378o {

    /* renamed from: p, reason: collision with root package name */
    public static final a f4003p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    private static final EnumC0377n f4004q = EnumC0377n.f4071d;

    /* renamed from: r, reason: collision with root package name */
    private static final EnumC0377n f4005r = EnumC0377n.f4070c;

    /* renamed from: i, reason: collision with root package name */
    private EnumC0377n f4006i;

    /* renamed from: j, reason: collision with root package name */
    private int f4007j;

    /* renamed from: k, reason: collision with root package name */
    private int f4008k;

    /* renamed from: l, reason: collision with root package name */
    private int f4009l;

    /* renamed from: m, reason: collision with root package name */
    private int f4010m;

    /* renamed from: n, reason: collision with root package name */
    private float f4011n;

    /* renamed from: o, reason: collision with root package name */
    private EnumC0377n f4012o;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public C() {
        n(40.0f);
        k(0.0f);
        this.f4006i = f4004q;
        this.f4011n = 0.5f;
        this.f4012o = f4005r;
    }

    public final void A(int i5) {
        this.f4010m = i5;
    }

    public final void B(int i5) {
        this.f4007j = i5;
    }

    public final void C(int i5) {
        this.f4009l = i5;
    }

    public final void D(int i5) {
        this.f4008k = i5;
    }

    public final EnumC0377n q() {
        return this.f4012o;
    }

    public final float r() {
        return this.f4011n;
    }

    public final EnumC0377n s() {
        return this.f4006i;
    }

    public final int t() {
        return this.f4010m;
    }

    public final int u() {
        return this.f4007j;
    }

    public final int v() {
        return this.f4009l;
    }

    public final int w() {
        return this.f4008k;
    }

    public final void x(EnumC0377n enumC0377n) {
        this.f4012o = enumC0377n;
    }

    public final void y(float f5) {
        this.f4011n = f5;
    }

    public final void z(EnumC0377n enumC0377n) {
        j4.k.g(enumC0377n, "<set-?>");
        this.f4006i = enumC0377n;
    }
}
