package m;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public g f7923c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k f7924f;

    @Override // java.lang.Runnable
    public final void run() {
        l.j jVar;
        g gVar = this.f7923c;
        k kVar = this.f7924f;
        l.l lVar = kVar.f7946g;
        if (lVar != null && (jVar = lVar.f7587e) != null) {
            jVar.f(lVar);
        }
        View view = (View) kVar.f7950l;
        if (view != null && view.getWindowToken() != null) {
            if (gVar.b()) {
                kVar.f7961w = gVar;
            } else if (gVar.f7650e != null) {
                gVar.d(0, 0, false, false);
                kVar.f7961w = gVar;
            }
        }
        kVar.f7963y = null;
    }
}
