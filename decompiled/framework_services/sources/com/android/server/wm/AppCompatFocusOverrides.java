package com.android.server.wm;

import com.android.server.wm.utils.OptPropFactory;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatFocusOverrides {
    final ActivityRecord mActivityRecord;
    private final OptPropFactory.OptProp mFakeFocusOptProp;

    AppCompatFocusOverrides(ActivityRecord activityRecord, final AppCompatConfiguration appCompatConfiguration, OptPropFactory optPropBuilder) {
        this.mActivityRecord = activityRecord;
        appCompatConfiguration.getClass();
        this.mFakeFocusOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ENABLE_FAKE_FOCUS", new AppCompatFocusOverrides$$ExternalSyntheticLambda0(appCompatConfiguration));
    }

    boolean shouldSendFakeFocus() {
        if (this.mFakeFocusOptProp.shouldEnableWithOverrideAndProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 263259275)) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mActivityRecord.inMultiWindowMode() == false) goto L11;
        if (this.mActivityRecord.inPinnedWindowingMode() == true) goto L11;
        if (this.mActivityRecord.inFreeformWindowingMode() == true) goto L11;
        return true;
    }
}
