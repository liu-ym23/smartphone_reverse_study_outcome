package com.bytedance.ai.bridge.method.device;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.clipboard.AbsGetClipboardDataMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/GetClipboardDataMethod;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL$GetClipboardDataResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetClipboardDataMethod extends AbsGetClipboardDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetClipboardDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetClipboardDataMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call start, appletId=");
        a0 r105 = r100.getContainerContext();
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.getAppletId();
    L6:
        r104.append(r107);
        r103.i("AISDK_JSB_GetClipboardDataMethod", r104.toString());
        Activity r108 = r100.getOwnerActivity();
        if (r108 != null) goto L11;
        r108 = k.b();
        if (r108 != null) goto L11;
        StringBuilder r109 = new StringBuilder("call failed, errNo=");
        f3.a r110 = f3.a.f475265f;
        r109.append(r110.f475285a);
        r109.append(", msg=context is null");
        r103.e("AISDK_JSB_GetClipboardDataMethod", r109.toString());
        h.a.a(r102, "context is null", r110, null, 10);
        return;
    L11:
        r4.k r111 = r4.a.f535984k;
        if (r111 != null) goto L14;
        StringBuilder r112 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475266g;
        r112.append(r113.f475285a);
        r112.append(", msg=system action depend is null");
        r103.e("AISDK_JSB_GetClipboardDataMethod", r112.toString());
        h.a.a(r102, "system action depend is null", r113, null, 10);
        return;
    L14:
        ClipData r114 = r111.c(r108, r100, this.f35280a);
        if (r114 != null) goto L17;
    L22:
        r106 = "";
    L23:
        r103.i("AISDK_JSB_GetClipboardDataMethod", "call success, dataLen=" + r106.length());
        Intrinsics.checkNotNullParameter(AbsGetClipboardDataMethodIDL.b.class, "<this>");
        BaseModel r115 = c.a(AbsGetClipboardDataMethodIDL.b.class);
        ((AbsGetClipboardDataMethodIDL.b) r115).setData(r106);
        r102.b((ResultModel) r115, "");
        return;
    L17:
        if (r114.getItemCount() <= 0) goto L22;
        CharSequence r116 = r114.getItemAt(0).coerceToText(r108);
        if (r116 == null) goto L21;
        r106 = r116.toString();
    L21:
        if (r106 != null) goto L23;
    L5:
        r107 = null;
        goto L6
    }
}
