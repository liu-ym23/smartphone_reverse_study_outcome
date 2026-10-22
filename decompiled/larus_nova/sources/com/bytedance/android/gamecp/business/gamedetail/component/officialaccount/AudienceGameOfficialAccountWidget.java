package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.track.GameDetailTrackV2;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/AudienceGameOfficialAccountWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameOfficialAccountWidget extends BaseGameDetailWidget<com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f54690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f54691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f54692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f54693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f54694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a f54695t;

    public static final class a extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f54696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f54697b;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 1;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getClickTempExtraAttrs() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("is_followed", this.f54696a), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, this.f54697b)});
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getShowExtraAttrs() {
            return MapsKt.mapOf(TuplesKt.to("is_followed", this.f54696a));
        }

        public a() {
            this.f54696a = "0";
            this.f54697b = "";
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceGameOfficialAccountWidget f54698a;

        public b(AudienceGameOfficialAccountWidget r100) {
            this.f54698a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i r101 = new i(this.f54698a.context);
            if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r101);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r101);
            r101.show();
            DialogLancet.afterDialogShow(r101);
        }
    }

    public AudienceGameOfficialAccountWidget() {
        this(null);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_game_detail_officail_item;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f54690o = (Button) this.containerView.findViewById(R.id.btn_confirm);
        this.f54691p = (HSImageView) this.containerView.findViewById(R.id.iv_portrait);
        this.f54692q = (TextView) this.containerView.findViewById(R.id.tv_name);
        this.f54693r = (TextView) this.containerView.findViewById(R.id.tv_fans_num);
        this.f54694s = (ImageView) this.containerView.findViewById(R.id.iv_certification);
        ImageView r100 = (ImageView) this.containerView.findViewById(R.id.iv_question_mark);
        if (r100 == null) goto L6;
        r100.setOnClickListener(new b(this));
        return;
    }

    public AudienceGameOfficialAccountWidget(Function1<? super RecyclerViewItemWidget<com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a>, ? extends Object> r100) {
        super(null, r100, null, 4);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a) r100);
    }

    public final void dr(final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a r210) {
        Intrinsics.checkNotNullParameter(r210, SlcElement.KEY_PROPS);
        super.br(r210);
        Button r100 = this.f54690o;
        if (r100 == null) goto L29;
        String r101 = "1";
        if (this.f54695t != null) goto L18;
        a r102 = new a();
        this.f54695t = r102;
        if (Intrinsics.areEqual(r210.f54709g, Boolean.TRUE) == false) goto L10;
        String r103 = "1";
    L11:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f54696a = r103;
        a r104 = this.f54695t;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L14:
        String r105 = String.valueOf(r210.f54704b);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f54697b = r105;
        HashMap<String, String> r106 = GamecpTracker.f56755a;
        ViewGroup r110 = this.containerView;
        Map r111 = MapsKt.emptyMap();
        a r107 = this.f54695t;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L17:
        GamecpTracker.r(r110, "game_account_card", r111, r107, false, 112);
        GamecpTracker.r(r100, "follow", MapsKt.emptyMap(), new com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.b(this), false, 112);
        goto L18
    L10:
        r103 = "0";
    L18:
        a r108 = this.f54695t;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L22:
        if (Intrinsics.areEqual(r210.f54709g, Boolean.TRUE) == true) goto L25;
        r101 = "0";
    L25:
        r108.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r108.f54696a = r101;
        a r109 = this.f54695t;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L28:
        String r112 = String.valueOf(r210.f54704b);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r109.f54697b = r112;
    L29:
        r.a.c(this, r210, AudienceGameOfficialAccountWidget$onUpdate$1.INSTANCE, new AudienceGameOfficialAccountWidget$onUpdate$2(this, r210));
        r.a.c(this, r210, AudienceGameOfficialAccountWidget$onUpdate$3.INSTANCE, new AudienceGameOfficialAccountWidget$onUpdate$4(this, r210));
        r.a.c(this, r210, AudienceGameOfficialAccountWidget$onUpdate$5.INSTANCE, new AudienceGameOfficialAccountWidget$onUpdate$6(this));
        r.a.c(this, r210, AudienceGameOfficialAccountWidget$onUpdate$7.INSTANCE, new AudienceGameOfficialAccountWidget$onUpdate$8(this, r210));
        r.a.c(this, r210, AudienceGameOfficialAccountWidget$onUpdate$9.INSTANCE, new AudienceGameOfficialAccountWidget$onUpdate$10(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        dr((com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a) r101, "data");
        if (r100 == false) goto L12;
        Pair[] r102 = new Pair[1];
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a r103 = (com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.a) this.f248681b.f248670b;
        if (r103 == null) goto L9;
        String r104 = r103.f54704b;
        if (r104 == null) goto L9;
    L10:
        r102[0] = TuplesKt.to("official_account", r104);
        GameDetailTrackV2.h("livesdk_game_promote_user_promote_offical_show", MapsKt.mutableMapOf(r102), null);
        return;
    L9:
        r104 = null;
        goto L10
    }
}
