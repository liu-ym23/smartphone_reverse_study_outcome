package com.obric.oui.calendar;

import android.R;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TitleChanger.java */
/* JADX INFO: loaded from: classes4.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f34391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.calendar.a.g f34392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f34395e;
    private final Interpolator f;
    private int g;
    private long h;
    private CalendarDay i;

    static /* synthetic */ TextView a(n r0) {
        return r0.f34391a;
    }

    static /* synthetic */ void a(n r0, TextView r1, int r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ int b(n r0) {
        return r0.g;
    }

    static /* synthetic */ Interpolator c(n r0) {
        return r0.f;
    }

    static /* synthetic */ int d(n r0) {
        return r0.f34394d;
    }

    public n(TextView r3) {
        this.f34392b = com.obric.oui.calendar.a.g.f34371a;
        this.f = new DecelerateInterpolator(2.0f);
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.f34391a = r3;
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        this.f34393c = 400;
        this.f34394d = r4.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f34395e = (int) TypedValue.applyDimension(1, 20.0f, r4.getDisplayMetrics());
    }

    public void a(CalendarDay r7) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f34391a.getText()) == false) goto L8;
    L9:
        a(r0, r7, false);
    L11:
        if (r7.equals(this.i) == false) goto L13;
        return;
    L13:
        if (r7.getMonth() == this.i.getMonth()) goto L15;
    L17:
        a(r0, r7, true);
        return;
    L15:
        if (r7.getYear() != this.i.getYear()) goto L17;
        return;
    L8:
        if ((r0 - this.h) >= this.f34393c) goto L11;
        goto L9
    }

    private void a(long r3, CalendarDay r5, boolean r6) {
        this.f34391a.animate().cancel();
        a(this.f34391a, 0);
        this.f34391a.setAlpha(1.0f);
        this.h = r3;
        final CharSequence r4 = this.f34392b.a(r5);
        if (r6 == true) goto L5;
        this.f34391a.setText(r4);
    L14:
        this.i = r5;
        return;
    L5:
        int r7 = this.f34395e;
        if (this.i.isBefore(r5) == false) goto L8;
        int r8 = 1;
    L9:
        final int r9 = r7 * r8;
        ViewPropertyAnimator r10 = this.f34391a.animate();
        if (this.g != 1) goto L12;
        r10.translationX(r9 * (-1));
    L13:
        r10.alpha(0.0f).setDuration(this.f34394d).setInterpolator(this.f).setListener(new TitleChanger$1(this, r4, r9)).start();
        goto L14
    L12:
        r10.translationY(r9 * (-1));
        goto L13
    L8:
        r8 = -1;
        goto L9
    }

    private void a(TextView r2, int r3) {
        if (this.g != 1) goto L5;
        r2.setTranslationX(r3);
        return;
    L5:
        r2.setTranslationY(r3);
    }

    public void a(com.obric.oui.calendar.a.g r3) {
        com.obric.oui.calendar.a.g r4 = (com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.g.f34371a;
    L5:
        this.f34392b = r4;
    }

    public void a(int r1) {
        this.g = r1;
    }

    public int a() {
        return this.g;
    }

    public void b(CalendarDay r1) {
        this.i = r1;
    }
}
