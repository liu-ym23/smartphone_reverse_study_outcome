package com.bytedance.android.ec.hybrid.bridge;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "USE ECHybridStatefulBridge")
public class LynxStatefulBridgeProxy extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Map<String, ? extends Object>, Map<String, Object>> f46294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f46295e;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46295e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LynxStatefulBridgeProxy(final Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Intrinsics.checkNotNullParameter(r101, "name");
        super(new AnonymousClass1(r100), r101);
        this.f46294d = r100;
        this.f46295e = r101;
    }
}
