package stepos.support.v7.app;

import android.animation.AnimatorSet;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import stepos.support.v7.widget.LitePopupContentFrameLayout;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes2.dex */
public final class G implements C {

    /* renamed from: k, reason: collision with root package name */
    public static final Interpolator f14269k;

    /* renamed from: a, reason: collision with root package name */
    public final ColorDrawable f14270a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14271b;

    /* renamed from: c, reason: collision with root package name */
    public final PopupNestedScrollingLayout f14272c;

    /* renamed from: d, reason: collision with root package name */
    public final D f14273d;

    /* renamed from: e, reason: collision with root package name */
    public final LitePopupContentFrameLayout f14274e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f14275f;

    /* renamed from: g, reason: collision with root package name */
    public int f14276g;

    /* renamed from: h, reason: collision with root package name */
    public AnimatorSet f14277h;

    /* renamed from: i, reason: collision with root package name */
    public final W.m f14278i;

    /* renamed from: j, reason: collision with root package name */
    public final Window f14279j;

    static {
        M.a.b(0.11f, 0.9f, 0.2f, 1.0f);
        M.a.b(0.23f, 0.03f, 0.63f, 0.93f);
        f14269k = M.a.b(0.33f, Property.DEFAULT_FLOAT_VALUE, 0.67f, 1.0f);
    }

    public G(D d4) {
        E e4 = new E(this);
        this.f14273d = d4;
        this.f14279j = d4.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) d4.findViewById(R.id.nested_scrolling_layout);
        this.f14272c = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(d4.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height));
        d4.getSupportActionBar();
        this.f14274e = (LitePopupContentFrameLayout) d4.findViewById(android.R.id.content);
        this.f14270a = new ColorDrawable(d4.getResources().getColor(R.color.stepos_lite_popup_window_dim));
        this.f14275f = (LinearLayout) d4.findViewById(R.id.action_bar_container);
        popupNestedScrollingLayout.setOnDismissedListener(e4);
        this.f14271b = 255;
        this.f14276g = 255;
        this.f14278i = new W.m(popupNestedScrollingLayout, W.m.f1955q);
        popupNestedScrollingLayout.setScrollListener(new E(this));
    }

    public final boolean a() throws Settings.SettingNotFoundException {
        float f4;
        try {
            f4 = Settings.Global.getFloat(this.f14273d.getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f4 = 1.0f;
        }
        return f4 != Property.DEFAULT_FLOAT_VALUE;
    }

    public final void b() {
        this.f14275f.setVisibility(8);
        D d4 = this.f14273d;
        Drawable drawable = d4.getResources().getDrawable(R.drawable.stepos_lite_popup_title_bar_bg);
        drawable.setTint(d4.getResources().getColor(R.color.fd_sys_color_surface_bright_default));
        this.f14274e.setBackground(drawable);
    }

    public final boolean c() {
        return I.b().f14283a == this.f14273d;
    }
}
