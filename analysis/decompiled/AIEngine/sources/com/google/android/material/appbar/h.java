package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import stepos.support.v7.app.s;
import stepos.support.v7.app.w;
import stepos.support.v7.widget.ActionBarOverlayLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4598a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4599b;

    public /* synthetic */ h(Object obj, int i10) {
        this.f4598a = i10;
        this.f4599b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f4598a) {
            case 0:
                super.onAnimationCancel(animator);
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.f4599b;
                stepOSAppBarBehavior.f4574u = false;
                if (stepOSAppBarBehavior.f4573t != null) {
                    Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                    h1.f fVar = stepOSAppBarBehavior.f4573t.f3240a;
                    if (fVar != null && fVar.f9232f) {
                        fVar.f();
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
        switch (this.f4598a) {
            case 0:
                super.onAnimationEnd(animator);
                ((StepOSAppBarBehavior) this.f4599b).f4574u = false;
                break;
            case 1:
                ((com.google.android.material.textfield.c) this.f4599b).f5287b.h(false);
                break;
            case 2:
                com.google.android.material.textfield.j jVar = (com.google.android.material.textfield.j) this.f4599b;
                jVar.p();
                jVar.r.start();
                break;
            case 3:
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) this.f4599b;
                if (stepOSPressAnimationDrawable.f6443y) {
                    stepOSPressAnimationDrawable.f6443y = false;
                    stepOSPressAnimationDrawable.c();
                    break;
                }
                break;
            case 4:
                ((HideBottomViewOnScrollBehavior) this.f4599b).f4618n = null;
                break;
            case 5:
                ((HideViewOnScrollBehavior) this.f4599b).f4629o = null;
                break;
            case 6:
                super.onAnimationEnd(animator);
                s sVar = (s) this.f4599b;
                sVar.f12264d.r();
                sVar.f12264d.overridePendingTransition(0, 0);
                sVar.f12266f = null;
                w.a().getClass();
                w.f12270a = null;
                break;
            default:
                super.onAnimationEnd(animator);
                ((ActionBarOverlayLayout) this.f4599b).f12479e.setVisibility(4);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f4598a) {
            case 0:
                super.onAnimationStart(animator);
                ((StepOSAppBarBehavior) this.f4599b).f4574u = true;
                break;
            case 6:
                if (!((s) this.f4599b).a()) {
                    Log.d("popup_stack", " top stack start exit Anim, try to call bottom stack do stackExit ");
                    w.a().getClass();
                    Log.e("popup_stack", "  call bottom stack do stackExit , but state error, return ");
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
