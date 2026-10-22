package com.bytedance.applet.aibridge.anniex;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.w3;
import com.larus.platform.service.u3;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/anniex/SendEventToAnniexMethod;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendEventToAnniexMethod extends AbsSendEventToAnniexMethodIDL {
    public SendEventToAnniexMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsSendEventToAnniexMethodIDL.b r103 = (AbsSendEventToAnniexMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = null;
        if (StringsKt.isBlank(r103.getEventName()) == false) goto L5;
        h.a.a(r102, "eventName is empty", null, null, 14);
        return;
    L5:
        Lazy r105 = u3.f365813a;
        String r106 = r103.getEventName();
        Map<String, ? extends Object> r107 = r103.getParams();
        String r108 = r103.getContainerId();
        if (r108 != null) goto L8;
    L13:
        Intrinsics.checkNotNullParameter(r106, "eventName");
        w3 r109 = (w3) u3.f365813a.getValue();
        if (r109 == null) goto L16;
        r109.b(r106, r107, r104);
    L16:
        Intrinsics.checkNotNullParameter(AbsSendEventToAnniexMethodIDL.c.class, "<this>");
        r102.b((ResultModel) c.a(AbsSendEventToAnniexMethodIDL.c.class), "");
        return;
    L8:
        if (r108.length() <= 0) goto L10;
        boolean r110 = true;
    L11:
        if (r110 == false) goto L13;
        r104 = r108;
        goto L13
    L10:
        r110 = false;
        goto L11
    }
}
