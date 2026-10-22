package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/StopShowFloatAllMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StopShowFloatAllMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44147e;

    public static final class a {
    }

    static {
    }

    public StopShowFloatAllMethod() {
        this.f44147e = "stopShowFloatAll";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44147e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r104 = r103.getLiveWindowService();
        if (r104 == null) goto L7;
        r104.stopShowFloat();
    L7:
        r101.onSuccess(new JSONObject());
    }
}
