package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import i2.AbstractC0620a;

/* loaded from: classes.dex */
public class StepOSImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11801a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11802b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11803c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11804d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11805e;

    @RequiresApi(api = 21)
    public StepOSImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11801a = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13033o, 0, 0);
        this.f11801a = typedArrayObtainStyledAttributes.getBoolean(1, this.f11801a);
        this.f11802b = typedArrayObtainStyledAttributes.getInt(0, 200);
        this.f11803c = typedArrayObtainStyledAttributes.getFloat(3, 0.9f);
        this.f11804d = typedArrayObtainStyledAttributes.getFloat(4, 0.9f);
        this.f11805e = typedArrayObtainStyledAttributes.getFloat(2, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getDuration() {
        return this.f11802b;
    }

    public float getToAlpha() {
        return this.f11805e;
    }

    public float getToXScale() {
        return this.f11803c;
    }

    public float getToYScale() {
        return this.f11804d;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z4) {
        this.f11801a = z4;
    }
}
