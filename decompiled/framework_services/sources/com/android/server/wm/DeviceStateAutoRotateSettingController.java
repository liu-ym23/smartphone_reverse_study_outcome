package com.android.server.wm;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStateAutoRotateSettingController {
    private final Context mContext;
    private final DeviceStateAutoRotateSettingIssueLogger mDeviceStateAutoRotateSettingIssueLogger;
    private final Handler mHandler;

    public DeviceStateAutoRotateSettingController(Context context, DeviceStateAutoRotateSettingIssueLogger deviceStateAutoRotateSettingIssueLogger, Handler handler) {
        this.mDeviceStateAutoRotateSettingIssueLogger = deviceStateAutoRotateSettingIssueLogger;
        this.mContext = context;
        this.mHandler = handler;
        registerDeviceStateAutoRotateSettingObserver();
    }

    public void onDeviceStateChange(DeviceStateController.DeviceState deviceState) {
    }

    private void registerDeviceStateAutoRotateSettingObserver() {
        ContentResolver r0 = this.mContext.getContentResolver();
        Uri r1 = Settings.Secure.getUriFor("device_state_rotation_lock");
        final Handler r3 = this.mHandler;
        r0.registerContentObserver(r1, false, new AnonymousClass1(this, r3));
    }
}
