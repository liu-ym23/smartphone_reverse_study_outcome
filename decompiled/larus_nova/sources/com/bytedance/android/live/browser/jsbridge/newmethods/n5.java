package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.InputActivityEmojiResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "inputActivityEmoji")
public final class n5 extends w20.e2<w20.ca, InputActivityEmojiResultModel> {
    public n5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.ca r102 = (w20.ca) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 == null) goto L5;
        Long r104 = StringsKt.toLongOrNull(r103);
    L6:
        if (r104 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r105 = r102.b();
        if (r105 == null) goto L21;
        HashMap r106 = new HashMap();
        Iterator<String> r107 = r105.keySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L22;
        String r108 = r107.next();
        JsonElement r109 = r105.get(r108);
        if ((r109 instanceof JsonPrimitive) == true) goto L16;
        r109 = null;
    L16:
        JsonPrimitive r110 = (JsonPrimitive) r109;
        if (r110 == null) goto L12;
        String r111 = r110.getAsString();
        if (r111 == null) goto L12;
        String r112 = (String) r106.put(r108, r111);
    L22:
        ICommentService r113 = (ICommentService) jc1.k.f(ICommentService.class);
        if (r113 == null) goto L26;
        r113.inputActivityEmoji(r104.longValue(), r102.c(), r106);
    L26:
        if (com.bytedance.android.livesdk.s4.f157858a.getValue().booleanValue() == false) goto L31;
        LinkedHashMap r114 = new LinkedHashMap();
        String r115 = r102.d();
        if (r115 != null) goto L30;
        r115 = "";
    L30:
        r114.put("request_source", r115);
        r114.put("jsb_name", "inputActivityEmoji");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r114, new Object[0]);
    L31:
        finishWithSuccess();
        return;
    L21:
        r106 = new HashMap();
        goto L22
    L5:
        r104 = null;
        goto L6
    }
}
