package rc;

/* loaded from: classes5.dex */
public class A0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39015d;

    /* renamed from: e, reason: collision with root package name */
    public int f39016e;

    /* renamed from: f, reason: collision with root package name */
    public int f39017f;

    /* renamed from: g, reason: collision with root package name */
    public int f39018g;

    /* renamed from: h, reason: collision with root package name */
    public float f39019h;

    /* renamed from: i, reason: collision with root package name */
    public float f39020i;

    /* renamed from: j, reason: collision with root package name */
    public float f39021j;

    public A0(AbstractC5276d abstractC5276d, int i10, float f10, int i11, float f11, int i12, float f12) {
        this.f39015d = abstractC5276d;
        this.f39016e = i10;
        this.f39019h = f10;
        this.f39017f = i11;
        this.f39020i = f11;
        this.f39018g = i12;
        this.f39021j = f12;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39015d.f(y02);
        int i10 = this.f39016e;
        if (i10 == -1) {
            abstractC5284hF.o(0.0f);
        } else {
            abstractC5284hF.o((-this.f39019h) * R0.j(i10, y02));
        }
        if (this.f39017f == -1) {
            return abstractC5284hF;
        }
        Q q10 = new Q(abstractC5284hF);
        q10.n(this.f39020i * R0.j(this.f39017f, y02));
        int i11 = this.f39018g;
        if (i11 == -1) {
            q10.m(0.0f);
            return q10;
        }
        q10.m(this.f39021j * R0.j(i11, y02));
        return q10;
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39015d.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39015d.h();
    }
}
