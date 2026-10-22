package com.android.server.usb.hal.port;

import com.android.internal.util.IndentingPrintWriter;
import com.android.server.usb.UsbPortManager;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbPortHalInstance {
    public UsbPortHalInstance() {
    }

    public static UsbPortHal getInstance(UsbPortManager portManager, IndentingPrintWriter pw) {
        UsbPortManager.logAndPrint(3, null, "Querying USB HAL version");
        if (UsbPortAidl.isServicePresent(null) == false) goto L7;
        UsbPortManager.logAndPrint(4, null, "USB HAL AIDL present");
        return new UsbPortAidl(portManager, pw);
    L7:
        if (UsbPortHidl.isServicePresent(null) == false) goto L10;
        UsbPortManager.logAndPrint(4, null, "USB HAL HIDL present");
        return new UsbPortHidl(portManager, pw);
    L10:
        return null;
    }
}
