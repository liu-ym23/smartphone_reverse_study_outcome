package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.LiveShortTouchFeatureUpdateResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.internal.LazilyParsedNumber;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.shortTouchFeatureUpdate")
public final class y6 extends w20.l3<w20.gb, LiveShortTouchFeatureUpdateResultModel> {
    public y6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.gb r102 = (w20.gb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
        JsonObject r104 = r102.a();     // Catch: Throwable -> L29
        if (r104 == null) goto L7;
        String r105 = r104.toString();     // Catch: Throwable -> L29
        if (r105 == null) goto L7;
    L8:
        ALogger.i("HOT_PACKAGE_TERM", "LiveShortTouchFeatureUpdateMethod params ".concat(r105));     // Catch: Throwable -> L29
        JsonObject r106 = r102.a();     // Catch: Throwable -> L29
        if (r106 == null) goto L11;
        Map r107 = UtilsKt.i(r106);     // Catch: Throwable -> L29
    L12:
        ALogger.d("HOT_PACKAGE_TERM", new x6(r107));     // Catch: Throwable -> L29
        HashMap r108 = new HashMap();     // Catch: Throwable -> L29
        if (r107 != null) goto L34;
    L23:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        xs2.b.a().post(new y90.a(r108));     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L29
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
        goto L27
    L34:
        Iterator r110 = r107.entrySet().iterator();     // Catch: Throwable -> L25
    L16:
        if (r110.hasNext() == false) goto L23;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L25
        Object r112 = r111.getValue();     // Catch: Throwable -> L25
        if (r112 == null) goto L16;
        if ((r112 instanceof LazilyParsedNumber) == true) goto L21;
        r108.put(r111.getKey(), r112);     // Catch: Throwable -> L25
        goto L16
    L21:
        r108.put(r111.getKey(), Long.valueOf(((LazilyParsedNumber) r112).longValue()));     // Catch: Throwable -> L25
        ALogger.d("HOT_PACKAGE_TERM", "存在类型非Int类型的数据 key = " + ((String) r111.getKey()) + "   value = " + r112);     // Catch: Throwable -> L25
        goto L16
    L11:
        r107 = MapsKt.emptyMap();     // Catch: Throwable -> L29
    L7:
        r105 = "";
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
