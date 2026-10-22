package com.android.internal.chooser.resolver;

import android.app.Activity;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ResolverUsageStats {
    private static final String USAGE_CUSTOM_PACKAGE_NAME = "com.stepos.stepos.sdk";
    private static final String USAGE_EVENT_NAME_OPENED_COUNT = "sdk_stepos_resolver_fileopen_show";
    private static final String USAGE_EVENT_NAME_SELECT_ALWAYS_USE_OPEN = "sdk_stepos_resolver_whether_tick";
    private static final String USAGE_EVENT_NAME_SELECT_WHICH_COUNT = "sdk_stepos_resolver_app_selected_times";
    private static final String USAGE_NAME_SELECT_WHICH_COUNT_WITH_PACKAGE = "sdk_stepos_resolver_app_selected_times_with_package";

    public static void onActivityStart(Activity activity) {
    }

    public static void onTargetClick(Activity activity, ResolveInfo resolveInfo, boolean isChecked) {
        try {
            ComponentInfo aCi = resolveInfo.getComponentInfo();
            Map<String, String> properties = new HashMap<>();
            properties.put(USAGE_NAME_SELECT_WHICH_COUNT_WITH_PACKAGE, aCi.name);
        } catch (Exception e) {
            LogUtils.e("UsageStatsNonVccProxy3 error");
        }
    }
}
