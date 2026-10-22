package androidx.compose.foundation.layout;

import u1.y0;
import w.h0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class LayoutWeightElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f879c;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f880f;

    public LayoutWeightElement(float f5, boolean z10) {
        this.f879c = f5;
        this.f880f = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.f879c == layoutWeightElement.f879c && this.f880f == layoutWeightElement.f880f;
    }

    @Override // u1.y0
    public final l g() {
        h0 h0Var = new h0();
        h0Var.f14980s = this.f879c;
        h0Var.f14981t = this.f880f;
        return h0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f880f) + (Float.hashCode(this.f879c) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        h0 h0Var = (h0) lVar;
        h0Var.f14980s = this.f879c;
        h0Var.f14981t = this.f880f;
    }
}
