package z2;

/* loaded from: classes.dex */
public abstract class l extends AbstractC1345b {
    public l(Object[] objArr) {
        super(objArr);
        int i5 = (int) i();
        if (i5 % 2 == 0) {
            o(i5);
        } else {
            o(i5 + 1);
        }
        n(0.0d);
    }

    @Override // z2.f
    public double e(int i5) {
        return p(i5);
    }

    public abstract int p(int i5);
}
