package j4;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i5) {
        this.arity = i5;
    }

    @Override // j4.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strG = w.g(this);
        k.f(strG, "renderLambdaToString(...)");
        return strG;
    }
}
