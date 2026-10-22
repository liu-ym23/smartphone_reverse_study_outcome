package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailCommonButton;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/signup/BetaApplyButtonItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/signup/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BetaApplyButtonItemWidget extends BaseGameDetailWidget<d> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameDetailCommonButton f53791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f53792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f53793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53794r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f53795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f53796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f53797u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_detail_beta_apply_button_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        GameDetailCommonButton r100 = (GameDetailCommonButton) this.contentView.findViewById(R.id.btn_beta_apply);
        this.f53791o = r100;
        if (this.f53797u == false) goto L7;
        if (r100 == null) goto L8;
        r100.S5();
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
    }

    public static final Map dr(BetaApplyButtonItemWidget r100) {
        r100.getClass();
        dt.b r101 = (dt.b) r100.Kq(dt.e.f469988b);
        Pair[] r102 = new Pair[4];
        if (r100.f53792p == false) goto L5;
        String r103 = "signed_up";
    L6:
        r102[0] = TuplesKt.to("status", r103);
        r102[1] = TuplesKt.to("test_id", r100.f53793q);
        r102[2] = TuplesKt.to("is_fullscreen", r101.f469945c0);
        r102[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top");
        return MapsKt.mapOf(r102);
    L5:
        r103 = "sign_up";
        goto L6
    }

    public static final Map er(BetaApplyButtonItemWidget r100) {
        r100.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "gray"), TuplesKt.to("test_id", r100.f53793q), TuplesKt.to("is_fullscreen", ((dt.b) r100.Kq(dt.e.f469988b)).f469945c0), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top")});
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((d) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        fr((d) r100);
    }

    public final void fr(final d r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, BetaApplyButtonItemWidget$onUpdate$1.INSTANCE, new BetaApplyButtonItemWidget$onUpdate$2(this, r100));
        r.a.c(this, r100, BetaApplyButtonItemWidget$onUpdate$3.INSTANCE, new BetaApplyButtonItemWidget$onUpdate$4(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        fr((d) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((d) r101, "data");
    }

    public BetaApplyButtonItemWidget(boolean r100, boolean r101, h r102, Function1<? super PureWidget<d>, Unit> r103) {
        super(null, r103, null, 4);
        this.f53796t = r100;
        this.f53797u = r101;
        this.f53793q = "";
        this.f53795s = !p0.a();
    }
}
