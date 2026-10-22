package com.android.server.usb.hal.gadget;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface UsbGadgetHal {
    void getCurrentUsbFunctions(long r1);

    int getGadgetHalVersion() throws RemoteException;

    void getUsbSpeed(long r1);

    void reset(long r1);

    void setCurrentUsbFunctions(int r1, long r2, boolean r4, int r5, long r6);
}
