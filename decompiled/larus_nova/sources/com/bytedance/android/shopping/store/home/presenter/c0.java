package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f184125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CartCtrlInfo f184126b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f184127a;

        public a(c0 r100) {
            this.f184127a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            ViewGroup.LayoutParams r103 = ECShopFloatCartEntryPresenterV2.T(this.f184127a.f184125a).getLayoutParams();
            ECShopFloatCartEntryPresenterV2 r104 = this.f184127a.f184125a;
            r103.width = (int) (r104.f183931v * r102);
            ECShopFloatCartEntryPresenterV2.T(r104).setLayoutParams(r103);
            ECShopFloatCartEntryPresenterV2.T(this.f184127a.f184125a).setAlpha(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f184128a;

        public b(c0 r100) {
            this.f184128a = r100;
        }

        public final void a() {
            ECShopFloatCartEntryPresenterV2 r100 = this.f184128a.f184125a;
            r100.getClass();
            ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r101.setDuration(r100.f183921l);
            r101.addUpdateListener(new x(r100));
            r101.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.83f, 0.83f));
            r101.start();
            r101.addListener(new y(r100));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c0(ECShopFloatCartEntryPresenterV2 r100, CartCtrlInfo r101) {
        this.f184125a = r100;
        this.f184126b = r101;
    }

    public final void a() {
        ECShopFloatCartEntryPresenterV2.T(this.f184125a).setVisibility(0);
        ECShopFloatCartEntryPresenterV2.T(this.f184125a).setPivotX(ECShopFloatCartEntryPresenterV2.T(this.f184125a).getWidth());
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r100.setDuration(this.f184125a.f183921l);
        r100.addUpdateListener(new a(this));
        r100.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.83f, 0.83f));
        r100.start();
        View r101 = this.f184125a.y();
        b r102 = new b(this);
        CartCtrlInfo r103 = this.f184126b;
        if (r103 == null) goto L5;
        Integer r104 = r103.getRemainMilliseconds();
    L6:
        r101.postDelayed(r102, com.bytedance.android.shopping.extensions.c.a(r104, 1000));
        this.f184125a.f183930u = AnimationStatus.FINISHED;
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
