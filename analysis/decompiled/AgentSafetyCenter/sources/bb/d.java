package bb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import n3.p0;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.k1;
import z3.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2054a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2055b;

    public d(p0 p0Var, View view) {
        this.f2054a = 4;
        this.f2055b = p0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2054a) {
            case 1:
                super.onAnimationCancel(animator);
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.f2055b;
                stepOSAppBarBehavior.f2324r = false;
                if (stepOSAppBarBehavior.f2323q != null) {
                    Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                    g gVar = (g) stepOSAppBarBehavior.f2323q.f19f;
                    if (gVar != null && gVar.f16365f) {
                        gVar.b();
                    }
                    stepOSAppBarBehavior.b();
                    break;
                }
                break;
            case 2:
            default:
                super.onAnimationCancel(animator);
                break;
            case 3:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2055b;
                actionBarOverlayLayout.A = null;
                actionBarOverlayLayout.f779n = false;
                break;
            case 4:
                ((p0) this.f2055b).a();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i = this.f2054a;
        Object obj = this.f2055b;
        switch (i) {
            case 0:
                animator.getClass();
                e eVar = (e) obj;
                eVar.f2066l = 0.0f;
                eVar.f2062g.setAlpha(0);
                eVar.invalidateSelf();
                return;
            case 1:
                super.onAnimationEnd(animator);
                ((StepOSAppBarBehavior) obj).f2324r = false;
                return;
            case 2:
                d5.f fVar = (d5.f) obj;
                ArrayList arrayList = new ArrayList(fVar.i);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ColorStateList colorStateList = ((w6.a) arrayList.get(i3)).f15268b.f15279s;
                    if (colorStateList != null) {
                        fVar.setTintList(colorStateList);
                    }
                }
                return;
            case 3:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.A = null;
                actionBarOverlayLayout.f779n = false;
                return;
            case 4:
                ((p0) obj).d();
                return;
            case 5:
                ((HideBottomViewOnScrollBehavior) obj).f2392k = null;
                return;
            case 6:
                ((HideViewOnScrollBehavior) obj).f2402k = null;
                return;
            case 7:
            default:
                super.onAnimationEnd(animator);
                return;
            case 8:
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) obj;
                if (stepOSPressAnimationDrawable.f2534z) {
                    stepOSPressAnimationDrawable.f2534z = false;
                    stepOSPressAnimationDrawable.c();
                    return;
                }
                return;
            case 9:
                super.onAnimationEnd(animator);
                ((stepos.support.v7.widget.ActionBarOverlayLayout) obj).i.setVisibility(4);
                return;
            case 10:
                super.onAnimationEnd(animator);
                k1 k1Var = (k1) obj;
                k1Var.f12770g = true;
                Iterator it = k1Var.f12764a.values().iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
                boolean z10 = k1Var.f12770g;
                if (z10) {
                    k1Var.f12768e = 3;
                }
                if (z10) {
                    boolean z11 = StepOSRecyclerView.f12637u0;
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f2054a) {
            case 1:
                super.onAnimationStart(animator);
                ((StepOSAppBarBehavior) this.f2055b).f2324r = true;
                break;
            case 2:
                d5.f fVar = (d5.f) this.f2055b;
                ArrayList arrayList = new ArrayList(fVar.i);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((w6.a) arrayList.get(i)).a(fVar);
                }
                break;
            case 3:
            case 5:
            case 6:
            default:
                super.onAnimationStart(animator);
                break;
            case 4:
                ((p0) this.f2055b).c();
                break;
            case 7:
                super.onAnimationStart(animator);
                ((r9.d) this.f2055b).f10495b = SystemClock.uptimeMillis();
                break;
        }
    }

    public /* synthetic */ d(Object obj, int i) {
        this.f2054a = i;
        this.f2055b = obj;
    }
}
