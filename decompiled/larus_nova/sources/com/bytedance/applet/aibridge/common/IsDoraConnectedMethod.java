package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.j2;
import com.larus.platform.service.DoraAudioService;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/common/IsDoraConnectedMethod;", "Lcom/bytedance/applet/aibridge/common/AbsIsDoraConnectedMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsIsDoraConnectedMethodIDL$IsDoraConnectedParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsIsDoraConnectedMethodIDL$IsDoraConnectedResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsDoraConnectedMethod extends AbsIsDoraConnectedMethodIDL {
    public IsDoraConnectedMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsIsDoraConnectedMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(AbsIsDoraConnectedMethodIDL.b.class, "<this>");
        BaseModel r103 = c.a(AbsIsDoraConnectedMethodIDL.b.class);
        AbsIsDoraConnectedMethodIDL.b r104 = (AbsIsDoraConnectedMethodIDL.b) r103;
        j2 r105 = DoraAudioService.c();
        if (r105 == null) goto L7;
        boolean r106 = true;
        if (r105.isDoraConnected() != true) goto L7;
    L8:
        r104.setConnected(r106);
        r102.b((ResultModel) r103, "");
        return;
    L7:
        r106 = false;
        goto L8
    }
}
