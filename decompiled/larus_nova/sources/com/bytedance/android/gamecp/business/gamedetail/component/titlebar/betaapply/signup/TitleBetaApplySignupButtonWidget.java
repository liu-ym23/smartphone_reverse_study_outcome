package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailCommonButton;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import dt.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/betaapply/signup/TitleBetaApplySignupButtonWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/betaapply/signup/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleBetaApplySignupButtonWidget extends BaseGameDetailWidget<com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameDetailCommonButton f55151o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f55152p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f55153q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f55154r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f55155s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f55156t;

    public static final class a {
    }

    static {
    }

    public TitleBetaApplySignupButtonWidget() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_title_beta_apply_sign_up_btn;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        GameDetailCommonButton r100 = (GameDetailCommonButton) this.contentView.findViewById(R.id.btn_beta_apply_sign_up);
        this.f55151o = r100;
        if (this.f55156t == false) goto L6;
        if (r100 == null) goto L6;
        r100.S5();
    L6:
        GameDetailCommonButton r101 = this.f55151o;
        if (r101 == null) goto L10;
        r101.setStrokeWidth(1.25f);
        return;
    }

    public static final Map dr(TitleBetaApplySignupButtonWidget r100) {
        r100.getClass();
        dt.b r101 = (dt.b) r100.Kq(e.f469988b);
        Pair[] r102 = new Pair[4];
        if (r100.f55152p == false) goto L5;
        String r103 = "signed_up";
    L6:
        r102[0] = TuplesKt.to("status", r103);
        r102[1] = TuplesKt.to("test_id", r100.f55153q);
        r102[2] = TuplesKt.to("is_fullscreen", r101.f469945c0);
        r102[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top_right");
        return MapsKt.mapOf(r102);
    L5:
        r103 = "sign_up";
        goto L6
    }

    public static final Map er(TitleBetaApplySignupButtonWidget r100) {
        r100.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "gray"), TuplesKt.to("test_id", r100.f55153q), TuplesKt.to("is_fullscreen", ((dt.b) r100.Kq(e.f469988b)).f469945c0), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top_right")});
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a) r100);
    }

    public final void fr(final com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, TitleBetaApplySignupButtonWidget$onUpdate$1.INSTANCE, new TitleBetaApplySignupButtonWidget$onUpdate$2(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        fr((com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a) r100);
    }

    public TitleBetaApplySignupButtonWidget(boolean r100, boolean r101) {
        super(null, null, null, 4);
        this.f55155s = r100;
        this.f55156t = r101;
        this.f55153q = "";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup.a) r101, "data");
    }
}
