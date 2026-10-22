package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public class TitleBarBadgeView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f6560a;
    public int b;
    public final Paint c;
    public boolean d;
    public int e;
    public final Paint f;
    public final float g;

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Ra.a.g, 0, 0);
        if (typedArrayObtainStyledAttributes != null) {
            this.f6560a = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.stepos_tab_view_dot_color));
            this.b = (int) typedArrayObtainStyledAttributes.getDimension(1, getResources().getDimension(R.dimen.stepos_title_bar_badge_radius));
        }
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.f6560a);
        this.c.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setColor(-1);
        this.f.setTextSize(a5.l.c(10.0f, getContext()));
        this.g = a5.l.c(16.0f, getContext());
    }

    public int getBadgeColor() {
        return this.f6560a;
    }

    public int getBadgeRadius() {
        return this.b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (!this.d) {
            canvas2 = canvas;
        } else if (TextUtils.isEmpty(null)) {
            canvas.drawCircle(this.e / 2, getHeight() / 2, this.b, this.c);
            canvas2 = canvas;
        } else {
            canvas.translate(a5.l.c(10.0f, getContext()), (-a5.l.c(17.0f, getContext())) + 0);
            canvas2 = canvas;
            canvas2.drawRoundRect(0.0f, 0.0f, this.g, a5.l.c(16.0f, getContext()), a5.l.c(8.0f, getContext()), a5.l.c(8.0f, getContext()), this.c);
            canvas2.drawText("null", a5.l.c(5.0f, getContext()), a5.l.c(12.0f, getContext()), this.f);
        }
        super.onDraw(canvas2);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        if (mode != 1073741824) {
            size = 16;
        }
        this.e = size;
        if (mode2 != 1073741824) {
            size2 = 16;
        }
        setMeasuredDimension(size, size2);
    }

    public void setBadgeColor(int i) {
        this.f6560a = i;
        invalidate();
    }

    public void setBadgeRadius(int i) {
        this.b = i;
        invalidate();
    }

    public void setShow(boolean z10) {
        this.d = z10;
    }
}
