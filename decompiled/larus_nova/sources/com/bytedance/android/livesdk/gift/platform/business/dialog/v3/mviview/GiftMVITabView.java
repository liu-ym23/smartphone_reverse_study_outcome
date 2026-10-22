package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CleanTabShowRange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchConfigData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnTabItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbExpireToastEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbTipsEffect;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVITabView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftTabViewState, GiftAction> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f127604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f127605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f127606o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f127607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f127608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IntRange f127609r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f127610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f127611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f127612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f127613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f127614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f127615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ViewGroup f127616y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DataCenter f127617z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftMVITabView f127618a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            GiftMVITabView r100 = this.f127618a;
            r100.f127611t = true;
            r100.r().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GiftMVITabView.u(this.f127618a);
        }

        public b(GiftMVITabView r100) {
            this.f127618a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        p(0);
        r().setOnClickListener(u0.f128146a);
        this.f127607p = r().findViewById(R.id.bottom_bg_view);
        this.f127605n = r().findViewById(R.id.gift_search_icon);
        this.f127606o = (ImageView) r().findViewById(R.id.gift_search_icon_iv);
        if (((Boolean) this.f127613v.getValue()).booleanValue() == false) goto L10;
        View r100 = this.f127605n;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
    L7:
        View r101 = this.f127605n;
        if (r101 == null) goto L13;
        r101.setOnClickListener(new v0(this));
    L13:
        v().setHorizontalFadingEdgeEnabled(true);
        v().setFadingEdgeLength(s1.f(40.0f));
        View r102 = r().findViewById(R.id.start_board);
        if (r102 == null) goto L16;
        r102.setVisibility(8);
    L16:
        View r103 = r().findViewById(R.id.end_board);
        if (r103 == null) goto L20;
        r103.setVisibility(8);
    L20:
        if (w() == true) goto L22;
    L23:
        View r104 = this.f127607p;
        if (r104 == null) goto L26;
        r104.setVisibility(8);
    L26:
        boolean r105 = w();
        int r106 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        Disposable r107 = null;
        if ((!r105) == false) goto L30;
        UIUtils.setViewVisibility(null, 8);
        UIUtils.setViewVisibility(null, 8);
    L30:
        if (((Boolean) this.f127612u.getValue()).booleanValue() == false) goto L38;
        GiftContext r108 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r108 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r109 = r108.getGiftTabMarginWidth();
        if (r109 == null) goto L38;
        Integer r110 = r109.getValue();
        if (r110 == null) goto L38;
        r().post(new t0(r110.intValue(), this));
    L38:
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L47;
        com.bytedance.live.datacontext.m<Integer> r112 = r111.getGiftTabMarginWidth();
        if (r112 == null) goto L47;
        Observable<Integer> r113 = r112.a();
        if (r113 == null) goto L47;
        Observable<Integer> r114 = r113.observeOn(AndroidSchedulers.mainThread());
        if (r114 == null) goto L47;
        r107 = r114.subscribe(new w0(this));
    L47:
        this.f127608q = r107;
        return;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L26;
    L10:
        View r115 = this.f127605n;
        if (r115 == null) goto L13;
        r115.setVisibility(8);
        goto L13
    }

    public final RecyclerView v() {
        return (RecyclerView) this.f127604m.getValue();
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        Disposable r100 = this.f127608q;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f127608q = null;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (PadConfigUtils.c() == false) goto L6;
        return R.layout.ttlive_base_gift_tab_view_pad;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L8;
        return R.layout.ttlive_base_gift_tab_view_new_structure;
    L8:
        return R.layout.ttlive_base_gift_tab_view;
    }

    public final boolean w() {
        if (PadConfigUtils.c() == false) goto L6;
        return true;
    L6:
        Boolean r100 = (Boolean) this.f127617z.get("data_is_portrait", Boolean.TRUE);
        if (r100 != null) goto L11;
        return false;
    L11:
        return r100.booleanValue();
    }

    public static final boolean t(GiftMVITabView r100) {
        if (((Boolean) r100.f127615x.getValue()).booleanValue() == false) goto L6;
        return ((Boolean) r100.f127614w.getValue()).booleanValue();
    L6:
        return com.bytedance.android.livesdk.gift.platform.core.utils.u.l(r100.w(), null);
    }

    public static final void u(GiftMVITabView r100) {
        if (r100.f127611t == false) goto L17;
        RecyclerView.LayoutManager r101 = r100.v().getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == true) goto L8;
        r101 = null;
    L8:
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
        if (r102 == null) goto L11;
        IntRange r103 = new IntRange(r102.findFirstVisibleItemPosition(), r102.findLastVisibleItemPosition());
    L13:
        if ((!Intrinsics.areEqual(r103, r100.f127609r)) == false) goto L16;
        r100.f127609r = r103;
        r100.o(new OnTabItemVisibleChanged(r103));
        return;
    L16:
        return;
    L11:
        r103 = new IntRange(-1, -1);
        goto L13
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVITabView$bindToParent$1 r101 = GiftMVITabView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(com.bytedance.android.anya.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof ShowProbTipsEffect) == false) goto L7;
        ToastUtil.a(R.string.ttlive_live_send_props_to_linker_tips, 0);
        return true;
    L7:
        if ((r100 instanceof ShowProbExpireToastEffect) == false) goto L11;
        String r101 = rm3.c.f538539a;
        rm3.c.f(getContext(), R.string.ttlive_live_prop_expire_toast_new, false, 16);
        mz0.n r102 = new mz0.n();
        mz0.m r103 = new mz0.m();
        r103.b(LogCommon.ROOM);
        r103.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r104 = r102.f516448b;
        ArrayList r105 = (ArrayList) r104;
        r105.addAll(r103.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r107 = com.bytedance.android.scope.m.b(r106).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r107);
        ((mz0.i) ((f80.a) r107)).w3("livesdk_property_overdue_remind_toast_show", r102.f516447a, r102.f516448b);
        return true;
    L11:
        if ((r100 instanceof CleanTabShowRange) == false) goto L14;
        this.f127609r = new IntRange(-1, -1);
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void k(com.bytedance.android.anya.dsl.a<GiftTabViewState, GiftAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerListAdapters");
        r100.a(GiftMVITabView$registerListAdapters$1.INSTANCE, new GiftMVITabView$registerListAdapters$2(this), v(), new GiftMVITabView$registerListAdapters$3(this));
    }

    public final void x(int r100) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L6;
        return;
    L6:
        if (this.f127616y.getWidth() <= 0) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r(), this.f127616y.getWidth() - s1.f(r100));
        if (this.f127610s == true) goto L12;
        this.f127610s = true;
        r().getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTabViewState r102 = (GiftTabViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        com.bytedance.android.anya.t0<GiftTabViewState, GiftTabItem> r103 = r102.getGiftTabItemList();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L8;
        r100.f41739b.f41563a.invoke(r103);
        if ((!((com.bytedance.android.anya.s0) r104).isEmpty()) == false) goto L7;
        v().setVisibility(0);
        goto L8
    L7:
        v().setVisibility(8);
    L8:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r105 = r102.getTabType();
        Object r106 = r100.f41740c.a(r105);
        if (r106 == null) goto L25;
        r100.f41739b.f41563a.invoke(r105);
        w1 r107 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).U(((Number) r106).intValue());
        if (r107 == null) goto L25;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.i(r107) == false) goto L15;
    L22:
        View r108 = this.f127607p;
        if (r108 == null) goto L25;
        r108.setVisibility(8);
        goto L25
    L15:
        if (w() == false) goto L22;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == true) goto L22;
        View r109 = this.f127607p;
        if (r109 == null) goto L25;
        r109.setVisibility(0);
    L25:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r110 = r102.getSelectPosition();
        Object r111 = r100.f41740c.a(r110);
        if (r111 == null) goto L32;
        r100.f41739b.f41563a.invoke(r110);
        int r112 = ((Number) r111).intValue();
        if (r112 < 0) goto L32;
        RecyclerView.LayoutManager r113 = v().getLayoutManager();
        if ((r113 instanceof LinearLayoutManager) == false) goto L32;
        r113.smoothScrollToPosition(v(), new RecyclerView.State(), r112);
    L32:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r114 = r102.getMarginEdgeWidth();
        Object r115 = r100.f41740c.a(r114);
        if (r115 == null) goto L37;
        r100.f41739b.f41563a.invoke(r114);
        int r116 = ((Number) r115).intValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L37;
        x(r116);
    L37:
        com.bytedance.android.anya.r0<GiftTabViewState, GiftSearchConfigData> r117 = r102.getGiftSearchConfig();
        Object r118 = r100.f41740c.a(r117);
        if (r118 == null) goto L59;
        r100.f41739b.f41563a.invoke(r117);
        GiftSearchConfigData r119 = (GiftSearchConfigData) r118;
        if (((Boolean) this.f127613v.getValue()).booleanValue() == true) goto L42;
        return;
    L42:
        if (r119.isNormalSearch() == true) goto L51;
        if (TextUtils.isEmpty(r119.getSchema()) == true) goto L51;
        if (r119.getIcon() == null) goto L51;
        ImageUtil.loadImage(this.f127606o, r119.getIcon(), 0);
        View r120 = this.f127605n;
        if (r120 == null) goto L61;
        r120.setOnClickListener(new s0(r119, this));
        return;
    L61:
        return;
    L51:
        if (r119.isNormalSearch() == true) goto L53;
    L55:
        View r121 = this.f127605n;
        if (r121 == null) goto L64;
        r121.setVisibility(8);
        return;
    L64:
        return;
    L53:
        if (r119.getIcon() == null) goto L55;
        ImageUtil.loadImage(this.f127606o, r119.getIcon(), 0);
        return;
    }

    public GiftMVITabView(Context r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentView");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        super(r100, r101);
        this.f127616y = r101;
        this.f127617z = r102;
        this.f127604m = LazyKt.lazy(new GiftMVITabView$recyclerView$2(this, r100));
        this.f127609r = new IntRange(-1, -1);
        this.f127612u = LazyKt.lazy(GiftMVITabView$tabWidthFix$2.INSTANCE);
        this.f127613v = LazyKt.lazy(new GiftMVITabView$giftSearchNewEntrance$2(this));
        this.f127614w = LazyKt.lazy(new GiftMVITabView$enableInComeToCoins$2(this));
        this.f127615x = LazyKt.lazy(GiftMVITabView$reqFrequencyOptSwitch$2.INSTANCE);
    }
}
