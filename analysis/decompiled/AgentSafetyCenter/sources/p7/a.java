package p7;

import java.lang.invoke.VarHandle;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a implements m7.o {
    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        Type type = aVar.getType();
        boolean z10 = type instanceof GenericArrayType;
        if (!z10 && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type genericComponentType = z10 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
        m7.n nVarC = eVar.c(t7.a.get(genericComponentType));
        Class clsG = o7.h.g(genericComponentType);
        b bVar = new b();
        bVar.f9834b = new r(eVar, nVarC, clsG);
        bVar.f9833a = clsG;
        VarHandle.storeStoreFence();
        return bVar;
    }
}
