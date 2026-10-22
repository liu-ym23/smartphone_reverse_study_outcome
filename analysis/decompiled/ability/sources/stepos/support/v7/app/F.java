package stepos.support.v7.app;

import android.animation.AnimatorSet;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.stepos.ability.R;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes4.dex */
public final class F {
    public static final Interpolator i;

    /* renamed from: a, reason: collision with root package name */
    public final ColorDrawable f6216a;
    public final int b;
    public final PopupNestedScrollingLayout c;
    public final D d;
    public int e;
    public AnimatorSet f;
    public final SpringAnimation g;
    public final Window h;

    static {
        PathInterpolatorCompat.create(0.11f, 0.9f, 0.2f, 1.0f);
        PathInterpolatorCompat.create(0.23f, 0.03f, 0.63f, 0.93f);
        i = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public F(D d) {
        Q.a aVar = new Q.a(this, 10);
        this.d = d;
        this.h = d.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) d.findViewById(R.id.nested_scrolling_layout);
        this.c = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(d.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height));
        d.getSupportActionBar();
        this.f6216a = new ColorDrawable(d.getResources().getColor(R.color.stepos_lite_popup_window_dim));
        popupNestedScrollingLayout.setOnDismissedListener(aVar);
        this.b = 255;
        this.e = 255;
        this.g = new SpringAnimation(popupNestedScrollingLayout, DynamicAnimation.TRANSLATION_Y);
        popupNestedScrollingLayout.setScrollListener(new C1973w(this, 1));
    }

    public final boolean a() {
        I.a().getClass();
        return this.d == null;
    }
}
