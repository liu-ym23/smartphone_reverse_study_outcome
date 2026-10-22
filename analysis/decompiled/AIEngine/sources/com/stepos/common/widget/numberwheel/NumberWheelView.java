package com.stepos.common.widget.numberwheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.aiengine.R;
import com.stepos.common.widget.numberwheel.NumberWheelView;
import g8.a;
import h1.d;
import h1.e;
import h1.f;
import l8.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NumberWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final f f7155a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f7156b;

    /* renamed from: c, reason: collision with root package name */
    public final Camera f7157c;

    /* renamed from: d, reason: collision with root package name */
    public float f7158d;

    /* renamed from: e, reason: collision with root package name */
    public int f7159e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f7160j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f7161k;

    /* renamed from: l, reason: collision with root package name */
    public final BlurMaskFilter[] f7162l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7163m;

    /* renamed from: n, reason: collision with root package name */
    public int f7164n;

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7158d = 0.0f;
        this.f7163m = true;
        this.f7164n = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f9082i);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, g.a(context, 60.0d));
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getColor(R.color.fd_sys_color_on_surface_default));
        Paint paint = new Paint(1);
        this.f7156b = paint;
        paint.setTextSize(dimensionPixelSize);
        this.f7156b.setTextAlign(Paint.Align.CENTER);
        this.f7156b.setColor(color);
        this.f7157c = new Camera();
        this.f7160j = new Paint(this.f7156b);
        this.f7161k = new Paint(this.f7156b);
        BlurMaskFilter[] blurMaskFilterArr = new BlurMaskFilter[40];
        this.f7162l = blurMaskFilterArr;
        blurMaskFilterArr[0] = null;
        int i10 = 1;
        while (true) {
            BlurMaskFilter[] blurMaskFilterArr2 = this.f7162l;
            if (i10 >= blurMaskFilterArr2.length) {
                setLayerType(1, this.f7156b);
                h1.g gVar = new h1.g();
                gVar.a(0.65f);
                gVar.b(250.0f);
                f fVar = new f(new e());
                fVar.f9241t = gVar;
                this.f7155a = fVar;
                fVar.b(new d.l() { // from class: p8.a
                    @Override // h1.d.l
                    public final void a(float f8) {
                        NumberWheelView numberWheelView = this.f11467a;
                        numberWheelView.f7158d = f8;
                        numberWheelView.invalidate();
                        if (numberWheelView.f7164n != 0) {
                            numberWheelView.requestLayout();
                        }
                    }
                });
                this.f7155a.a(new d.k() { // from class: p8.b
                    @Override // h1.d.k
                    public final void a(boolean z) {
                        NumberWheelView numberWheelView = this.f11468a;
                        if (numberWheelView.f7164n == 1) {
                            numberWheelView.f7164n = 2;
                        } else {
                            numberWheelView.f7158d = 0.0f;
                        }
                    }
                });
                return;
            }
            blurMaskFilterArr2[i10] = new BlurMaskFilter(i10, BlurMaskFilter.Blur.NORMAL);
            i10++;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7164n == 2) {
            return;
        }
        float f8 = this.f7158d / 90.0f;
        float f9 = 1.0f - f8;
        this.f7160j.setAlpha((int) (f9 * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr = this.f7162l;
        int length = (int) (blurMaskFilterArr.length * f8);
        if (length < blurMaskFilterArr.length && length >= 0) {
            this.f7160j.setMaskFilter(blurMaskFilterArr[length]);
        }
        canvas.save();
        this.f7157c.save();
        float f10 = this.f7158d;
        boolean z = this.f7163m;
        if (f10 <= 90.0f) {
            if (z) {
                this.f7157c.rotateX(f10);
                canvas.translate(this.f7159e, this.h - this.f7158d);
            } else {
                this.f7157c.rotateX(-f10);
                canvas.translate(this.f7159e, this.h + this.f7158d);
            }
            this.f7157c.applyToCanvas(canvas);
            canvas.drawText(String.valueOf(0), 0.0f, this.h / 2.0f, this.f7160j);
        }
        this.f7157c.restore();
        canvas.restore();
        if (this.f7164n == 1) {
            return;
        }
        this.f7161k.setAlpha((int) (f8 * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr2 = this.f7162l;
        int length2 = (int) (f9 * blurMaskFilterArr2.length);
        if (length2 >= 0 && length2 < blurMaskFilterArr2.length) {
            this.f7161k.setMaskFilter(blurMaskFilterArr2[length2]);
        }
        canvas.save();
        this.f7157c.save();
        if (z) {
            this.f7157c.rotateX(((this.f7158d / 90.0f) * 90.0f) - 90.0f);
            canvas.translate(this.f7159e, (90.0f - this.f7158d) + this.h);
        } else {
            this.f7157c.rotateX(90.0f - ((this.f7158d / 90.0f) * 90.0f));
            canvas.translate(this.f7159e, this.h - (90.0f - this.f7158d));
        }
        this.f7157c.applyToCanvas(canvas);
        canvas.drawText(String.valueOf(0), 0.0f, this.h / 2.0f, this.f7161k);
        this.f7157c.restore();
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        float fMeasureText = this.f7156b.measureText(String.valueOf(9));
        Paint.FontMetrics fontMetrics = this.f7156b.getFontMetrics();
        float f8 = fontMetrics.descent - fontMetrics.ascent;
        float fMax = Math.max(fMeasureText, getSuggestedMinimumWidth());
        float fMax2 = Math.max(f8, getSuggestedMinimumHeight());
        if (this.f7164n != 0) {
            setMeasuredDimension((int) ((1.0f - Math.min(this.f7158d / 90.0f, 1.0f)) * fMax), (int) fMax2);
        } else {
            setMeasuredDimension((int) fMax, g.a(getContext(), 30.0d) + ((int) fMax2));
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f7159e = i10 / 2;
        this.h = i11 / 2;
    }

    public void setTextColor(int i10) {
        this.f7156b.setColor(i10);
        this.f7160j.setColor(i10);
        this.f7161k.setColor(i10);
        invalidate();
    }

    public void setTextSize(int i10) {
        float f8 = i10;
        this.f7156b.setTextSize(f8);
        this.f7160j.setTextSize(f8);
        this.f7161k.setTextSize(f8);
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        this.f7156b.setTypeface(typeface);
        this.f7160j.setTypeface(typeface);
        this.f7161k.setTypeface(typeface);
        requestLayout();
    }
}
