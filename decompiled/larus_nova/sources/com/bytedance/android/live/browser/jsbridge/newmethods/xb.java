package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendSubscribeEmoji")
public final class xb extends u<yb, SendSubscribeEmojiResultModel> {
    public xb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        yb r112 = (yb) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r113 = r112.a();
        if (r113 == null) goto L5;
        Long r114 = StringsKt.toLongOrNull(r113);
    L6:
        if (r114 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        IMiddlewareUserService r100 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L40;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 == null) goto L40;
        if (r101.isLogin() != true) goto L40;
        JsonObject r102 = r112.b();
        if (r102 == null) goto L28;
        HashMap r103 = new HashMap();
        Iterator<String> r104 = r102.keySet().iterator();
    L19:
        if (r104.hasNext() == false) goto L29;
        String r105 = r104.next();
        JsonElement r106 = r102.get(r105);
        if ((r106 instanceof JsonPrimitive) == true) goto L23;
        r106 = null;
    L23:
        JsonPrimitive r107 = (JsonPrimitive) r106;
        if (r107 == null) goto L19;
        String r108 = r107.getAsString();
        if (r108 == null) goto L19;
        r103.put(r105, r108);
    L29:
        HashMap r109 = r103;
        HashMap r115 = new HashMap();
        if (Intrinsics.areEqual(r112.c(), "emoji_detail_page") == false) goto L32;
        r115.put("is_from_screen_chat", "1");
    L32:
        String r116 = r112.c();
        if (r116 == null) goto L35;
        r115.put("message_source", r116);
    L35:
        xs2.b r117 = xs2.b.a();
        long r118 = r114.longValue();
        Integer r119 = r112.d();
        if (r119 == null) goto L38;
        int r120 = r119.intValue();
    L39:
        r117.post(new com.bytedance.android.livesdk.event.c0(r118, r120, false, ISendCommentEvent.Sender.SubscribeJSB, r109, null, r115));
        finishWithSuccess();
        return;
    L38:
        r120 = 0;
        goto L39
    L28:
        r103 = new HashMap();
    L40:
        finishWithFailure();
        return;
    L5:
        r114 = null;
        goto L6
    }
}
