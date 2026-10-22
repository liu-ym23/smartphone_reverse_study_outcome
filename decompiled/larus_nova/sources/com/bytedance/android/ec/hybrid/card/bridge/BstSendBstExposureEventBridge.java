package com.bytedance.android.ec.hybrid.card.bridge;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class BstSendBstExposureEventBridge implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<View> f46393d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46391b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46392c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46390a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BstSendBstExposureEventBridge(Function0<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "obtainViewHandler");
        this.f46393d = r100;
        this.f46390a = "sendBstExposureMethod";
        this.f46391b = IDLXBridgeMethod.Access.PUBLIC;
        this.f46392c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, final IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = com.bytedance.android.bst.bridge.a.f41932a;     // Catch: Exception -> L5
        com.bytedance.android.bst.bridge.a.a(k.b(r101), this.f46393d.invoke(), new AnonymousClass1(r102));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ExtKt.b("BstSendBstExposureEventBridge", ExtKt.c(e));
    }
}
