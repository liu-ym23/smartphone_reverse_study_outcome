package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.bridge.b;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitGetScreenStateMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitGetScreenStateMethod extends TabKitBridge.TabKitBaseBridgeMethod {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabKitBridge f186615f;

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecTabKitGetScreenState";
    }

    public ECTabKitGetScreenStateMethod(TabKitBridge r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "tabkitBridge");
        super(r101);
        this.f186615f = r100;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        b r102 = this.f186615f.f186581d;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        int r104 = r102.getScreenState();     // Catch: Throwable -> L9
    L7:
        r101.a(new JSONObject().putOpt(InteractConst.WAKEUP_SCREEN_STATE, Integer.valueOf(r104)));     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        r101.onFailed(0, r106.getMessage());
        return;
    L17:
        return;
    L6:
        r104 = 0;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
