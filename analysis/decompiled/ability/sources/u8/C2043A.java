package u8;

import g9.InterfaceC1474a;
import h8.InterfaceC1522e;
import java.util.Collection;

/* renamed from: u8.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2043A implements InterfaceC1474a {

    /* renamed from: a, reason: collision with root package name */
    public static final C2043A f6713a = new C2043A();

    @Override // g9.InterfaceC1474a
    public final Iterable c(Object obj) {
        int i = C2045C.p;
        Collection collectionE = ((InterfaceC1522e) obj).m().e();
        kotlin.jvm.internal.k.e(collectionE, "getSupertypes(...)");
        return new D7.s(kotlin.sequences.a.n0(D7.v.s0(collectionE), m.f), 6);
    }
}
