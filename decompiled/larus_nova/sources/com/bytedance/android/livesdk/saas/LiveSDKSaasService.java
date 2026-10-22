package com.bytedance.android.livesdk.saas;

import com.bytedance.android.livesdk.config.np0;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.android.livesdk.provideservices.SaaSInternalServiceImpl;
import com.bytedance.android.livesdkapi.service.ISaaSInternalService;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/saas/LiveSDKSaasService;", "Lcom/bytedance/android/livesdk/saas/ILiveSDKSaasService;", "()V", "createLiveServiceApiImpl", "Lcom/bytedance/android/livesdkapi/service/ISaaSInternalService;", "saasCopyableDebugItems", "", "", "supportFeature", "", "feature", "Lcom/bytedance/android/livesdk/saas/OptionalFeatures;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveSDKSaasService implements ILiveSDKSaasService {
    @Override // com.bytedance.android.livesdk.saas.ILiveSDKSaasService
    public Map<String, String> saasCopyableDebugItems() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("saas 完全同构 setting enable", String.valueOf(np0.f120851a.getValue().booleanValue())), TuplesKt.to("sdk_githash", "740f86880f"), TuplesKt.to("liveSdkVersion_webcast_sdk_version", String.valueOf(c.b())), TuplesKt.to("LiveSDKConstUtil_webcast_sdk_version", LiveSDKConstUtil.getSdkVersion()), TuplesKt.to("BuildConfig_webcast_sdk_version", String.valueOf(4210))});
    }

    public LiveSDKSaasService() {
        k.l(LiveSDKSaasService.class, this);
    }

    @Override // com.bytedance.android.livesdk.saas.ILiveSDKSaasService
    public ISaaSInternalService createLiveServiceApiImpl() {
        return SaaSInternalServiceImpl.f156752n;
    }

    @Override // com.bytedance.android.livesdk.saas.ILiveSDKSaasService
    public boolean supportFeature(OptionalFeatures r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        switch(a.f157866a[r100.ordinal()]) {
            case 1: goto L6;
            case 2: goto L8;
            case 3: goto L6;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L8;
            default: goto L5;
        };
    L6:
        return false;
    L8:
        return true;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
