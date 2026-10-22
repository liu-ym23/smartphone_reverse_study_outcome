package com.bytedance.android.ec.store.view;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SortFilterExpandPanel f48962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f48963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f48964c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f48965a;

        public a(u r100) {
            this.f48965a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ViewGroup r101 = SortFilterExpandPanel.a(this.f48965a.f48962a);
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setTranslationY(((Float) r102).floatValue());
            this.f48965a.f48962a.setBackgroundColor(Color.argb((int) (r100.getAnimatedFraction() * 128), 0, 0, 0));
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public u(SortFilterExpandPanel r100, View r101, List r102) {
        this.f48962a = r100;
        this.f48963b = r101;
        this.f48964c = r102;
    }

    public final void a() {
        SortFilterExpandPanel.a(this.f48962a).setTranslationY(-SortFilterExpandPanel.a(this.f48962a).getHeight());
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{SortFilterExpandPanel.a(this.f48962a).getTranslationY(), 0.0f});
        r100.setInterpolator(new com.bytedance.android.ec.hybrid.tools.g(this.f48962a.f48911g));
        r100.addUpdateListener(new a(this));
        r100.setDuration(200);
        r100.start();
        this.f48962a.setVisibility(0);
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
