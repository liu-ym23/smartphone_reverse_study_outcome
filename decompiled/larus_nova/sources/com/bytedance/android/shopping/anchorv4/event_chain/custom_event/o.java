package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o extends AbsCommonChainEventImpl<jq.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t96.b f166567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v f166568f;

    @Override // t96.a
    public final t96.b a() {
        return this.f166567e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<jq.a> c(Map<String, ? extends Object> r100) {
        int r101 = jq.a.f500015a;
        jq.a r102 = jq.a.C6473a.a(r100);
        if (r102 == null) goto L5;
        String r103 = r102.f();
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("event name is nil");
    L15:
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r102);
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public o(v r100, Context r101) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_TRACKER, "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(com.bytedance.android.ec.core.event.a.KEY_TRACKER, r100, r101);
        this.f166568f = r100;
        this.f166567e = new t96.b(true, CollectionsKt.listOf("params"), true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, jq.a r101, Function1 r102) {
        jq.a r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L7;
        Map<String, Object> r104 = r100.f251272e.f251305a;
        HashMap r105 = new HashMap(r104.size() + 2);
        r105.putAll(r104);
        View r106 = yp.a.c(r100);
        this.f166568f.a(r103, r105, r106);
        return;
    }
}
