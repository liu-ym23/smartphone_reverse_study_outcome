package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f13510b;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f13510b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean f(View view, View view2, boolean z5, boolean z6) {
        AnimatorSet animatorSet = this.f13510b;
        boolean z7 = animatorSet != null;
        if (z7) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetH = h(view, view2, z5, z7);
        this.f13510b = animatorSetH;
        animatorSetH.addListener(new a());
        this.f13510b.start();
        if (!z6) {
            this.f13510b.end();
        }
        return true;
    }

    protected abstract AnimatorSet h(View view, View view2, boolean z5, boolean z6);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
