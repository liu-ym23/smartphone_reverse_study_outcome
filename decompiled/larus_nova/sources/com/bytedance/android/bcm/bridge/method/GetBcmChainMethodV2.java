package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.api.model.d;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "getBcmChainV2")
public final class GetBcmChainMethodV2 extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41766b;

    public GetBcmChainMethodV2() {
        this.f41765a = "getBcmChainV2";
        this.f41766b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41766b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41765a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, android.view.View] */
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r110, com.bytedance.ies.xbridge.XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        ALogger.c(ALogger.f41996d, "FE_GetBcmChainV2", new AnonymousClass1(r110));
        int r113 = r110.getInt("chain_length");
        boolean r100 = r110.getBoolean("is_domain_standard");
        final String r101 = r110.getString("btm");
        final XReadableMap r114 = r110.getMap("bcm");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        JSONObject r103 = null;
        r102.element = null;
        c r104 = getContextProviderFactory();
        if (r104 == null) goto L6;
        r102.element = HybridContainerContextManager.c(r104);
    L6:
        if (((View) r102.element) != null) goto L8;
        g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, null, null, AnonymousClass4.INSTANCE, 30);
    L11:
        if (r103 != null) goto L13;
        j.a(this, r111, "chain is null");
        return;
    L13:
        int r115 = j.f42100a;
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("content", r103);
        j.b(this, r111, r116);
        return;
    L8:
        Function1<d, Unit> r105 = new GetBcmChainMethodV2$handle$btmModel$1(r102, r101, r114);
        d r117 = new d();
        r105.invoke(r117);
        kc.a r118 = b.f41761a.getBcmChainByBtmModel(r117, CollectionsKt.listOf("ecom_entrance"), r113, r100);
        if (r118 == null) goto L11;
        r103 = r118.a();
        goto L11
    }
}
