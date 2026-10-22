package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.stepos.alphame.utils.Property;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.widget.SwimmingAnimationView;
import h.RunnableC0583a;
import java.util.ArrayList;
import java.util.Iterator;
import stepos.support.v7.widget.StepOSRecyclerView;

/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3074a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3075b;

    public /* synthetic */ C0195d(int i4, Object obj) {
        this.f3074a = i4;
        this.f3075b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i4 = this.f3074a;
        Object obj = this.f3075b;
        switch (i4) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.f2781w = null;
                actionBarOverlayLayout.f2768j = false;
                break;
            case 3:
                super.onAnimationCancel(animator);
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) obj;
                stepOSAppBarBehavior.f10279r = false;
                if (stepOSAppBarBehavior.f10278q != null) {
                    Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                    B0.c cVar = stepOSAppBarBehavior.f10278q;
                    W.m mVar = (W.m) cVar.f136a;
                    if (mVar != null && mVar.f1967f) {
                        mVar.c();
                    }
                    W.m mVar2 = (W.m) cVar.f137b;
                    if (mVar2 != null && mVar2.f1967f) {
                        mVar2.c();
                    }
                    stepOSAppBarBehavior.b();
                    break;
                }
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f3074a;
        Object obj = this.f3075b;
        switch (i4) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.f2781w = null;
                actionBarOverlayLayout.f2768j = false;
                return;
            case 1:
                ((o0.s) obj).m();
                animator.removeListener(this);
                return;
            case 2:
                p0.e eVar = (p0.e) obj;
                ArrayList arrayList = new ArrayList(eVar.f13855e);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ColorStateList colorStateList = ((com.google.android.material.checkbox.a) arrayList.get(i5)).f10546b.f10561o;
                    if (colorStateList != null) {
                        eVar.setTintList(colorStateList);
                    }
                }
                return;
            case 3:
                super.onAnimationEnd(animator);
                ((StepOSAppBarBehavior) obj).f10279r = false;
                return;
            case 4:
                ((HideBottomViewOnScrollBehavior) obj).f10381k = null;
                return;
            case 5:
                ((HideViewOnScrollBehavior) obj).f10393l = null;
                return;
            case 6:
            case 10:
            default:
                super.onAnimationEnd(animator);
                return;
            case 7:
                B0.g.y(obj);
                throw null;
            case 8:
                com.google.android.material.textfield.k kVar = (com.google.android.material.textfield.k) obj;
                kVar.q();
                kVar.f11031r.start();
                return;
            case 9:
                ((ExpandableTransformationBehavior) obj).getClass();
                return;
            case 11:
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) obj;
                if (stepOSPressAnimationDrawable.f11262v) {
                    stepOSPressAnimationDrawable.f11262v = false;
                    stepOSPressAnimationDrawable.c();
                    return;
                }
                return;
            case 12:
                SwimmingAnimationView swimmingAnimationView = (SwimmingAnimationView) obj;
                if (Settings.Global.getFloat(swimmingAnimationView.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != Property.DEFAULT_FLOAT_VALUE) {
                    swimmingAnimationView.post(new RunnableC0583a(23, this));
                    return;
                } else {
                    Log.d("SwimmingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                    swimmingAnimationView.a();
                    return;
                }
            case 13:
                super.onAnimationEnd(animator);
                ((stepos.support.v7.widget.ActionBarOverlayLayout) obj).f14773e.setVisibility(4);
                return;
            case 14:
                super.onAnimationEnd(animator);
                stepos.support.v7.widget.j0 j0Var = (stepos.support.v7.widget.j0) obj;
                j0Var.f15094g = true;
                Iterator it = j0Var.f15088a.values().iterator();
                if (it.hasNext()) {
                    B0.g.y(it.next());
                    throw null;
                }
                boolean z4 = j0Var.f15094g;
                if (z4) {
                    j0Var.f15092e = 3;
                }
                if (z4) {
                    boolean z5 = StepOSRecyclerView.f14911C0;
                    j0Var.f15095h.getClass();
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        switch (this.f3074a) {
            case 3:
                super.onAnimationPause(animator);
                break;
            default:
                super.onAnimationPause(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        switch (this.f3074a) {
            case 3:
                super.onAnimationRepeat(animator);
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        switch (this.f3074a) {
            case 3:
                super.onAnimationResume(animator);
                break;
            default:
                super.onAnimationResume(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f3074a;
        Object obj = this.f3075b;
        switch (i4) {
            case 2:
                p0.e eVar = (p0.e) obj;
                ArrayList arrayList = new ArrayList(eVar.f13855e);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    com.google.android.material.checkbox.c cVar = ((com.google.android.material.checkbox.a) arrayList.get(i5)).f10546b;
                    ColorStateList colorStateList = cVar.f10561o;
                    if (colorStateList != null) {
                        eVar.setTint(colorStateList.getColorForState(cVar.f10565s, colorStateList.getDefaultColor()));
                    }
                }
                return;
            case 3:
                super.onAnimationStart(animator);
                ((StepOSAppBarBehavior) obj).f10279r = true;
                return;
            case 7:
                B0.g.y(obj);
                throw null;
            case 10:
                super.onAnimationStart(animator);
                ((com.stepos.common.animator.d) obj).f11285b = SystemClock.uptimeMillis();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
