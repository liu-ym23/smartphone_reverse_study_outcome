package com.stepos.textinputlayout;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.stepos.textinputlayout.a;

/* loaded from: classes2.dex */
public class b extends a.d {

    /* renamed from: a, reason: collision with root package name */
    public final ValueAnimator f31113a = new ValueAnimator();

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.d.InterfaceC0377a f31114a;

        public a(a.d.InterfaceC0377a interfaceC0377a) {
            this.f31114a = interfaceC0377a;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f31114a.a();
        }
    }

    @Override // com.stepos.textinputlayout.a.d
    public void a() {
        this.f31113a.cancel();
    }

    @Override // com.stepos.textinputlayout.a.d
    public float b() {
        return ((Float) this.f31113a.getAnimatedValue()).floatValue();
    }

    @Override // com.stepos.textinputlayout.a.d
    public boolean c() {
        return this.f31113a.isRunning();
    }

    @Override // com.stepos.textinputlayout.a.d
    public void d(int i10) {
        this.f31113a.setDuration(i10);
    }

    @Override // com.stepos.textinputlayout.a.d
    public void e(float f10, float f11) {
        this.f31113a.setFloatValues(f10, f11);
    }

    @Override // com.stepos.textinputlayout.a.d
    public void f(Interpolator interpolator) {
        this.f31113a.setInterpolator(interpolator);
    }

    @Override // com.stepos.textinputlayout.a.d
    public void g(a.d.InterfaceC0377a interfaceC0377a) {
        this.f31113a.addUpdateListener(new a(interfaceC0377a));
    }

    @Override // com.stepos.textinputlayout.a.d
    public void h() {
        this.f31113a.start();
    }
}
