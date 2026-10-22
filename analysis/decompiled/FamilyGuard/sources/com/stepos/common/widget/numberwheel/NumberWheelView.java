package com.stepos.common.widget.numberwheel;

import H1.e;
import H1.m;
import N1.j;
import P.e;
import P.g;
import P.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.stepos.common.widget.numberwheel.NumberWheelView;

/* loaded from: classes.dex */
public class NumberWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    protected i f14450a;

    /* renamed from: b, reason: collision with root package name */
    private int f14451b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f14452c;

    /* renamed from: d, reason: collision with root package name */
    private Camera f14453d;

    /* renamed from: e, reason: collision with root package name */
    private int f14454e;

    /* renamed from: f, reason: collision with root package name */
    private int f14455f;

    /* renamed from: g, reason: collision with root package name */
    private float f14456g;

    /* renamed from: h, reason: collision with root package name */
    private int f14457h;

    /* renamed from: i, reason: collision with root package name */
    private int f14458i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f14459j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f14460k;

    /* renamed from: l, reason: collision with root package name */
    private BlurMaskFilter[] f14461l;

    /* renamed from: m, reason: collision with root package name */
    private int f14462m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14463n;

    /* renamed from: o, reason: collision with root package name */
    private int f14464o;

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14454e = 0;
        this.f14455f = 0;
        this.f14456g = 0.0f;
        this.f14463n = true;
        this.f14464o = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f2652r3);
        this.f14451b = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f2664t3, j.a(context, 60.0d));
        this.f14462m = typedArrayObtainStyledAttributes.getColor(m.f2658s3, a.c(context, e.f2081c));
        c();
    }

    public static /* synthetic */ void a(NumberWheelView numberWheelView, P.e eVar, boolean z5, float f5, float f6) {
        numberWheelView.f14454e = numberWheelView.f14455f;
        if (numberWheelView.f14464o == 1) {
            numberWheelView.f14464o = 2;
        } else {
            numberWheelView.f14456g = 0.0f;
        }
    }

    public static /* synthetic */ void b(NumberWheelView numberWheelView, P.e eVar, float f5, float f6) {
        numberWheelView.f14456g = f5;
        numberWheelView.invalidate();
        if (numberWheelView.f14464o != 0) {
            numberWheelView.requestLayout();
        }
    }

    private void c() {
        Paint paint = new Paint(1);
        this.f14452c = paint;
        paint.setTextSize(this.f14451b);
        this.f14452c.setTextAlign(Paint.Align.CENTER);
        this.f14452c.setColor(this.f14462m);
        this.f14453d = new Camera();
        this.f14459j = new Paint(this.f14452c);
        this.f14460k = new Paint(this.f14452c);
        BlurMaskFilter[] blurMaskFilterArr = new BlurMaskFilter[40];
        this.f14461l = blurMaskFilterArr;
        blurMaskFilterArr[0] = null;
        int i5 = 1;
        while (true) {
            BlurMaskFilter[] blurMaskFilterArr2 = this.f14461l;
            if (i5 >= blurMaskFilterArr2.length) {
                setLayerType(1, this.f14452c);
                i iVarX = new i(new g()).x(new P.j().f(0.65f).h(250.0f));
                this.f14450a = iVarX;
                iVarX.c(new e.r() { // from class: O1.a
                    @Override // P.e.r
                    public final void a(P.e eVar, float f5, float f6) {
                        NumberWheelView.b(this.f4343a, eVar, f5, f6);
                    }
                });
                this.f14450a.b(new e.q() { // from class: O1.b
                    @Override // P.e.q
                    public final void a(P.e eVar, boolean z5, float f5, float f6) {
                        NumberWheelView.a(this.f4344a, eVar, z5, f5, f6);
                    }
                });
                return;
            }
            blurMaskFilterArr2[i5] = new BlurMaskFilter(i5, BlurMaskFilter.Blur.NORMAL);
            i5++;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14464o == 2) {
            return;
        }
        float f5 = this.f14456g;
        float f6 = f5 / 90.0f;
        this.f14459j.setAlpha((int) ((1.0f - (f5 / 90.0f)) * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr = this.f14461l;
        int length = (int) (blurMaskFilterArr.length * f6);
        if (length < blurMaskFilterArr.length && length >= 0) {
            this.f14459j.setMaskFilter(blurMaskFilterArr[length]);
        }
        canvas.save();
        this.f14453d.save();
        float f7 = this.f14456g;
        if (f7 <= 90.0f) {
            if (this.f14463n) {
                this.f14453d.rotateX(f7);
                canvas.translate(this.f14457h, this.f14458i - this.f14456g);
            } else {
                this.f14453d.rotateX(-f7);
                canvas.translate(this.f14457h, this.f14458i + this.f14456g);
            }
            this.f14453d.applyToCanvas(canvas);
            canvas.drawText(String.valueOf(this.f14454e), 0.0f, this.f14458i / 2.0f, this.f14459j);
        }
        this.f14453d.restore();
        canvas.restore();
        if (this.f14464o == 1) {
            return;
        }
        this.f14460k.setAlpha((int) (255.0f * f6));
        BlurMaskFilter[] blurMaskFilterArr2 = this.f14461l;
        int length2 = (int) (blurMaskFilterArr2.length * (1.0f - f6));
        if (length2 >= 0 && length2 < blurMaskFilterArr2.length) {
            this.f14460k.setMaskFilter(blurMaskFilterArr2[length2]);
        }
        canvas.save();
        this.f14453d.save();
        if (this.f14463n) {
            this.f14453d.rotateX(((this.f14456g / 90.0f) * 90.0f) - 90.0f);
            canvas.translate(this.f14457h, this.f14458i + (90.0f - this.f14456g));
        } else {
            this.f14453d.rotateX(90.0f - ((this.f14456g / 90.0f) * 90.0f));
            canvas.translate(this.f14457h, this.f14458i - (90.0f - this.f14456g));
        }
        this.f14453d.applyToCanvas(canvas);
        canvas.drawText(String.valueOf(this.f14455f), 0.0f, this.f14458i / 2.0f, this.f14460k);
        this.f14453d.restore();
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        float fMeasureText = this.f14452c.measureText(String.valueOf(9));
        Paint.FontMetrics fontMetrics = this.f14452c.getFontMetrics();
        float f5 = fontMetrics.descent - fontMetrics.ascent;
        float fMax = Math.max(fMeasureText, getSuggestedMinimumWidth());
        float fMax2 = Math.max(f5, getSuggestedMinimumHeight());
        if (this.f14464o != 0) {
            setMeasuredDimension((int) (fMax * (1.0f - Math.min(this.f14456g / 90.0f, 1.0f))), (int) fMax2);
        } else {
            setMeasuredDimension((int) fMax, ((int) fMax2) + j.a(getContext(), 30.0d));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f14457h = i5 / 2;
        this.f14458i = i6 / 2;
    }

    public void setTextColor(int i5) {
        this.f14452c.setColor(i5);
        this.f14459j.setColor(i5);
        this.f14460k.setColor(i5);
        invalidate();
    }

    public void setTextSize(int i5) {
        float f5 = i5;
        this.f14452c.setTextSize(f5);
        this.f14459j.setTextSize(f5);
        this.f14460k.setTextSize(f5);
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        this.f14452c.setTypeface(typeface);
        this.f14459j.setTypeface(typeface);
        this.f14460k.setTypeface(typeface);
        requestLayout();
    }
}
