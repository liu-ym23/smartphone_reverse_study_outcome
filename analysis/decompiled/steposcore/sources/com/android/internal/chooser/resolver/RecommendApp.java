package com.android.internal.chooser.resolver;

import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.chooser.AppInfo;

/* loaded from: classes.dex */
public enum RecommendApp {
    GALLERY("com.stepos.media.gallery"),
    MUSIC("com.stepos.media.music"),
    VIDEO("com.stepos.media.video"),
    DOCUMENT(AppInfo.WPS_PACKAGE_NAME),
    FILE_MANAGER("com.stepos.filemanager");

    private String packageName;

    RecommendApp(String packageName) {
        this.packageName = packageName;
    }

    private static RecommendApp getAppInfo(ComponentInfo info) {
        for (RecommendApp appInfo : values()) {
            if (info.packageName.equals(appInfo.packageName)) {
                return appInfo;
            }
        }
        return null;
    }

    public static boolean isRecommendApp(ResolveInfo info) {
        RecommendApp appInfo = getAppInfo(info.getComponentInfo());
        return appInfo != null;
    }
}
