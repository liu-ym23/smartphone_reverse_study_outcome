package com.bytedance.ai.bridge.method.device;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.clipboard.AbsSetClipboardDataMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/SetClipboardDataMethod;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL$SetClipboardDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetClipboardDataMethod extends AbsSetClipboardDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetClipboardDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r110, h r111) {
        AbsSetClipboardDataMethodIDL.b r112 = (AbsSetClipboardDataMethodIDL.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        g r101 = g.f37637a;
        StringBuilder r102 = new StringBuilder("call start, dataLen=");
        r102.append(r112.getData().length());
        r102.append(", appletId=");
        a0 r103 = r100.getContainerContext();
        if (r103 == null) goto L5;
        String r104 = r103.getAppletId();
    L6:
        r102.append(r104);
        r101.i("AISDK_JSB_SetClipboardDataMethod", r102.toString());
        Activity r105 = r100.getOwnerActivity();
        if (r105 != null) goto L11;
        r105 = k.b();
        if (r105 != null) goto L11;
        StringBuilder r106 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475265f;
        r106.append(r113.f475285a);
        r106.append(", msg=context is null");
        r101.e("AISDK_JSB_SetClipboardDataMethod", r106.toString());
        h.a.a(r111, "context is null", r113, null, 10);
        return;
    L11:
        ClipData r114 = ClipData.newPlainText(r112.getData(), r112.getData());
        r4.k r107 = r4.a.f535984k;
        if (r107 != null) goto L23;
        StringBuilder r108 = new StringBuilder("call failed, errNo=");
        f3.a r115 = f3.a.f475266g;
        r108.append(r115.f475285a);
        r108.append(", msg=system action depend is null");
        r101.e("AISDK_JSB_SetClipboardDataMethod", r108.toString());
        h.a.a(r111, "system action depend is null", r115, null, 10);
        return;
    L23:
        String r109 = this.f35281a;     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r114);     // Catch: Exception -> L19
        r107.b(r105, r100, r109, r114);     // Catch: Exception -> L19
        if (r107.a(r105, r100, this.f35281a) == true) goto L17;
        StringBuilder r116 = new StringBuilder("call failed, errNo=");     // Catch: Exception -> L19
        f3.a r117 = f3.a.f475269j;     // Catch: Exception -> L19
        r116.append(r117.f475285a);     // Catch: Exception -> L19
        r116.append(", msg=no permission to access clipboard");     // Catch: Exception -> L19
        r101.e("AISDK_JSB_SetClipboardDataMethod", r116.toString());     // Catch: Exception -> L19
        h.a.a(r111, "no permission to access clipboard", r117, null, 10);     // Catch: Exception -> L19
    L22:
        return;
    L17:
        r101.i("AISDK_JSB_SetClipboardDataMethod", "call success");     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(AbsSetClipboardDataMethodIDL.a.class, "<this>");     // Catch: Exception -> L19
        r111.b((ResultModel) c.a(AbsSetClipboardDataMethodIDL.a.class), "");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        g r118 = g.f37637a;
        StringBuilder r119 = new StringBuilder("call failed, errNo=");
        f3.a r120 = f3.a.f475265f;
        r119.append(r120.f475285a);
        r119.append(", msg=setClipboardData failed: ");
        r119.append(e.getMessage());
        r118.e("AISDK_JSB_SetClipboardDataMethod", r119.toString());
        h.a.a(r111, "setClipboardData failed: " + e.getMessage(), r120, null, 10);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
