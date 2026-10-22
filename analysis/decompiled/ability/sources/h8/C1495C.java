package h8;

import i8.InterfaceC1561g;

/* renamed from: h8.C, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1495C implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4574a;
    public final G8.c b;

    public /* synthetic */ C1495C(G8.c cVar, int i) {
        this.f4574a = i;
        this.b = cVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4574a) {
            case 0:
                G8.c it = (G8.c) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.valueOf(!it.d() && it.e().equals(this.b));
            default:
                InterfaceC1561g it2 = (InterfaceC1561g) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                return it2.m(this.b);
        }
    }
}
