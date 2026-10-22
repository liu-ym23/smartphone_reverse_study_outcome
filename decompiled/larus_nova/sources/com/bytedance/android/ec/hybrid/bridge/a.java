package com.bytedance.android.ec.hybrid.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46297b;

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.bridge.a$a, reason: collision with other inner class name */
    public static final class C0815a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public a() {
        this.f46296a = IDLXBridgeMethod.Access.PUBLIC;
        this.f46297b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46296a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46297b;
    }
}
