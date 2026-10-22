package com.android.server.usb;

import android.content.Context;
import android.content.Intent;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtUsbDeviceManager extends IExtBase {
    boolean handleUsbDialogRestoreState(boolean r1, boolean r2);

    void startUsbSettingsActivity(Intent r1, Context r2);

    void updateConnectionState(boolean r1);

    void updateUsbPortConnectionState(boolean r1);

    void updateUsbReconnectState(int r1, boolean r2);
}
