package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ChooseMediaResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "chooseMedia")
public final class g extends com.bytedance.android.annie.bridge.b<com.bytedance.android.annie.bridge.i, ChooseMediaResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        com.bytedance.android.annie.bridge.i r102 = (com.bytedance.android.annie.bridge.i) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        String r104 = r102.a();
        if (r104 == null) goto L17;
        if (r103 == null) goto L17;
        if (Intrinsics.areEqual(r103.toLowerCase(Locale.ROOT), "camera") == false) goto L17;
        if (r104.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L17;
        ChooseMediaResultModel r106 = new ChooseMediaResultModel();
        r106.a(ChooseMediaResultModel.Code.InvalidParam);
        r106.b("CameraType not provided with sourceType specified as camera in params");
        finishWithResult(r106);
        return;
    L10:
        r105 = false;
    L17:
        a9.g r107 = (a9.g) Annie.getService(a9.g.class, r101.a());     // Catch: Exception -> L15
        r101.getContext();     // Catch: Exception -> L15
        r107.d0();     // Catch: Exception -> L15
        return;
    L15:
        ChooseMediaResultModel r108 = new ChooseMediaResultModel();
        r108.a(ChooseMediaResultModel.Code.Failed);
        r108.b("chooseMedia not implemented in host");
        finishWithResult(r108);
    }
}
