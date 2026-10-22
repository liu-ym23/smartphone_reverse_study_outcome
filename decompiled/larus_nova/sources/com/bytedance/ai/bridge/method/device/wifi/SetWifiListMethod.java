package com.bytedance.ai.bridge.method.device.wifi;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.wifi.AbsSetWifiListMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonObject;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/SetWifiListMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", JSEventListener.ACTION_RESOLVE, "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$SetWifiListParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetWifiListMethod extends AbsSetWifiListMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetWifiListMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsSetWifiListMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call failed, errNo=");
        f3.a r105 = f3.a.f475266g;
        r104.append(r105.f475285a);
        r104.append(", msg=setWifiList is iOS only");
        r103.e("AISDK_JSB_SetWifiListMethod", r104.toString());
        h.a.a(r102, "setWifiList is iOS only", r105, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final void realHandle(d r100, JsonObject r101, Consumer<JsonObject> r110, Consumer<AIBridgeMethod.Error> r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r111, "reject");
        g r102 = g.f37637a;
        StringBuilder r103 = new StringBuilder("call failed, errNo=");
        f3.a r104 = f3.a.f475266g;
        r103.append(r104.f475285a);
        r103.append(", msg=setWifiList is iOS only");
        r102.e("AISDK_JSB_SetWifiListMethod", r103.toString());
        r111.accept(new AIBridgeMethod.Error(0, "setWifiList is iOS only", null, r104, 4, null));
    }
}
