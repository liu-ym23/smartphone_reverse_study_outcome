package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageType;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetInputModeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetInputModeMethod extends AbsSetInputModeMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public SetInputModeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsSetInputModeMethodIDL.a r103 = (AbsSetInputModeMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r104 = r100.getContainerContext();
        if (r104 == null) goto L5;
        ContainerType r105 = r104.getContainerType();
    L7:
        if (r105 != ContainerType.PAGE) goto L31;
        j r106 = (j) r100.d(j.class);
        if (r106 != null) goto L12;
        h.a.a(r102, "aicontainer is null", null, null, 14);
        return;
    L12:
        if (r106.getPageInfo().getPageType() != PageType.FULL_PAGE) goto L14;
    L37:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        InputMode.a r108 = InputMode.Companion;     // Catch: Throwable -> L19
        String r109 = r103.getMode();     // Catch: Throwable -> L19
        r108.getClass();     // Catch: Throwable -> L19
        Object r110 = Result.m9449constructorimpl(InputMode.a.a(r109));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r110) == false) goto L24;
        r110 = null;
    L24:
        InputMode r111 = (InputMode) r110;
        if (r111 == null) goto L30;
        t r112 = r106.getFloatingSpeakerController();
        if (r112 == null) goto L29;
        r112.o(r111);
        Intrinsics.checkNotNullParameter(AbsSetInputModeMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetInputModeMethodIDL.b.class), "");
        return;
    L29:
        h.a.a(r102, "floating speaker controller is null", null, null, 14);
        return;
    L30:
        h.a.a(r102, "unsupported input mode " + r103.getMode(), null, null, 14);
        return;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L14:
        if (r106.getPageInfo().getPageType() == PageType.POPUP_PAGE) goto L37;
        h.a.a(r102, "unsupported page type " + r106.getPageInfo().getPageType(), null, null, 14);
        return;
    L31:
        StringBuilder r114 = new StringBuilder("unsupported container type ");
        a0 r115 = r100.getContainerContext();
        if (r115 == null) goto L34;
        ContainerType r116 = r115.getContainerType();
    L35:
        r114.append(r116);
        h.a.a(r102, r114.toString(), null, null, 14);
        return;
    L34:
        r116 = null;
        goto L35
    L5:
        r105 = null;
        goto L7
    }
}
