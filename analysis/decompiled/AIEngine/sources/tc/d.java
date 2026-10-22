package tc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d<E> extends o<Object, List<Object>, ArrayList<Object>> {

    /* renamed from: b, reason: collision with root package name */
    public final c f12970b;

    public d(pc.a<E> aVar) {
        super(aVar);
        rc.e elementDesc = aVar.d();
        kotlin.jvm.internal.g.f(elementDesc, "elementDesc");
        this.f12970b = new c(elementDesc);
    }

    @Override // pc.c
    public final rc.e d() {
        return this.f12970b;
    }

    @Override // tc.a
    public final Object e() {
        return new ArrayList();
    }

    @Override // tc.a
    public final int f(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.g.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // tc.a
    public final Iterator g(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.g.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // tc.a
    public final int h(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.g.f(collection, "<this>");
        return collection.size();
    }

    @Override // tc.a
    public final Object k(Object obj) {
        kotlin.jvm.internal.g.f(null, "<this>");
        return new ArrayList((Collection) null);
    }

    @Override // tc.a
    public final Object l(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.g.f(arrayList, "<this>");
        return arrayList;
    }

    @Override // tc.o
    public final void m(int i10, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.g.f(arrayList, "<this>");
        arrayList.add(i10, obj2);
    }
}
