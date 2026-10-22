package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openEvaluationPublishView")
public final class v4 extends k0<w4, OpenEvaluationPublishViewResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57548a = 0;

    public static final class a {
    }

    static {
    }

    public v4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        final w4 r102 = (w4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        xr.f r104 = (xr.f) xr.s.a(xr.f.class);     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r104.q2(new Gson().toJson(r102), getCallContext().getContext(), new OpenEvaluationPublishViewMethod$invoke$$inlined$runCatching$lambda$1(this, r102));     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
