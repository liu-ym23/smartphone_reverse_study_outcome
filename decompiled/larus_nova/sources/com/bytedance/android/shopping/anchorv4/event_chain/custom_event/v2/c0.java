package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c0 extends AbsCommonChainEventImpl<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166611e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<Map<String, ? extends Object>> c(Map<String, ? extends Object> r100) {
        boolean r101 = true;
        Object r102 = null;
        if (Intrinsics.areEqual(this.f545098a, "HeadJump") == false) goto L25;
        if (r100 == null) goto L6;
        Object r103 = r100.get("url");
    L8:
        if ((r103 instanceof String) == true) goto L10;
        r103 = null;
    L10:
        String r104 = (String) r103;
        if (r104 != null) goto L13;
    L16:
        if (r101 == false) goto L19;
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("url is nil");
    L19:
        if (r100 == null) goto L21;
        r102 = r100.get("btm_fields");
    L21:
        if (r102 != null) goto L42;
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.c("btm_fields is nil", r100);
    L42:
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r100);
    L13:
        if (r104.length() == 0) goto L16;
        r101 = false;
        goto L16
    L6:
        r103 = null;
        goto L8
    L25:
        if (Intrinsics.areEqual(this.f545098a, "HeadTrack") == false) goto L42;
        if (r100 == null) goto L28;
        Object r108 = r100.get(ReportCardMonitorPlugin.EVENT_NAME);
    L30:
        if ((r108 instanceof String) == false) goto L33;
        r102 = r108;
    L33:
        String r109 = (String) r102;
        if (r109 != null) goto L36;
    L39:
        if (r101 == false) goto L42;
        int r110 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("event_name is nil");
    L36:
        if (r109.length() == 0) goto L39;
        r101 = false;
        goto L39
    L28:
        r108 = null;
        goto L30
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, Map<String, ? extends Object> r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        View r103 = yp.a.c(r100);
        j73.d r104 = this.f166611e;
        String r105 = this.f545098a;
        r104.a0(r103, r105, r101, r100.f251272e.f251305a);
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }

    public c0(String r100, com.bytedance.android.ecom.arch.slice.action.v r101, Context r102, j73.d r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "anchorV4VM");
        super(r100, r101, r102);
        this.f166611e = r103;
    }
}
