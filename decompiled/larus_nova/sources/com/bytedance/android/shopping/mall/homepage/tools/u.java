package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f178542a = 0;

    static {
    }

    public static boolean a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "pageInfoMap");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L22
        v93.a.f553778c.getClass();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter("pitaya_analyze_interest_on_good", "business");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter("lastest_ecom_video_behavior", "key");     // Catch: Throwable -> L22
        IFeatureCore r102 = FeatureCoreFactory.INSTANCE.getFeatureCore(String.valueOf(HybridAppInfoService.f47545p.getAppId()));     // Catch: Throwable -> L22
        Unit r103 = null;
        if (r102 == null) goto L8;
        IKVStore r104 = r102.createInMemoryKVStore("pitaya_analyze_interest_on_good");     // Catch: Throwable -> L22
        if (r104 == null) goto L8;
        Object r105 = r104.getValueForKey("lastest_ecom_video_behavior");     // Catch: Throwable -> L22
    L9:
        if (r105 == null) goto L20;
        String r106 = r105.toString();     // Catch: Throwable -> L22
        if (r106 == null) goto L20;
        String r107 = new JSONObject(r106).optString("group_id");     // Catch: Throwable -> L22
        if (r107.length() <= 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L18:
        return Intrinsics.areEqual(r107, r100.get("groupId"));
    L15:
        r108 = false;
    L20:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L22
    L24:
        return false;
    L8:
        r105 = null;
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
