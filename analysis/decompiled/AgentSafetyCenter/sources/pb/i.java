package pb;

import yb.v;
import yb.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i extends c implements yb.h {
    private final int arity;

    public i(int i, nb.c cVar) {
        super(cVar);
        this.arity = i;
    }

    @Override // yb.h
    public int getArity() {
        return this.arity;
    }

    @Override // pb.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        v.f16099a.getClass();
        return w.a(this);
    }
}
