package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatButton;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class StepOSButton extends AppCompatButton {
    private boolean mAlphaAnimEnabled;
    private com.stepos.common.animator.f mHelper;
    private boolean mPressAnimationEnabled;

    public StepOSButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public final void a() {
        com.stepos.common.animator.f fVar = new com.stepos.common.animator.f();
        this.mHelper = fVar;
        fVar.f(this, true, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_MASK);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mHelper.i(this, motionEvent);
        if (isEnabled() && this.mPressAnimationEnabled) {
            motionEvent.getAction();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z10) {
        if (this.mPressAnimationEnabled != z10) {
            this.mPressAnimationEnabled = z10;
            a();
        }
    }

    public StepOSButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAlphaAnimEnabled = false;
        this.mPressAnimationEnabled = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StepOSButton, i10, 0);
        this.mAlphaAnimEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSButton_steposPressAnimationAlphaEnabled, this.mAlphaAnimEnabled);
        this.mPressAnimationEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSButton_pressAnimationEnabled, this.mPressAnimationEnabled);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
