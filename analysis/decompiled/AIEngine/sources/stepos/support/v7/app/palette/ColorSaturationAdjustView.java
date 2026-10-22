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
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ColorSaturationAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f12238a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f12239b;

    /* renamed from: c, reason: collision with root package name */
    public float f12240c;

    /* renamed from: d, reason: collision with root package name */
    public int f12241d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f12242e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public int f12243j;

    /* renamed from: k, reason: collision with root package name */
    public int f12244k;

    /* renamed from: l, reason: collision with root package name */
    public int f12245l;

    /* renamed from: m, reason: collision with root package name */
    public final Drawable f12246m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f12247n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f12248o;

    public ColorSaturationAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12238a = e(-65536);
        this.f12239b = new Paint(1);
        Paint paint = new Paint(1);
        this.f12242e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f12242e.setStrokeWidth((int) l8.f.a(4.0f, getContext()));
        this.f12242e.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f12248o = paint2;
        paint2.setStyle(style);
        this.f12248o.setStrokeWidth(l8.f.a(1.0f, getContext()));
        this.f12248o.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.h = (int) l8.f.a(14.0f, getContext());
        this.f12240c = ((int) l8.f.a(8.0f, getContext())) + this.h;
        this.f12246m = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f12247n = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        ((ArrayList) b.h().h).add(this);
    }

    public static int[] e(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        int[] iArr = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            fArr[1] = 0.003921569f * i11;
            iArr[i11] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    public static int f(int i10) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i10, fArr);
        return Color.HSVToColor(fArr);
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i10) {
        this.f12238a = e(f(i10));
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(f(i10), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        float[] fArr2 = {0.0f, 1.0f, 0.0f};
        Color.colorToHSV(f(i10), fArr2);
        int iHSVToColor2 = Color.HSVToColor(fArr2);
        this.f12246m.setTint(iHSVToColor);
        this.f12247n.setTint(iHSVToColor2);
        d();
        float[] fArr3 = new float[3];
        Color.colorToHSV(i10, fArr3);
        float f8 = this.f12243j * fArr3[1];
        int i11 = this.f12244k;
        float f9 = f8 + i11;
        this.f12240c = f9;
        float f10 = i11;
        if (f9 <= f10) {
            this.f12240c = f10;
        }
        float f11 = this.f12240c;
        float f12 = this.f12245l;
        if (f11 >= f12) {
            this.f12240c = f12;
        }
        invalidate();
    }

    public final void d() {
        if (getWidth() > 0) {
            this.f12239b.setShader(new LinearGradient(this.f12244k, 0.0f, this.f12245l, 0.0f, this.f12238a, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f12244k, 0.0f, this.f12245l, getHeight(), this.f12239b);
        this.f12246m.setBounds(0, 0, this.f12244k, getHeight());
        this.f12246m.draw(canvas);
        this.f12247n.setBounds(this.f12245l, 0, getWidth(), getHeight());
        this.f12247n.draw(canvas);
        canvas.drawCircle(this.f12240c, this.f12241d, this.h, this.f12242e);
        canvas.drawCircle(this.f12240c, this.f12241d, (this.f12242e.getStrokeWidth() / 2.0f) + this.h, this.f12248o);
        canvas.drawCircle(this.f12240c, this.f12241d, this.h - (this.f12242e.getStrokeWidth() / 2.0f), this.f12248o);
        canvas.drawRoundRect(this.f12248o.getStrokeWidth(), this.f12248o.getStrokeWidth(), getWidth() - this.f12248o.getStrokeWidth(), getHeight() - this.f12248o.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f12248o);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f12243j = (int) (getWidth() * 0.88d);
        this.f12244k = (int) (getWidth() * 0.06d);
        this.f12245l = (int) (getWidth() * 0.94d);
        d();
        this.f12241d = i11 / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 2) {
            return true;
        }
        float x3 = motionEvent.getX();
        this.f12240c = x3;
        int i10 = this.f12244k;
        float f8 = i10;
        if (x3 <= f8) {
            this.f12240c = f8;
        }
        float f9 = this.f12240c;
        float f10 = this.f12245l;
        if (f9 >= f10) {
            this.f12240c = f10;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, (this.f12240c - i10) / this.f12243j));
        ArrayList arrayList = (ArrayList) b.h().h;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((a) obj).c(fMax);
        }
        invalidate();
        return true;
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f8) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f8) {
    }
}
