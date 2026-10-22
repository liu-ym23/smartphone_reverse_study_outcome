package com.bytedance.android.window.shop.home.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
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

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowTopInfoBarPresenter extends j implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f188478u = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public tp3.a f188479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f188480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f188481o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f188482p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f188483q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f188484r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f188485s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f188486t;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowTopInfoBarPresenter f188487a;

        public b(ECWindowTopInfoBarPresenter r100) {
            this.f188487a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ImageView r102 = this.f188487a.f188482p;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L5:
            r102.setColorFilter(-1);
            ImageView r103 = this.f188487a.f188484r;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L8:
            r103.setColorFilter(-1);
            ImageView r104 = this.f188487a.f188483q;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("searchViewPlaceholder");
        L11:
            r104.setColorFilter(-1);
            if (this.f188487a.F() == true) goto L14;
        L22:
            boolean r105 = false;
        L23:
            if (r105 == false) goto L28;
            ImageView r106 = this.f188487a.f188485s;
            if (r106 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
        L27:
            r106.setOnClickListener(new f2(this));
        L28:
            this.f188487a.O().getOffsetState().a(this.f188487a.U(), new g2(this, r105), false);
            final ECWindowTopInfoBarPresenter r107 = this.f188487a;
            uq3.a r108 = r107.O().getHeaderResponse().getValue();
            if (r108 == null) goto L33;
            uq3.o r109 = r108.f551204c;
            if (r109 == null) goto L33;
            final uq3.m r110 = r109.f551271v;
        L34:
            if (r110 == null) goto L47;
            ViewStub r111 = (ViewStub) r107.y().findViewById(R.id.ec_shop_top_bar_im_entry);
            if (r111 == null) goto L48;
            View r112 = r111.inflate();
            if ((r112 instanceof ECDraweeView) == true) goto L42;
            r112 = null;
        L42:
            ECDraweeView r113 = (ECDraweeView) r112;
            if (r113 == null) goto L49;
            com.bytedance.android.ec.core.utils.y.a(r113, r110.f551243a);
            r107.O().doEventAction(r110.f551245c + "_show", new Pair[0]);
            com.bytedance.android.ec.core.widget.f.b(r113, 500L, null, new ECWindowTopInfoBarPresenter$prepareImEntry$1(r107, r110));
            return;
        L49:
            return;
        L48:
            return;
        L47:
            return;
        L33:
            r110 = null;
            goto L34
        L14:
            if (this.f188487a.O().isCroppedStyle() == true) goto L22;
            uq3.a r114 = this.f188487a.O().getHeaderResponse().getValue();
            r105 = true;
            if (r114 == null) goto L23;
            uq3.o r115 = r114.f551204c;
            if (r115 == null) goto L23;
            if (r115.a() == true) goto L22;
            goto L22
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
    }

    public ECWindowTopInfoBarPresenter() {
        this.f188486t = LazyKt.lazy(new ECWindowTopInfoBarPresenter$actionButtonGroup$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        View r101 = w().b(R.id.ec_shop_top_info_bar_container).f();
        this.f188480n = r101;
        r101.setOnClickListener(this);
        this.f188481o = w().b(R.id.ec_shop_head_info_area_container).f();
        ImageView r102 = (ImageView) w().b(R.id.ec_shop_top_bar_back_btn).f();
        if (O().isSplitStyle() == false) goto L5;
        r102.setImageResource(R.drawable.commerce_anchor_v4_back_cross_shadow);
    L5:
        Unit r103 = Unit.INSTANCE;
        this.f188482p = r102;
        this.f188485s = (ImageView) w().b(R.id.ec_window_click_enter_live_hint).f();
        this.f188483q = (ImageView) w().b(R.id.ec_shop_top_bar_search_placeholder).f();
        this.f188484r = (ImageView) w().b(R.id.ec_shop_top_bar_more_btn).f();
        ImageView r104 = this.f188482p;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L8:
        fo.a<WindowLayoutType> r105 = WindowConstDef.f188713a;
        Lazy r106 = WindowConstDef.f188729q;
        com.bytedance.android.window.shop.home.tab.presenter.c0.j(r104, com.bytedance.android.window.shop.holder.d.a(Float.valueOf(((Number) r106.getValue()).floatValue())));
        com.bytedance.android.window.shop.home.tab.presenter.c0.j((View) this.f188486t.getValue(), com.bytedance.android.window.shop.holder.d.a(Float.valueOf(((Number) r106.getValue()).floatValue())));
        ImageView r107 = this.f188482p;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L11:
        r107.setOnClickListener(this);
        ImageView r108 = this.f188484r;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L14:
        r108.setOnClickListener(this);
        ImageView r109 = this.f188483q;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchViewPlaceholder");
    L17:
        r109.setOnClickListener(this);
        w().b(R.id.ec_shop_top_bar_container_inner).f().setOnClickListener(this);
        QContext r110 = u();
        FragmentActivity r111 = com.bytedance.android.ec.core.utils.l0.c(r110.c());
        if ((r111 instanceof FragmentActivity) == true) goto L20;
        r111 = null;
    L20:
        if (r111 != null) goto L22;
        r111 = r110.a();
    L22:
        int r112 = com.bytedance.android.ec.core.utils.y1.f45751a;
        com.bytedance.android.ec.core.utils.y1.c(r111, r111.getWindow(), false);
        int r113 = com.bytedance.android.ec.core.utils.j.f45614a;
        com.bytedance.android.ec.core.utils.j.a.a(w().b(R.id.ec_shop_status_bar_placeholder).f());
        O().getTopBarHeight().setValue(Integer.valueOf(eh.b.b(r111) + w().b(R.id.ec_shop_top_bar_container_inner).f().getLayoutParams().height));
        O().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_window")});
        O().isLiveOn().a(U(), new b(this), false);
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
        tp3.a r105 = this.f188479m;
        if (r105 == null) goto L24;
        if (r105.isShowing() != true) goto L24;
        return;
    L24:
        if (this.f188479m != null) goto L32;
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
        this.f188479m = r108;
    L32:
        tp3.a r110 = this.f188479m;
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
        View r113 = this.f188480n;
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
}
