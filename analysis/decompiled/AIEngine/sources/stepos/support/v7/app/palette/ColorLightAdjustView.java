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
class ColorLightAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f12212a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f12213b;

    /* renamed from: c, reason: collision with root package name */
    public float f12214c;

    /* renamed from: d, reason: collision with root package name */
    public int f12215d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f12216e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public int f12217j;

    /* renamed from: k, reason: collision with root package name */
    public int f12218k;

    /* renamed from: l, reason: collision with root package name */
    public int f12219l;

    /* renamed from: m, reason: collision with root package name */
    public final Drawable f12220m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f12221n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f12222o;

    public ColorLightAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12212a = new int[]{-1, -16777216};
        this.f12213b = new Paint(1);
        Paint paint = new Paint(1);
        this.f12216e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f12216e.setStrokeWidth((int) l8.f.a(4.0f, getContext()));
        this.f12216e.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f12222o = paint2;
        paint2.setStyle(style);
        this.f12222o.setStrokeWidth(l8.f.a(1.0f, getContext()));
        this.f12222o.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.h = (int) l8.f.a(14.0f, getContext());
        this.f12214c = ((int) l8.f.a(8.0f, getContext())) + this.h;
        this.f12220m = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f12221n = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        ((ArrayList) b.h().h).add(this);
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i10) {
        this.f12220m.setTint(-1);
        this.f12221n.setTint(-16777216);
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        float f8 = (1.0f - fArr[2]) * this.f12217j;
        int i11 = this.f12218k;
        float f9 = f8 + i11;
        this.f12214c = f9;
        float f10 = i11;
        if (f9 <= f10) {
            this.f12214c = f10;
        }
        float f11 = this.f12214c;
        float f12 = this.f12219l;
        if (f11 >= f12) {
            this.f12214c = f12;
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f12218k, 0.0f, this.f12219l, getHeight(), this.f12213b);
        this.f12220m.setBounds(0, 0, this.f12218k, getHeight());
        this.f12220m.draw(canvas);
        this.f12221n.setBounds(this.f12219l, 0, getWidth(), getHeight());
        this.f12221n.draw(canvas);
        canvas.drawCircle(this.f12214c, this.f12215d, this.h, this.f12216e);
        canvas.drawCircle(this.f12214c, this.f12215d, (this.f12216e.getStrokeWidth() / 2.0f) + this.h, this.f12222o);
        canvas.drawCircle(this.f12214c, this.f12215d, this.h - (this.f12216e.getStrokeWidth() / 2.0f), this.f12222o);
        canvas.drawRoundRect(this.f12222o.getStrokeWidth(), this.f12222o.getStrokeWidth(), getWidth() - this.f12222o.getStrokeWidth(), getHeight() - this.f12222o.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f12222o);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f12217j = (int) (getWidth() * 0.88d);
        this.f12218k = (int) (getWidth() * 0.06d);
        this.f12219l = (int) (getWidth() * 0.94d);
        if (getWidth() > 0) {
            this.f12213b.setShader(new LinearGradient(this.f12218k, 0.0f, this.f12219l, 0.0f, this.f12212a, (float[]) null, Shader.TileMode.CLAMP));
        }
        this.f12215d = i11 / 2;
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
        this.f12214c = x3;
        int i10 = this.f12218k;
        float f8 = i10;
        if (x3 <= f8) {
            this.f12214c = f8;
        }
        float f9 = this.f12214c;
        float f10 = this.f12219l;
        if (f9 >= f10) {
            this.f12214c = f10;
        }
        float fMax = 1.0f - Math.max(0.0f, Math.min(1.0f, (this.f12214c - i10) / this.f12217j));
        ArrayList arrayList = (ArrayList) b.h().h;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((a) obj).b(fMax);
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
