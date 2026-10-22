package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailDescListView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/AudienceGameDetailInfoWidgetV4;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/c;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameDetailInfoWidgetV4 extends BaseGameDetailWidget<c> {
    public static final /* synthetic */ int Y = 0;
    public HSImageView A;
    public HSImageView B;
    public View C;
    public final Lazy D;
    public TextView E;
    public final Lazy F;
    public View G;
    public FlowLayout H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public GameDetailDescListView f53577J;
    public final Lazy K;
    public final Lazy L;
    public View M;
    public TextView N;
    public TextView O;
    public TextView P;
    public final boolean Q;
    public boolean R;
    public float S;
    public float T;
    public boolean U;
    public View V;
    public View W;
    public final dt.b X;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f53578o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f53579p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f53580q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f53581r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f53582s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f53583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f53584u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HSImageView f53585v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f53586w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f53587x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f53588y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f53589z;

    public static final class a extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceGameDetailInfoWidgetV4 f53590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f53591b;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 3;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getShowExtraAttrs() {
            Pair[] r100 = new Pair[2];
            r100[0] = TuplesKt.to("is_fullscreen", this.f53591b);
            if (this.f53590a.U == false) goto L5;
            String r101 = "1";
        L6:
            r100[1] = TuplesKt.to("is_first_show", r101);
            Map<String, String> r102 = MapsKt.mapOf(r100);
            this.f53590a.U = false;
            return r102;
        L5:
            r101 = "0";
            goto L6
        }

        public a(AudienceGameDetailInfoWidgetV4 r100, String r101) {
            this.f53590a = r100;
            this.f53591b = r101;
        }
    }

    public AudienceGameDetailInfoWidgetV4() {
        throw null;
    }

    public final int dr() {
        return ((Number) this.f53582s.getValue()).intValue();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_header_template_v4;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        yr.c.e(this.f53578o, "Game_Head onMount");
        View r100 = this.contentView.findViewById(R.id.gamecp_detail_half_head_top_transparent);
        this.f53583t = r100;
        if (this.f53580q == false) goto L6;
        if (r100 == null) goto L6;
        com.bytedance.android.gamecp.common.utils.g0.d(r100, com.bytedance.android.gamecp.common.utils.y0.b(44.0f) + dr());
    L6:
        View r101 = this.f53583t;
        if (r101 == null) goto L9;
        r101.setOnClickListener(new a0(this));
    L9:
        View r102 = this.contentView.findViewById(R.id.gamecp_detail_head_container);
        this.f53584u = r102;
        if (r102 == null) goto L12;
        HashMap<String, String> r103 = GamecpTracker.f56755a;
        GamecpTracker.r(r102, "top_pic", MapsKt.emptyMap(), null, false, 120);
    L12:
        this.f53585v = (HSImageView) this.contentView.findViewById(R.id.gamecp_detail_header_icon);
        TextView r104 = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_name);
        this.f53587x = r104;
        if (r104 == null) goto L15;
        yt.o.a(r104, 500);
    L15:
        this.f53589z = this.contentView.findViewById(R.id.gamecp_detail_header_status);
        this.A = (HSImageView) this.contentView.findViewById(R.id.gamecp_detail_header_status_half);
        this.B = (HSImageView) this.contentView.findViewById(R.id.gamecp_detail_header_status_full);
        this.C = this.contentView.findViewById(R.id.gamecp_detail_header_official_account_container);
        ImageView r105 = (ImageView) this.contentView.findViewById(R.id.gamecp_detail_header_official_account_icon);
        this.E = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_official_account_text);
        this.G = this.contentView.findViewById(R.id.gamecp_detail_header_official_account_arrow);
        FlowLayout r106 = (FlowLayout) this.contentView.findViewById(R.id.gamecp_detail_header_tags);
        this.H = r106;
        if (r106 == null) goto L18;
        r106.setSingleLineLimitChildNumber(true);
    L18:
        FlowLayout r107 = this.H;
        if (r107 == null) goto L21;
        r107.setSingleLine(true);
    L21:
        this.I = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_desc);
        this.f53577J = (GameDetailDescListView) this.contentView.findViewById(R.id.gamecp_detail_header_desc_list);
        this.M = this.contentView.findViewById(R.id.gamecp_detail_header_score_container);
        this.N = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_score);
        this.O = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_score_text);
        this.P = (TextView) this.contentView.findViewById(R.id.gamecp_detail_header_comment_count);
        View r108 = null;
        if (this.f53581r == false) goto L47;
        TextView r109 = this.f53587x;
        if (r109 == null) goto L26;
        r109.setTextColor(-1);
    L26:
        TextView r110 = this.E;
        if (r110 == null) goto L29;
        r110.setTextColor(ColorProtector.parseColor("#E5FFFFFF"));
    L29:
        View r111 = this.G;
        if (r111 == null) goto L32;
        r111.setBackgroundResource(R.drawable.gamecp_ic_official_account_arrow);
    L32:
        View r112 = this.C;
        if (r112 == null) goto L37;
        Drawable r113 = r112.getBackground();
        if (r113 == null) goto L37;
        Drawable r114 = r113.mutate();
    L39:
        if ((r114 instanceof GradientDrawable) == true) goto L41;
        r114 = null;
    L41:
        GradientDrawable r115 = (GradientDrawable) r114;
        if (r115 == null) goto L44;
        r115.setColor(ColorProtector.parseColor("#26FFFFFF"));
    L44:
        TextView r116 = this.I;
        if (r116 == null) goto L47;
        r116.setTextColor(ColorProtector.parseColor("#E5FFFFFF"));
    L37:
        r114 = null;
    L47:
        View r117 = this.contentView;
        if (r117 == null) goto L50;
        View r118 = r117.findViewById(R.id.gamecp_detail_header_half_track_view);
    L51:
        this.V = r118;
        View r119 = this.contentView;
        if (r119 == null) goto L54;
        r108 = r119.findViewById(R.id.gamecp_detail_header_full_track_view);
    L54:
        this.W = r108;
        if (this.f53581r != true) goto L57;
        int r120 = 2;
    L58:
        er(this.V, r120, "0");
        er(this.W, r120, "1");
        if (this.Q == false) goto L73;
        FlowLayout r121 = this.H;
        if (r121 == null) goto L63;
        com.bytedance.android.gamecp.common.utils.g0.h(r121, 0);
    L63:
        FlowLayout r122 = this.H;
        if (r122 == null) goto L66;
        com.bytedance.android.gamecp.common.utils.g0.e(r122, 0);
    L66:
        TextView r123 = this.I;
        if (r123 == null) goto L69;
        com.bytedance.android.gamecp.common.utils.g0.h(r123, UtilityKotlinExtentionsKt.c(1));
    L69:
        TextView r124 = this.I;
        if (r124 == null) goto L74;
        com.bytedance.android.gamecp.common.utils.g0.e(r124, UtilityKotlinExtentionsKt.c(5));
        return;
    L74:
        return;
    L73:
        return;
    L57:
        r120 = 1;
        goto L58
    L50:
        r118 = null;
        goto L51
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((c) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(com.bytedance.android.gamecp.base.gamedetail.d0 r100) {
        fr((c) r100);
    }

    public final void fr(final c r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$1.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$2(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$3.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$4(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$5.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$6(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$7.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$8(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$9.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$10(this));
        FlowLayout r101 = this.H;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r101);
        if (r101.getChildCount() > 0) goto L7;
        FlowLayout r102 = this.H;
        Intrinsics.checkNotNull(r102);
        UtilityKotlinExtentionsKt.h(r102);
    L7:
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$11.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$12(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$13.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$14(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$15.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$16(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV4$onUpdate$17.INSTANCE, new AudienceGameDetailInfoWidgetV4$onUpdate$18(this));
        Wo(tt.b.C7771b.f547498a);
    }

    public final void gr(boolean r100) {
        if (r100 == false) goto L9;
        View r101 = this.V;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.h(r101);
    L6:
        View r102 = this.W;
        if (r102 == null) goto L16;
        UtilityKotlinExtentionsKt.j(r102);
        return;
    L16:
        return;
    L9:
        View r103 = this.W;
        if (r103 == null) goto L12;
        UtilityKotlinExtentionsKt.h(r103);
    L12:
        View r104 = this.V;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.j(r104);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        fr((c) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, com.bytedance.android.gamecp.base.gamedetail.d0 r101) {
        Intrinsics.checkNotNullParameter((c) r101, "data");
    }

    public AudienceGameDetailInfoWidgetV4(dt.b r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, com.bytedance.android.gamecp.base.gamedetail.k0 r102) {
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        super(null, null, null, 4);
        this.X = r100;
        this.f53578o = "GameDetailInfoWidgetV4";
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f53579p = r103;
        this.f53580q = !com.bytedance.android.gamecp.common.utils.p0.a();
        if (r101 == null) goto L17;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r104 = r101.c();
        if (r104 == null) goto L17;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r105 = r104.b();
        if (r105 == null) goto L17;
        if (r105.e() != true) goto L17;
        boolean r106 = true;
    L18:
        this.f53581r = r106;
        this.f53582s = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$statusBarHeight$2.INSTANCE);
        this.f53586w = LazyKt.lazy(new AudienceGameDetailInfoWidgetV4$mGameIconMarginAnim$2(this));
        this.f53588y = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$mGameNameAnimColor$2.INSTANCE);
        this.D = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$mGameOfficialAccountContainerAnimColor$2.INSTANCE);
        this.F = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$mGameOfficialAccountTextAnimColor$2.INSTANCE);
        this.K = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$mGameDescListTextAnimColor$2.INSTANCE);
        this.L = LazyKt.lazy(AudienceGameDetailInfoWidgetV4$mGameDescListLineAnimColor$2.INSTANCE);
        int r107 = com.bytedance.android.gamecp.common.utils.f0.f57219a;
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getFontScale();
        this.Q = false;
        this.S = -1.0f;
        this.T = -1.0f;
        this.U = true;
        return;
    L17:
        r106 = false;
        goto L18
    L5:
        if (r100.c() != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void er(View r100, int r101, String r110) {
        if (r100 == null) goto L5;
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.r(r100, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", Integer.valueOf(r101))), new a(this, r110), false, 112);
        return;
    }
}
