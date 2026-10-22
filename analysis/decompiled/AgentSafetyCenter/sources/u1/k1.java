package u1;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k1 implements Comparator {

    /* renamed from: f, reason: collision with root package name */
    public static final k1 f13859f = new k1(0);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13860c;

    public /* synthetic */ k1(int i) {
        this.f13860c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f13860c) {
            case 0:
                g0 g0Var = (g0) obj;
                g0 g0Var2 = (g0) obj2;
                int iB = yb.k.b(g0Var2.f13802s, g0Var.f13802s);
                return iB != 0 ? iB : yb.k.b(g0Var.hashCode(), g0Var2.hashCode());
            default:
                g0 g0Var3 = (g0) obj;
                g0 g0Var4 = (g0) obj2;
                int iB2 = yb.k.b(g0Var3.f13802s, g0Var4.f13802s);
                return iB2 != 0 ? iB2 : yb.k.b(g0Var3.hashCode(), g0Var4.hashCode());
        }
    }
}
