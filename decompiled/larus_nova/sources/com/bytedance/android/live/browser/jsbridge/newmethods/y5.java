package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.LiveCEPEventUpdateResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.CEPEventUpdate")
public final class y5 extends w20.k2<w20.la, LiveCEPEventUpdateResultModel> {
    public y5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.la r102 = (w20.la) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r102.b();
        if (r103 == null) goto L6;
        String r104 = r103.toString();
        if (r104 == null) goto L6;
    L7:
        ALogger.i("HOT_PACKAGE_TERM", "LiveCEPEventUpdateMethod params ".concat(r104));
        String r105 = r102.a();
        JsonObject r106 = r102.b();
        if (r106 == null) goto L10;
        Map r107 = UtilsKt.i(r106);
    L11:
        LinkedHashMap r108 = new LinkedHashMap();
        if (TextUtils.isEmpty(r105) == true) goto L25;
        if (r107 == null) goto L25;
        if (r107.size() <= 0) goto L25;
        if (r105 == null) goto L25;
        Iterator r109 = r107.entrySet().iterator();
    L19:
        if (r109.hasNext() == false) goto L25;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (TextUtils.isEmpty((CharSequence) r110.getKey()) == true) goto L19;
        if (r110.getValue() == null) goto L19;
        r108.put(r110.getKey(), String.valueOf(r110.getValue()));
    L25:
        if (r105 == null) goto L37;
        IDynamicStrategyService r111 = (IDynamicStrategyService) jc1.k.f(IDynamicStrategyService.class);
        if (r111 == null) goto L38;
        r111.sendNfaEvent(r105, r108);
        return;
    L38:
        return;
    L37:
        return;
    L10:
        r107 = MapsKt.emptyMap();
    L6:
        r104 = "";
        goto L7
    }
}
