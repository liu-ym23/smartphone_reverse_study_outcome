package T8;

import h8.InterfaceC1527j;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* loaded from: classes4.dex */
public final class t implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final v f1233a;
    public final boolean b;
    public final ProtoBuf$Property c;

    public t(v vVar, boolean z10, ProtoBuf$Property protoBuf$Property) {
        this.f1233a = vVar;
        this.b = z10;
        this.c = protoBuf$Property;
    }

    @Override // S7.a
    public final Object invoke() {
        List listF1;
        v vVar = this.f1233a;
        m mVar = vVar.f1235a;
        InterfaceC1527j interfaceC1527j = mVar.c;
        InterfaceC0249a interfaceC0249a = mVar.f1228a.e;
        J5.b bVarA = vVar.a(interfaceC1527j);
        if (bVarA != null) {
            boolean z10 = this.b;
            ProtoBuf$Property protoBuf$Property = this.c;
            listF1 = z10 ? D7.v.f1(interfaceC0249a.Q(bVarA, protoBuf$Property)) : D7.v.f1(interfaceC0249a.m0(bVarA, protoBuf$Property));
        } else {
            listF1 = null;
        }
        return listF1 == null ? EmptyList.f4893a : listF1;
    }
}
