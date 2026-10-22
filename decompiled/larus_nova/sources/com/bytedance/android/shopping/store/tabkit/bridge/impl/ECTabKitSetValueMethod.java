package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.bridge.b;
import com.bytedance.android.shopping.store.tabkit.model.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitSetValueMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitSetValueMethod extends TabKitBridge.TabKitBaseBridgeMethod {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabKitBridge f186624f;

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecTabKitSetValue";
    }

    public ECTabKitSetValueMethod(TabKitBridge r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "tabkitBridge");
        super(r101);
        this.f186624f = r100;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        b r102 = this.f186624f.f186581d;
        if (r102 != null) goto L30;
        r101.onFailed(0, "proxy is null");
        return;
    L30:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        String r104 = r100.optString("key");     // Catch: Throwable -> L24
        String r105 = r100.optString("value");     // Catch: Throwable -> L24
        boolean r106 = true;
        if (r104 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L22;
        if (r105 != null) goto L16;
    L19:
        if (r106 == true) goto L22;
        r102.q(r104, r105);     // Catch: Throwable -> L24
        r101.a(new JSONObject());     // Catch: Throwable -> L24
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L31;
        r101.onFailed(0, r109.getMessage());
        return;
    L31:
        return;
    L16:
        if (StringsKt.isBlank(r105) == true) goto L19;
        r106 = false;
    L22:
        r101.onFailed(0, "invalid key or value! key=" + r104 + " value=" + r105);     // Catch: Throwable -> L24
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r107 = false;
    L24:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
