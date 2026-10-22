package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;

/* loaded from: classes2.dex */
public class TitleBarBadgeView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f14984a;

    /* renamed from: b, reason: collision with root package name */
    public int f14985b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f14986c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14987d;

    /* renamed from: e, reason: collision with root package name */
    public int f14988e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f14989f;

    /* renamed from: g, reason: collision with root package name */
    public final float f14990g;

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14987d = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I3.a.f847g, 0, 0);
        if (typedArrayObtainStyledAttributes != null) {
            this.f14984a = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.stepos_tab_view_dot_color));
            this.f14985b = (int) typedArrayObtainStyledAttributes.getDimension(1, getResources().getDimension(R.dimen.stepos_title_bar_badge_radius));
        }
        Paint paint = new Paint();
        this.f14986c = paint;
        paint.setColor(this.f14984a);
        this.f14986c.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f14989f = paint2;
        paint2.setColor(-1);
        this.f14989f.setTextSize(m2.o.c(getContext(), 10.0f));
        this.f14990g = m2.o.c(getContext(), 16.0f);
    }

    public int getBadgeColor() {
        return this.f14984a;
    }

    public int getBadgeRadius() {
        return this.f14985b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f14987d) {
            if (!TextUtils.isEmpty(null)) {
                canvas.translate(m2.o.c(getContext(), 10.0f), (-m2.o.c(getContext(), 17.0f)) + 0);
                canvas.drawRoundRect(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, this.f14990g, m2.o.c(getContext(), 16.0f), m2.o.c(getContext(), 8.0f), m2.o.c(getContext(), 8.0f), this.f14986c);
                canvas.drawText("null", m2.o.c(getContext(), 5.0f), m2.o.c(getContext(), 12.0f), this.f14989f);
            } else {
                canvas.drawCircle(this.f14988e / 2, getHeight() / 2, this.f14985b, this.f14986c);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode != 1073741824) {
            size = 16;
        }
        this.f14988e = size;
        if (mode2 != 1073741824) {
            size2 = 16;
        }
        setMeasuredDimension(size, size2);
    }

    public void setBadgeColor(int i4) {
        this.f14984a = i4;
        invalidate();
    }

    public void setBadgeRadius(int i4) {
        this.f14985b = i4;
        invalidate();
    }

    public void setShow(boolean z4) {
        this.f14987d = z4;
    }
}
