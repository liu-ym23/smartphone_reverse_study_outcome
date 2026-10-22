package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.C0200f0;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
class AIGlowTextView extends C0200f0 {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f11435h = 0;

    /* renamed from: g, reason: collision with root package name */
    public LinearGradient f11436g;

    public AIGlowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        valueAnimatorOfFloat.setDuration(1250L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i4 = AIGlowTextView.f11435h;
                AIGlowTextView aIGlowTextView = this.f11888a;
                aIGlowTextView.getClass();
                float measuredWidth = aIGlowTextView.getMeasuredWidth() * 2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                aIGlowTextView.f11436g = new LinearGradient(measuredWidth - aIGlowTextView.getMeasuredWidth(), Property.DEFAULT_FLOAT_VALUE, measuredWidth, aIGlowTextView.getMeasuredHeight(), new int[]{aIGlowTextView.getCurrentTextColor(), -1, aIGlowTextView.getCurrentTextColor()}, (float[]) null, Shader.TileMode.CLAMP);
                aIGlowTextView.invalidate();
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        getPaint().setShader(this.f11436g);
        super.onDraw(canvas);
    }
}
