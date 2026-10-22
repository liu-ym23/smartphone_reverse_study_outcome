package cdc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f23430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f23431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f23432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TimeInterpolator f23433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f23434e;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f23430a.getViewTreeObserver().removeOnPreDrawListener(this);
        int[] r100 = new int[2];
        this.f23430a.getLocationOnScreen(r100);
        a r101 = this.f23431b;
        d r102 = this.f23432c;
        r101.f23424a = r102.f23438b - r100[0];
        r101.f23425b = r102.f23437a - r100[1];
        if (this.f23430a.getWidth() > 0) goto L5;
    L7:
        a r103 = this.f23431b;
        TimeInterpolator r104 = this.f23433d;
        Animator.AnimatorListener r105 = this.f23434e;
        View r106 = r103.f23429f;
        r106.setPivotX(0.0f);
        r106.setPivotY(0.0f);
        r106.setScaleX(r103.f23426c);
        r106.setScaleY(r103.f23427d);
        r106.setTranslationX(r103.f23424a);
        r106.setTranslationY(r103.f23425b);
        r106.animate().setDuration(r103.f23428e).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(r105).setInterpolator(r104);
        return true;
    L5:
        if (this.f23430a.getHeight() <= 0) goto L7;
        this.f23431b.f23426c = this.f23432c.f23439c / this.f23430a.getWidth();
        this.f23431b.f23427d = this.f23432c.f23440d / this.f23430a.getHeight();
        goto L7
    }

    public b(View r100, a r101, d r102, TimeInterpolator r103, Animator.AnimatorListener r104) {
        this.f23430a = r100;
        this.f23431b = r101;
        this.f23432c = r102;
        this.f23433d = r103;
        this.f23434e = r104;
    }
}
