package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p1 extends AbsCommonChainEventImpl<fi3.t0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t96.b f166689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j73.d f166690f;

    @Override // t96.a
    public final t96.b a() {
        return this.f166689e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.t0> c(Map<String, ? extends Object> r100) {
        fi3.t0 r101 = new fi3.t0();
        if (r100 == null) goto L12;
        Object r102 = r100.get("refresh_req_params");
        Object r103 = null;
        if ((r102 instanceof Map) == true) goto L7;
        r102 = null;
    L7:
        r101.f477323a = (Map) r102;
        Object r104 = r100.get("cancel_pre_task");
        if ((r104 instanceof Boolean) == false) goto L11;
        r103 = r104;
    L11:
        r101.f477324b = (Boolean) r103;
    L12:
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r101);
    }

    public p1(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("Refresh", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("Refresh", r100, r101);
        this.f166690f = r102;
        this.f166689e = new t96.b(true, CollectionsKt.listOf(new String[]{"incoming_data", "refresh_req_params"}), true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.t0 r101, final Function1 r102) {
        fi3.t0 r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L7;
        Boolean r104 = r103.f477324b;
        if (r104 == null) goto L7;
        boolean r105 = r104.booleanValue();
    L8:
        j73.d r106 = this.f166690f;
        if (r103 == null) goto L11;
        Map<String, ? extends Object> r107 = r103.f477323a;
    L12:
        r106.V(r107, null, r105, new RefreshPageActionEvent$onHandle$1(r102));
        return;
    L11:
        r107 = null;
    L7:
        r105 = false;
        goto L8
    }
}
