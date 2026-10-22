package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/IsPlayerPlayingMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IsPlayerPlayingMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "mallPlayerIsPlaying";
    }

    public IsPlayerPlayingMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        JSONObject r102 = new JSONObject();
        boolean r103 = true;
        r102.put("code", 1);
        boolean r104 = ECServiceManager.f42805a;
        s83.d r105 = ((s83.g) ECServiceManager.c(s83.g.class)).N();
        if (r105 != null) goto L5;
    L7:
        r103 = false;
    L8:
        r102.put("isPlaying", r103);
        Unit r106 = Unit.INSTANCE;
        r101.a(r102);
        return;
    L5:
        if (r105.isPlaying() != true) goto L7;
        goto L7
    }
}
