package com.prolificinteractive.materialcalendarview;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TitleFormatter f17811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f17815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f17817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f17818i;

    public class a extends com.prolificinteractive.materialcalendarview.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f17819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f17821c;

        public a(l r10, CharSequence r11, int r12) {
            this.f17821c = r10;
            this.f17819a = r11;
            this.f17820b = r12;
        }

        @Override // com.prolificinteractive.materialcalendarview.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            l r11 = this.f17821c;
            l.b(r11, l.a(r11), 0);
            l.a(this.f17821c).setAlpha(1.0f);
        }

        @Override // com.prolificinteractive.materialcalendarview.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            l.a(this.f17821c).setText(this.f17819a);
            l r11 = this.f17821c;
            l.b(r11, l.a(r11), this.f17820b);
            ViewPropertyAnimator r12 = l.a(this.f17821c).animate();
            if (l.c(this.f17821c) != 1) goto L5;
            r12.translationX(0.0f);
        L6:
            r12.alpha(1.0f).setDuration(l.e(this.f17821c)).setInterpolator(l.d(this.f17821c)).setListener(new com.prolificinteractive.materialcalendarview.a()).start();
            return;
        L5:
            r12.translationY(0.0f);
            goto L6
        }
    }

    public l(TextView r10) {
        this.f17811b = TitleFormatter.DEFAULT;
        this.f17815f = new DecelerateInterpolator(2.0f);
        this.f17816g = 0;
        this.f17817h = 0;
        this.f17818i = null;
        this.f17810a = r10;
        Resources r11 = r10.getResources();
        this.f17812c = 400;
        this.f17813d = r11.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f17814e = (int) TypedValue.applyDimension(1, 20.0f, r11.getDisplayMetrics());
    }

    public static /* synthetic */ TextView a(l r10) {
        return r10.f17810a;
    }

    public static /* synthetic */ void b(l r10, TextView r11, int r12) {
        r10.h(r11, r12);
    }

    public static /* synthetic */ int c(l r10) {
        return r10.f17816g;
    }

    public static /* synthetic */ Interpolator d(l r10) {
        return r10.f17815f;
    }

    public static /* synthetic */ int e(l r10) {
        return r10.f17813d;
    }

    public void f(CalendarDay r10) {
        long r11 = System.currentTimeMillis();
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f17810a.getText()) == false) goto L8;
    L9:
        g(r11, r10, false);
    L11:
        if (r10.equals(this.f17818i) == false) goto L13;
        return;
    L13:
        if (r10.getMonth() == this.f17818i.getMonth()) goto L15;
    L17:
        g(r11, r10, true);
        return;
    L15:
        if (r10.getYear() != this.f17818i.getYear()) goto L17;
        return;
    L8:
        if ((r11 - this.f17817h) >= this.f17812c) goto L11;
        goto L9
    }

    public final void g(long r10, CalendarDay r11, boolean r12) {
        this.f17810a.animate().cancel();
        h(this.f17810a, 0);
        this.f17810a.setAlpha(1.0f);
        this.f17817h = r10;
        CharSequence r13 = this.f17811b.format(r11);
        if (r12 == true) goto L5;
        this.f17810a.setText(r13);
    L14:
        this.f17818i = r11;
        return;
    L5:
        int r14 = this.f17814e;
        if (this.f17818i.isBefore(r11) == false) goto L8;
        int r15 = 1;
    L9:
        int r16 = r14 * r15;
        ViewPropertyAnimator r17 = this.f17810a.animate();
        if (this.f17816g != 1) goto L12;
        r17.translationX(r16 * (-1));
    L13:
        r17.alpha(0.0f).setDuration(this.f17813d).setInterpolator(this.f17815f).setListener(new a(this, r13, r16)).start();
        goto L14
    L12:
        r17.translationY(r16 * (-1));
        goto L13
    L8:
        r15 = -1;
        goto L9
    }

    public final void h(TextView r10, int r11) {
        if (this.f17816g != 1) goto L5;
        r10.setTranslationX(r11);
        return;
    L5:
        r10.setTranslationY(r11);
    }

    public int i() {
        return this.f17816g;
    }

    public void j(int r10) {
        this.f17816g = r10;
    }

    public void k(CalendarDay r10) {
        this.f17818i = r10;
    }

    public void l(TitleFormatter r10) {
        if (r10 != null) goto L4;
        r10 = TitleFormatter.DEFAULT;
    L4:
        this.f17811b = r10;
    }
}
