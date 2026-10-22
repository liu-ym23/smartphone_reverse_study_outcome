package W9;

import E9.InterfaceC0803h;
import H9.AbstractC0823b;
import Z8.C1172u;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final class Z extends AbstractC0823b {

    /* renamed from: k, reason: collision with root package name */
    public final V9.k f6717k;

    /* renamed from: l, reason: collision with root package name */
    public final Z9.y f6718l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(V9.k c10, Z9.y javaTypeParameter, int i10, InterfaceC0803h containingDeclaration) {
        super(c10.e(), containingDeclaration, new V9.g(c10, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, i10, E9.W.f2444a, c10.a().v());
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(javaTypeParameter, "javaTypeParameter");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        this.f6717k = c10;
        this.f6718l = javaTypeParameter;
    }

    @Override // H9.AbstractC0829h
    public List<ya.S> A0(List<? extends ya.S> bounds) {
        kotlin.jvm.internal.p.i(bounds, "bounds");
        return this.f6717k.a().r().r(this, bounds, this.f6717k);
    }

    @Override // H9.AbstractC0829h
    public void E0(ya.S type) {
        kotlin.jvm.internal.p.i(type, "type");
    }

    @Override // H9.AbstractC0829h
    public List<ya.S> F0() {
        return G0();
    }

    public final List<ya.S> G0() {
        Collection<Z9.j> upperBounds = this.f6718l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            AbstractC5990d0 abstractC5990d0I = this.f6717k.d().g().i();
            kotlin.jvm.internal.p.h(abstractC5990d0I, "getAnyType(...)");
            AbstractC5990d0 abstractC5990d0J = this.f6717k.d().g().J();
            kotlin.jvm.internal.p.h(abstractC5990d0J, "getNullableAnyType(...)");
            return C1172u.e(ya.V.e(abstractC5990d0I, abstractC5990d0J));
        }
        Collection<Z9.j> collection = upperBounds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Z z10 = this;
            arrayList.add(this.f6717k.g().p((Z9.j) it.next(), X9.b.b(TypeUsage.COMMON, false, false, z10, 3, null)));
            this = z10;
        }
        return arrayList;
    }
}
