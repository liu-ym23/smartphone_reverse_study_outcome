package b0;

/* loaded from: classes.dex */
public final class h1 implements c {

    /* renamed from: f, reason: collision with root package name */
    public final int f1172f;

    /* renamed from: g, reason: collision with root package name */
    public int f1173g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1174h;

    public h1() {
        this.f1174h = new h1[256];
        this.f1172f = 0;
        this.f1173g = 0;
    }

    @Override // b0.c
    public void a(int i2, Object obj) {
        ((c) this.f1174h).a(i2 + (this.f1173g == 0 ? this.f1172f : 0), obj);
    }

    @Override // b0.c
    public void c(Object obj) {
        this.f1173g++;
        ((c) this.f1174h).c(obj);
    }

    @Override // b0.c
    public void d() {
        ((c) this.f1174h).d();
    }

    @Override // b0.c
    public void e(int i2, Object obj) {
        ((c) this.f1174h).e(i2 + (this.f1173g == 0 ? this.f1172f : 0), obj);
    }

    @Override // b0.c
    public void f(int i2, int i10, int i11) {
        int i12 = this.f1173g == 0 ? this.f1172f : 0;
        ((c) this.f1174h).f(i2 + i12, i10 + i12, i11);
    }

    @Override // b0.c
    public void g(int i2, int i10) {
        ((c) this.f1174h).g(i2 + (this.f1173g == 0 ? this.f1172f : 0), i10);
    }

    @Override // b0.c
    public Object getCurrent() {
        return ((c) this.f1174h).getCurrent();
    }

    @Override // b0.c
    public void h(Object obj, p7.n nVar) {
        ((c) this.f1174h).h(obj, nVar);
    }

    @Override // b0.c
    public void j() {
        if (!(this.f1173g > 0)) {
            s.c("OffsetApplier up called with no corresponding down");
        }
        this.f1173g--;
        ((c) this.f1174h).j();
    }

    public h1(int i2, int i10) {
        this.f1174h = null;
        this.f1172f = i2;
        int i11 = i10 & 7;
        this.f1173g = i11 == 0 ? 8 : i11;
    }

    public h1(c cVar, int i2) {
        this.f1174h = cVar;
        this.f1172f = i2;
    }
}
