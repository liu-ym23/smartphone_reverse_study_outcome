package u8;

import h8.InterfaceC1522e;
import java.util.Collection;
import java.util.Set;

/* renamed from: u8.B, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2044B extends g9.l {
    public final /* synthetic */ InterfaceC1522e b;
    public final /* synthetic */ Set c;
    public final /* synthetic */ S7.k d;

    public C2044B(InterfaceC1522e interfaceC1522e, Set set, S7.k kVar) {
        this.b = interfaceC1522e;
        this.c = set;
        this.d = kVar;
    }

    @Override // g9.l
    public final boolean d(Object obj) {
        InterfaceC1522e current = (InterfaceC1522e) obj;
        kotlin.jvm.internal.k.f(current, "current");
        if (current == this.b) {
            return true;
        }
        Q8.o oVarH0 = current.h0();
        kotlin.jvm.internal.k.e(oVarH0, "getStaticScope(...)");
        if (!(oVarH0 instanceof D)) {
            return true;
        }
        this.c.addAll((Collection) this.d.invoke(oVarH0));
        return false;
    }

    @Override // g9.l
    public final /* bridge */ /* synthetic */ Object k() {
        return C7.r.f317a;
    }
}
