package stepos.support.v7.app;

import android.animation.AnimatorSet;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.animation.PathInterpolator;
import com.stepos.aiengine.R;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: i, reason: collision with root package name */
    public static final PathInterpolator f12260i;

    /* renamed from: a, reason: collision with root package name */
    public final ColorDrawable f12261a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12262b;

    /* renamed from: c, reason: collision with root package name */
    public final PopupNestedScrollingLayout f12263c;

    /* renamed from: d, reason: collision with root package name */
    public final r f12264d;

    /* renamed from: e, reason: collision with root package name */
    public int f12265e;

    /* renamed from: f, reason: collision with root package name */
    public AnimatorSet f12266f;

    /* renamed from: g, reason: collision with root package name */
    public final h1.f f12267g;
    public final Window h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements q {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements PopupNestedScrollingLayout.d {
    }

    static {
        x0.a.a(0.11f, 0.9f, 0.2f, 1.0f);
        x0.a.a(0.23f, 0.03f, 0.63f, 0.93f);
        f12260i = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public s(r rVar) {
        a aVar = new a();
        this.f12264d = rVar;
        this.h = rVar.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) rVar.findViewById(R.id.nested_scrolling_layout);
        this.f12263c = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(rVar.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height));
        rVar.getSupportActionBar();
        this.f12261a = new ColorDrawable(rVar.getResources().getColor(R.color.stepos_lite_popup_window_dim));
        popupNestedScrollingLayout.setOnDismissedListener(aVar);
        this.f12262b = 255;
        this.f12265e = 255;
        this.f12267g = new h1.f(popupNestedScrollingLayout, h1.d.f9221m);
        popupNestedScrollingLayout.setScrollListener(new b());
    }

    public final boolean a() {
        w.a().getClass();
        return this.f12264d == null;
    }
}
