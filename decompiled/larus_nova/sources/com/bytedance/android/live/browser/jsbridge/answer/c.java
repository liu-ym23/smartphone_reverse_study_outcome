package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveDestroyQuestionContainerResultModel;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.o2;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.destroyQuestionContainer")
public final class c extends o2<JsonObject, LiveDestroyQuestionContainerResultModel> {
    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IAnswerQuestionService r102 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r102 != null) goto L5;
    L7:
        LiveDestroyQuestionContainerResultModel r103 = new LiveDestroyQuestionContainerResultModel();
        r103.a(LiveDestroyQuestionContainerResultModel.Code.Failed);
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r103);
        return;
    L5:
        if (r102.dismissAnswerQuestionContainer() != true) goto L7;
        LiveDestroyQuestionContainerResultModel r105 = new LiveDestroyQuestionContainerResultModel();
        r105.a(LiveDestroyQuestionContainerResultModel.Code.Success);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
    }
}
