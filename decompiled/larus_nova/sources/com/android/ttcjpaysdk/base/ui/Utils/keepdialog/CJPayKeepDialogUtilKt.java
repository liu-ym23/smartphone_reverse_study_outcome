package com.android.ttcjpaysdk.base.ui.Utils.keepdialog;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"lynxCardInitDataWrapUp", "", "", "", "initData", "Lorg/json/JSONObject;", "initDataToString", "", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogUtilKt {
    public static final Map<String, Object> lynxCardInitDataWrapUp(JSONObject r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L6;
        if (r101 == false) goto L6;
        boolean r103 = true;
    L7:
        KtSafeMethodExtensionKt.safePut(r102, "cj_data", KtSafeMethodExtensionKt.tf(r103, String.valueOf(r100), r100));
        KtSafeMethodExtensionKt.safePut(r102, "cj_sdk_version", CJPayBasicUtils.getRealVersion());
        KtSafeMethodExtensionKt.safePut(r102, "cj_sdk_plugin_version", CJPayBasicUtils.getVersionName());
        KtSafeMethodExtensionKt.safePut(r102, "cj_sdk_plugin_version_code", Integer.valueOf(CJPayBasicUtils.getSDKVersionCode()));
        KtSafeMethodExtensionKt.safePut(r102, "cj_host_plugin_version_code", Long.valueOf(CJPayBasicUtils.getPluginVerCodeHost()));
        KtSafeMethodExtensionKt.safePut(r102, "cj_version", 1);
        return MapsKt.mapOf(TuplesKt.to("cj_initial_props", r102));
    L6:
        r103 = false;
        goto L7
    }

    public static /* synthetic */ Map lynxCardInitDataWrapUp$default(JSONObject r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        return lynxCardInitDataWrapUp(r100, r101);
    }
}
