package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7056a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7057b;

    /* renamed from: c, reason: collision with root package name */
    public final float f7058c;

    /* renamed from: d, reason: collision with root package name */
    public final float f7059d;

    /* renamed from: e, reason: collision with root package name */
    public final float f7060e;

    public StepOSImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7056a = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9088o, 0, 0);
        this.f7056a = typedArrayObtainStyledAttributes.getBoolean(1, this.f7056a);
        this.f7057b = typedArrayObtainStyledAttributes.getInt(0, 200);
        this.f7058c = typedArrayObtainStyledAttributes.getFloat(3, 0.9f);
        this.f7059d = typedArrayObtainStyledAttributes.getFloat(4, 0.9f);
        this.f7060e = typedArrayObtainStyledAttributes.getFloat(2, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getDuration() {
        return this.f7057b;
    }

    public float getToAlpha() {
        return this.f7060e;
    }

    public float getToXScale() {
        return this.f7058c;
    }

    public float getToYScale() {
        return this.f7059d;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z) {
        this.f7056a = z;
    }
}
