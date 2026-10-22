package com.bytedance.android.btm.bridge.method;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.HybridSchemaHelper;
import com.bytedance.ee.space.sync.PushRoute$EType;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.pageRoute")
public final class a extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42087b;

    public a() {
        this.f42086a = "btm.pageRoute";
        this.f42087b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42087b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, android.view.View] */
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r110, final com.bytedance.ies.xbridge.XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        b.f42088a.getClass();
        ALogger.c(ALogger.f41996d, "FE_pageRoute", new BtmPageRouteMethodHelper$handle$1(r110));
        final String r100 = s.f(r110, "btm", "");
        final String r101 = s.f(r110, PushRoute$EType.KEY_NAME, "");
        XReadableMap r102 = s.e(r110, "page_event_params");
        Uri r103 = null;
        if (r102 == null) goto L5;
        final Map<String, ? extends Object> r104 = r102.toMap();
    L6:
        final Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = null;
        if (getContextProviderFactory() == null) goto L12;
        Lazy r106 = HybridContainerContextManager.f42079a;
        g66.c r107 = getContextProviderFactory();
        if (r107 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r105.element = HybridContainerContextManager.c(r107);
    L12:
        View r113 = (View) r105.element;
        if (r113 == null) goto L22;
        Lazy r108 = HybridContainerContextManager.f42079a;
        final String r109 = HybridContainerContextManager.b(getContextProviderFactory());
        Map<View, String> r114 = HybridSchemaHelper.f42080a;
        View r115 = (View) r105.element;
        if (r109 == null) goto L17;
        r103 = UriProtector.parse(r109);
    L17:
        String r116 = HybridSchemaHelper.b(r115, r103);
        BtmSDK r117 = BtmSDK.INSTANCE;
        if (r117.getService().registerFEBtmPage(r113, r100, r116, Boolean.valueOf(Intrinsics.areEqual(r101, "back")), r104) == false) goto L20;
        j.b(this, r111, new LinkedHashMap());
    L21:
        j.b(this, r111, new LinkedHashMap());
        return;
    L20:
        int r118 = j.f42100a;
        j.a(this, r111, "route btm page failed, route type: " + r101);
        com.bytedance.android.btm.api.inner.g.a.a(r117.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, null, null, new BtmPageRouteMethodHelper$handle$$inlined$apply$lambda$1(r109, this, r105, r100, r101, r104, r111), 30);
        goto L21
    L22:
        j.a(this, r111, "view is null");
        Unit r119 = Unit.INSTANCE;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
