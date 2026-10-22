package androidx.compose.foundation.layout;

import d2.f;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import r.m0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Li1/w0;", "Lr/m0;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class UnspecifiedConstraintsElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f742a;

    /* renamed from: b, reason: collision with root package name */
    public final float f743b;

    public UnspecifiedConstraintsElement(float f10, float f11) {
        this.f742a = f10;
        this.f743b = f11;
    }

    @Override // i1.w0
    public final l d() {
        m0 m0Var = new m0();
        m0Var.f8895t = this.f742a;
        m0Var.f8896u = this.f743b;
        return m0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        return f.a(this.f742a, unspecifiedConstraintsElement.f742a) && f.a(this.f743b, unspecifiedConstraintsElement.f743b);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        m0 m0Var = (m0) lVar;
        m0Var.f8895t = this.f742a;
        m0Var.f8896u = this.f743b;
    }

    public final int hashCode() {
        return Float.hashCode(this.f743b) + (Float.hashCode(this.f742a) * 31);
    }
}
