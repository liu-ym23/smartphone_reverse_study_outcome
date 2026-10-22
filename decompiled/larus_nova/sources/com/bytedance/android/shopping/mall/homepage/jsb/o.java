package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178209d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f178209d;
    }

    public o(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f178209d = "ecomSwtichTaskBannerVisible";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        JSONObject r104 = new JSONObject(r102);
        r104.optString("containerID");
        r104.optInt("visible", 0);
        IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();
        if (r105 == null) goto L8;
        yj.f r106 = r105.getHybridECSdkService();
        if (r106 == null) goto L8;
        r106.f();
    L8:
        return qf3.e.f(this);
    }
}
