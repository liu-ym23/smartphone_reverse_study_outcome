package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/UpdateInputTextMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateInputTextMethod extends AbsUpdateInputTextMethodIDL {
    public UpdateInputTextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsUpdateInputTextMethodIDL.a r103 = (AbsUpdateInputTextMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r104 = r100.getContainerContext();
        if (r104 == null) goto L5;
        ContainerType r105 = r104.getContainerType();
    L7:
        if (r105 != ContainerType.PAGE) goto L35;
        j r106 = (j) r100.d(j.class);
        if (r106 == null) goto L13;
        PageInfo r107 = r106.getPageInfo();
        if (r107 == null) goto L13;
        PageType r108 = r107.getPageType();
    L15:
        if (r108 == PageType.FULL_PAGE) goto L31;
        if (r106 == null) goto L20;
        PageInfo r109 = r106.getPageInfo();
        if (r109 == null) goto L20;
        PageType r110 = r109.getPageType();
    L22:
        if (r110 == PageType.POPUP_PAGE) goto L31;
        StringBuilder r111 = new StringBuilder("unsupported page type ");
        if (r106 == null) goto L29;
        PageInfo r112 = r106.getPageInfo();
        if (r112 == null) goto L29;
        PageType r113 = r112.getPageType();
    L30:
        r111.append(r113);
        h.a.a(r102, r111.toString(), null, null, 14);
        return;
    L29:
        r113 = null;
    L20:
        r110 = null;
    L31:
        t r114 = r106.getFloatingSpeakerController();
        if (r114 == null) goto L34;
        r114.d(r103.getText(), r103.getMode());
    L34:
        Intrinsics.checkNotNullParameter(AbsUpdateInputTextMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsUpdateInputTextMethodIDL.b.class), "");
        return;
    L13:
        r108 = null;
        goto L15
    L35:
        StringBuilder r115 = new StringBuilder("unsupported container type ");
        a0 r116 = r100.getContainerContext();
        if (r116 == null) goto L38;
        ContainerType r117 = r116.getContainerType();
    L39:
        r115.append(r117);
        h.a.a(r102, r115.toString(), null, null, 14);
        return;
    L38:
        r117 = null;
        goto L39
    L5:
        r105 = null;
        goto L7
    }
}
