package yb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l implements h, Serializable {
    private final int arity;

    public l(int i) {
        this.arity = i;
    }

    @Override // yb.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        v.f16099a.getClass();
        return w.a(this);
    }
}
