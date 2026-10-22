package g8;

import Z7.t;
import g9.InterfaceC1474a;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;

/* renamed from: g8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1469e implements InterfaceC1474a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1469e f4492a = new C1469e();

    public static InterfaceC1522e a(InterfaceC1522e interfaceC1522e) {
        G8.e eVarG = J8.e.g(interfaceC1522e);
        String str = C1468d.f4490a;
        G8.c cVar = (G8.c) C1468d.k.get(eVarG);
        if (cVar != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1522e).i(cVar);
        }
        throw new IllegalArgumentException("Given class " + interfaceC1522e + " is not a read-only collection");
    }

    public static InterfaceC1522e b(G8.c cVar, e8.i builtIns) {
        kotlin.jvm.internal.k.f(builtIns, "builtIns");
        String str = C1468d.f4490a;
        G8.b bVar = (G8.b) C1468d.h.get(cVar.i());
        if (bVar != null) {
            return builtIns.i(bVar.a());
        }
        return null;
    }

    @Override // g9.InterfaceC1474a
    public Iterable c(Object obj) {
        t[] tVarArr = kotlin.reflect.jvm.internal.impl.builtins.jvm.b.h;
        return ((InterfaceC1520c) obj).a().e();
    }
}
