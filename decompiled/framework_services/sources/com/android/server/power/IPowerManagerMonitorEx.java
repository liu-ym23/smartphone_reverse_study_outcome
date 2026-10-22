package com.android.server.power;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public interface IPowerManagerMonitorEx {
    default void init(PowerManagerService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateDeviceIdleModeTimeLocked(boolean enabled) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateLightDeviceIdleModeTimeLocked(boolean enabled) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateAcquireWakeLockTimeLocked(String wakeName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateReleaseWakeLockTimeLocked(String wakeame) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getLastLightDozeTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getLastDeepDozeTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getLastWakelockBlameTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getLastDisplayOnTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }
}
