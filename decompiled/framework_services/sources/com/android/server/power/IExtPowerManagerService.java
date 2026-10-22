package com.android.server.power;

import android.os.ExtPowerManagerInternal;
import android.os.IPowerManagerExt;
import android.pico.utils.IExtBase;
import android.util.IntArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtPowerManagerService extends IExtBase {
    void acquireWakeLockInternal(PowerManagerService.WakeLock r1);

    boolean dump(FileDescriptor r1, PrintWriter r2, String[] r3);

    IPowerManagerExt getIExt();

    ExtPowerManagerInternal getInternalExt();

    void goToSleepInternal(IntArray r1, long r2, int r4, int r5);

    void onDisplayAdded(int r1);

    void onDisplayChanged(int r1);

    void onDisplayGroupAdded(int r1);

    void onDisplayGroupChanged(int r1);

    void onDisplayGroupRemoved(int r1);

    void onDisplayRemoved(int r1);

    void releaseWakeLockInternal(PowerManagerService.WakeLock r1);

    boolean shouldWakeUpWhenPluggedOrUnpluggedLocked(boolean r1, boolean r2, int r3, int r4, boolean r5, int r6);

    void systemReady();

    boolean updateDozeAfterScreenOff(PowerGroup r1, boolean r2);

    void wakeUp(long r1, int r3, String r4, String r5);

    default boolean shouldWakeUpWhenUndockedFromWirelessCharger() {
        return false;
    }

    default float setDozeOverrideFromDreamManagerInternal(int screenState, int reason, float screenBrightnessFloat, int screenBrightnessInt, boolean useNormalBrightnessForDoze, float dozeScreenBrightnessOverrideFromDreamManagerFloat) {
        return dozeScreenBrightnessOverrideFromDreamManagerFloat;
    }
}
