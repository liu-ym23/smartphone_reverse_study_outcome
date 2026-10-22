package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.bottombtn;

import android.content.Context;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.sdk.helper.m;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenMiniAppParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends AbsCommonChainEventImpl<PdpOpenMiniAppParam> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166554e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<PdpOpenMiniAppParam> c(Map<String, ? extends Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("small_app_url");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L12;
    L22:
        int r104 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("small_app_url is nil");
    L12:
        if (a2.d(r103) == null) goto L22;
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        PdpOpenMiniAppParam.Companion.getClass();
        if (r100 == null) goto L21;
        Object r106 = r100.get("small_app_url");
        if ((r106 instanceof String) == false) goto L19;
        r101 = r106;
    L19:
        r101 = new PdpOpenMiniAppParam((String) r101);
    L21:
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r101);
    L5:
        r102 = null;
        goto L7
    }

    public c(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("PdpOpenMiniApp", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("PdpOpenMiniApp", r100, r101);
        this.f166554e = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, PdpOpenMiniAppParam r101, Function1 r110) {
        PdpOpenMiniAppParam r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r110, "completion");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        m r104 = m.f48127a;     // Catch: Throwable -> L13
        Context r105 = this.f166554e;     // Catch: Throwable -> L13
        if (r102 == null) goto L6;
        String r106 = r102.getSmallAppUrl();     // Catch: Throwable -> L13
    L8:
        if (r104.a(r105, r106) == false) goto L10;
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L13
        r110.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));     // Catch: Throwable -> L13
    L11:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L21;
        AbsCommonChainEventImpl.g(this, "exception: " + r109.getMessage(), r100, "1004", 8);
        int r111 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r110.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PdpOpenMiniAppActionEvent exception: " + r109.getMessage(), null, null, 57));
        return;
    L21:
        return;
    L10:
        f("jump failed", r100, "1004", null);     // Catch: Throwable -> L13
        int r112 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L13
        r110.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PdpOpenMiniAppActionEvent jump failed", null, null, 57));     // Catch: Throwable -> L13
        goto L11
    L6:
        r106 = null;
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
