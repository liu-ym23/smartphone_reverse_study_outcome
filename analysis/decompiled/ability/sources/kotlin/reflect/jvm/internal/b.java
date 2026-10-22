package kotlin.reflect.jvm.internal;

import D8.h;
import D8.j;
import E8.c;
import F8.g;
import G8.f;
import H8.l;
import Q8.o;
import Z7.t;
import b8.AbstractC0830C;
import b8.C0839L;
import b8.O;
import b8.p0;
import b8.v0;
import h8.InterfaceC1501I;
import java.util.Collection;
import kotlin.LazyThreadSafetyMode;
import kotlin.Triple;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public final class b extends AbstractC0830C {
    public final Class b;
    public final Object c;

    public b(Class jClass) {
        k.f(jClass, "jClass");
        this.b = jClass;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new C0839L(this, 0));
    }

    @Override // kotlin.jvm.internal.c
    public final Class b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return k.b(this.b, ((b) obj).b);
        }
        return false;
    }

    @Override // b8.AbstractC0830C
    public final Collection g() {
        return EmptyList.f4893a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0830C
    public final Collection h(f fVar) {
        p0 p0Var = ((O) this.c.getF4884a()).d;
        t tVar = O.g[1];
        Object objInvoke = p0Var.invoke();
        k.e(objInvoke, "getValue(...)");
        return ((o) objInvoke).f(fVar, NoLookupLocation.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0830C
    public final InterfaceC1501I i(int i) {
        Triple triple = (Triple) ((O) this.c.getF4884a()).f.getF4884a();
        if (triple == null) {
            return null;
        }
        g gVar = (g) triple.f4891a;
        ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) triple.b;
        F8.f fVar = (F8.f) triple.c;
        l packageLocalVariable = c.n;
        k.e(packageLocalVariable, "packageLocalVariable");
        ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) h.b(protoBuf$Package, packageLocalVariable, i);
        if (protoBuf$Property == null) {
            return null;
        }
        ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Package.g;
        k.e(protoBuf$TypeTable, "getTypeTable(...)");
        return (InterfaceC1501I) v0.f(this.b, protoBuf$Property, gVar, new j(protoBuf$TypeTable), fVar, KPackageImpl$getLocalProperty$1$1$1.f4939a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0830C
    public final Class o() {
        Class cls = (Class) ((O) this.c.getF4884a()).e.getF4884a();
        return cls == null ? this.b : cls;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0830C
    public final Collection p(f fVar) {
        p0 p0Var = ((O) this.c.getF4884a()).d;
        t tVar = O.g[1];
        Object objInvoke = p0Var.invoke();
        k.e(objInvoke, "getValue(...)");
        return ((o) objInvoke).d(fVar, NoLookupLocation.b);
    }

    public final String toString() {
        return "file class " + AbstractC1744c.a(this.b).a();
    }
}
