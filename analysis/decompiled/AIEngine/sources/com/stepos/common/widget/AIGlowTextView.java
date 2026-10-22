package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class AIGlowTextView extends AppCompatTextView {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f6770k = 0;

    /* renamed from: j, reason: collision with root package name */
    public LinearGradient f6771j;

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
                int i10 = AIGlowTextView.f6770k;
                AIGlowTextView aIGlowTextView = this.f7142a;
                aIGlowTextView.getClass();
                float measuredWidth = aIGlowTextView.getMeasuredWidth() * 2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                aIGlowTextView.f6771j = new LinearGradient(measuredWidth - aIGlowTextView.getMeasuredWidth(), 0.0f, measuredWidth, aIGlowTextView.getMeasuredHeight(), new int[]{aIGlowTextView.getCurrentTextColor(), -1, aIGlowTextView.getCurrentTextColor()}, (float[]) null, Shader.TileMode.CLAMP);
                aIGlowTextView.invalidate();
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        getPaint().setShader(this.f6771j);
        super.onDraw(canvas);
    }
}
