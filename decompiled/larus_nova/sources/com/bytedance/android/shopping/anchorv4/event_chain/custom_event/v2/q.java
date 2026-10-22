package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q extends AbsCommonChainEventImpl<fi3.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166691e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.f> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.f.f477261b;
        Object r102 = null;
        if (r100 == null) goto L10;
        Object r103 = r100.get("group_id");
        if ((r103 instanceof String) == false) goto L9;
        r102 = r103;
    L9:
        r102 = new fi3.f((String) r102);
    L10:
        if (r102 != null) goto L12;
        int r104 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("params is null");
    L12:
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r102);
    }

    public q(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PdpClickNavTab", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PdpClickNavTab", r100, r101);
        this.f166691e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.f r101, Function1 r102) {
        fi3.f r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L8;
        String r104 = r103.f477262a;
        if (r104 == null) goto L8;
        this.f166691e.C(r104);
        int r105 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L8:
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPClickNavTabActionEvent groupId is null", null, null, 57));
    }
}
