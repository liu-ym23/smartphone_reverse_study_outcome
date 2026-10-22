package ve;

import android.view.ViewGroup;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public int f14920c;

    /* renamed from: f, reason: collision with root package name */
    public int f14921f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ d f14922g;

    public final void a() {
        d dVar = this.f14922g;
        if (dVar.f14927e.isFinished()) {
            return;
        }
        dVar.f14927e.abortAnimation();
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.f14922g;
        ViewGroup viewGroup = dVar.f14924b;
        if (!dVar.f14927e.computeScrollOffset() || dVar.f14927e.isFinished()) {
            return;
        }
        boolean zB = dVar.b();
        boolean zC = dVar.c();
        dVar.f14927e.getCurrVelocity();
        int i = this.f14921f;
        if ((i < 0 && !zB) || (i > 0 && !zC)) {
            boolean z10 = dVar.f14927e.getStartY() > dVar.f14927e.getCurrY();
            float currVelocity = dVar.f14927e.getCurrVelocity();
            if (!z10) {
                currVelocity = -currVelocity;
            }
            d.a(dVar, currVelocity, true);
            a();
            return;
        }
        if ((this.f14920c >= 0 || viewGroup.canScrollHorizontally(-1)) && (this.f14920c <= 0 || viewGroup.canScrollHorizontally(1))) {
            ViewGroup viewGroup2 = dVar.f14924b;
            viewGroup2.removeCallbacks(this);
            viewGroup2.postOnAnimation(this);
        } else {
            boolean z11 = dVar.f14927e.getStartX() > dVar.f14927e.getCurrX();
            float currVelocity2 = dVar.f14927e.getCurrVelocity();
            if (!z11) {
                currVelocity2 = -currVelocity2;
            }
            d.a(dVar, currVelocity2, false);
            a();
        }
    }
}
