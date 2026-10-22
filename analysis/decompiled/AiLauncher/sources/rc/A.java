package rc;

/* loaded from: classes5.dex */
public class A extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public float f39011d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC5276d f39012e;

    /* renamed from: f, reason: collision with root package name */
    public Cc.c f39013f;

    /* renamed from: g, reason: collision with root package name */
    public Cc.c f39014g;

    public A(AbstractC5276d abstractC5276d) {
        this.f39011d = 0.65f;
        this.f39013f = null;
        this.f39014g = null;
        if (abstractC5276d == null) {
            this.f39012e = new I0();
        } else {
            this.f39012e = abstractC5276d;
            this.f39248a = abstractC5276d.f39248a;
        }
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39012e.f(y02);
        float fN = y02.n().N(y02.m());
        float fJ = this.f39011d * R0.j(0, y02);
        if (this.f39013f == null) {
            return new H(abstractC5284hF, fN, fJ);
        }
        y02.f39193l = true;
        return new H(abstractC5284hF, fN, fJ, this.f39014g, this.f39013f);
    }

    public A(AbstractC5276d abstractC5276d, Cc.c cVar, Cc.c cVar2) {
        this(abstractC5276d);
        this.f39013f = cVar;
        this.f39014g = cVar2;
    }
}
