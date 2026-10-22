package stepos.support.v7.app.palette;

import a5.l;
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
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.stepos.ability.R;
import java.util.Iterator;

/* loaded from: classes4.dex */
class ColorSaturationAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f6326a;
    public final Paint b;
    public float c;
    public int d;
    public final Paint e;
    public final int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f6327j;
    public final Drawable k;
    public final Paint l;

    public ColorSaturationAdjustView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6326a = e(SupportMenu.CATEGORY_MASK);
        this.b = new Paint(1);
        Paint paint = new Paint(1);
        this.e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.e.setStrokeWidth((int) l.c(4.0f, getContext()));
        this.e.setColor(-1);
        Paint paint2 = new Paint(1);
        this.l = paint2;
        paint2.setStyle(style);
        this.l.setStrokeWidth(l.c(1.0f, getContext()));
        this.l.setColor(ContextCompat.getColor(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.f = (int) l.c(14.0f, getContext());
        this.c = ((int) l.c(8.0f, getContext())) + this.f;
        this.f6327j = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.k = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        b.c().f6328a.add(this);
    }

    public static int[] e(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        int[] iArr = new int[256];
        for (int i6 = 0; i6 < 256; i6++) {
            fArr[1] = 0.003921569f * i6;
            iArr[i6] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    public static int f(int i) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i, fArr);
        return Color.HSVToColor(fArr);
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i) {
        this.f6326a = e(f(i));
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(f(i), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        float[] fArr2 = {0.0f, 1.0f, 0.0f};
        Color.colorToHSV(f(i), fArr2);
        int iHSVToColor2 = Color.HSVToColor(fArr2);
        this.f6327j.setTint(iHSVToColor);
        this.k.setTint(iHSVToColor2);
        d();
        float[] fArr3 = new float[3];
        Color.colorToHSV(i, fArr3);
        float f = this.g * fArr3[1];
        int i6 = this.h;
        float f7 = f + i6;
        this.c = f7;
        float f9 = i6;
        if (f7 <= f9) {
            this.c = f9;
        }
        float f10 = this.c;
        float f11 = this.i;
        if (f10 >= f11) {
            this.c = f11;
        }
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f) {
    }

    public final void d() {
        if (getWidth() > 0) {
            this.b.setShader(new LinearGradient(this.h, 0.0f, this.i, 0.0f, this.f6326a, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.h, 0.0f, this.i, getHeight(), this.b);
        this.f6327j.setBounds(0, 0, this.h, getHeight());
        this.f6327j.draw(canvas);
        this.k.setBounds(this.i, 0, getWidth(), getHeight());
        this.k.draw(canvas);
        canvas.drawCircle(this.c, this.d, this.f, this.e);
        canvas.drawCircle(this.c, this.d, (this.e.getStrokeWidth() / 2.0f) + this.f, this.l);
        canvas.drawCircle(this.c, this.d, this.f - (this.e.getStrokeWidth() / 2.0f), this.l);
        canvas.drawRoundRect(this.l.getStrokeWidth(), this.l.getStrokeWidth(), getWidth() - this.l.getStrokeWidth(), getHeight() - this.l.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.l);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.g = (int) (getWidth() * 0.88d);
        this.h = (int) (getWidth() * 0.06d);
        this.i = (int) (getWidth() * 0.94d);
        d();
        this.d = i6 / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 2) {
            return true;
        }
        float x10 = motionEvent.getX();
        this.c = x10;
        int i = this.h;
        float f = i;
        if (x10 <= f) {
            this.c = f;
        }
        float f7 = this.c;
        float f9 = this.i;
        if (f7 >= f9) {
            this.c = f9;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, (this.c - i) / this.g));
        Iterator it = b.c().f6328a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(fMax);
        }
        invalidate();
        return true;
    }
}
