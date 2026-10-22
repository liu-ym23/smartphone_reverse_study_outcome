package rc;

/* loaded from: classes5.dex */
public class i1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final int f39326d;

    /* renamed from: e, reason: collision with root package name */
    public final int f39327e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC5276d f39328f;

    public i1(int i10, int i11, AbstractC5276d abstractC5276d) {
        this.f39326d = i10;
        this.f39327e = i11;
        this.f39328f = abstractC5276d;
        this.f39249b = abstractC5276d.f39249b;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return this.f39328f.f(y02);
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39326d;
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39327e;
    }

    public AbstractC5276d i() {
        AbstractC5276d abstractC5276d = this.f39328f;
        abstractC5276d.f39249b = this.f39249b;
        return abstractC5276d;
    }
}
