package kotlin.coroutines.jvm.internal;

import j4.w;

/* loaded from: classes.dex */
public abstract class l extends d implements j4.h<Object> {
    private final int arity;

    public l(int i5, Z3.e<Object> eVar) {
        super(eVar);
        this.arity = i5;
    }

    @Override // j4.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strF = w.f(this);
        j4.k.f(strF, "renderLambdaToString(...)");
        return strF;
    }

    public l(int i5) {
        this(i5, null);
    }
}
