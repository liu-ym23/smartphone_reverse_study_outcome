package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186933a = 0;

    public static void a() {
        Intrinsics.checkNotNullParameter("ecom_store_rerank", "businessName");
        String r100 = ECAppInfoService.f48114e.getAppId();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        PitayaCoreFactory.getCore(r100).runTask("ecom_store_rerank", new PTYTaskData(null), new PTYTaskConfig(false, null, 0.0f, 7, null), new ECShopProductListPitayaManager$runTask$1());
    }

    static {
    }
}
