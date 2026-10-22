package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 extends g<JsonObject, LiveGetRecordingStatusResultModel> {
    public c1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = com.bytedance.android.livesdk.service.l.d().e().isRecording();
        String r103 = com.bytedance.android.livesdk.service.l.d().e().getSource();
        ALogger.i("GetRecordingStatusMethod", "isRecording=" + r102 + " curSource=" + r103);
        LiveGetRecordingStatusResultModel r104 = new LiveGetRecordingStatusResultModel();
        r104.a(LiveGetRecordingStatusResultModel.Code.Success);
        LiveGetRecordingStatusResultModel.a r105 = new LiveGetRecordingStatusResultModel.a();
        r105.a(Boolean.valueOf(r102));
        r105.b(r103);
        Unit r106 = Unit.INSTANCE;
        r104.b(r105);
        finishWithResult(r104);
    }
}
