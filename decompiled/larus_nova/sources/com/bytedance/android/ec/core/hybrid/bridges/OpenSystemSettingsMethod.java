package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/OpenSystemSettingsMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSystemSettingsMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44146e;

    public OpenSystemSettingsMethod() {
        this.f44146e = "ecOpenSystemSettings";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44146e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        Context r102 = getContext();
        if (r102 == null) goto L5;
        com.bytedance.android.ec.sdk.helper.d.f48119b.openSystemSettingPage(r102);
    L5:
        r101.onSuccess(null);
    }
}
