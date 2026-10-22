package com.bytedance.android.ec.hybrid.bridge;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "USE ECHybridStatefulBridge")
public class d implements IDLXBridgeMethod, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Map<String, ? extends Object>, IBDXBridgeContext, Map<String, Object>> f46308c;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46306a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46307b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function2<? super Map<String, ? extends Object>, ? super IBDXBridgeContext, ? extends Map<String, ? extends Object>> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f46308c = r100;
        this.f46306a = IDLXBridgeMethod.Access.PUBLIC;
        this.f46307b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Map<String, ? extends Object> r103 = (Map) this.f46308c.invoke(r101, r100);
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.g(r101, r103, ((LynxStatefulBridgeProxy) this).f46295e);
        r102.invoke(r103);
    }
}
