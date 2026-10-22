package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveCreateQuestionContainerResultModel;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.n2;
import w20.oa;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.createQuestionContainer")
public final class b extends n2<oa, LiveCreateQuestionContainerResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        oa r102 = (oa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        JsonObject r104 = r102.a();
        if (r103 == null) goto L12;
        if (r104 == null) goto L12;
        IAnswerQuestionService r105 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r105 != null) goto L8;
    L10:
        LiveCreateQuestionContainerResultModel r106 = new LiveCreateQuestionContainerResultModel();
        r106.a(LiveCreateQuestionContainerResultModel.Code.Failed);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
    L11:
        Unit r108 = Unit.INSTANCE;
    L13:
        if (r108 != null) goto L16;
        LiveCreateQuestionContainerResultModel r109 = new LiveCreateQuestionContainerResultModel();
        r109.a(LiveCreateQuestionContainerResultModel.Code.Failed);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L16:
        return;
    L8:
        if (r105.showAnswerQuestionContainer(r103, r104) != true) goto L10;
        LiveCreateQuestionContainerResultModel r111 = new LiveCreateQuestionContainerResultModel();
        r111.a(LiveCreateQuestionContainerResultModel.Code.Success);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
    L12:
        r108 = null;
        goto L13
    }
}
