package ya;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import ka.C4828h;

/* renamed from: ya.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6014u implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public int f44129a;

    @Override // ya.v0
    public abstract InterfaceC0799d d();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0) || obj.hashCode() != hashCode()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        if (v0Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        InterfaceC0799d interfaceC0799dD = d();
        InterfaceC0799d interfaceC0799dD2 = v0Var.d();
        if (interfaceC0799dD2 != null && i(interfaceC0799dD) && i(interfaceC0799dD2)) {
            return j(interfaceC0799dD2);
        }
        return false;
    }

    public final boolean h(InterfaceC0799d first, InterfaceC0799d second) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        if (!kotlin.jvm.internal.p.d(first.getName(), second.getName())) {
            return false;
        }
        InterfaceC0803h interfaceC0803hB = first.b();
        for (InterfaceC0803h interfaceC0803hB2 = second.b(); interfaceC0803hB != null && interfaceC0803hB2 != null; interfaceC0803hB2 = interfaceC0803hB2.b()) {
            if (interfaceC0803hB instanceof InterfaceC0819y) {
                return interfaceC0803hB2 instanceof InterfaceC0819y;
            }
            if (interfaceC0803hB2 instanceof InterfaceC0819y) {
                return false;
            }
            if (interfaceC0803hB instanceof E9.E) {
                return (interfaceC0803hB2 instanceof E9.E) && kotlin.jvm.internal.p.d(((E9.E) interfaceC0803hB).f(), ((E9.E) interfaceC0803hB2).f());
            }
            if ((interfaceC0803hB2 instanceof E9.E) || !kotlin.jvm.internal.p.d(interfaceC0803hB.getName(), interfaceC0803hB2.getName())) {
                return false;
            }
            interfaceC0803hB = interfaceC0803hB.b();
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f44129a;
        if (i10 != 0) {
            return i10;
        }
        InterfaceC0799d interfaceC0799dD = d();
        int iHashCode = i(interfaceC0799dD) ? C4828h.m(interfaceC0799dD).hashCode() : System.identityHashCode(this);
        this.f44129a = iHashCode;
        return iHashCode;
    }

    public final boolean i(InterfaceC0799d interfaceC0799d) {
        return (Aa.i.m(interfaceC0799d) || C4828h.E(interfaceC0799d)) ? false : true;
    }

    public abstract boolean j(InterfaceC0799d interfaceC0799d);
}
