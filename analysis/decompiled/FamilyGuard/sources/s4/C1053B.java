package s4;

import V3.n;
import i4.InterfaceC0772l;

/* renamed from: s4.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1053B {
    public static final <T> Object a(Object obj, Z3.e<? super T> eVar) {
        if (!(obj instanceof C1096y)) {
            return V3.n.a(obj);
        }
        n.a aVar = V3.n.f5531a;
        return V3.n.a(V3.o.a(((C1096y) obj).f20398a));
    }

    public static final <T> Object b(Object obj, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        Throwable thB = V3.n.b(obj);
        return thB == null ? interfaceC0772l != null ? new C1097z(obj, interfaceC0772l) : obj : new C1096y(thB, false, 2, null);
    }

    public static final <T> Object c(Object obj, InterfaceC1080k<?> interfaceC1080k) {
        Throwable thB = V3.n.b(obj);
        return thB == null ? obj : new C1096y(thB, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, InterfaceC0772l interfaceC0772l, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            interfaceC0772l = null;
        }
        return b(obj, interfaceC0772l);
    }
}
