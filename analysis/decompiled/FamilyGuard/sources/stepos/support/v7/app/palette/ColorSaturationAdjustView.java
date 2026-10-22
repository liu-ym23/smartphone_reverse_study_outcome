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
class ColorSaturationAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    private int[] f20931a;

    /* renamed from: b, reason: collision with root package name */
    private LinearGradient f20932b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20933c;

    /* renamed from: d, reason: collision with root package name */
    private float f20934d;

    /* renamed from: e, reason: collision with root package name */
    private int f20935e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f20936f;

    /* renamed from: g, reason: collision with root package name */
    private int f20937g;

    /* renamed from: h, reason: collision with root package name */
    private int f20938h;

    /* renamed from: i, reason: collision with root package name */
    private int f20939i;

    /* renamed from: j, reason: collision with root package name */
    private int f20940j;

    /* renamed from: k, reason: collision with root package name */
    private int f20941k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f20942l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f20943m;

    /* renamed from: n, reason: collision with root package name */
    private Paint f20944n;

    public ColorSaturationAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    private void d(float f5) {
        this.f20934d = f5;
        int i5 = this.f20940j;
        if (f5 <= i5) {
            this.f20934d = i5;
        }
        float f6 = this.f20934d;
        int i6 = this.f20941k;
        if (f6 >= i6) {
            this.f20934d = i6;
        }
    }

    private void e() {
        if (getWidth() > 0) {
            LinearGradient linearGradient = new LinearGradient(this.f20940j, 0.0f, this.f20941k, 0.0f, this.f20931a, (float[]) null, Shader.TileMode.CLAMP);
            this.f20932b = linearGradient;
            this.f20933c.setShader(linearGradient);
        }
    }

    private int[] f(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        int[] iArr = new int[256];
        for (int i6 = 0; i6 < 256; i6++) {
            fArr[1] = 0.003921569f * i6;
            iArr[i6] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    private int g(int i5, float f5) {
        float[] fArr = {0.0f, f5, 0.0f};
        Color.colorToHSV(i5, fArr);
        return Color.HSVToColor(fArr);
    }

    private int h(int i5) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i5, fArr);
        return Color.HSVToColor(fArr);
    }

    private float i(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        return fArr[1];
    }

    private void j() {
        this.f20931a = f(-65536);
        this.f20933c = new Paint(1);
        Paint paint = new Paint(1);
        this.f20936f = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f20936f.setStrokeWidth((int) i.a(4.0f, getContext()));
        this.f20936f.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f20944n = paint2;
        paint2.setStyle(style);
        this.f20944n.setStrokeWidth(i.a(1.0f, getContext()));
        this.f20944n.setColor(androidx.core.content.a.c(getContext(), H1.e.f2083e));
        this.f20937g = (int) i.a(14.0f, getContext());
        this.f20938h = (int) i.a(8.0f, getContext());
        this.f20934d = r0 + this.f20937g;
        this.f20942l = getContext().getDrawable(X4.e.f5929c);
        this.f20943m = getContext().getDrawable(X4.e.f5930d);
        b.b().a(this);
    }

    private void k(int i5) {
        this.f20931a = f(h(i5));
        int iG = g(h(i5), 0.0f);
        int iG2 = g(h(i5), 1.0f);
        this.f20942l.setTint(iG);
        this.f20943m.setTint(iG2);
        e();
        float fI = (this.f20939i * i(i5)) + this.f20940j;
        this.f20934d = fI;
        d(fI);
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public void a(float f5) {
    }

    @Override // stepos.support.v7.app.palette.a
    public void b(int i5) {
        k(i5);
    }

    @Override // stepos.support.v7.app.palette.a
    public void c(float f5) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f20940j, 0.0f, this.f20941k, getHeight(), this.f20933c);
        this.f20942l.setBounds(0, 0, this.f20940j, getHeight());
        this.f20942l.draw(canvas);
        this.f20943m.setBounds(this.f20941k, 0, getWidth(), getHeight());
        this.f20943m.draw(canvas);
        canvas.drawCircle(this.f20934d, this.f20935e, this.f20937g, this.f20936f);
        canvas.drawCircle(this.f20934d, this.f20935e, this.f20937g + (this.f20936f.getStrokeWidth() / 2.0f), this.f20944n);
        canvas.drawCircle(this.f20934d, this.f20935e, this.f20937g - (this.f20936f.getStrokeWidth() / 2.0f), this.f20944n);
        canvas.drawRoundRect(this.f20944n.getStrokeWidth(), this.f20944n.getStrokeWidth(), getWidth() - this.f20944n.getStrokeWidth(), getHeight() - this.f20944n.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f20944n);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f20939i = (int) (getWidth() * 0.88d);
        this.f20940j = (int) (getWidth() * 0.06d);
        this.f20941k = (int) (getWidth() * 0.94d);
        e();
        this.f20935e = i6 / 2;
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
        b.b().e(Math.max(0.0f, Math.min(1.0f, (this.f20934d - this.f20940j) / this.f20939i)));
        invalidate();
        return true;
    }
}
