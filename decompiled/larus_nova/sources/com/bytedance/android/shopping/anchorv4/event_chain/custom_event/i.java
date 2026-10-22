package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.slice.action.entity.LawHintParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verify.AuthUtils;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends AbsCommonChainEventImpl<LawHintParam> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166560e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<LawHintParam> c(Map<String, ? extends Object> r100) {
        LawHintParam.Companion.getClass();
        LawHintParam r101 = null;
        Long r102 = null;
        if (r100 == null) goto L11;
        Object r103 = r100.get(PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
        if ((r103 instanceof Double) == true) goto L7;
        r103 = null;
    L7:
        Double r104 = (Double) r103;
        if (r104 == null) goto L10;
        r102 = Long.valueOf((long) r104.doubleValue());
    L10:
        r101 = new LawHintParam(r102);
    L11:
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r101);
    }

    public i(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("PdpLawHint", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("PdpLawHint", r100, r101);
        this.f166560e = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(final EventContext r100, LawHintParam r101, final Function1 r102) {
        LawHintParam r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        int r104 = AuthUtils.f187163a;
        Context r105 = this.f166560e;
        if (r103 == null) goto L7;
        Long r106 = r103.getPromotionSource();
        if (r106 == null) goto L7;
        long r107 = r106.longValue();
    L8:
        AuthUtils.a(r105, r107, null, new PDPLawHintActionEvent$onHandle$1(this, r102, r100));
        return;
    L7:
        r107 = 0;
        goto L8
    }
}
