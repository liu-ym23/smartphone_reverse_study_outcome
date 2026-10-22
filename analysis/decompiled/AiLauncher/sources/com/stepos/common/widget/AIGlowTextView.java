package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
class AIGlowTextView extends AppCompatTextView {
    private ValueAnimator animator;
    private LinearGradient mGradient;

    public AIGlowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1250L);
        this.animator.setRepeatCount(-1);
        this.animator.setRepeatMode(1);
        this.animator.setInterpolator(new LinearInterpolator());
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIGlowTextView.f(this.f29519a, valueAnimator);
            }
        });
    }

    public static /* synthetic */ void f(AIGlowTextView aIGlowTextView, ValueAnimator valueAnimator) {
        aIGlowTextView.getClass();
        float measuredWidth = aIGlowTextView.getMeasuredWidth() * 2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
        aIGlowTextView.mGradient = new LinearGradient(measuredWidth - aIGlowTextView.getMeasuredWidth(), 0.0f, measuredWidth, aIGlowTextView.getMeasuredHeight(), new int[]{aIGlowTextView.getCurrentTextColor(), -1, aIGlowTextView.getCurrentTextColor()}, (float[]) null, Shader.TileMode.CLAMP);
        aIGlowTextView.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getPaint().setShader(this.mGradient);
        super.onDraw(canvas);
    }
}
