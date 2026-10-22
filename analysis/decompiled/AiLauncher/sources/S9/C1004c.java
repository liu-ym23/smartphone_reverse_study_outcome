package S9;

import E9.InterfaceC0797b;
import Z8.C1172u;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ma.AbstractC4927g;
import ma.C4922b;

/* renamed from: S9.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1004c extends AbstractC1003b<F9.c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1004c(A javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        kotlin.jvm.internal.p.i(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    @Override // S9.AbstractC1003b
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Iterable<F9.c> m(F9.c cVar) {
        F9.g annotations;
        kotlin.jvm.internal.p.i(cVar, "<this>");
        InterfaceC0797b interfaceC0797bL = DescriptorUtilsKt.l(cVar);
        return (interfaceC0797bL == null || (annotations = interfaceC0797bL.getAnnotations()) == null) ? C1173v.m() : annotations;
    }

    public final List<String> B(AbstractC4927g<?> abstractC4927g) {
        if (!(abstractC4927g instanceof C4922b)) {
            return abstractC4927g instanceof ma.k ? C1172u.e(((ma.k) abstractC4927g).c().e()) : C1173v.m();
        }
        List<? extends AbstractC4927g<?>> listB = ((C4922b) abstractC4927g).b();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, B((AbstractC4927g) it.next()));
        }
        return arrayList;
    }

    @Override // S9.AbstractC1003b
    public boolean o() {
        return false;
    }

    @Override // S9.AbstractC1003b
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable<String> c(F9.c cVar, boolean z10) {
        kotlin.jvm.internal.p.i(cVar, "<this>");
        Map<ga.e, AbstractC4927g<?>> mapA = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ga.e, AbstractC4927g<?>> entry : mapA.entrySet()) {
            Z8.A.E(arrayList, (!z10 || kotlin.jvm.internal.p.d(entry.getKey(), F.f5685c)) ? B(entry.getValue()) : C1173v.m());
        }
        return arrayList;
    }

    @Override // S9.AbstractC1003b
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ga.c k(F9.c cVar) {
        kotlin.jvm.internal.p.i(cVar, "<this>");
        return cVar.f();
    }

    @Override // S9.AbstractC1003b
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object l(F9.c cVar) {
        kotlin.jvm.internal.p.i(cVar, "<this>");
        InterfaceC0797b interfaceC0797bL = DescriptorUtilsKt.l(cVar);
        kotlin.jvm.internal.p.f(interfaceC0797bL);
        return interfaceC0797bL;
    }
}
