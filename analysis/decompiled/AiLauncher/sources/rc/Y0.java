package rc;

/* loaded from: classes5.dex */
public class Y0 {

    /* renamed from: a, reason: collision with root package name */
    public Cc.c f39182a;

    /* renamed from: b, reason: collision with root package name */
    public Cc.c f39183b;

    /* renamed from: c, reason: collision with root package name */
    public int f39184c;

    /* renamed from: d, reason: collision with root package name */
    public Z0 f39185d;

    /* renamed from: e, reason: collision with root package name */
    public int f39186e;

    /* renamed from: f, reason: collision with root package name */
    public float f39187f;

    /* renamed from: g, reason: collision with root package name */
    public String f39188g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39189h;

    /* renamed from: i, reason: collision with root package name */
    public float f39190i;

    /* renamed from: j, reason: collision with root package name */
    public int f39191j;

    /* renamed from: k, reason: collision with root package name */
    public float f39192k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39193l;

    public Y0(int i10, Z0 z02) {
        this(i10, z02, (Cc.c) null, (Cc.c) null);
    }

    public void A(String str) {
        this.f39188g = str;
    }

    public Y0 B() {
        Y0 y0A = a();
        y0A.f39184c = ((this.f39184c / 4) * 2) + 5;
        return y0A;
    }

    public Y0 C() {
        Y0 y0A = a();
        int i10 = this.f39184c;
        y0A.f39184c = ((i10 / 4) * 2) + 4 + (i10 % 2);
        return y0A;
    }

    public Y0 a() {
        return new Y0(this.f39184c, this.f39190i, this.f39185d, this.f39182a, this.f39183b, this.f39188g, this.f39189h);
    }

    public Y0 b(Z0 z02) {
        Y0 y02 = new Y0(this.f39184c, this.f39190i, z02, this.f39182a, this.f39183b, this.f39188g, this.f39189h);
        y02.f39187f = this.f39187f;
        y02.f39192k = this.f39192k;
        y02.f39191j = this.f39191j;
        return y02;
    }

    public Y0 c() {
        Y0 y0A = a();
        int i10 = this.f39184c;
        if (i10 % 2 != 1) {
            i10++;
        }
        y0A.f39184c = i10;
        return y0A;
    }

    public Y0 d() {
        Y0 y0A = a();
        int i10 = this.f39184c;
        y0A.f39184c = (((i10 / 2) * 2) + 3) - ((i10 / 6) * 2);
        return y0A;
    }

    public Cc.c e() {
        return this.f39182a;
    }

    public Cc.c f() {
        return this.f39183b;
    }

    public float g() {
        return this.f39192k * R0.j(this.f39191j, this);
    }

    public int h() {
        int i10 = this.f39186e;
        return i10 == -1 ? this.f39185d.I() : i10;
    }

    public float i() {
        return this.f39190i;
    }

    public float j() {
        return this.f39185d.getSize();
    }

    public boolean k() {
        return this.f39189h;
    }

    public float l() {
        return this.f39185d.l(this.f39184c) * this.f39185d.g();
    }

    public int m() {
        return this.f39184c;
    }

    public Z0 n() {
        return this.f39185d;
    }

    public String o() {
        return this.f39188g;
    }

    public float p() {
        return this.f39187f;
    }

    public Y0 q() {
        Y0 y0A = a();
        int i10 = this.f39184c;
        y0A.f39184c = (i10 + 2) - ((i10 / 6) * 2);
        return y0A;
    }

    public void r() {
        this.f39183b = null;
        this.f39182a = null;
    }

    public Y0 s() {
        Y0 y0A = a();
        y0A.f39184c = 6;
        return y0A;
    }

    public void t(Cc.c cVar) {
        this.f39182a = cVar;
    }

    public void u(Cc.c cVar) {
        this.f39183b = cVar;
    }

    public void v(int i10, float f10) {
        this.f39192k = f10;
        this.f39191j = i10;
    }

    public void w(int i10) {
        this.f39186e = i10;
    }

    public void x(float f10) {
        this.f39190i = f10;
    }

    public void y(boolean z10) {
        this.f39189h = z10;
    }

    public void z(int i10) {
        this.f39184c = i10;
    }

    public Y0(int i10, Z0 z02, int i11, float f10) {
        this(i10, z02, (Cc.c) null, (Cc.c) null);
        this.f39187f = f10 * R0.j(i11, this);
    }

    public Y0(int i10, Z0 z02, Cc.c cVar, Cc.c cVar2) {
        this.f39186e = -1;
        this.f39187f = Float.POSITIVE_INFINITY;
        this.f39190i = 1.0f;
        this.f39193l = false;
        this.f39184c = i10;
        this.f39185d = z02;
        this.f39182a = cVar;
        this.f39183b = cVar2;
        v(1, 1.0f);
    }

    public Y0(int i10, float f10, Z0 z02, Cc.c cVar, Cc.c cVar2, String str, boolean z10) {
        this.f39186e = -1;
        this.f39187f = Float.POSITIVE_INFINITY;
        this.f39193l = false;
        this.f39184c = i10;
        this.f39190i = f10;
        this.f39185d = z02;
        this.f39188g = str;
        this.f39189h = z10;
        this.f39182a = cVar;
        this.f39183b = cVar2;
        v(1, 1.0f);
    }
}
