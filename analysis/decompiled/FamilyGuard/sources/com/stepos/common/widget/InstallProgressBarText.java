package com.stepos.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallProgressBarText extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f14010a;

    /* renamed from: b, reason: collision with root package name */
    private int f14011b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f14012c;

    /* renamed from: d, reason: collision with root package name */
    private int f14013d;

    /* renamed from: e, reason: collision with root package name */
    private int f14014e;

    /* renamed from: f, reason: collision with root package name */
    private int f14015f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f14016g;

    /* renamed from: h, reason: collision with root package name */
    private String f14017h;

    /* renamed from: i, reason: collision with root package name */
    private int f14018i;

    /* renamed from: j, reason: collision with root package name */
    private int f14019j;

    /* renamed from: k, reason: collision with root package name */
    private float f14020k;

    /* renamed from: l, reason: collision with root package name */
    private ObjectAnimator f14021l;

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14010a = 0;
        this.f14011b = 0;
        this.f14013d = getResources().getDimensionPixelOffset(H1.f.f2122R);
        this.f14014e = -16777216;
        this.f14015f = -1;
        this.f14016g = new Rect();
        this.f14017h = null;
        f(context, attributeSet);
    }

    private void a(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            int i5 = this.f14015f;
            int i6 = this.f14010a;
            c(canvas, i5, i6, (int) (i6 + (this.f14020k * this.f14019j)));
        } else {
            int i7 = this.f14015f;
            int i8 = this.f14010a;
            int i9 = this.f14019j;
            c(canvas, i7, i8 + i9, (int) ((i8 + i9) - (this.f14020k * i9)));
        }
    }

    private void b(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            c(canvas, this.f14014e, (int) ((r1 + r2) - (this.f14020k * this.f14019j)), this.f14010a);
            return;
        }
        int i5 = this.f14014e;
        int i6 = this.f14010a;
        float f5 = this.f14020k;
        int i7 = this.f14019j;
        c(canvas, i5, (int) (i6 + (f5 * i7)), i6 + i7);
    }

    private void c(Canvas canvas, int i5, int i6, int i7) {
        this.f14012c.setColor(i5);
        canvas.save();
        canvas.clipRect(i6, 0, i7, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.f14012c.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i8 = fontMetricsInt.top;
        canvas.drawText(this.f14017h, this.f14011b, ((measuredHeight + i8) / 2) - i8, this.f14012c);
        canvas.restore();
    }

    private ObjectAnimator d(float f5) {
        float f6 = this.f14020k;
        return f5 < f6 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f5).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f6, f5).setDuration(500L);
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.f14012c = new Paint(1);
        this.f14012c.setTypeface(Typeface.create("sans-serif-medium", 0));
        g(context, attributeSet);
    }

    private void g(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayE = e(context, attributeSet, H1.m.f2519W1);
        if (typedArrayE == null) {
            return;
        }
        this.f14017h = typedArrayE.getString(H1.m.f2531Y1);
        this.f14013d = typedArrayE.getDimensionPixelSize(H1.m.f2525X1, this.f14013d);
        this.f14014e = typedArrayE.getColor(H1.m.f2544a2, this.f14014e);
        this.f14015f = typedArrayE.getColor(H1.m.f2537Z1, this.f14015f);
        this.f14020k = typedArrayE.getFloat(H1.m.f2551b2, 0.0f);
        typedArrayE.recycle();
    }

    private int h(int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int iHeight = (mode == Integer.MIN_VALUE || mode == 0) ? this.f14016g.height() * 2 : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iHeight = Math.min(iHeight, size);
        }
        return iHeight + getPaddingTop() + getPaddingBottom();
    }

    private void i() {
        this.f14018i = (int) this.f14012c.measureText(this.f14017h);
        Paint paint = this.f14012c;
        String str = this.f14017h;
        paint.getTextBounds(str, 0, str.length(), this.f14016g);
    }

    private int j(int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int iMin = (mode == Integer.MIN_VALUE || mode == 0) ? this.f14018i : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, size);
        }
        return iMin + getPaddingLeft() + getPaddingRight();
    }

    protected TypedArray e(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public float getProgress() {
        return this.f14020k;
    }

    public String getText() {
        return this.f14017h;
    }

    public int getTextChangeColor() {
        return this.f14015f;
    }

    public int getTextOriginColor() {
        return this.f14014e;
    }

    public int getTextSize() {
        return this.f14013d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        i();
        this.f14012c.setTextSize(this.f14013d);
        setMeasuredDimension(j(i5), h(i6));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f14019j = measuredWidth;
        this.f14011b = (measuredWidth / 2) - (this.f14018i / 2);
        invalidate();
    }

    public synchronized void setAnimProgress(float f5) {
        ObjectAnimator objectAnimatorD = d(f5);
        this.f14021l = objectAnimatorD;
        objectAnimatorD.start();
    }

    public void setProgress(float f5) {
        this.f14020k = f5;
        invalidate();
    }

    public void setText(String str) {
        this.f14017h = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i5) {
        this.f14015f = i5;
        invalidate();
    }

    public void setTextOriginColor(int i5) {
        this.f14014e = i5;
        invalidate();
    }

    public void setTextSize(int i5) {
        this.f14013d = i5;
        requestLayout();
        invalidate();
    }
}
