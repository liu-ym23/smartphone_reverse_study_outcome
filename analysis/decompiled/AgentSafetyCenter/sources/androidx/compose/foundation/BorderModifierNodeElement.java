package androidx.compose.foundation;

import a1.h;
import d1.j0;
import d1.l0;
import java.lang.invoke.VarHandle;
import o2.f;
import t.m;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class BorderModifierNodeElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public float f840c;

    /* renamed from: f, reason: collision with root package name */
    public l0 f841f;

    /* renamed from: g, reason: collision with root package name */
    public j0 f842g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        return f.b(this.f840c, borderModifierNodeElement.f840c) && k.a(this.f841f, borderModifierNodeElement.f841f) && k.a(this.f842g, borderModifierNodeElement.f842g);
    }

    @Override // u1.y0
    public final l g() {
        float f5 = this.f840c;
        l0 l0Var = this.f841f;
        j0 j0Var = this.f842g;
        m mVar = new m();
        mVar.f13043v = f5;
        mVar.f13044w = l0Var;
        mVar.f13045x = j0Var;
        a2.m mVar2 = new a2.m(mVar, 14);
        a1.d dVar = new a1.d();
        int i = h.f20c;
        a1.c cVar = new a1.c();
        cVar.f11s = dVar;
        cVar.f13u = mVar2;
        dVar.f14c = cVar;
        VarHandle.storeStoreFence();
        mVar.B0(cVar);
        mVar.f13046y = cVar;
        VarHandle.storeStoreFence();
        return mVar;
    }

    public final int hashCode() {
        return this.f842g.hashCode() + ((this.f841f.hashCode() + (Float.hashCode(this.f840c) * 31)) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        m mVar = (m) lVar;
        float f5 = this.f840c;
        float f10 = mVar.f13043v;
        a1.c cVar = mVar.f13046y;
        if (!f.b(f10, f5)) {
            mVar.f13043v = f5;
            cVar.B0();
        }
        l0 l0Var = this.f841f;
        if (!k.a(mVar.f13044w, l0Var)) {
            mVar.f13044w = l0Var;
            cVar.B0();
        }
        j0 j0Var = this.f842g;
        if (k.a(mVar.f13045x, j0Var)) {
            return;
        }
        mVar.f13045x = j0Var;
        cVar.B0();
    }

    public final String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) f.c(this.f840c)) + ", brush=" + this.f841f + ", shape=" + this.f842g + ')';
    }
}
