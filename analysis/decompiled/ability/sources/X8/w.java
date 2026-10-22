package X8;

import a9.InterfaceC0310b;
import i8.InterfaceC1555a;
import i8.InterfaceC1561g;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class w implements InterfaceC1555a, InterfaceC0310b {

    /* renamed from: a, reason: collision with root package name */
    public int f1537a;

    public abstract List L();

    public abstract H M();

    public abstract K Q();

    public abstract boolean W();

    public abstract w Y(Y8.f fVar);

    public abstract U Z();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (W() == wVar.W()) {
            return AbstractC0272c.z(Y8.m.f1578a, Z(), wVar.Z());
        }
        return false;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return AbstractC0277h.a(M());
    }

    public final int hashCode() {
        int iHashCode;
        int i = this.f1537a;
        if (i != 0) {
            return i;
        }
        if (AbstractC0272c.k(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (W() ? 1 : 0) + ((L().hashCode() + (Q().hashCode() * 31)) * 31);
        }
        this.f1537a = iHashCode;
        return iHashCode;
    }

    public abstract Q8.o w();
}
