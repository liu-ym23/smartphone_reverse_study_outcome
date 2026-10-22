package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.UploadTraceMonitorResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.c7;
import w20.nf;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadTraceMonitor")
public final class u4 extends c7<nf, UploadTraceMonitorResultModel> {

    public static final class a {
    }

    static {
    }

    public u4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        nf r112 = (nf) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        LocalTestManager.a(new Class[]{wy.a.class});
        UploadTraceMonitorResultModel r100 = new UploadTraceMonitorResultModel();
        String r101 = r112.a();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r100.a(UploadTraceMonitorResultModel.Code.Failed);
        r100.b("business type is null or blank");
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r100);
        ALogger.e("UploadTraceMethod", "business type name is null or blank");
        return;
    L12:
        String r103 = r112.g();
        if (r103 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L21;
        r100.a(UploadTraceMonitorResultModel.Code.Failed);
        r100.b("trace name is null or blank");
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r100);
        ALogger.e("UploadTraceMethod", "trace name is null or blank");
        return;
    L21:
        String r105 = r112.f();
        if (r105 != null) goto L24;
    L27:
        boolean r106 = true;
    L28:
        if (r106 == false) goto L30;
        r100.a(UploadTraceMonitorResultModel.Code.Failed);
        r100.b("step is null or blank");
        Unit r115 = Unit.INSTANCE;
        finishWithResult(r100);
        ALogger.e("UploadTraceMethod", "step is null or blank");
        return;
    L30:
        LinkedHashMap r107 = new LinkedHashMap();
        JsonObject r108 = r112.e();
        if (r108 == null) goto L38;
        Iterator<Map.Entry<String, Object>> r109 = UtilsKt.i(r108).entrySet().iterator();
    L34:
        if (r109.hasNext() == false) goto L38;
        Map.Entry<String, Object> r116 = r109.next();
        String r117 = r116.getKey();
        Object r118 = r116.getValue();
        if ((!StringsKt.isBlank(r117)) == false) goto L34;
        r107.put(r117, r118);
    L38:
        JSONObject r119 = new JSONObject();
        JsonObject r120 = r112.d();
        if (r120 == null) goto L46;
        Iterator<Map.Entry<String, Object>> r121 = UtilsKt.i(r120).entrySet().iterator();
    L42:
        if (r121.hasNext() == false) goto L46;
        Map.Entry<String, Object> r122 = r121.next();
        String r123 = r122.getKey();
        Object r124 = r122.getValue();
        if ((!StringsKt.isBlank(r123)) == false) goto L42;
        r119.put(r123, r124);
    L46:
        Integer r125 = r112.b();
        if (r125 == null) goto L49;
        int r126 = r125.intValue();
    L50:
        String r127 = r112.c();
        if (r127 != null) goto L53;
        r127 = "";
    L53:
        String r128 = r127;
        int r129 = rd0.a.f537202a;
        rd0.a.a(r101, r103, r105, r126, r128, r119, r107);
        r100.a(UploadTraceMonitorResultModel.Code.Success);
        Unit r130 = Unit.INSTANCE;
        finishWithResult(r100);
        return;
    L49:
        r126 = 0;
        goto L50
    L24:
        if (StringsKt.isBlank(r105) == true) goto L27;
        r106 = false;
        goto L28
    L15:
        if (StringsKt.isBlank(r103) == true) goto L18;
        r104 = false;
        goto L19
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L10
    }
}
