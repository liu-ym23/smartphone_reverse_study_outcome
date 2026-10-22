package stepos.support.v7.app.palette;

import N1.i;
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

/* loaded from: classes.dex */
class ColorLightAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    private int[] f20901a;

    /* renamed from: b, reason: collision with root package name */
    private LinearGradient f20902b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20903c;

    /* renamed from: d, reason: collision with root package name */
    private float f20904d;

    /* renamed from: e, reason: collision with root package name */
    private int f20905e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f20906f;

    /* renamed from: g, reason: collision with root package name */
    private int f20907g;

    /* renamed from: h, reason: collision with root package name */
    private int f20908h;

    /* renamed from: i, reason: collision with root package name */
    private int f20909i;

    /* renamed from: j, reason: collision with root package name */
    private int f20910j;

    /* renamed from: k, reason: collision with root package name */
    private int f20911k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f20912l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f20913m;

    /* renamed from: n, reason: collision with root package name */
    private Paint f20914n;

    public ColorLightAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    private void d(float f5) {
        this.f20904d = f5;
        int i5 = this.f20910j;
        if (f5 <= i5) {
            this.f20904d = i5;
        }
        float f6 = this.f20904d;
        int i6 = this.f20911k;
        if (f6 >= i6) {
            this.f20904d = i6;
        }
    }

    private void e() {
        if (getWidth() > 0) {
            LinearGradient linearGradient = new LinearGradient(this.f20910j, 0.0f, this.f20911k, 0.0f, this.f20901a, (float[]) null, Shader.TileMode.CLAMP);
            this.f20902b = linearGradient;
            this.f20903c.setShader(linearGradient);
        }
    }

    private int[] f() {
        return new int[]{-1, -16777216};
    }

    private float g(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        return fArr[2];
    }

    private void h() {
        this.f20901a = f();
        this.f20903c = new Paint(1);
        Paint paint = new Paint(1);
        this.f20906f = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f20906f.setStrokeWidth((int) i.a(4.0f, getContext()));
        this.f20906f.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f20914n = paint2;
        paint2.setStyle(style);
        this.f20914n.setStrokeWidth(i.a(1.0f, getContext()));
        this.f20914n.setColor(androidx.core.content.a.c(getContext(), H1.e.f2083e));
        this.f20907g = (int) i.a(14.0f, getContext());
        this.f20908h = (int) i.a(8.0f, getContext());
        this.f20904d = r0 + this.f20907g;
        this.f20912l = getContext().getDrawable(X4.e.f5929c);
        this.f20913m = getContext().getDrawable(X4.e.f5930d);
        b.b().a(this);
    }

    private void i(int i5) {
        this.f20912l.setTint(-1);
        this.f20913m.setTint(-16777216);
        float fG = (this.f20909i * (1.0f - g(i5))) + this.f20910j;
        this.f20904d = fG;
        d(fG);
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(float f5) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(int i5) {
        i(i5);
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f5) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f20910j, 0.0f, this.f20911k, getHeight(), this.f20903c);
        this.f20912l.setBounds(0, 0, this.f20910j, getHeight());
        this.f20912l.draw(canvas);
        this.f20913m.setBounds(this.f20911k, 0, getWidth(), getHeight());
        this.f20913m.draw(canvas);
        canvas.drawCircle(this.f20904d, this.f20905e, this.f20907g, this.f20906f);
        canvas.drawCircle(this.f20904d, this.f20905e, this.f20907g + (this.f20906f.getStrokeWidth() / 2.0f), this.f20914n);
        canvas.drawCircle(this.f20904d, this.f20905e, this.f20907g - (this.f20906f.getStrokeWidth() / 2.0f), this.f20914n);
        canvas.drawRoundRect(this.f20914n.getStrokeWidth(), this.f20914n.getStrokeWidth(), getWidth() - this.f20914n.getStrokeWidth(), getHeight() - this.f20914n.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f20914n);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f20909i = (int) (getWidth() * 0.88d);
        this.f20910j = (int) (getWidth() * 0.06d);
        this.f20911k = (int) (getWidth() * 0.94d);
        e();
        this.f20905e = i6 / 2;
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
        b.b().d(1.0f - Math.max(0.0f, Math.min(1.0f, (this.f20904d - this.f20910j) / this.f20909i)));
        invalidate();
        return true;
    }
}
