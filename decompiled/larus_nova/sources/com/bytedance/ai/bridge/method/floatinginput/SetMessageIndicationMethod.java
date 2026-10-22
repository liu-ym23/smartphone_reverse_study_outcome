package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetMessageIndicationMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL$SetMessageIndicationParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL$SetMessageIndicationResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetMessageIndicationMethod extends AbsSetMessageIndicationMethodIDL {
    public SetMessageIndicationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsSetMessageIndicationMethodIDL.a r103 = (AbsSetMessageIndicationMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g.f37637a.d("FloatingSpeaker", this.f35502a + tb2.c.DEFAULT_TEXT + r103.getBotId() + ' ' + r103.getSend() + ' ' + r103.getReceive());
        r4.h r104 = r4.a.f535985l;
        if (r104 != null) goto L5;
        h.a.a(r102, "host message service is unavailable", null, null, 14);
        return;
    L5:
        RefType r105 = RefType.NORMAL;
        Object r106 = r100.d(e.class);
        if (r106 != null) goto L8;
        r106 = new e(r100);
        r100.b(e.class, r106, r105);
    L8:
        ((e) r106).update(r103.getBotId(), r103.getSend(), r103.getReceive());
        r104.k(r103.getBotId(), r103.getConversationId());
        Intrinsics.checkNotNullParameter(AbsSetMessageIndicationMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetMessageIndicationMethodIDL.b.class), "");
    }
}
