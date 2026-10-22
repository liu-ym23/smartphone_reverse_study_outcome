package androidx.compose.foundation.lazy.layout;

import java.lang.invoke.VarHandle;
import u1.y0;
import w0.l;
import y.e0;
import y.p0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class TraversablePrefetchStateModifierElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public e0 f914c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TraversablePrefetchStateModifierElement) && k.a(this.f914c, ((TraversablePrefetchStateModifierElement) obj).f914c);
    }

    @Override // u1.y0
    public final l g() {
        e0 e0Var = this.f914c;
        p0 p0Var = new p0();
        p0Var.f15814s = e0Var;
        VarHandle.storeStoreFence();
        return p0Var;
    }

    public final int hashCode() {
        return this.f914c.hashCode();
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((p0) lVar).f15814s = this.f914c;
    }

    public final String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.f914c + ')';
    }
}
