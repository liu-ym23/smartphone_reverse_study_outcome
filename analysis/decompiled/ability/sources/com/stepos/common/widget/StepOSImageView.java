package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public class StepOSImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3770a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;

    @RequiresApi(api = 21)
    public StepOSImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3770a = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.o, 0, 0);
        this.f3770a = typedArrayObtainStyledAttributes.getBoolean(1, this.f3770a);
        this.b = typedArrayObtainStyledAttributes.getInt(0, 200);
        this.c = typedArrayObtainStyledAttributes.getFloat(3, 0.9f);
        this.d = typedArrayObtainStyledAttributes.getFloat(4, 0.9f);
        this.e = typedArrayObtainStyledAttributes.getFloat(2, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getDuration() {
        return this.b;
    }

    public float getToAlpha() {
        return this.e;
    }

    public float getToXScale() {
        return this.c;
    }

    public float getToYScale() {
        return this.d;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z10) {
        this.f3770a = z10;
    }
}
