package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IBatteryServiceOptEx {
    default void init(Context context, BatteryService batteryService) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void initPowerMonitor() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean onTransactOptEx(int code, Parcel data, Parcel reply, int pid, int uid) throws RemoteException {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
