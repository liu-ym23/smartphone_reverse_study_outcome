package rc;

/* loaded from: classes5.dex */
public class B extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public int f39022d;

    public B(int i10) {
        this.f39022d = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fJ = R0.j(5, y02) * 12.0f;
        int i10 = this.f39022d;
        return new C(i10 == 5 ? 4 : i10, 1.0f * fJ, 0.07f * fJ, 0.125f * fJ, i10 == 5);
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return 0;
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return 0;
    }
}
