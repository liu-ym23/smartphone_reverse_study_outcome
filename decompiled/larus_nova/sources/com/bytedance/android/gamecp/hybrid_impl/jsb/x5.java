package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.text.TextUtils;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "reportGameCPViewTrackEvent")
public final class x5 extends x0<y5, ReportGameCPViewTrackEventResultModel> {

    public static final class a {
    }

    static {
    }

    public x5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        y5 r102 = (y5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (TextUtils.isEmpty(r102.a()) == true) goto L21;
        JsonObject r103 = r102.b();
        if (r103 == null) goto L7;
        Set<Map.Entry<String, JsonElement>> r104 = r103.entrySet();
    L8:
        HashMap r105 = new HashMap();
        if (r104 == null) goto L20;
        Iterator<Map.Entry<String, JsonElement>> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, JsonElement> r107 = r106.next();
        if (r107.getValue().isJsonPrimitive() == true) goto L16;
    L18:
        String r108 = r107.getValue().toString();
    L19:
        r105.put(r107.getKey(), r108);
        goto L12
    L16:
        if (r107.getValue().getAsJsonPrimitive().isString() == false) goto L18;
        r108 = r107.getValue().getAsString();
    L20:
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        String r110 = r102.a();
        Intrinsics.checkNotNull(r110);
        GamecpTracker.B(r110, r105);
        ReportGameCPViewTrackEventResultModel r111 = new ReportGameCPViewTrackEventResultModel();
        r111.a(ReportGameCPViewTrackEventResultModel.Code.Success);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
        return;
    L7:
        r104 = null;
        goto L8
    L21:
        ReportGameCPViewTrackEventResultModel r113 = new ReportGameCPViewTrackEventResultModel();
        r113.a(ReportGameCPViewTrackEventResultModel.Code.Failed);
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r113);
    }
}
