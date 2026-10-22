package com.bytedance.android.btm.bridge.method;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.HybridSchemaHelper;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "registerBtmPage")
public final class m extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42105b;

    public m() {
        this.f42104a = "registerBtmPage";
        this.f42105b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42105b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42104a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, android.view.View] */
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r110, com.bytedance.ies.xbridge.XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        int r113 = l.f42103a;
        ALogger.c(ALogger.f41996d, "FE_registerBtmPage", new RegisterBtmPageBridgeHelper$handle$1(r110));
        final String r114 = s.f(r110, "btm", "");
        XReadableMap r115 = s.e(r110, "page_event_params");
        Uri r100 = null;
        if (r115 == null) goto L5;
        Map<String, ? extends Object> r116 = r115.toMap();
    L6:
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        g66.c r102 = getContextProviderFactory();
        if (r102 == null) goto L9;
        r101.element = HybridContainerContextManager.c(r102);
    L9:
        Lazy r103 = HybridContainerContextManager.f42079a;
        final String r104 = HybridContainerContextManager.b(getContextProviderFactory());
        View r105 = (View) r101.element;
        if (r105 == null) goto L21;
        Map<View, String> r106 = HybridSchemaHelper.f42080a;
        if (r104 == null) goto L14;
        r100 = UriProtector.parse(r104);
    L14:
        String r107 = HybridSchemaHelper.b(r105, r100);
        BtmSDK r108 = BtmSDK.INSTANCE;
        r108.getService().checkPageBtmFormat(r114, r107, true, null, r104);
        com.bytedance.android.btm.api.inner.e r109 = r108.getService();
        View r117 = (View) r101.element;
        if (r117 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        if (r109.registerBtmPage(r117, r114, r107, r116) == false) goto L20;
        j.b(this, r111, new LinkedHashMap());
        return;
    L20:
        j.a(this, r111, "register btm page failed");
        com.bytedance.android.btm.api.inner.g.a.a(r108.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, null, null, new RegisterBtmPageBridgeHelper$handle$3(r114, r104, r101), 30);
        return;
    L21:
        j.a(this, r111, "Hybrid view is null");
        com.bytedance.android.btm.api.inner.g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, "registerBtmPage", null, new RegisterBtmPageBridgeHelper$handle$4(r114, r104), 28);
        return;
    L5:
        r116 = null;
        goto L6
    }
}
