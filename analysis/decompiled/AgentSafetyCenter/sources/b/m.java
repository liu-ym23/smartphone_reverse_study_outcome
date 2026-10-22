package b;

import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends d.c {

    /* renamed from: a, reason: collision with root package name */
    public a f1709a;

    @Override // d.c
    public final void a(Cloneable cloneable) throws Exception {
        v vVar;
        d.e eVar = this.f1709a.f1683a;
        if (eVar != null) {
            eVar.a(cloneable);
            vVar = v.f6774a;
        } else {
            vVar = null;
        }
        if (vVar != null) {
            return;
        }
        od.f.e("Launcher has not been initialized");
    }
}
