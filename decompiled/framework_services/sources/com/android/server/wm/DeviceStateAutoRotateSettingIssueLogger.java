package com.android.server.wm;

import android.util.MathUtils;
import com.android.internal.util.FrameworkStatsLog;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStateAutoRotateSettingIssueLogger {
    static final long DEVICE_STATE_AUTO_ROTATE_SETTING_ISSUE_THRESHOLD_MILLIS = 1500;
    private static final long TIME_NOT_SET = -1;
    private final LongSupplier mElapsedTimeMillisSupplier;
    private long mLastDeviceStateAutoRotateSettingChangeTime;
    private long mLastDeviceStateChangeTime;

    public DeviceStateAutoRotateSettingIssueLogger(LongSupplier elapsedTimeMillisSupplier) {
        this.mLastDeviceStateChangeTime = -1;
        this.mLastDeviceStateAutoRotateSettingChangeTime = -1;
        this.mElapsedTimeMillisSupplier = elapsedTimeMillisSupplier;
    }

    public void onDeviceStateChange() {
        this.mLastDeviceStateChangeTime = this.mElapsedTimeMillisSupplier.getAsLong();
        onStateChange();
    }

    public void onDeviceStateAutoRotateSettingChange() {
        this.mLastDeviceStateAutoRotateSettingChangeTime = this.mElapsedTimeMillisSupplier.getAsLong();
        onStateChange();
    }

    private void onStateChange() {
        if (this.mLastDeviceStateChangeTime != (-1)) goto L5;
        return;
    L5:
        if (this.mLastDeviceStateAutoRotateSettingChangeTime == (-1)) goto L21;
        long duration = this.mLastDeviceStateAutoRotateSettingChangeTime - this.mLastDeviceStateChangeTime;
        if (duration <= 0) goto L10;
        boolean isDeviceStateChangeFirst = true;
    L12:
        if (MathUtils.abs(duration) >= 1500.0f) goto L14;
        FrameworkStatsLog.write(1011, (int) MathUtils.abs(duration), isDeviceStateChangeFirst);
        this.mLastDeviceStateAutoRotateSettingChangeTime = -1;
        this.mLastDeviceStateChangeTime = -1;
        return;
    L14:
        if (isDeviceStateChangeFirst == false) goto L16;
        this.mLastDeviceStateChangeTime = -1;
        return;
    L16:
        this.mLastDeviceStateAutoRotateSettingChangeTime = -1;
        return;
    L10:
        isDeviceStateChangeFirst = false;
        goto L12
    }
}
