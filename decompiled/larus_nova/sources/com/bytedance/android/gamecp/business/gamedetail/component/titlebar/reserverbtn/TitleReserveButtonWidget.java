package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.reserverbtn;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig;
import com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.z0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/reserverbtn/TitleReserveButtonWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/reserverbtn/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleReserveButtonWidget extends BaseGameDetailWidget<b> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f55239t = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ReserveButton f55240o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f55241p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AudienceReverseUnsupportBtnConfig.a f55242q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AudienceReverseBtnConfig.a f55243r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f55244s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_title_reserve_btn;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        View r100 = this.contentView;
        if (r100 == null) goto L5;
        ReserveButton r101 = (ReserveButton) r100.findViewById(R.id.btn_promote_list_reverse);
    L6:
        this.f55240o = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        er((b) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        er((b) r100);
    }

    public final void er(final b r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, TitleReserveButtonWidget$onUpdate$1.INSTANCE, new TitleReserveButtonWidget$onUpdate$2(this));
        r.a.c(this, r100, TitleReserveButtonWidget$onUpdate$3.INSTANCE, new TitleReserveButtonWidget$onUpdate$4(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        er((b) r100);
    }

    public static final boolean dr(TitleReserveButtonWidget r100, ReserveButton r101) {
        r100.getClass();
        z0 r102 = r101.getConfig();
        if ((r102 instanceof AudienceReverseBtnConfig) == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L12;
        AudienceReverseBtnConfig.State r103 = ((AudienceReverseBtnConfig) r102).f51466a;
        if (r103 != AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE) goto L10;
    L11:
        return true;
    L10:
        if (r103 == AudienceReverseBtnConfig.State.RESERVE) goto L11;
    L12:
        return false;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((b) r101, "data");
    }

    public final void fr(boolean r100, boolean r101, AudienceReverseBtnConfig.a r102) {
        if (r101 == false) goto L14;
        if (r100 == false) goto L7;
        ReserveButton r103 = this.f55240o;
        if (r103 == null) goto L18;
        r103.setConfig(new AudienceReverseBtnConfig(AudienceReverseBtnConfig.State.CANCEL_RESERVE, r102));
        return;
    L18:
        return;
    L7:
        ReserveButton r104 = this.f55240o;
        if (r104 != null) goto L10;
        return;
    L10:
        if (this.f55244s == false) goto L12;
        AudienceReverseBtnConfig.State r105 = AudienceReverseBtnConfig.State.RESERVE;
    L13:
        r104.setConfig(new AudienceReverseBtnConfig(r105, r102));
        return;
    L12:
        r105 = AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE;
        goto L13
    L14:
        ReserveButton r106 = this.f55240o;
        if (r106 == null) goto L22;
        r106.setConfig(new AudienceReverseUnsupportBtnConfig(AudienceReverseUnsupportBtnConfig.Location.AUDIENCE_DETAIL_TITLE_BAR, this.f55242q));
        return;
    }

    public TitleReserveButtonWidget(AudienceReverseUnsupportBtnConfig.a r100, AudienceReverseBtnConfig.a r101, boolean r102, Function1<? super RecyclerViewItemWidget<b>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "unsupportBtnStyle");
        Intrinsics.checkNotNullParameter(r101, "uiStyle");
        super(null, r103, null, 4);
        this.f55242q = r100;
        this.f55243r = r101;
        this.f55244s = r102;
    }
}
