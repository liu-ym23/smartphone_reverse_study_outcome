package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageType;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/GetInputModeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL$GetInputModeParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL$GetInputModeResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetInputModeMethod extends AbsGetInputModeMethodIDL {
    public GetInputModeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetInputModeMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r103 = r100.getContainerContext();
        if (r103 == null) goto L5;
        ContainerType r104 = r103.getContainerType();
    L7:
        if (r104 != ContainerType.PAGE) goto L23;
        j r105 = (j) r100.d(j.class);
        if (r105 != null) goto L12;
        h.a.a(r102, "aicontainer is null", null, null, 14);
        return;
    L12:
        if (r105.getPageInfo().getPageType() != PageType.FULL_PAGE) goto L14;
    L17:
        t r106 = r105.getFloatingSpeakerController();
        if (r106 == null) goto L22;
        InputMode r107 = r106.j();
        if (r107 == null) goto L22;
        Intrinsics.checkNotNullParameter(AbsGetInputModeMethodIDL.b.class, "<this>");
        BaseModel r108 = k3.c.a(AbsGetInputModeMethodIDL.b.class);
        ((AbsGetInputModeMethodIDL.b) r108).setMode(r107.getValue());
        r102.b((ResultModel) r108, "");
        return;
    L22:
        h.a.a(r102, "floating speaker controller is null", null, null, 14);
        return;
    L14:
        if (r105.getPageInfo().getPageType() == PageType.POPUP_PAGE) goto L17;
        h.a.a(r102, "unsupported page type " + r105.getPageInfo().getPageType(), null, null, 14);
        return;
    L23:
        StringBuilder r109 = new StringBuilder("unsupported container type ");
        a0 r110 = r100.getContainerContext();
        if (r110 == null) goto L26;
        ContainerType r111 = r110.getContainerType();
    L27:
        r109.append(r111);
        h.a.a(r102, r109.toString(), null, null, 14);
        return;
    L26:
        r111 = null;
        goto L27
    L5:
        r104 = null;
        goto L7
    }
}
