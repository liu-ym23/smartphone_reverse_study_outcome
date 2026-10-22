package B9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class b0 extends AbstractC0188o {
    public final Z7.d b;
    public final C0176c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Z7.d kClass, x9.b eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.k.f(kClass, "kClass");
        kotlin.jvm.internal.k.f(eSerializer, "eSerializer");
        this.b = kClass;
        z9.g elementDesc = eSerializer.getDescriptor();
        kotlin.jvm.internal.k.f(elementDesc, "elementDesc");
        this.c = new C0176c(elementDesc, 0);
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
        Object[] objArr = (Object[]) obj;
        kotlin.jvm.internal.k.f(objArr, "<this>");
        return kotlin.jvm.internal.k.j(objArr);
    }

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        Object[] objArr = (Object[]) obj;
        kotlin.jvm.internal.k.f(objArr, "<this>");
        return objArr.length;
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.c;
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        kotlin.jvm.internal.k.f(null, "<this>");
        D7.q.L(null);
        throw null;
    }

    @Override // B9.AbstractC0174a
    public final Object j(Object obj) throws NegativeArraySizeException {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        Z7.d eClass = this.b;
        kotlin.jvm.internal.k.f(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) M.a.Z(eClass), arrayList.size());
        kotlin.jvm.internal.k.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        kotlin.jvm.internal.k.e(array, "toArray(...)");
        return array;
    }

    @Override // B9.AbstractC0188o
    public final void k(int i, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        arrayList.add(i, obj2);
    }
}
