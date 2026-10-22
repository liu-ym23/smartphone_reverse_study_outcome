package androidx.compose.foundation;

import a0.e;
import d2.f;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import o.n;
import q7.k;
import u0.c0;
import u0.e0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/BorderModifierNodeElement;", "Li1/w0;", "Lo/n;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BorderModifierNodeElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f707a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f708b;

    public BorderModifierNodeElement(e0 e0Var, c0 c0Var) {
        float f10 = e.f38a;
        this.f707a = e0Var;
        this.f708b = c0Var;
    }

    @Override // i1.w0
    public final l d() {
        float f10 = e.f38a;
        return new n(this.f707a, this.f708b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        float f10 = e.f38a;
        return f.a(f10, f10) && this.f707a.equals(borderModifierNodeElement.f707a) && k.a(this.f708b, borderModifierNodeElement.f708b);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        n nVar = (n) lVar;
        float f10 = e.f38a;
        float f11 = nVar.f7091w;
        r0.b bVar = nVar.f7094z;
        if (!f.a(f11, f10)) {
            nVar.f7091w = f10;
            bVar.l0();
        }
        e0 e0Var = nVar.f7092x;
        e0 e0Var2 = this.f707a;
        if (!k.a(e0Var, e0Var2)) {
            nVar.f7092x = e0Var2;
            bVar.l0();
        }
        c0 c0Var = nVar.f7093y;
        c0 c0Var2 = this.f708b;
        if (k.a(c0Var, c0Var2)) {
            return;
        }
        nVar.f7093y = c0Var2;
        bVar.l0();
    }

    public final int hashCode() {
        return this.f708b.hashCode() + ((this.f707a.hashCode() + (Float.hashCode(e.f38a) * 31)) * 31);
    }

    public final String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) f.b(e.f38a)) + ", brush=" + this.f707a + ", shape=" + this.f708b + ')';
    }
}
