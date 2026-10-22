package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.D;

/* loaded from: classes.dex */
class AIGlowTextView extends D {

    /* renamed from: h, reason: collision with root package name */
    private LinearGradient f13767h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f13768i;

    public AIGlowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f13768i = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1250L);
        this.f13768i.setRepeatCount(-1);
        this.f13768i.setRepeatMode(1);
        this.f13768i.setInterpolator(new LinearInterpolator());
        this.f13768i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIGlowTextView.t(this.f14378a, valueAnimator);
            }
        });
    }

    public static /* synthetic */ void t(AIGlowTextView aIGlowTextView, ValueAnimator valueAnimator) {
        aIGlowTextView.getClass();
        float measuredWidth = aIGlowTextView.getMeasuredWidth() * 2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
        aIGlowTextView.f13767h = new LinearGradient(measuredWidth - aIGlowTextView.getMeasuredWidth(), 0.0f, measuredWidth, aIGlowTextView.getMeasuredHeight(), new int[]{aIGlowTextView.getCurrentTextColor(), -1, aIGlowTextView.getCurrentTextColor()}, (float[]) null, Shader.TileMode.CLAMP);
        aIGlowTextView.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getPaint().setShader(this.f13767h);
        super.onDraw(canvas);
    }
}
