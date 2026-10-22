package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n1 extends AbsCommonChainEventImpl<fi3.k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166680e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.k> c(Map<String, ? extends Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("index_name");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r100 == null) goto L12;
        Object r104 = r100.get("index_type");
    L14:
        if ((r104 instanceof String) == false) goto L17;
        r101 = r104;
    L17:
        String r105 = (String) r101;
        if (r103 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L30;
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        if (r105 != null) goto L29;
        r105 = "click";
    L29:
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(new fi3.k(r103, r105));
    L30:
        int r108 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("index_name is nil");
    L20:
        if (r103.length() == 0) goto L23;
        r106 = false;
        goto L24
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public n1(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("Index", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("Index", r100, r101);
        this.f166680e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.k r101, Function1 r102) {
        fi3.k r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 != null) goto L5;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        com.bytedance.kmp.ec.yata.chain.event.b r105 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "actionParams is null", null, null, 57);
    L9:
        r102.invoke(r105);
        return;
    L5:
        if (this.f166680e.t0(r103.f477278a, r103.f477279b, yp.a.c(r100), yp.a.a(r100)) == false) goto L7;
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r105 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L9
    L7:
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r105 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "targetAction is null", null, null, 57);
        goto L9
    }
}
