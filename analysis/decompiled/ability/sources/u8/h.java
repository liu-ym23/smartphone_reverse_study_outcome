package u8;

import h8.AbstractC1538u;
import h8.InterfaceC1507O;
import java.util.ArrayList;
import java.util.Iterator;
import t8.C2024a;
import t8.InterfaceC2028e;

/* loaded from: classes4.dex */
public final class h implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6719a;
    public final j b;

    public /* synthetic */ h(j jVar, int i) {
        this.f6719a = i;
        this.b = jVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f6719a) {
            case 0:
                j jVar = this.b;
                if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(jVar) == null) {
                    return null;
                }
                ((C2024a) jVar.g.f903a).f6677w.getClass();
                return null;
            case 1:
                j jVar2 = this.b;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar = jVar2.h;
                ArrayList typeParameters = aVar.getTypeParameters();
                ArrayList arrayList = new ArrayList(D7.w.c0(typeParameters, 10));
                Iterator it = typeParameters.iterator();
                while (it.hasNext()) {
                    n8.v vVar = (n8.v) it.next();
                    InterfaceC1507O interfaceC1507OA = ((InterfaceC2028e) jVar2.f6721j.b).a(vVar);
                    if (interfaceC1507OA == null) {
                        throw new AssertionError("Parameter " + vVar + " surely belongs to class " + aVar + ", so it must be resolved");
                    }
                    arrayList.add(interfaceC1507OA);
                }
                return arrayList;
            default:
                return AbstractC1538u.c(this.b);
        }
    }
}
