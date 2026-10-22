package com.bytedance.ai.bridge.method.device;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.accessibility.AbsCheckIsOpenAccessibilityMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/CheckIsOpenAccessibilityMethod;", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL$CheckIsOpenAccessibilityResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckIsOpenAccessibilityMethod extends AbsCheckIsOpenAccessibilityMethodIDL {

    public static final class a {
    }

    static {
    }

    public CheckIsOpenAccessibilityMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsCheckIsOpenAccessibilityMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call start, appletId=");
        a0 r105 = r100.getContainerContext();
        if (r105 == null) goto L5;
        String r106 = r105.getAppletId();
    L6:
        r104.append(r106);
        r103.i("AISDK_JSB_CheckIsOpenAccessibilityMethod", r104.toString());
        Context r107 = e.b(r100);
        if (r107 != null) goto L9;
        StringBuilder r108 = new StringBuilder("call failed, errNo=");
        f3.a r109 = f3.a.f475265f;
        r108.append(r109.f475285a);
        r108.append(", msg=context is null");
        r103.e("AISDK_JSB_CheckIsOpenAccessibilityMethod", r108.toString());
        h.a.a(r102, "context is null", r109, null, 10);
        return;
    L9:
        Object r110 = r107.getSystemService("accessibility");
        if ((r110 instanceof AccessibilityManager) == false) goto L12;
        AccessibilityManager r111 = (AccessibilityManager) r110;
    L13:
        if (r111 != null) goto L15;
        StringBuilder r112 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475266g;
        r112.append(r113.f475285a);
        r112.append(", msg=accessibility service is unavailable");
        r103.e("AISDK_JSB_CheckIsOpenAccessibilityMethod", r112.toString());
        h.a.a(r102, "accessibility service is unavailable", r113, null, 10);
        return;
    L15:
        r103.i("AISDK_JSB_CheckIsOpenAccessibilityMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsCheckIsOpenAccessibilityMethodIDL.a.class, "<this>");
        BaseModel r114 = c.a(AbsCheckIsOpenAccessibilityMethodIDL.a.class);
        AbsCheckIsOpenAccessibilityMethodIDL.a r115 = (AbsCheckIsOpenAccessibilityMethodIDL.a) r114;
        if (r111.isEnabled() == true) goto L18;
    L20:
        boolean r116 = false;
    L21:
        r115.setOpen(r116);
        r102.b((ResultModel) r114, "");
        return;
    L18:
        if (r111.isTouchExplorationEnabled() == false) goto L20;
        r116 = true;
        goto L21
    L12:
        r111 = null;
        goto L13
    L5:
        r106 = null;
        goto L6
    }
}
