package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallGetBCMFullChainJSB extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.getBCMFullChain";
    }

    public ECMallGetBCMFullChainJSB(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, final Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        ALogger.c(ALogger.f41996d, "ec.getBCMFullChain", new ECMallGetBCMFullChainJSB$handleCall$1(r102));
        Object r104 = r102.get("chainLength");
        JSONObject r105 = null;
        if ((r104 instanceof Integer) == true) goto L5;
        r104 = null;
    L5:
        Integer r106 = (Integer) r104;
        if (r106 == null) goto L8;
        int r107 = r106.intValue();
    L9:
        Object r108 = r102.get("isDomainStandard");
        if ((r108 instanceof Boolean) == true) goto L12;
        r108 = null;
    L12:
        kc.a r109 = com.bytedance.android.bcm.api.b.f41761a.getBcmChainByFinder(null, CollectionsKt.listOf("ecom_entrance"), r107, Intrinsics.areEqual((Boolean) r108, Boolean.TRUE));
        if (r109 == null) goto L15;
        r105 = r109.a();
    L15:
        if (r105 != null) goto L17;
        r103.put("err_message", "params is empty");
    L19:
        return qf3.e.f(this);
    L17:
        r103.put("content", r105);
        goto L19
    L8:
        r107 = 20;
        goto L9
    }
}
