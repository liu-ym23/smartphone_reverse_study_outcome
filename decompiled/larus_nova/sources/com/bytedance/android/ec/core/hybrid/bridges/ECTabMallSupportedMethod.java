package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECTabMallSupportedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabMallSupportedMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecTabMallSupported";
    }

    public ECTabMallSupportedMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        JSONObject r102 = new JSONObject();
        r102.put("code", 1);
        int r103 = ECSdk.f48106a;
        s83.g r104 = (s83.g) ECSdk.a(s83.g.class);
        if (r104 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r104.a0());
    L6:
        r102.put("isSupported", r105);
        Unit r106 = Unit.INSTANCE;
        r101.a(r102);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
