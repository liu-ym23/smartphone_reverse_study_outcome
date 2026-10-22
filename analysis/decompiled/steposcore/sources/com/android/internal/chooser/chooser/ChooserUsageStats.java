package com.android.internal.chooser.chooser;

import android.app.Activity;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ChooserUsageStats {
    private static final String USAGE_CUSTOM_PACKAGE_NAME = "com.stepos.stepos.sdk";
    private static final String USAGE_EVENT_NAME_OPENED_COUNT = "sdk_share_view_open_show";
    private static final String USAGE_EVENT_NAME_SELECT_ALWAYS_USE_OPEN = "sdk_share_view_whether_tick";
    private static final String USAGE_EVENT_NAME_SELECT_WHICH_COUNT = "sdk_share_view_app_shareto";
    private static final String USAGE_NAME_OPENED_COUNT_FORM_PACKAGE = "sdk_share_view_open_form_package";
    private static final String USAGE_NAME_SELECT_WHICH_COUNT_WITH_PACKAGE = "sdk_share_view_app_selected_shareto_with_package";

    public static void onActivityStart(Activity activity, String packageName) {
        try {
            new HashMap();
        } catch (Exception e) {
            LogUtils.e("UsageStatsNonVccProxy3 error");
        }
    }

    public static void onTargetClick(Activity activity, ResolveInfo resolveInfo, boolean isChecked) {
        try {
            Map<String, String> properties = new HashMap<>();
            properties.put(USAGE_NAME_SELECT_WHICH_COUNT_WITH_PACKAGE, resolveInfo.getComponentInfo().name);
        } catch (Exception e) {
            LogUtils.e("UsageStatsNonVccProxy3 error");
        }
    }
}
