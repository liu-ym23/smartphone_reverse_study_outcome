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
class ColorLightAdjustView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f14535a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f14536b;

    /* renamed from: c, reason: collision with root package name */
    public float f14537c;

    /* renamed from: d, reason: collision with root package name */
    public int f14538d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f14539e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14540f;

    /* renamed from: g, reason: collision with root package name */
    public int f14541g;

    /* renamed from: h, reason: collision with root package name */
    public int f14542h;

    /* renamed from: i, reason: collision with root package name */
    public int f14543i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f14544j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f14545k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f14546l;

    public ColorLightAdjustView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14535a = new int[]{-1, -16777216};
        this.f14536b = new Paint(1);
        Paint paint = new Paint(1);
        this.f14539e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f14539e.setStrokeWidth((int) o.c(getContext(), 4.0f));
        this.f14539e.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f14546l = paint2;
        paint2.setStyle(style);
        this.f14546l.setStrokeWidth(o.c(getContext(), 1.0f));
        this.f14546l.setColor(androidx.core.content.b.a(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.f14540f = (int) o.c(getContext(), 14.0f);
        this.f14537c = ((int) o.c(getContext(), 8.0f)) + this.f14540f;
        this.f14544j = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f14545k = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        b.d().f14577a.add(this);
    }

    @Override // stepos.support.v7.app.palette.a
    public final void a(int i4) {
        this.f14544j.setTint(-1);
        this.f14545k.setTint(-16777216);
        float[] fArr = new float[3];
        Color.colorToHSV(i4, fArr);
        float f4 = (1.0f - fArr[2]) * this.f14541g;
        int i5 = this.f14542h;
        float f5 = f4 + i5;
        this.f14537c = f5;
        float f6 = i5;
        if (f5 <= f6) {
            this.f14537c = f6;
        }
        float f7 = this.f14537c;
        float f8 = this.f14543i;
        if (f7 >= f8) {
            this.f14537c = f8;
        }
        invalidate();
    }

    @Override // stepos.support.v7.app.palette.a
    public final void b(float f4) {
    }

    @Override // stepos.support.v7.app.palette.a
    public final void c(float f4) {
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f14542h, Property.DEFAULT_FLOAT_VALUE, this.f14543i, getHeight(), this.f14536b);
        this.f14544j.setBounds(0, 0, this.f14542h, getHeight());
        this.f14544j.draw(canvas);
        this.f14545k.setBounds(this.f14543i, 0, getWidth(), getHeight());
        this.f14545k.draw(canvas);
        canvas.drawCircle(this.f14537c, this.f14538d, this.f14540f, this.f14539e);
        canvas.drawCircle(this.f14537c, this.f14538d, (this.f14539e.getStrokeWidth() / 2.0f) + this.f14540f, this.f14546l);
        canvas.drawCircle(this.f14537c, this.f14538d, this.f14540f - (this.f14539e.getStrokeWidth() / 2.0f), this.f14546l);
        canvas.drawRoundRect(this.f14546l.getStrokeWidth(), this.f14546l.getStrokeWidth(), getWidth() - this.f14546l.getStrokeWidth(), getHeight() - this.f14546l.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f14546l);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f14541g = (int) (getWidth() * 0.88d);
        this.f14542h = (int) (getWidth() * 0.06d);
        this.f14543i = (int) (getWidth() * 0.94d);
        if (getWidth() > 0) {
            this.f14536b.setShader(new LinearGradient(this.f14542h, Property.DEFAULT_FLOAT_VALUE, this.f14543i, Property.DEFAULT_FLOAT_VALUE, this.f14535a, (float[]) null, Shader.TileMode.CLAMP));
        }
        this.f14538d = i5 / 2;
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
        this.f14537c = x4;
        int i4 = this.f14542h;
        float f4 = i4;
        if (x4 <= f4) {
            this.f14537c = f4;
        }
        float f5 = this.f14537c;
        float f6 = this.f14543i;
        if (f5 >= f6) {
            this.f14537c = f6;
        }
        float fMax = 1.0f - Math.max(Property.DEFAULT_FLOAT_VALUE, Math.min(1.0f, (this.f14537c - i4) / this.f14541g));
        Iterator it = b.d().f14577a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(fMax);
        }
        invalidate();
        return true;
    }
}
