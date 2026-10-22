package b0;

import java.util.ArrayList;
import java.util.List;
import s1.e0;
import s1.f0;
import s1.g0;
import s1.h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements f0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1713b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f1714c = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1715a;

    public /* synthetic */ b(int i) {
        this.f1715a = i;
    }

    @Override // s1.f0
    public final g0 c(h0 h0Var, List list, long j10) {
        switch (this.f1715a) {
            case 0:
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((e0) list.get(i)).q(j10));
                }
                return h0Var.Y(o2.a.i(j10), o2.a.h(j10), kb.t.f7405c, new a(arrayList, 0));
            default:
                return h0Var.Y(o2.a.i(j10), o2.a.h(j10), kb.t.f7405c, l.f1761g);
        }
    }
}
