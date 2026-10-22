package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "performXPlayPreCheck")
public final class m5 extends s0<l5, PerformXPlayPreCheckResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57527a = 0;

    public static final class a {
    }

    static {
    }

    public m5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        l5 r102 = (l5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r103 = r102.getType();
        String r104 = r102.b();
        Integer r105 = r102.a();
        boolean r106 = false;
        if (r105 == null) goto L5;
        int r107 = r105.intValue();
    L7:
        if (r104 != null) goto L9;
    L10:
        r106 = true;
    L11:
        if (r106 == false) goto L13;
        finishWithFailure();
        return;
    L13:
        PerformXPlayPreCheckResultModel r108 = new PerformXPlayPreCheckResultModel();
        r108.b(new PerformXPlayPreCheckResultModel.a());
        PerformXPlayPreCheckResultModel.a r109 = r108.a();
        if (r109 == null) goto L16;
        r109.setResult(new JsonObject());
    L16:
        if (r103 != null) goto L19;
    L21:
        if (r103 != null) goto L24;
    L28:
        if (r103 != null) goto L31;
    L35:
        finishWithFailure();
        return;
    L31:
        if (r103.intValue() != 3) goto L35;
        if (r107 != 0) goto L34;
        finishWithFailure();
    L34:
        com.bytedance.android.gamecp.host_api.a.b().getCloudGameService().p();
        return;
    L24:
        if (r103.intValue() != 2) goto L28;
        if (r107 != 0) goto L27;
        finishWithFailure();
    L27:
        com.bytedance.android.gamecp.host_api.a.b().getCloudGameService().p();
        return;
    L19:
        if (r103.intValue() != 1) goto L21;
        com.bytedance.android.gamecp.host_api.a.b().getCloudGameService().p();
        return;
    L9:
        if (StringsKt.isBlank(r104) == false) goto L11;
    L5:
        r107 = 0;
        goto L7
    }
}
