package Q8;

import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class r implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1130a;
    public final s b;

    public /* synthetic */ r(s sVar, int i) {
        this.f1130a = i;
        this.b = sVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1130a) {
            case 0:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = this.b.b;
                return H4.o.N(J8.m.i(bVar), J8.m.j(bVar));
            default:
                s sVar = this.b;
                return sVar.c ? H4.o.O(J8.m.h(sVar.b)) : EmptyList.f4893a;
        }
    }
}
