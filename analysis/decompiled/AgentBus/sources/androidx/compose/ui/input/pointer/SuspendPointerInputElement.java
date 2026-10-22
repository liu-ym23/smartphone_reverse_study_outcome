package androidx.compose.ui.input.pointer;

import c1.s;
import c1.x;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import n7.b;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendPointerInputElement;", "Li1/w0;", "Lc1/x;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SuspendPointerInputElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f765a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f766b;

    /* renamed from: c, reason: collision with root package name */
    public final s f767c;

    public SuspendPointerInputElement(Object obj, b bVar, s sVar, int i2) {
        bVar = (i2 & 2) != 0 ? null : bVar;
        this.f765a = obj;
        this.f766b = bVar;
        this.f767c = sVar;
    }

    @Override // i1.w0
    public final l d() {
        return new x(this.f765a, this.f766b, this.f767c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        return this.f765a.equals(suspendPointerInputElement.f765a) && k.a(this.f766b, suspendPointerInputElement.f766b) && this.f767c == suspendPointerInputElement.f767c;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        x xVar = (x) lVar;
        Object obj = xVar.f1850t;
        Object obj2 = this.f765a;
        boolean z4 = !k.a(obj, obj2);
        xVar.f1850t = obj2;
        Object obj3 = xVar.f1851u;
        Object obj4 = this.f766b;
        if (!k.a(obj3, obj4)) {
            z4 = true;
        }
        xVar.f1851u = obj4;
        if (xVar.f1853w.getClass() == s.class ? z4 : true) {
            xVar.m0();
        }
        xVar.f1853w = this.f767c;
    }

    public final int hashCode() {
        int iHashCode = this.f765a.hashCode() * 31;
        Object obj = this.f766b;
        return this.f767c.hashCode() + ((iHashCode + (obj != null ? obj.hashCode() : 0)) * 961);
    }
}
