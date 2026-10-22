package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PiaRenderingExecuteResultModel;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "pia.rendering.execute")
public final class g1 extends e7.p<e7.o0, PiaRenderingExecuteResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.o0 r102 = (e7.o0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        finishWithFailure(new PiaMethod.Error("'url' can not be null!"));
        return;
    L11:
        Object r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        JsonObject r107 = r102.getContext();     // Catch: Throwable -> L20
        if (r107 == null) goto L17;
        Object r108 = com.bytedance.android.annie.util.h.f40059c.fromJson(r107, Map.class);     // Catch: Throwable -> L20
        if ((r108 instanceof Map) == false) goto L17;
        Map r109 = (Map) r108;     // Catch: Throwable -> L20
    L18:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r110) == true) goto L26;
        r105 = r110;
    L26:
        Map r111 = (Map) r105;
        c47.c r112 = com.bytedance.android.annie.pia.b.f39722a;
        e1 r113 = new e1(this);
        f1 r114 = new f1(this);
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r113, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r114, "reject");
        k47.d r115 = (k47.d) c47.b.b(k47.d.class);
        if (r115 != null) goto L30;
        r114.accept(new PiaMethod.Error("not implemented!"));
        return;
    L30:
        if (r111 != null) goto L32;
        Map r116 = new HashMap();
    L33:
        r115.a(r103, ILiveHybridMonitor.ContainerType.ANNIE, r116, r113, r114);
        return;
    L32:
        r116 = r111;
    L17:
        r109 = null;
    L20:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
