package com.bytedance.android.ec.sdk.plugin;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/sdk/plugin/PluginBridgeMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PluginBridgeMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECBaseBridgeMethod.a f48146f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        this.f48146f = r101;
        throw null;
    }
}
