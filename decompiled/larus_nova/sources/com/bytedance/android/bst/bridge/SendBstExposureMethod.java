package com.bytedance.android.bst.bridge;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.google.gson.Gson;
import g66.c;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "sendBstExposureMethod")
public final class SendBstExposureMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41931b;

    public static final class a {
    }

    static {
    }

    public SendBstExposureMethod() {
        this.f41930a = "sendBstExposureMethod";
        this.f41931b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41931b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41930a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, final com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        final JSONObject r103 = new JSONObject(new Gson().toJson(s.h(r100)));     // Catch: Exception -> L8
        Function0<String> r104 = new AnonymousClass1(r103);     // Catch: Exception -> L8
        ALogger r105 = ALogger.f41996d;     // Catch: Exception -> L8
        r105.getClass();     // Catch: Exception -> L8
        View r106 = null;
        r105.o("BTMSDK_BST_".concat("SendBstExposureMethod"), false, r104, null);     // Catch: Exception -> L8
        c r107 = getContextProviderFactory();     // Catch: Exception -> L8
        if (r107 == null) goto L6;
        r106 = HybridContainerContextManager.c(r107);     // Catch: Exception -> L8
    L6:
        int r108 = com.bytedance.android.bst.bridge.a.f41932a;     // Catch: Exception -> L8
        com.bytedance.android.bst.bridge.a.a(r103, r106, new AnonymousClass2(this, r101));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ExtKt.b("SendBstExposureMethod", ExtKt.c(e));
    }
}
