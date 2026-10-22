package rc;

/* renamed from: rc.v0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5312v0 extends AbstractC5276d implements H0 {

    /* renamed from: d, reason: collision with root package name */
    public I0 f39428d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39429e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39430f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39431g;

    public C5312v0(AbstractC5276d abstractC5276d) {
        this.f39429e = true;
        this.f39430f = true;
        this.f39431g = true;
        if (abstractC5276d == null) {
            this.f39428d = new I0();
        } else {
            this.f39428d = new I0(abstractC5276d);
        }
    }

    @Override // rc.H0
    public void a(C5315x c5315x) {
        this.f39428d.a(c5315x);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39428d.f(y02);
        return new U0(this.f39429e ? abstractC5284hF.k() : 0.0f, this.f39430f ? abstractC5284hF.h() : 0.0f, this.f39431g ? abstractC5284hF.g() : 0.0f, abstractC5284hF.j());
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39428d.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39428d.h();
    }

    public C5312v0(AbstractC5276d abstractC5276d, boolean z10, boolean z11, boolean z12) {
        this(abstractC5276d);
        this.f39429e = z10;
        this.f39430f = z11;
        this.f39431g = z12;
    }
}
