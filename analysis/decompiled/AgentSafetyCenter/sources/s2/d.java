package s2;

import java.util.ArrayList;
import java.util.List;
import kb.t;
import s1.e0;
import s1.f0;
import s1.g0;
import s1.h0;
import s1.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11342a = new d();

    @Override // s1.f0
    public final g0 c(h0 h0Var, List list, long j10) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iK = 0;
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            o0 o0VarQ = ((e0) list.get(i)).q(j10);
            iK = Math.max(iK, o0VarQ.f11277c);
            iJ = Math.max(iJ, o0VarQ.f11278f);
            arrayList.add(o0VarQ);
        }
        if (list.isEmpty()) {
            iK = o2.a.k(j10);
            iJ = o2.a.j(j10);
        }
        return h0Var.Y(iK, iJ, t.f7405c, new b0.a(arrayList, 3));
    }
}
