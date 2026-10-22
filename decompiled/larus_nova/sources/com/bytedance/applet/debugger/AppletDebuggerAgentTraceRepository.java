package com.bytedance.applet.debugger;

import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.b2;
import com.larus.platform.service.AccountService;
import com.larus.security.api.AzerothUtils;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletDebuggerAgentTraceRepository {

    public static final class a {
    }

    static {
    }

    public AppletDebuggerAgentTraceRepository() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r210, String r211, String r212, Continuation<? super e> r213) {
        if ((r213 instanceof AppletDebuggerAgentTraceRepository$fetch$1) == false) goto L7;
        AppletDebuggerAgentTraceRepository$fetch$1 r100 = (AppletDebuggerAgentTraceRepository$fetch$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Continuation r104 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
        String r111 = "AppletDebugAgentTrace";
        String r112 = ", msg=";
        r104 = r104;
    L53:
        dm9.a r105 = (dm9.a) r102;
        if ((r105 instanceof dm9.a.b) == false) goto L62;
        dm9.a.b r106 = (dm9.a.b) r105;
        if (r106.f469231a.isSuccess() == false) goto L60;
        e r113 = (e) r106.f469231a.getData();
        if (r113 != null) goto L80;
        FLogger.f375446a.w(r111, "get agent trace succeeded but data is empty");
        return r113;
    L80:
        return r113;
    L60:
        FLogger.f375446a.w(r111, "get agent trace failed, code=" + r106.f469231a.getCode() + r112 + r106.f469231a.getMsg());
    L65:
        return r104;
    L62:
        if ((r105 instanceof dm9.a.C5690a) == false) goto L67;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("get agent trace request failed, code=");
        dm9.a.C5690a r109 = (dm9.a.C5690a) r105;
        r108.append(r109.f469228a);
        r108.append(r112);
        r108.append(r109.f469229b);
        r107.e(r111, r108.toString(), r109.f469230c);
        goto L65
    L67:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r114 = (String) r100.L$1;
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r116 = r114;
    L36:
        dm9.a r117 = (dm9.a) r102;
        if ((r117 instanceof dm9.a.b) == false) goto L71;
        dm9.a.b r118 = (dm9.a.b) r117;
        if (r118.f469231a.isSuccess() == true) goto L42;
        FLogger.f375446a.w("AppletDebugAgentTrace", "save debug token failed, code=" + r118.f469231a.getCode() + ", msg=" + r118.f469231a.getMsg());
        return r104;
    L42:
        String r119 = AccountService.f365697a.getXTTToken();
        if (r119 == null) goto L68;
        boolean r120 = !StringsKt.isBlank(r119);
        String r121 = r119;
        if (r120 == true) goto L48;
        r121 = r104;
    L48:
        if (r121 == 0) goto L68;
        AppletDebuggerAgentTraceApi.a r122 = AppletDebuggerAgentTraceApi.f191692a;
        r100.L$0 = r104;
        r100.L$1 = r104;
        r100.label = 2;
        r122.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r102 = FlowHttpConnection.i(ServiceType.FIRST_PART, AppletDebuggerAgentTraceApi.class, new AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(r115, r116, r121, r104), "/app_developer/debugger/agent_trace", null, b2.f364870a.e(), r100, 96);
        if (r102 != r110) goto L53;
        return r110;
    L68:
        FLogger.f375446a.w(r111, "get agent trace skipped: X-Tt-Token is empty");
        return r104;
    L71:
        if ((r117 instanceof dm9.a.C5690a) == false) goto L75;
        FLogger r124 = FLogger.f375446a;
        StringBuilder r125 = new StringBuilder("save debug token request failed, code=");
        dm9.a.C5690a r126 = (dm9.a.C5690a) r117;
        r125.append(r126.f469228a);
        r125.append(r112);
        r125.append(r126.f469229b);
        r124.e(r111, r125.toString(), r126.f469230c);
        return r104;
    L75:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r102);
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L19
        AzerothUtils r128 = AzerothUtils.f367839a;     // Catch: Throwable -> L19
        Object r129 = Result.m9449constructorimpl(AzerothUtils.b(r210, r211, r212));     // Catch: Throwable -> L19
    L21:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L25;
        FLogger.f375446a.e("AppletDebugAgentTrace", "generate fornax token failed", r130);
        r129 = r104;
    L25:
        String r131 = (String) r129;
        if (r131 == null) goto L76;
        boolean r132 = !StringsKt.isBlank(r131);
        String r133 = r131;
        if (r132 == true) goto L31;
        r133 = r104;
    L31:
        if (r133 == 0) goto L76;
        r r134 = new r(CollectionsKt.listOf(new q(r210, r133)));
        AppletDebuggerAgentTraceApi.a r135 = AppletDebuggerAgentTraceApi.f191692a;
        r100.L$0 = r210;
        r100.L$1 = r133;
        r100.label = 1;
        r135.getClass();
        FlowHttpConnection r136 = FlowHttpConnection.f359975a;
        Object r137 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, AppletDebuggerAgentTraceApi.class, new AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2(r134, r104), true, "/alice/debug/save_token", null, null, r100, 224);
        if (r137 != r110) goto L35;
        return r110;
    L35:
        r116 = r133;
        r102 = r137;
        r115 = r210;
    L76:
        FLogger.f375446a.w("AppletDebugAgentTrace", "generate fornax token returned empty");
        return r104;
    L19:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new AppletDebuggerAgentTraceRepository$fetch$1(this, r213);
        goto L8
    }
}
