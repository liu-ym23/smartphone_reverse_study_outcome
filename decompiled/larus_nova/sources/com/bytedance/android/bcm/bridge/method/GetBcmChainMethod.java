package com.bytedance.android.bcm.bridge.method;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ss.ttvideoengine.DataLoaderHelper;
import g66.c;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "getBcmChain")
public final class GetBcmChainMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41764b;

    public GetBcmChainMethod() {
        this.f41763a = "getBcmChain";
        this.f41764b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41764b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41763a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        ALogger.c(ALogger.f41996d, "FE_getBcmChain", new AnonymousClass1(r100));
        String r102 = r100.getString("biz");
        int r103 = r100.getInt("chain_length");
        JSONObject r104 = null;
        if (TextUtils.isEmpty(r102) == true) goto L14;
        c r111 = getContextProviderFactory();
        if (r111 == null) goto L8;
        View r112 = HybridContainerContextManager.c(r111);
    L9:
        if (r112 != null) goto L11;
        g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, r102, null, AnonymousClass4.INSTANCE, 28);
        goto L14
    L11:
        kc.a r105 = b.b(PageFinder.via(r112), CollectionsKt.listOf(r102), r103);
        if (r105 == null) goto L14;
        r104 = r105.a();
        goto L14
    L8:
        r112 = null;
    L14:
        if (r104 != null) goto L16;
        j.a(this, r101, "chain is null");
        return;
    L16:
        int r106 = j.f42100a;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("content", r104);
        j.b(this, r101, r107);
    }
}
