package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMarketingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f178471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f178472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECMarketingHelper$scrollerListener$1 f178473c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.mall.homepage.tools.ECMarketingHelper$scrollerListener$1] */
    public ECMarketingHelper() {
        this.f178471a = "";
        this.f178473c = new ECMarketingHelper$scrollerListener$1(this);
    }

    public static IMarketingServiceV2 a() {
        ServiceManager r100 = ServiceManager.get();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (IMarketingServiceV2) r100.getService(IMarketingServiceV2.class);
    }
}
