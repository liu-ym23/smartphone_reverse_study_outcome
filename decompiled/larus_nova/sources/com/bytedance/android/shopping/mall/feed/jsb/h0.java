package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h0 extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f177117d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f177117d;
    }

    public h0(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f177117d = "ec.mallSchemaMonitor";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Object r104 = r102.get("scene");
        Object r105 = null;
        if ((r104 instanceof String) == true) goto L5;
        r104 = null;
    L5:
        String r106 = (String) r104;
        Object r107 = r102.get("params");
        if ((r107 instanceof String) == true) goto L8;
        r107 = null;
    L8:
        String r108 = (String) r107;
        if (r106 == null) goto L20;
        if (r108 == null) goto L20;
        Object r109 = r102.get("contextProvider");
        if ((r109 instanceof String) == true) goto L14;
        r109 = null;
    L14:
        String r110 = (String) r109;
        Object r111 = r102.get("scriptPath");
        if ((r111 instanceof String) == false) goto L18;
        r105 = r111;
    L18:
        String r112 = (String) r105;
        com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostECSchemaMonitorService();
        return qf3.e.f(this);
    L20:
        return qf3.e.c("scene or params is null");
    }
}
