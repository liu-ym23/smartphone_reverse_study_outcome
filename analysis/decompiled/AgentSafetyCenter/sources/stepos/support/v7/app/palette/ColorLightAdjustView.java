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
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import ne.a;
import ne.b;
import t1.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ColorLightAdjustView extends View implements a {

    /* renamed from: c, reason: collision with root package name */
    public final int[] f12413c;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f12414f;

    /* renamed from: g, reason: collision with root package name */
    public float f12415g;

    /* renamed from: h, reason: collision with root package name */
    public int f12416h;
    public final Paint i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12417j;

    /* renamed from: k, reason: collision with root package name */
    public int f12418k;

    /* renamed from: l, reason: collision with root package name */
    public int f12419l;

    /* renamed from: m, reason: collision with root package name */
    public int f12420m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f12421n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f12422o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f12423p;

    public ColorLightAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12413c = new int[]{-1, -16777216};
        this.f12414f = new Paint(1);
        Paint paint = new Paint(1);
        this.i = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.i.setStrokeWidth((int) e.e(4.0f, getContext()));
        this.i.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f12423p = paint2;
        paint2.setStyle(style);
        this.f12423p.setStrokeWidth(e.e(1.0f, getContext()));
        this.f12423p.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.f12417j = (int) e.e(14.0f, getContext());
        this.f12415g = ((int) e.e(8.0f, getContext())) + this.f12417j;
        this.f12421n = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f12422o = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        b.e().f8958c.add(this);
    }

    @Override // ne.a
    public final void b(int i) {
        this.f12421n.setTint(-1);
        this.f12422o.setTint(-16777216);
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float f5 = (1.0f - fArr[2]) * this.f12418k;
        int i3 = this.f12419l;
        float f10 = f5 + i3;
        this.f12415g = f10;
        float f11 = i3;
        if (f10 <= f11) {
            this.f12415g = f11;
        }
        float f12 = this.f12415g;
        float f13 = this.f12420m;
        if (f12 >= f13) {
            this.f12415g = f13;
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f12419l, 0.0f, this.f12420m, getHeight(), this.f12414f);
        this.f12421n.setBounds(0, 0, this.f12419l, getHeight());
        this.f12421n.draw(canvas);
        this.f12422o.setBounds(this.f12420m, 0, getWidth(), getHeight());
        this.f12422o.draw(canvas);
        canvas.drawCircle(this.f12415g, this.f12416h, this.f12417j, this.i);
        canvas.drawCircle(this.f12415g, this.f12416h, (this.i.getStrokeWidth() / 2.0f) + this.f12417j, this.f12423p);
        canvas.drawCircle(this.f12415g, this.f12416h, this.f12417j - (this.i.getStrokeWidth() / 2.0f), this.f12423p);
        canvas.drawRoundRect(this.f12423p.getStrokeWidth(), this.f12423p.getStrokeWidth(), getWidth() - this.f12423p.getStrokeWidth(), getHeight() - this.f12423p.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f12423p);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        this.f12418k = (int) (getWidth() * 0.88d);
        this.f12419l = (int) (getWidth() * 0.06d);
        this.f12420m = (int) (getWidth() * 0.94d);
        if (getWidth() > 0) {
            this.f12414f.setShader(new LinearGradient(this.f12419l, 0.0f, this.f12420m, 0.0f, this.f12413c, (float[]) null, Shader.TileMode.CLAMP));
        }
        this.f12416h = i3 / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 2) {
            return true;
        }
        float x6 = motionEvent.getX();
        this.f12415g = x6;
        int i = this.f12419l;
        float f5 = i;
        if (x6 <= f5) {
            this.f12415g = f5;
        }
        float f10 = this.f12415g;
        float f11 = this.f12420m;
        if (f10 >= f11) {
            this.f12415g = f11;
        }
        float fMax = 1.0f - Math.max(0.0f, Math.min(1.0f, (this.f12415g - i) / this.f12418k));
        ArrayList arrayList = b.e().f8958c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((a) obj).a(fMax);
        }
        invalidate();
        return true;
    }

    @Override // ne.a
    public final void a(float f5) {
    }

    @Override // ne.a
    public final void c(float f5) {
    }
}
