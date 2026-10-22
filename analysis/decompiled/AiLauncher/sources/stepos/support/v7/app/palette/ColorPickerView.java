package stepos.support.v7.app.palette;

import O6.s;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.common.R$color;
import stepos.support.v7.app.palette.StepOSPalettePopupActivity;

/* loaded from: classes5.dex */
class ColorPickerView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f40651a;

    /* renamed from: b, reason: collision with root package name */
    public int f40652b;

    /* renamed from: c, reason: collision with root package name */
    public int f40653c;

    /* renamed from: d, reason: collision with root package name */
    public float f40654d;

    /* renamed from: e, reason: collision with root package name */
    public float f40655e;

    /* renamed from: f, reason: collision with root package name */
    public int f40656f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f40657g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f40658h;

    /* renamed from: i, reason: collision with root package name */
    public int f40659i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f40660j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f40661k;

    /* renamed from: l, reason: collision with root package name */
    public int f40662l;

    /* renamed from: m, reason: collision with root package name */
    public int f40663m;

    /* renamed from: n, reason: collision with root package name */
    public float f40664n;

    /* renamed from: o, reason: collision with root package name */
    public float f40665o;

    /* renamed from: p, reason: collision with root package name */
    public Paint f40666p;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40651a = false;
        this.f40663m = -1;
        s();
    }

    public static /* synthetic */ void d(ColorPickerView colorPickerView, final int i10) {
        float fM = colorPickerView.m(i10);
        if (fM >= 0.0f) {
            double d10 = fM;
            colorPickerView.f40654d = (float) (colorPickerView.f40652b + (colorPickerView.f40656f * Math.cos(Math.toRadians(d10))));
            colorPickerView.f40655e = (float) (colorPickerView.f40653c + (colorPickerView.f40656f * Math.sin(Math.toRadians(d10))));
        }
        colorPickerView.f40663m = colorPickerView.p(i10);
        colorPickerView.f40661k.setColor(i10);
        colorPickerView.f40664n = colorPickerView.r(i10);
        colorPickerView.f40665o = colorPickerView.q(i10);
        colorPickerView.invalidate();
        colorPickerView.post(new Runnable() { // from class: stepos.support.v7.app.palette.g
            @Override // java.lang.Runnable
            public final void run() {
                b.b().c(i10);
            }
        });
    }

    public static /* synthetic */ void f(ColorPickerView colorPickerView) {
        colorPickerView.getClass();
        b.b().c(colorPickerView.f40663m);
    }

    private float q(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        return fArr[2];
    }

    @SuppressLint({"NewApi"})
    private void s() {
        int iA = (int) s.a(40.0f, getContext());
        Paint paint = new Paint(1);
        this.f40657g = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f40657g.setStrokeWidth(iA);
        Paint paint2 = new Paint(1);
        this.f40658h = paint2;
        paint2.setStyle(style);
        this.f40658h.setStrokeWidth((int) s.a(4.0f, getContext()));
        this.f40658h.setColor(-1);
        this.f40659i = (int) s.a(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.f40666p = paint3;
        paint3.setStyle(style);
        this.f40666p.setStrokeWidth(s.a(1.0f, getContext()));
        this.f40666p.setColor(androidx.core.content.a.c(getContext(), R$color.fd_sys_color_outline_variant_default));
        this.f40660j = new int[361];
        for (int i10 = 0; i10 < 361; i10++) {
            this.f40660j[i10] = Color.HSVToColor(new float[]{i10, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.f40661k = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f40662l = (int) s.a(45.0f, getContext());
        b.b().a(this);
        this.f40664n = 1.0f;
        this.f40665o = 1.0f;
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(int i10) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(float f10) {
        this.f40665o = f10;
        this.f40661k.setColor(g(this.f40663m, f10));
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f10) {
        this.f40664n = f10;
        this.f40661k.setColor(h(this.f40663m, f10));
        invalidate();
    }

    public final int g(int i10, float f10) {
        float[] fArr = {0.0f, this.f40664n, f10};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    public final int h(int i10, float f10) {
        float[] fArr = {0.0f, f10, this.f40665o};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    public final PointF i(double d10) {
        float fAbs = Math.abs(this.f40655e - this.f40653c);
        double d11 = fAbs / d10;
        double d12 = this.f40656f - d10;
        double dAbs = (Math.abs(this.f40654d - this.f40652b) / d10) * d12;
        double d13 = d12 * d11;
        float f10 = this.f40655e;
        int i10 = this.f40653c;
        int i11 = f10 < ((float) i10) ? -1 : f10 > ((float) i10) ? 1 : 0;
        float f11 = this.f40654d;
        int i12 = this.f40652b;
        this.f40654d = (float) (f11 + (dAbs * (f11 <= ((float) i12) ? f11 < ((float) i12) ? -1 : 0 : 1)));
        this.f40655e = (float) (f10 + (d13 * i11));
        return new PointF(this.f40654d, this.f40655e);
    }

    public final void j(Canvas canvas) {
        canvas.drawCircle(this.f40652b, this.f40653c, this.f40662l, this.f40661k);
    }

    public final void k(Canvas canvas) {
        canvas.drawCircle(this.f40652b, this.f40653c, this.f40656f, this.f40657g);
    }

    public final void l(Canvas canvas) {
        canvas.drawCircle(this.f40654d, this.f40655e, this.f40659i, this.f40658h);
    }

    public final float m(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        return fArr[0];
    }

    public final int n(float f10) {
        return Color.HSVToColor(new float[]{((f10 % 360.0f) + 360.0f) % 360.0f, 1.0f, 1.0f});
    }

    public int o(float f10, float f11) {
        float degrees = (float) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)));
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        return Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas);
        l(canvas);
        j(canvas);
        canvas.drawCircle(this.f40652b, this.f40653c, this.f40662l, this.f40666p);
        this.f40661k.getColor();
        throw null;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f40652b = i10 / 2;
        this.f40653c = i11 / 2;
        this.f40656f = (int) (Math.min(r5, r6) - (this.f40657g.getStrokeWidth() / 2.0f));
        this.f40657g.setShader(new SweepGradient(this.f40652b, this.f40653c, this.f40660j, (float[]) null));
        if (this.f40663m == -1) {
            int iN = n(90.0f);
            this.f40663m = iN;
            this.f40661k.setColor(iN);
            this.f40654d = (float) (this.f40652b + (this.f40656f * Math.cos(Math.toRadians(90.0d))));
            this.f40655e = (float) (this.f40653c + (this.f40656f * Math.sin(Math.toRadians(90.0d))));
            post(new Runnable() { // from class: stepos.support.v7.app.palette.e
                @Override // java.lang.Runnable
                public final void run() {
                    ColorPickerView.f(this.f40705a);
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40654d = motionEvent.getX();
            this.f40655e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.f40654d - this.f40652b), 2.0d) + Math.pow(Math.abs(this.f40655e - this.f40653c), 2.0d));
            boolean z10 = dSqrt >= ((double) (((float) this.f40652b) - this.f40657g.getStrokeWidth())) && dSqrt <= ((double) this.f40652b);
            this.f40651a = z10;
            if (z10) {
                i(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.f40654d = motionEvent.getX();
            this.f40655e = motionEvent.getY();
            if (this.f40651a) {
                PointF pointFI = i(Math.sqrt(Math.pow(Math.abs(this.f40654d - this.f40652b), 2.0d) + Math.pow(Math.abs(this.f40655e - this.f40653c), 2.0d)));
                int iO = o(pointFI.x, pointFI.y);
                this.f40663m = iO;
                int iG = g(h(iO, this.f40664n), this.f40665o);
                this.f40661k.setColor(iG);
                b.b().c(iG);
                invalidate();
            }
        }
        return true;
    }

    public final int p(int i10) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    public final float r(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        return fArr[1];
    }

    public void t(StepOSPalettePopupActivity.a aVar) {
    }

    public void u(final int i10) {
        post(new Runnable() { // from class: stepos.support.v7.app.palette.f
            @Override // java.lang.Runnable
            public final void run() {
                ColorPickerView.d(this.f40706a, i10);
            }
        });
    }
}
