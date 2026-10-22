package d.h.b;

import java.io.Serializable;

/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p<R> implements j<R>, Serializable {
    private final int arity;

    public p(int r1) {
        this.arity = r1;
    }

    @Override // d.h.b.j
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String r1 = aa.a(this);
        o.c(r1, "renderLambdaToString(...)");
        return r1;
    }
}
