package k8;

import h8.AbstractC1538u;
import h8.InterfaceC1497E;
import h8.InterfaceC1498F;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1540w;
import i8.C1560f;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* loaded from: classes4.dex */
public final class z extends AbstractC1644m implements InterfaceC1540w {
    public final W8.i c;
    public final e8.i d;
    public final Map e;
    public final E f;
    public u1.d g;
    public InterfaceC1497E h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final W8.e f4875j;
    public final C7.f k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(G8.f moduleName, W8.i iVar, e8.i iVar2, int i) {
        super(C1560f.f4611a, moduleName);
        Map mapM = kotlin.collections.a.M();
        kotlin.jvm.internal.k.f(moduleName, "moduleName");
        this.c = iVar;
        this.d = iVar2;
        if (!moduleName.b) {
            throw new IllegalArgumentException("Module name must be special: " + moduleName);
        }
        this.e = mapM;
        E.f4826a.getClass();
        E e = (E) z(C1630C.b);
        this.f = e == null ? C1631D.b : e;
        this.i = true;
        this.f4875j = iVar.c(new J4.b(this, 14));
        this.k = kotlin.a.a(new e8.k(this, 2));
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.v(obj, this);
    }

    public final void Q0() {
        if (this.i) {
            return;
        }
        if (z(AbstractC1538u.f4589a) != null) {
            throw new ClassCastException();
        }
        String message = "Accessing invalid module descriptor " + this;
        kotlin.jvm.internal.k.f(message, "message");
        throw new InvalidModuleException(message);
    }

    @Override // h8.InterfaceC1540w
    public final InterfaceC1498F V(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Q0();
        return (InterfaceC1498F) this.f4875j.invoke(fqName);
    }

    @Override // h8.InterfaceC1540w
    public final e8.i c() {
        return this.d;
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return null;
    }

    @Override // h8.InterfaceC1540w
    public final Collection f(G8.c fqName, S7.k kVar) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Q0();
        Q0();
        return ((C1643l) this.k.getF4884a()).f(fqName, kVar);
    }

    @Override // h8.InterfaceC1540w
    public final List r0() {
        u1.d dVar = this.g;
        if (dVar != null) {
            return (List) dVar.d;
        }
        StringBuilder sb = new StringBuilder("Dependencies of module ");
        String str = getName().f690a;
        kotlin.jvm.internal.k.e(str, "toString(...)");
        sb.append(str);
        sb.append(" were not set");
        throw new AssertionError(sb.toString());
    }

    @Override // k8.AbstractC1644m
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC1644m.P0(this));
        if (!this.i) {
            sb.append(" !isValid");
        }
        sb.append(" packageFragmentProvider: ");
        InterfaceC1497E interfaceC1497E = this.h;
        sb.append(interfaceC1497E != null ? interfaceC1497E.getClass().getSimpleName() : null);
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    @Override // h8.InterfaceC1540w
    public final Object z(A0.b capability) {
        kotlin.jvm.internal.k.f(capability, "capability");
        Object obj = this.e.get(capability);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override // h8.InterfaceC1540w
    public final boolean z0(InterfaceC1540w targetModule) {
        kotlin.jvm.internal.k.f(targetModule, "targetModule");
        if (equals(targetModule)) {
            return true;
        }
        u1.d dVar = this.g;
        kotlin.jvm.internal.k.c(dVar);
        return D7.v.u0((Set) dVar.c, targetModule) || r0().contains(targetModule) || targetModule.r0().contains(this);
    }
}
