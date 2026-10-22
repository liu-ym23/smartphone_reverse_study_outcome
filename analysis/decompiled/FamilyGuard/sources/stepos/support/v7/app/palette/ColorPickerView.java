package stepos.support.v7.app.palette;

import N1.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import stepos.support.v7.app.palette.StepOSPalettePopupActivity;

/* loaded from: classes.dex */
class ColorPickerView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    boolean f20915a;

    /* renamed from: b, reason: collision with root package name */
    private int f20916b;

    /* renamed from: c, reason: collision with root package name */
    private int f20917c;

    /* renamed from: d, reason: collision with root package name */
    private float f20918d;

    /* renamed from: e, reason: collision with root package name */
    private float f20919e;

    /* renamed from: f, reason: collision with root package name */
    private int f20920f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f20921g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f20922h;

    /* renamed from: i, reason: collision with root package name */
    private int f20923i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f20924j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f20925k;

    /* renamed from: l, reason: collision with root package name */
    private int f20926l;

    /* renamed from: m, reason: collision with root package name */
    private int f20927m;

    /* renamed from: n, reason: collision with root package name */
    private float f20928n;

    /* renamed from: o, reason: collision with root package name */
    private float f20929o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f20930p;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20915a = false;
        this.f20927m = -1;
        s();
    }

    public static /* synthetic */ void d(ColorPickerView colorPickerView, final int i5) {
        float fM = colorPickerView.m(i5);
        if (fM >= 0.0f) {
            double d6 = fM;
            colorPickerView.f20918d = (float) (colorPickerView.f20916b + (colorPickerView.f20920f * Math.cos(Math.toRadians(d6))));
            colorPickerView.f20919e = (float) (colorPickerView.f20917c + (colorPickerView.f20920f * Math.sin(Math.toRadians(d6))));
        }
        colorPickerView.f20927m = colorPickerView.p(i5);
        colorPickerView.f20925k.setColor(i5);
        colorPickerView.f20928n = colorPickerView.r(i5);
        colorPickerView.f20929o = colorPickerView.q(i5);
        colorPickerView.invalidate();
        colorPickerView.post(new Runnable() { // from class: stepos.support.v7.app.palette.g
            @Override // java.lang.Runnable
            public final void run() {
                b.b().c(i5);
            }
        });
    }

    public static /* synthetic */ void f(ColorPickerView colorPickerView) {
        colorPickerView.getClass();
        b.b().c(colorPickerView.f20927m);
    }

    private int g(int i5, float f5) {
        float[] fArr = {0.0f, this.f20928n, f5};
        Color.colorToHSV(i5, fArr);
        return Color.HSVToColor(fArr);
    }

    private int h(int i5, float f5) {
        float[] fArr = {0.0f, f5, this.f20929o};
        Color.colorToHSV(i5, fArr);
        return Color.HSVToColor(fArr);
    }

    private PointF i(double d6) {
        float fAbs = Math.abs(this.f20919e - this.f20917c);
        double d7 = fAbs / d6;
        double d8 = this.f20920f - d6;
        double dAbs = (Math.abs(this.f20918d - this.f20916b) / d6) * d8;
        double d9 = d8 * d7;
        float f5 = this.f20919e;
        int i5 = this.f20917c;
        int i6 = f5 < ((float) i5) ? -1 : f5 > ((float) i5) ? 1 : 0;
        float f6 = this.f20918d;
        int i7 = this.f20916b;
        this.f20918d = (float) (f6 + (dAbs * (f6 <= ((float) i7) ? f6 < ((float) i7) ? -1 : 0 : 1)));
        this.f20919e = (float) (f5 + (d9 * i6));
        return new PointF(this.f20918d, this.f20919e);
    }

    private void j(Canvas canvas) {
        canvas.drawCircle(this.f20916b, this.f20917c, this.f20926l, this.f20925k);
    }

    private void k(Canvas canvas) {
        canvas.drawCircle(this.f20916b, this.f20917c, this.f20920f, this.f20921g);
    }

    private void l(Canvas canvas) {
        canvas.drawCircle(this.f20918d, this.f20919e, this.f20923i, this.f20922h);
    }

    private float m(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        return fArr[0];
    }

    private int n(float f5) {
        return Color.HSVToColor(new float[]{((f5 % 360.0f) + 360.0f) % 360.0f, 1.0f, 1.0f});
    }

    private int p(int i5) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i5, fArr);
        return Color.HSVToColor(fArr);
    }

    private float q(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        return fArr[2];
    }

    private float r(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        return fArr[1];
    }

    private void s() {
        int iA = (int) i.a(40.0f, getContext());
        Paint paint = new Paint(1);
        this.f20921g = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f20921g.setStrokeWidth(iA);
        Paint paint2 = new Paint(1);
        this.f20922h = paint2;
        paint2.setStyle(style);
        this.f20922h.setStrokeWidth((int) i.a(4.0f, getContext()));
        this.f20922h.setColor(-1);
        this.f20923i = (int) i.a(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.f20930p = paint3;
        paint3.setStyle(style);
        this.f20930p.setStrokeWidth(i.a(1.0f, getContext()));
        this.f20930p.setColor(androidx.core.content.a.c(getContext(), H1.e.f2083e));
        this.f20924j = new int[361];
        for (int i5 = 0; i5 < 361; i5++) {
            this.f20924j[i5] = Color.HSVToColor(new float[]{i5, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.f20925k = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f20926l = (int) i.a(45.0f, getContext());
        b.b().a(this);
        this.f20928n = 1.0f;
        this.f20929o = 1.0f;
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(float f5) {
        this.f20929o = f5;
        this.f20925k.setColor(g(this.f20927m, f5));
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(int i5) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f5) {
        this.f20928n = f5;
        this.f20925k.setColor(h(this.f20927m, f5));
        invalidate();
    }

    public int o(float f5, float f6) {
        float degrees = (float) Math.toDegrees(Math.atan2(f6 - (getHeight() / 2), f5 - (getWidth() / 2)));
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        return Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas);
        l(canvas);
        j(canvas);
        canvas.drawCircle(this.f20916b, this.f20917c, this.f20926l, this.f20930p);
        this.f20925k.getColor();
        throw null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f20916b = i5 / 2;
        this.f20917c = i6 / 2;
        this.f20920f = (int) (Math.min(r5, r6) - (this.f20921g.getStrokeWidth() / 2.0f));
        this.f20921g.setShader(new SweepGradient(this.f20916b, this.f20917c, this.f20924j, (float[]) null));
        if (this.f20927m == -1) {
            int iN = n(90.0f);
            this.f20927m = iN;
            this.f20925k.setColor(iN);
            this.f20918d = (float) (this.f20916b + (this.f20920f * Math.cos(Math.toRadians(90.0d))));
            this.f20919e = (float) (this.f20917c + (this.f20920f * Math.sin(Math.toRadians(90.0d))));
            post(new Runnable() { // from class: stepos.support.v7.app.palette.e
                @Override // java.lang.Runnable
                public final void run() {
                    ColorPickerView.f(this.f20969a);
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20918d = motionEvent.getX();
            this.f20919e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.f20918d - this.f20916b), 2.0d) + Math.pow(Math.abs(this.f20919e - this.f20917c), 2.0d));
            boolean z5 = dSqrt >= ((double) (((float) this.f20916b) - this.f20921g.getStrokeWidth())) && dSqrt <= ((double) this.f20916b);
            this.f20915a = z5;
            if (z5) {
                i(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.f20918d = motionEvent.getX();
            this.f20919e = motionEvent.getY();
            if (this.f20915a) {
                PointF pointFI = i(Math.sqrt(Math.pow(Math.abs(this.f20918d - this.f20916b), 2.0d) + Math.pow(Math.abs(this.f20919e - this.f20917c), 2.0d)));
                int iO = o(pointFI.x, pointFI.y);
                this.f20927m = iO;
                int iG = g(h(iO, this.f20928n), this.f20929o);
                this.f20925k.setColor(iG);
                b.b().c(iG);
                invalidate();
            }
        }
        return true;
    }

    public void t(StepOSPalettePopupActivity.a aVar) {
    }

    public void u(final int i5) {
        post(new Runnable() { // from class: stepos.support.v7.app.palette.f
            @Override // java.lang.Runnable
            public final void run() {
                ColorPickerView.d(this.f20970a, i5);
            }
        });
    }
}
