package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f177133d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f177133d;
    }

    public t(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f177133d = "ec.getHomePageMallSource";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        if (r104 == null) goto L7;
        yj.f r105 = r104.getHybridECSdkService();
        if (r105 == null) goto L7;
        r105.getHomePageMallSource();
        Integer r106 = 0;
    L8:
        r103.put("mallSourceType", r106);
        return qf3.e.f(this);
    L7:
        r106 = null;
        goto L8
    }
}
