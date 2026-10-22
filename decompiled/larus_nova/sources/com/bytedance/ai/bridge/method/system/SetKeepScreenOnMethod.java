package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.screen.AbsSetKeepScreenOnMethodIDL;
import com.bytedance.ai.utils.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d3.a0;
import e3.e;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/SetKeepScreenOnMethod;", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL$SetKeepScreenOnParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetKeepScreenOnMethod extends AbsSetKeepScreenOnMethodIDL {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public SetKeepScreenOnMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsSetKeepScreenOnMethodIDL.b r103 = (AbsSetKeepScreenOnMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r104 = g.f37637a;
        StringBuilder r105 = new StringBuilder("call start, keepScreenOn=");
        r105.append(r103.getKeepScreenOn());
        r105.append(", appletId=");
        a0 r106 = r100.getContainerContext();
        if (r106 == null) goto L5;
        String r107 = r106.getAppletId();
    L6:
        r105.append(r107);
        r104.i("AISDK_JSB_SetKeepScreenOnMethod", r105.toString());
        Activity r108 = e.a(r100);
        if (r108 == null) goto L15;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L15;
        View r110 = r109.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r111 = ThreadMethodProxy.currentThread();
        if (r111 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r111, "getDecorView");
    L16:
        if (r110 != null) goto L18;
        StringBuilder r112 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475265f;
        r112.append(r113.f475285a);
        r112.append(", msg=not found view");
        r104.e("AISDK_JSB_SetKeepScreenOnMethod", r112.toString());
        h.a.a(r102, "not found view", r113, null, 10);
        return;
    L18:
        r110.setKeepScreenOn(r103.getKeepScreenOn());
        r104.i("AISDK_JSB_SetKeepScreenOnMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsSetKeepScreenOnMethodIDL.a.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetKeepScreenOnMethodIDL.a.class), "");
        return;
    L15:
        r110 = null;
        goto L16
    L5:
        r107 = null;
        goto L6
    }
}
