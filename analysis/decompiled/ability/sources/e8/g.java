package e8;

import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import k8.w;
import k8.z;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class g implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4382a;
    public final i b;

    public /* synthetic */ g(i iVar, int i) {
        this.f4382a = i;
        this.b = iVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f4382a;
        i iVar = this.b;
        switch (i) {
            case 0:
                G8.f fVar = (G8.f) obj;
                z zVarK = iVar.k();
                G8.c cVar = o.l;
                Q8.k kVar = ((w) zVarK.V(cVar)).g;
                if (kVar == null) {
                    i.a(11);
                    throw null;
                }
                InterfaceC1524g interfaceC1524gB = kVar.b(fVar, NoLookupLocation.f4986a);
                if (interfaceC1524gB == null) {
                    throw new AssertionError("Built-in class " + cVar.c(fVar) + " is not found");
                }
                if (interfaceC1524gB instanceof InterfaceC1522e) {
                    return (InterfaceC1522e) interfaceC1524gB;
                }
                throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + interfaceC1524gB);
            default:
                InterfaceC1540w module = (InterfaceC1540w) obj;
                kotlin.jvm.internal.k.f(module, "module");
                i iVarC = module.c();
                Variance variance = Variance.c;
                return iVarC.g(iVar.u());
        }
    }
}
