package com.stepos.common.widget.numberwheel;

import W.i;
import W.j;
import W.l;
import W.m;
import W.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.numberwheel.NumberWheelView;
import i2.AbstractC0620a;
import m2.o;

/* loaded from: classes.dex */
public class NumberWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final m f11921a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11922b;

    /* renamed from: c, reason: collision with root package name */
    public final Camera f11923c;

    /* renamed from: d, reason: collision with root package name */
    public float f11924d;

    /* renamed from: e, reason: collision with root package name */
    public int f11925e;

    /* renamed from: f, reason: collision with root package name */
    public int f11926f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f11927g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f11928h;

    /* renamed from: i, reason: collision with root package name */
    public final BlurMaskFilter[] f11929i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11930j;

    /* renamed from: k, reason: collision with root package name */
    public int f11931k;

    public NumberWheelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11924d = Property.DEFAULT_FLOAT_VALUE;
        this.f11930j = true;
        this.f11931k = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13027i);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, o.b(context, 60.0d));
        int color = typedArrayObtainStyledAttributes.getColor(0, b.a(context, R.color.fd_sys_color_on_surface_default));
        Paint paint = new Paint(1);
        this.f11922b = paint;
        paint.setTextSize(dimensionPixelSize);
        this.f11922b.setTextAlign(Paint.Align.CENTER);
        this.f11922b.setColor(color);
        this.f11923c = new Camera();
        this.f11927g = new Paint(this.f11922b);
        this.f11928h = new Paint(this.f11922b);
        BlurMaskFilter[] blurMaskFilterArr = new BlurMaskFilter[40];
        this.f11929i = blurMaskFilterArr;
        blurMaskFilterArr[0] = null;
        int i4 = 1;
        while (true) {
            BlurMaskFilter[] blurMaskFilterArr2 = this.f11929i;
            if (i4 >= blurMaskFilterArr2.length) {
                setLayerType(1, this.f11922b);
                n nVar = new n();
                nVar.a(0.65f);
                nVar.b(250.0f);
                m mVar = new m(new l());
                mVar.f1974m = nVar;
                this.f11921a = mVar;
                mVar.b(new j() { // from class: n2.a
                    @Override // W.j
                    public final void a(float f4) {
                        NumberWheelView numberWheelView = this.f13662a;
                        numberWheelView.f11924d = f4;
                        numberWheelView.invalidate();
                        if (numberWheelView.f11931k != 0) {
                            numberWheelView.requestLayout();
                        }
                    }
                });
                this.f11921a.a(new i() { // from class: n2.b
                    @Override // W.i
                    public final void a(boolean z4) {
                        NumberWheelView numberWheelView = this.f13663a;
                        numberWheelView.getClass();
                        if (numberWheelView.f11931k == 1) {
                            numberWheelView.f11931k = 2;
                        } else {
                            numberWheelView.f11924d = Property.DEFAULT_FLOAT_VALUE;
                        }
                    }
                });
                return;
            }
            blurMaskFilterArr2[i4] = new BlurMaskFilter(i4, BlurMaskFilter.Blur.NORMAL);
            i4++;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11931k == 2) {
            return;
        }
        float f4 = this.f11924d / 90.0f;
        float f5 = 1.0f - f4;
        this.f11927g.setAlpha((int) (f5 * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr = this.f11929i;
        int length = (int) (blurMaskFilterArr.length * f4);
        if (length < blurMaskFilterArr.length && length >= 0) {
            this.f11927g.setMaskFilter(blurMaskFilterArr[length]);
        }
        canvas.save();
        this.f11923c.save();
        float f6 = this.f11924d;
        boolean z4 = this.f11930j;
        if (f6 <= 90.0f) {
            if (z4) {
                this.f11923c.rotateX(f6);
                canvas.translate(this.f11925e, this.f11926f - this.f11924d);
            } else {
                this.f11923c.rotateX(-f6);
                canvas.translate(this.f11925e, this.f11926f + this.f11924d);
            }
            this.f11923c.applyToCanvas(canvas);
            canvas.drawText(String.valueOf(0), Property.DEFAULT_FLOAT_VALUE, this.f11926f / 2.0f, this.f11927g);
        }
        this.f11923c.restore();
        canvas.restore();
        if (this.f11931k == 1) {
            return;
        }
        this.f11928h.setAlpha((int) (f4 * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr2 = this.f11929i;
        int length2 = (int) (f5 * blurMaskFilterArr2.length);
        if (length2 >= 0 && length2 < blurMaskFilterArr2.length) {
            this.f11928h.setMaskFilter(blurMaskFilterArr2[length2]);
        }
        canvas.save();
        this.f11923c.save();
        if (z4) {
            this.f11923c.rotateX(((this.f11924d / 90.0f) * 90.0f) - 90.0f);
            canvas.translate(this.f11925e, (90.0f - this.f11924d) + this.f11926f);
        } else {
            this.f11923c.rotateX(90.0f - ((this.f11924d / 90.0f) * 90.0f));
            canvas.translate(this.f11925e, this.f11926f - (90.0f - this.f11924d));
        }
        this.f11923c.applyToCanvas(canvas);
        canvas.drawText(String.valueOf(0), Property.DEFAULT_FLOAT_VALUE, this.f11926f / 2.0f, this.f11928h);
        this.f11923c.restore();
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        float fMeasureText = this.f11922b.measureText(String.valueOf(9));
        Paint.FontMetrics fontMetrics = this.f11922b.getFontMetrics();
        float f4 = fontMetrics.descent - fontMetrics.ascent;
        float fMax = Math.max(fMeasureText, getSuggestedMinimumWidth());
        float fMax2 = Math.max(f4, getSuggestedMinimumHeight());
        if (this.f11931k != 0) {
            setMeasuredDimension((int) ((1.0f - Math.min(this.f11924d / 90.0f, 1.0f)) * fMax), (int) fMax2);
        } else {
            setMeasuredDimension((int) fMax, o.b(getContext(), 30.0d) + ((int) fMax2));
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f11925e = i4 / 2;
        this.f11926f = i5 / 2;
    }

    public void setTextColor(@ColorInt int i4) {
        this.f11922b.setColor(i4);
        this.f11927g.setColor(i4);
        this.f11928h.setColor(i4);
        invalidate();
    }

    public void setTextSize(int i4) {
        float f4 = i4;
        this.f11922b.setTextSize(f4);
        this.f11927g.setTextSize(f4);
        this.f11928h.setTextSize(f4);
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        this.f11922b.setTypeface(typeface);
        this.f11927g.setTypeface(typeface);
        this.f11928h.setTypeface(typeface);
        requestLayout();
    }
}
