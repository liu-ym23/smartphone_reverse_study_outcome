package stepos.support.v7.app.palette;

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
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import m2.o;

/* loaded from: classes2.dex */
class ColorPickerView extends View implements a {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f14547q = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f14548a;

    /* renamed from: b, reason: collision with root package name */
    public int f14549b;

    /* renamed from: c, reason: collision with root package name */
    public int f14550c;

    /* renamed from: d, reason: collision with root package name */
    public float f14551d;

    /* renamed from: e, reason: collision with root package name */
    public float f14552e;

    /* renamed from: f, reason: collision with root package name */
    public int f14553f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f14554g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f14555h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14556i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f14557j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f14558k;

    /* renamed from: l, reason: collision with root package name */
    public final int f14559l;

    /* renamed from: m, reason: collision with root package name */
    public int f14560m;

    /* renamed from: n, reason: collision with root package name */
    public float f14561n;

    /* renamed from: o, reason: collision with root package name */
    public float f14562o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f14563p;

    public ColorPickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14548a = false;
        this.f14560m = -1;
        int iC = (int) o.c(getContext(), 40.0f);
        Paint paint = new Paint(1);
        this.f14554g = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f14554g.setStrokeWidth(iC);
        Paint paint2 = new Paint(1);
        this.f14555h = paint2;
        paint2.setStyle(style);
        this.f14555h.setStrokeWidth((int) o.c(getContext(), 4.0f));
        this.f14555h.setColor(-1);
        this.f14556i = (int) o.c(getContext(), 14.0f);
        Paint paint3 = new Paint(1);
        this.f14563p = paint3;
        paint3.setStyle(style);
        this.f14563p.setStrokeWidth(o.c(getContext(), 1.0f));
        this.f14563p.setColor(androidx.core.content.b.a(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.f14557j = new int[361];
        for (int i4 = 0; i4 < 361; i4++) {
            this.f14557j[i4] = Color.HSVToColor(new float[]{i4, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.f14558k = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f14559l = (int) o.c(getContext(), 45.0f);
        b.d().f14577a.add(this);
        this.f14561n = 1.0f;
        this.f14562o = 1.0f;
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i4) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f4) {
        this.f14561n = f4;
        float[] fArr = {0.0f, f4, this.f14562o};
        Color.colorToHSV(this.f14560m, fArr);
        this.f14558k.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f4) {
        this.f14562o = f4;
        float[] fArr = {0.0f, this.f14561n, f4};
        Color.colorToHSV(this.f14560m, fArr);
        this.f14558k.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    public final PointF d(double d4) {
        float fAbs = Math.abs(this.f14552e - this.f14550c);
        double d5 = fAbs / d4;
        double d6 = this.f14553f - d4;
        double dAbs = (Math.abs(this.f14551d - this.f14549b) / d4) * d6;
        double d7 = d6 * d5;
        float f4 = this.f14552e;
        int i4 = this.f14550c;
        int i5 = f4 < ((float) i4) ? -1 : f4 > ((float) i4) ? 1 : 0;
        float f5 = this.f14551d;
        int i6 = this.f14549b;
        this.f14551d = (float) ((dAbs * (f5 <= ((float) i6) ? f5 < ((float) i6) ? -1 : 0 : 1)) + f5);
        this.f14552e = (float) ((d7 * i5) + f4);
        return new PointF(this.f14551d, this.f14552e);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f14549b, this.f14550c, this.f14553f, this.f14554g);
        canvas.drawCircle(this.f14551d, this.f14552e, this.f14556i, this.f14555h);
        canvas.drawCircle(this.f14549b, this.f14550c, this.f14559l, this.f14558k);
        canvas.drawCircle(this.f14549b, this.f14550c, this.f14559l, this.f14563p);
        this.f14558k.getColor();
        throw null;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        int i8 = i4 / 2;
        this.f14549b = i8;
        int i9 = i5 / 2;
        this.f14550c = i9;
        float fMin = Math.min(i8, i9);
        Paint paint = this.f14554g;
        this.f14553f = (int) (fMin - (paint.getStrokeWidth() / 2.0f));
        paint.setShader(new SweepGradient(this.f14549b, this.f14550c, this.f14557j, (float[]) null));
        if (this.f14560m == -1) {
            int iHSVToColor = Color.HSVToColor(new float[]{90.0f, 1.0f, 1.0f});
            this.f14560m = iHSVToColor;
            this.f14558k.setColor(iHSVToColor);
            this.f14551d = (float) ((Math.cos(Math.toRadians(90.0d)) * this.f14553f) + this.f14549b);
            this.f14552e = (float) ((Math.sin(Math.toRadians(90.0d)) * this.f14553f) + this.f14550c);
            post(new Runnable() { // from class: stepos.support.v7.app.palette.c
                @Override // java.lang.Runnable
                public final void run() {
                    int i10 = ColorPickerView.f14547q;
                    ColorPickerView colorPickerView = this.f14578a;
                    colorPickerView.getClass();
                    b.d().e(colorPickerView.f14560m);
                }
            });
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4 = false;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14551d = motionEvent.getX();
            this.f14552e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.f14552e - this.f14550c), 2.0d) + Math.pow(Math.abs(this.f14551d - this.f14549b), 2.0d));
            if (dSqrt >= this.f14549b - this.f14554g.getStrokeWidth() && dSqrt <= this.f14549b) {
                z4 = true;
            }
            this.f14548a = z4;
            if (z4) {
                d(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.f14551d = motionEvent.getX();
            this.f14552e = motionEvent.getY();
            if (this.f14548a) {
                PointF pointFD = d(Math.sqrt(Math.pow(Math.abs(this.f14552e - this.f14550c), 2.0d) + Math.pow(Math.abs(this.f14551d - this.f14549b), 2.0d)));
                float degrees = (float) Math.toDegrees(Math.atan2(pointFD.y - (getHeight() / 2), pointFD.x - (getWidth() / 2)));
                if (degrees < Property.DEFAULT_FLOAT_VALUE) {
                    degrees += 360.0f;
                }
                int iHSVToColor = Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
                this.f14560m = iHSVToColor;
                float[] fArr = {0.0f, this.f14561n, this.f14562o};
                Color.colorToHSV(iHSVToColor, fArr);
                int iHSVToColor2 = Color.HSVToColor(fArr);
                float[] fArr2 = {0.0f, this.f14561n, this.f14562o};
                Color.colorToHSV(iHSVToColor2, fArr2);
                int iHSVToColor3 = Color.HSVToColor(fArr2);
                this.f14558k.setColor(iHSVToColor3);
                b.d().e(iHSVToColor3);
                invalidate();
            }
        }
        return true;
    }
}
