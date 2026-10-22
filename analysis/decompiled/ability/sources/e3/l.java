package e3;

/* loaded from: classes3.dex */
public final class l extends C1417f {
    public final C1418g c;
    public final float d;

    public l(C1418g c1418g, float f) {
        super(0);
        this.c = c1418g;
        this.d = f;
    }

    @Override // e3.C1417f
    public final boolean m() {
        return true;
    }

    @Override // e3.C1417f
    public final void n(float f, float f7, float f9, z zVar) {
        this.c.n(f, f7 - this.d, f9, zVar);
    }
}
