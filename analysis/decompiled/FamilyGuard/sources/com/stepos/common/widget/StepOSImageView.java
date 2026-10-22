package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class StepOSImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f14236a;

    /* renamed from: b, reason: collision with root package name */
    private int f14237b;

    /* renamed from: c, reason: collision with root package name */
    private float f14238c;

    /* renamed from: d, reason: collision with root package name */
    private float f14239d;

    /* renamed from: e, reason: collision with root package name */
    private float f14240e;

    public StepOSImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14236a = true;
        a(context, attributeSet, 0, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.j5, i5, i6);
        this.f14236a = typedArrayObtainStyledAttributes.getBoolean(H1.m.l5, this.f14236a);
        this.f14237b = typedArrayObtainStyledAttributes.getInt(H1.m.k5, 200);
        this.f14238c = typedArrayObtainStyledAttributes.getFloat(H1.m.n5, 0.9f);
        this.f14239d = typedArrayObtainStyledAttributes.getFloat(H1.m.o5, 0.9f);
        this.f14240e = typedArrayObtainStyledAttributes.getFloat(H1.m.m5, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getDuration() {
        return this.f14237b;
    }

    public float getToAlpha() {
        return this.f14240e;
    }

    public float getToXScale() {
        return this.f14238c;
    }

    public float getToYScale() {
        return this.f14239d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z5) {
        this.f14236a = z5;
    }
}
