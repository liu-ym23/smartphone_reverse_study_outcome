package v5;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements h {
    @Override // v5.h
    public final i a(y5.m mVar, e6.m mVar2) {
        String str = mVar.f15926b;
        if (str == null || !hc.o.U(str, "video/", false)) {
            return null;
        }
        p pVar = mVar.f15925a;
        t tVar = new t();
        tVar.f14811a = pVar;
        tVar.f14812b = mVar2;
        VarHandle.storeStoreFence();
        return tVar;
    }

    public final boolean equals(Object obj) {
        return obj instanceof s;
    }

    public final int hashCode() {
        return s.class.hashCode();
    }
}
