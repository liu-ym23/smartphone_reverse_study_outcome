package androidx.fragment.app;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements m3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1293a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ v f1294b;

    public /* synthetic */ n(int i) {
        this.f1293a = i;
    }

    @Override // m3.a
    public final void accept(Object obj) {
        int i = this.f1293a;
        v vVar = this.f1294b;
        switch (i) {
            case 0:
                Iterator it = vVar.f1307c.c().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        od.f.j();
                        break;
                    }
                }
                break;
            case 1:
                if (((Integer) obj).intValue() == 80) {
                    Iterator it2 = vVar.f1307c.c().iterator();
                    while (it2.hasNext()) {
                        if (it2.next() != null) {
                            od.f.j();
                            break;
                        }
                    }
                    break;
                }
                break;
            case 2:
                boolean z10 = ((d3.d) obj).f3185a;
                Iterator it3 = vVar.f1307c.c().iterator();
                while (it3.hasNext()) {
                    if (it3.next() != null) {
                        od.f.j();
                        break;
                    }
                }
                break;
            default:
                boolean z11 = ((d3.f) obj).f3186a;
                Iterator it4 = vVar.f1307c.c().iterator();
                while (it4.hasNext()) {
                    if (it4.next() != null) {
                        od.f.j();
                        break;
                    }
                }
                break;
        }
    }
}
