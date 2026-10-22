package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w0 extends AbsCommonChainEventImpl<fi3.z> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166726e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.z> c(Map<String, ? extends Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("slide_params");
    L7:
        if ((r102 instanceof Map) == false) goto L10;
        r101 = r102;
    L10:
        int r103 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(new fi3.z((Map) r101));
    L5:
        r102 = null;
        goto L7
    }

    public w0(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PDPRecommendGoodsScrollEvent", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PDPRecommendGoodsScrollEvent", r100, r101);
        this.f166726e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.z r101, Function1 r102) {
        fi3.z r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L6;
        Map<String, Object> r104 = r103.f477356a;
        if (r104 == null) goto L6;
    L7:
        Map r105 = MapsKt.plus(r104, TuplesKt.to("recommend_pro_num", 6));
        j73.h.a.a(this.f166726e, "store_recommend_slide", r105, true, null, 52);
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L6:
        r104 = MapsKt.emptyMap();
        goto L7
    }
}
