package Xa;

import android.view.ViewGroup;
import android.widget.OverScroller;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f1542a;
    public int b;
    public final /* synthetic */ e c;

    public d(e eVar) {
        this.c = eVar;
        eVar.e = new OverScroller(eVar.f1546a);
    }

    public final void a() {
        e eVar = this.c;
        if (eVar.e.isFinished()) {
            return;
        }
        eVar.e.abortAnimation();
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.c;
        ViewGroup viewGroup = eVar.b;
        if (!eVar.e.computeScrollOffset() || eVar.e.isFinished()) {
            return;
        }
        boolean zB = eVar.b();
        boolean zC = eVar.c();
        eVar.e.getCurrVelocity();
        int i = this.b;
        if ((i < 0 && !zB) || (i > 0 && !zC)) {
            boolean z10 = eVar.e.getStartY() > eVar.e.getCurrY();
            float currVelocity = eVar.e.getCurrVelocity();
            if (!z10) {
                currVelocity = -currVelocity;
            }
            e.a(eVar, currVelocity, true);
            a();
            return;
        }
        if ((this.f1542a >= 0 || viewGroup.canScrollHorizontally(-1)) && (this.f1542a <= 0 || viewGroup.canScrollHorizontally(1))) {
            ViewGroup viewGroup2 = eVar.b;
            viewGroup2.removeCallbacks(this);
            viewGroup2.postOnAnimation(this);
        } else {
            boolean z11 = eVar.e.getStartX() > eVar.e.getCurrX();
            float currVelocity2 = eVar.e.getCurrVelocity();
            if (!z11) {
                currVelocity2 = -currVelocity2;
            }
            e.a(eVar, currVelocity2, false);
            a();
        }
    }
}
