package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/AudienceGameDetailInfoWidgetV3;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/b;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameDetailInfoWidgetV3 extends BaseGameDetailWidget<b> {
    public static final /* synthetic */ int V1 = 0;
    public final Lazy A;
    public final Lazy B;
    public HSImageView C;
    public View D;
    public TextView E;
    public TextView F;
    public FlowLayout G;
    public View G1;
    public int H;
    public int H0;
    public View H1;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f53552J;
    public ConstraintLayout K;
    public TextView L;
    public int L0;
    public final Function0<Unit> L1;
    public ImageView M;
    public boolean M1;
    public TextView N;
    public TextView O;
    public int P;
    public boolean P0;
    public boolean P1;
    public View Q;
    public final dt.b Q1;
    public View R;
    public HSImageView S;
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h S1;
    public HSImageView T;
    public final com.bytedance.android.gamecp.base.gamedetail.l0 T1;
    public View U;
    public View V;
    public final boolean V0;
    public View W;
    public View X;
    public View Y;
    public View Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public ViewGroup f53553b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public ViewGroup f53554g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public View f53555h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public TextView f53556k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public HSImageView f53557k1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f53558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AudienceGamePromoteDetailViewModel f53559p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public TextView f53560p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public View f53561p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f53562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f53563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f53564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Integer f53565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f53566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f53567v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public View f53568v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f53569w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f53570x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public View f53571x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f53572y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public ImageView f53573y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f53574z;

    public static final class a extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceGameDetailInfoWidgetV3 f53575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f53576b;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 3;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getShowExtraAttrs() {
            Pair[] r100 = new Pair[2];
            r100[0] = TuplesKt.to("is_fullscreen", this.f53576b);
            if (this.f53575a.M1 == false) goto L5;
            String r101 = "1";
        L6:
            r100[1] = TuplesKt.to("is_first_show", r101);
            Map<String, String> r102 = MapsKt.mapOf(r100);
            this.f53575a.M1 = false;
            return r102;
        L5:
            r101 = "0";
            goto L6
        }

        public a(AudienceGameDetailInfoWidgetV3 r100, String r101) {
            this.f53575a = r100;
            this.f53576b = r101;
        }
    }

    public AudienceGameDetailInfoWidgetV3() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_header_template_v3;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        yr.c.e(this.f53558o, "Game_Head onMount");
        this.R = this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_ly);
        this.S = (HSImageView) this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_img);
        this.Q = this.contentView.findViewById(R.id.v_game_header_full_bg);
        this.G1 = this.contentView.findViewById(R.id.v_game_header_half_gradient_bg);
        this.H1 = this.contentView.findViewById(R.id.v_game_header_full_light_bg);
        View r100 = this.contentView.findViewById(R.id.v_game_header_top_alpha_atmosphere);
        this.U = r100;
        if (this.f53562q == false) goto L6;
        if (r100 == null) goto L6;
        com.bytedance.android.gamecp.common.utils.g0.d(r100, com.bytedance.android.gamecp.common.utils.y0.b(44.0f) + ((Number) this.B.getValue()).intValue());
    L6:
        View r101 = this.U;
        if (r101 == null) goto L9;
        r101.setOnClickListener(new u(this));
    L9:
        this.T = (HSImageView) this.contentView.findViewById(R.id.v_game_header_half_img);
        this.Y = this.contentView.findViewById(R.id.v_game_header_half_shape);
        this.Z = this.contentView.findViewById(R.id.v_game_header_half_shape_container);
        this.V = this.contentView.findViewById(R.id.v_game_header_full_shape);
        this.W = this.contentView.findViewById(R.id.v_game_header_full_shape_sub1);
        this.X = this.contentView.findViewById(R.id.v_game_header_full_shape_sub2);
        ConstraintLayout r102 = (ConstraintLayout) this.contentView.findViewById(R.id.cl_game_header_info_container);
        this.C = (HSImageView) this.contentView.findViewById(R.id.iv_game_header_icon);
        this.D = this.contentView.findViewById(R.id.iv_game_header_icon_frame);
        this.E = (TextView) this.contentView.findViewById(R.id.tv_game_header_name);
        this.F = (TextView) this.contentView.findViewById(R.id.mini_game_tag);
        this.G = (FlowLayout) this.contentView.findViewById(R.id.fl_game_tags_container);
        this.K = (ConstraintLayout) this.containerView.findViewById(R.id.official_account_container);
        this.L = (TextView) this.containerView.findViewById(R.id.tv_official_account);
        this.M = (ImageView) this.contentView.findViewById(R.id.official_account_arrow);
        this.N = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc);
        this.O = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc_2);
        this.f53556k0 = (TextView) this.contentView.findViewById(R.id.tv_score);
        this.f53560p0 = (TextView) this.contentView.findViewById(R.id.tv_comment_count);
        Integer r103 = null;
        ViewGroup r104 = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.gamecp_audience_head_anim_ly, null);
        this.f53554g1 = r104;
        if (r104 == null) goto L12;
        View r105 = r104.findViewById(R.id.v_game_header_full_anim_bg);
    L13:
        this.f53555h1 = r105;
        ViewGroup r106 = this.f53554g1;
        if (r106 == null) goto L16;
        HSImageView r107 = (HSImageView) r106.findViewById(R.id.v_game_header_full_anim_img);
    L17:
        this.f53557k1 = r107;
        ViewGroup r108 = this.f53554g1;
        if (r108 == null) goto L20;
        View r109 = r108.findViewById(R.id.v_game_header_full_anim_shape_container);
    L21:
        this.f53561p1 = r109;
        ViewGroup r110 = this.f53554g1;
        if (r110 == null) goto L24;
        View r111 = r110.findViewById(R.id.v_game_header_full_anim_shape_sub1);
    L25:
        this.f53568v1 = r111;
        ViewGroup r112 = this.f53554g1;
        if (r112 == null) goto L28;
        View r113 = r112.findViewById(R.id.v_game_header_full_anim_shape_sub2);
    L29:
        this.f53571x1 = r113;
        if (com.bytedance.android.gamecp.business.gamedetail.util.g.b() == false) goto L33;
        fu.j.f(this.C);
        fu.j.f(this.S);
        fu.j.f(this.T);
        fu.j.f(this.f53557k1);
    L33:
        com.bytedance.android.gamecp.base.gamedetail.l0 r114 = this.T1;
        if (r114 == null) goto L48;
        com.bytedance.android.gamecp.base.gamedetail.a1 r115 = r114.f51619a;
        if (r115 == null) goto L48;
        Window r116 = r115.f51543f;
        if (r116 == null) goto L48;
        View r117 = r116.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L44;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r118 = ThreadMethodProxy.currentThread();
        if (r118 == com.larus.home.impl.utils.c.f346341a) goto L44;
        com.larus.home.impl.utils.c.a(r118, "getDecorView");
    L44:
        if (r117 == null) goto L48;
        FrameLayout r119 = (FrameLayout) r117.findViewById(R.id.design_bottom_sheet);
        if (r119 == null) goto L48;
        ViewGroup r120 = UtilityKotlinExtentionsKt.f(r119);
    L49:
        this.f53553b1 = r120;
        if (this.f53563r == false) goto L55;
        ImageView r121 = new ImageView(this.context);
        this.f53573y1 = r121;
        r121.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView r122 = this.f53573y1;
        if (r122 == null) goto L55;
        r122.setImageResource(R.drawable.gamecp_game_detail_title_close_ic_v2);
    L55:
        HSImageView r123 = this.S;
        if (r123 == null) goto L60;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L60;
        int r125 = r124.width;
    L61:
        ViewGroup.LayoutParams r126 = new ViewGroup.LayoutParams(r125, -1);
        ViewGroup r127 = this.f53554g1;
        if (r127 == null) goto L64;
        r127.setLayoutParams(r126);
    L64:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r128 = this.S1;
        if (r128 == null) goto L71;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r129 = r128.c();
        if (r129 == null) goto L71;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r130 = r129.b();
        if (r130 == null) goto L71;
        GameImageBundler r131 = r130.b();
    L72:
        if (r131 == null) goto L83;
        HSImageView r132 = this.S;
        if (r132 == null) goto L76;
        int r133 = com.bytedance.android.gamecp.business.i0.f56003a;
        boolean r134 = fu.d.f478832a;
        com.bytedance.android.gamecp.business.i0.a(r132, r131, fu.d.d("dygame_tech_detail_header_image_load", dr(r131)), r131.getThumbImageUrl());
    L76:
        HSImageView r135 = this.T;
        if (r135 == null) goto L79;
        int r136 = com.bytedance.android.gamecp.business.i0.f56003a;
        com.bytedance.android.gamecp.business.i0.a(r135, r131, null, r131.getThumbImageUrl());
    L79:
        HSImageView r137 = this.f53557k1;
        if (r137 == null) goto L83;
        int r138 = com.bytedance.android.gamecp.business.i0.f56003a;
        com.bytedance.android.gamecp.business.i0.a(r137, r131, null, r131.getThumbImageUrl());
    L83:
        if (this.f53564s == false) goto L114;
        View r139 = this.D;
        if (r139 == null) goto L88;
        r139.setBackgroundResource(R.drawable.gamecp_game_detail_img_default_bg_12dp_frame);
    L88:
        TextView r140 = this.E;
        if (r140 == null) goto L91;
        r140.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black));
    L91:
        TextView r141 = this.F;
        if (r141 == null) goto L94;
        r141.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black_75));
    L94:
        TextView r142 = this.N;
        if (r142 == null) goto L97;
        r142.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black_60));
    L97:
        TextView r143 = this.O;
        if (r143 == null) goto L100;
        r143.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black_60));
    L100:
        this.P = R.drawable.gamecp_game_detail_right_arrow_icon_v3_light;
        TextView r144 = this.L;
        if (r144 == null) goto L103;
        r144.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black_60));
    L103:
        ConstraintLayout r145 = this.K;
        if (r145 == null) goto L106;
        r145.setBackgroundResource(R.drawable.gamecp_shape_bg_0d161823_corner_2);
    L106:
        ImageView r146 = this.M;
        if (r146 == null) goto L109;
        r146.setBackgroundResource(R.drawable.gamecp_ic_official_account_arrow_gray);
    L109:
        this.H = R.style.gamecp_anchor_game_detail_game_security_tag_new_v3_light;
        this.I = R.drawable.gamecp_icon_game_detail_security;
        this.f53552J = R.style.gamecp_anchor_game_detail_game_security_tag_new;
        TextView r147 = this.f53560p0;
        if (r147 == null) goto L112;
        r147.setTextColor(com.bytedance.android.gamecp.common.utils.y0.c(R.color.gamecp_text_black_60));
    L112:
        this.H0 = R.color.gamecp_red_FE2C55;
        this.L0 = R.color.gamecp_text_black_60;
    L114:
        if (this.f53563r == true) goto L127;
        ConstraintLayout.LayoutParams r148 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.gamecp.common.utils.y0.b(44.0f) + ((Number) this.B.getValue()).intValue());
        View r149 = this.U;
        if (r149 == null) goto L118;
        r149.setLayoutParams(r148);
    L118:
        View r150 = this.R;
        if (r150 == null) goto L121;
        UtilityKotlinExtentionsKt.h(r150);
    L121:
        View r151 = this.V;
        if (r151 == null) goto L124;
        UtilityKotlinExtentionsKt.h(r151);
    L124:
        View r152 = this.Z;
        if (r152 == null) goto L127;
        UtilityKotlinExtentionsKt.h(r152);
    L127:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r153 = this.S1;
        if (r153 == null) goto L134;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r154 = r153.c();
        if (r154 == null) goto L134;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r155 = r154.b();
        if (r155 == null) goto L134;
        int r156 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
        r103 = Integer.valueOf(r155.a(R.color.gamecp_color_0B1926));
    L134:
        boolean r157 = false;
        if (r103 == null) goto L172;
        if (this.f53563r == false) goto L153;
        GradientDrawable r158 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r103.intValue(), com.bytedance.android.gamecp.common.utils.y0.c(R.color.transparent)});
        r158.setGradientType(0);
        View r159 = this.W;
        if (r159 == null) goto L141;
        r159.setBackground(r158);
    L141:
        View r160 = this.f53568v1;
        if (r160 == null) goto L144;
        r160.setBackground(r158);
    L144:
        GradientDrawable.Orientation r161 = GradientDrawable.Orientation.BOTTOM_TOP;
        int r162 = com.bytedance.android.gamecp.common.utils.f.f57218a;
        GradientDrawable r163 = new GradientDrawable(r161, new int[]{com.bytedance.android.gamecp.common.utils.f.a(0.3f, r103.intValue()), com.bytedance.android.gamecp.common.utils.y0.c(R.color.transparent)});
        r163.setGradientType(0);
        View r164 = this.X;
        if (r164 == null) goto L147;
        r164.setBackground(r163);
    L147:
        View r165 = this.f53571x1;
        if (r165 == null) goto L150;
        r165.setBackground(r163);
    L150:
        GradientDrawable r166 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r103.intValue(), com.bytedance.android.gamecp.common.utils.f.a(0.4f, r103.intValue())});
        r166.setGradientType(0);
        View r167 = this.Y;
        if (r167 == null) goto L153;
        r167.setBackground(r166);
    L153:
        HSImageView r168 = this.S;
        if (r168 == null) goto L156;
        r168.setBackgroundColor(r103.intValue());
    L156:
        View r169 = this.Q;
        if (r169 == null) goto L159;
        r169.setBackgroundColor(r103.intValue());
    L159:
        HSImageView r170 = this.T;
        if (r170 == null) goto L162;
        r170.setBackgroundColor(r103.intValue());
    L162:
        HSImageView r171 = this.f53557k1;
        if (r171 == null) goto L165;
        r171.setBackgroundColor(r103.intValue());
    L165:
        View r172 = this.f53555h1;
        if (r172 == null) goto L168;
        r172.setBackgroundColor(r103.intValue());
    L168:
        View r173 = this.Z;
        if (r173 == null) goto L172;
        r173.setBackgroundColor(r103.intValue());
    L172:
        if (this.f53564s == false) goto L219;
        Integer r174 = this.f53565t;
        if (r174 != null) goto L177;
    L201:
        View r175 = this.G1;
        if (r175 == null) goto L204;
        r175.setBackground(com.bytedance.android.gamecp.common.utils.y0.e(R.drawable.gamecp_game_detail_header_bg_v3));
    L204:
        View r176 = this.G1;
        if (r176 == null) goto L207;
        UtilityKotlinExtentionsKt.j(r176);
    L207:
        View r177 = this.Z;
        if (r177 == null) goto L210;
        UtilityKotlinExtentionsKt.h(r177);
    L210:
        View r178 = this.Q;
        if (r178 == null) goto L213;
        UtilityKotlinExtentionsKt.h(r178);
    L213:
        HSImageView r179 = this.S;
        if (r179 == null) goto L216;
        r179.setBackground(com.bytedance.android.gamecp.common.utils.y0.e(R.drawable.gamecp_game_detail_header_bg_v3));
    L216:
        View r180 = this.H1;
        if (r180 == null) goto L219;
        r180.setBackground(com.bytedance.android.gamecp.common.utils.y0.e(R.drawable.gamecp_game_detail_header_bg_v3));
        goto L219
    L177:
        if (r174.intValue() != 1) goto L201;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r181 = this.S1;
        if (r181 == null) goto L185;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r182 = r181.c();
        if (r182 == null) goto L185;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r183 = r182.b();
        if (r183 == null) goto L185;
        int r184 = r183.a(R.color.white);
    L186:
        float[] r185 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        ShapeDrawable r186 = new ShapeDrawable(new RoundRectShape(r185, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r185));
        r186.getPaint().setColor(r184);
        View r187 = this.G1;
        if (r187 == null) goto L189;
        r187.setBackground(r186);
    L189:
        View r188 = this.G1;
        if (r188 == null) goto L192;
        UtilityKotlinExtentionsKt.j(r188);
    L192:
        View r189 = this.Z;
        if (r189 == null) goto L195;
        UtilityKotlinExtentionsKt.h(r189);
    L195:
        View r190 = this.Q;
        if (r190 == null) goto L198;
        UtilityKotlinExtentionsKt.h(r190);
    L198:
        View r191 = this.H1;
        if (r191 == null) goto L219;
        r191.setBackgroundColor(r184);
    L185:
        r184 = com.bytedance.android.gamecp.common.utils.y0.c(R.color.white);
    L219:
        dt.b r192 = this.Q1;
        if (r192 != null) goto L222;
    L226:
        gr(r157);
        if (this.f53562q == true) goto L240;
        View r193 = this.U;
        if (r193 == null) goto L231;
        UtilityKotlinExtentionsKt.h(r193);
    L231:
        View r194 = this.R;
        if (r194 == null) goto L234;
        UtilityKotlinExtentionsKt.h(r194);
    L234:
        View r195 = this.Q;
        if (r195 == null) goto L237;
        UtilityKotlinExtentionsKt.h(r195);
    L237:
        View r196 = this.V;
        if (r196 == null) goto L240;
        UtilityKotlinExtentionsKt.h(r196);
    L240:
        er(this.G1, 1, "0");
        er(this.H1, 1, "1");
        er(this.T, 2, "0");
        er(this.S, 2, "1");
        return;
    L222:
        if (r192.c() != true) goto L226;
        if (this.f53562q == false) goto L226;
        r157 = true;
    L71:
        r131 = null;
    L60:
        r125 = -1;
    L48:
        r120 = null;
        goto L49
    L28:
        r113 = null;
        goto L29
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
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((b) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(com.bytedance.android.gamecp.base.gamedetail.d0 r100) {
        fr((b) r100);
    }

    public final Map<String, String> dr(GameImageBundler r100) {
        Pair[] r101 = new Pair[4];
        dt.b r102 = this.Q1;
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.F;
        if (r104 == null) goto L6;
    L7:
        boolean r105 = false;
        r101[0] = TuplesKt.to("game_id", r104);
        dt.b r106 = this.Q1;
        if (r106 == null) goto L13;
        String r107 = r106.C;
        if (r107 == null) goto L13;
        r103 = r107;
    L13:
        r101[1] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r103);
        String r108 = "1";
        if (r100 == null) goto L23;
        String r109 = r100.getThumbImageUrl();
        if (r109 == null) goto L23;
        if (r109.length() <= 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 != true) goto L23;
        Object r111 = "1";
    L24:
        r101[2] = TuplesKt.to("has_thumb_image", r111);
        if (r100 == null) goto L33;
        String r112 = r100.getThumbHeifImageUrl();
        if (r112 == null) goto L33;
        if (r112.length() <= 0) goto L31;
        r105 = true;
    L31:
        if (r105 != true) goto L33;
    L34:
        r101[3] = TuplesKt.to("has_thumb_heif_image", r108);
        return MapsKt.mutableMapOf(r101);
    L33:
        r108 = "0";
        goto L34
    L20:
        r110 = false;
    L23:
        r111 = "0";
    L6:
        r104 = "";
        goto L7
    }

    public final void fr(final b r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r101 = r100.f53661m;
        if (r101 == null) goto L8;
        if ((!r101.isEmpty()) == false) goto L8;
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$1.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$2(this));
    L10:
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$5.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$6(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$7.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$8(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$9.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$10(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$11.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$12(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$13.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$14(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$15.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$16(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$17.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$18(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdateStyleAtmosphere$1.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdateStyleAtmosphere$2(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdateStyleAtmosphere$3.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdateStyleAtmosphere$4(this));
        Wo(tt.b.C7771b.f547498a);
        return;
    L8:
        if (TextUtils.isEmpty(r100.f53660l) == true) goto L10;
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidgetV3$onUpdate$3.INSTANCE, new AudienceGameDetailInfoWidgetV3$onUpdate$4(this));
        goto L10
    }

    public final void gr(boolean r100) {
        if (this.f53563r == false) goto L5;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r101 = this.S1;
        View r102 = this.Z;
        if (r102 == null) goto L31;
        UtilityKotlinExtentionsKt.j(r102);
    L31:
        View r103 = this.R;
        if (r103 == null) goto L34;
        UtilityKotlinExtentionsKt.j(r103);
    L34:
        View r104 = this.V;
        if (r104 == null) goto L38;
        UtilityKotlinExtentionsKt.j(r104);
    L38:
        if (r100 == false) goto L48;
        View r105 = this.Z;
        if (r105 == null) goto L42;
        r105.setAlpha(0.0f);
    L42:
        View r106 = this.V;
        if (r106 == null) goto L45;
        r106.setAlpha(1.0f);
    L45:
        HSImageView r107 = this.S;
        if (r107 == null) goto L64;
        r107.setAlpha(1.0f);
        return;
    L64:
        return;
    L48:
        View r108 = this.Z;
        if (r108 == null) goto L51;
        r108.setAlpha(1.0f);
    L51:
        HSImageView r109 = this.S;
        if (r109 == null) goto L54;
        r109.setAlpha(0.0f);
    L54:
        View r110 = this.V;
        if (r110 == null) goto L66;
        r110.setAlpha(0.0f);
        return;
    L66:
        return;
    L5:
        if (this.f53564s == false) goto L20;
        if (r100 == false) goto L13;
        View r111 = this.H1;
        if (r111 == null) goto L10;
        UtilityKotlinExtentionsKt.j(r111);
    L10:
        View r112 = this.G1;
        if (r112 == null) goto L58;
        UtilityKotlinExtentionsKt.h(r112);
        return;
    L58:
        return;
    L13:
        View r113 = this.H1;
        if (r113 == null) goto L16;
        UtilityKotlinExtentionsKt.h(r113);
    L16:
        View r114 = this.G1;
        if (r114 == null) goto L60;
        UtilityKotlinExtentionsKt.j(r114);
        return;
    L60:
        return;
    L20:
        if (r100 == false) goto L24;
        View r115 = this.Q;
        if (r115 == null) goto L61;
        UtilityKotlinExtentionsKt.j(r115);
        return;
    L61:
        return;
    L24:
        View r116 = this.Q;
        if (r116 == null) goto L63;
        UtilityKotlinExtentionsKt.h(r116);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        fr((b) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, com.bytedance.android.gamecp.base.gamedetail.d0 r101) {
        Intrinsics.checkNotNullParameter((b) r101, "data");
    }

    public final void er(View r100, int r101, String r110) {
        if (r100 == null) goto L5;
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.r(r100, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", Integer.valueOf(r101))), new a(this, r110), false, 112);
        return;
    }

    public AudienceGameDetailInfoWidgetV3(dt.b r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, com.bytedance.android.gamecp.base.gamedetail.k0 r102, com.bytedance.android.gamecp.base.gamedetail.l0 r103) {
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        Integer r104 = null;
        super(null, null, null, 4);
        this.Q1 = r100;
        this.S1 = r101;
        this.T1 = r103;
        this.f53558o = "GameDetailInfoWidgetV3";
        DataContext r105 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r105 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r105 = null;
    L5:
        this.f53559p = (AudienceGamePromoteDetailViewModel) r105;
        this.f53562q = !com.bytedance.android.gamecp.common.utils.p0.a();
        boolean r106 = false;
        if (r101 == null) goto L14;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r107 = r101.c();
        if (r107 == null) goto L14;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r108 = r107.b();
        if (r108 == null) goto L14;
        if (r108.e() != true) goto L14;
        boolean r109 = true;
    L15:
        this.f53563r = r109;
        if (r101 == null) goto L22;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r110 = r101.c();
        if (r110 == null) goto L22;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r111 = r110.b();
        if (r111 == null) goto L22;
        r111.d();
    L22:
        if (r101 == null) goto L28;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r112 = r101.c();
        if (r112 == null) goto L28;
        if (r112.i() != true) goto L28;
        boolean r113 = true;
    L29:
        this.f53564s = r113;
        if (r101 == null) goto L36;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r114 = r101.c();
        if (r114 == null) goto L36;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r115 = r114.b();
        if (r115 == null) goto L36;
        r104 = Integer.valueOf(r115.c());
    L36:
        this.f53565t = r104;
        this.f53566u = LazyKt.lazy(new AudienceGameDetailInfoWidgetV3$dialogBGHalf2FullScreenGradientColor$2(this));
        this.f53567v = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$titleHalf2FullScreenGradientColor$2.INSTANCE);
        this.f53569w = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$subTitleHalf2FullScreenGradientColor$2.INSTANCE);
        this.f53570x = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$shortAdditionalDescHalf2FullScreenGradientColor$2.INSTANCE);
        this.f53572y = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$officialAccountTextHalf2FullScreenGradientColor$2.INSTANCE);
        this.f53574z = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$officialAccountBgHalf2FullScreenGradientColor$2.INSTANCE);
        this.A = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$commentHalf2FullScreenGradientColor$2.INSTANCE);
        this.B = LazyKt.lazy(AudienceGameDetailInfoWidgetV3$statusBarHeight$2.INSTANCE);
        this.H = R.style.gamecp_anchor_game_detail_game_security_tag_new_v2;
        this.I = R.drawable.gamecp_icon_game_detail_security_v2;
        this.f53552J = R.style.gamecp_anchor_game_detail_game_security_tag_new_v2;
        this.P = R.drawable.gamecp_game_detail_right_arrow_icon_v2;
        this.H0 = R.color.gamecp_game_FFFFFF;
        this.L0 = R.color.gamecp_game_99FFFFFF;
        if (r100 != null) goto L39;
    L41:
        boolean r116 = false;
    L42:
        this.P0 = r116;
        if (r100 != null) goto L45;
    L47:
        this.V0 = r106;
        this.L1 = AudienceGameDetailInfoWidgetV3$closeClickAction$1.INSTANCE;
        this.M1 = true;
        return;
    L45:
        if (r100.d() != true) goto L47;
        r106 = true;
        goto L47
    L39:
        if (r100.c() != true) goto L41;
        r116 = true;
    L28:
        r113 = false;
    L14:
        r109 = false;
        goto L15
    }
}
