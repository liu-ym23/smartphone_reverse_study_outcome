package androidx.compose.foundation.layout;

import d2.f;
import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import r.k0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Li1/w0;", "Lr/k0;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f737a;

    /* renamed from: b, reason: collision with root package name */
    public final float f738b;

    /* renamed from: c, reason: collision with root package name */
    public final float f739c;

    /* renamed from: d, reason: collision with root package name */
    public final float f740d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f741e;

    public SizeElement(float f10, float f11, float f12, float f13) {
        this.f737a = f10;
        this.f738b = f11;
        this.f739c = f12;
        this.f740d = f13;
        this.f741e = true;
    }

    @Override // i1.w0
    public final l d() {
        k0 k0Var = new k0();
        k0Var.f8880t = this.f737a;
        k0Var.f8881u = this.f738b;
        k0Var.f8882v = this.f739c;
        k0Var.f8883w = this.f740d;
        k0Var.f8884x = this.f741e;
        return k0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return f.a(this.f737a, sizeElement.f737a) && f.a(this.f738b, sizeElement.f738b) && f.a(this.f739c, sizeElement.f739c) && f.a(this.f740d, sizeElement.f740d) && this.f741e == sizeElement.f741e;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        k0 k0Var = (k0) lVar;
        k0Var.f8880t = this.f737a;
        k0Var.f8881u = this.f738b;
        k0Var.f8882v = this.f739c;
        k0Var.f8883w = this.f740d;
        k0Var.f8884x = this.f741e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f741e) + x.d(this.f740d, x.d(this.f739c, x.d(this.f738b, Float.hashCode(this.f737a) * 31, 31), 31), 31);
    }

    public /* synthetic */ SizeElement(float f10, float f11, float f12, float f13, int i2) {
        this((i2 & 1) != 0 ? Float.NaN : f10, (i2 & 2) != 0 ? Float.NaN : f11, (i2 & 4) != 0 ? Float.NaN : f12, (i2 & 8) != 0 ? Float.NaN : f13);
    }
}
