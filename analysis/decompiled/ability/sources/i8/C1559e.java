package i8;

import java.util.Iterator;
import kotlin.collections.EmptyList;

/* renamed from: i8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1559e implements InterfaceC1561g {
    @Override // i8.InterfaceC1561g
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return EmptyList.f4893a.iterator();
    }

    @Override // i8.InterfaceC1561g
    public final boolean k(G8.c cVar) {
        return N9.j.B(this, cVar);
    }

    @Override // i8.InterfaceC1561g
    public final InterfaceC1556b m(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return null;
    }

    public final String toString() {
        return "EMPTY";
    }
}
