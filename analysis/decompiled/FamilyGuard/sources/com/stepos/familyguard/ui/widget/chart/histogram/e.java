package com.stepos.familyguard.ui.widget.chart.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.familyguard.ui.widget.chart.histogram.b;

/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: Z, reason: collision with root package name */
    private static final Typeface f15335Z = Typeface.create("sans-serif-medium", 0);

    /* renamed from: a0, reason: collision with root package name */
    private static final Typeface f15336a0 = Typeface.create("sans-serif", 0);

    /* renamed from: V, reason: collision with root package name */
    private int f15337V;

    /* renamed from: W, reason: collision with root package name */
    private int f15338W;

    /* renamed from: X, reason: collision with root package name */
    private int f15339X;

    /* renamed from: Y, reason: collision with root package name */
    private int f15340Y;

    public e(Context context, int i5, int i6, PathEffect pathEffect, PathEffect pathEffect2, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, b.a aVar, b.a aVar2, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2, int i15, int i16, boolean z5, boolean z6, boolean z7, boolean z8, int i17, int i18) {
        super(context, i5, i6, pathEffect, pathEffect2, i7, i8, i9, i10, i11, i12, i13, i14, aVar, aVar2, strArr, strArr2, iArr, iArr2, i15, i16, z5, z6, z7, z8);
        this.f15339X = -1;
        this.f15340Y = -1;
        this.f15337V = i18;
        this.f15338W = i17;
    }

    public void N(int i5) {
        this.f15339X = i5;
    }

    public void O(int i5) {
        this.f15340Y = i5;
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.b
    protected void v(Canvas canvas, boolean z5) {
        String[] strArrB;
        PointF[] pointFArr;
        TextPaint textPaint;
        if (true == z5) {
            strArrB = y();
            pointFArr = this.f15317w;
            textPaint = this.f15315u;
        } else {
            strArrB = B();
            pointFArr = this.f15312r;
            textPaint = this.f15316v;
        }
        int length = strArrB.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (true == z5 && x() == b.a.CENTER_BETWEEN_TOW_DIVIDER) {
                if (this.f15340Y == i5) {
                    textPaint.setColor(this.f15338W);
                    textPaint.setTypeface(f15335Z);
                } else if (this.f15339X == i5) {
                    textPaint.setColor(this.f15337V);
                    textPaint.setTypeface(f15335Z);
                } else {
                    textPaint.setColor(z());
                    textPaint.setTypeface(f15336a0);
                }
            }
            String str = strArrB[i5];
            PointF pointF = pointFArr[i5];
            HistogramView.l(str, canvas, pointF.x, pointF.y, textPaint);
        }
    }
}
