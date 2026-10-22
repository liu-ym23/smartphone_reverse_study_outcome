package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/AudienceGameDetailInfoWidgetV2;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameDetailInfoWidgetV2 extends BaseGameDetailWidget<a> {
    public static final /* synthetic */ int H0 = 0;
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public boolean G;
    public final boolean H;
    public ViewGroup I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ViewGroup f53537J;
    public View K;
    public HSImageView L;
    public View M;
    public View N;
    public View O;
    public ImageView P;
    public FrameLayout Q;
    public View R;
    public float S;
    public float T;
    public final Integer U;
    public final Integer V;
    public View W;
    public View X;
    public final Function0<Unit> Y;
    public boolean Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final dt.b f53538k0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AudienceGamePromoteDetailViewModel f53539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f53540p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f53541p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f53542q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ConstraintLayout f53543r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HSImageView f53544s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f53545t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FlowLayout f53546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f53547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f53548w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f53549x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HSImageView f53550y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HSImageView f53551z;

    public AudienceGameDetailInfoWidgetV2() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_header_template_v2;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f53549x = this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_ly);
        this.f53550y = (HSImageView) this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_img);
        this.f53548w = this.contentView.findViewById(R.id.v_game_header_full_bg);
        this.W = this.contentView.findViewById(R.id.v_game_header_half_gradient_bg);
        this.X = this.contentView.findViewById(R.id.v_game_header_full_gradient_bg);
        View r100 = this.contentView.findViewById(R.id.v_game_header_top_alpha_atmosphere);
        this.A = r100;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new o(this));
    L5:
        this.f53551z = (HSImageView) this.contentView.findViewById(R.id.v_game_header_half_img);
        this.E = this.contentView.findViewById(R.id.v_game_header_half_shape);
        this.F = this.contentView.findViewById(R.id.v_game_header_half_shape_container);
        this.B = this.contentView.findViewById(R.id.v_game_header_full_shape);
        this.C = this.contentView.findViewById(R.id.v_game_header_full_shape_sub1);
        this.D = this.contentView.findViewById(R.id.v_game_header_full_shape_sub2);
        this.f53543r = (ConstraintLayout) this.contentView.findViewById(R.id.cl_game_header_info_container);
        this.f53544s = (HSImageView) this.contentView.findViewById(R.id.iv_game_header_icon);
        this.f53545t = (TextView) this.contentView.findViewById(R.id.tv_game_header_name);
        this.f53546u = (FlowLayout) this.contentView.findViewById(R.id.fl_game_tags_container);
        this.f53547v = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc);
        Integer r101 = null;
        ViewGroup r102 = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.gamecp_audience_head_anim_ly, null);
        this.f53537J = r102;
        if (r102 == null) goto L8;
        View r103 = r102.findViewById(R.id.v_game_header_full_anim_bg);
    L9:
        this.K = r103;
        ViewGroup r104 = this.f53537J;
        if (r104 == null) goto L12;
        HSImageView r105 = (HSImageView) r104.findViewById(R.id.v_game_header_full_anim_img);
    L13:
        this.L = r105;
        ViewGroup r106 = this.f53537J;
        if (r106 == null) goto L16;
        View r107 = r106.findViewById(R.id.v_game_header_full_anim_shape_container);
    L17:
        this.M = r107;
        ViewGroup r108 = this.f53537J;
        if (r108 == null) goto L20;
        View r109 = r108.findViewById(R.id.v_game_header_full_anim_shape_sub1);
    L21:
        this.N = r109;
        ViewGroup r110 = this.f53537J;
        if (r110 == null) goto L24;
        View r111 = r110.findViewById(R.id.v_game_header_full_anim_shape_sub2);
    L25:
        this.O = r111;
        HSImageView r112 = this.f53550y;
        if (r112 == null) goto L28;
        r112.post(new p(this));
    L28:
        HSImageView r113 = this.f53550y;
        if (r113 == null) goto L33;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L33;
        int r115 = r114.width;
    L34:
        ViewGroup.LayoutParams r116 = new ViewGroup.LayoutParams(r115, com.bytedance.android.gamecp.common.utils.y0.b(150.0f));
        ViewGroup r117 = this.f53537J;
        if (r117 == null) goto L37;
        r117.setLayoutParams(r116);
    L37:
        Integer r118 = this.U;
        if (r118 != null) goto L41;
    L42:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r119 = this.f53541p0;
        if (r119 == null) goto L49;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r120 = r119.c();
        if (r120 == null) goto L49;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r121 = r120.b();
        if (r121 == null) goto L49;
        GameImageBundler r122 = r121.b();
    L50:
        if (r122 == null) goto L97;
        HSImageView r123 = this.f53550y;
        if (r123 == null) goto L54;
        int r124 = com.bytedance.android.gamecp.business.i0.f56003a;
        com.bytedance.android.gamecp.business.i0.a(r123, r122, null, r122.getThumbImageUrl());
    L54:
        HSImageView r125 = this.f53551z;
        if (r125 == null) goto L57;
        int r126 = com.bytedance.android.gamecp.business.i0.f56003a;
        com.bytedance.android.gamecp.business.i0.a(r125, r122, null, r122.getThumbImageUrl());
    L57:
        HSImageView r127 = this.L;
        if (r127 == null) goto L97;
        int r128 = com.bytedance.android.gamecp.business.i0.f56003a;
        com.bytedance.android.gamecp.business.i0.a(r127, r122, null, r122.getThumbImageUrl());
    L97:
        if (this.f53542q == true) goto L110;
        ConstraintLayout.LayoutParams r129 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.gamecp.common.utils.y0.b(44.0f));
        View r130 = this.A;
        if (r130 == null) goto L101;
        r130.setLayoutParams(r129);
    L101:
        View r131 = this.f53549x;
        if (r131 == null) goto L104;
        UtilityKotlinExtentionsKt.h(r131);
    L104:
        View r132 = this.B;
        if (r132 == null) goto L107;
        UtilityKotlinExtentionsKt.h(r132);
    L107:
        View r133 = this.F;
        if (r133 == null) goto L110;
        UtilityKotlinExtentionsKt.h(r133);
    L110:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r134 = this.f53541p0;
        if (r134 == null) goto L117;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r135 = r134.c();
        if (r135 == null) goto L117;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r136 = r135.b();
        if (r136 == null) goto L117;
        int r137 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
        r101 = Integer.valueOf(r136.a(R.color.gamecp_color_0B1926));
    L117:
        boolean r138 = false;
        if (r101 != null) goto L120;
    L174:
        dt.b r139 = this.f53538k0;
        if (r139 != null) goto L177;
    L181:
        er(r138);
        if (this.f53540p == true) goto L195;
        View r140 = this.A;
        if (r140 == null) goto L186;
        UtilityKotlinExtentionsKt.h(r140);
    L186:
        View r141 = this.f53549x;
        if (r141 == null) goto L189;
        UtilityKotlinExtentionsKt.h(r141);
    L189:
        View r142 = this.f53548w;
        if (r142 == null) goto L192;
        UtilityKotlinExtentionsKt.h(r142);
    L192:
        View r143 = this.B;
        if (r143 == null) goto L195;
        UtilityKotlinExtentionsKt.h(r143);
    L195:
        Ref.IntRef r144 = new Ref.IntRef();
        r144.element = 1;
        if (this.f53542q == false) goto L198;
        r144.element = 2;
    L198:
        ConstraintLayout r145 = this.f53543r;
        if (r145 == null) goto L202;
        HashMap<String, String> r146 = GamecpTracker.f56755a;
        GamecpTracker.r(r145, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", Integer.valueOf(r144.element))), new q(this), false, 112);
        return;
    L202:
        return;
    L177:
        if (r139.c() != true) goto L181;
        if (this.f53540p == false) goto L181;
        r138 = true;
        goto L181
    L120:
        if (this.f53542q == false) goto L136;
        GradientDrawable r147 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r101.intValue(), com.bytedance.android.gamecp.common.utils.y0.c(R.color.transparent)});
        r147.setGradientType(0);
        View r148 = this.C;
        if (r148 == null) goto L124;
        r148.setBackground(r147);
    L124:
        View r149 = this.N;
        if (r149 == null) goto L127;
        r149.setBackground(r147);
    L127:
        GradientDrawable.Orientation r150 = GradientDrawable.Orientation.BOTTOM_TOP;
        int r151 = com.bytedance.android.gamecp.common.utils.f.f57218a;
        GradientDrawable r152 = new GradientDrawable(r150, new int[]{com.bytedance.android.gamecp.common.utils.f.a(0.3f, r101.intValue()), com.bytedance.android.gamecp.common.utils.y0.c(R.color.transparent)});
        r152.setGradientType(0);
        View r153 = this.D;
        if (r153 == null) goto L130;
        r153.setBackground(r152);
    L130:
        View r154 = this.O;
        if (r154 == null) goto L133;
        r154.setBackground(r152);
    L133:
        GradientDrawable r155 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r101.intValue(), com.bytedance.android.gamecp.common.utils.f.a(0.4f, r101.intValue())});
        r155.setGradientType(0);
        View r156 = this.E;
        if (r156 == null) goto L136;
        r156.setBackground(r155);
    L136:
        HSImageView r157 = this.f53550y;
        if (r157 == null) goto L139;
        r157.setBackgroundColor(r101.intValue());
    L139:
        View r158 = this.f53548w;
        if (r158 == null) goto L142;
        r158.setBackgroundColor(r101.intValue());
    L142:
        HSImageView r159 = this.f53551z;
        if (r159 == null) goto L145;
        r159.setBackgroundColor(r101.intValue());
    L145:
        HSImageView r160 = this.L;
        if (r160 == null) goto L148;
        r160.setBackgroundColor(r101.intValue());
    L148:
        View r161 = this.K;
        if (r161 == null) goto L151;
        r161.setBackgroundColor(r101.intValue());
    L151:
        View r162 = this.F;
        if (r162 == null) goto L154;
        r162.setBackgroundColor(r101.intValue());
    L154:
        Integer r163 = this.U;
        if (r163 == null) goto L174;
        if (r163.intValue() != 2) goto L174;
        float r164 = com.bytedance.android.gamecp.business.gamedetail.p.b(r101.intValue())[0];
        int r165 = com.bytedance.android.gamecp.business.gamedetail.p.a(r164, 0.5f, 0.35f);
        int r166 = com.bytedance.android.gamecp.business.gamedetail.p.a(r164, 0.6f, 0.46f);
        GradientDrawable r167 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r165, r166});
        r167.setGradientType(0);
        View r168 = this.W;
        if (r168 == null) goto L162;
        r168.setBackground(r167);
    L162:
        View r169 = this.W;
        if (r169 == null) goto L165;
        UtilityKotlinExtentionsKt.j(r169);
    L165:
        View r170 = this.X;
        if (r170 == null) goto L168;
        r170.setBackgroundColor(r166);
    L168:
        View r171 = this.f53548w;
        if (r171 == null) goto L171;
        r171.setBackgroundColor(r166);
    L171:
        HSImageView r172 = this.f53550y;
        if (r172 == null) goto L174;
        r172.setBackgroundColor(r166);
    L49:
        r122 = null;
        goto L50
    L41:
        if (r118.intValue() != 3) goto L42;
        Integer r173 = this.U;
        if (r173 == null) goto L97;
        if (r173.intValue() != 3) goto L97;
        if (Build.VERSION.SDK_INT < 29) goto L97;
        if (this.V == null) goto L97;
        HSImageView r174 = this.f53550y;
        if (r174 == null) goto L72;
        r174.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_full);
    L72:
        HSImageView r175 = this.f53550y;
        if (r175 == null) goto L75;
        r175.setColorFilter(new BlendModeColorFilter(this.V.intValue(), BlendMode.COLOR));
    L75:
        HSImageView r176 = this.f53550y;
        if (r176 == null) goto L78;
        r176.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L78:
        HSImageView r177 = this.f53551z;
        if (r177 == null) goto L81;
        r177.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_half);
    L81:
        HSImageView r178 = this.f53551z;
        if (r178 == null) goto L84;
        r178.setColorFilter(new BlendModeColorFilter(this.V.intValue(), BlendMode.COLOR));
    L84:
        HSImageView r179 = this.f53551z;
        if (r179 == null) goto L87;
        r179.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L87:
        HSImageView r180 = this.L;
        if (r180 == null) goto L90;
        r180.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_full);
    L90:
        HSImageView r181 = this.L;
        if (r181 == null) goto L93;
        r181.setColorFilter(new BlendModeColorFilter(this.V.intValue(), BlendMode.COLOR));
    L93:
        HSImageView r182 = this.L;
        if (r182 == null) goto L97;
        r182.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L33:
        r115 = -1;
        goto L34
    L24:
        r111 = null;
        goto L25
    L20:
        r109 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(com.bytedance.android.gamecp.base.gamedetail.d0 r100) {
        dr((a) r100);
    }

    public final void dr(final a r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        if (r100.f53645m == null) goto L6;
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$1.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$2(this));
    L8:
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$5.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$6(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$7.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$8(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$9.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$10(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$11.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$12(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$13.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$14(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdateStyleAtmosphere$1.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdateStyleAtmosphere$2(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdateStyleAtmosphere$3.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdateStyleAtmosphere$4(this));
        Wo(tt.b.C7771b.f547498a);
        return;
    L6:
        if (TextUtils.isEmpty(r100.f53644l) == true) goto L8;
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV2$onUpdate$3.INSTANCE, new AudienceGameDetailInfoWidgetV2$onUpdate$4(this));
        goto L8
    }

    public final void er(boolean r100) {
        if (this.f53542q == true) goto L24;
        if (r100 == false) goto L8;
        View r101 = this.f53548w;
        if (r101 == null) goto L11;
        UtilityKotlinExtentionsKt.j(r101);
    L11:
        Integer r102 = this.U;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.intValue() != 2) goto L54;
        if (r100 == false) goto L20;
        View r103 = this.X;
        if (r103 == null) goto L55;
        UtilityKotlinExtentionsKt.j(r103);
        return;
    L55:
        return;
    L20:
        View r104 = this.X;
        if (r104 == null) goto L57;
        UtilityKotlinExtentionsKt.h(r104);
        return;
    L57:
        return;
    L54:
        return;
    L8:
        View r105 = this.f53548w;
        if (r105 == null) goto L11;
        UtilityKotlinExtentionsKt.h(r105);
        goto L11
    L24:
        View r106 = this.F;
        if (r106 == null) goto L27;
        UtilityKotlinExtentionsKt.j(r106);
    L27:
        View r107 = this.f53549x;
        if (r107 == null) goto L30;
        UtilityKotlinExtentionsKt.j(r107);
    L30:
        View r108 = this.B;
        if (r108 == null) goto L34;
        UtilityKotlinExtentionsKt.j(r108);
    L34:
        if (r100 == false) goto L44;
        View r109 = this.F;
        if (r109 == null) goto L38;
        r109.setAlpha(0.0f);
    L38:
        View r110 = this.B;
        if (r110 == null) goto L41;
        r110.setAlpha(1.0f);
    L41:
        HSImageView r111 = this.f53550y;
        if (r111 == null) goto L59;
        r111.setAlpha(1.0f);
        return;
    L59:
        return;
    L44:
        View r112 = this.F;
        if (r112 == null) goto L47;
        r112.setAlpha(1.0f);
    L47:
        HSImageView r113 = this.f53550y;
        if (r113 == null) goto L50;
        r113.setAlpha(0.0f);
    L50:
        View r114 = this.B;
        if (r114 == null) goto L61;
        r114.setAlpha(0.0f);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, com.bytedance.android.gamecp.base.gamedetail.d0 r101) {
        Intrinsics.checkNotNullParameter((a) r101, "data");
    }

    public AudienceGameDetailInfoWidgetV2(dt.b r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, com.bytedance.android.gamecp.base.gamedetail.k0 r102) {
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        Integer r103 = null;
        super(null, null, null, 4);
        this.f53538k0 = r100;
        this.f53541p0 = r101;
        DataContext r104 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r104 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r104 = null;
    L5:
        this.f53539o = (AudienceGamePromoteDetailViewModel) r104;
        boolean r105 = true;
        this.f53540p = !com.bytedance.android.gamecp.common.utils.p0.a();
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r106 = r101.c();
        if (r106 == null) goto L12;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r107 = r106.b();
        if (r107 == null) goto L12;
        if (r107.e() != true) goto L12;
        boolean r108 = true;
    L13:
        this.f53542q = r108;
        if (r100 != null) goto L16;
    L18:
        boolean r109 = false;
    L19:
        this.G = r109;
        if (r100 != null) goto L22;
    L24:
        r105 = false;
    L25:
        this.H = r105;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r110 = r101.c();
        if (r110 == null) goto L30;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r111 = r110.b();
        if (r111 == null) goto L30;
        Integer r112 = Integer.valueOf(r111.c());
    L31:
        this.U = r112;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r113 = r101.c();
        if (r113 == null) goto L36;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r114 = r113.b();
        if (r114 == null) goto L36;
        int r115 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
        r103 = Integer.valueOf(r114.a(R.color.gamecp_color_0B1926));
    L36:
        this.V = r103;
        this.Y = AudienceGameDetailInfoWidgetV2$closeClickAction$1.INSTANCE;
        return;
    L30:
        r112 = null;
        goto L31
    L22:
        if (r100.d() != true) goto L24;
    L16:
        if (r100.c() != true) goto L18;
        r109 = true;
    L12:
        r108 = false;
        goto L13
    }
}
