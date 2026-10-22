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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitObserveValueForKeyMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitObserveValueForKeyMethod extends TabKitBridge.TabKitBaseBridgeMethod {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabKitBridge f186619f;

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecTabKitObserveValueForKey";
    }

    public ECTabKitObserveValueForKeyMethod(TabKitBridge r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "tabkitBridge");
        super(r101);
        this.f186619f = r100;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        b r102 = this.f186619f.f186581d;
        if (r102 != null) goto L24;
        r101.onFailed(0, "proxy is null");
        return;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        String r104 = r100.optString("key");     // Catch: Throwable -> L18
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L16;
        r101.onFailed(0, "invalid key! key=" + r104);     // Catch: Throwable -> L18
        return;
    L16:
        r102.l(r104);     // Catch: Throwable -> L18
        r101.a(new JSONObject());     // Catch: Throwable -> L18
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L25;
        r101.onFailed(0, r107.getMessage());
        return;
    L25:
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r105 = false;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
