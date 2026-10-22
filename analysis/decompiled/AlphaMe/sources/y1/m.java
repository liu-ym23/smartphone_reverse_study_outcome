package y1;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public B0.f f16260a = new l();

    /* renamed from: b, reason: collision with root package name */
    public B0.f f16261b = new l();

    /* renamed from: c, reason: collision with root package name */
    public B0.f f16262c = new l();

    /* renamed from: d, reason: collision with root package name */
    public B0.f f16263d = new l();

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0990d f16264e = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0990d f16265f = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0990d f16266g = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0990d f16267h = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: i, reason: collision with root package name */
    public f f16268i = B0.f.n();

    /* renamed from: j, reason: collision with root package name */
    public f f16269j = B0.f.n();

    /* renamed from: k, reason: collision with root package name */
    public f f16270k = B0.f.n();

    /* renamed from: l, reason: collision with root package name */
    public f f16271l = B0.f.n();

    public static void b(B0.f fVar) {
        if (fVar instanceof l) {
            ((l) fVar).getClass();
        } else if (fVar instanceof e) {
            ((e) fVar).getClass();
        }
    }

    public final n a() {
        n nVar = new n();
        nVar.f16272a = this.f16260a;
        nVar.f16273b = this.f16261b;
        nVar.f16274c = this.f16262c;
        nVar.f16275d = this.f16263d;
        nVar.f16276e = this.f16264e;
        nVar.f16277f = this.f16265f;
        nVar.f16278g = this.f16266g;
        nVar.f16279h = this.f16267h;
        nVar.f16280i = this.f16268i;
        nVar.f16281j = this.f16269j;
        nVar.f16282k = this.f16270k;
        nVar.f16283l = this.f16271l;
        return nVar;
    }

    public final void c(float f4) {
        this.f16264e = new C0987a(f4);
        this.f16265f = new C0987a(f4);
        this.f16266g = new C0987a(f4);
        this.f16267h = new C0987a(f4);
    }

    public final void d(B0.f fVar) {
        this.f16260a = fVar;
        b(fVar);
        this.f16261b = fVar;
        b(fVar);
        this.f16262c = fVar;
        b(fVar);
        this.f16263d = fVar;
        b(fVar);
    }
}
