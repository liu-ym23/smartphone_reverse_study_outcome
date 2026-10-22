package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CloseMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseMethod extends AbsCloseMethodIDL {
    public CloseMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsCloseMethodIDL.a r103 = (AbsCloseMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getContainerID();
        List<String> r105 = r103.getContainerIDs();
        boolean r106 = r103.getAnimated();
        if (r105 == null) goto L7;
        boolean r107 = true;
        if ((!r105.isEmpty()) != true) goto L7;
    L8:
        if (r107 == false) goto L15;
        Iterator<T> r108 = r105.iterator();
    L11:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();
        r4.j r110 = r4.a.f535983j;
        if (r110 == null) goto L11;
        r110.closeView(r100, r109, r106);
    L18:
        Intrinsics.checkNotNullParameter(AbsCloseMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsCloseMethodIDL.b.class), "");
        return;
    L15:
        r4.j r111 = r4.a.f535983j;
        if (r111 == null) goto L18;
        r111.closeView(r100, r104, r106);
    L7:
        r107 = false;
        goto L8
    }
}
