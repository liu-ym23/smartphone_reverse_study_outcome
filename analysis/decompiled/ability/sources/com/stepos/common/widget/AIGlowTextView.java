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
    public static final /* synthetic */ int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public LinearGradient f3621a;

    public AIGlowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(1250L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i = AIGlowTextView.b;
                AIGlowTextView aIGlowTextView = this.f3799a;
                aIGlowTextView.getClass();
                float measuredWidth = aIGlowTextView.getMeasuredWidth() * 2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                aIGlowTextView.f3621a = new LinearGradient(measuredWidth - aIGlowTextView.getMeasuredWidth(), 0.0f, measuredWidth, aIGlowTextView.getMeasuredHeight(), new int[]{aIGlowTextView.getCurrentTextColor(), -1, aIGlowTextView.getCurrentTextColor()}, (float[]) null, Shader.TileMode.CLAMP);
                aIGlowTextView.invalidate();
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        getPaint().setShader(this.f3621a);
        super.onDraw(canvas);
    }
}
