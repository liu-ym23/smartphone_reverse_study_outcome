package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdleControllerOptEx {
    default void init(DeviceIdleController controller, Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean removePowerSaveWhitelistApp(String name) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean addPowerSaveWhitelistApp(String name) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void updateQuickDozeFlag(boolean enabled) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void registerReceiver(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void initDozeWhitelist(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDozeMode(boolean lightDoze, boolean deepDoze) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
