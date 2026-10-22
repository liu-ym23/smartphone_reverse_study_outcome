package androidx.fragment.app;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public i f1291a;

    public final void a() {
        v vVar = this.f1291a.f1285g;
        if (vVar.f1321r == null) {
            return;
        }
        vVar.f1328y = false;
        vVar.f1329z = false;
        vVar.E.getClass();
        Iterator it = vVar.f1307c.c().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                od.f.j();
                return;
            }
        }
    }
}
