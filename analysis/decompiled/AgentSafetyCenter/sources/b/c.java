package b;

import java.util.Iterator;
import jb.v;
import k0.k0;
import s.e1;
import v1.c1;
import v1.g2;
import y.e0;
import y.t;
import y.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1686a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1687b;

    public /* synthetic */ c(int i) {
        this.f1686a = i;
    }

    @Override // k0.k0
    public final void dispose() {
        v vVar;
        switch (this.f1686a) {
            case 0:
                d.e eVar = ((a) this.f1687b).f1683a;
                if (eVar != null) {
                    eVar.b();
                    vVar = v.f6774a;
                } else {
                    vVar = null;
                }
                if (vVar == null) {
                    od.f.e("Launcher has not been initialized");
                    break;
                }
                break;
            case 1:
                Iterator it = ((i) this.f1687b).f700b.iterator();
                while (it.hasNext()) {
                    ((androidx.activity.d) it.next()).cancel();
                }
                break;
            case 2:
                ((e1) this.f1687b).i();
                break;
            case 3:
                s2.m mVar = (s2.m) this.f1687b;
                mVar.dismiss();
                s2.j jVar = mVar.f11363k;
                g2 g2Var = jVar.f14326g;
                if (g2Var != null) {
                    g2Var.a();
                }
                jVar.f14326g = null;
                jVar.requestLayout();
                break;
            case 4:
                ((c1) this.f1687b).f14391f.invoke();
                break;
            case 5:
                ((t) this.f1687b).f15823d = null;
                break;
            case 6:
                ((e0) this.f1687b).f15737c = null;
                break;
            default:
                z zVar = (z) this.f1687b;
                int iG = zVar.f15842d.g();
                for (int i = 0; i < iG; i++) {
                    zVar.b();
                }
                break;
        }
    }
}
