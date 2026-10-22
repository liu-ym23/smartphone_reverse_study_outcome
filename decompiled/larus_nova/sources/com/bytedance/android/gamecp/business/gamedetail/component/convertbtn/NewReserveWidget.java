package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.NewReverseConfig;
import com.bytedance.android.gamecp.base.gamedetail.c0;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.o;
import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton2;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.s;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import dt.h;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/NewReserveWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewReserveWidget extends BaseGameDetailWidget<com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ReserveButton2 f53895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f53896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f53897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f53898r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f53899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public s0 f53900t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public s0 f53901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public s0 f53902v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public s0 f53903w;

    public static final class a {
    }

    static {
    }

    public NewReserveWidget() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_detail_new_reverse_button_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f53895o = (ReserveButton2) this.contentView.findViewById(R.id.btn_order);
        this.f53896p = this.contentView.findViewById(R.id.root_view);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        Disposable r100 = this.f53898r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f53898r;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public NewReserveWidget(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "itemLayoutStyle");
        super(null, null, null, 6);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        er((com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        er((com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a) r100);
    }

    public final void er(final com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, NewReserveWidget$onUpdate$1.INSTANCE, new NewReserveWidget$onUpdate$2(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        er((com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a r102 = (com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.a) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r100 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("reserve", r102.f53916j) == true) goto L7;
        return;
    L7:
        if (this.f53899s == true) goto L12;
        yr.c.a("NewReserveWidget", "auto reserve");
        ki(new o(!r102.f53908b, 0));
        this.f53899s = true;
        return;
    }

    public static final boolean dr(NewReserveWidget r100, boolean r101, ReserveButton2 r102) {
        r100.getClass();
        s0 r103 = r102.getConfig();
        if ((r103 instanceof NewReverseConfig) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L23;
        NewReverseConfig r104 = (NewReverseConfig) r103;
        if (r101 == false) goto L21;
        int r105 = com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.f55589d;
        Pair<com.bytedance.ies.sve_core.o<S>, Function1<s, Unit>> r106 = r100.Mq(com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.C0896a.a(), null);
        com.bytedance.ies.sve_core.o r107 = (com.bytedance.ies.sve_core.o) r106.component1();
        Function1<s, Unit> r108 = r106.component2();
        com.bytedance.android.gamecp.business.gamedetail.page.root.state.a r109 = (com.bytedance.android.gamecp.business.gamedetail.page.root.state.a) r107.b();
        if (r109 == null) goto L21;
        h r110 = r109.f55590a;
        if (r110 == null) goto L21;
        if (r110.f469991a != true) goto L21;
        com.bytedance.android.gamecp.business.gamedetail.page.root.state.a r111 = (com.bytedance.android.gamecp.business.gamedetail.page.root.state.a) r107.b();
        if (r111 == null) goto L21;
        if (r111.f55592c == true) goto L23;
    L21:
        if (r104.f51532a != NewReverseConfig.State.RESERVE) goto L23;
        return true;
    L23:
        return false;
    }
}
