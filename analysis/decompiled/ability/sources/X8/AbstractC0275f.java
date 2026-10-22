package X8;

import h8.C1504L;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;

/* renamed from: X8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0275f implements K {

    /* renamed from: a, reason: collision with root package name */
    public int f1530a;
    public final W8.d b;

    public AbstractC0275f(W8.l storageManager) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.b = new W8.d((W8.i) storageManager, new I8.e(this, 9), new J4.b(this, 6));
    }

    public abstract Collection b();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof K) && obj.hashCode() == hashCode()) {
            K k = (K) obj;
            if (k.getParameters().size() == getParameters().size()) {
                InterfaceC1524g interfaceC1524gD = d();
                InterfaceC1524g interfaceC1524gD2 = k.d();
                if (interfaceC1524gD2 == null || Z8.i.f(interfaceC1524gD) || J8.e.o(interfaceC1524gD) || Z8.i.f(interfaceC1524gD2) || J8.e.o(interfaceC1524gD2)) {
                    return false;
                }
                return j(interfaceC1524gD2);
            }
        }
        return false;
    }

    public abstract w g();

    public abstract C1504L h();

    public final int hashCode() {
        int i = this.f1530a;
        if (i != 0) {
            return i;
        }
        InterfaceC1524g interfaceC1524gD = d();
        int iIdentityHashCode = (Z8.i.f(interfaceC1524gD) || J8.e.o(interfaceC1524gD)) ? System.identityHashCode(this) : J8.e.g(interfaceC1524gD).f689a.hashCode();
        this.f1530a = iIdentityHashCode;
        return iIdentityHashCode;
    }

    @Override // X8.K
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final List e() {
        return ((C0274e) this.b.invoke()).b;
    }

    public abstract boolean j(InterfaceC1524g interfaceC1524g);

    public List k(List supertypes) {
        kotlin.jvm.internal.k.f(supertypes, "supertypes");
        return supertypes;
    }
}
