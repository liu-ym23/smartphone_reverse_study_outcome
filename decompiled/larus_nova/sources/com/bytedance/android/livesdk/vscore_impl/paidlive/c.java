package com.bytedance.android.livesdk.vscore_impl.paidlive;

import android.content.Context;
import com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.ToolbarTicketSaleBehavior;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public c() {
    }

    public final ToolbarTicketSaleBehavior a(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return new ToolbarTicketSaleBehavior(r100, r101);
    }
}
