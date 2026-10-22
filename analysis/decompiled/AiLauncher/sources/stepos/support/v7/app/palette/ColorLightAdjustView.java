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
class ColorLightAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f40637a;

    /* renamed from: b, reason: collision with root package name */
    public LinearGradient f40638b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f40639c;

    /* renamed from: d, reason: collision with root package name */
    public float f40640d;

    /* renamed from: e, reason: collision with root package name */
    public int f40641e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f40642f;

    /* renamed from: g, reason: collision with root package name */
    public int f40643g;

    /* renamed from: h, reason: collision with root package name */
    public int f40644h;

    /* renamed from: i, reason: collision with root package name */
    public int f40645i;

    /* renamed from: j, reason: collision with root package name */
    public int f40646j;

    /* renamed from: k, reason: collision with root package name */
    public int f40647k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f40648l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f40649m;

    /* renamed from: n, reason: collision with root package name */
    public Paint f40650n;

    public ColorLightAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(int i10) {
        i(i10);
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(float f10) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f10) {
    }

    public final void d(float f10) {
        this.f40640d = f10;
        int i10 = this.f40646j;
        if (f10 <= i10) {
            this.f40640d = i10;
        }
        float f11 = this.f40640d;
        int i11 = this.f40647k;
        if (f11 >= i11) {
            this.f40640d = i11;
        }
    }

    public final void e() {
        if (getWidth() > 0) {
            LinearGradient linearGradient = new LinearGradient(this.f40646j, 0.0f, this.f40647k, 0.0f, this.f40637a, (float[]) null, Shader.TileMode.CLAMP);
            this.f40638b = linearGradient;
            this.f40639c.setShader(linearGradient);
        }
    }

    public final int[] f() {
        return new int[]{-1, -16777216};
    }

    public final float g(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        return fArr[2];
    }

    public final void h() {
        this.f40637a = f();
        this.f40639c = new Paint(1);
        Paint paint = new Paint(1);
        this.f40642f = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f40642f.setStrokeWidth((int) s.a(4.0f, getContext()));
        this.f40642f.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f40650n = paint2;
        paint2.setStyle(style);
        this.f40650n.setStrokeWidth(s.a(1.0f, getContext()));
        this.f40650n.setColor(androidx.core.content.a.c(getContext(), R$color.fd_sys_color_outline_variant_default));
        this.f40643g = (int) s.a(14.0f, getContext());
        this.f40644h = (int) s.a(8.0f, getContext());
        this.f40640d = r0 + this.f40643g;
        this.f40648l = getContext().getDrawable(R$drawable.color_adjust_view_left_space_bkg);
        this.f40649m = getContext().getDrawable(R$drawable.color_adjust_view_right_space_bkg);
        b.b().a(this);
    }

    public final void i(int i10) {
        this.f40648l.setTint(-1);
        this.f40649m.setTint(-16777216);
        float fG = (this.f40645i * (1.0f - g(i10))) + this.f40646j;
        this.f40640d = fG;
        d(fG);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f40646j, 0.0f, this.f40647k, getHeight(), this.f40639c);
        this.f40648l.setBounds(0, 0, this.f40646j, getHeight());
        this.f40648l.draw(canvas);
        this.f40649m.setBounds(this.f40647k, 0, getWidth(), getHeight());
        this.f40649m.draw(canvas);
        canvas.drawCircle(this.f40640d, this.f40641e, this.f40643g, this.f40642f);
        canvas.drawCircle(this.f40640d, this.f40641e, this.f40643g + (this.f40642f.getStrokeWidth() / 2.0f), this.f40650n);
        canvas.drawCircle(this.f40640d, this.f40641e, this.f40643g - (this.f40642f.getStrokeWidth() / 2.0f), this.f40650n);
        canvas.drawRoundRect(this.f40650n.getStrokeWidth(), this.f40650n.getStrokeWidth(), getWidth() - this.f40650n.getStrokeWidth(), getHeight() - this.f40650n.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f40650n);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f40645i = (int) (getWidth() * 0.88d);
        this.f40646j = (int) (getWidth() * 0.06d);
        this.f40647k = (int) (getWidth() * 0.94d);
        e();
        this.f40641e = i11 / 2;
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
        b.b().d(1.0f - Math.max(0.0f, Math.min(1.0f, (this.f40640d - this.f40646j) / this.f40645i)));
        invalidate();
        return true;
    }
}
