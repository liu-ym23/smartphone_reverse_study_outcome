package w;

import java.lang.invoke.VarHandle;
import u1.q1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends w0.l implements q1 {

    /* renamed from: s, reason: collision with root package name */
    public s1.l f15048s;

    @Override // u1.q1
    public final Object b0(o2.c cVar, Object obj) {
        o0 o0Var = obj instanceof o0 ? (o0) obj : null;
        if (o0Var == null) {
            o0Var = new o0();
        }
        s1.l lVar = this.f15048s;
        a aVar = new a();
        aVar.f14948a = lVar;
        VarHandle.storeStoreFence();
        y yVar = new y();
        yVar.f15066a = aVar;
        VarHandle.storeStoreFence();
        o0Var.f15019c = yVar;
        return o0Var;
    }
}
