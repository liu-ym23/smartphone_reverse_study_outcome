package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TitleBarBadgeView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f12639a;

    /* renamed from: b, reason: collision with root package name */
    public int f12640b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f12641c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12642d;

    /* renamed from: e, reason: collision with root package name */
    public int f12643e;
    public final Paint h;

    /* renamed from: j, reason: collision with root package name */
    public final float f12644j;

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12642d = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ce.a.f3419i, 0, 0);
        if (typedArrayObtainStyledAttributes != null) {
            this.f12639a = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.stepos_tab_view_dot_color));
            this.f12640b = (int) typedArrayObtainStyledAttributes.getDimension(1, getResources().getDimension(R.dimen.stepos_title_bar_badge_radius));
        }
        Paint paint = new Paint();
        this.f12641c = paint;
        paint.setColor(this.f12639a);
        this.f12641c.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setColor(-1);
        this.h.setTextSize(l8.f.a(10.0f, getContext()));
        this.f12644j = l8.f.a(16.0f, getContext());
    }

    public int getBadgeColor() {
        return this.f12639a;
    }

    public int getBadgeRadius() {
        return this.f12640b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (!this.f12642d) {
            canvas2 = canvas;
        } else if (TextUtils.isEmpty(null)) {
            canvas.drawCircle(this.f12643e / 2, getHeight() / 2, this.f12640b, this.f12641c);
            canvas2 = canvas;
        } else {
            canvas.translate(l8.f.a(10.0f, getContext()), (-l8.f.a(17.0f, getContext())) + 0);
            canvas2 = canvas;
            canvas2.drawRoundRect(0.0f, 0.0f, this.f12644j, l8.f.a(16.0f, getContext()), l8.f.a(8.0f, getContext()), l8.f.a(8.0f, getContext()), this.f12641c);
            canvas2.drawText("null", l8.f.a(5.0f, getContext()), l8.f.a(12.0f, getContext()), this.h);
        }
        super.onDraw(canvas2);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            size = 16;
        }
        this.f12643e = size;
        if (mode2 != 1073741824) {
            size2 = 16;
        }
        setMeasuredDimension(size, size2);
    }

    public void setBadgeColor(int i10) {
        this.f12639a = i10;
        invalidate();
    }

    public void setBadgeRadius(int i10) {
        this.f12640b = i10;
        invalidate();
    }

    public void setShow(boolean z) {
        this.f12642d = z;
    }
}
