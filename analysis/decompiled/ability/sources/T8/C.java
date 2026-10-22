package T8;

import h8.InterfaceC1506N;
import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: classes4.dex */
public final class C implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1213a;
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.a b;

    public /* synthetic */ C(kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar, int i) {
        this.f1213a = i;
        this.b = aVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1213a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                m mVar = this.b.f5127a;
                D8.f fVar = mVar.b;
                k kVar = mVar.f1228a;
                G8.b bVarS = N9.j.s(fVar, iIntValue);
                return bVarS.c ? kVar.b(bVarS) : kotlin.reflect.jvm.internal.impl.descriptors.a.b(kVar.b, bVarS);
            case 1:
                int iIntValue2 = ((Number) obj).intValue();
                m mVar2 = this.b.f5127a;
                G8.b bVarS2 = N9.j.s(mVar2.b, iIntValue2);
                if (!bVarS2.c) {
                    InterfaceC1540w interfaceC1540w = mVar2.f1228a.b;
                    kotlin.jvm.internal.k.f(interfaceC1540w, "<this>");
                    InterfaceC1524g interfaceC1524gB = kotlin.reflect.jvm.internal.impl.descriptors.a.b(interfaceC1540w, bVarS2);
                    if (interfaceC1524gB instanceof InterfaceC1506N) {
                        return (InterfaceC1506N) interfaceC1524gB;
                    }
                }
                return null;
            default:
                ProtoBuf$Type it = (ProtoBuf$Type) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return D8.i.a(it, this.b.f5127a.d);
        }
    }
}
