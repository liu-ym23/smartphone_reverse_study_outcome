package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toJSON", "Lorg/json/JSONObject;", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainLynxRequest;", "bdpay-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainLynxRequestKt {
    public static final JSONObject toJSON(CJPayRetainLynxRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        JSONObject r102 = r100.getApiData().getPiyataResponse().getGrowthViewModel();
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "process", r100.getApiData().getContactInfo().getProcess());
        KtSafeMethodExtensionKt.safePut(r103, "function", r100.getApiData().getContactInfo().getFunction());
        KtSafeMethodExtensionKt.safePut(r103, "behavior", r100.getApiData().getContactInfo().getBehavior());
        KtSafeMethodExtensionKt.safePut(r103, UserInfo.USERSTATE, r100.getApiData().getContactInfo().getUserState());
        KtSafeMethodExtensionKt.safePut(r102, "exts", new JSONObject(r100.getApiData().getExts()));
        KtSafeMethodExtensionKt.safePut(r102, "response_common_params", new JSONObject(r100.getApiData().getCommonParams()));
        KtSafeMethodExtensionKt.safePut(r101, "api_data", r102);
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "id", r100.getExtraData().getId());
        KtSafeMethodExtensionKt.safePut(r104, "is_bio_degrade", r100.getExtraData().isBioDegrade());
        KtSafeMethodExtensionKt.safePut(r104, "is_fingerprint_local_enable", Boolean.valueOf(r100.getExtraData().isFingerprintLocalEnable()));
        JSONObject r105 = r100.getExtraData().getAssetMetaInfo();
        if (r105 == null) goto L5;
        KtSafeMethodExtensionKt.safePut(r104, "asset_meta_info", r105);
    L5:
        KtSafeMethodExtensionKt.safePut(r104, "common_params", new JSONObject(r100.getExtraData().getCommonParams()));
        KtSafeMethodExtensionKt.safePut(r101, "extra_data", r104);
        return r101;
    }
}
