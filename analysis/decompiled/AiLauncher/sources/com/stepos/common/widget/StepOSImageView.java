package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class StepOSImageView extends ImageView {
    private static final int ANIMATION_DURATION = 200;
    private static final float TO_ALPHA = 0.8f;
    private static final float TO_X_SCALE = 0.9f;
    private static final float TO_Y_SCALE = 0.9f;
    private boolean mAnimationEnabled;
    private int mDuration;
    private float mToAlpha;
    private float mToXScale;
    private float mToYScale;

    public StepOSImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimationEnabled = true;
        a(context, attributeSet, 0, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StepOSImageView, i10, i11);
        this.mAnimationEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSImageView_pressAnimationEnabled, this.mAnimationEnabled);
        this.mDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSImageView_pressAnimationDuration, 200);
        this.mToXScale = typedArrayObtainStyledAttributes.getFloat(R$styleable.StepOSImageView_toXScale, 0.9f);
        this.mToYScale = typedArrayObtainStyledAttributes.getFloat(R$styleable.StepOSImageView_toYScale, 0.9f);
        this.mToAlpha = typedArrayObtainStyledAttributes.getFloat(R$styleable.StepOSImageView_toAlpha, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public float getToAlpha() {
        return this.mToAlpha;
    }

    public float getToXScale() {
        return this.mToXScale;
    }

    public float getToYScale() {
        return this.mToYScale;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z10) {
        this.mAnimationEnabled = z10;
    }
}
