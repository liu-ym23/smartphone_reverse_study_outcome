package com.bytedance.ai.bridge.method.postMessage;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMessage.AbsPostMessageMethodIDL;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z2.p;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/postMessage/PostMessageMethod;", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL$PostMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostMessageMethod extends AbsPostMessageMethodIDL {
    public PostMessageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsPostMessageMethodIDL.b r103 = (AbsPostMessageMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r104 = r100.getContainerContext();
        if (r104 == null) goto L5;
        ContainerType r105 = r104.getContainerType();
    L7:
        if (r105 == ContainerType.EMBED_WEB_VIEW) goto L9;
        h.a.a(r102, "postMessage is only available in webview container", null, null, 14);
        return;
    L9:
        p r106 = (p) r100.d(p.class);
        if (r106 == null) goto L12;
        r106.onMessage(r103.getData());
    L12:
        Intrinsics.checkNotNullParameter(AbsPostMessageMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsPostMessageMethodIDL.a.class), "");
        return;
    L5:
        r105 = null;
        goto L7
    }
}
