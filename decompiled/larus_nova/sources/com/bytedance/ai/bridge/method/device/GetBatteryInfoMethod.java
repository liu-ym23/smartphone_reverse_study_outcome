package com.bytedance.ai.bridge.method.device;

import android.content.Context;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.battery.AbsGetBatteryInfoMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import t3.f;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/GetBatteryInfoMethod;", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL$GetBatteryInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetBatteryInfoMethod extends AbsGetBatteryInfoMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35435b;

    public static final class a {
    }

    static {
    }

    public GetBatteryInfoMethod() {
        this.f35435b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.f35435b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r100, AbsGetBatteryInfoMethodIDL.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        g r111 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, appletId=");
        a0 r102 = r100.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getAppletId();
    L6:
        r101.append(r103);
        r111.i("AISDK_JSB_GetBatteryInfoMethod", r101.toString());
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Context r105 = e.b(r100);     // Catch: Throwable -> L17
        if (r105 != null) goto L11;
        StringBuilder r106 = new StringBuilder("call failed, errNo=");     // Catch: Throwable -> L17
        f3.a r107 = f3.a.f475265f;     // Catch: Throwable -> L17
        r106.append(r107.f475285a);     // Catch: Throwable -> L17
        r106.append(", msg=context is null");     // Catch: Throwable -> L17
        r111.e("AISDK_JSB_GetBatteryInfoMethod", r106.toString());     // Catch: Throwable -> L17
        return new com.bytedance.ai.bridge.core.a.b(0, "context is null", null, r107, 21);
    L11:
        t3.g r108 = f.a(r105);     // Catch: Throwable -> L17
        if (r108 != null) goto L15;
        StringBuilder r109 = new StringBuilder("call failed, errNo=");     // Catch: Throwable -> L17
        f3.a r112 = f3.a.f475265f;     // Catch: Throwable -> L17
        r109.append(r112.f475285a);     // Catch: Throwable -> L17
        r109.append(", msg=battery info is unavailable");     // Catch: Throwable -> L17
        r111.e("AISDK_JSB_GetBatteryInfoMethod", r109.toString());     // Catch: Throwable -> L17
        return new com.bytedance.ai.bridge.core.a.b(0, "battery info is unavailable", null, r112, 21);
    L15:
        r111.i("AISDK_JSB_GetBatteryInfoMethod", "call success");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(AbsGetBatteryInfoMethodIDL.b.class, "<this>");     // Catch: Throwable -> L17
        BaseModel r113 = c.a(AbsGetBatteryInfoMethodIDL.b.class);     // Catch: Throwable -> L17
        AbsGetBatteryInfoMethodIDL.b r114 = (AbsGetBatteryInfoMethodIDL.b) r113;     // Catch: Throwable -> L17
        r114.setLevel(r108.f544292a);     // Catch: Throwable -> L17
        r114.setCharging(r108.f544293b);     // Catch: Throwable -> L17
        Object r115 = Result.m9449constructorimpl(new com.bytedance.ai.bridge.core.a.c(r113));     // Catch: Throwable -> L17
    L19:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L27;
        String r117 = r116.getMessage();
        if (r117 != null) goto L25;
        r117 = "get battery info failed";
    L25:
        String r118 = r117;
        g r119 = g.f37637a;
        StringBuilder r120 = new StringBuilder("call failed, errNo=");
        f3.a r121 = f3.a.f475265f;
        r120.append(r121.f475285a);
        r120.append(", msg=");
        r120.append(r118);
        r119.e("AISDK_JSB_GetBatteryInfoMethod", r120.toString(), r116);
        r115 = new com.bytedance.ai.bridge.core.a.b(0, r118, null, r121, 21);
    L27:
        return (com.bytedance.ai.bridge.core.a) r115;
    L17:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r100, ParamModel r101) {
        return b(r100, (AbsGetBatteryInfoMethodIDL.a) r101);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsGetBatteryInfoMethodIDL.a r103 = (AbsGetBatteryInfoMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        b.a(b(r100, r103), r102);
    }
}
