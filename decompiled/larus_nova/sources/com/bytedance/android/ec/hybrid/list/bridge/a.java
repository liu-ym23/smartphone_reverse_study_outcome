package com.bytedance.android.ec.hybrid.list.bridge;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements IDLXBridgeMethod, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f47004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f47005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f47006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Map<String, ? extends Object>, Map<String, Object>> f47007d;

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.list.bridge.a$a, reason: collision with other inner class name */
    public static final class C0821a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f47004a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f47006c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f47005b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        this.f47007d = r100;
        this.f47004a = IDLXBridgeMethod.Access.PUBLIC;
        this.f47005b = "ec.saveCardStateExtra";
        this.f47006c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Map<String, ? extends Object> r103 = (Map) this.f47007d.invoke(r101);
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.g(r101, r103, this.f47005b);
        r102.invoke(r103);
    }
}
