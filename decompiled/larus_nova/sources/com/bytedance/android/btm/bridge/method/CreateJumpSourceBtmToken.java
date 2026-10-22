package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.createJumpSourceBtmToken")
public final class CreateJumpSourceBtmToken extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42085b;

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public CreateJumpSourceBtmToken() {
        this.f42084a = "btm.createJumpSourceBtmToken";
        this.f42085b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42085b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42084a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        final String r102 = s.f(r100, "btm", "");
        final XReadableMap r111 = s.e(r100, "bcm");
        ALogger.c(ALogger.f41996d, "FE_createJumpSourceBtmToken", new AnonymousClass1(r102, r111));
        g66.c r103 = getContextProviderFactory();
        if (r103 == null) goto L5;
        final View r104 = HybridContainerContextManager.c(r103);
    L6:
        if (r104 != null) goto L9;
        com.bytedance.android.btm.api.inner.g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, r102, null, new AnonymousClass2(r102), 28);
        j.a(this, r101, "Cannot find view");
        return;
    L9:
        XReadableMap r105 = s.e(r100, "options");
        if (r105 == null) goto L12;
        s.b(r105, "cache_btm_token", false);
    L12:
        BtmSDK r106 = BtmSDK.INSTANCE;
        Function1<com.bytedance.android.btm.api.model.d, Unit> r107 = new CreateJumpSourceBtmToken$handle$sourceBtmToken$1(r102, r111, r104);
        com.bytedance.android.btm.api.model.d r112 = new com.bytedance.android.btm.api.model.d();
        r107.invoke(r112);
        String r108 = r106.createJumpSourceBtmTokenForJSB(r112);
        if (r108 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == false) goto L21;
        j.a(this, r101, "createJumpSourceBtmToken Fail.");
        return;
    L21:
        int r113 = j.f42100a;
        j.b(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PhotoEnterModel.SOURCE_BTM_TOKEN, r108)}));
        return;
    L15:
        if (r108.length() == 0) goto L18;
        r109 = false;
        goto L19
    L5:
        r104 = null;
        goto L6
    }
}
