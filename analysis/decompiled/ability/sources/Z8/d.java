package Z8;

import h8.InterfaceC1498F;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1540w;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;

/* loaded from: classes4.dex */
public final class d implements InterfaceC1540w {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1616a = new d();
    public static final G8.f b;
    public static final EmptyList c;
    public static final C7.f d;

    static {
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        b = G8.f.g("<Error module>");
        c = EmptyList.f4893a;
        EmptySet emptySet = EmptySet.f4895a;
        d = kotlin.a.a(c.f1615a);
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return null;
    }

    @Override // h8.InterfaceC1540w
    public final InterfaceC1498F V(G8.c fqName) {
        k.f(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this;
    }

    @Override // h8.InterfaceC1540w
    public final e8.i c() {
        return (e8.i) d.getF4884a();
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return null;
    }

    @Override // h8.InterfaceC1540w
    public final Collection f(G8.c fqName, S7.k kVar) {
        k.f(fqName, "fqName");
        return EmptyList.f4893a;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return C1560f.f4611a;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        return b;
    }

    @Override // h8.InterfaceC1540w
    public final List r0() {
        return c;
    }

    @Override // h8.InterfaceC1540w
    public final Object z(A0.b capability) {
        k.f(capability, "capability");
        return null;
    }

    @Override // h8.InterfaceC1540w
    public final boolean z0(InterfaceC1540w targetModule) {
        k.f(targetModule, "targetModule");
        return false;
    }
}
