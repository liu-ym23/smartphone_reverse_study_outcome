package com.android.server.usb;

import android.pico.utils.IExtBase;
import android.util.ArrayMap;
import com.android.internal.util.dump.DualDumpOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtUsbPortManager extends IExtBase {
    void dump(DualDumpOutputStream r1);

    void systemReady();

    void updateContaminantNotificationNew(ArrayMap<String, UsbPortManager.PortInfo> r1);

    void updateOtgStatusLocked(boolean r1);
}
