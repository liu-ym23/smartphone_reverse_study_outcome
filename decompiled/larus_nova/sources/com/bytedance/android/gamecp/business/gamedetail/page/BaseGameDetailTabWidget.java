package com.bytedance.android.gamecp.business.gamedetail.page;

import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailEmptyView;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailErrorView;
import com.bytedance.android.gamecp.business.gamedetail.view.f;
import com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorPagerItemWidget;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.ui.DouyinLoadingLayout;
import com.bytedance.android.gamecp.common.ui.LoadingStatusView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/page/BaseGameDetailTabWidget;", "Lcom/bytedance/ies/sve_core/p;", "P", "Lcom/bytedance/android/gamecp/business/monitor/widget/BaseMonitorPagerItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/view/f;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGameDetailTabWidget<P extends p> extends BaseMonitorPagerItemWidget<P> implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadingStatusView f55313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f55314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f55315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<PureWidget<P>, Unit> f55317h;

    public static final class a extends TrackRegisterStrategy {
        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 3;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final float getViewAppearRectLimit() {
            return 0.2f;
        }

        public a() {
        }
    }

    public BaseGameDetailTabWidget() {
        this(null);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Jq() {
    }

    @Override // com.bytedance.ies.viewpager.PagerItemWidget
    public void Nq() {
    }

    public abstract String Rq();

    public abstract String Sq();

    public final void Tq() {
        if (this.f55313d != null) goto L13;
        LoadingStatusView r100 = new LoadingStatusView(this.context);
        this.f55313d = r100;
        this.containerView.addView(r100, new ViewGroup.LayoutParams(-1, -1));
        if (GameCpTargetUtils.h() == false) goto L9;
        LoadingStatusView r101 = this.f55313d;
        if (r101 == null) goto L14;
        LoadingStatusView.a r102 = LoadingStatusView.a.a(this.context);
        r102.b(this.context.getResources().getDimensionPixelSize(R.dimen.gamecp_default_list_progressbar_size));
        r101.setBuilder(r102);
        return;
    L14:
        return;
    L9:
        LoadingStatusView r103 = this.f55313d;
        if (r103 == null) goto L16;
        LoadingStatusView.a r104 = LoadingStatusView.a.a(this.context);
        r104.f56938d = (GameDetailErrorView) this.f55315f.getValue();
        r104.f56937c = (GameDetailEmptyView) this.f55314e.getValue();
        r104.f56936b = new DouyinLoadingLayout(this.context);
        r103.setBuilder(r104);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public void Fq() {
        super.Fq();
        Function1<PureWidget<P>, Unit> r100 = this.f55317h;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseGameDetailTabWidget(Function1<? super PureWidget<P>, Unit> r100) {
        this.f55317h = r100;
        p0.a();
        this.f55314e = LazyKt.lazy(new BaseGameDetailTabWidget$emptyView$2(this));
        this.f55315f = LazyKt.lazy(new BaseGameDetailTabWidget$errorView$2(this));
    }

    @Override // com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorPagerItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void wq(P r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.wq(r100);
        if (this.f55316g == true) goto L6;
        HashMap<String, String> r101 = GamecpTracker.f56755a;
        GamecpTracker.r(this.contentView, Rq(), MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, Sq())), new a(), false, 112);
        this.f55316g = true;
        return;
    }

    public static void Wq(BaseGameDetailTabWidget r100, Integer r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L5;
        String r104 = "";
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = Integer.valueOf(y0.c(R.color.gamecp_game_80161823));
    L9:
        r100.Tq();
        if (r104 != null) goto L12;
    L18:
        if (r101 == null) goto L22;
        int r105 = r101.intValue();
        GameDetailErrorView r106 = (GameDetailErrorView) r100.f55315f.getValue();
        if (r106 == null) goto L22;
        r106.setMsgTextColor(r105);
    L22:
        LoadingStatusView r107 = r100.f55313d;
        if (r107 == null) goto L25;
        r107.a();
    L25:
        LoadingStatusView r108 = r100.f55313d;
        if (r108 == null) goto L28;
        UtilityKotlinExtentionsKt.j(r108);
    L28:
        LoadingStatusView r109 = r100.f55313d;
        if (r109 == null) goto L32;
        r109.c();
        return;
    L32:
        return;
    L12:
        if ((!StringsKt.isBlank(r104)) == false) goto L14;
        r103 = r104;
    L14:
        if (r103 == null) goto L18;
        GameDetailErrorView r110 = (GameDetailErrorView) r100.f55315f.getValue();
        if (r110 == null) goto L18;
        r110.setMsgText(r103);
        goto L18
    L5:
        r104 = null;
        goto L7
    }
}
