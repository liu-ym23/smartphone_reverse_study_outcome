package androidx.compose.ui.semantics;

import a2.c;
import u1.y0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AppendedSemanticsElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f987c;

    /* renamed from: f, reason: collision with root package name */
    public l f988f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.f987c == appendedSemanticsElement.f987c && this.f988f == appendedSemanticsElement.f988f;
    }

    @Override // u1.y0
    public final w0.l g() {
        boolean z10 = this.f987c;
        l lVar = this.f988f;
        c cVar = new c();
        cVar.f37s = z10;
        cVar.f38t = lVar;
        return cVar;
    }

    public final int hashCode() {
        return this.f988f.hashCode() + (Boolean.hashCode(this.f987c) * 31);
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        c cVar = (c) lVar;
        cVar.f37s = this.f987c;
        cVar.f38t = this.f988f;
    }
}
