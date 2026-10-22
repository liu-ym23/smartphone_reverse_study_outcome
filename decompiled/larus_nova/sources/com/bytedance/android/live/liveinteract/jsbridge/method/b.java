package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetConcertStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.qa;
import w20.r2;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends r2<qa, LiveGetConcertStatusResultModel> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        qa r102 = (qa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        JsonObject r106 = r102.b();
        IKtvService r107 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r107 == null) goto L14;
        gd2.f r108 = r107.getConcertStageService();
        if (r108 == null) goto L14;
        JsonObject r109 = r108.g(new hd2.a(r104, r103, r106));
    L15:
        LiveGetConcertStatusResultModel r110 = new LiveGetConcertStatusResultModel();
        r110.a(LiveGetConcertStatusResultModel.Code.Success);
        r110.b(r109);
        r110.c("get success");
        ALogger.i("DynamicGetConcertStatusMethod", "DynamicGetConcertStatusMethod#invoke type=" + r103 + " bizId=" + r104 + " extra=" + r106 + ", resultData=" + r109);
        finishWithResult(r110);
        return;
    L14:
        r109 = null;
        goto L15
    }
}
