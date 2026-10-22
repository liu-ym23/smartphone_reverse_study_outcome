package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import java.lang.ref.WeakReference;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u4.a;
import u4.b;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageUnSubscribeMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIStorageUnSubscribeMethodV2 extends AbsUnSubscribeStorageMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AIStorageUnSubscribeMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        AbsUnSubscribeStorageMethodIDL.a r102 = (AbsUnSubscribeStorageMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r102.getGroupId().length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        h.a.a(r110, "no group id", null, null, 14);
        return;
    L10:
        if (r102.isShared() == true) goto L12;
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.b.class, "<this>");
        r110.b((ResultModel) c.a(AbsUnSubscribeStorageMethodIDL.b.class), "");
        return;
    L12:
        a r104 = s3.a.a(r100);
        if (r104 != null) goto L15;
        h.a.a(r110, "no find AiContainer", null, null, 14);
        return;
    L15:
        b r105 = s3.a.b(r100, r102);
        if (r105 != null) goto L18;
        h.a.a(r110, "no find ViewModel", null, null, 14);
        return;
    L18:
        r105.b(new u4.h(r105.d(r102.getGroupId(), r102.getStorageId()), r102.getKey(), r102.isPersist(), new WeakReference(r104)));
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.b.class, "<this>");
        r110.b((ResultModel) c.a(AbsUnSubscribeStorageMethodIDL.b.class), "");
        return;
    L5:
        r103 = false;
        goto L7
    }
}
