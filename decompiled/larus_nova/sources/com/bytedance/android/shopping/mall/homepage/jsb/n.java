package com.bytedance.android.shopping.mall.homepage.jsb;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178208d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f178208d;
    }

    public n(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f178208d = "ec.mall.showToast";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r110, Map<String, Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "result");
        Object r102 = r110.get("content");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r104 = (String) r102;
        int r105 = 0;
        if (r104 != null) goto L8;
    L11:
        boolean r112 = true;
    L12:
        if (r112 == false) goto L16;
        return TuplesKt.to(Boolean.FALSE, "content is empty");
    L16:
        if (Intrinsics.areEqual(r110.get(GXTemplateKey.GAIAX_LAYER_GRAVITY), "top") == false) goto L18;
        int r106 = 48;
    L19:
        Object r113 = r110.get("xOffset");
        if ((r113 instanceof Integer) == true) goto L22;
        r113 = null;
    L22:
        Integer r114 = (Integer) r113;
        if (r114 == null) goto L25;
        int r115 = r114.intValue();
    L26:
        Object r107 = r110.get("yOffset");
        if ((r107 instanceof Integer) == true) goto L29;
        r107 = null;
    L29:
        Integer r108 = (Integer) r107;
        if (r108 == null) goto L32;
        r105 = r108.intValue();
    L32:
        Object r116 = r110.get("duration");
        if ((r116 instanceof Integer) == false) goto L36;
        r103 = r116;
    L36:
        Integer r109 = (Integer) r103;
        if (r109 == null) goto L39;
        int r117 = r109.intValue();
    L48:
        int r118 = com.bytedance.android.shopping.mall.widget.b.f178631h;     // Catch: Exception -> L42
        com.bytedance.android.shopping.mall.widget.b.a.a(r100.f532722a, r104, r106, b0.c(Integer.valueOf(r115)), b0.c(Integer.valueOf(r105)), r117);     // Catch: Exception -> L42
        return TuplesKt.to(Boolean.TRUE, "show toast success.");
    L42:
        e = move-exception;
        if (HybridAppInfoService.f47545p.isLocalTest() == true) goto L47;
        EnsureManager.ensureNotReachHere(e);
        return TuplesKt.to(Boolean.FALSE, String.valueOf(e.getMessage()));
    L47:
        throw e;
    L39:
        r117 = 3000;
        goto L48
    L25:
        r115 = 0;
        goto L26
    L18:
        r106 = 17;
        goto L19
    L8:
        if (r104.length() == 0) goto L11;
        r112 = false;
        goto L12
    }
}
