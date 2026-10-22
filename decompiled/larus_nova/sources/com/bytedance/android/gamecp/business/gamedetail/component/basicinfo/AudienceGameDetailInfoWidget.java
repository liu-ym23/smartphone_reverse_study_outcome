package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/AudienceGameDetailInfoWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameDetailInfoWidget extends BaseGameDetailWidget<a> {
    public static final /* synthetic */ int D = 0;
    public final dt.b A;
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h B;
    public final com.bytedance.android.gamecp.base.gamedetail.k0 C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AudienceGamePromoteDetailViewModel f53525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f53526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f53527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ConstraintLayout f53528r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HSImageView f53529s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f53530t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FlowLayout f53531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f53532v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f53533w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53534x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ShapeDrawable f53535y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Integer f53536z;

    public AudienceGameDetailInfoWidget() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_header_template;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f53527q = this.contentView.findViewById(R.id.v_game_header_full_bg);
        this.f53528r = (ConstraintLayout) this.contentView.findViewById(R.id.cl_game_header_info_container);
        this.f53529s = (HSImageView) this.contentView.findViewById(R.id.iv_game_header_icon);
        this.f53530t = (TextView) this.contentView.findViewById(R.id.tv_game_header_name);
        this.f53531u = (FlowLayout) this.contentView.findViewById(R.id.fl_game_tags_container);
        this.f53532v = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc);
        this.f53533w = this.contentView.findViewById(R.id.v_game_header_top_alpha);
        ConstraintLayout r100 = this.f53528r;
        if (r100 == null) goto L5;
        r100.setBackground(com.bytedance.android.gamecp.common.utils.y0.e(R.drawable.gamecp_transparent));
    L5:
        int r101 = this.C.f51611a;
        ConstraintLayout r102 = this.f53528r;
        if (r102 == null) goto L8;
        r102.setPadding(com.bytedance.android.gamecp.common.utils.y0.b(18.0f), r101, com.bytedance.android.gamecp.common.utils.y0.b(18.0f), 0);
    L8:
        View r103 = this.f53533w;
        if (r103 != null) goto L11;
    L15:
        View r104 = this.f53527q;
        if (r104 == null) goto L20;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L20;
        r105.height = this.C.f51614d;
    L20:
        dt.b r106 = this.A;
        if (r106 == null) goto L23;
        String r107 = r106.f469945c0;
    L25:
        if (Intrinsics.areEqual(r107, "1") == false) goto L29;
        View r108 = this.f53527q;
        if (r108 == null) goto L32;
        UtilityKotlinExtentionsKt.j(r108);
    L32:
        Integer r109 = this.f53536z;
        if (r109 != null) goto L36;
    L48:
        ConstraintLayout r110 = this.f53528r;
        if (r110 == null) goto L52;
        HashMap<String, String> r111 = GamecpTracker.f56755a;
        GamecpTracker.r(r110, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", 0)), new k(this), false, 112);
        return;
    L52:
        return;
    L36:
        if (r109.intValue() != 1) goto L48;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r112 = this.B;
        if (r112 == null) goto L44;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r113 = r112.c();
        if (r113 == null) goto L44;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r114 = r113.b();
        if (r114 == null) goto L44;
        int r115 = r114.a(R.color.white);
    L45:
        ConstraintLayout r116 = this.f53528r;
        if (r116 == null) goto L48;
        r116.post(new j(this, r115));
    L44:
        r115 = com.bytedance.android.gamecp.common.utils.y0.c(R.color.white);
        goto L45
    L29:
        View r117 = this.f53527q;
        if (r117 == null) goto L32;
        UtilityKotlinExtentionsKt.h(r117);
        goto L32
    L23:
        r107 = null;
        goto L25
    L11:
        if (this.C.f51613c == false) goto L13;
        int r118 = 0;
    L14:
        r103.setVisibility(r118);
        goto L15
    L13:
        r118 = 8;
        goto L14
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
        com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r101 = r100.f53645m;
        if (r101 == null) goto L29;
        if (TextUtils.isEmpty(r101.d()) == true) goto L41;
        TextView r102 = this.f53532v;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        TextView r103 = this.f53532v;
        if (r103 == null) goto L12;
        r103.setText(r101.d());
    L12:
        Long r104 = r101.a();
        if (r104 == null) goto L18;
        if (r104.longValue() == (-1)) goto L41;
    L18:
        if (TextUtils.isEmpty(r101.b()) == true) goto L41;
        TextView r105 = this.f53532v;
        if (r105 == null) goto L22;
        r105.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.gamecp_game_detail_right_arrow_icon_black, 0);
    L22:
        TextView r106 = this.f53532v;
        if (r106 == null) goto L25;
        r106.setCompoundDrawablePadding(com.bytedance.android.gamecp.common.utils.y0.b(4.0f));
    L25:
        TextView r107 = this.f53532v;
        if (r107 == null) goto L41;
        r107.setOnClickListener(new n(this, r101));
    L41:
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$1.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$2(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$3.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$4(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$5.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$6(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$7.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$8(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$9.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$10(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$11.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$12(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, AudienceGameDetailInfoWidget$onUpdate$13.INSTANCE, new AudienceGameDetailInfoWidget$onUpdate$14(this));
        Wo(tt.b.C7771b.f547498a);
        return;
    L29:
        if (TextUtils.isEmpty(r100.f53644l) == true) goto L41;
        String r108 = r100.f53644l;
        Intrinsics.checkNotNull(r108);
        if (r108.length() <= 0) goto L33;
        boolean r109 = true;
    L34:
        if (r109 == false) goto L41;
        TextView r110 = this.f53532v;
        if (r110 == null) goto L38;
        r110.setVisibility(0);
    L38:
        TextView r111 = this.f53532v;
        if (r111 == null) goto L41;
        r111.setText(r108);
        goto L41
    L33:
        r109 = false;
        goto L34
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, com.bytedance.android.gamecp.base.gamedetail.d0 r101) {
        Intrinsics.checkNotNullParameter((a) r101, "data");
    }

    public AudienceGameDetailInfoWidget(dt.b r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, com.bytedance.android.gamecp.base.gamedetail.k0 r102) {
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        Integer r103 = null;
        super(null, null, null, 4);
        this.A = r100;
        this.B = r101;
        this.C = r102;
        DataContext r104 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r104 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r104 = null;
    L5:
        this.f53525o = (AudienceGamePromoteDetailViewModel) r104;
        boolean r105 = true;
        this.f53526p = !com.bytedance.android.gamecp.common.utils.p0.a();
        if (r100 != null) goto L8;
    L10:
        r105 = false;
    L11:
        this.f53534x = r105;
        if (r101 == null) goto L18;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r106 = r101.c();
        if (r106 == null) goto L18;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r107 = r106.b();
        if (r107 == null) goto L18;
        r103 = Integer.valueOf(r107.c());
    L18:
        this.f53536z = r103;
        return;
    L8:
        if (r100.c() != true) goto L10;
        goto L10
    }
}
