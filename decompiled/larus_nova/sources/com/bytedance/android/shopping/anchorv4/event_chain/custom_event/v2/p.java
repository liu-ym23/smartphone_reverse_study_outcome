package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p extends AbsCommonChainEventImpl<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j73.d f166687f;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<Map<String, ? extends Object>> c(Map<String, ? extends Object> r100) {
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(null);
    }

    public p(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PdpClickCollect", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PdpClickCollect", r100, r101);
        this.f166686e = r101;
        this.f166687f = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r310, Map<String, ? extends Object> r311, Function1 r312) {
        Intrinsics.checkNotNullParameter(r310, "eventContext");
        Intrinsics.checkNotNullParameter(r312, "completion");
        CollectMeta r110 = new CollectMeta(0, null, null, null, null, null, false, null, null, null, null, 0, this.f166687f.u(), UnixStat.PERM_MASK, null).fillCommonMeta(this.f166687f.a());
        com.bytedance.android.shopping.anchorv4.bottom.x r111 = new com.bytedance.android.shopping.anchorv4.bottom.x(this.f166687f.p(), this.f166687f.isExpanded(), this.f166687f.compositeDisposable(), null);
        new com.bytedance.android.shopping.anchorv4.bottom.v(new n(this), this.f166686e, null, null, null, r110, r111, new o(this, r310)).a();
        int r100 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r312.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
