package stepos.support.v7.app.palette;

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
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.Iterator;
import m2.o;

/* loaded from: classes2.dex */
class ColorSaturationAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f14564a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f14565b;

    /* renamed from: c, reason: collision with root package name */
    public float f14566c;

    /* renamed from: d, reason: collision with root package name */
    public int f14567d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f14568e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14569f;

    /* renamed from: g, reason: collision with root package name */
    public int f14570g;

    /* renamed from: h, reason: collision with root package name */
    public int f14571h;

    /* renamed from: i, reason: collision with root package name */
    public int f14572i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f14573j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f14574k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f14575l;

    public ColorSaturationAdjustView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14564a = e(-65536);
        this.f14565b = new Paint(1);
        Paint paint = new Paint(1);
        this.f14568e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f14568e.setStrokeWidth((int) o.c(getContext(), 4.0f));
        this.f14568e.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f14575l = paint2;
        paint2.setStyle(style);
        this.f14575l.setStrokeWidth(o.c(getContext(), 1.0f));
        this.f14575l.setColor(androidx.core.content.b.a(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.f14569f = (int) o.c(getContext(), 14.0f);
        this.f14566c = ((int) o.c(getContext(), 8.0f)) + this.f14569f;
        this.f14573j = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f14574k = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        b.d().f14577a.add(this);
    }

    public static int[] e(int i4) {
        float[] fArr = new float[3];
        Color.colorToHSV(i4, fArr);
        int[] iArr = new int[256];
        for (int i5 = 0; i5 < 256; i5++) {
            fArr[1] = 0.003921569f * i5;
            iArr[i5] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    public static int f(int i4) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i4, fArr);
        return Color.HSVToColor(fArr);
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i4) {
        this.f14564a = e(f(i4));
        float[] fArr = {0.0f, Property.DEFAULT_FLOAT_VALUE, 0.0f};
        Color.colorToHSV(f(i4), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        float[] fArr2 = {0.0f, 1.0f, 0.0f};
        Color.colorToHSV(f(i4), fArr2);
        int iHSVToColor2 = Color.HSVToColor(fArr2);
        this.f14573j.setTint(iHSVToColor);
        this.f14574k.setTint(iHSVToColor2);
        d();
        float[] fArr3 = new float[3];
        Color.colorToHSV(i4, fArr3);
        float f4 = this.f14570g * fArr3[1];
        int i5 = this.f14571h;
        float f5 = f4 + i5;
        this.f14566c = f5;
        float f6 = i5;
        if (f5 <= f6) {
            this.f14566c = f6;
        }
        float f7 = this.f14566c;
        float f8 = this.f14572i;
        if (f7 >= f8) {
            this.f14566c = f8;
        }
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f4) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f4) {
    }

    public final void d() {
        if (getWidth() > 0) {
            this.f14565b.setShader(new LinearGradient(this.f14571h, Property.DEFAULT_FLOAT_VALUE, this.f14572i, Property.DEFAULT_FLOAT_VALUE, this.f14564a, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f14571h, Property.DEFAULT_FLOAT_VALUE, this.f14572i, getHeight(), this.f14565b);
        this.f14573j.setBounds(0, 0, this.f14571h, getHeight());
        this.f14573j.draw(canvas);
        this.f14574k.setBounds(this.f14572i, 0, getWidth(), getHeight());
        this.f14574k.draw(canvas);
        canvas.drawCircle(this.f14566c, this.f14567d, this.f14569f, this.f14568e);
        canvas.drawCircle(this.f14566c, this.f14567d, (this.f14568e.getStrokeWidth() / 2.0f) + this.f14569f, this.f14575l);
        canvas.drawCircle(this.f14566c, this.f14567d, this.f14569f - (this.f14568e.getStrokeWidth() / 2.0f), this.f14575l);
        canvas.drawRoundRect(this.f14575l.getStrokeWidth(), this.f14575l.getStrokeWidth(), getWidth() - this.f14575l.getStrokeWidth(), getHeight() - this.f14575l.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f14575l);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f14570g = (int) (getWidth() * 0.88d);
        this.f14571h = (int) (getWidth() * 0.06d);
        this.f14572i = (int) (getWidth() * 0.94d);
        d();
        this.f14567d = i5 / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
            }
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        float x4 = motionEvent.getX();
        this.f14566c = x4;
        int i4 = this.f14571h;
        float f4 = i4;
        if (x4 <= f4) {
            this.f14566c = f4;
        }
        float f5 = this.f14566c;
        float f6 = this.f14572i;
        if (f5 >= f6) {
            this.f14566c = f6;
        }
        float fMax = Math.max(Property.DEFAULT_FLOAT_VALUE, Math.min(1.0f, (this.f14566c - i4) / this.f14570g));
        Iterator it = b.d().f14577a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(fMax);
        }
        invalidate();
        return true;
    }
}
