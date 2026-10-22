package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.window.DesktopModeFlags;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatSandboxingPolicy {
    private final ActivityRecord mActivityRecord;

    AppCompatSandboxingPolicy(ActivityRecord activityRecord) {
        this.mActivityRecord = activityRecord;
    }

    void sandboxBoundsIfNeeded(Configuration resolvedConfig, int windowingMode) {
        if (DesktopModeFlags.EXCLUDE_CAPTION_FROM_APP_BOUNDS.isTrue() == true) goto L6;
        return;
    L6:
        if (AppCompatUtils.isInDesktopMode(this.mActivityRecord.mAtmService.mContext, windowingMode) == false) goto L14;
        Rect appBounds = resolvedConfig.windowConfiguration.getAppBounds();
        if (appBounds != null) goto L10;
    L11:
        appBounds = this.mActivityRecord.mResolveConfigHint.mParentAppBoundsOverride;
    L12:
        resolvedConfig.windowConfiguration.setBounds(appBounds);
        return;
    L10:
        if (appBounds.isEmpty() == false) goto L12;
    }
}
