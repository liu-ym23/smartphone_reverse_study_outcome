package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.format.service.IFormatSDKService;
import com.bytedance.android.live.browser.jsbridge.base.FormatSendLogResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "format.sendLog")
public final class m3 extends w20.r0<w20.w8, FormatSendLogResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public m3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.w8 r102 = (w20.w8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r102.b();
        String r104 = r102.a();
        if (r103 == null) goto L26;
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L29;
        HashMap<String, String> r106 = new HashMap();
        Set<String> r107 = r103.keySet();
        if (r107.size() <= 0) goto L18;
        Iterator<T> r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();
        r106.put(r109, r103.get(r109).getAsString());
    L18:
        if (r102.c() != null) goto L20;
    L23:
        com.bytedance.android.livesdk.log.u.l().h(r102.a(), r106, new Object[0]);
        return;
    L20:
        if (Intrinsics.areEqual(r102.c(), Boolean.FALSE) == true) goto L23;
        ((IFormatSDKService) jc1.k.n(IFormatSDKService.class)).sendLog(r104, r106);
        return;
    L29:
        return;
    L8:
        r105 = false;
        goto L9
    }
}
