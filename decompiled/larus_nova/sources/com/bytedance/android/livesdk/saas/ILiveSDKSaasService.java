package com.bytedance.android.livesdk.saas;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.service.ISaaSInternalService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.saas.LiveSDKSaasService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/saas/ILiveSDKSaasService;", "Lcom/bytedance/android/live/base/IService;", "createLiveServiceApiImpl", "Lcom/bytedance/android/livesdkapi/service/ISaaSInternalService;", "saasCopyableDebugItems", "", "", "supportFeature", "", "feature", "Lcom/bytedance/android/livesdk/saas/OptionalFeatures;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveSDKSaasService extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.saas.ILiveSDKSaasService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ISaaSInternalService $default$createLiveServiceApiImpl(ILiveSDKSaasService r100) {
            return null;
        }

        public static boolean $default$supportFeature(ILiveSDKSaasService r100, OptionalFeatures r101) {
            Intrinsics.checkNotNullParameter(r101, "feature");
            return false;
        }

        public static Map $default$saasCopyableDebugItems(ILiveSDKSaasService r100) {
            return MapsKt.emptyMap();
        }
    }

    ISaaSInternalService createLiveServiceApiImpl();

    Map<String, String> saasCopyableDebugItems();

    boolean supportFeature(OptionalFeatures r100);
}
