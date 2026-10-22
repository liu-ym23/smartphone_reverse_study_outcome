package N3;

import android.view.View;
import android.widget.OverScroller;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f1491a;

    /* renamed from: b, reason: collision with root package name */
    public int f1492b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f1493c;

    public c(d dVar) {
        this.f1493c = dVar;
        dVar.f1501e = new OverScroller(dVar.f1497a);
    }

    public final void a() {
        d dVar = this.f1493c;
        if (dVar.f1501e.isFinished()) {
            return;
        }
        dVar.f1501e.abortAnimation();
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.f1493c;
        if (!dVar.f1501e.computeScrollOffset() || dVar.f1501e.isFinished()) {
            return;
        }
        boolean zB = dVar.b();
        boolean zC = dVar.c();
        dVar.f1501e.getCurrVelocity();
        int i4 = this.f1492b;
        if ((i4 < 0 && !zB) || (i4 > 0 && !zC)) {
            boolean z4 = dVar.f1501e.getStartY() > dVar.f1501e.getCurrY();
            float currVelocity = dVar.f1501e.getCurrVelocity();
            if (!z4) {
                currVelocity = -currVelocity;
            }
            d.a(dVar, currVelocity, true);
            a();
            return;
        }
        int i5 = this.f1491a;
        View view = dVar.f1498b;
        if ((i5 >= 0 || view.canScrollHorizontally(-1)) && (this.f1491a <= 0 || view.canScrollHorizontally(1))) {
            dVar.f1498b.removeCallbacks(this);
            dVar.f1498b.postOnAnimation(this);
            return;
        }
        boolean z5 = dVar.f1501e.getStartX() > dVar.f1501e.getCurrX();
        float currVelocity2 = dVar.f1501e.getCurrVelocity();
        if (!z5) {
            currVelocity2 = -currVelocity2;
        }
        d.a(dVar, currVelocity2, false);
        a();
    }
}
