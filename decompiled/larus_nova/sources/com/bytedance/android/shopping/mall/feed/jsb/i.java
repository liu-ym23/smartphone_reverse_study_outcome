package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f177118d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f177118d;
    }

    public i(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f177118d = "ec.deepFeedPreParseUrl";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Object r104 = r102.get("url");
        if ((r104 instanceof String) == true) goto L5;
        r104 = null;
    L5:
        String r105 = (String) r104;
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
        IECMallHostService r107 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r107 == null) goto L19;
        r107.preloadDeepFeedSchema(r105);
    L19:
        return qf3.e.f(this);
    L14:
        return qf3.e.c("url is null or empty");
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
