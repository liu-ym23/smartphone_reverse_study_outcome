package i7;

import q7.k;
import q7.w;

/* loaded from: classes.dex */
public abstract class i extends c implements q7.g {
    private final int arity;

    public i(int i2, g7.d dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // q7.g
    public int getArity() {
        return this.arity;
    }

    @Override // i7.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strG = w.f8821a.g(this);
        k.d(strG, "renderLambdaToString(...)");
        return strG;
    }
}
