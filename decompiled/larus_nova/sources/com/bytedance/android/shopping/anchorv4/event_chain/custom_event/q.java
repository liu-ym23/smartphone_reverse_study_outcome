package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q extends AbsCommonChainEventImpl<Map<String, ? extends Object>> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<Map<String, ? extends Object>> c(Map<String, ? extends Object> r100) {
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(null);
    }

    public q(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("BtmEnterPage", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("BtmEnterPage", r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, Map<String, ? extends Object> r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        dm.a.a("PPDEmptyEvent").b(this.f545098a + " event processor is empty", null);
    }
}
