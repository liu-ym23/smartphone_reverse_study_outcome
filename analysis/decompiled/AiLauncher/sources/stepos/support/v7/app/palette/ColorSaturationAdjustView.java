package stepos.support.v7.app.palette;

import O6.s;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.common.R$color;
import stepos.support.v7.appcompat.R$drawable;

/* loaded from: classes5.dex */
class ColorSaturationAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f40667a;

    /* renamed from: b, reason: collision with root package name */
    public LinearGradient f40668b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f40669c;

    /* renamed from: d, reason: collision with root package name */
    public float f40670d;

    /* renamed from: e, reason: collision with root package name */
    public int f40671e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f40672f;

    /* renamed from: g, reason: collision with root package name */
    public int f40673g;

    /* renamed from: h, reason: collision with root package name */
    public int f40674h;

    /* renamed from: i, reason: collision with root package name */
    public int f40675i;

    /* renamed from: j, reason: collision with root package name */
    public int f40676j;

    /* renamed from: k, reason: collision with root package name */
    public int f40677k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f40678l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f40679m;

    /* renamed from: n, reason: collision with root package name */
    public Paint f40680n;

    public ColorSaturationAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    private void d(float f10) {
        this.f40670d = f10;
        int i10 = this.f40676j;
        if (f10 <= i10) {
            this.f40670d = i10;
        }
        float f11 = this.f40670d;
        int i11 = this.f40677k;
        if (f11 >= i11) {
            this.f40670d = i11;
        }
    }

    private void e() {
        if (getWidth() > 0) {
            LinearGradient linearGradient = new LinearGradient(this.f40676j, 0.0f, this.f40677k, 0.0f, this.f40667a, (float[]) null, Shader.TileMode.CLAMP);
            this.f40668b = linearGradient;
            this.f40669c.setShader(linearGradient);
        }
    }

    private int h(int i10) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    private float i(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        return fArr[1];
    }

    private void j() {
        this.f40667a = f(-65536);
        this.f40669c = new Paint(1);
        Paint paint = new Paint(1);
        this.f40672f = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f40672f.setStrokeWidth((int) s.a(4.0f, getContext()));
        this.f40672f.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f40680n = paint2;
        paint2.setStyle(style);
        this.f40680n.setStrokeWidth(s.a(1.0f, getContext()));
        this.f40680n.setColor(androidx.core.content.a.c(getContext(), R$color.fd_sys_color_outline_variant_default));
        this.f40673g = (int) s.a(14.0f, getContext());
        this.f40674h = (int) s.a(8.0f, getContext());
        this.f40670d = r0 + this.f40673g;
        this.f40678l = getContext().getDrawable(R$drawable.color_adjust_view_left_space_bkg);
        this.f40679m = getContext().getDrawable(R$drawable.color_adjust_view_right_space_bkg);
        b.b().a(this);
    }

    private void k(int i10) {
        this.f40667a = f(h(i10));
        int iG = g(h(i10), 0.0f);
        int iG2 = g(h(i10), 1.0f);
        this.f40678l.setTint(iG);
        this.f40679m.setTint(iG2);
        e();
        float fI = (this.f40675i * i(i10)) + this.f40676j;
        this.f40670d = fI;
        d(fI);
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(int i10) {
        k(i10);
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(float f10) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f10) {
    }

    public final int[] f(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        int[] iArr = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            fArr[1] = 0.003921569f * i11;
            iArr[i11] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    public final int g(int i10, float f10) {
        float[] fArr = {0.0f, f10, 0.0f};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f40676j, 0.0f, this.f40677k, getHeight(), this.f40669c);
        this.f40678l.setBounds(0, 0, this.f40676j, getHeight());
        this.f40678l.draw(canvas);
        this.f40679m.setBounds(this.f40677k, 0, getWidth(), getHeight());
        this.f40679m.draw(canvas);
        canvas.drawCircle(this.f40670d, this.f40671e, this.f40673g, this.f40672f);
        canvas.drawCircle(this.f40670d, this.f40671e, this.f40673g + (this.f40672f.getStrokeWidth() / 2.0f), this.f40680n);
        canvas.drawCircle(this.f40670d, this.f40671e, this.f40673g - (this.f40672f.getStrokeWidth() / 2.0f), this.f40680n);
        canvas.drawRoundRect(this.f40680n.getStrokeWidth(), this.f40680n.getStrokeWidth(), getWidth() - this.f40680n.getStrokeWidth(), getHeight() - this.f40680n.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f40680n);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f40675i = (int) (getWidth() * 0.88d);
        this.f40676j = (int) (getWidth() * 0.06d);
        this.f40677k = (int) (getWidth() * 0.94d);
        e();
        this.f40671e = i11 / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
            }
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        d(motionEvent.getX());
        b.b().e(Math.max(0.0f, Math.min(1.0f, (this.f40670d - this.f40676j) / this.f40675i)));
        invalidate();
        return true;
    }
}
