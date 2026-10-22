package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECOpenQRCodeScanner;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenQRCodeScanner extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ECBaseBridgeMethod.a f44120f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44121e;

    public static final class a {
    }

    static {
    }

    public ECOpenQRCodeScanner() {
        this.f44121e = "openQRCodeScanner";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44121e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        Context r102 = getContext();
        p.f48130a.openSchema(r102, "sslocal://aweme/scan?page_from=2147483640&enter_from=false");
        f44120f = r101;
    }
}
