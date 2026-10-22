package com.bytedance.android.ec.hybrid.bridge;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "USE ECHybridAsyncStatefulBridge")
public class c implements IDLXBridgeMethod, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Map<String, ? extends Object>, IDLXBridgeMethod.a, Unit> f46301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46302d;

    public static final class a implements IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f46303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f46304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f46305c;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f46304b.invoke(r100);
            Lazy r101 = ECMallLogUtil.f47441a;
            ECMallLogUtil.g(this.f46305c, r100, this.f46303a.f46302d);
        }

        public a(c r100, IDLXBridgeMethod.a r101, Map r102) {
            this.f46303a = r100;
            this.f46304b = r101;
            this.f46305c = r102;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46299a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46300b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46302d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2<? super Map<String, ? extends Object>, ? super IDLXBridgeMethod.a, Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f46301c = r100;
        this.f46302d = r101;
        this.f46299a = IDLXBridgeMethod.Access.PUBLIC;
        this.f46300b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a r103 = new a(this, r102, r101);
        this.f46301c.invoke(r101, r103);
    }
}
