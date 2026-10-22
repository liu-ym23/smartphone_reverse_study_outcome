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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetBackGestureEnableMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL$SetBackGestureEnableParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL$SetBackGestureEnableResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetBackGestureEnableMethod extends AbsSetBackGestureEnableMethodIDL {
    public SetBackGestureEnableMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsSetBackGestureEnableMethodIDL.a r103 = (AbsSetBackGestureEnableMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r104 = r103.getEnabled();
        a0 r105 = r100.getContainerContext();
        if (r105 == null) goto L5;
        ContainerType r106 = r105.getContainerType();
    L7:
        if (r106 != ContainerType.PAGE) goto L35;
        j r107 = (j) r100.d(j.class);
        if (r107 == null) goto L13;
        PageInfo r108 = r107.getPageInfo();
        if (r108 == null) goto L13;
        PageType r109 = r108.getPageType();
    L15:
        if (r109 == PageType.FULL_PAGE) goto L31;
        if (r107 == null) goto L20;
        PageInfo r110 = r107.getPageInfo();
        if (r110 == null) goto L20;
        PageType r111 = r110.getPageType();
    L22:
        if (r111 == PageType.POPUP_PAGE) goto L31;
        StringBuilder r112 = new StringBuilder("unsupported page type ");
        if (r107 == null) goto L29;
        PageInfo r113 = r107.getPageInfo();
        if (r113 == null) goto L29;
        PageType r114 = r113.getPageType();
    L30:
        r112.append(r114);
        h.a.a(r102, r112.toString(), null, null, 14);
        return;
    L29:
        r114 = null;
    L20:
        r111 = null;
    L31:
        t r115 = r107.getFloatingSpeakerController();
        if (r115 == null) goto L34;
        r115.a(r104);
    L34:
        Intrinsics.checkNotNullParameter(AbsSetBackGestureEnableMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetBackGestureEnableMethodIDL.b.class), "");
        return;
    L13:
        r109 = null;
        goto L15
    L35:
        StringBuilder r116 = new StringBuilder("unsupported container type ");
        a0 r117 = r100.getContainerContext();
        if (r117 == null) goto L38;
        ContainerType r118 = r117.getContainerType();
    L39:
        r116.append(r118);
        h.a.a(r102, r116.toString(), null, null, 14);
        return;
    L38:
        r118 = null;
        goto L39
    L5:
        r106 = null;
        goto L7
    }
}
