package Z4;

import android.animation.ValueAnimator;
import android.view.animation.AnimationUtils;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes3.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f1590a = 0;
    public long b;
    public ValueAnimator c;
    public final StepOSScrollBarView d;
    public final int e;
    public final int f;
    public boolean g;
    public final b h;

    public d(StepOSScrollBarView stepOSScrollBarView, int i, int i6, b bVar) {
        this.d = stepOSScrollBarView;
        this.e = i;
        this.f = i6;
        this.h = bVar;
    }

    public final void a(int i, int i6) {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c.cancel();
        }
        if (this.c == null) {
            this.c = new ValueAnimator();
        }
        this.c.setIntValues(i, i6);
        this.c.setDuration(250L);
        this.c.setInterpolator(StepOSScrollBarView.f3601C);
        this.c.start();
        this.f1590a = 1;
        this.g = true;
        this.d.postInvalidate();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        if (AnimationUtils.currentAnimationTimeMillis() < this.b || this.f1590a != 0) {
            return;
        }
        if (this.c == null) {
            this.c = new ValueAnimator();
        }
        this.f1590a = 1;
        this.g = false;
        this.c.setDuration(250L);
        this.c.setInterpolator(StepOSScrollBarView.f3601C);
        this.c.setIntValues(this.e, this.f);
        if (StepOSScrollBarView.f3607N && (bVar = this.h) != null) {
            final int i = bVar.getBounds().left;
            this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: Z4.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    d dVar = this.f1589a;
                    dVar.getClass();
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i6 = i;
                    b bVar2 = dVar.h;
                    bVar2.setBounds(i6, bVar2.getBounds().top, iIntValue + i6, bVar2.getBounds().bottom);
                }
            });
        }
        this.c.start();
        this.d.postInvalidate();
    }
}
