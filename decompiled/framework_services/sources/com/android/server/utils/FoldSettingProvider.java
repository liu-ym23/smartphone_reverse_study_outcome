package com.android.server.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.android.internal.foldables.FoldLockSettingAvailabilityProvider;
import com.android.internal.util.SettingsWrapper;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class FoldSettingProvider {
    private static final Set<String> SETTING_VALUES = null;
    private static final String SETTING_VALUE_DEFAULT = "selective_stay_awake_key";
    public static final String SETTING_VALUE_SELECTIVE_STAY_AWAKE = "selective_stay_awake_key";
    public static final String SETTING_VALUE_SLEEP_ON_FOLD = "sleep_on_fold_key";
    public static final String SETTING_VALUE_STAY_AWAKE_ON_FOLD = "stay_awake_on_fold_key";
    private static final String TAG = "FoldSettingProvider";
    private final ContentResolver mContentResolver;
    private final FoldLockSettingAvailabilityProvider mFoldLockSettingAvailabilityProvider;
    private final SettingsWrapper mSettingsWrapper;

    static {
        SETTING_VALUES = Set.of(SETTING_VALUE_STAY_AWAKE_ON_FOLD, "selective_stay_awake_key", SETTING_VALUE_SLEEP_ON_FOLD);
    }

    public FoldSettingProvider(Context context, SettingsWrapper settingsWrapper, FoldLockSettingAvailabilityProvider foldLockSettingAvailabilityProvider) {
        this.mContentResolver = context.getContentResolver();
        this.mSettingsWrapper = settingsWrapper;
        this.mFoldLockSettingAvailabilityProvider = foldLockSettingAvailabilityProvider;
    }

    public boolean shouldStayAwakeOnFold() {
        return getFoldSettingValue().equals(SETTING_VALUE_STAY_AWAKE_ON_FOLD);
    }

    public boolean shouldSelectiveStayAwakeOnFold() {
        return getFoldSettingValue().equals("selective_stay_awake_key");
    }

    public boolean shouldSleepOnFold() {
        return getFoldSettingValue().equals(SETTING_VALUE_SLEEP_ON_FOLD);
    }

    private String getFoldSettingValue() {
        boolean isFoldLockBehaviorAvailable = this.mFoldLockSettingAvailabilityProvider.isFoldLockBehaviorAvailable();
        String foldSettingValue = "selective_stay_awake_key";
        if (isFoldLockBehaviorAvailable == true) goto L5;
        return "selective_stay_awake_key";
    L5:
        String foldSettingValue2 = this.mSettingsWrapper.getStringForUser(this.mContentResolver, "fold_lock_behavior_setting", -2);
        if (foldSettingValue2 == null) goto L9;
        foldSettingValue = foldSettingValue2;
    L9:
        if (SETTING_VALUES.contains(foldSettingValue) == true) goto L12;
        Log.e(TAG, "getFoldSettingValue: Invalid setting value, returning default setting value");
        return "selective_stay_awake_key";
    L12:
        return foldSettingValue;
    }
}
