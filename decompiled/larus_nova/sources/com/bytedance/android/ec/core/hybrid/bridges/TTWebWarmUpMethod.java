package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.host.api.ttwebview.ITTWebWarmUpService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/TTWebWarmUpMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTWebWarmUpMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44150e;

    public static final class a {
    }

    static {
    }

    public TTWebWarmUpMethod() {
        this.f44150e = "warmUpTTWeb";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44150e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        int r102 = ECSdk.f48106a;
        IECHostService r103 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r103 == null) goto L5;
        ITTWebWarmUpService r104 = r103.getITTWebWarmUpService();
    L7:
        if (r104 != null) goto L22;
        r101.onFailed(-1, "service is null");
        return;
    L22:
        int r105 = r100.optInt("mode", 0);     // Catch: Exception -> L18
        if (r105 != 1) goto L13;
        r104.warmUpRenderAsync();     // Catch: Exception -> L18
        r101.onSuccess(new JSONObject());     // Catch: Exception -> L18
    L21:
        return;
    L13:
        if (r105 == 2) goto L15;
        r101.onFailed(-1, "mode " + r105 + " is invalid");     // Catch: Exception -> L18
        goto L21
    L15:
        r104.warmUpRenderAndBrowserOnUI();     // Catch: Exception -> L18
        r101.onSuccess(new JSONObject());     // Catch: Exception -> L18
    L18:
        e = move-exception;
        r101.onFailed(-1, "warmup failed on " + e.getMessage());
        return;
    L5:
        r104 = null;
        goto L7
    }
}
