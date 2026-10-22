package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

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
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.w0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.p;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.ui.RoundRectLayout;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/OrderGameDetailInfoItemWidgetV2;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/j;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderGameDetailInfoItemWidgetV2 extends BaseGameDetailWidget<j> {
    public static final /* synthetic */ int Y = 0;
    public View A;
    public View B;
    public View C;
    public boolean D;
    public final boolean E;
    public ViewGroup F;
    public ViewGroup G;
    public View H;
    public HSImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View f54733J;
    public View K;
    public View L;
    public ImageView M;
    public FrameLayout N;
    public View O;
    public float P;
    public float Q;
    public final Integer R;
    public final Integer S;
    public View T;
    public View U;
    public final Function0<Unit> V;
    public boolean W;
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h X;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f54734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FlowLayout f54735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f54736q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f54737r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f54738s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f54739t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f54740u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HSImageView f54741v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HSImageView f54742w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f54743x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f54744y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f54745z;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderGameDetailInfoItemWidgetV2 f54746a;

        public a(OrderGameDetailInfoItemWidgetV2 r100) {
            this.f54746a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OrderGameDetailInfoItemWidgetV2 r101 = this.f54746a;
            if (r101.D == true) goto L6;
            r101.V.invoke();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderGameDetailInfoItemWidgetV2 f54747a;

        public b(OrderGameDetailInfoItemWidgetV2 r100) {
            this.f54747a = r100;
        }

        public final void a() {
            OrderGameDetailInfoItemWidgetV2 r100 = this.f54747a;
            FrameLayout r101 = (FrameLayout) r100.contentView.getRootView().findViewById(R.id.design_bottom_sheet);
            Integer r102 = null;
            if (r101 == null) goto L5;
            ViewGroup r103 = UtilityKotlinExtentionsKt.f(r101);
        L6:
            r100.F = r103;
            OrderGameDetailInfoItemWidgetV2 r104 = this.f54747a;
            if (r104.f54738s == true) goto L10;
            return;
        L10:
            if (r104.F == null) goto L43;
            int r105 = y0.b(44.0f);
            r104.Q = com.bytedance.android.gamecp.business.gamedetail.k.a() + r105;
            ViewGroup r106 = r104.F;
            Intrinsics.checkNotNull(r106);
            r104.P = r106.getHeight() - r104.Q;
            FrameLayout r107 = new FrameLayout(r104.context);
            r104.N = r107;
            r107.setY(r104.P);
            FrameLayout r108 = r104.N;
            Intrinsics.checkNotNull(r108);
            r108.setPadding(0, r105, 0, 0);
            r104.O = new View(r104.context);
            com.bytedance.android.gamecp.business.gamedetail.base.model.h r109 = r104.X;
            if (r109 == null) goto L19;
            com.bytedance.android.gamecp.business.gamedetail.base.model.j r110 = r109.c();
            if (r110 == null) goto L19;
            com.bytedance.android.gamecp.business.gamedetail.base.model.i r111 = r110.b();
            if (r111 == null) goto L19;
            int r112 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
            r102 = Integer.valueOf(r111.a(R.color.gamecp_color_0B1926));
        L19:
            if (r102 == null) goto L23;
            View r113 = r104.O;
            if (r113 == null) goto L26;
            r113.setBackgroundColor(r102.intValue());
        L26:
            RoundRectLayout r114 = new RoundRectLayout(r104.context);
            float r115 = y0.a(8.0f);
            float r116 = y0.a(8.0f);
            r114.f56940b = r115;
            r114.f56941c = r116;
            r114.f56942d = 0.0f;
            r114.f56943e = 0.0f;
            r114.invalidate();
            r114.addView(r104.O);
            FrameLayout r117 = r104.N;
            if (r117 == null) goto L29;
            r117.addView(r114);
        L29:
            ViewGroup r118 = r104.F;
            if (r118 == null) goto L33;
            r118.addView(r104.N, 0);
        L33:
            if (r104.f54737r == true) goto L37;
            FrameLayout r119 = r104.N;
            if (r119 == null) goto L37;
            r119.setVisibility(8);
        L37:
            ImageView r120 = new ImageView(r104.context);
            r104.M = r120;
            r120.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView r121 = r104.M;
            if (r121 == null) goto L41;
            r121.setImageResource(R.drawable.gamecp_game_detail_title_close_ic_v2);
            return;
        L41:
            return;
        L23:
            View r122 = r104.O;
            if (r122 == null) goto L26;
            r122.setBackgroundColor(0);
            goto L26
        L43:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_game_order_detail_widget_v2;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f54734o = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc);
        this.f54735p = (FlowLayout) this.contentView.findViewById(R.id.tags_container);
        this.f54736q = this.contentView.findViewById(R.id.cl_game_header_info_container);
        this.f54739t = this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_ly);
        this.f54741v = (HSImageView) this.contentView.findViewById(R.id.v_game_header_full_bg_atmosphere_img);
        this.f54740u = this.contentView.findViewById(R.id.v_game_header_full_bg);
        this.T = this.contentView.findViewById(R.id.v_game_header_half_gradient_bg);
        this.U = this.contentView.findViewById(R.id.v_game_header_full_gradient_bg);
        View r100 = this.contentView.findViewById(R.id.v_game_header_top_alpha_atmosphere);
        this.f54743x = r100;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new a(this));
    L5:
        this.f54742w = (HSImageView) this.contentView.findViewById(R.id.v_game_header_half_img);
        this.B = this.contentView.findViewById(R.id.v_game_header_half_shape);
        this.C = this.contentView.findViewById(R.id.v_game_header_half_shape_container);
        this.f54744y = this.contentView.findViewById(R.id.v_game_header_full_shape);
        this.f54745z = this.contentView.findViewById(R.id.v_game_header_full_shape_sub1);
        this.A = this.contentView.findViewById(R.id.v_game_header_full_shape_sub2);
        String r101 = null;
        ViewGroup r102 = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.gamecp_audience_head_anim_ly, null);
        this.G = r102;
        if (r102 == null) goto L8;
        View r103 = r102.findViewById(R.id.v_game_header_full_anim_bg);
    L9:
        this.H = r103;
        ViewGroup r104 = this.G;
        if (r104 == null) goto L12;
        HSImageView r105 = (HSImageView) r104.findViewById(R.id.v_game_header_full_anim_img);
    L13:
        this.I = r105;
        ViewGroup r106 = this.G;
        if (r106 == null) goto L16;
        View r107 = r106.findViewById(R.id.v_game_header_full_anim_shape_container);
    L17:
        this.f54733J = r107;
        ViewGroup r108 = this.G;
        if (r108 == null) goto L20;
        View r109 = r108.findViewById(R.id.v_game_header_full_anim_shape_sub1);
    L21:
        this.K = r109;
        ViewGroup r110 = this.G;
        if (r110 == null) goto L24;
        View r111 = r110.findViewById(R.id.v_game_header_full_anim_shape_sub2);
    L25:
        this.L = r111;
        HSImageView r112 = this.f54741v;
        if (r112 == null) goto L28;
        r112.post(new b(this));
    L28:
        HSImageView r113 = this.f54741v;
        if (r113 == null) goto L33;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L33;
        int r115 = r114.width;
    L34:
        ViewGroup.LayoutParams r116 = new ViewGroup.LayoutParams(r115, y0.b(150.0f));
        ViewGroup r117 = this.G;
        if (r117 == null) goto L37;
        r117.setLayoutParams(r116);
    L37:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r118 = this.X;
        if (r118 == null) goto L44;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r119 = r118.c();
        if (r119 == null) goto L44;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r120 = r119.b();
        if (r120 == null) goto L44;
        GameImageBundler r121 = r120.b();
    L45:
        if (r121 == null) goto L55;
        HSImageView r122 = this.f54741v;
        if (r122 == null) goto L49;
        int r123 = i0.f56003a;
        i0.a(r122, r121, null, r121.getThumbImageUrl());
    L49:
        HSImageView r124 = this.f54742w;
        if (r124 == null) goto L52;
        int r125 = i0.f56003a;
        i0.a(r124, r121, null, r121.getThumbImageUrl());
    L52:
        HSImageView r126 = this.I;
        if (r126 == null) goto L55;
        int r127 = i0.f56003a;
        i0.a(r126, r121, null, r121.getThumbImageUrl());
    L55:
        Integer r128 = this.R;
        if (r128 != null) goto L59;
    L60:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r129 = this.X;
        if (r129 == null) goto L67;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r130 = r129.c();
        if (r130 == null) goto L67;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r131 = r130.b();
        if (r131 == null) goto L67;
        GameImageBundler r132 = r131.b();
    L68:
        if (r132 == null) goto L115;
        HSImageView r133 = this.f54741v;
        if (r133 == null) goto L72;
        int r134 = i0.f56003a;
        i0.a(r133, r132, null, r132.getThumbImageUrl());
    L72:
        HSImageView r135 = this.f54742w;
        if (r135 == null) goto L75;
        int r136 = i0.f56003a;
        i0.a(r135, r132, null, r132.getThumbImageUrl());
    L75:
        HSImageView r137 = this.I;
        if (r137 == null) goto L115;
        int r138 = i0.f56003a;
        i0.a(r137, r132, null, r132.getThumbImageUrl());
    L115:
        if (this.f54738s == true) goto L128;
        ConstraintLayout.LayoutParams r139 = new ConstraintLayout.LayoutParams(-1, y0.b(44.0f));
        View r140 = this.f54743x;
        if (r140 == null) goto L119;
        r140.setLayoutParams(r139);
    L119:
        View r141 = this.f54739t;
        if (r141 == null) goto L122;
        UtilityKotlinExtentionsKt.h(r141);
    L122:
        View r142 = this.f54744y;
        if (r142 == null) goto L125;
        UtilityKotlinExtentionsKt.h(r142);
    L125:
        View r143 = this.C;
        if (r143 == null) goto L128;
        UtilityKotlinExtentionsKt.h(r143);
    L128:
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r144 = this.X;
        if (r144 == null) goto L135;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r145 = r144.c();
        if (r145 == null) goto L135;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r146 = r145.b();
        if (r146 == null) goto L135;
        int r147 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
        Integer r148 = Integer.valueOf(r146.a(R.color.gamecp_color_0B1926));
    L136:
        boolean r149 = false;
        if (r148 != null) goto L139;
    L196:
        dt.b r150 = (dt.b) Kq(dt.e.f469988b);
        if (r150 == null) goto L200;
        r101 = r150.f469945c0;
    L200:
        if (Intrinsics.areEqual(r101, "1") == true) goto L202;
    L204:
        er(r149);
        if (this.f54737r == true) goto L218;
        View r151 = this.f54743x;
        if (r151 == null) goto L209;
        UtilityKotlinExtentionsKt.h(r151);
    L209:
        View r152 = this.f54739t;
        if (r152 == null) goto L212;
        UtilityKotlinExtentionsKt.h(r152);
    L212:
        View r153 = this.f54740u;
        if (r153 == null) goto L215;
        UtilityKotlinExtentionsKt.h(r153);
    L215:
        View r154 = this.f54744y;
        if (r154 == null) goto L218;
        UtilityKotlinExtentionsKt.h(r154);
    L218:
        Ref.IntRef r155 = new Ref.IntRef();
        r155.element = 1;
        if (this.f54738s == false) goto L221;
        r155.element = 2;
    L221:
        View r156 = this.f54736q;
        if (r156 == null) goto L225;
        HashMap<String, String> r157 = GamecpTracker.f56755a;
        GamecpTracker.r(r156, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", Integer.valueOf(r155.element))), new e(this), false, 112);
        return;
    L225:
        return;
    L202:
        if (this.f54737r == false) goto L204;
        r149 = true;
        goto L204
    L139:
        if (this.f54738s == false) goto L155;
        GradientDrawable r158 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r148.intValue(), y0.c(R.color.transparent)});
        r158.setGradientType(0);
        View r159 = this.f54745z;
        if (r159 == null) goto L143;
        r159.setBackground(r158);
    L143:
        View r160 = this.K;
        if (r160 == null) goto L146;
        r160.setBackground(r158);
    L146:
        GradientDrawable.Orientation r161 = GradientDrawable.Orientation.BOTTOM_TOP;
        int r162 = com.bytedance.android.gamecp.common.utils.f.f57218a;
        GradientDrawable r163 = new GradientDrawable(r161, new int[]{com.bytedance.android.gamecp.common.utils.f.a(0.3f, r148.intValue()), y0.c(R.color.transparent)});
        r163.setGradientType(0);
        View r164 = this.A;
        if (r164 == null) goto L149;
        r164.setBackground(r163);
    L149:
        View r165 = this.L;
        if (r165 == null) goto L152;
        r165.setBackground(r163);
    L152:
        GradientDrawable r166 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r148.intValue(), com.bytedance.android.gamecp.common.utils.f.a(0.4f, r148.intValue())});
        r166.setGradientType(0);
        View r167 = this.B;
        if (r167 == null) goto L155;
        r167.setBackground(r166);
    L155:
        HSImageView r168 = this.f54741v;
        if (r168 == null) goto L158;
        r168.setBackgroundColor(r148.intValue());
    L158:
        View r169 = this.f54740u;
        if (r169 == null) goto L161;
        r169.setBackgroundColor(r148.intValue());
    L161:
        HSImageView r170 = this.f54742w;
        if (r170 == null) goto L164;
        r170.setBackgroundColor(r148.intValue());
    L164:
        HSImageView r171 = this.I;
        if (r171 == null) goto L167;
        r171.setBackgroundColor(r148.intValue());
    L167:
        View r172 = this.H;
        if (r172 == null) goto L170;
        r172.setBackgroundColor(r148.intValue());
    L170:
        View r173 = this.C;
        if (r173 == null) goto L173;
        r173.setBackgroundColor(r148.intValue());
    L173:
        Integer r174 = this.R;
        if (r174 == null) goto L196;
        if (r174.intValue() != 2) goto L196;
        float r175 = p.b(r148.intValue())[0];
        int r176 = p.a(r175, 0.5f, 0.35f);
        int r177 = p.a(r175, 0.6f, 0.46f);
        GradientDrawable r178 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r176, r177});
        r178.setGradientType(0);
        View r179 = this.T;
        if (r179 == null) goto L181;
        r179.setBackground(r178);
    L181:
        View r180 = this.T;
        if (r180 == null) goto L184;
        UtilityKotlinExtentionsKt.j(r180);
    L184:
        View r181 = this.U;
        if (r181 == null) goto L187;
        r181.setBackgroundColor(r177);
    L187:
        View r182 = this.U;
        if (r182 == null) goto L190;
        r182.setBackgroundColor(r177);
    L190:
        View r183 = this.f54740u;
        if (r183 == null) goto L193;
        r183.setBackgroundColor(r177);
    L193:
        HSImageView r184 = this.f54741v;
        if (r184 == null) goto L196;
        r184.setBackgroundColor(r177);
    L135:
        r148 = null;
    L67:
        r132 = null;
        goto L68
    L59:
        if (r128.intValue() != 3) goto L60;
        Integer r185 = this.R;
        if (r185 == null) goto L115;
        if (r185.intValue() != 3) goto L115;
        if (Build.VERSION.SDK_INT < 29) goto L115;
        if (this.S == null) goto L115;
        HSImageView r186 = this.f54741v;
        if (r186 == null) goto L90;
        r186.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_full);
    L90:
        HSImageView r187 = this.f54741v;
        if (r187 == null) goto L93;
        r187.setColorFilter(new BlendModeColorFilter(this.S.intValue(), BlendMode.COLOR));
    L93:
        HSImageView r188 = this.f54741v;
        if (r188 == null) goto L96;
        r188.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L96:
        HSImageView r189 = this.f54742w;
        if (r189 == null) goto L99;
        r189.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_half);
    L99:
        HSImageView r190 = this.f54742w;
        if (r190 == null) goto L102;
        r190.setColorFilter(new BlendModeColorFilter(this.S.intValue(), BlendMode.COLOR));
    L102:
        HSImageView r191 = this.f54742w;
        if (r191 == null) goto L105;
        r191.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L105:
        HSImageView r192 = this.I;
        if (r192 == null) goto L108;
        r192.setImageResource(R.drawable.gamecp_bg_game_detail_top_brand_full);
    L108:
        HSImageView r193 = this.I;
        if (r193 == null) goto L111;
        r193.setColorFilter(new BlendModeColorFilter(this.S.intValue(), BlendMode.COLOR));
    L111:
        HSImageView r194 = this.I;
        if (r194 == null) goto L115;
        r194.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L44:
        r121 = null;
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
        dr((j) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((j) r100);
    }

    public final void dr(j r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$1.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$2(this));
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$3.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$4(this));
        if (r100.f54791h == null) goto L6;
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$5.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$6(this));
    L8:
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$9.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$10(this));
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$11.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$12(this));
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$13.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$14(this));
        Wo(tt.b.C7771b.f547498a);
        return;
    L6:
        if (TextUtils.isEmpty(r100.f54790g) == true) goto L8;
        r.a.c(this, r100, OrderGameDetailInfoItemWidgetV2$onUpdate$7.INSTANCE, new OrderGameDetailInfoItemWidgetV2$onUpdate$8(this));
        goto L8
    }

    public final void er(boolean r100) {
        if (this.f54738s == true) goto L24;
        if (r100 == false) goto L8;
        View r101 = this.f54740u;
        if (r101 == null) goto L11;
        UtilityKotlinExtentionsKt.j(r101);
    L11:
        Integer r102 = this.R;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.intValue() != 2) goto L54;
        if (r100 == false) goto L20;
        View r103 = this.U;
        if (r103 == null) goto L55;
        UtilityKotlinExtentionsKt.j(r103);
        return;
    L55:
        return;
    L20:
        View r104 = this.U;
        if (r104 == null) goto L57;
        UtilityKotlinExtentionsKt.h(r104);
        return;
    L57:
        return;
    L54:
        return;
    L8:
        View r105 = this.f54740u;
        if (r105 == null) goto L11;
        UtilityKotlinExtentionsKt.h(r105);
        goto L11
    L24:
        View r106 = this.C;
        if (r106 == null) goto L27;
        UtilityKotlinExtentionsKt.j(r106);
    L27:
        View r107 = this.f54739t;
        if (r107 == null) goto L30;
        UtilityKotlinExtentionsKt.j(r107);
    L30:
        View r108 = this.f54744y;
        if (r108 == null) goto L34;
        UtilityKotlinExtentionsKt.j(r108);
    L34:
        if (r100 == false) goto L44;
        View r109 = this.C;
        if (r109 == null) goto L38;
        r109.setAlpha(0.0f);
    L38:
        HSImageView r110 = this.f54741v;
        if (r110 == null) goto L41;
        r110.setAlpha(1.0f);
    L41:
        View r111 = this.f54744y;
        if (r111 == null) goto L59;
        r111.setAlpha(1.0f);
        return;
    L59:
        return;
    L44:
        View r112 = this.C;
        if (r112 == null) goto L47;
        r112.setAlpha(1.0f);
    L47:
        HSImageView r113 = this.f54741v;
        if (r113 == null) goto L50;
        r113.setAlpha(0.0f);
    L50:
        View r114 = this.f54744y;
        if (r114 == null) goto L61;
        r114.setAlpha(0.0f);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((j) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((j) r101, "data");
    }

    public OrderGameDetailInfoItemWidgetV2(w0 r100, dt.b r101, com.bytedance.android.gamecp.business.gamedetail.base.model.h r102, Function1<? super RecyclerViewItemWidget<j>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        Integer r104 = null;
        super(null, r103, null, 4);
        this.X = r102;
        boolean r105 = true;
        this.f54737r = !p0.a();
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r106 = r102.c();
        if (r106 == null) goto L9;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r107 = r106.b();
        if (r107 == null) goto L9;
        if (r107.e() != true) goto L9;
        boolean r108 = true;
    L10:
        this.f54738s = r108;
        if (r101 != null) goto L13;
    L15:
        boolean r109 = false;
    L16:
        this.D = r109;
        if (r101 != null) goto L19;
    L21:
        r105 = false;
    L22:
        this.E = r105;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r110 = r102.c();
        if (r110 == null) goto L27;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r111 = r110.b();
        if (r111 == null) goto L27;
        Integer r112 = Integer.valueOf(r111.c());
    L28:
        this.R = r112;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r113 = r102.c();
        if (r113 == null) goto L33;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r114 = r113.b();
        if (r114 == null) goto L33;
        int r115 = com.bytedance.android.gamecp.business.gamedetail.base.model.i.f53488a;
        r104 = Integer.valueOf(r114.a(R.color.gamecp_color_0B1926));
    L33:
        this.S = r104;
        this.V = OrderGameDetailInfoItemWidgetV2$closeClickAction$1.INSTANCE;
        return;
    L27:
        r112 = null;
        goto L28
    L19:
        if (r101.d() != true) goto L21;
    L13:
        if (r101.c() != true) goto L15;
        r109 = true;
    L9:
        r108 = false;
        goto L10
    }
}
