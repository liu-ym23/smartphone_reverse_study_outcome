package com.bytedance.android.gamecp.business.dynamiccommon.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.network.NetWorkStatusCode;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailSkeletonViewV2;
import com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/dynamiccommon/widget/PageLoadingWidgetV2;", "Lcom/bytedance/android/gamecp/business/monitor/widget/BaseMonitorWidget;", "Lcom/bytedance/android/gamecp/business/dynamiccommon/widget/a;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageLoadingWidgetV2 extends BaseMonitorWidget<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f53144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f53145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GameDetailSkeletonViewV2 f53146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f53147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f53148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f53149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f53151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f53152l;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final View getLayoutView() {
        return (FrameLayout) this.f53144d.getValue();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final boolean isMergeMode() {
        if (this.containerView != null) goto L5;
        return false;
    L5:
        if (((FrameLayout) this.f53144d.getValue()) != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((FrameLayout) this.f53144d.getValue()).getClass(), this.containerView.getClass());
    }

    public PageLoadingWidgetV2() {
        this.f53144d = LazyKt.lazy(new PageLoadingWidgetV2$parentView$2(this));
        this.f53150j = NetWorkStatusCode.SUCCESS.getValue();
        this.f53151k = LazyKt.lazy(new PageLoadingWidgetV2$isFullScreen$2(this));
        this.f53152l = LazyKt.lazy(PageLoadingWidgetV2$isLandScape$2.INSTANCE);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        Wo(tt.b.c.f547499a);
    }

    @Override // com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorWidget, com.bytedance.ies.sve_core.q
    public final void wj(p r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        super.wj(r101);
        r.a.c(this, r101, PageLoadingWidgetV2$onUpdate$1.INSTANCE, new PageLoadingWidgetV2$onUpdate$2(this));
        r.a.c(this, r101, PageLoadingWidgetV2$onUpdate$3.INSTANCE, new PageLoadingWidgetV2$onUpdate$4(this));
    }
}
