package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i4 extends e<j4, GetDiscussionsResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f63446a;

    public i4(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataCenter");
        this.f63446a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((j4) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f63446a.get("data_vs_room_topic_info_str") == null) goto L5;
        GetDiscussionsResultModel r102 = new GetDiscussionsResultModel();
        r102.a(GetDiscussionsResultModel.Code.Success);
        r102.b((String) this.f63446a.get("data_vs_room_topic_info_str"));
        finishWithResult(r102);
        return;
    L5:
        finishWithFailure();
    }
}
