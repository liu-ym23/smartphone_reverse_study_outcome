package stepos.support.v7.app.palette;

import a4.t;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import ne.a;
import ne.b;
import t1.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ColorPickerView extends View implements a {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f12424u = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12425c;

    /* renamed from: f, reason: collision with root package name */
    public int f12426f;

    /* renamed from: g, reason: collision with root package name */
    public int f12427g;

    /* renamed from: h, reason: collision with root package name */
    public float f12428h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public int f12429j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f12430k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f12431l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12432m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f12433n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f12434o;

    /* renamed from: p, reason: collision with root package name */
    public final int f12435p;

    /* renamed from: q, reason: collision with root package name */
    public int f12436q;

    /* renamed from: r, reason: collision with root package name */
    public float f12437r;

    /* renamed from: s, reason: collision with root package name */
    public float f12438s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f12439t;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12425c = false;
        this.f12436q = -1;
        int iE = (int) e.e(40.0f, getContext());
        Paint paint = new Paint(1);
        this.f12430k = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f12430k.setStrokeWidth(iE);
        Paint paint2 = new Paint(1);
        this.f12431l = paint2;
        paint2.setStyle(style);
        this.f12431l.setStrokeWidth((int) e.e(4.0f, getContext()));
        this.f12431l.setColor(-1);
        this.f12432m = (int) e.e(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.f12439t = paint3;
        paint3.setStyle(style);
        this.f12439t.setStrokeWidth(e.e(1.0f, getContext()));
        this.f12439t.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.f12433n = new int[361];
        for (int i = 0; i < 361; i++) {
            this.f12433n[i] = Color.HSVToColor(new float[]{i, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.f12434o = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f12435p = (int) e.e(45.0f, getContext());
        b.e().f8958c.add(this);
        this.f12437r = 1.0f;
        this.f12438s = 1.0f;
    }

    @Override // ne.a
    public final void a(float f5) {
        this.f12438s = f5;
        float[] fArr = {0.0f, this.f12437r, f5};
        Color.colorToHSV(this.f12436q, fArr);
        this.f12434o.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    @Override // ne.a
    public final void c(float f5) {
        this.f12437r = f5;
        float[] fArr = {0.0f, f5, this.f12438s};
        Color.colorToHSV(this.f12436q, fArr);
        this.f12434o.setColor(Color.HSVToColor(fArr));
        invalidate();
    }

    public final PointF d(double d7) {
        float fAbs = Math.abs(this.i - this.f12427g);
        double d10 = fAbs / d7;
        double d11 = this.f12429j - d7;
        double dAbs = (Math.abs(this.f12428h - this.f12426f) / d7) * d11;
        double d12 = d11 * d10;
        float f5 = this.i;
        int i = this.f12427g;
        int i3 = f5 < ((float) i) ? -1 : f5 > ((float) i) ? 1 : 0;
        float f10 = this.f12428h;
        int i10 = this.f12426f;
        this.f12428h = (float) ((dAbs * (f10 <= ((float) i10) ? f10 < ((float) i10) ? -1 : 0 : 1)) + f10);
        this.i = (float) ((d12 * i3) + f5);
        return new PointF(this.f12428h, this.i);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f12426f, this.f12427g, this.f12429j, this.f12430k);
        canvas.drawCircle(this.f12428h, this.i, this.f12432m, this.f12431l);
        canvas.drawCircle(this.f12426f, this.f12427g, this.f12435p, this.f12434o);
        canvas.drawCircle(this.f12426f, this.f12427g, this.f12435p, this.f12439t);
        this.f12434o.getColor();
        throw null;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        int i12 = i / 2;
        this.f12426f = i12;
        int i13 = i3 / 2;
        this.f12427g = i13;
        float fMin = Math.min(i12, i13);
        Paint paint = this.f12430k;
        this.f12429j = (int) (fMin - (paint.getStrokeWidth() / 2.0f));
        paint.setShader(new SweepGradient(this.f12426f, this.f12427g, this.f12433n, (float[]) null));
        if (this.f12436q == -1) {
            int iHSVToColor = Color.HSVToColor(new float[]{90.0f, 1.0f, 1.0f});
            this.f12436q = iHSVToColor;
            this.f12434o.setColor(iHSVToColor);
            this.f12428h = (float) ((Math.cos(Math.toRadians(90.0d)) * this.f12429j) + this.f12426f);
            this.i = (float) ((Math.sin(Math.toRadians(90.0d)) * this.f12429j) + this.f12427g);
            t tVar = new t(18);
            tVar.f200f = this;
            VarHandle.storeStoreFence();
            post(tVar);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            this.f12428h = motionEvent.getX();
            this.i = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double dSqrt = Math.sqrt(Math.pow(Math.abs(this.i - this.f12427g), 2.0d) + Math.pow(Math.abs(this.f12428h - this.f12426f), 2.0d));
            if (dSqrt >= this.f12426f - this.f12430k.getStrokeWidth() && dSqrt <= this.f12426f) {
                z10 = true;
            }
            this.f12425c = z10;
            if (z10) {
                d(dSqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.f12428h = motionEvent.getX();
            this.i = motionEvent.getY();
            if (this.f12425c) {
                PointF pointFD = d(Math.sqrt(Math.pow(Math.abs(this.i - this.f12427g), 2.0d) + Math.pow(Math.abs(this.f12428h - this.f12426f), 2.0d)));
                float degrees = (float) Math.toDegrees(Math.atan2(pointFD.y - (getHeight() / 2), pointFD.x - (getWidth() / 2)));
                if (degrees < 0.0f) {
                    degrees += 360.0f;
                }
                int iHSVToColor = Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
                this.f12436q = iHSVToColor;
                float[] fArr = {0.0f, this.f12437r, this.f12438s};
                Color.colorToHSV(iHSVToColor, fArr);
                int iHSVToColor2 = Color.HSVToColor(fArr);
                float[] fArr2 = {0.0f, this.f12437r, this.f12438s};
                Color.colorToHSV(iHSVToColor2, fArr2);
                int iHSVToColor3 = Color.HSVToColor(fArr2);
                this.f12434o.setColor(iHSVToColor3);
                b.e().i(iHSVToColor3);
                invalidate();
                return true;
            }
        }
        return true;
    }

    @Override // ne.a
    public final void b(int i) {
    }
}
