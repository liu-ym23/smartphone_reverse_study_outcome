package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetChatInputVisibleMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL$SetChatInputVisibleParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL$SetChatInputVisibleResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetChatInputVisibleMethod extends AbsChatInputVisibleMethodIDL {
    public SetChatInputVisibleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsChatInputVisibleMethodIDL.a r103 = (AbsChatInputVisibleMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        j r104 = a.a(this, r100);
        if (r104 == null) goto L7;
        t r105 = r104.getFloatingSpeakerController();
        if (r105 == null) goto L7;
        r105.n(r103.getVisible(), r103.getFocusAtEnd());
        Intrinsics.checkNotNullParameter(AbsChatInputVisibleMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsChatInputVisibleMethodIDL.b.class), "");
        return;
    L7:
        StringBuilder r106 = new StringBuilder("unsupported container type ");
        a0 r107 = r100.getContainerContext();
        if (r107 == null) goto L10;
        ContainerType r108 = r107.getContainerType();
    L11:
        r106.append(r108);
        h.a.a(r102, r106.toString(), null, null, 14);
        return;
    L10:
        r108 = null;
        goto L11
    }
}
