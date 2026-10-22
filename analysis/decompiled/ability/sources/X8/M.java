package X8;

import h8.InterfaceC1507O;
import v8.C2065a;

/* loaded from: classes4.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1507O f1525a;
    public final C2065a b;

    public M(InterfaceC1507O typeParameter, C2065a typeAttr) {
        kotlin.jvm.internal.k.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.k.f(typeAttr, "typeAttr");
        this.f1525a = typeParameter;
        this.b = typeAttr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof M)) {
            return false;
        }
        M m = (M) obj;
        return kotlin.jvm.internal.k.b(m.f1525a, this.f1525a) && kotlin.jvm.internal.k.b(m.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = this.f1525a.hashCode();
        return this.b.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public final String toString() {
        return "DataToEraseUpperBound(typeParameter=" + this.f1525a + ", typeAttr=" + this.b + ')';
    }
}
