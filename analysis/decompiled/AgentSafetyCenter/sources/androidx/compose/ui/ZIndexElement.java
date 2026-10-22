package androidx.compose.ui;

import k0.a;
import u1.y0;
import w0.l;
import w0.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ZIndexElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public float f944c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZIndexElement) && Float.compare(this.f944c, ((ZIndexElement) obj).f944c) == 0;
    }

    @Override // u1.y0
    public final l g() {
        float f5 = this.f944c;
        o oVar = new o();
        oVar.f15127s = f5;
        return oVar;
    }

    public final int hashCode() {
        return Float.hashCode(this.f944c);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((o) lVar).f15127s = this.f944c;
    }

    public final String toString() {
        return a.q(new StringBuilder("ZIndexElement(zIndex="), this.f944c, ')');
    }
}
