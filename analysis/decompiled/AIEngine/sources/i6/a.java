package i6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.aiengine.R;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f9544a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9545b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9546c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9547d;

    public a(Context context) {
        Paint paint = new Paint(1);
        paint.setColor(context.getColor(R.color.mm_card_bg));
        paint.setStyle(Paint.Style.FILL);
        this.f9544a = paint;
        this.f9545b = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f9546c = TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics());
        this.f9547d = TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas c9, RecyclerView parent, RecyclerView.State state) {
        Paint paint;
        float f8;
        g.f(c9, "c");
        g.f(parent, "parent");
        g.f(state, "state");
        float width = parent.getWidth();
        float f9 = this.f9546c;
        float f10 = width - f9;
        RectF rectF = new RectF();
        int childCount = parent.getChildCount();
        float f11 = 0.0f;
        int i10 = 0;
        Float fValueOf = null;
        while (true) {
            paint = this.f9544a;
            f8 = this.f9545b;
            if (i10 >= childCount) {
                break;
            }
            View childAt = parent.getChildAt(i10);
            Object tag = childAt.getTag(R.id.mm_card_pos);
            int[] iArr = tag instanceof int[] ? (int[]) tag : null;
            if (iArr != null) {
                int i11 = iArr[0];
                int i12 = iArr[1];
                float f12 = this.f9547d;
                if (i11 == 0) {
                    fValueOf = Float.valueOf(childAt.getTop() - f12);
                } else if (fValueOf == null) {
                    fValueOf = Float.valueOf(-f8);
                }
                float bottom = childAt.getBottom();
                if (i11 == i12 - 1) {
                    rectF.set(f9, fValueOf.floatValue(), f10, f12 + bottom);
                    c9.drawRoundRect(rectF, f8, f8, paint);
                    f11 = bottom;
                } else {
                    f11 = bottom;
                    i10++;
                }
            } else if (fValueOf != null) {
                rectF.set(f9, fValueOf.floatValue(), f10, f11);
                c9.drawRoundRect(rectF, f8, f8, paint);
            }
            fValueOf = null;
            i10++;
        }
        if (fValueOf != null) {
            rectF.set(f9, fValueOf.floatValue(), f10, parent.getHeight() + f8);
            c9.drawRoundRect(rectF, f8, f8, paint);
        }
    }
}
