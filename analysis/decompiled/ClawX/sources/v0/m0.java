package v0;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f5879a;

    /* renamed from: b, reason: collision with root package name */
    public int f5880b;

    /* renamed from: c, reason: collision with root package name */
    public OverScroller f5881c;
    public Interpolator d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5882e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5883f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5884g;

    public m0(RecyclerView recyclerView) {
        this.f5884g = recyclerView;
        i0.d dVar = RecyclerView.f757n0;
        this.d = dVar;
        this.f5882e = false;
        this.f5883f = false;
        this.f5881c = new OverScroller(recyclerView.getContext(), dVar);
    }

    public final void a() {
        if (this.f5882e) {
            this.f5883f = true;
            return;
        }
        RecyclerView recyclerView = this.f5884g;
        recyclerView.removeCallbacks(this);
        int[] iArr = e0.a0.f2285a;
        recyclerView.postOnAnimation(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8;
        RecyclerView recyclerView = this.f5884g;
        int[] iArr = recyclerView.f773i0;
        if (recyclerView.f776k == null) {
            recyclerView.removeCallbacks(this);
            this.f5881c.abortAnimation();
            return;
        }
        this.f5883f = false;
        this.f5882e = true;
        recyclerView.g();
        OverScroller overScroller = this.f5881c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i9 = currX - this.f5879a;
            int i10 = currY - this.f5880b;
            this.f5879a = currX;
            this.f5880b = currY;
            int[] iArr2 = recyclerView.f773i0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int i11 = i9;
            if (recyclerView.j(i11, iArr2, i10, null, 1)) {
                i11 -= iArr[0];
                i8 = i10 - iArr[1];
            } else {
                i8 = i10;
            }
            int i12 = i11;
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.f(i12, i8);
            }
            if (!recyclerView.f778m.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f773i0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.k(0, 0, i12, i8, null, 1, iArr3);
            int i13 = i12 - iArr[0];
            int i14 = i8 - iArr[1];
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i13 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i14 != 0));
            recyclerView.f776k.getClass();
            if (z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i15 = i13 < 0 ? -currVelocity : i13 > 0 ? currVelocity : 0;
                    if (i14 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i14 <= 0) {
                        currVelocity = 0;
                    }
                    if (i15 < 0) {
                        recyclerView.m();
                        if (recyclerView.C.isFinished()) {
                            recyclerView.C.onAbsorb(-i15);
                        }
                    } else if (i15 > 0) {
                        recyclerView.n();
                        if (recyclerView.E.isFinished()) {
                            recyclerView.E.onAbsorb(i15);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.o();
                        if (recyclerView.D.isFinished()) {
                            recyclerView.D.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.l();
                        if (recyclerView.F.isFinished()) {
                            recyclerView.F.onAbsorb(currVelocity);
                        }
                    }
                    if (i15 != 0 || currVelocity != 0) {
                        int[] iArr4 = e0.a0.f2285a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                p1.m mVar = recyclerView.W;
                mVar.getClass();
                mVar.f4726c = 0;
            } else {
                a();
                l lVar = recyclerView.V;
                if (lVar != null) {
                    lVar.a(recyclerView, 0, 0);
                }
            }
        }
        recyclerView.f776k.getClass();
        this.f5882e = false;
        if (!this.f5883f) {
            recyclerView.setScrollState(0);
            recyclerView.H(1);
        } else {
            recyclerView.removeCallbacks(this);
            int[] iArr5 = e0.a0.f2285a;
            recyclerView.postOnAnimation(this);
        }
    }
}
