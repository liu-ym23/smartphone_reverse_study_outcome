package stepos.support.v7.app.palette;

import a5.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
class ColorPickerView extends View implements a {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f6323q = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6324a;
    public int b;
    public int c;
    public float d;
    public float e;
    public int f;
    public final Paint g;
    public final Paint h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f6325j;
    public final Paint k;
    public final int l;
    public int m;
    public float n;
    public float o;
    public final Paint p;

    public ColorPickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6324a = false;
        this.m = -1;
        int iC = (int) l.c(40.0f, getContext());
        Paint paint = new Paint(1);
        this.g = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.g.setStrokeWidth(iC);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setStyle(style);
        this.h.setStrokeWidth((int) l.c(4.0f, getContext()));
        this.h.setColor(-1);
        this.i = (int) l.c(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.p = paint3;
        paint3.setStyle(style);
        this.p.setStrokeWidth(l.c(1.0f, getContext()));
        this.p.setColor(ContextCompat.getColor(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.f6325j = new int[361];
        for (int i = 0; i < 361; i++) {
            this.f6325j[i] = Color.HSVToColor(new float[]{i, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.k = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.l = (int) l.c(45.0f, getContext());
        b.c().f6328a.add(this);
        this.n = 1.0f;
        this.o = 1.0f;
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f) {
        this.o = f;
        float[] fArr = {0.0f, this.n, f};
        Color.colorToHSV(this.m, fArr);
        this.k.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f) {
        this.n = f;
        float[] fArr = {0.0f, f, this.o};
        Color.colorToHSV(this.m, fArr);
        this.k.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    public final PointF d(double d) {
        float fAbs = Math.abs(this.e - this.c);
        double d6 = fAbs / d;
        double d10 = this.f - d;
        double dAbs = (Math.abs(this.d - this.b) / d) * d10;
        double d11 = d10 * d6;
        float f = this.e;
        int i = this.c;
        int i6 = f < ((float) i) ? -1 : f > ((float) i) ? 1 : 0;
        float f7 = this.d;
        int i10 = this.b;
        this.d = (float) ((dAbs * (f7 <= ((float) i10) ? f7 < ((float) i10) ? -1 : 0 : 1)) + f7);
        this.e = (float) ((d11 * i6) + f);
        return new PointF(this.d, this.e);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.b, this.c, this.f, this.g);
        canvas.drawCircle(this.d, this.e, this.i, this.h);
        canvas.drawCircle(this.b, this.c, this.l, this.k);
        canvas.drawCircle(this.b, this.c, this.l, this.p);
        this.k.getColor();
        throw null;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        int i12 = i / 2;
        this.b = i12;
        int i13 = i6 / 2;
        this.c = i13;
        float fMin = Math.min(i12, i13);
        Paint paint = this.g;
        this.f = (int) (fMin - (paint.getStrokeWidth() / 2.0f));
        paint.setShader(new SweepGradient(this.b, this.c, this.f6325j, (float[]) null));
        if (this.m == -1) {
            int iHSVToColor = Color.HSVToColor(new float[]{90.0f, 1.0f, 1.0f});
            this.m = iHSVToColor;
            this.k.setColor(iHSVToColor);
            this.d = (float) ((Math.cos(Math.toRadians(90.0d)) * this.f) + this.b);
            this.e = (float) ((Math.sin(Math.toRadians(90.0d)) * this.f) + this.c);
            post(new Runnable() { // from class: stepos.support.v7.app.palette.c
                @Override // java.lang.Runnable
                public final void run() {
                    int i14 = ColorPickerView.f6323q;
                    ColorPickerView colorPickerView = this.f6329a;
                    colorPickerView.getClass();
                    b.c().d(colorPickerView.m);
                }
            });
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.e - this.c), 2.0d) + Math.pow(Math.abs(this.d - this.b), 2.0d));
            if (dSqrt >= this.b - this.g.getStrokeWidth() && dSqrt <= this.b) {
                z10 = true;
            }
            this.f6324a = z10;
            if (z10) {
                d(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
            if (this.f6324a) {
                PointF pointFD = d(Math.sqrt(Math.pow(Math.abs(this.e - this.c), 2.0d) + Math.pow(Math.abs(this.d - this.b), 2.0d)));
                float degrees = (float) Math.toDegrees(Math.atan2(pointFD.y - (getHeight() / 2), pointFD.x - (getWidth() / 2)));
                if (degrees < 0.0f) {
                    degrees += 360.0f;
                }
                int iHSVToColor = Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
                this.m = iHSVToColor;
                float[] fArr = {0.0f, this.n, this.o};
                Color.colorToHSV(iHSVToColor, fArr);
                int iHSVToColor2 = Color.HSVToColor(fArr);
                float[] fArr2 = {0.0f, this.n, this.o};
                Color.colorToHSV(iHSVToColor2, fArr2);
                int iHSVToColor3 = Color.HSVToColor(fArr2);
                this.k.setColor(iHSVToColor3);
                b.c().d(iHSVToColor3);
                invalidate();
                return true;
            }
        }
        return true;
    }
}
