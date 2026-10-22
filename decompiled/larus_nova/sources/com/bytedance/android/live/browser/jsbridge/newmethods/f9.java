package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.NotifyClearMountDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "notifyClearMountData")
public final class f9 extends w20.a4<w20.wb, NotifyClearMountDataResultModel> {
    public f9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((w20.wb) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.widget.x0.b r102 = new com.bytedance.android.livesdk.widget.x0.b(r101.getContext(), 7);
        r102.m(R.string.ttlive_open_platform_unmount_message);
        r102.j(1, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_open_platform_cancel_button), new d9(this));
        r102.j(0, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_open_platform_confirm_button), new e9(this));
        r102.k(0, true);
        r102.setCornerRadius(16.0f);
        r102.n();
    }
}
