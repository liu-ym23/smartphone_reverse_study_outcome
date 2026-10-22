package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Vibrator;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "vibrate")
public final class ae extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public ae() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r102 = r101.getContext().getSystemService("vibrator");
        if ((r102 instanceof Vibrator) == true) goto L5;
        r102 = null;
    L5:
        Vibrator r103 = (Vibrator) r102;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        if ((r100 instanceof JSONObject) == true) goto L9;
        r100 = null;
    L9:
        JSONObject r105 = (JSONObject) r100;     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        long r106 = r105.optLong("duration");     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(Long.valueOf(r106));     // Catch: Throwable -> L15
    L17:
        long r108 = 50;
        if (Result.m9456isSuccessimpl(r107) == false) goto L22;
        long r109 = ((Number) r107).longValue();
        if (r109 <= 0) goto L22;
        r108 = r109;
    L22:
        if (r103 == null) goto L24;
        r103.vibrate(r108);
    L24:
        JSONObject r110 = new JSONObject();
        r110.put("code", 1);
        r110.put("msg", "SUCCESS");
        finishWithResult(r110);
        return;
    L12:
        r106 = 0;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
