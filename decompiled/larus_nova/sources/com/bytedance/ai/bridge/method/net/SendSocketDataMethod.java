package com.bytedance.ai.bridge.method.net;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsSendSocketDataMethodIDL;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/SendSocketDataMethod;", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL$SendSocketDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL$SendSocketDataResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendSocketDataMethod extends AbsSendSocketDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public SendSocketDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        AbsSendSocketDataMethodIDL.a r113 = (AbsSendSocketDataMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        long r100 = r113.getSocketTaskId();
        com.bytedance.ai.utils.g r101 = com.bytedance.ai.utils.g.f37637a;
        r101.d("AISDK_JSB_SendSocketDataMethod", "call start, socketTaskId=" + r100 + ", dataType=" + r113.getDataType() + ", dataSize=" + r113.getData().length());
        c4.a r102 = c4.b.a(r110);
        if (r102 != null) goto L5;
        StringBuilder r114 = new StringBuilder("call failed, errNo=");
        f3.a r115 = f3.a.f475276q;
        r114.append(r115.f475285a);
        r114.append(", msg=The socketTaskId doesn't exist");
        r101.e("AISDK_JSB_SendSocketDataMethod", r114.toString());
        f3.h.a.a(r112, "The socketTaskId doesn't exist", r115, null, 10);
        return;
    L5:
        String r103 = r113.getDataType();
        if (Intrinsics.areEqual(r103, "string") == false) goto L12;
        String r116 = r113.getData();
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r116, "text");
        c4.a.e r117 = r102.j(r110, r100);
        if (r117 != null) goto L10;
        c4.a.d r118 = new c4.a.d("The socketTaskId doesn't exist", f3.a.f475276q);
    L28:
        if (r118 == null) goto L30;
        com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_SendSocketDataMethod", "call failed, errNo=" + r118.f22366b.f475285a + ", msg=" + r118.f22365a);
        f3.h.a.a(r112, r118.f22365a, r118.f22366b, null, 10);
        return;
    L30:
        com.bytedance.ai.utils.g.f37637a.d("AISDK_JSB_SendSocketDataMethod", "call success, socketTaskId=" + r100);
        Intrinsics.checkNotNullParameter(AbsSendSocketDataMethodIDL.b.class, "<this>");
        r112.b((ResultModel) k3.c.a(AbsSendSocketDataMethodIDL.b.class), "");
        return;
    L10:
        Intrinsics.checkNotNullParameter(r116, "text");
        r118 = r117.c(r116.getBytes(Charsets.UTF_8), 1, "text");
        goto L28
    L12:
        if (Intrinsics.areEqual(r103, TTVideoEngineInterface.PLAY_API_KEY_BASE64) == true) goto L32;
        r118 = new c4.a.d("unsupported dataType " + r113.getDataType(), f3.a.f475267h);
        goto L28
    L32:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        Object r119 = Result.m9449constructorimpl(Base64.decode(r113.getData(), 0));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r119) == false) goto L20;
        r119 = null;
    L20:
        byte[] r120 = (byte[]) r119;
        if (r120 != null) goto L23;
        r118 = new c4.a.d("invalid base64 data", f3.a.f475267h);
        goto L28
    L23:
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r120, HTTP.CONTENT_RANGE_BYTES);
        c4.a.e r121 = r102.j(r110, r100);
        if (r121 != null) goto L26;
        r118 = new c4.a.d("The socketTaskId doesn't exist", f3.a.f475276q);
        goto L28
    L26:
        Intrinsics.checkNotNullParameter(r120, HTTP.CONTENT_RANGE_BYTES);
        r118 = r121.c(r120, 2, HTTP.CONTENT_RANGE_BYTES);
    L15:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
