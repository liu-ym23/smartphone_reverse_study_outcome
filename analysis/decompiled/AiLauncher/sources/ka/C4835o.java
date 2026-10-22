package ka;

import A.h;
import Z8.F;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import p9.InterfaceC5074l;

/* renamed from: ka.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4835o {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> b(Collection<? extends H> collection, InterfaceC5074l<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.a> descriptorByHandle) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        Ia.k kVarA = Ia.k.f3419c.a();
        while (!linkedList.isEmpty()) {
            Object objQ0 = F.q0(linkedList);
            Ia.k kVarA2 = Ia.k.f3419c.a();
            Collection<h.Companion> collectionP = OverridingUtil.p(objQ0, linkedList, descriptorByHandle, new C4834n(kVarA2));
            kotlin.jvm.internal.p.h(collectionP, "extractMembersOverridableInBothWays(...)");
            if (collectionP.size() == 1 && kVarA2.isEmpty()) {
                Object objW0 = F.W0(collectionP);
                kotlin.jvm.internal.p.h(objW0, "single(...)");
                kVarA.add(objW0);
            } else {
                h.b bVar = (Object) OverridingUtil.L(collectionP, descriptorByHandle);
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = descriptorByHandle.invoke(bVar);
                for (h.Companion companion : collectionP) {
                    kotlin.jvm.internal.p.f(companion);
                    if (!OverridingUtil.B(aVarInvoke, descriptorByHandle.invoke(companion))) {
                        kVarA2.add(companion);
                    }
                }
                if (!kVarA2.isEmpty()) {
                    kVarA.addAll(kVarA2);
                }
                kVarA.add(bVar);
            }
        }
        return kVarA;
    }

    public static final Y8.t c(Ia.k kVar, Object obj) {
        kotlin.jvm.internal.p.f(obj);
        kVar.add(obj);
        return Y8.t.f7040a;
    }
}
