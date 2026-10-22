package B9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: B9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0177d extends AbstractC0188o {
    public final C0176c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0177d(x9.b element) {
        super(element);
        kotlin.jvm.internal.k.f(element, "element");
        z9.g elementDesc = element.getDescriptor();
        kotlin.jvm.internal.k.f(elementDesc, "elementDesc");
        this.b = new C0176c(elementDesc, 1);
    }

    @Override // B9.AbstractC0174a
    public final Object a() {
        return new ArrayList();
    }

    @Override // B9.AbstractC0174a
    public final int b(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // B9.AbstractC0174a
    public final void c(int i, Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    @Override // B9.AbstractC0174a
    public final Iterator d(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.k.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.k.f(collection, "<this>");
        return collection.size();
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.b;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        kotlin.jvm.internal.k.f(null, "<this>");
        return new ArrayList((Collection) null);
    }

    @Override // B9.AbstractC0174a
    public final Object j(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        return arrayList;
    }

    @Override // B9.AbstractC0188o
    public final void k(int i, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        arrayList.add(i, obj2);
    }
}
