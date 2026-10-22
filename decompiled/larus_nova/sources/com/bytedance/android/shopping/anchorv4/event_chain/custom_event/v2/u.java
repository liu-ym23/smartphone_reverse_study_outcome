package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponentV2;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u extends AbsCommonChainEventImpl<fi3.e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j73.d f166716f;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.e> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.e.f477257c;
        fi3.e r102 = null;
        if (r100 != null) goto L32;
        Object r103 = null;
    L9:
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        Map r104 = (Map) r103;     // Catch: Throwable -> L5
        if (r104 == null) goto L16;
        ShareMeta r105 = (ShareMeta) com.bytedance.android.ec.core.utils.u0.b(com.bytedance.android.ec.hybrid.list.util.k.d(r104), ShareMeta.class);     // Catch: Throwable -> L5
    L17:
        if (r100 == null) goto L19;
        Object r106 = r100.get("location");
    L21:
        if ((r106 instanceof String) == true) goto L23;
        r106 = null;
    L23:
        String r107 = (String) r106;
        if (r107 != null) goto L26;
        r107 = "top";
    L26:
        if (r105 == null) goto L28;
        r102 = new fi3.e(r105, r107);
    L28:
        if (r102 != null) goto L30;
        int r108 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("share meta is null");
    L30:
        int r109 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r102);
    L19:
        r106 = null;
    L5:
        th = move-exception;
        ECExceptionMonitor.e(th);
    L16:
        r105 = null;
        goto L17
    L32:
        r103 = r100.get("meta");     // Catch: Throwable -> L5
        goto L9
    }

    public u(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PdpClickShare", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PdpClickShare", r100, r101);
        this.f166715e = r101;
        this.f166716f = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.e r110, Function1 r111) {
        fi3.e r112 = r110;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r111, "completion");
        if (this.f166716f != null) goto L5;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        com.bytedance.kmp.ec.yata.chain.event.b r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPClickShareActionEvent anchorV4VM is null", null, null, 57);
    L20:
        r111.invoke(r102);
        return;
    L5:
        if (r112 == null) goto L19;
        ShareMeta r103 = r112.f477258a;
        if (r103 == null) goto L19;
        View r104 = yp.a.c(r100);
        if (r104 != null) goto L12;
        r104 = new View(this.f166715e);
    L12:
        View r105 = r104;
        r103.fillCommonMeta(this.f166716f.a());
        Object r106 = r100.f251272e.f251305a.get("location");
        if ((r106 instanceof String) == true) goto L15;
        r106 = null;
    L15:
        String r107 = (String) r106;
        if (r107 != null) goto L18;
        r107 = r112.f477259b;
    L18:
        new ShareComponentV2(new t(this), r105, r103, r107, null, 1).a();
        int r108 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L19:
        int r109 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPClickShareActionEvent meta is null", null, null, 57);
        goto L20
    }
}
