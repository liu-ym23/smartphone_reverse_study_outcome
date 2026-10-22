package q7;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class m implements g, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final int f8813f;

    public m(int i2) {
        this.f8813f = i2;
    }

    @Override // q7.g
    public final int getArity() {
        return this.f8813f;
    }

    public final String toString() {
        String strH = w.f8821a.h(this);
        k.d(strH, "renderLambdaToString(...)");
        return strH;
    }
}
