package rc;

import kc.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends p {

    /* renamed from: f, reason: collision with root package name */
    public static final k f10566f = new k();

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        e.f10554g.f10555f.e(runnable, true, false);
    }

    @Override // kc.p
    public final void N(nb.g gVar, Runnable runnable) {
        e.f10554g.f10555f.e(runnable, true, true);
    }

    @Override // kc.p
    public final p P(int i) {
        pc.a.a(i);
        return i >= j.f10563d ? this : super.P(i);
    }

    @Override // kc.p
    public final String toString() {
        return "Dispatchers.IO";
    }
}
