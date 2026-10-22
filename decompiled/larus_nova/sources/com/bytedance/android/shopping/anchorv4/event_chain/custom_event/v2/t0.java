package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t0 extends AbsCommonChainEventImpl<fi3.x> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j73.d f166713f;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.x> c(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("params is null");
    L5:
        Object r102 = r100.get("preload_components");
        Object r103 = null;
        if ((r102 instanceof List) == true) goto L8;
        r102 = null;
    L8:
        List r104 = (List) r102;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("preload_components 为空");
    L18:
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        Object r108 = r100.get("preload_components");
        if ((r108 instanceof List) == false) goto L22;
        r103 = r108;
    L22:
        List r109 = (List) r103;
        if (r109 != null) goto L26;
        r109 = CollectionsKt.emptyList();
    L26:
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(new fi3.x(r109));
    L11:
        if (r104.isEmpty() == true) goto L14;
        r105 = false;
        goto L15
    }

    public t0(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PDPPreloadLynxCards", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PDPPreloadLynxCards", r100, r101);
        this.f166712e = r101;
        this.f166713f = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.x r101, Function1 r102) {
        fi3.x r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        j73.d r104 = this.f166713f;
        if (r103 == null) goto L5;
        List<String> r105 = r103.f477344a;
    L6:
        r104.R(r105, this.f166712e);
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r105 = null;
        goto L6
    }
}
