package w;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements s1.f0 {

    /* renamed from: b, reason: collision with root package name */
    public static final o f15014b = new o(0);

    /* renamed from: c, reason: collision with root package name */
    public static final o f15015c = new o(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15016a;

    public /* synthetic */ o(int i) {
        this.f15016a = i;
    }

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        switch (this.f15016a) {
            case 0:
                return h0Var.Y(o2.a.k(j10), o2.a.j(j10), kb.t.f7405c, n.f15010f);
            default:
                return h0Var.Y(o2.a.g(j10) ? o2.a.i(j10) : 0, o2.a.f(j10) ? o2.a.h(j10) : 0, kb.t.f7405c, n.f15012h);
        }
    }
}
