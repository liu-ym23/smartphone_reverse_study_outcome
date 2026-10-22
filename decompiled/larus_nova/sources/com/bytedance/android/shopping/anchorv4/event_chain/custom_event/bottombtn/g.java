package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.bottombtn;

import android.content.Context;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends AbsCommonChainEventImpl<SendClosePdpEventParam> {
    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<SendClosePdpEventParam> c(Map<String, ? extends Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(SendClosePdpEventParam.KEY_LYNX_URL);
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("lynx_url is empty");
    L19:
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        SendClosePdpEventParam.Companion.getClass();
        if (r100 == null) goto L27;
        Object r107 = r100.get(SendClosePdpEventParam.KEY_LYNX_URL);
        if ((r107 instanceof String) == false) goto L25;
        r101 = r107;
    L25:
        r101 = new SendClosePdpEventParam((String) r101);
    L27:
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r101);
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public g(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("SendClosePdpEvent", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("SendClosePdpEvent", r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, SendClosePdpEventParam r101, Function1 r102) {
        SendClosePdpEventParam r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        if (r103 == null) goto L6;
        String r105 = r103.getLynxUrl();     // Catch: Throwable -> L23
    L8:
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L17;
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L23
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "SendClosePdpEvent lynx_url is empty", null, null, 57));     // Catch: Throwable -> L23
    L21:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L31;
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "SendClosePdpEvent onFailure " + r109, null, null, 57));
        return;
    L31:
        return;
    L17:
        if (r103 == null) goto L19;
        String r111 = r103.getLynxUrl();     // Catch: Throwable -> L23
    L20:
        s0.a(new hl.e(r111));     // Catch: Throwable -> L23
        int r112 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L23
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));     // Catch: Throwable -> L23
        goto L21
    L19:
        r111 = null;
        goto L20
    L10:
        if (r105.length() == 0) goto L13;
        r106 = false;
        goto L14
    L6:
        r105 = null;
    L23:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
