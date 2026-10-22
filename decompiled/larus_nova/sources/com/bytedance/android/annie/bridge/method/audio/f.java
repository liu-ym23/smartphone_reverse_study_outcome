package com.bytedance.android.annie.bridge.method.audio;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.browser.jsbridge.base.StopSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import w20.ef;
import w20.u6;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "stopSpeechRecognition")
public final class f extends u6<ef, StopSpeechRecognitionResultModel> {
    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ef r102 = (ef) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        a r103 = null;
        if (Intrinsics.areEqual(r102.a(), Boolean.TRUE) == true) goto L13;
        WeakHashMap<View, a> r104 = a.f38544k;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r105 = r101.f249269d;
        if (r105 == null) goto L7;
        r103 = a.f38544k.get(r105);
    L7:
        if (r103 == null) goto L12;
        Handler r106 = r103.f38551g;
        if (r106 == null) goto L11;
        r106.sendMessage(r106.obtainMessage(105));
    L11:
        a.a("stopAsrAudio");
    L12:
        StopSpeechRecognitionResultModel r107 = new StopSpeechRecognitionResultModel();
        r107.a(StopSpeechRecognitionResultModel.Code.Success);
        finishWithResult(r107);
        return;
    L13:
        AsrState r108 = f7.c.f475743a;
        if (f7.c.f475743a == AsrState.STARTED) goto L16;
        int r109 = 1;
    L20:
        if (r109 != 0) goto L22;
        StopSpeechRecognitionResultModel r110 = new StopSpeechRecognitionResultModel();
        r110.a(StopSpeechRecognitionResultModel.Code.Success);
        finishWithResult(r110);
        return;
    L22:
        StopSpeechRecognitionResultModel r111 = new StopSpeechRecognitionResultModel();
        r111.a(StopSpeechRecognitionResultModel.Code.Failed);
        r111.b("failed with code: " + r109);
        finishWithResult(r111);
        return;
    L16:
        a9.e r112 = (a9.e) Annie.getService$default(a9.e.class, null, 2, null);
        if (r112 != null) goto L19;
        r109 = 2;
        goto L20
    L19:
        r112.stop();
        r109 = 3;
        goto L20
    }
}
