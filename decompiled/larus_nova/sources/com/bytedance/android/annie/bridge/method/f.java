package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ChooseAndUploadParamModel;
import com.bytedance.android.annie.bridge.ChooseAndUploadResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "chooseAndUpload")
public final class f extends com.bytedance.android.annie.bridge.a<ChooseAndUploadParamModel, ChooseAndUploadResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ChooseAndUploadParamModel r102 = (ChooseAndUploadParamModel) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r103 = r102.a();
        if (r103 != null) goto L5;
    L14:
        String r104 = r101.a();     // Catch: Exception -> L12
        if (r104 != null) goto L10;
        r104 = "host";
    L10:
        a9.g r105 = (a9.g) Annie.getService(a9.g.class, r104);     // Catch: Exception -> L12
        r101.getContext();     // Catch: Exception -> L12
        r105.d0();     // Catch: Exception -> L12
        return;
    L12:
        ChooseAndUploadResultModel r106 = new ChooseAndUploadResultModel();
        r106.a(ChooseAndUploadResultModel.Code.Failed);
        r106.b("chooseAndUpload not implemented in host");
        finishWithResult(r106);
        return;
    L5:
        if (r103.intValue() > 0) goto L14;
        ChooseAndUploadResultModel r107 = new ChooseAndUploadResultModel();
        r107.a(ChooseAndUploadResultModel.Code.InvalidParam);
        r107.b("maxCount must be greater than 0");
        finishWithResult(r107);
    }
}
