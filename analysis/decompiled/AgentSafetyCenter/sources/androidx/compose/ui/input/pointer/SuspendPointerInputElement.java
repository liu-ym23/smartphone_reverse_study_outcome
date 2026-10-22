package androidx.compose.ui.input.pointer;

import o1.i0;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SuspendPointerInputElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final Object f969c;

    /* renamed from: f, reason: collision with root package name */
    public final Object f970f;

    /* renamed from: g, reason: collision with root package name */
    public final PointerInputEventHandler f971g;

    public SuspendPointerInputElement(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler, int i) {
        obj2 = (i & 2) != 0 ? null : obj2;
        this.f969c = obj;
        this.f970f = obj2;
        this.f971g = pointerInputEventHandler;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        return k.a(this.f969c, suspendPointerInputElement.f969c) && k.a(this.f970f, suspendPointerInputElement.f970f) && this.f971g == suspendPointerInputElement.f971g;
    }

    @Override // u1.y0
    public final l g() {
        return new i0(this.f969c, this.f970f, this.f971g);
    }

    public final int hashCode() {
        Object obj = this.f969c;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f970f;
        return this.f971g.hashCode() + ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 961);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        i0 i0Var = (i0) lVar;
        Object obj = i0Var.f9048s;
        Object obj2 = this.f969c;
        boolean z10 = !k.a(obj, obj2);
        i0Var.f9048s = obj2;
        Object obj3 = i0Var.f9049t;
        Object obj4 = this.f970f;
        if (!k.a(obj3, obj4)) {
            z10 = true;
        }
        i0Var.f9049t = obj4;
        Class<?> cls = i0Var.f9051v.getClass();
        PointerInputEventHandler pointerInputEventHandler = this.f971g;
        if (cls == pointerInputEventHandler.getClass() ? z10 : true) {
            i0Var.C0();
        }
        i0Var.f9051v = pointerInputEventHandler;
    }
}
