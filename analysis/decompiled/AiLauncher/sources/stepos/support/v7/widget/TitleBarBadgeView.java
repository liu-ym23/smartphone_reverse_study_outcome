package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$styleable;

/* loaded from: classes5.dex */
public class TitleBarBadgeView extends View {

    /* renamed from: k, reason: collision with root package name */
    public static int f41433k = 16;

    /* renamed from: l, reason: collision with root package name */
    public static int f41434l = 16;

    /* renamed from: a, reason: collision with root package name */
    public int f41435a;

    /* renamed from: b, reason: collision with root package name */
    public int f41436b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f41437c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f41438d;

    /* renamed from: e, reason: collision with root package name */
    public int f41439e;

    /* renamed from: f, reason: collision with root package name */
    public int f41440f;

    /* renamed from: g, reason: collision with root package name */
    public String f41441g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f41442h;

    /* renamed from: i, reason: collision with root package name */
    public float f41443i;

    /* renamed from: j, reason: collision with root package name */
    public int f41444j;

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41438d = false;
        c(context, attributeSet);
    }

    public final int a(int i10, int i11, int i12) {
        return i11 != 1073741824 ? i12 : i10;
    }

    public TypedArray b(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        d(context, attributeSet);
        e();
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayB = b(context, attributeSet, R$styleable.TitleBarBadgeView);
        if (typedArrayB == null) {
            return;
        }
        this.f41435a = typedArrayB.getColor(R$styleable.TitleBarBadgeView_mcTBBadgeColor, getResources().getColor(R$color.stepos_tab_view_dot_color));
        this.f41436b = (int) typedArrayB.getDimension(R$styleable.TitleBarBadgeView_mcTBBadgeRadius, getResources().getDimension(R$dimen.stepos_title_bar_badge_radius));
    }

    public final void e() {
        Paint paint = new Paint();
        this.f41437c = paint;
        paint.setColor(this.f41435a);
        this.f41437c.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f41442h = paint2;
        paint2.setColor(-1);
        this.f41442h.setTextSize(O6.s.a(10.0f, getContext()));
        this.f41443i = O6.s.a(16.0f, getContext());
    }

    public final boolean f() {
        return !TextUtils.isEmpty(this.f41441g);
    }

    public int getBadgeColor() {
        return this.f41435a;
    }

    public int getBadgeRadius() {
        return this.f41436b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (!this.f41438d) {
            canvas2 = canvas;
        } else if (f()) {
            canvas.translate(O6.s.a(10.0f, getContext()), (-O6.s.a(17.0f, getContext())) + this.f41444j);
            canvas2 = canvas;
            canvas2.drawRoundRect(0.0f, 0.0f, this.f41443i, O6.s.a(16.0f, getContext()), O6.s.a(8.0f, getContext()), O6.s.a(8.0f, getContext()), this.f41437c);
            canvas2.drawText(String.valueOf(this.f41441g), O6.s.a(5.0f, getContext()), O6.s.a(12.0f, getContext()), this.f41442h);
        } else {
            canvas.drawCircle(this.f41440f / 2, getHeight() / 2, this.f41436b, this.f41437c);
            canvas2 = canvas;
        }
        super.onDraw(canvas2);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f41440f = a(size, mode, f41434l);
        int iA = a(size2, mode2, f41433k);
        this.f41439e = iA;
        setMeasuredDimension(this.f41440f, iA);
    }

    public void setBadgeColor(int i10) {
        this.f41435a = i10;
        invalidate();
    }

    public void setBadgeRadius(int i10) {
        this.f41436b = i10;
        invalidate();
    }

    public void setShow(boolean z10) {
        this.f41438d = z10;
    }
}
