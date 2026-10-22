package i7;

import q7.k;
import q7.w;

/* loaded from: classes.dex */
public abstract class h extends g implements q7.g {

    /* renamed from: f, reason: collision with root package name */
    public final int f4735f;

    public h(int i2, g7.d dVar) {
        super(dVar);
        this.f4735f = i2;
    }

    @Override // q7.g
    public final int getArity() {
        return this.f4735f;
    }

    @Override // i7.a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strG = w.f8821a.g(this);
        k.d(strG, "renderLambdaToString(...)");
        return strG;
    }
}
