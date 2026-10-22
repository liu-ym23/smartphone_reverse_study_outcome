package com.bytedance.android.ec.window.base.product.presenter.element.extmodule;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagContainerDTO;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ec.window.base.repository.vo.TagContainerUI;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.view.ECWindowTagListView;
import com.bytedance.android.ec.window.base.view.k;
import com.bytedance.android.window.shop.holder.d;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.WindowTabExtViewModel;
import com.bytedance.android.window.shop.home.tab.event.WindowLowPriceRecommendEvent;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase;
import com.bytedance.android.window.shop.repository.dto.y0;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.u;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import yo.i;
import zq3.f;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowProductExtModuleElementPresenter extends i<WindowV2ProductItemVO> implements com.bytedance.android.ec.window.base.view.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f49371t = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f49372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f49373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f49374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f49375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f49376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f49377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f49378r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ConstraintSet f49379s;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowProductExtModuleElementPresenter f49380a;

        public b(ECWindowProductExtModuleElementPresenter r100) {
            this.f49380a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f49380a.h0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowProductExtModuleElementPresenter f49381a;

        public c(ECWindowProductExtModuleElementPresenter r100) {
            this.f49381a = r100;
        }

        @Override // com.bytedance.android.ec.window.base.view.k
        public final String a(String r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ECWindowProductExtModuleElementPresenter r101 = this.f49381a;
            WindowV2ProductItemVO r102 = r101.f568605j;
            if (r102 != null) goto L8;
            return r100;
        L8:
            int r103 = f.f573300a;
            return f.c(r100, r101.i0(r102), PageFinder.via(this.f49381a.f450897e), f.a(((ECWindowViewModel) this.f49381a.f49378r.getValue()).getShopParam().getAuthorId(), r102));
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.window.base.view.a
    public final void U(ClickAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    public final ECWindowTagListView k0() {
        return (ECWindowTagListView) this.f49372l.getValue();
    }

    public final ViewGroup l0() {
        return (ViewGroup) this.f49373m.getValue();
    }

    public final void h0() {
        T r100 = this.f568605j;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == 0) goto L7;
        fo.b r102 = r100.C;
        if (r102 == null) goto L7;
        Boolean r103 = (Boolean) r102.a(wn.a.f560422s);
    L8:
        int r104 = 0;
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L41;
        ECWindowTagListDTO r105 = m0();
        if (r105 == null) goto L17;
        List<ECWindowTagContainerDTO> r106 = r105.getTagContainers();
        if (r106 == null) goto L17;
        if ((!r106.isEmpty()) == true) goto L41;
    L17:
        int r107 = d.a(32);
        ECWindowTagListView r108 = k0();
        if (r108 == null) goto L20;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L22:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r101 = r109;
    L25:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r101;
        if (r110 != null) goto L28;
        int r111 = 0;
    L29:
        int r112 = r107 + r111;
        Integer r113 = n0(a0().findViewById(R.id.store_product_card_extra_info_area));
        if (r113 == null) goto L32;
        int r114 = r113.intValue();
    L33:
        Integer r115 = n0(a0().findViewById(R.id.store_product_card_source_wrapper));
        if (r115 == null) goto L37;
        r104 = r115.intValue();
    L37:
        if ((r114 + r104) < r112) goto L39;
        return;
    L39:
        t0(r112);
        return;
    L32:
        r114 = 0;
        goto L33
    L28:
        r111 = r110.topMargin + r110.bottomMargin;
        goto L29
    L20:
        r109 = null;
    L41:
        ViewGroup r116 = l0();
        if (r116 == null) goto L51;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 != null) goto L47;
        return;
    L47:
        if ((r117 instanceof ConstraintLayout.LayoutParams) == true) goto L49;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ConstraintLayout.LayoutParams.class + " is expected, but " + r117.getClass() + " actually");
        return;
    L49:
        ((ConstraintLayout.LayoutParams) r117).constrainedHeight = false;
        r116.setLayoutParams(r116.getLayoutParams());
        return;
    L51:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final ECWindowTagListDTO m0() {
        T r100 = this.f568605j;
        if (r100 == 0) goto L5;
        Map<String, ECWindowTagListDTO> r101 = r100.K;
    L6:
        ECWindowTagListDTO r102 = j0(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        WindowTabExtViewModel r103 = (WindowTabExtViewModel) this.f49375o.getValue();
        T r104 = this.f568605j;
        if (r104 == 0) goto L12;
        String r105 = r104.f49464b;
    L13:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        y0 r106 = r103.getExtData(r105);
        if (r106 == null) goto L28;
        Map<String, ECWindowTagListDTO> r107 = r106.a();
        if (r107 == null) goto L28;
        T r108 = this.f568605j;
        if (r108 == 0) goto L27;
        Map<String, ECWindowTagListDTO> r109 = r108.K;
        if (r109 != null) goto L25;
        r109 = MapsKt.emptyMap();
    L25:
        r108.K = MapsKt.plus(r109, r107);
    L27:
        return j0(r107);
    L28:
        return null;
    L12:
        r105 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final boolean q0() {
        if (this.f568601f.c() != WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        ECWindowTagListView r100 = k0();
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        T r101 = this.f568605j;
        if (r101 == 0) goto L12;
        String r102 = r101.f49464b;
        if (r102 == null) goto L12;
        ((WindowTabExtViewModel) this.f49375o.getValue()).unsubscribe(r102);
    L12:
        if (q0() == false) goto L30;
        ViewGroup r103 = l0();
        ViewParent r104 = null;
        if (r103 == null) goto L17;
        ViewParent r105 = r103.getParent();
    L19:
        if ((r105 instanceof ConstraintLayout) == false) goto L22;
        r104 = r105;
    L22:
        ConstraintLayout r106 = (ConstraintLayout) r104;
        if (r106 == null) goto L31;
        ConstraintSet r107 = this.f49379s;
        if (r107 == null) goto L32;
        r107.applyTo(r106);
        return;
    L32:
        return;
    L31:
        return;
    L17:
        r105 = null;
        goto L19
    }

    public ECWindowProductExtModuleElementPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f49372l = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$extensionArea$2(this));
        this.f49373m = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$extensionAreaWrapper$2(this));
        this.f49374n = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$barrier$2(this));
        this.f49375o = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$extViewModel$2(this, r100));
        this.f49376p = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$priceArea$2(this));
        this.f49377q = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$windowTabViewModel$2(this, r100));
        this.f49378r = LazyKt.lazy(new ECWindowProductExtModuleElementPresenter$windowViewModel$2(this));
    }

    public static Integer n0(View r100) {
        Integer r101 = null;
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (r100.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r102 = null;
    L10:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        int r104 = r100.getHeight();
        if (r103 == null) goto L13;
        Integer r105 = Integer.valueOf(r103.topMargin);
    L14:
        int r106 = r104 + com.bytedance.android.shopping.extensions.k.f(r105);
        if (r103 == null) goto L18;
        r101 = Integer.valueOf(r103.bottomMargin);
    L18:
        return Integer.valueOf(r106 + com.bytedance.android.shopping.extensions.k.f(r101));
    L13:
        r105 = null;
        goto L14
    }

    @Override // yo.i
    public final void d0(WindowV2ProductItemVO r100) {
        String r101 = null;
        if (q0() == false) goto L30;
        Barrier r102 = (Barrier) this.f49374n.getValue();
        if (r102 == null) goto L8;
        r102.setReferencedIds(new int[]{R.id.store_product_card_extra_info_area, R.id.ec_window_product_bottom_ext_area_wrapper, R.id.store_product_card_source_wrapper});
    L8:
        View r103 = (View) this.f49376p.getValue();
        if (r103 == null) goto L17;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L17;
        if ((r104 instanceof ConstraintLayout.LayoutParams) == true) goto L16;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ConstraintLayout.LayoutParams.class + " is expected, but " + r104.getClass() + " actually");
        goto L17
    L16:
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        r105.topToTop = 0;
        r105.verticalChainStyle = 2;
        r105.bottomToTop = R.id.ec_window_product_bottom_ext_area_barrier;
        r105.verticalBias = 1.0f;
        r103.setLayoutParams(r103.getLayoutParams());
    L17:
        ViewGroup r106 = l0();
        if (r106 == null) goto L20;
        ViewParent r107 = r106.getParent();
    L22:
        if ((r107 instanceof ConstraintLayout) == true) goto L24;
        r107 = null;
    L24:
        ConstraintLayout r108 = (ConstraintLayout) r107;
        if (r108 == null) goto L30;
        if (this.f49379s != null) goto L30;
        ConstraintSet r109 = new ConstraintSet();
        r109.clone(r108);
        Unit r110 = Unit.INSTANCE;
        this.f49379s = r109;
        goto L30
    L20:
        r107 = null;
    L30:
        ECWindowTagListView r111 = k0();
        if (r111 == null) goto L36;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L36;
        r112.height = -2;
        r111.setLayoutParams(r111.getLayoutParams());
    L36:
        if (r100 == null) goto L38;
        r101 = r100.H;
    L38:
        boolean r113 = true;
        if (r101 != null) goto L41;
    L44:
        boolean r114 = true;
    L45:
        if (r114 == false) goto L47;
        return;
    L47:
        h0();
        ViewGroup r115 = l0();
        if (r115 == null) goto L65;
        int[] r116 = {R.id.store_product_card_extra_info_area, R.id.store_product_card_source_wrapper};
        int r117 = 0;
    L50:
        if (r117 >= 2) goto L61;
        Integer r118 = n0(a0().findViewById(r116[r117]));
        if (r118 == null) goto L54;
        int r119 = r118.intValue();
    L55:
        if (r119 <= 0) goto L57;
        boolean r120 = true;
    L58:
        if (r120 == false) goto L59;
        r117 = r117 + 1;
        goto L50
    L59:
        r113 = false;
        goto L61
    L57:
        r120 = false;
        goto L58
    L54:
        r119 = 1;
    L61:
        if (r113 == false) goto L63;
        h0();
        goto L65
    L63:
        r115.post(new b(this));
    L65:
        if (s0(false) == true) goto L75;
        T r121 = this.f568605j;
        if (r121 == 0) goto L76;
        String r122 = r121.f49464b;
        if (r122 == null) goto L77;
        ((WindowTabExtViewModel) this.f49375o.getValue()).subscribeOnce(r122, new ECWindowProductExtModuleElementPresenter$subscribeExtModule$1(this));
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L41:
        if (StringsKt.isBlank(r101) == true) goto L44;
        r114 = false;
        goto L45
    }

    public final String i0(WindowV2ProductItemVO r100) {
        if (r100 == null) goto L9;
        fo.b r101 = r100.C;
        if (r101 == null) goto L11;
        fo.a<String> r102 = wn.a.f560404a;
        Integer r103 = (Integer) r101.a(wn.a.C);
        if (r103 != null) goto L8;
        return "";
    L8:
        return "a1.b7635.c68164.d02462_i" + r103.intValue();
    L11:
        return "";
    L9:
        return "";
    }

    public final ECWindowTagListDTO j0(Map<String, ECWindowTagListDTO> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (q0() == false) goto L8;
        ECWindowTagListDTO r101 = r100.get("window_compare_price_tag_single");
    L9:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return r100.get("window_compare_price_tag");
    L8:
        r101 = r100.get("window_compare_price_tag_double");
        goto L9
    }

    public final int p0(boolean r100) {
        T r101 = this.f568605j;
        if (r101 == 0) goto L8;
        fo.b r102 = r101.C;
        if (r102 == null) goto L8;
        fo.a<String> r103 = wn.a.f560404a;
        Boolean r104 = (Boolean) r102.b(wn.a.f560420q, Boolean.TRUE);
    L8:
        return o0(R.id.store_product_card_extra_info_area, r100);
    }

    public final void r0(String r100) {
        final T r101 = this.f568605j;
        if (r101 != 0) goto L5;
        return;
    L5:
        BaseMetricsEvent2 r102 = new WindowLowPriceRecommendEvent(r100).with(new BaseEventContext[]{((BaseWindowTabViewModel) this.f49377q.getValue()).getWindowTabEventContext()});
        ECWindowProductCardGroupPresenterBase.a r103 = ECWindowProductCardGroupPresenterBase.f189292w;
        ECWindowViewModel r104 = (ECWindowViewModel) this.f49378r.getValue();
        BaseWindowTabViewModel r105 = (BaseWindowTabViewModel) this.f49377q.getValue();
        WindowLayoutType.a r106 = WindowLayoutType.Companion;
        WindowLayoutTypes r107 = this.f568601f.c();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "type");
        int r108 = u.f189633a[r107.ordinal()];
        if (r108 != 1) goto L8;
        WindowLayoutType r109 = WindowLayoutType.DOUBLECOLUMN;
    L12:
        BaseWindowTabViewModel r110 = (BaseWindowTabViewModel) this.f49377q.getValue();
        if ((r110 instanceof BaseWindowTabViewModel) == true) goto L15;
        r110 = null;
    L15:
        if (r110 == null) goto L17;
        String r111 = r110.getLastCategoryId();
    L18:
        if (r111 != null) goto L20;
        r111 = "";
    L20:
        String r112 = ((ECWindowViewModel) this.f49378r.getValue()).getEntranceInfo();
        if (r112 == null) goto L23;
        String r113 = com.bytedance.android.shopping.extensions.k.a(r112, new ECWindowProductExtModuleElementPresenter$reportEvent$$inlined$also$lambda$1(this, r101));
    L24:
        r103.getClass();
        r102.appendParam(ECWindowProductCardGroupPresenterBase.a.a(r104, r105, r101, r109, r111, r113));
        r102.post(PageFinder.via(a0()), i0(this.f568605j));
        return;
    L23:
        r113 = null;
        goto L24
    L17:
        r111 = null;
        goto L18
    L8:
        if (r108 == 2) goto L10;
        r109 = WindowLayoutType.DOUBLECOLUMN;
        goto L12
    L10:
        r109 = WindowLayoutType.SINGLECOLUMN;
        goto L12
    }

    public final boolean s0(boolean r110) {
        ECWindowTagListDTO r100 = m0();
        if (r100 != null) goto L8;
        ECWindowTagListView r101 = k0();
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        return false;
    L8:
        String r102 = r100.getExtraInfo().get("margin_left");
        if (r102 == null) goto L11;
        Integer r103 = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r105 = com.bytedance.android.ec.hybrid.list.util.c.d(r103);
    L12:
        String r106 = r100.getExtraInfo().get("margin_right");
        if (r106 == null) goto L15;
        Integer r107 = Integer.valueOf(CastIntegerProtector.parseInt(r106));
        int r108 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.d(r107);
    L16:
        ECWindowTagListView r111 = k0();
        if (r111 == null) goto L25;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L25;
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ViewGroup.MarginLayoutParams.class + " is expected, but " + r112.getClass() + " actually");
        goto L25
    L24:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        r113.leftMargin = r105;
        r113.rightMargin = r109;
        r111.setLayoutParams(r111.getLayoutParams());
    L25:
        int r114 = -1;
        if (r110 == true) goto L28;
        ECWindowTagListView r115 = k0();
        if (r115 == null) goto L62;
        r115.setVisibility(0);
    L62:
        T r116 = this.f568605j;
        if (r116 == 0) goto L67;
        fo.b r117 = r116.C;
        if (r117 == null) goto L67;
        Boolean r118 = (Boolean) r117.b(wn.a.f560421r, Boolean.TRUE);
    L67:
        T r119 = this.f568605j;
        if (r119 == 0) goto L72;
        fo.b r120 = r119.C;
        if (r120 == null) goto L72;
        Boolean r121 = (Boolean) r120.b(wn.a.f560420q, Boolean.TRUE);
    L72:
        if (r110 == true) goto L74;
    L76:
        boolean r122 = false;
    L77:
        if (r122 == true) goto L79;
        o0(R.id.store_product_card_source_wrapper, r110);
        p0(r110);
    L79:
        List<ECWindowTagContainerDTO> r123 = r100.getTagContainers();
        if (r123 == null) goto L103;
        List<ECWindowTagContainerDTO> r124 = r123;
        if ((r124 instanceof Collection) == true) goto L84;
    L86:
        Iterator<T> r125 = r124.iterator();
    L88:
        if (r125.hasNext() == false) goto L100;
        ECWindowTagContainerDTO r126 = (ECWindowTagContainerDTO) r125.next();
        if (r126 == null) goto L96;
        TagContainerUI r127 = r126.getTagContainerUI();
        if (r127 == null) goto L96;
        boolean r128 = true;
        if (r127.getRightAlignment() != true) goto L97;
        boolean r129 = true;
    L98:
        if (r129 == false) goto L88;
        boolean r130 = true;
    L101:
        if (r130 != r128) goto L103;
    L104:
        ECWindowTagListView r131 = k0();
        if (r131 == null) goto L113;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if (r132 == null) goto L113;
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == true) goto L112;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ViewGroup.MarginLayoutParams.class + " is expected, but " + r132.getClass() + " actually");
        goto L113
    L112:
        ((ViewGroup.MarginLayoutParams) r132).width = r114;
        r131.setLayoutParams(r131.getLayoutParams());
    L113:
        ECWindowTagListView r133 = k0();
        if (r133 != null) goto L116;
    L125:
        ECWindowTagListView r134 = k0();
        if (r134 == null) goto L128;
        Intrinsics.checkNotNullParameter(this, "clickProcessor");
        r134.f49834g.add(this);
    L128:
        ECWindowTagListView r135 = k0();
        if (r135 == null) goto L131;
        r135.setSchemaProcessor(new c(this));
    L131:
        BaseWindowTabViewModel r136 = (BaseWindowTabViewModel) this.f49377q.getValue();
        fo.a<Set<String>> r137 = wn.a.f560418o;
        T r138 = this.f568605j;
        if (r138 == 0) goto L134;
        String r139 = r138.f49464b;
    L135:
        if (r139 != null) goto L138;
        r139 = "";
    L138:
        if (r136.shouldReportEvent(r137, r139) == false) goto L148;
        ((BaseWindowTabViewModel) this.f49377q.getValue()).runLowPriorityTask(new ECWindowProductExtModuleElementPresenter$reportAreaShow$1(this));
        return true;
    L148:
        return true;
    L134:
        r139 = null;
        goto L135
    L116:
        if (q0() == true) goto L118;
    L123:
        Integer r140 = 0;
    L124:
        ECWindowTagListView.b(r133, r100, r140, 60);
        goto L125
    L118:
        if (r100.singleFormWidth() == null) goto L123;
        Integer r141 = r100.singleFormWidth();
        if (r141 == null) goto L122;
        r140 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(r141));
        goto L124
    L122:
        r140 = null;
    L97:
        r129 = false;
    L96:
        r128 = true;
        goto L97
    L100:
        r128 = true;
        r130 = false;
        goto L101
    L84:
        if (r124.isEmpty() == false) goto L86;
        r130 = false;
        r128 = true;
    L103:
        r114 = -2;
        goto L104
    L74:
        if (q0() == false) goto L76;
        r122 = true;
        goto L77
    L28:
        if (q0() == false) goto L56;
        ViewGroup r142 = l0();
        if (r142 == null) goto L32;
        ViewParent r143 = r142.getParent();
    L34:
        if ((r143 instanceof ConstraintLayout) == true) goto L36;
        r143 = null;
    L36:
        ConstraintLayout r144 = (ConstraintLayout) r143;
        if (r144 == null) goto L62;
        ViewGroup r145 = l0();
        if (r145 == null) goto L62;
        ECWindowTagListView r146 = k0();
        if (r146 == null) goto L62;
        View r147 = (View) this.f49376p.getValue();
        if (r147 == null) goto L62;
        r146.setVisibility(0);
        r145.setVisibility(4);
        ViewGroup.LayoutParams r148 = r147.getLayoutParams();
        if (r148 != null) goto L52;
    L55:
        ConstraintSet r149 = new ConstraintSet();
        r149.clone(r144);
        r149.setVisibility(r145.getId(), 0);
        r149.connect(R.id.store_product_card_price_wrapper, 4, R.id.ec_window_product_bottom_ext_area_wrapper, 3);
        r149.setVisibility(R.id.store_product_card_source_wrapper, 8);
        r149.setVisibility(R.id.store_product_card_extra_info_area, 8);
        TransitionManager.beginDelayedTransition(r144, new TransitionSet().setDuration(600).setOrdering(0).addTransition(new ChangeBounds().addTarget(R.id.store_product_card_price_wrapper)).addTransition(new Fade(1).addTarget(R.id.ec_window_product_bottom_ext_area_wrapper)));
        r149.applyTo(r144);
        goto L62
    L52:
        if ((r148 instanceof ConstraintLayout.LayoutParams) == true) goto L54;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ConstraintLayout.LayoutParams.class + " is expected, but " + r148.getClass() + " actually");
        goto L55
    L54:
        ((ConstraintLayout.LayoutParams) r148).bottomToTop = -1;
        r147.setLayoutParams(r147.getLayoutParams());
        goto L55
    L32:
        r143 = null;
        goto L34
    L56:
        ECWindowTagListView r150 = k0();
        if (r150 == null) goto L62;
        Integer[] r151 = com.bytedance.android.ec.window.base.common.uiext.b.f49223a;
        Intrinsics.checkNotNullParameter(r150, "$this$showWithAnimations");
        com.bytedance.android.ec.window.base.common.uiext.b.a(r150, 1, 600, true);
        goto L62
    L15:
        r109 = 0;
        goto L16
    L11:
        r105 = 0;
        goto L12
    }

    @Override // com.bytedance.android.ec.window.base.view.a
    public final void t(ClickAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r0("window_low_price_component_click");
    }

    public final void t0(int r100) {
        if (q0() == false) goto L5;
        return;
    L5:
        ViewGroup r101 = l0();
        if (r101 == null) goto L27;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 != null) goto L11;
        return;
    L11:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == true) goto L13;
        ECExceptionMonitor.c("layoutParams type mismatch, " + ConstraintLayout.LayoutParams.class + " is expected, but " + r102.getClass() + " actually");
        return;
    L13:
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r103.constrainedHeight = true;
        int r104 = d.a(32);
        ECWindowTagListView r105 = k0();
        ViewGroup.LayoutParams r106 = null;
        if (r105 == null) goto L16;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
    L18:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r106 = r107;
    L21:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r106;
        if (r108 != null) goto L24;
        int r109 = 0;
    L25:
        r103.matchConstraintMinHeight = RangesKt.coerceAtLeast(r100, r104 + r109);
        r101.setLayoutParams(r101.getLayoutParams());
        return;
    L24:
        r109 = r108.topMargin + r108.bottomMargin;
        goto L25
    L16:
        r107 = null;
        goto L18
    }

    public final int o0(int r100, boolean r101) {
        View r102 = a0().findViewById(r100);
        if (r102 != null) goto L6;
        return 0;
    L6:
        if (r102.getVisibility() != 8) goto L8;
        return 0;
    L8:
        Integer r103 = n0(r102);
        if (r101 == false) goto L11;
        Integer[] r104 = com.bytedance.android.ec.window.base.common.uiext.b.f49223a;
        Intrinsics.checkNotNullParameter(r102, "$this$hideWithAnimations");
        com.bytedance.android.ec.window.base.common.uiext.b.a(r102, 1, 600, false);
    L12:
        if (r103 != null) goto L14;
        return 0;
    L14:
        return RangesKt.coerceAtLeast(r103.intValue(), 0);
    L11:
        r102.setVisibility(8);
        goto L12
    }
}
