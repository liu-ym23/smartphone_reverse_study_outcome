package com.stepos.textinputlayout;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.stepos.textinputlayout.d;

/* loaded from: classes.dex */
class e extends d.AbstractC0199d {

    /* renamed from: a, reason: collision with root package name */
    final ValueAnimator f16067a = new ValueAnimator();

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.AbstractC0199d.a f16068a;

        a(d.AbstractC0199d.a aVar) {
            this.f16068a = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f16068a.a();
        }
    }

    e() {
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void a() {
        this.f16067a.cancel();
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public float b() {
        return ((Float) this.f16067a.getAnimatedValue()).floatValue();
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public boolean c() {
        return this.f16067a.isRunning();
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void d(int i5) {
        this.f16067a.setDuration(i5);
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void e(float f5, float f6) {
        this.f16067a.setFloatValues(f5, f6);
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void f(Interpolator interpolator) {
        this.f16067a.setInterpolator(interpolator);
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void g(d.AbstractC0199d.a aVar) {
        this.f16067a.addUpdateListener(new a(aVar));
    }

    @Override // com.stepos.textinputlayout.d.AbstractC0199d
    public void h() {
        this.f16067a.start();
    }
}
