package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import android.content.Context;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends AbsCommonChainEventImpl<Map<String, ? extends Object>> {
    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<Map<String, ? extends Object>> c(Map<String, ? extends Object> r100) {
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r100);
    }

    public f(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("PdpDelayAction", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("PdpDelayAction", r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, Map<String, ? extends Object> r101, Function1 r102) {
        Map<String, ? extends Object> r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        Object r105 = r103.get(VideoThumbInfo.KEY_INTERVAL);     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        String r106 = r105.toString();     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        Long r107 = Long.valueOf(CastLongProtector.parseLong(r106));     // Catch: Throwable -> L13
    L11:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == false) goto L18;
        r108 = null;
    L18:
        Long r109 = (Long) r108;
        if (r109 != null) goto L21;
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L21:
        Lazy r111 = UIUtils.f45548a;
        UIUtils.c().postDelayed(new e(r102), r109.longValue());
        return;
    L10:
        r107 = null;
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
