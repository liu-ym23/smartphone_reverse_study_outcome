package rc;

/* loaded from: classes5.dex */
public class V0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public int f39167d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39168e;

    public V0(int i10, AbstractC5276d abstractC5276d) {
        this.f39167d = i10;
        this.f39168e = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        int iM = y02.m();
        y02.z(this.f39167d);
        AbstractC5284h abstractC5284hF = this.f39168e.f(y02);
        y02.z(iM);
        return abstractC5284hF;
    }
}
