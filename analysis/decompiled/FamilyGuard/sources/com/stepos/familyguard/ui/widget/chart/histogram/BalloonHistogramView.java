package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.C0263b;
import A2.D;
import A2.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import g2.C0737g;
import y2.i;

/* loaded from: classes.dex */
public class BalloonHistogramView extends D {

    /* renamed from: i0, reason: collision with root package name */
    private int f15226i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f15227j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f15228k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f15229l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f15230m0;

    public BalloonHistogramView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getBalloonLineColor() {
        return this.f15229l0;
    }

    public int getBalloonLineMarginBottom() {
        return this.f15228k0;
    }

    public int getBalloonLineMarginTop() {
        return this.f15227j0;
    }

    public int getBalloonLineWidth() {
        return this.f15226i0;
    }

    public int getBalloonMarginBottom() {
        return this.f15230m0;
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView
    protected void i(boolean z5, int i5, Object obj) {
        super.i(z5, i5, obj);
        i foregroundLayer = getForegroundLayer();
        if (foregroundLayer != null) {
            if (foregroundLayer instanceof C0263b) {
                ((C0263b) foregroundLayer).q(this, z5, i5, obj);
            } else if (foregroundLayer instanceof k) {
                ((k) foregroundLayer).q(this, z5, i5, obj);
            }
        }
    }

    public void setBalloonLineColor(int i5) {
        this.f15229l0 = i5;
    }

    public void setBalloonLineMarginBottom(int i5) {
        this.f15228k0 = i5;
    }

    public void setBalloonLineMarginTop(int i5) {
        this.f15227j0 = i5;
    }

    public void setBalloonLineWidth(int i5) {
        this.f15226i0 = i5;
    }

    public void setBalloonMarginBottom(int i5) {
        this.f15230m0 = i5;
    }

    public BalloonHistogramView(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public BalloonHistogramView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f15226i0 = 0;
        this.f15227j0 = 0;
        this.f15228k0 = 0;
        this.f15229l0 = 0;
        this.f15230m0 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0737g.f17265F, i5, i6);
        this.f15226i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f15227j0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f15228k0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f15230m0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f15229l0 = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
