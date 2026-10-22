package Q8;

import D7.v;
import h8.InterfaceC1501I;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;
import k8.K;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class s extends p {
    public static final /* synthetic */ Z7.t[] f;
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b b;
    public final boolean c;
    public final W8.h d;
    public final W8.h e;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        f = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(s.class), "functions", "getFunctions()Ljava/util/List;")), nVar.g(new PropertyReference1Impl(nVar.b(s.class), "properties", "getProperties()Ljava/util/List;"))};
    }

    public s(W8.i storageManager, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar, boolean z10) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.b = bVar;
        this.c = z10;
        ClassKind classKind = ClassKind.f4951a;
        this.d = new W8.h(storageManager, new r(this, 0));
        this.e = new W8.h(storageManager, new r(this, 1));
    }

    @Override // Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return null;
    }

    @Override // Q8.p, Q8.q
    public final Collection c(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        Z7.t[] tVarArr = f;
        return v.Q0((List) S0.b.g1(this.e, tVarArr[1]), (List) S0.b.g1(this.d, tVarArr[0]));
    }

    @Override // Q8.p, Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        List list = (List) S0.b.g1(this.e, f[1]);
        g9.f fVar = new g9.f();
        for (Object obj : list) {
            if (kotlin.jvm.internal.k.b(((InterfaceC1501I) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }

    @Override // Q8.p, Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        List list = (List) S0.b.g1(this.d, f[0]);
        g9.f fVar = new g9.f();
        for (Object obj : list) {
            if (kotlin.jvm.internal.k.b(((K) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }
}
