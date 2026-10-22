package com.android.server.deviceidle;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public class TvConstraintController implements ConstraintController {
    private final BluetoothConstraint mBluetoothConstraint;
    private final Context mContext;
    private final DeviceIdleInternal mDeviceIdleService;
    private final Handler mHandler;

    public TvConstraintController(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
        this.mDeviceIdleService = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        PackageManager pm = context.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.bluetooth") == false) goto L5;
        BluetoothConstraint r1 = new BluetoothConstraint(this.mContext, this.mHandler, this.mDeviceIdleService);
    L6:
        this.mBluetoothConstraint = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void start() {
        if (this.mBluetoothConstraint == null) goto L6;
        this.mDeviceIdleService.registerDeviceIdleConstraint(this.mBluetoothConstraint, "bluetooth", 1);
        return;
    }

    public void stop() {
        if (this.mBluetoothConstraint == null) goto L6;
        this.mDeviceIdleService.unregisterDeviceIdleConstraint(this.mBluetoothConstraint);
        return;
    }
}
