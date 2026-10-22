package androidx.compose.foundation.layout;

import s.f;
import u1.y0;
import w.b0;
import w0.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class FillElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final int f876c;

    /* renamed from: f, reason: collision with root package name */
    public final float f877f;

    public FillElement(int i, float f5) {
        this.f876c = i;
        this.f877f = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        return this.f876c == fillElement.f876c && this.f877f == fillElement.f877f;
    }

    @Override // u1.y0
    public final l g() {
        b0 b0Var = new b0();
        b0Var.f14956s = this.f876c;
        b0Var.f14957t = this.f877f;
        return b0Var;
    }

    public final int hashCode() {
        return Float.hashCode(this.f877f) + (f.c(this.f876c) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        b0 b0Var = (b0) lVar;
        b0Var.f14956s = this.f876c;
        b0Var.f14957t = this.f877f;
    }
}
