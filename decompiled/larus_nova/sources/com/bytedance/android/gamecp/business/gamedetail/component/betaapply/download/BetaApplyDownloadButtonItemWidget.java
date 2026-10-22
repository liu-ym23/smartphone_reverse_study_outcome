package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download;

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
import dt.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/download/BetaApplyDownloadButtonItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/download/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BetaApplyDownloadButtonItemWidget extends BaseGameDetailWidget<com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f53763v = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameDetailCommonButton f53764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f53765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f53766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53767r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f53768s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f53769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f53770u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_detail_beta_apply_download_button_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        GameDetailCommonButton r100 = (GameDetailCommonButton) this.contentView.findViewById(R.id.btn_beta_apply_download);
        this.f53764o = r100;
        if (this.f53769t == false) goto L7;
        if (r100 == null) goto L8;
        r100.S5();
        return;
    L8:
        return;
    }

    public static final Map dr(BetaApplyDownloadButtonItemWidget r100) {
        r100.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("test_id", r100.f53765p), TuplesKt.to("is_fullscreen", ((dt.b) r100.Kq(e.f469988b)).f469945c0)});
    }

    public static final Map er(BetaApplyDownloadButtonItemWidget r100) {
        r100.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("test_id", r100.f53765p), TuplesKt.to("is_fullscreen", ((dt.b) r100.Kq(e.f469988b)).f469945c0)});
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a) r100);
    }

    public final void fr(final com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, BetaApplyDownloadButtonItemWidget$onUpdate$1.INSTANCE, new BetaApplyDownloadButtonItemWidget$onUpdate$2(this, r100));
        r.a.c(this, r100, BetaApplyDownloadButtonItemWidget$onUpdate$3.INSTANCE, new BetaApplyDownloadButtonItemWidget$onUpdate$4(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a r102 = (com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a) r101;
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_PROPS);
        if (r100 == true) goto L5;
        return;
    L5:
        if (r102.f53783h == false) goto L13;
        boolean r103 = r102.f53780e;
        if (r103 == true) goto L9;
        return;
    L9:
        if (this.f53767r == true) goto L15;
        Wo(new d(this.context, r102.f53778c, r102.f53782g, r103));
        this.f53767r = true;
        return;
    L15:
        return;
    }

    public BetaApplyDownloadButtonItemWidget(boolean r100, boolean r101, h r102, Function1<? super PureWidget<com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.a>, Unit> r103) {
        super(null, r103, null, 4);
        this.f53769t = r100;
        this.f53770u = r101;
        this.f53765p = "";
        this.f53768s = !p0.a();
    }
}
