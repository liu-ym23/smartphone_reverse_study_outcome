package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/HeightChangedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeightChangedMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44144e;

    public HeightChangedMethod() {
        this.f44144e = "shopAdjustHybridContainerHeight";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44144e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        boolean r102 = false;
        Integer r103 = Integer.valueOf(r100.optInt("height", 0));
        if (r103.intValue() == 0) goto L5;
        r102 = true;
    L5:
        if (r102 == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L11;
        s0.a(new ah.e(r103.intValue(), r100.optString("targetContainer", "")));
        return;
    }
}
