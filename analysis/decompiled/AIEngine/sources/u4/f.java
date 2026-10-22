package u4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f13157g;
    public final float h;

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f13157g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        V v3 = this.f13144b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(v3, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(v3, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (v3 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v3;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new o1.b());
        return animatorSet;
    }

    public final void b(float f8) {
        float interpolation = this.f13143a.getInterpolation(f8);
        V v3 = this.f13144b;
        float width = v3.getWidth();
        float height = v3.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f9 = this.f13157g / width;
        float f10 = this.h / height;
        float fA = 1.0f - l4.a.a(0.0f, f9, interpolation);
        float fA2 = 1.0f - l4.a.a(0.0f, f10, interpolation);
        if (Float.isNaN(fA) || Float.isNaN(fA2)) {
            return;
        }
        v3.setScaleX(fA);
        v3.setPivotY(height);
        v3.setScaleY(fA2);
        if (v3 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v3;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA2 != 0.0f ? fA / fA2 : 1.0f);
            }
        }
    }
}
