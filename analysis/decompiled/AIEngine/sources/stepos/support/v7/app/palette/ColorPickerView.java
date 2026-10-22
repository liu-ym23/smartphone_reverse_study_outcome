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
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ColorPickerView extends View implements a {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f12223t = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12224a;

    /* renamed from: b, reason: collision with root package name */
    public int f12225b;

    /* renamed from: c, reason: collision with root package name */
    public int f12226c;

    /* renamed from: d, reason: collision with root package name */
    public float f12227d;

    /* renamed from: e, reason: collision with root package name */
    public float f12228e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f12229j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f12230k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12231l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f12232m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f12233n;

    /* renamed from: o, reason: collision with root package name */
    public final int f12234o;

    /* renamed from: p, reason: collision with root package name */
    public int f12235p;

    /* renamed from: q, reason: collision with root package name */
    public float f12236q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f12237s;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12224a = false;
        this.f12235p = -1;
        int iA = (int) l8.f.a(40.0f, getContext());
        Paint paint = new Paint(1);
        this.f12229j = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f12229j.setStrokeWidth(iA);
        Paint paint2 = new Paint(1);
        this.f12230k = paint2;
        paint2.setStyle(style);
        this.f12230k.setStrokeWidth((int) l8.f.a(4.0f, getContext()));
        this.f12230k.setColor(-1);
        this.f12231l = (int) l8.f.a(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.f12237s = paint3;
        paint3.setStyle(style);
        this.f12237s.setStrokeWidth(l8.f.a(1.0f, getContext()));
        this.f12237s.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.f12232m = new int[361];
        for (int i10 = 0; i10 < 361; i10++) {
            this.f12232m[i10] = Color.HSVToColor(new float[]{i10, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.f12233n = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f12234o = (int) l8.f.a(45.0f, getContext());
        ((ArrayList) b.h().h).add(this);
        this.f12236q = 1.0f;
        this.r = 1.0f;
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f8) {
        this.r = f8;
        float[] fArr = {0.0f, this.f12236q, f8};
        Color.colorToHSV(this.f12235p, fArr);
        this.f12233n.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f8) {
        this.f12236q = f8;
        float[] fArr = {0.0f, f8, this.r};
        Color.colorToHSV(this.f12235p, fArr);
        this.f12233n.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    public final PointF d(double d8) {
        float fAbs = Math.abs(this.f12228e - this.f12226c);
        double d10 = fAbs / d8;
        double d11 = this.h - d8;
        double dAbs = (Math.abs(this.f12227d - this.f12225b) / d8) * d11;
        double d12 = d11 * d10;
        float f8 = this.f12228e;
        int i10 = this.f12226c;
        int i11 = f8 < ((float) i10) ? -1 : f8 > ((float) i10) ? 1 : 0;
        float f9 = this.f12227d;
        int i12 = this.f12225b;
        this.f12227d = (float) ((dAbs * (f9 <= ((float) i12) ? f9 < ((float) i12) ? -1 : 0 : 1)) + f9);
        this.f12228e = (float) ((d12 * i11) + f8);
        return new PointF(this.f12227d, this.f12228e);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f12225b, this.f12226c, this.h, this.f12229j);
        canvas.drawCircle(this.f12227d, this.f12228e, this.f12231l, this.f12230k);
        canvas.drawCircle(this.f12225b, this.f12226c, this.f12234o, this.f12233n);
        canvas.drawCircle(this.f12225b, this.f12226c, this.f12234o, this.f12237s);
        this.f12233n.getColor();
        throw null;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = i10 / 2;
        this.f12225b = i14;
        int i15 = i11 / 2;
        this.f12226c = i15;
        float fMin = Math.min(i14, i15);
        Paint paint = this.f12229j;
        this.h = (int) (fMin - (paint.getStrokeWidth() / 2.0f));
        paint.setShader(new SweepGradient(this.f12225b, this.f12226c, this.f12232m, (float[]) null));
        if (this.f12235p == -1) {
            int iHSVToColor = Color.HSVToColor(new float[]{90.0f, 1.0f, 1.0f});
            this.f12235p = iHSVToColor;
            this.f12233n.setColor(iHSVToColor);
            this.f12227d = (float) ((Math.cos(Math.toRadians(90.0d)) * this.h) + this.f12225b);
            this.f12228e = (float) ((Math.sin(Math.toRadians(90.0d)) * this.h) + this.f12226c);
            post(new Runnable() { // from class: stepos.support.v7.app.palette.d
                @Override // java.lang.Runnable
                public final void run() {
                    int i16 = ColorPickerView.f12223t;
                    ColorPickerView colorPickerView = this.f12252a;
                    colorPickerView.getClass();
                    b.h().k(colorPickerView.f12235p);
                }
            });
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f12227d = motionEvent.getX();
            this.f12228e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.f12228e - this.f12226c), 2.0d) + Math.pow(Math.abs(this.f12227d - this.f12225b), 2.0d));
            if (dSqrt >= this.f12225b - this.f12229j.getStrokeWidth() && dSqrt <= this.f12225b) {
                z = true;
            }
            this.f12224a = z;
            if (z) {
                d(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.f12227d = motionEvent.getX();
            this.f12228e = motionEvent.getY();
            if (this.f12224a) {
                PointF pointFD = d(Math.sqrt(Math.pow(Math.abs(this.f12228e - this.f12226c), 2.0d) + Math.pow(Math.abs(this.f12227d - this.f12225b), 2.0d)));
                float degrees = (float) Math.toDegrees(Math.atan2(pointFD.y - (getHeight() / 2), pointFD.x - (getWidth() / 2)));
                if (degrees < 0.0f) {
                    degrees += 360.0f;
                }
                int iHSVToColor = Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
                this.f12235p = iHSVToColor;
                float[] fArr = {0.0f, this.f12236q, this.r};
                Color.colorToHSV(iHSVToColor, fArr);
                int iHSVToColor2 = Color.HSVToColor(fArr);
                float[] fArr2 = {0.0f, this.f12236q, this.r};
                Color.colorToHSV(iHSVToColor2, fArr2);
                int iHSVToColor3 = Color.HSVToColor(fArr2);
                this.f12233n.setColor(iHSVToColor3);
                b.h().k(iHSVToColor3);
                invalidate();
                return true;
            }
        }
        return true;
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i10) {
    }
}
