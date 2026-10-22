package com.stepos.familyguard.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private long f15194a;

    /* renamed from: b, reason: collision with root package name */
    private long f15195b;

    /* renamed from: c, reason: collision with root package name */
    private long f15196c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f15197d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f15198e;

    /* renamed from: f, reason: collision with root package name */
    private int f15199f;

    /* renamed from: g, reason: collision with root package name */
    private int f15200g;

    /* renamed from: h, reason: collision with root package name */
    private int f15201h;

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15197d = new Rect();
        this.f15198e = new Rect();
        this.f15201h = Integer.MAX_VALUE;
        b(context, attributeSet);
    }

    private int a(int i5) {
        if (i5 > 0) {
            long j5 = this.f15194a;
            if (j5 > 0) {
                long j6 = this.f15196c;
                if (j6 > 0) {
                    long j7 = this.f15195b;
                    if (j6 < j7) {
                        j6 = j7;
                    }
                    int i6 = (int) (i5 * (j6 / j5));
                    int i7 = this.f15199f;
                    if (i7 > 0 && i6 < i7) {
                        i6 = i7;
                    }
                    if (i6 <= i5) {
                        i5 = i6;
                    }
                    this.f15198e.set(0, 0, i5, 0);
                    return i5;
                }
            }
        }
        return 0;
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "maxWidth", 0);
        if (attributeResourceValue != 0) {
            this.f15201h = context.getResources().getDimensionPixelSize(attributeResourceValue);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.maxWidth});
        this.f15201h = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, Integer.MAX_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    private int c(int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int i6 = this.f15201h;
        if (mode == 0 || size <= 0) {
            size = (i6 <= 0 || i6 >= Integer.MAX_VALUE) ? this.f15200g : i6;
        } else if (mode == 1073741824 && this.f15200g > 0 && size == this.f15198e.width()) {
            size = this.f15200g;
        } else if (i6 > 0 && i6 < Integer.MAX_VALUE) {
            size = Math.min(size, i6);
        }
        if (size > 0) {
            this.f15200g = size;
        }
        return size;
    }

    public Rect getDisplayBounds() {
        return this.f15198e;
    }

    public long getMax() {
        return this.f15194a;
    }

    public long getMin() {
        return this.f15195b;
    }

    public int getMinLength() {
        return this.f15199f;
    }

    public Rect getOriginalBounds() {
        return this.f15197d;
    }

    public long getValue() {
        return this.f15196c;
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        setMeasuredDimension(a(c(i5)), View.getDefaultSize(getSuggestedMinimumHeight(), i6));
    }

    public void setMax(long j5) {
        this.f15194a = j5;
        requestLayout();
    }

    public void setMin(long j5) {
        this.f15195b = j5;
    }

    public void setMinLength(int i5) {
        this.f15199f = i5;
    }

    public void setValue(long j5) {
        long j6 = this.f15194a;
        if (j5 > j6) {
            j5 = j6;
        }
        this.f15196c = j5;
        requestLayout();
    }
}
