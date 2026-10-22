package com.bytedance.android.livesdk.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f161784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f161785b;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f161786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f161787b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            int r102 = this.f161786a;
            int r103 = (int) (r102 - (r102 * r101));
            l r104 = this.f161787b;
            View r105 = r104.f161784a;
            if (r104.f161785b == false) goto L5;
            float r106 = r103;
        L6:
            r105.setTranslationY(r106);
            return;
        L5:
            r106 = r101 * (-r102);
            goto L6
        }

        public a(l r100, int r101) {
            this.f161787b = r100;
            this.f161786a = r101;
        }
    }

    public final void a() {
        int r100 = (int) (this.f161784a.getHeight() * 0.075f);
        boolean r101 = this.f161785b;
        if (r101 == false) goto L5;
        long r102 = 300;
    L6:
        View r103 = this.f161784a;
        float[] r104 = new float[2];
        float r105 = 0.0f;
        if (r101 == false) goto L9;
        float r106 = 0.0f;
    L10:
        r104[0] = r106;
        if (r101 == false) goto L13;
        r105 = 1.0f;
    L13:
        r104[1] = r105;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r103, "alpha", r104);
        r107.setDuration(r102);
        r107.addUpdateListener(new a(this, r100));
        r107.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r107.start();
        return;
    L9:
        r106 = 1.0f;
        goto L10
    L5:
        r102 = 100;
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

    public l(View r100, boolean r101) {
        this.f161784a = r100;
        this.f161785b = r101;
    }
}
