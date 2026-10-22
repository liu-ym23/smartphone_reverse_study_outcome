package rc;

/* loaded from: classes5.dex */
public class K0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39119d;

    /* renamed from: e, reason: collision with root package name */
    public double f39120e;

    /* renamed from: f, reason: collision with root package name */
    public double f39121f;

    public K0(AbstractC5276d abstractC5276d, double d10, double d11) {
        this.f39248a = abstractC5276d.f39248a;
        this.f39119d = abstractC5276d;
        this.f39120e = d10;
        this.f39121f = d11;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return new L0(this.f39119d.f(y02), this.f39120e, this.f39121f);
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39119d.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39119d.h();
    }

    public K0(AbstractC5276d abstractC5276d, double d10) {
        this.f39248a = abstractC5276d.f39248a;
        this.f39119d = abstractC5276d;
        this.f39120e = d10;
        this.f39121f = d10;
    }
}
