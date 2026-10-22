package com.stepos.familyguard.ui.widget.chart.histogram;

import A2.q;
import A2.z;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class b extends z {

    /* renamed from: A, reason: collision with root package name */
    private int f15291A;

    /* renamed from: B, reason: collision with root package name */
    private int f15292B;

    /* renamed from: C, reason: collision with root package name */
    private int f15293C;

    /* renamed from: D, reason: collision with root package name */
    private a f15294D;

    /* renamed from: E, reason: collision with root package name */
    private a f15295E;

    /* renamed from: F, reason: collision with root package name */
    private String[] f15296F;

    /* renamed from: G, reason: collision with root package name */
    private String[] f15297G;

    /* renamed from: H, reason: collision with root package name */
    private int[] f15298H;

    /* renamed from: I, reason: collision with root package name */
    private int[] f15299I;

    /* renamed from: J, reason: collision with root package name */
    private int f15300J;

    /* renamed from: K, reason: collision with root package name */
    private int f15301K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f15302L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f15303M;

    /* renamed from: N, reason: collision with root package name */
    private float[] f15304N;

    /* renamed from: O, reason: collision with root package name */
    private float[] f15305O;

    /* renamed from: P, reason: collision with root package name */
    private float f15306P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f15307Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f15308R;

    /* renamed from: S, reason: collision with root package name */
    private int f15309S;

    /* renamed from: T, reason: collision with root package name */
    private int f15310T;

    /* renamed from: U, reason: collision with root package name */
    private final Rect f15311U;

    /* renamed from: r, reason: collision with root package name */
    protected final PointF[] f15312r;

    /* renamed from: s, reason: collision with root package name */
    protected final boolean f15313s;

    /* renamed from: t, reason: collision with root package name */
    protected final boolean f15314t;

    /* renamed from: u, reason: collision with root package name */
    protected final TextPaint f15315u;

    /* renamed from: v, reason: collision with root package name */
    protected final TextPaint f15316v;

    /* renamed from: w, reason: collision with root package name */
    protected final PointF[] f15317w;

    /* renamed from: x, reason: collision with root package name */
    protected float f15318x;

    /* renamed from: y, reason: collision with root package name */
    protected float f15319y;

    /* renamed from: z, reason: collision with root package name */
    private int f15320z;

    public enum a {
        START,
        END,
        CENTER,
        CENTER_BETWEEN_TOW_DIVIDER
    }

    public b(Context context, int i5, int i6, PathEffect pathEffect, PathEffect pathEffect2, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, a aVar, a aVar2, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2, int i15, int i16, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(context, i5, i6, pathEffect, pathEffect2, i7, i8, i9, i10);
        this.f15313s = true;
        this.f15314t = false;
        TextPaint textPaint = new TextPaint();
        this.f15315u = textPaint;
        TextPaint textPaint2 = new TextPaint();
        this.f15316v = textPaint2;
        this.f15311U = new Rect();
        this.f15320z = i11;
        this.f15291A = i12;
        this.f15292B = i13;
        this.f15293C = i14;
        this.f15294D = aVar;
        this.f15295E = aVar2;
        this.f15296F = strArr;
        this.f15297G = strArr2;
        this.f15298H = iArr;
        this.f15299I = iArr2;
        this.f15300J = i15;
        this.f15301K = i16;
        this.f15302L = z5;
        this.f15303M = z6;
        this.f15307Q = z7;
        this.f15308R = z8;
        textPaint.setTextSize(i11);
        textPaint.setColor(this.f15292B);
        textPaint.setAntiAlias(true);
        textPaint2.setTextSize(this.f15291A);
        textPaint2.setColor(this.f15293C);
        textPaint2.setAntiAlias(true);
        this.f15317w = new PointF[strArr.length];
        this.f15312r = new PointF[strArr2.length];
    }

    public int A() {
        return this.f15301K;
    }

    public String[] B() {
        return this.f15297G;
    }

    public boolean C() {
        return this.f15302L;
    }

    public void D(boolean z5) {
        this.f15302L = z5;
    }

    public void E(boolean z5) {
        this.f15303M = z5;
    }

    public void F(a aVar) {
        this.f15294D = aVar;
    }

    public void G(boolean z5) {
        this.f15307Q = z5;
    }

    public void H(int i5) {
        this.f15320z = i5;
    }

    public void I(int[] iArr) {
        this.f15298H = iArr;
    }

    public void J(String[] strArr) {
        this.f15296F = strArr;
    }

    public void K(int i5) {
        this.f15292B = i5;
    }

    public void L(a aVar) {
        this.f15295E = aVar;
    }

    public void M(String[] strArr) {
        this.f15297G = strArr;
    }

    @Override // A2.z, y2.i
    public void c(Canvas canvas) {
        super.c(canvas);
        v(canvas, true);
        v(canvas, false);
    }

    @Override // A2.z, y2.i
    public int[] j(AbstractC1325f abstractC1325f, int i5, int i6) {
        int i7;
        int iMakeMeasureSpec;
        int i8;
        int iMakeMeasureSpec2;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        int length = this.f15296F.length;
        int length2 = this.f15297G.length;
        this.f15304N = new float[length];
        this.f15305O = new float[length2];
        for (int i9 = 0; i9 < length; i9++) {
            this.f15304N[i9] = this.f15315u.measureText(this.f15296F[i9]);
        }
        for (int i10 = 0; i10 < length2; i10++) {
            this.f15305O[i10] = this.f15316v.measureText(this.f15297G[i10]);
        }
        Paint.FontMetrics fontMetrics = this.f15315u.getFontMetrics();
        this.f15306P = fontMetrics.bottom - fontMetrics.top;
        Paint.FontMetrics fontMetrics2 = this.f15316v.getFontMetrics();
        this.f15319y = fontMetrics2.bottom - fontMetrics2.top;
        this.f15318x = C2.c.b(this.f15305O);
        int iW = w();
        int i11 = -((int) (this.f15306P + this.f15300J));
        if (mode == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
            this.f15309S = size;
            i7 = size - iW;
        } else {
            i7 = size + iW;
            this.f15309S = i7;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, mode);
        }
        if (mode2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, mode2);
            this.f15310T = size2;
            i8 = size2 - i11;
        } else {
            i8 = size2 + i11;
            this.f15310T = i8;
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, mode2);
        }
        a aVar = this.f15295E;
        int i12 = aVar != a.CENTER_BETWEEN_TOW_DIVIDER ? (int) (aVar == a.CENTER ? this.f15319y / 2.0f : this.f15319y) : 0;
        super.j(abstractC1325f, iMakeMeasureSpec, iMakeMeasureSpec2);
        return new int[]{i7, i8 + i12};
    }

    @Override // A2.z, y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int length = this.f15296F.length;
        int length2 = this.f15297G.length;
        q qVar = (q) abstractC1325f.getDataLayer().i();
        int iE = qVar.e();
        boolean zF = qVar.f();
        a aVar = this.f15295E;
        int i14 = aVar == a.CENTER_BETWEEN_TOW_DIVIDER ? 0 : (int) (aVar == a.CENTER ? this.f15319y / 2.0f : this.f15319y);
        boolean z6 = this.f15303M;
        if (z6) {
            i10 = i8 - i14;
            i9 = i6;
        } else {
            i9 = i6 + i14;
            i10 = i8;
        }
        if (z6) {
            i9 += ((int) this.f15306P) + this.f15300J;
            i11 = i6;
        } else {
            int i15 = (int) this.f15306P;
            int i16 = this.f15300J;
            i10 -= i15 + i16;
            i11 = i10 + i16;
        }
        int i17 = i10;
        int i18 = i9;
        boolean z7 = this.f15302L;
        if (z7) {
            i12 = (int) (i5 + this.f15318x + this.f15301K);
            i13 = i7;
        } else {
            i12 = i5;
            i13 = (int) (i7 - (this.f15318x + this.f15301K));
        }
        if (!zF) {
            i12 += iE;
            i13 -= iE;
        } else if (z7) {
            i12 += iE * 2;
        } else {
            i13 -= iE * 2;
        }
        int i19 = i13;
        int i20 = i12;
        super.l(abstractC1325f, z5, i20, i18, i19, i17);
        for (int i21 = 0; i21 < length; i21++) {
            PointF pointF = new PointF();
            pointF.x = u(true, this.f15307Q, i21, this.f15294D);
            pointF.y = i11;
            this.f15317w[i21] = pointF;
        }
        for (int i22 = 0; i22 < length2; i22++) {
            PointF pointF2 = new PointF();
            if (this.f15302L) {
                if (zF) {
                    pointF2.x = ((i20 - this.f15305O[i22]) - this.f15301K) - (iE * 2);
                } else {
                    pointF2.x = ((i20 - this.f15305O[i22]) - this.f15301K) - iE;
                }
            } else if (zF) {
                pointF2.x = this.f15301K + i19 + (iE * 2);
            } else {
                pointF2.x = this.f15301K + i19 + iE;
            }
            pointF2.y = u(false, this.f15308R, i22, this.f15295E);
            this.f15312r[i22] = pointF2;
        }
        this.f15311U.set(i20, i18, i19, i17);
    }

    @Override // A2.z, A2.AbstractC0264c
    public Rect m() {
        return this.f15311U;
    }

    @Override // A2.z, A2.AbstractC0264c
    public int n() {
        return this.f15310T;
    }

    @Override // A2.z, A2.AbstractC0264c
    public int o() {
        return this.f15309S;
    }

    protected float u(boolean z5, boolean z6, int i5, a aVar) {
        int i6;
        float f5;
        float f6;
        int length;
        float f7;
        if (z5) {
            float[] fArrP = p();
            int length2 = fArrP.length;
            i6 = this.f15298H[i5];
            f5 = fArrP[i6];
            f6 = i6 < length2 - 1 ? fArrP[i6 + 1] : -1.0f;
            length = fArrP.length;
            f7 = this.f15304N[i5];
        } else {
            float[] fArrQ = q();
            int length3 = fArrQ.length;
            i6 = this.f15299I[i5];
            f5 = fArrQ[i6];
            f6 = i6 < length3 - 1 ? fArrQ[i6 + 1] : -1.0f;
            length = fArrQ.length;
            f7 = this.f15319y;
        }
        if (aVar == a.START) {
            if (z6 && i6 == length - 1) {
                return f5 - f7;
            }
        } else if (aVar == a.END) {
            if (!z6 || i6 != 0) {
                return f5 - f7;
            }
        } else if (aVar == a.CENTER) {
            if (!z6 || i6 != 0) {
                if (z6 && i6 == length - 1) {
                    return f5 - f7;
                }
                return f5 - (f7 / 2.0f);
            }
        } else if (f6 > 0.0f) {
            f5 = (f5 + f6) / 2.0f;
            return f5 - (f7 / 2.0f);
        }
        return f5;
    }

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
            String str = strArrB[i5];
            PointF pointF = pointFArr[i5];
            HistogramView.l(str, canvas, pointF.x, pointF.y, textPaint);
        }
    }

    protected int w() {
        return -((int) (this.f15318x + this.f15301K));
    }

    public a x() {
        return this.f15294D;
    }

    public String[] y() {
        return this.f15296F;
    }

    public int z() {
        return this.f15292B;
    }
}
