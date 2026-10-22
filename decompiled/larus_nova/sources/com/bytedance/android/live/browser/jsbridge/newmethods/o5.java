package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.InputFusionEmojiResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "inputFusionEmoji")
public final class o5 extends w20.f2<w20.da, InputFusionEmojiResultModel> {
    public o5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.da r102 = (w20.da) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 == null) goto L5;
        Long r104 = StringsKt.toLongOrNull(r103);
    L6:
        if (r104 != null) goto L9;
        finishWithFailure();
        return;
    L9:
        if (com.bytedance.android.livesdk.s4.f157858a.getValue().booleanValue() == false) goto L14;
        LinkedHashMap r105 = new LinkedHashMap();
        String r106 = r102.d();
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r105.put("request_source", r106);
        r105.put("jsb_name", "inputFusionEmoji");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r105, new Object[0]);
    L14:
        ICommentService r107 = (ICommentService) jc1.k.f(ICommentService.class);
        if (r107 == null) goto L17;
        r107.inputFusionEmoji(r104.longValue(), r102.b(), r102.c(), null);
    L17:
        finishWithSuccess();
        return;
    L5:
        r104 = null;
        goto L6
    }
}
