package com.bytedance.android.gamecp.business.gamedetail.page.root;

import android.view.Window;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ies.sve_core.PureWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/page/root/StatusBarWidgetV3;", "Lcom/bytedance/ies/sve_core/PureWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/page/root/s0;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StatusBarWidgetV3 extends PureWidget<s0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f55462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window f55463d;

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
    }

    public StatusBarWidgetV3(Window r100) {
        super(null);
        this.f55463d = r100;
        this.f55462c = !com.bytedance.android.gamecp.common.utils.p0.a();
    }

    @Override // com.bytedance.ies.sve_core.q
    public final void wj(com.bytedance.ies.sve_core.p r100) {
        final s0 r101 = (s0) r100;
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        com.bytedance.ies.sve_core.r.a.c(this, r101, StatusBarWidgetV3$onUpdate$1.INSTANCE, new StatusBarWidgetV3$onUpdate$2(this, r101));
    }
}
