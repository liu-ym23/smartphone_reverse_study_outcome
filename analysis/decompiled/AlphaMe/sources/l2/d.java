package l2;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f13489a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f13490b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f13491c;

    /* renamed from: d, reason: collision with root package name */
    public final View f13492d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13493e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13494f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13495g;

    /* renamed from: h, reason: collision with root package name */
    public final C0763b f13496h;

    public d(View view, int i4, int i5, C0763b c0763b) {
        this.f13492d = view;
        this.f13493e = i4;
        this.f13494f = i5;
        this.f13496h = c0763b;
    }

    public final void a(int i4, int i5) {
        ValueAnimator valueAnimator = this.f13491c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f13491c.cancel();
        }
        if (this.f13491c == null) {
            this.f13491c = new ValueAnimator();
        }
        this.f13491c.setIntValues(i4, i5);
        this.f13491c.setDuration(250L);
        this.f13491c.setInterpolator(StepOSScrollBarView.f11395C);
        this.f13491c.start();
        this.f13489a = 1;
        this.f13495g = true;
        this.f13492d.postInvalidate();
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0763b c0763b;
        if (AnimationUtils.currentAnimationTimeMillis() < this.f13490b || this.f13489a != 0) {
            return;
        }
        if (this.f13491c == null) {
            this.f13491c = new ValueAnimator();
        }
        this.f13489a = 1;
        this.f13495g = false;
        this.f13491c.setDuration(250L);
        this.f13491c.setInterpolator(StepOSScrollBarView.f11395C);
        this.f13491c.setIntValues(this.f13493e, this.f13494f);
        if (StepOSScrollBarView.f11402J && (c0763b = this.f13496h) != null) {
            final int i4 = c0763b.getBounds().left;
            this.f13491c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: l2.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    d dVar = this.f13487a;
                    dVar.getClass();
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i5 = i4;
                    C0763b c0763b2 = dVar.f13496h;
                    c0763b2.setBounds(i5, c0763b2.getBounds().top, iIntValue + i5, c0763b2.getBounds().bottom);
                }
            });
        }
        this.f13491c.start();
        this.f13492d.postInvalidate();
    }
}
