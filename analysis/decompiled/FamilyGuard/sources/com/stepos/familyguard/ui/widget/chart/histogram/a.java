package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.q;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.text.TextPaint;
import com.stepos.familyguard.ui.widget.chart.histogram.b;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b0, reason: collision with root package name */
    private int f15278b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f15279c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f15280d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f15281e0;

    /* renamed from: f0, reason: collision with root package name */
    private PathEffect f15282f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Paint f15283g0;

    /* renamed from: h0, reason: collision with root package name */
    private final TextPaint f15284h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f15285i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f15286j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f15287k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f15288l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f15289m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f15290n0;

    public a(Context context, int i5, int i6, PathEffect pathEffect, PathEffect pathEffect2, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, b.a aVar, b.a aVar2, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2, int i15, int i16, boolean z5, boolean z6, boolean z7, boolean z8, int i17, int i18, int i19, int i20, String str, int i21, PathEffect pathEffect3, int i22) {
        super(context, i5, i6, pathEffect, pathEffect2, i7, i8, i9, i10, i11, i12, i13, i14, aVar, aVar2, strArr, strArr2, iArr, iArr2, i15, i16, z5, z6, z7, z8, i17, i18);
        this.f15278b0 = i19;
        this.f15279c0 = i20;
        this.f15280d0 = str;
        this.f15281e0 = i21;
        this.f15282f0 = pathEffect3;
        Paint paint = new Paint();
        this.f15283g0 = paint;
        paint.setColor(this.f15278b0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setPathEffect(this.f15282f0);
        paint.setStrokeWidth(i22);
        TextPaint textPaint = new TextPaint();
        this.f15284h0 = textPaint;
        textPaint.setColor(this.f15279c0);
        textPaint.setTextSize(i21);
    }

    protected boolean P() {
        int length = this.f151e.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (Q(i5)) {
                return true;
            }
        }
        return false;
    }

    protected boolean Q(int i5) {
        float f5 = this.f151e[i5];
        float f6 = this.f15319y;
        float f7 = f5 - (f6 / 2.0f);
        float f8 = f5 + (f6 / 2.0f);
        float f9 = this.f15286j0;
        float f10 = this.f15290n0;
        return f9 - (f10 / 2.0f) <= f8 && f9 + (f10 / 2.0f) >= f7;
    }

    public void R(float f5) {
        this.f15285i0 = f5;
        Rect rectM = m();
        float fHeight = rectM.bottom - (rectM.height() * this.f15285i0);
        this.f15286j0 = fHeight;
        this.f15288l0 = fHeight - (this.f15290n0 / 2.0f);
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.b, A2.z, y2.i
    public void c(Canvas canvas) {
        super.c(canvas);
        Rect rectM = m();
        float f5 = rectM.left;
        float f6 = rectM.right;
        this.f15283g0.setColor(this.f15278b0);
        float f7 = this.f15286j0;
        canvas.drawLine(f5, f7, f6, f7, this.f15283g0);
        if (P()) {
            return;
        }
        HistogramView.l(this.f15280d0, canvas, this.f15287k0, this.f15288l0, this.f15284h0);
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.b, A2.z, y2.i
    public int[] j(AbstractC1325f abstractC1325f, int i5, int i6) {
        super.j(abstractC1325f, i5, i6);
        this.f15289m0 = (int) this.f15284h0.measureText(this.f15280d0);
        Paint.FontMetrics fontMetrics = this.f15284h0.getFontMetrics();
        this.f15290n0 = fontMetrics.bottom - fontMetrics.top;
        this.f15318x = Math.max(this.f15318x, this.f15289m0);
        return super.j(abstractC1325f, i5, i6);
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.b, A2.z, y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        super.l(abstractC1325f, z5, i5, i6, i7, i8);
        int iHeight = m().height();
        q qVar = (q) abstractC1325f.getDataLayer().i();
        int iE = qVar.e();
        boolean zF = qVar.f();
        this.f15286j0 = r2.bottom - (iHeight * this.f15285i0);
        if (C()) {
            if (zF) {
                this.f15287k0 = ((r2.left - A()) - this.f15289m0) - (iE * 2);
            } else {
                this.f15287k0 = ((r2.left - A()) - this.f15289m0) - iE;
            }
        } else if (zF) {
            this.f15287k0 = r2.right + A() + (iE * 2);
        } else {
            this.f15287k0 = r2.right + A() + iE;
        }
        this.f15288l0 = this.f15286j0 - (this.f15290n0 / 2.0f);
    }

    @Override // com.stepos.familyguard.ui.widget.chart.histogram.b
    protected int w() {
        float fMax = Math.max(this.f15318x, this.f15289m0);
        this.f15318x = fMax;
        return -((int) (fMax + A()));
    }
}
