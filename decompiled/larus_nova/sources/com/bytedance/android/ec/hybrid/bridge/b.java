package com.bytedance.android.ec.hybrid.bridge;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b extends a implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46298c;

    public abstract Pair<Boolean, String> a(IBDXBridgeContext r100, Map<String, ? extends Object> r101, Map<String, Object> r102);

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46298c;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f46298c = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        LinkedHashMap r102 = new LinkedHashMap();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(a(r100, r101, r102));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        String r106 = "";
        if (r105 == null) goto L10;
        String r107 = r105.toString();
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        r104 = null;
    L14:
        Pair r108 = (Pair) r104;
        if (r108 != null) goto L17;
        r108 = new Pair(Boolean.FALSE, "ECHybridStatefulBridge Error: " + r107);
    L17:
        boolean r109 = ((Boolean) r108.component1()).booleanValue();
        String r111 = (String) r108.component2();
        Pair[] r112 = new Pair[3];
        r112[0] = TuplesKt.to("code", Integer.valueOf(r109 ? 1 : 0));
        if (r111 == null) goto L21;
        r106 = r111;
    L21:
        r112[1] = TuplesKt.to("msg", r106);
        r112[2] = TuplesKt.to("data", r102);
        Map<String, ? extends Object> r113 = MapsKt.mapOf(r112);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r113, "result");
        Lazy r114 = ECMallLogUtil.f47441a;
        ECMallLogUtil.g(r101, r113, this.f46298c);
        r110.invoke(r113);
        return;
    L10:
        r107 = "";
    L5:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
