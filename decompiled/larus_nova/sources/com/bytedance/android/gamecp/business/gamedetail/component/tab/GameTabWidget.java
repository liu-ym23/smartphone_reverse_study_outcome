package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.l0;
import com.bytedance.android.gamecp.business.comment.edit.w;
import com.bytedance.android.gamecp.business.datachannelmonitorlink.DataChannelMonitorLinkHandler;
import com.bytedance.android.gamecp.business.gamedetail.base.model.k;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.utils.d1;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.o;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.viewpager.PagerItemWidget;
import com.bytedance.ies.viewpager.SimpleSVEViewPagerAdapter;
import com.bytedance.live.datacontext.DataContext;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/tab/GameTabWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/tab/f;", "", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameTabWidget extends BaseGameDetailWidget<f> {
    public static final /* synthetic */ int C = 0;
    public final com.bytedance.android.gamecp.business.gamedetail.component.f A;
    public final /* synthetic */ yt.a B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TabLayout f55036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f55037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CustomGameViewPagerWidget f55038q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinearLayout f55039r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AudienceGamePromoteDetailViewModel f55040s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f55041t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f55042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f55043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f55044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l0 f55045x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f55046y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f55047z;

    public static final class a extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameTabWidget f55048a;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 3;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getShowExtraAttrs() {
            ArrayList r100 = new ArrayList();
            f r101 = (f) this.f55048a.f248681b.f248670b;
            if (r101 == null) goto L6;
            List r102 = r101.f55074b;
            if (r102 == null) goto L6;
        L7:
            Iterator r103 = r102.iterator();
        L9:
            if (r103.hasNext() == false) goto L12;
            r100.add(((e) r103.next()).f55068a);
            goto L9
        L12:
            return MapsKt.mapOf(TuplesKt.to("tab_content_list", r100.toString()));
        L6:
            r102 = new ArrayList();
            goto L7
        }

        public a(GameTabWidget r100) {
            this.f55048a = r100;
        }
    }

    public GameTabWidget() {
        throw null;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget
    public final boolean Qq() {
        return false;
    }

    public final void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.B.a(r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_item_game_detail_tab_widget;
    }

    public final BaseGameDetailTabWidget<?> fr() {
        CustomGameViewPagerWidget r100 = this.f55038q;
        PagerItemWidget r101 = null;
        if (r100 == null) goto L7;
        SimpleSVEViewPagerAdapter r102 = r100.f249256c;
        if (r102 == null) goto L7;
        PagerItemWidget r103 = (PagerItemWidget) CollectionsKt.getOrNull(r102.f249260a, r102.f249261b);
    L9:
        if ((r103 instanceof BaseGameDetailTabWidget) == false) goto L13;
        r101 = r103;
    L13:
        return (BaseGameDetailTabWidget) r101;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f55036o = (TabLayout) this.contentView.findViewById(R.id.tl_game_detail_tab_layout);
        this.f55037p = this.contentView.findViewById(R.id.v_game_detail_tab_line);
        this.f55039r = (LinearLayout) this.contentView.findViewById(R.id.ll_tab_view_parent);
        if (this.f55047z == false) goto L5;
        this.contentView.setBackgroundResource(R.drawable.gamecp_bg_detail_tab_radius_12);
    L5:
        autoDispose(com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("gamecpGameDetailTabToggle").observeOn(AndroidSchedulers.mainThread()), new GameTabWidget$initJSB$1(this)));
        autoDispose(com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("gamecpOpenPropOrder").observeOn(AndroidSchedulers.mainThread()), new GameTabWidget$initJSB$2(this)));
        autoDispose(com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("GameCPReceiveGiftPackSuccess").observeOn(AndroidSchedulers.mainThread()), new GameTabWidget$initJSB$3(this)));
        autoDispose(com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("GameCPReceiveCouponSuccess").observeOn(AndroidSchedulers.mainThread()), new GameTabWidget$initJSB$4(this)));
        Disposable r100 = jv.a.a().c(w.class).subscribe(new i(this));
        if (r100 == null) goto L8;
        autoDispose(r100);
    L8:
        int r101 = this.f55045x.f51624f.f51645a;
        if (r101 != 0) goto L21;
        Context r102 = this.context;
        Rect r103 = new Rect();
        if ((r102 instanceof Activity) == false) goto L14;
        d1.b(((Activity) r102).getWindow()).getWindowVisibleDisplayFrame(r103);
    L14:
        if (r103.height() != 0) goto L16;
        int r104 = y0.f();
        int r105 = y0.b(44.0f);
    L20:
        r101 = r104 - r105;
        goto L21
    L16:
        Context r106 = this.context;
        Rect r107 = new Rect();
        if ((r106 instanceof Activity) == false) goto L19;
        d1.b(((Activity) r106).getWindow()).getWindowVisibleDisplayFrame(r107);
    L19:
        r104 = r107.height();
        r105 = y0.b(44.0f);
    L21:
        LinearLayout r108 = this.f55039r;
        if (r108 == null) goto L24;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L25:
        if (r109 == null) goto L27;
        r109.height = r101;
    L27:
        if (r108 == null) goto L29;
        r108.setLayoutParams(r109);
    L29:
        LinearLayout r110 = this.f55039r;
        if (r110 == null) goto L32;
        ViewParent r111 = r110.getParent();
    L34:
        if ((r111 instanceof FrameLayout) == true) goto L36;
        r111 = null;
    L36:
        FrameLayout r112 = (FrameLayout) r111;
        if (r112 == null) goto L39;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L40:
        if (r113 == null) goto L42;
        r113.height = r101;
    L42:
        if (r112 == null) goto L44;
        r112.setLayoutParams(r113);
    L44:
        TabLayout r114 = this.f55036o;
        if (r114 == null) goto L47;
        r114.setTabMode(0);
    L47:
        TabLayout r115 = this.f55036o;
        if (r115 == null) goto L50;
        r115.setTabGravity(0);
    L50:
        r.a.a(this, new h(this, Eq()));
        int r116 = com.bytedance.android.gamecp.business.gamedetail.page.root.d.f55481b;
        ((o) Mq(com.bytedance.android.gamecp.business.gamedetail.page.root.d.a.a(), null).getFirst()).a(this, new GameTabWidget$handleVpBottomMargin$2(this));
        HashMap<String, String> r117 = GamecpTracker.f56755a;
        TabLayout r118 = this.f55036o;
        Intrinsics.checkNotNull(r118);
        GamecpTracker.r(r118, "tab_list", MapsKt.emptyMap(), new a(this), false, 112);
        return;
    L39:
        r113 = null;
        goto L40
    L32:
        r111 = null;
        goto L34
    L24:
        r109 = null;
        goto L25
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        this.f55041t = null;
        this.B.b();
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        gr((f) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        gr((f) r100);
    }

    public final void gr(f r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, GameTabWidget$onUpdate$1.INSTANCE, new GameTabWidget$onUpdate$2(this));
        r.a.c(this, r100, GameTabWidget$onUpdate$3.INSTANCE, new GameTabWidget$onUpdate$4(this));
        r.a.c(this, r100, GameTabWidget$onUpdate$5.INSTANCE, new GameTabWidget$onUpdate$6(this));
        r.a.c(this, r100, GameTabWidget$onUpdate$7.INSTANCE, new GameTabWidget$onUpdate$8(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        gr((f) r100);
    }

    public static final void dr(GameTabWidget r100, String r101) {
        r100.getClass();
        dt.b r102 = (dt.b) r100.Kq(dt.e.f469988b);
        k r103 = r102.D;
        if (r103 == null) goto L53;
        String r104 = r103.a();
        boolean r105 = false;
        if (r104 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L54;
        HashMap r107 = new HashMap();
        k r108 = r102.D;
        String r109 = "";
        if (r108 == null) goto L17;
        String r110 = r108.a();
        if (r110 == null) goto L17;
    L18:
        r107.put("game_id", r110);
        r107.put("action_type", r101);
        int r111 = r102.P;
        r107.put("is_ads", i0.d(r111));
        if (r102.Q.length() <= 0) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == false) goto L24;
        String r113 = r102.Q;
    L32:
        r107.put("host_id", r113);
        if (r111 == 0) goto L37;
        if (r111 == 1) goto L36;
        String r114 = "";
    L38:
        if (r114 == null) goto L41;
        r109 = r114;
    L41:
        r107.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r109);
        r107.put("scene", String.valueOf(r111));
        r107.put("req_id", i0.f(r111));
        mw.a r115 = (mw.a) s.a(mw.a.class);
        if (r115 == null) goto L46;
        if (r115.hasToolbarShow() != true) goto L46;
    L49:
        String r116 = "1";
    L51:
        r107.put("if_promote_icon", r116);
        DataChannelMonitorLinkHandler.h("douyin_game_content_consume_click_monitor", r107);
        return;
    L46:
        if (r102.P == 1) goto L48;
    L50:
        r116 = "0";
        goto L51
    L48:
        if (Intrinsics.areEqual(r102.f469950f, "video_anchor") == false) goto L50;
    L36:
        r114 = r102.R;
        goto L38
    L37:
        r114 = r102.f469939J;
        goto L38
    L24:
        String r117 = r102.I;
        if (r117 != null) goto L27;
    L31:
        r113 = "";
        goto L32
    L27:
        if (r117.length() <= 0) goto L29;
        r105 = true;
    L29:
        if (r105 != true) goto L31;
        r113 = r102.I;
        goto L32
    L21:
        r112 = false;
    L17:
        r110 = "";
        goto L18
    L54:
        return;
    L7:
        if (r104.length() == 0) goto L10;
        r106 = false;
        goto L11
    }

    public static final void er(GameTabWidget r100, int r101) {
        CustomGameViewPagerWidget r102 = r100.f55038q;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.contentView;
        if (r104 == null) goto L7;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L9:
        if ((r105 instanceof FrameLayout.LayoutParams) == false) goto L12;
        r103 = r105;
    L12:
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r103;
        if (r106 == null) goto L20;
        r106.bottomMargin = Math.max(r101, 0);
        CustomGameViewPagerWidget r107 = r100.f55038q;
        if (r107 == null) goto L21;
        View r108 = r107.contentView;
        if (r108 == null) goto L22;
        r108.setLayoutParams(r106);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((f) r101, "data");
    }

    public GameTabWidget(l0 r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, boolean r102, com.bytedance.android.gamecp.business.gamedetail.component.f r103) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        Intrinsics.checkNotNullParameter(r103, "componentFactory");
        DataContext r104 = null;
        super(null, null, null, 4);
        this.B = new yt.a();
        this.f55045x = r100;
        this.f55046y = r101;
        this.f55047z = r102;
        this.A = r103;
        p0.a();
        DataContext r105 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r105 instanceof AudienceGamePromoteDetailViewModel) == false) goto L6;
        r104 = r105;
    L6:
        this.f55040s = (AudienceGamePromoteDetailViewModel) r104;
    }
}
