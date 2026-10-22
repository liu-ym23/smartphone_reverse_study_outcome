package pb;

import yb.v;
import yb.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h extends g implements yb.h {

    /* renamed from: c, reason: collision with root package name */
    public final int f9942c;

    public h(nb.c cVar) {
        super(cVar);
        this.f9942c = 2;
    }

    @Override // yb.h
    public final int getArity() {
        return this.f9942c;
    }

    @Override // pb.a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        v.f16099a.getClass();
        return w.a(this);
    }
}
