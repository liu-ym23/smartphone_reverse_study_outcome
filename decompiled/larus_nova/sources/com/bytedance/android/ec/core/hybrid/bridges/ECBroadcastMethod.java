package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECBroadcastMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBroadcastMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecBroadcast";
    }

    public ECBroadcastMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        String r100 = r110.optString("eventName");
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L28;
        JSONObject r112 = r110.optJSONObject("data");
        if (r112 != null) goto L11;
        r111.onFailed(0, "no data found");
        return;
    L11:
        EventBus.getDefault().post(new ah.c(r100, r112));
        int r101 = r100.hashCode();
        if (r101 == (-1034470971)) goto L25;
        if (r101 == (-654096686)) goto L22;
        if (r101 == (-396285131)) goto L19;
    L27:
        r111.onSuccess(null);
        return;
    L19:
        if (r100.equals("didApplyCoupon") == false) goto L27;
        EventBus.getDefault().post(new ah.b(r112));
        goto L27
    L22:
        if (r100.equals("closeHalfSku") == false) goto L27;
        ECHybridExtensionsKt.f(ECBroadcastMethod$onEvent$1.INSTANCE);
        goto L27
    L25:
        if (r100.equals("moveToState") == false) goto L27;
        EventBus.getDefault().post(new ah.f(r112.optString("state"), r112.optInt("num"), r112.optBoolean("isD3"), r112.optString("couponShowType"), r112.optBoolean("animate"), r112.optBoolean("useNative"), r112.optJSONObject("logData")));
        goto L27
    L28:
        r111.onFailed(0, "no event name found");
        Unit r113 = Unit.INSTANCE;
    }
}
