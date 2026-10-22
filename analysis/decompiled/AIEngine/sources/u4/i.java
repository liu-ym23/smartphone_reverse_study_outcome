package u4;

import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f13161g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f13162i;

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f13161g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f13162i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void a(float f8, boolean z, int i10) {
        float interpolation = this.f13143a.getInterpolation(f8);
        V v3 = this.f13144b;
        boolean z3 = (Gravity.getAbsoluteGravity(i10, v3.getLayoutDirection()) & 3) == 3;
        boolean z10 = z == z3;
        int width = v3.getWidth();
        int height = v3.getHeight();
        float f9 = width;
        if (f9 > 0.0f) {
            float f10 = height;
            if (f10 <= 0.0f) {
                return;
            }
            float f11 = this.f13161g / f9;
            float f12 = this.h / f9;
            float f13 = this.f13162i / f10;
            if (z3) {
                f9 = 0.0f;
            }
            v3.setPivotX(f9);
            if (!z10) {
                f12 = -f11;
            }
            float fA = l4.a.a(0.0f, f12, interpolation);
            float f14 = fA + 1.0f;
            float fA2 = 1.0f - l4.a.a(0.0f, f13, interpolation);
            if (Float.isNaN(f14) || Float.isNaN(fA2)) {
                return;
            }
            v3.setScaleX(f14);
            v3.setScaleY(fA2);
            if (v3 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v3;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    childAt.setPivotX(z3 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f15 = z10 ? 1.0f - fA : 1.0f;
                    float f16 = fA2 != 0.0f ? (f14 / fA2) * f15 : 1.0f;
                    if (!Float.isNaN(f15) && !Float.isNaN(f16)) {
                        childAt.setScaleX(f15);
                        childAt.setScaleY(f16);
                    }
                }
            }
        }
    }
}
