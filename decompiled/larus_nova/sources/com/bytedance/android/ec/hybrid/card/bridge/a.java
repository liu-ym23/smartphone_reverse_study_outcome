package com.bytedance.android.ec.hybrid.card.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.hybrid.bridge.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.card.api.e f46409d;

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.card.bridge.a$a, reason: collision with other inner class name */
    public static final class C0816a {
    }

    static {
    }

    public a(com.bytedance.android.ec.hybrid.card.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxCard");
        super("ec.lynxCardSetData");
        this.f46409d = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.bridge.b
    public final Pair<Boolean, String> a(IBDXBridgeContext r100, Map<String, ? extends Object> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "result");
        Object r103 = r101.get("disableReset");
        if ((r103 instanceof Boolean) == true) goto L5;
        r103 = null;
    L5:
        Boolean r104 = (Boolean) r103;
        Object r105 = r101.get("data");
        if (r105 == null) goto L11;
        if ((r105 instanceof Map) == false) goto L11;
        com.bytedance.android.ec.hybrid.card.api.e r106 = this.f46409d;
        int r107 = com.bytedance.android.ec.hybrid.card.api.d.f46381e;
        r106.e(com.bytedance.android.ec.hybrid.card.api.d.a.c("", (Map) r105), !Intrinsics.areEqual(r104, Boolean.TRUE));
    L11:
        return TuplesKt.to(Boolean.TRUE, "success");
    }
}
