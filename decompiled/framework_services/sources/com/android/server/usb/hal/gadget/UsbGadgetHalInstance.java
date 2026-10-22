package com.android.server.usb.hal.gadget;

import com.android.internal.util.IndentingPrintWriter;
import com.android.server.usb.UsbDeviceManager;
import com.android.server.usb.UsbPortManager;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbGadgetHalInstance {
    public UsbGadgetHalInstance() {
    }

    public static UsbGadgetHal getInstance(UsbDeviceManager deviceManager, IndentingPrintWriter pw) {
        UsbPortManager.logAndPrint(3, pw, "Querying USB Gadget HAL version");
        if (UsbGadgetAidl.isServicePresent(null) == false) goto L7;
        UsbPortManager.logAndPrint(4, pw, "USB Gadget HAL AIDL present");
        return new UsbGadgetAidl(deviceManager, pw);
    L7:
        if (UsbGadgetHidl.isServicePresent(null) == false) goto L10;
        UsbPortManager.logAndPrint(4, pw, "USB Gadget HAL HIDL present");
        return new UsbGadgetHidl(deviceManager, pw);
    L10:
        UsbPortManager.logAndPrint(6, pw, "USB Gadget HAL AIDL/HIDL not present");
        return null;
    }
}
