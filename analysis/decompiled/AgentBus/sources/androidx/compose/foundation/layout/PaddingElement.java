package androidx.compose.foundation.layout;

import d2.f;
import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import r.b0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Li1/w0;", "Lr/b0;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PaddingElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f732a;

    /* renamed from: b, reason: collision with root package name */
    public final float f733b;

    /* renamed from: c, reason: collision with root package name */
    public final float f734c;

    /* renamed from: d, reason: collision with root package name */
    public final float f735d;

    public PaddingElement(float f10, float f11, float f12, float f13) {
        this.f732a = f10;
        this.f733b = f11;
        this.f734c = f12;
        this.f735d = f13;
        if ((f10 < 0.0f && !f.a(f10, Float.NaN)) || ((f11 < 0.0f && !f.a(f11, Float.NaN)) || ((f12 < 0.0f && !f.a(f12, Float.NaN)) || (f13 < 0.0f && !f.a(f13, Float.NaN))))) {
            throw new IllegalArgumentException("Padding must be non-negative");
        }
    }

    @Override // i1.w0
    public final l d() {
        b0 b0Var = new b0();
        b0Var.f8845t = this.f732a;
        b0Var.f8846u = this.f733b;
        b0Var.f8847v = this.f734c;
        b0Var.f8848w = this.f735d;
        b0Var.f8849x = true;
        return b0Var;
    }

    public final boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && f.a(this.f732a, paddingElement.f732a) && f.a(this.f733b, paddingElement.f733b) && f.a(this.f734c, paddingElement.f734c) && f.a(this.f735d, paddingElement.f735d);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        b0 b0Var = (b0) lVar;
        b0Var.f8845t = this.f732a;
        b0Var.f8846u = this.f733b;
        b0Var.f8847v = this.f734c;
        b0Var.f8848w = this.f735d;
        b0Var.f8849x = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + x.d(this.f735d, x.d(this.f734c, x.d(this.f733b, Float.hashCode(this.f732a) * 31, 31), 31), 31);
    }
}
