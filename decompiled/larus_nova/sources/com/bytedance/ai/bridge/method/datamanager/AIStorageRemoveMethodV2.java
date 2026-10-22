package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s3.a;
import u4.b;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageRemoveMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsRemoveStorageMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/datamanager/AbsRemoveStorageMethodIDL$RemoveStorageParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsRemoveStorageMethodIDL$RemoveStorageResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIStorageRemoveMethodV2 extends AbsRemoveStorageMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AIStorageRemoveMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsRemoveStorageMethodIDL.a r103 = (AbsRemoveStorageMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r103.getGroupId().length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        h.a.a(r102, "no group id", null, null, 14);
        return;
    L9:
        b r105 = a.b(r100, r103);
        if (r105 != null) goto L12;
        h.a.a(r102, "no find AiContainer", null, null, 14);
        return;
    L12:
        r105.e(r103.getStorageId(), r103.isPersist(), r103.getKey(), r103.getExtra());
        Intrinsics.checkNotNullParameter(AbsRemoveStorageMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsRemoveStorageMethodIDL.b.class), "");
        return;
    L5:
        r104 = false;
        goto L7
    }
}
