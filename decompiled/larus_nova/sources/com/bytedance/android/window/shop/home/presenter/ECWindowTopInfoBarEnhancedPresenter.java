package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.window.base.widget.BouncingMarqueeTextView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.topbar.ECWindowSearchView;
import com.bytedance.android.window.shop.widget.topbar.MinMode;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowTopInfoBarEnhancedPresenter extends j implements View.OnClickListener, View.OnLayoutChangeListener {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final ViewGroup B;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f188461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public tp3.a f188462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f188463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f188464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f188465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f188466r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f188467s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f188468t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f188469u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f188470v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f188471w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f188472x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f188473y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f188474z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter f188475a;

        public b(ECWindowTopInfoBarEnhancedPresenter r100) {
            this.f188475a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f188475a.b0().update(((Float) r100).floatValue());
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter f188476a;

        public c(ECWindowTopInfoBarEnhancedPresenter r100) {
            this.f188476a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if (r101.floatValue() < 0.9f) goto L14;
            BouncingMarqueeTextView r102 = (BouncingMarqueeTextView) this.f188476a.f188471w.getValue();
            if (r102 == null) goto L7;
            r102.setSelected(true);
        L7:
            BouncingMarqueeTextView r103 = (BouncingMarqueeTextView) this.f188476a.f188471w.getValue();
            if (r103 == null) goto L14;
            if (r103.f49901k == r103.f49900j) goto L14;
            r103.y(r103.f49899i);
        L14:
            if (this.f188476a.F() == false) goto L16;
            this.f188476a.b0().update(r101.floatValue());
        L17:
            this.f188476a.b0().setVisibility(0);
            return;
        L16:
            this.f188476a.b0().update(1 - r101.floatValue());
            goto L17
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter f188477a;

        public d(ECWindowTopInfoBarEnhancedPresenter r100) {
            this.f188477a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ECWindowTopInfoBarEnhancedPresenter r102 = this.f188477a;
            if (r102.A == true) goto L61;
            boolean r103 = true;
            r102.A = true;
            ImageView r104 = r102.f188465q;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L8:
            r104.setColorFilter(-1);
            ImageView r105 = this.f188477a.f188467s;
            if (r105 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L11:
            r105.setColorFilter(-1);
            if (this.f188477a.F() == true) goto L14;
        L22:
            r103 = false;
        L23:
            if (r103 == false) goto L28;
            ImageView r106 = this.f188477a.f188468t;
            if (r106 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
        L27:
            r106.setOnClickListener(new c2(this));
            this.f188477a.b0().setMinMode(MinMode.ICON);
        L30:
            if (this.f188477a.F() == false) goto L32;
            this.f188477a.b0().setMinMode(MinMode.ICON);
        L33:
            View r107 = this.f188477a.f188464p;
            if (r107 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
        L36:
            r107.addOnLayoutChangeListener(this.f188477a);
            ImageView r108 = this.f188477a.f188465q;
            if (r108 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L39:
            r108.addOnLayoutChangeListener(this.f188477a);
            View r109 = this.f188477a.f188464p;
            if (r109 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
        L42:
            r109.post(new d2(this));
            this.f188477a.O().getOffsetState().a(this.f188477a.U(), new e2(this, r103), false);
            final ECWindowTopInfoBarEnhancedPresenter r110 = this.f188477a;
            uq3.a r111 = r110.O().getHeaderResponse().getValue();
            if (r111 == null) goto L47;
            uq3.o r112 = r111.f551204c;
            if (r112 == null) goto L47;
            final uq3.m r113 = r112.f551271v;
        L48:
            if (r113 == null) goto L62;
            ViewStub r114 = (ViewStub) r110.y().findViewById(R.id.ec_shop_top_bar_im_entry);
            if (r114 == null) goto L63;
            View r115 = r114.inflate();
            if ((r115 instanceof ECDraweeView) == true) goto L56;
            r115 = null;
        L56:
            ECDraweeView r116 = (ECDraweeView) r115;
            if (r116 == null) goto L64;
            com.bytedance.android.ec.core.utils.y.a(r116, r113.f551243a);
            r110.O().doEventAction(r113.f551245c + "_show", new Pair[0]);
            com.bytedance.android.ec.core.widget.f.b(r116, 500L, null, new ECWindowTopInfoBarEnhancedPresenter$prepareImEntry$1(r110, r113));
            return;
        L64:
            return;
        L63:
            return;
        L62:
            return;
        L47:
            r113 = null;
            goto L48
        L32:
            this.f188477a.b0().setMinMode(MinMode.TEXT);
            goto L33
        L28:
            this.f188477a.b0().setMinMode(MinMode.TEXT);
            goto L30
        L14:
            if (this.f188477a.O().isCroppedStyle() == true) goto L22;
            uq3.a r117 = this.f188477a.O().getHeaderResponse().getValue();
            if (r117 == null) goto L23;
            uq3.o r118 = r117.f551204c;
            if (r118 == null) goto L23;
            if (r118.a() == true) goto L22;
        }
    }

    static {
    }

    public final ECWindowSearchView b0() {
        return (ECWindowSearchView) this.f188466r.getValue();
    }

    public final void c0() {
        Boolean r100 = O().isLiveOn().getValue();
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
    L8:
        int r102 = this.f188473y;
    L9:
        int r103 = this.f188474z;
        if (r103 > 0) goto L12;
        return;
    L12:
        if (this.f188472x > 0) goto L14;
        return;
    L14:
        if (this.f188473y <= 0) goto L26;
        int r104 = r103 - r102;
        if (r104 <= 0) goto L20;
        ECWindowSearchView r105 = b0();
        r105.f190114b = r104;
        r105.update(r105.f190116d);
        r105.f190115c = RangesKt.coerceAtMost(r105.f190115c, r104);
    L20:
        if ((!Intrinsics.areEqual(O().isLiveOn().getValue(), r101)) == false) goto L25;
        b0().a(Integer.valueOf(this.f188474z - this.f188473y));
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (O().isCroppedStyle() == true) goto L8;
        r102 = this.f188472x;
        goto L9
    }

    public ECWindowTopInfoBarEnhancedPresenter(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.B = r100;
        this.f188461m = LazyKt.lazy(ECWindowTopInfoBarEnhancedPresenter$topBarInfoAreaInterpolator$2.INSTANCE);
        this.f188466r = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$searchViewPlaceholder$2(this));
        this.f188469u = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$actionButtonGroup$2(this));
        this.f188470v = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$searchNoticeView$2(this));
        this.f188471w = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$tvShopName$2(this));
    }

    public static int a0(View r100) {
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        return r101.right;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        View r101 = w().b(R.id.ec_shop_top_info_bar_container).f();
        this.f188463o = r101;
        r101.setOnClickListener(this);
        this.f188464p = w().b(R.id.ec_shop_head_info_area_container).f();
        ImageView r102 = (ImageView) w().b(R.id.ec_shop_top_bar_back_btn).f();
        if (O().isSplitStyle() == false) goto L5;
        r102.setImageResource(R.drawable.commerce_anchor_v4_back_cross_shadow);
    L5:
        Unit r103 = Unit.INSTANCE;
        this.f188465q = r102;
        ((View) this.f188470v.getValue()).setSelected(true);
        this.f188468t = (ImageView) w().b(R.id.ec_window_click_enter_live_hint).f();
        this.f188467s = (ImageView) w().b(R.id.ec_shop_top_bar_more_btn).f();
        ImageView r104 = this.f188465q;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L8:
        r104.setOnClickListener(this);
        ImageView r105 = this.f188467s;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L11:
        r105.setOnClickListener(this);
        b0().setOnClickListener(this);
        w().b(R.id.ec_shop_top_bar_container_inner).f().setOnClickListener(this);
        b0().addOnLayoutChangeListener(this);
        QContext r106 = u();
        FragmentActivity r107 = com.bytedance.android.ec.core.utils.l0.c(r106.c());
        if ((r107 instanceof FragmentActivity) == true) goto L14;
        r107 = null;
    L14:
        if (r107 != null) goto L16;
        r107 = r106.a();
    L16:
        int r108 = com.bytedance.android.ec.core.utils.y1.f45751a;
        com.bytedance.android.ec.core.utils.y1.c(r107, r107.getWindow(), false);
        int r109 = com.bytedance.android.ec.core.utils.j.f45614a;
        com.bytedance.android.ec.core.utils.j.a.a(w().b(R.id.ec_shop_status_bar_placeholder).f());
        O().getTopBarHeight().setValue(Integer.valueOf(eh.b.b(r107) + w().b(R.id.ec_shop_top_bar_container_inner).f().getLayoutParams().height));
        O().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_window")});
        O().getCollapseProgress().observe(U(), new b(this));
        O().getSubCollapseProgress().observe(U(), new c(this));
        O().isLiveOn().a(U(), new d(this), false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = rp.a.f538829a;
        if (rp.a.a(r100.getId()) == false) goto L6;
        return;
    L6:
        if (r100.getId() != R.id.ec_shop_top_bar_back_btn) goto L16;
        Function1<hp3.b, Boolean> r102 = O().getEventDeliverer();
        if (r102 == null) goto L13;
        if (r102.invoke(lp3.a.f510210a).booleanValue() == false) goto L15;
        return;
    L15:
        D();
        goto L16
    L13:
        if (O().getPendingTaskViewModel().a() == false) goto L15;
        return;
    L16:
        int r103 = r100.getId();
        FragmentActivity r104 = null;
        if (r103 != R.id.ec_shop_top_bar_more_btn) goto L37;
        tp3.a r105 = this.f188462n;
        if (r105 == null) goto L24;
        if (r105.isShowing() != true) goto L24;
        return;
    L24:
        if (this.f188462n != null) goto L32;
        QContext r106 = u();
        FragmentActivity r107 = com.bytedance.android.ec.core.utils.l0.c(r106.c());
        if ((r107 instanceof FragmentActivity) == false) goto L29;
        r104 = r107;
    L29:
        if (r104 != null) goto L31;
        r104 = r106.a();
    L31:
        tp3.a r108 = new tp3.a(r104);
        r108.c(O());
        Unit r109 = Unit.INSTANCE;
        this.f188462n = r108;
    L32:
        tp3.a r110 = this.f188462n;
        if (r110 == null) goto L35;
        r110.b(w().b(R.id.ec_shop_top_bar_more_btn).f());
    L35:
        ECWindowViewModel r111 = O();
        int r112 = com.bytedance.android.ec.window.base.utils.i.f49729a;
        r111.doEventAction("click_menu", new Pair[]{com.bytedance.android.ec.window.base.utils.i.a("a1.b7635.c2240.d4411", false)});
        return;
    L37:
        if (r103 != R.id.ec_shop_top_bar_search_placeholder) goto L40;
        V();
        return;
    L40:
        if (r103 != R.id.ec_shop_top_info_bar_container) goto L54;
        View r113 = this.f188463o;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("topBarContainer");
    L44:
        Drawable r114 = r113.getBackground();
        if (r114 != null) goto L47;
        return;
    L47:
        if (r114.getAlpha() >= 10) goto L56;
        Function3<String, Boolean, String, Unit> r115 = O().getJump2Live();
        if (r115 == null) goto L57;
        Unit r116 = r115.invoke(null, Boolean.FALSE, "a1.b7635.c4706.d3124");
        return;
    L57:
        return;
    L56:
        return;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r100 == null) goto L15;
        int r109 = r100.getId();
        ImageView r110 = this.f188465q;
        if (r110 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L6:
        if (r110 == null) goto L8;
        Integer r111 = Integer.valueOf(r110.getId());
    L10:
        if (r109 != r111.intValue()) goto L15;
        ImageView r112 = this.f188465q;
        if (r112 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L14:
        this.f188472x = a0(r112);
        goto L15
    L8:
        r111 = null;
    L15:
        if (r100 == null) goto L25;
        int r113 = r100.getId();
        View r114 = this.f188464p;
        if (r114 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L20:
        if (r113 != r114.getId()) goto L25;
        View r115 = this.f188464p;
        if (r115 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L24:
        this.f188473y = RangesKt.coerceAtLeast(a0(r115), this.f188473y);
    L25:
        if (r100 != null) goto L27;
    L29:
        c0();
        return;
    L27:
        if (r100.getId() != b0().getId()) goto L29;
        this.f188474z = a0(b0());
        goto L29
    }
}
