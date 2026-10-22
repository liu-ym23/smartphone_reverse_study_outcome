package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.ShowType;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.i0;
import com.bytedance.android.gamecp.base.gamedetail.l0;
import com.bytedance.android.gamecp.business.gamedetail.BottomSheetBehavior;
import com.bytedance.android.gamecp.business.gamedetail.component.nav.NavBarWidget;
import com.bytedance.android.gamecp.business.gamedetail.component.nav.NavTabWidgetV4;
import com.bytedance.android.gamecp.business.gamedetail.component.tab.GameTabWidget;
import com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.NestedChildRecyclerView;
import com.bytedance.android.gamecp.business.gamedetail.view.NestedParentRecyclerView;
import com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerList;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.ui.RoundRectLayoutV2;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.b1;
import com.bytedance.android.gamecp.common.utils.g0;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.bytedance.ies.sve_list.SVEAdapter;
import com.bytedance.ies.sve_list.SVEViewHolder;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/scaffold/ScaffoldWidgetV5;", "Lcom/bytedance/android/gamecp/business/monitor/widget/BaseMonitorRecyclerList;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/scaffold/g;", "Lcom/bytedance/android/gamecp/base/gamedetail/d0;", "Lcom/bytedance/android/gamecp/business/gamedetail/view/NestedParentRecyclerView;", "Lcom/bytedance/android/gamecp/business/gamedetail/view/f;", "Lcom/bytedance/android/gamecp/business/gamedetail/view/g;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScaffoldWidgetV5 extends BaseMonitorRecyclerList<g, d0, NestedParentRecyclerView> implements com.bytedance.android.gamecp.business.gamedetail.view.f, com.bytedance.android.gamecp.business.gamedetail.view.g {
    public static final /* synthetic */ int O = 0;
    public float A;
    public FrameLayout B;
    public FrameLayout C;
    public HSImageView D;
    public float E;
    public boolean F;
    public final dt.b G;
    public PureWidget<d0> H;
    public PureWidget<d0> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public PureWidget<d0> f54977J;
    public final l0 K;
    public final h L;
    public final com.bytedance.android.gamecp.business.gamedetail.component.f M;
    public final Function2<Integer, SVEAdapter<d0, ?>, RecyclerViewItemWidget<? extends d0>> N;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super ScaffoldWidgetV5, Unit> f54978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f54979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f54980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f54981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BottomSheetBehavior<View> f54982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f54983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f54984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f54985o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f54986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f54987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f54988r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f54989s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f54990t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f54991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f54992v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f54993w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f54994x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f54995y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f54996z;

    public final NestedParentRecyclerView Sq() {
        View r100 = this.contentView;
        if (r100 == null) goto L7;
        NestedParentRecyclerView r101 = (NestedParentRecyclerView) r100.findViewById(R.id.rv_game_detail_list);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new NestedParentRecyclerView(this.context, null, 6, 0);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final View getLayoutView() {
        if (this.f54985o != null) goto L6;
        int r100 = com.bytedance.android.gamecp.business.gamedetail.asyncinflate.a.f53475a;
        this.f54985o = com.bytedance.android.gamecp.business.gamedetail.asyncinflate.a.a(this.context, getLayoutId());
    L6:
        return this.f54985o;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.view.f
    public final NestedChildRecyclerView ig() {
        ListAdapter r100 = this.f248711d;
        if (r100 == null) goto L5;
        int r101 = r100.getItemCount();
    L6:
        IntRange r102 = new IntRange(0, r101);
        int r103 = r102.getFirst();
        int r104 = r102.getLast();
        if (r103 > r104) goto L39;
    L8:
        RecyclerView.ViewHolder r105 = Sq().findViewHolderForAdapterPosition(r103);
        if (r105 == null) goto L37;
        boolean r106 = r105 instanceof SVEViewHolder;
        if (r106 == false) goto L21;
        LifecycleOwner r107 = ((SVEViewHolder) r105).f248724a;
        if ((r107 instanceof GameTabWidget) == false) goto L21;
        if (r107 == null) goto L20;
        BaseGameDetailTabWidget<?> r108 = ((GameTabWidget) r107).fr();
        if (r108 != null) goto L18;
        return null;
    L18:
        return r108.ig();
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.gamedetail.component.tab.GameTabWidget");
    L21:
        if (r106 == false) goto L29;
        LifecycleOwner r109 = ((SVEViewHolder) r105).f248724a;
        if ((r109 instanceof NavBarWidget) == false) goto L29;
        if (r109 == null) goto L28;
        return ((NavBarWidget) r109).ig();
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.gamedetail.component.nav.NavBarWidget");
    L29:
        if (r106 == false) goto L37;
        LifecycleOwner r110 = ((SVEViewHolder) r105).f248724a;
        if ((r110 instanceof NavTabWidgetV4) == false) goto L37;
        if (r110 == null) goto L36;
        return ((NavTabWidgetV4) r110).ig();
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.gamedetail.component.nav.NavTabWidgetV4");
    L37:
        if (r103 == r104) goto L39;
        r103 = r103 + 1;
    L39:
        return null;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.view.g
    public final NestedParentRecyclerView Ca() {
        return Sq();
    }

    @Override // com.bytedance.ies.sve_list.RecyclerList, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        Function1<? super ScaffoldWidgetV5, Unit> r100 = this.f54978h;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(this);
    L5:
        this.f54979i = (FrameLayout) this.contentView.getRootView().findViewById(R.id.fl_game_promote_detail_parent);
        l0 r102 = this.K;
        if (r102 == null) goto L14;
        i0 r103 = r102.f51629k;
        if (r103 == null) goto L14;
        if (r103.a() != true) goto L14;
        RoundRectLayoutV2 r104 = (RoundRectLayoutV2) this.contentView.findViewById(R.id.game_detail_round_bg);
        if (r104 == null) goto L14;
        r104.a(0.0f, 0.0f, 0.0f, 0.0f);
    L14:
        View r105 = this.contentView.getRootView().findViewById(R.id.design_bottom_sheet);
        this.f54980j = r105;
        if (r105 == null) goto L17;
        this.f54981k = UtilityKotlinExtentionsKt.f(r105);
        int r106 = BottomSheetBehavior.G;
        this.f54982l = BottomSheetBehavior.b.a(r105);
    L17:
        int r107 = b1.f57209a;
        dt.d r108 = dt.d.f469987b;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r109 = (com.bytedance.android.gamecp.business.gamedetail.base.model.h) b1.a(this, r108);
        int r110 = 0;
        if (r109 != null) goto L20;
    L22:
        boolean r111 = false;
    L23:
        this.F = r111;
        FrameLayout r112 = (FrameLayout) this.contentView.findViewById(R.id.gamecp_detail_below_bottomsheet_container);
        this.B = r112;
        if (r112 == null) goto L37;
        UtilsKt.f(r112);
        l0 r113 = this.K;
        if (r113 == null) goto L34;
        i0 r114 = r113.f51629k;
        if (r114 == null) goto L34;
        if (r114.a() != true) goto L34;
        FrameLayout r115 = this.f54979i;
        if (r115 == null) goto L37;
        r115.addView(r112, 0);
    L34:
        ViewGroup r116 = this.f54981k;
        if (r116 == null) goto L37;
        r116.addView(r112, 0);
    L37:
        View r117 = this.f54980j;
        if (r117 == null) goto L46;
        FrameLayout r118 = this.B;
        if (r118 == null) goto L46;
        g0.i(r118, g0.b(r117));
        Intrinsics.checkNotNullParameter(r117, "$this$layoutHeight");
        ViewGroup.LayoutParams r119 = r117.getLayoutParams();
        if (r119 == null) goto L44;
        int r120 = r119.height;
    L45:
        g0.d(r118, r120);
        g0.c(r118, g0.a(r117));
        goto L46
    L44:
        r120 = 0;
    L46:
        this.f54996z = this.contentView.getRootView().findViewById(R.id.game_detail_dialog_bg);
        this.f54988r = this.contentView.findViewById(R.id.ttlive_game_detail_dialog_title);
        l0 r121 = this.K;
        if (r121 == null) goto L57;
        i0 r122 = r121.f51629k;
        if (r122 == null) goto L57;
        if (r122.f51591a != ShowType.FLOAT) goto L53;
        boolean r123 = true;
    L54:
        if (r123 != true) goto L57;
    L70:
        FrameLayout r124 = this.B;
        if (r124 == null) goto L73;
        FrameLayout r125 = (FrameLayout) r124.findViewById(R.id.gamecp_detail_title_bar_bg_container);
    L74:
        this.C = r125;
        if (r125 == null) goto L77;
        g0.d(r125, (y0.b(44.0f) + ((Number) this.f54984n.getValue()).intValue()) + y0.b(12.0f));
    L77:
        FrameLayout r126 = this.B;
        if (r126 == null) goto L80;
        HSImageView r127 = (HSImageView) r126.findViewById(R.id.gamecp_detail_title_bar_bg);
    L81:
        this.D = r127;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r128 = (com.bytedance.android.gamecp.business.gamedetail.base.model.h) b1.a(this, r108);
        if (r128 == null) goto L93;
        com.bytedance.android.gamecp.business.gamedetail.base.model.c r129 = r128.e();
        if (r129 == null) goto L93;
        GameImageBundler r130 = r129.f();
        if (r130 == null) goto L93;
        boolean r131 = fu.d.f478832a;
        String r132 = fu.d.e(r130);
        if (r132 == null) goto L93;
        ImageModel r133 = new ImageModel();
        r133.setUrls(CollectionsKt.arrayListOf(new String[]{r132}));
        View r134 = this.f54980j;
        if (r134 == null) goto L92;
        r110 = r134.getMeasuredWidth();
    L92:
        fu.j.d(this.D, r133, new d(r110), null);
    L93:
        NestedParentRecyclerView r135 = Sq();
        r135.setMChildNestedScrollViewProvider(this);
        r135.setItemAnimator(null);
        r135.u();
        r135.addOnScrollListener(new ScaffoldWidgetV5$initRecyclerView$$inlined$apply$lambda$1(this));
        k r136 = new k(this);
        Intrinsics.checkNotNullParameter(r136, "listener");
        if (r135.f55704k.contains(r136) == true) goto L97;
        r135.f55704k.add(r136);
        return;
    L97:
        return;
    L80:
        r127 = null;
        goto L81
    L73:
        r125 = null;
        goto L74
    L53:
        r123 = false;
    L57:
        if (this.f54983m == true) goto L67;
        if (r121 == null) goto L63;
        i0 r137 = r121.f51629k;
        if (r137 == null) goto L63;
        if (r137.a() == true) goto L67;
    L63:
        dt.b r138 = this.G;
        if (r138 == null) goto L70;
        if (r138.P != 2) goto L70;
    L67:
        View r139 = this.f54988r;
        if (r139 == null) goto L70;
        r139.setPadding(0, ((Number) this.f54984n.getValue()).intValue(), 0, 0);
        goto L70
    L20:
        if (r109.f53487b != true) goto L22;
        r111 = true;
        goto L23
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        Sq().setAdapter(null);
    }

    @Override // com.bytedance.ies.sve_list.RecyclerList, com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        if (p0.a() == false) goto L5;
        return R.layout.gamecp_layout_game_detail_multi_tab_widget_v5_landscape;
    L5:
        return R.layout.gamecp_layout_game_detail_multi_tab_widget_v5_portrait;
    }

    @Override // com.bytedance.ies.sve_list.RecyclerList
    public final /* bridge */ /* synthetic */ RecyclerView getRecyclerView() {
        return Sq();
    }

    @Override // com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerList, com.bytedance.ies.sve_list.RecyclerList
    public final /* bridge */ /* synthetic */ void Nq(com.bytedance.ies.sve_list.b r100) {
        Tq((g) r100);
    }

    public final void Tq(final g r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.Nq(r100);
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$1.INSTANCE, new ScaffoldWidgetV5$onUpdate$2(this, r100));
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$3.INSTANCE, new ScaffoldWidgetV5$onUpdate$4(this));
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$5.INSTANCE, new ScaffoldWidgetV5$onUpdate$6(this));
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$7.INSTANCE, new ScaffoldWidgetV5$onUpdate$8(this));
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$9.INSTANCE, new ScaffoldWidgetV5$onUpdate$10(this));
        r.a.c(this, r100, ScaffoldWidgetV5$onUpdate$11.INSTANCE, new ScaffoldWidgetV5$onUpdate$12(this));
        if (this.F == false) goto L12;
        int r101 = b1.f57209a;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r102 = (com.bytedance.android.gamecp.business.gamedetail.base.model.h) b1.a(this, dt.d.f469987b);
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.f53487b != true) goto L9;
    L10:
        this.F = r103;
        Sq().setMIsNeedInterceptTouchEvent(this.F);
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerList, com.bytedance.ies.sve_list.RecyclerList, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        Tq((g) r100);
    }

    public static final void Rq(ScaffoldWidgetV5 r100, String r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        jw.c r103 = (jw.c) s.a(jw.c.class);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.sendJsEventToEventCenter("gamecpDetailTouchesEvents", MapsKt.mapOf(TuplesKt.to("eventType", r101)));     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScaffoldWidgetV5(dt.b r100, PureWidget<d0> r101, PureWidget<d0> r102, PureWidget<d0> r103, l0 r104, h r105, com.bytedance.android.gamecp.business.gamedetail.component.f r106, Function2<? super Integer, ? super SVEAdapter<d0, ?>, ? extends RecyclerViewItemWidget<? extends d0>> r107) {
        Intrinsics.checkNotNullParameter(r105, "uiStyle");
        Intrinsics.checkNotNullParameter(r106, "componentFactory");
        Intrinsics.checkNotNullParameter(r107, "block");
        super(r107);
        this.G = r100;
        this.H = r101;
        this.I = r102;
        this.f54977J = r103;
        this.K = r104;
        this.L = r105;
        this.M = r106;
        this.N = r107;
        this.f54983m = !p0.a();
        this.f54984n = LazyKt.lazy(ScaffoldWidgetV5$statusBarHeight$2.INSTANCE);
        this.f54986p = LazyKt.lazy(new ScaffoldWidgetV5$statusBarWidget$2(this));
        this.f54995y = -1.0f;
        this.A = -1.0f;
        this.E = -1.0f;
    }
}
