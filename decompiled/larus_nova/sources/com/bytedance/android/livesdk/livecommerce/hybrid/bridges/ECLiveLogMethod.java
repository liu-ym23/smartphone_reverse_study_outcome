package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveLogMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLogMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecLiveLog";
    }

    public ECLiveLogMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        if (r100.optString("msg", null) != null) goto L5;
        r100.optString("log");
    L5:
        String r102 = r100.optString("level", null);
        if (r102 != null) goto L8;
        r102 = r100.optString("label");
    L8:
        if (r102 == null) goto L31;
        int r103 = r102.hashCode();
        if (r103 != 100) goto L13;
        r102.equals("d");
        return;
    L13:
        if (r103 != 101) goto L15;
        r102.equals("e");
        return;
    L15:
        if (r103 != 105) goto L17;
        r102.equals(RXScreenCaptureService.KEY_INDEX);
        return;
    L17:
        if (r103 != 118) goto L19;
        r102.equals(BaseSwitches.V);
        return;
    L19:
        if (r103 != 119) goto L32;
        r102.equals("w");
        return;
    L32:
        return;
    }
}
