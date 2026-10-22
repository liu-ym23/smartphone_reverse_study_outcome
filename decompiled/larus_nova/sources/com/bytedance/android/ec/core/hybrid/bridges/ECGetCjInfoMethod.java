package com.bytedance.android.ec.core.hybrid.bridges;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECGetCjInfoMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetCjInfoMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44112e;

    public static final class a {
    }

    static {
    }

    public ECGetCjInfoMethod() {
        this.f44112e = "getCjInfo";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44112e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r103.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        r103.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, TTCJPayUtils.Companion.getInstance().getSDKVersion());
        r103.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r102.put("code", 1);
        r102.put("data", r103);
        r101.a(r102);
    }
}
