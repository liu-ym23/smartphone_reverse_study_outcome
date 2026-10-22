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
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import ne.a;
import ne.b;
import t1.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ColorSaturationAdjustView extends View implements a {

    /* renamed from: c, reason: collision with root package name */
    public int[] f12440c;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f12441f;

    /* renamed from: g, reason: collision with root package name */
    public float f12442g;

    /* renamed from: h, reason: collision with root package name */
    public int f12443h;
    public final Paint i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12444j;

    /* renamed from: k, reason: collision with root package name */
    public int f12445k;

    /* renamed from: l, reason: collision with root package name */
    public int f12446l;

    /* renamed from: m, reason: collision with root package name */
    public int f12447m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f12448n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f12449o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f12450p;

    public ColorSaturationAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12440c = e(-65536);
        this.f12441f = new Paint(1);
        Paint paint = new Paint(1);
        this.i = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.i.setStrokeWidth((int) e.e(4.0f, getContext()));
        this.i.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f12450p = paint2;
        paint2.setStyle(style);
        this.f12450p.setStrokeWidth(e.e(1.0f, getContext()));
        this.f12450p.setColor(getContext().getColor(R.color.fd_sys_color_outline_variant_default));
        this.f12444j = (int) e.e(14.0f, getContext());
        this.f12442g = ((int) e.e(8.0f, getContext())) + this.f12444j;
        this.f12448n = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.f12449o = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        b.e().f8958c.add(this);
    }

    public static int[] e(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        int[] iArr = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        for (int i3 = 0; i3 < 256; i3++) {
            fArr[1] = 0.003921569f * i3;
            iArr[i3] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    public static int f(int i) {
        float[] fArr = {0.0f, 1.0f, 1.0f};
        Color.colorToHSV(i, fArr);
        return Color.HSVToColor(fArr);
    }

    @Override // ne.a
    public final void b(int i) {
        this.f12440c = e(f(i));
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(f(i), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        float[] fArr2 = {0.0f, 1.0f, 0.0f};
        Color.colorToHSV(f(i), fArr2);
        int iHSVToColor2 = Color.HSVToColor(fArr2);
        this.f12448n.setTint(iHSVToColor);
        this.f12449o.setTint(iHSVToColor2);
        d();
        float[] fArr3 = new float[3];
        Color.colorToHSV(i, fArr3);
        float f5 = this.f12445k * fArr3[1];
        int i3 = this.f12446l;
        float f10 = f5 + i3;
        this.f12442g = f10;
        float f11 = i3;
        if (f10 <= f11) {
            this.f12442g = f11;
        }
        float f12 = this.f12442g;
        float f13 = this.f12447m;
        if (f12 >= f13) {
            this.f12442g = f13;
        }
        invalidate();
    }

    public final void d() {
        if (getWidth() > 0) {
            this.f12441f.setShader(new LinearGradient(this.f12446l, 0.0f, this.f12447m, 0.0f, this.f12440c, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f12446l, 0.0f, this.f12447m, getHeight(), this.f12441f);
        this.f12448n.setBounds(0, 0, this.f12446l, getHeight());
        this.f12448n.draw(canvas);
        this.f12449o.setBounds(this.f12447m, 0, getWidth(), getHeight());
        this.f12449o.draw(canvas);
        canvas.drawCircle(this.f12442g, this.f12443h, this.f12444j, this.i);
        canvas.drawCircle(this.f12442g, this.f12443h, (this.i.getStrokeWidth() / 2.0f) + this.f12444j, this.f12450p);
        canvas.drawCircle(this.f12442g, this.f12443h, this.f12444j - (this.i.getStrokeWidth() / 2.0f), this.f12450p);
        canvas.drawRoundRect(this.f12450p.getStrokeWidth(), this.f12450p.getStrokeWidth(), getWidth() - this.f12450p.getStrokeWidth(), getHeight() - this.f12450p.getStrokeWidth(), getHeight() / 2, getHeight() / 2, this.f12450p);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        this.f12445k = (int) (getWidth() * 0.88d);
        this.f12446l = (int) (getWidth() * 0.06d);
        this.f12447m = (int) (getWidth() * 0.94d);
        d();
        this.f12443h = i3 / 2;
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
        this.f12442g = x6;
        int i = this.f12446l;
        float f5 = i;
        if (x6 <= f5) {
            this.f12442g = f5;
        }
        float f10 = this.f12442g;
        float f11 = this.f12447m;
        if (f10 >= f11) {
            this.f12442g = f11;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, (this.f12442g - i) / this.f12445k));
        ArrayList arrayList = b.e().f8958c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((a) obj).c(fMax);
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
