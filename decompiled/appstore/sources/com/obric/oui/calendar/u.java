package com.obric.oui.calendar;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.obric.oui.calendar.format.TitleFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f12735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TitleFormatter f12736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f12740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f12743i;

    public class a extends com.obric.oui.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f12746c;

        public a(u r10, CharSequence r11, int r12) {
            this.f12746c = r10;
            this.f12744a = r11;
            this.f12745b = r12;
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            u r11 = this.f12746c;
            u.b(r11, u.a(r11), 0);
            u.a(this.f12746c).setAlpha(1.0f);
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            u.a(this.f12746c).setText(this.f12744a);
            u r11 = this.f12746c;
            u.b(r11, u.a(r11), this.f12745b);
            ViewPropertyAnimator r12 = u.a(this.f12746c).animate();
            if (u.c(this.f12746c) != 1) goto L5;
            r12.translationX(0.0f);
        L6:
            r12.alpha(1.0f).setDuration(u.e(this.f12746c)).setInterpolator(u.d(this.f12746c)).setListener(new com.obric.oui.calendar.a()).start();
            return;
        L5:
            r12.translationY(0.0f);
            goto L6
        }
    }

    public u(TextView r10) {
        this.f12736b = TitleFormatter.DEFAULT;
        this.f12740f = new DecelerateInterpolator(2.0f);
        this.f12741g = 0;
        this.f12742h = 0;
        this.f12743i = null;
        this.f12735a = r10;
        Resources r11 = r10.getResources();
        this.f12737c = 400;
        this.f12738d = r11.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f12739e = (int) TypedValue.applyDimension(1, 20.0f, r11.getDisplayMetrics());
    }

    public static /* synthetic */ TextView a(u r10) {
        return r10.f12735a;
    }

    public static /* synthetic */ void b(u r10, TextView r11, int r12) {
        r10.h(r11, r12);
    }

    public static /* synthetic */ int c(u r10) {
        return r10.f12741g;
    }

    public static /* synthetic */ Interpolator d(u r10) {
        return r10.f12740f;
    }

    public static /* synthetic */ int e(u r10) {
        return r10.f12738d;
    }

    public void f(CalendarDay r10) {
        long r11 = System.currentTimeMillis();
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f12735a.getText()) == false) goto L8;
    L9:
        g(r11, r10, false);
    L11:
        if (r10.equals(this.f12743i) == false) goto L13;
        return;
    L13:
        if (r10.getMonth() == this.f12743i.getMonth()) goto L15;
    L17:
        g(r11, r10, true);
        return;
    L15:
        if (r10.getYear() != this.f12743i.getYear()) goto L17;
        return;
    L8:
        if ((r11 - this.f12742h) >= this.f12737c) goto L11;
        goto L9
    }

    public final void g(long r10, CalendarDay r11, boolean r12) {
        this.f12735a.animate().cancel();
        h(this.f12735a, 0);
        this.f12735a.setAlpha(1.0f);
        this.f12742h = r10;
        CharSequence r13 = this.f12736b.format(r11);
        if (r12 == true) goto L5;
        this.f12735a.setText(r13);
    L14:
        this.f12743i = r11;
        return;
    L5:
        int r14 = this.f12739e;
        if (this.f12743i.isBefore(r11) == false) goto L8;
        int r15 = 1;
    L9:
        int r16 = r14 * r15;
        ViewPropertyAnimator r17 = this.f12735a.animate();
        if (this.f12741g != 1) goto L12;
        r17.translationX(r16 * (-1));
    L13:
        r17.alpha(0.0f).setDuration(this.f12738d).setInterpolator(this.f12740f).setListener(new a(this, r13, r16)).start();
        goto L14
    L12:
        r17.translationY(r16 * (-1));
        goto L13
    L8:
        r15 = -1;
        goto L9
    }

    public final void h(TextView r10, int r11) {
        if (this.f12741g != 1) goto L5;
        r10.setTranslationX(r11);
        return;
    L5:
        r10.setTranslationY(r11);
    }

    public int i() {
        return this.f12741g;
    }

    public void j(int r10) {
        this.f12741g = r10;
    }

    public void k(CalendarDay r10) {
        this.f12743i = r10;
    }

    public void l(TitleFormatter r10) {
        if (r10 != null) goto L4;
        r10 = TitleFormatter.DEFAULT;
    L4:
        this.f12736b = r10;
    }
}
