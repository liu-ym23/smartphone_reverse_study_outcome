package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig;
import com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig;
import com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig;
import com.bytedance.android.gamecp.base.gamedetail.ItemViewLayoutStyle;
import com.bytedance.android.gamecp.base.gamedetail.c0;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.z0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.s;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbutton/GameOrderButtonItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbutton/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameOrderButtonItemWidget extends BaseGameDetailWidget<h> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ReserveButton f54804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f54805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f54806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f54807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f54808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f54809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f54810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AudienceReverseUnsupportBtnConfig.a f54811v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AudienceReverseBtnConfig.a f54812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AudienceReserveSmallBtnConfig.a f54813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c0 f54814y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f54815z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_detail_order_button_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f54804o = (ReserveButton) this.contentView.findViewById(R.id.btn_order);
        this.f54805p = this.contentView.findViewById(R.id.root_view);
        ItemViewLayoutStyle r100 = this.f54814y.f51563a;
        if (r100 != ItemViewLayoutStyle.TwoButtonLayout) goto L5;
    L8:
        this.f54808s = 0;
        ReserveButton r101 = this.f54804o;
        if (r101 == null) goto L11;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L12:
        if (r102 == null) goto L27;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r103).leftMargin = 0;
        r103.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = 0;
        r103.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = 0;
        ReserveButton r104 = this.f54804o;
        if (r104 == null) goto L17;
        r104.setLayoutParams(r103);
    L17:
        if (this.f54815z == false) goto L28;
        ReserveButton r105 = this.f54804o;
        if (r105 == null) goto L29;
        TextView r106 = r105.f55734b;
        if (r106 == null) goto L30;
        TextPaint r107 = r106.getPaint();
        if (r107 == null) goto L31;
        r107.setFakeBoldText(true);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        r102 = null;
        goto L12
    L5:
        if (r100 == ItemViewLayoutStyle.InRowTwoButton) goto L8;
        if (r100 != ItemViewLayoutStyle.InRowSingleButton) goto L17;
        goto L8
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        Disposable r100 = this.f54807r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f54807r;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((h) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        fr((h) r100);
    }

    public final void fr(final h r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        com.bytedance.ies.sve_core.r.a.c(this, r100, GameOrderButtonItemWidget$onUpdate$1.INSTANCE, new GameOrderButtonItemWidget$onUpdate$2(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, GameOrderButtonItemWidget$onUpdate$3.INSTANCE, new GameOrderButtonItemWidget$onUpdate$4(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, GameOrderButtonItemWidget$onUpdate$5.INSTANCE, new GameOrderButtonItemWidget$onUpdate$6(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, GameOrderButtonItemWidget$onUpdate$7.INSTANCE, new GameOrderButtonItemWidget$onUpdate$8(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, GameOrderButtonItemWidget$onUpdate$9.INSTANCE, new GameOrderButtonItemWidget$onUpdate$10(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        fr((h) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((h) r101, "data");
    }

    public static final boolean dr(GameOrderButtonItemWidget r100, boolean r101, ReserveButton r102) {
        r100.getClass();
        z0 r103 = r102.getConfig();
        if ((r103 instanceof AudienceReverseBtnConfig) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L25;
        AudienceReverseBtnConfig r104 = (AudienceReverseBtnConfig) r103;
        if (r101 == false) goto L20;
        int r105 = com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.f55589d;
        Pair<com.bytedance.ies.sve_core.o<S>, Function1<s, Unit>> r106 = r100.Mq(com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.C0896a.a(), null);
        com.bytedance.ies.sve_core.o r107 = (com.bytedance.ies.sve_core.o) r106.component1();
        Function1<s, Unit> r108 = r106.component2();
        com.bytedance.android.gamecp.business.gamedetail.page.root.state.a r109 = (com.bytedance.android.gamecp.business.gamedetail.page.root.state.a) r107.b();
        if (r109 == null) goto L20;
        dt.h r110 = r109.f55590a;
        if (r110 == null) goto L20;
        if (r110.f469991a != true) goto L20;
        com.bytedance.android.gamecp.business.gamedetail.page.root.state.a r111 = (com.bytedance.android.gamecp.business.gamedetail.page.root.state.a) r107.b();
        if (r111 == null) goto L20;
        if (r111.f55592c != true) goto L20;
        return true;
    L20:
        AudienceReverseBtnConfig.State r112 = r104.f51466a;
        if (r112 != AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE) goto L23;
        return true;
    L23:
        if (r112 != AudienceReverseBtnConfig.State.RESERVE) goto L25;
        return true;
    L25:
        return false;
    }

    public static final void er(GameOrderButtonItemWidget r100, ReserveButton r101, boolean r102) {
        if (r101 != null) goto L4;
        r100.getClass();
        return;
    L4:
        if (r100.f54806q == true) goto L13;
        if (r102 == false) goto L8;
        HashMap<String, String> r103 = GamecpTracker.f56755a;
        GamecpTracker.r(r101, "book", MapsKt.emptyMap(), new i(r100, r101), true, 96);
    L9:
        r100.f54806q = true;
        return;
    L8:
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        GamecpTracker.r(r101, "book", MapsKt.mapOf(TuplesKt.to("status", "grayed")), new j(), true, 96);
        goto L9
    }

    public GameOrderButtonItemWidget(com.bytedance.android.gamecp.business.gamedetail.base.model.h r100, boolean r101, AudienceReverseUnsupportBtnConfig.a r102, AudienceReverseBtnConfig.b r103, AudienceReserveSmallBtnConfig.a r104, c0 r105, boolean r106, Function1 r110) {
        Intrinsics.checkNotNullParameter(r102, "unsupportBtnStyle");
        Intrinsics.checkNotNullParameter(r103, "orderButtonStyle");
        Intrinsics.checkNotNullParameter(r104, "orderSmallBtnStyle");
        Intrinsics.checkNotNullParameter(r105, "itemLayoutStyle");
        super(null, r110, null, 4);
        this.f54810u = r101;
        this.f54811v = r102;
        this.f54812w = r103;
        this.f54813x = r104;
        this.f54814y = r105;
        this.f54815z = r106;
        this.f54808s = y0.b(8.0f);
        this.f54809t = !p0.a();
        if (r100 == null) goto L10;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r107 = r100.c();
        if (r107 == null) goto L11;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r108 = r107.b();
        if (r108 == null) goto L12;
        r108.e();
        return;
    L12:
        return;
    L11:
        return;
    }
}
