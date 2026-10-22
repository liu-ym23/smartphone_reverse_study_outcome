package adc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f3052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TimeInterpolator f3053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f3054d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f3051a.getViewTreeObserver().removeOnPreDrawListener(this);
        c r100 = this.f3052b;
        TimeInterpolator r101 = this.f3053c;
        Animator.AnimatorListener r102 = this.f3054d;
        View r103 = (View) ListProtector.get(r100.f3061d, 0);
        r103.setAlpha(r100.f3059b);
        r103.animate().setDuration(r100.f3058a).alpha(r100.f3060c).setListener(r102).setInterpolator(r101);
        return true;
    }

    public a(View r100, c r101, TimeInterpolator r102, Animator.AnimatorListener r103) {
        this.f3051a = r100;
        this.f3052b = r101;
        this.f3053c = r102;
        this.f3054d = r103;
    }
}
