package s1;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 extends u1.d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final r0 f11292a = new r0();

    @Override // s1.f0
    public final g0 c(h0 h0Var, List list, long j10) {
        int size = list.size();
        kb.t tVar = kb.t.f7405c;
        if (size == 0) {
            return h0Var.Y(o2.a.k(j10), o2.a.j(j10), tVar, p0.f11288g);
        }
        if (size == 1) {
            o0 o0VarQ = ((e0) list.get(0)).q(j10);
            return h0Var.Y(o2.b.f(o0VarQ.f11277c, j10), o2.b.e(o0VarQ.f11278f, j10), tVar, new a1.i(o0VarQ, 6));
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            o0 o0VarQ2 = ((e0) list.get(i)).q(j10);
            iMax = Math.max(o0VarQ2.f11277c, iMax);
            iMax2 = Math.max(o0VarQ2.f11278f, iMax2);
            arrayList.add(o0VarQ2);
        }
        return h0Var.Y(o2.b.f(iMax, j10), o2.b.e(iMax2, j10), tVar, new b0.a(arrayList, 2));
    }
}
