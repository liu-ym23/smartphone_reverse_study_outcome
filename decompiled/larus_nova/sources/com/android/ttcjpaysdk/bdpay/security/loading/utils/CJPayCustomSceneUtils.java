package com.android.ttcjpaysdk.bdpay.security.loading.utils;

import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.settings.bean.CJPaySecurityLoadingConfig;
import com.android.ttcjpaysdk.base.ui.data.CJPaySecurityLoadingStyleInfo;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/utils/CJPayCustomSceneUtils;", "", "()V", "TAG", "", "getRepeatGifByScene", "scene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "loadingObject", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig$CJPaySecurityLoadingExperimentObject;", "defVal", "getShowInfoByScene", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo$CJPaySecurityItemShowInfo;", "loadingInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo;", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCustomSceneUtils {
    public static final CJPayCustomSceneUtils INSTANCE = null;
    private static final String TAG = null;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ICJPaySecurityLoadingService.LoadingCustomScene.values().length];
            r100[ICJPaySecurityLoadingService.LoadingCustomScene.VERIFY_PRE_LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ICJPaySecurityLoadingService.LoadingCustomScene.LOADING_ROUND_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private CJPayCustomSceneUtils() {
    }

    static {
        INSTANCE = new CJPayCustomSceneUtils();
        TAG = "CJPayCustomSceneUtils";
    }

    public final String getRepeatGifByScene(ICJPaySecurityLoadingService.LoadingCustomScene r100, CJPaySecurityLoadingConfig.CJPaySecurityLoadingExperimentObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        CJLogger.d(TAG, "getRepeatGifByScene " + r100);
        int r103 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r103 != 1) goto L5;
        if (r101 != null) goto L14;
    L12:
        return null;
    L14:
        return r101.dialog_repeat_gif;
    L5:
        if (r103 != 2) goto L15;
        if (r101 == null) goto L12;
        return r101.dialog_repeat_round_gif;
    L15:
        return r102;
    }

    public final CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo getShowInfoByScene(ICJPaySecurityLoadingService.LoadingCustomScene r100, CJPaySecurityLoadingStyleInfo r101, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        CJLogger.d(TAG, "getShowInfoByScene " + r100);
        if (WhenMappings.$EnumSwitchMapping$0[r100.ordinal()] != 1) goto L8;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.pay_verify_pre_show_info;
    L8:
        return r102;
    }
}
