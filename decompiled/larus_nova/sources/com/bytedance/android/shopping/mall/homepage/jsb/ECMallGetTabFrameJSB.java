package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallGetTabFrameJSB extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.mallGetTabFrame";
    }

    public ECMallGetTabFrameJSB(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(final qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Object r104 = r102.get("tabID");
        Object r105 = null;
        if ((r104 instanceof String) == true) goto L5;
        r104 = null;
    L5:
        final String r106 = (String) r104;
        Object r107 = r102.get("tabPosition");
        if ((r107 instanceof String) == false) goto L9;
        r105 = r107;
    L9:
        final String r108 = (String) r105;
        p.b(r103, new ECMallGetTabFrameJSB$handleCall$1(r100, r106, r108));
        return qf3.e.f(this);
    }
}
