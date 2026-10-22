package com.bytedance.android.gamecp.business.gamedetail.page.lynx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget;
import com.bytedance.android.gamecp.business.gamedetail.page.root.effect.j;
import com.bytedance.android.gamecp.business.gamedetail.view.NestedChildRecyclerView;
import com.bytedance.android.gamecp.business.hybrid.uielement.GameDetailLynxCard;
import com.bytedance.android.gamecp.common.utils.b1;
import com.bytedance.ies.sve_core.PureWidget;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/page/lynx/GameLynxTabWidgetV4;", "Lcom/bytedance/android/gamecp/business/gamedetail/page/BaseGameDetailTabWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/page/lynx/d;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameLynxTabWidgetV4 extends BaseGameDetailTabWidget<d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GameDetailLynxCard f55387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public NestedChildRecyclerView f55388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f55389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f55390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GameLynxTabWidgetV4$onScrollListener$1 f55391m;

    public GameLynxTabWidgetV4() {
        this(null);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget, com.bytedance.ies.viewpager.PagerItemWidget
    public final void Nq() {
        d r100 = (d) this.f248681b.f248670b;
        if (r100 == null) goto L8;
        String r101 = r100.f55412a;
        if (r101 == null) goto L8;
        Wo(new j(r101));
    L8:
        if (this.f55390l == false) goto L93;
        this.f55390l = false;
        LayoutInflater r102 = LayoutInflater.from(this.context);
        View r103 = this.contentView;
        if (r103 == null) goto L92;
        r102.inflate(R.layout.gamecp_game_lynx_tab_widget, (ViewGroup) r103, true);
        View r104 = this.contentView;
        if (r104 == null) goto L14;
        GameDetailLynxCard r105 = (GameDetailLynxCard) r104.findViewById(R.id.lynx_item_card);
    L15:
        this.f55387i = r105;
        if (r105 == null) goto L19;
        r105.setCardLifeCycle(new e(this));
    L19:
        if (((d) this.f248681b.f248670b) == null) goto L94;
        int r106 = b1.f57209a;
        dt.b r107 = (dt.b) b1.a(this, dt.e.f469988b);
        d r108 = (d) this.f248681b.f248670b;
        if (r108 == null) goto L26;
        String r109 = r108.f55415d;
        if (r109 == null) goto L26;
        String r110 = r109;
    L27:
        if (r107 == null) goto L32;
        String r111 = r107.I;
        if (r111 == null) goto L32;
        String r112 = r111;
    L33:
        if (r107 == null) goto L38;
        String r113 = r107.F;
        if (r113 == null) goto L38;
        String r114 = r113;
    L39:
        if (r108 == null) goto L42;
        String r115 = r108.f55414c;
        if (r115 == null) goto L42;
    L45:
        if (r115 != null) goto L47;
        String r116 = "";
    L48:
        if (r107 == null) goto L50;
        Integer r117 = Integer.valueOf(r107.P);
    L51:
        String r118 = String.valueOf(r117);
        if (r107 == null) goto L57;
        String r119 = r107.G;
        if (r119 == null) goto L57;
        String r120 = r119;
    L58:
        if (r107 == null) goto L63;
        String r121 = r107.f469961k0;
        if (r121 == null) goto L63;
        String r122 = r121;
    L64:
        if (r107 == null) goto L69;
        String r123 = r107.f469939J;
        if (r123 == null) goto L69;
        String r124 = r123;
    L70:
        if (r107 == null) goto L75;
        String r125 = r107.R;
        if (r125 == null) goto L75;
        String r126 = r125;
    L76:
        String r127 = com.bytedance.android.gamecp.business.gamedetail.component.lynx.j.a(r110, r112, r114, r116, r118, r120, r122, r124, r126);
        GameDetailLynxCard r128 = this.f55387i;
        if (r128 == null) goto L95;
        Pair[] r129 = new Pair[4];
        d r130 = (d) this.f248681b.f248670b;
        if (r130 == null) goto L81;
        String r131 = r130.f55416e;
    L82:
        r129[0] = TuplesKt.to("cardInfo", r131);
        d r132 = (d) this.f248681b.f248670b;
        if (r132 == null) goto L85;
        Map<String, String> r133 = r132.f55418g;
    L86:
        r129[1] = TuplesKt.to("index", r133);
        d r134 = (d) this.f248681b.f248670b;
        if (r134 == null) goto L89;
        String r135 = r134.f55417f;
    L90:
        r129[2] = TuplesKt.to("gameDetailCommonParams", r135);
        com.bytedance.android.gamecp.business.gamedetail.util.e.f55635a.getClass();
        r129[3] = TuplesKt.to("detailPageInitialData", com.bytedance.android.gamecp.business.gamedetail.util.e.a(this, null).toString());
        GameDetailLynxCard.b(r128, r127, MapsKt.mapOf(r129));
        return;
    L89:
        r135 = null;
        goto L90
    L85:
        r133 = null;
        goto L86
    L81:
        r131 = null;
        goto L82
    L95:
        return;
    L75:
        r126 = "";
    L69:
        r124 = "";
    L63:
        r122 = "";
    L57:
        r120 = "";
        goto L58
    L50:
        r117 = null;
        goto L51
    L47:
        r116 = r115;
    L42:
        if (r107 == null) goto L44;
        r115 = r107.C;
        goto L45
    L44:
        r115 = null;
    L38:
        r114 = "";
    L32:
        r112 = "";
    L26:
        r110 = "";
        goto L27
    L94:
        return;
    L14:
        r105 = null;
        goto L15
    L92:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget
    public final String Rq() {
        d r100 = (d) this.f248681b.f248670b;
        if (r100 == null) goto L6;
        String r101 = r100.f55412a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget
    public final String Sq() {
        d r100 = (d) this.f248681b.f248670b;
        if (r100 == null) goto L6;
        String r101 = r100.f55413b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final View getLayoutView() {
        return (View) this.f55389k.getValue();
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.view.f
    public final NestedChildRecyclerView ig() {
        NestedChildRecyclerView r100 = this.f55388j;
        if (r100 != null) goto L5;
    L6:
        GameDetailLynxCard r101 = this.f55387i;
        if (r101 == null) goto L15;
        NestedChildRecyclerView r102 = Yq(r101);
        this.f55388j = r102;
        if (r102 == null) goto L11;
        r102.removeOnScrollListener(this.f55391m);
    L11:
        NestedChildRecyclerView r103 = this.f55388j;
        if (r103 == null) goto L15;
        r103.addOnScrollListener(this.f55391m);
    L15:
        return this.f55388j;
    L5:
        if (r100.isAttachedToWindow() == true) goto L15;
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final boolean isMergeMode() {
        return Intrinsics.areEqual(((View) this.f55389k.getValue()).getClass(), FrameLayout.class);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final void Zm() {
        super.Zm();
        GameDetailLynxCard r100 = this.f55387i;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.android.gamecp.business.gamedetail.page.lynx.GameLynxTabWidgetV4$onScrollListener$1] */
    public GameLynxTabWidgetV4(Function1<? super PureWidget<d>, Unit> r100) {
        super(r100);
        this.f55389k = LazyKt.lazy(new GameLynxTabWidgetV4$lazyLoadLayoutView$2(this));
        this.f55390l = true;
        this.f55391m = new GameLynxTabWidgetV4$onScrollListener$1(this);
    }

    public final NestedChildRecyclerView Yq(ViewGroup r100) {
        if ((r100 instanceof NestedChildRecyclerView) == false) goto L7;
        NestedChildRecyclerView r101 = (NestedChildRecyclerView) r100;
        if (r101.isAttachedToWindow() == false) goto L7;
        return r101;
    L7:
        int r102 = r100.getChildCount();
        if (r102 > 0) goto L10;
        return null;
    L10:
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L23;
        View r104 = r100.getChildAt(r103);
        if ((r104 instanceof NestedChildRecyclerView) == false) goto L18;
        NestedChildRecyclerView r105 = (NestedChildRecyclerView) r104;
        if (r105.isAttachedToWindow() == false) goto L18;
        return r105;
    L18:
        if ((r104 instanceof ViewGroup) == false) goto L22;
        NestedChildRecyclerView r106 = Yq((ViewGroup) r104);
        if (r106 == null) goto L22;
        return r106;
    L22:
        r103 = r103 + 1;
        goto L11
    L23:
        return null;
    }
}
