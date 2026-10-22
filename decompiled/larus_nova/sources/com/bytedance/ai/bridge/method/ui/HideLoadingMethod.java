package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsHideLoadingMethodIDL;
import e3.a;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/HideLoadingMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL$HideInteractionParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideLoadingMethod extends AbsHideLoadingMethodIDL {
    public HideLoadingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsHideLoadingMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Boolean r103 = null;
        if ((r100 instanceof a) == false) goto L5;
        a r104 = (a) r100;
    L6:
        IHostStyleUIDepend r105 = r4.a.f535978e;
        if (r105 == null) goto L10;
        r103 = r105.hideLoading(r104);
    L10:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L12;
    L12:
        Intrinsics.checkNotNullParameter(AbsHideLoadingMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsHideLoadingMethodIDL.a.class), "");
        return;
    L5:
        r104 = null;
        goto L6
    }
}
