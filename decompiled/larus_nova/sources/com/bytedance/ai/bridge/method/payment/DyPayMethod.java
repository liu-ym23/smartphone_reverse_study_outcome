package com.bytedance.ai.bridge.method.payment;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.payment.payment.AbsDyPayMethodIDL;
import com.bytedance.ai.bridge.service.IHostPaymentDepend;
import com.bytedance.ai.model.AppletRuntimeManager;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J0\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/DyPayMethod;", "Lcom/bytedance/ai/bridge/payment/payment/AbsDyPayMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/payment/payment/AbsDyPayMethodIDL$DyPayParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "completeFailure", "errorNo", "", "errorMessage", "apiError", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DyPayMethod extends AbsDyPayMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35761b = 0;

    public static final class a {
    }

    static {
    }

    public DyPayMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsDyPayMethodIDL.b r103 = (AbsDyPayMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r104 = r100.getContainerContext();
        com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r106 = new StringBuilder("call start, appletId=");
        FragmentActivity r107 = null;
        if (r104 == null) goto L5;
        String r108 = r104.getAppletId();
    L6:
        r106.append(r108);
        r106.append(", containerId=");
        if (r104 == null) goto L9;
        String r109 = r104.getContainerId();
    L10:
        r106.append(r109);
        r105.i("AISDK_JSB_DyPayMethod", r106.toString());
        IHostPaymentDepend r110 = r4.a.f535986m;
        if (r110 != null) goto L13;
        f3.a r111 = f3.a.f475266g;
        b(r102, String.valueOf(r111.f475285a), "Host payment service is unavailable", r111);
        return;
    L13:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r112 = AppletRuntimeManager.f36749d;
        if (r112 == null) goto L16;
        Activity r113 = r112.currentActivity();
    L18:
        if ((r113 instanceof FragmentActivity) == false) goto L21;
        r107 = (FragmentActivity) r113;
    L21:
        if (AppletRuntimeManager.f36751f == true) goto L25;
        if (r107 == null) goto L25;
        r110.openDyPay(r107, r103.getData(), new c(r102, this));
        return;
    L25:
        b(r102, "-3", "Payment is not supported in background", f3.a.f475265f);
        return;
    L16:
        r113 = null;
        goto L18
    L9:
        r109 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }

    public static void b(f3.h r100, String r101, String r102, f3.a r103) {
        AbsDyPayMethodIDL.a r104 = (AbsDyPayMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsDyPayMethodIDL.a.class));
        r104.setErrNo(r101);
        r104.setErrMsg(r102);
        com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_DyPayMethod", "call failed, errNo=" + r103.f475285a + ", bizErrNo=" + r101 + ", msg=" + r102);
        f3.h.a.a(r100, r102, r103, r104.toJson(), 2);
    }
}
