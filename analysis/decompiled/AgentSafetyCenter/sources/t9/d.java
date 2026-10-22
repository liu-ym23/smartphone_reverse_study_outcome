package t9;

import android.animation.ValueAnimator;
import android.view.animation.AnimationUtils;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public int f13277c;

    /* renamed from: f, reason: collision with root package name */
    public long f13278f;

    /* renamed from: g, reason: collision with root package name */
    public ValueAnimator f13279g;

    /* renamed from: h, reason: collision with root package name */
    public StepOSScrollBarView f13280h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f13281j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13282k;

    /* renamed from: l, reason: collision with root package name */
    public b f13283l;

    public final void a(int i, int i3) {
        ValueAnimator valueAnimator = this.f13279g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f13279g.cancel();
        }
        if (this.f13279g == null) {
            this.f13279g = new ValueAnimator();
        }
        this.f13279g.setIntValues(i, i3);
        this.f13279g.setDuration(250L);
        this.f13279g.setInterpolator(StepOSScrollBarView.G);
        this.f13279g.start();
        this.f13277c = 1;
        this.f13282k = true;
        this.f13280h.postInvalidate();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        if (AnimationUtils.currentAnimationTimeMillis() < this.f13278f || this.f13277c != 0) {
            return;
        }
        if (this.f13279g == null) {
            this.f13279g = new ValueAnimator();
        }
        this.f13277c = 1;
        this.f13282k = false;
        this.f13279g.setDuration(250L);
        this.f13279g.setInterpolator(StepOSScrollBarView.G);
        this.f13279g.setIntValues(this.i, this.f13281j);
        if (StepOSScrollBarView.N && (bVar = this.f13283l) != null) {
            int i = bVar.getBounds().left;
            ValueAnimator valueAnimator = this.f13279g;
            c cVar = new c();
            cVar.f13275a = this;
            cVar.f13276b = i;
            VarHandle.storeStoreFence();
            valueAnimator.addUpdateListener(cVar);
        }
        this.f13279g.start();
        this.f13280h.postInvalidate();
    }
}
