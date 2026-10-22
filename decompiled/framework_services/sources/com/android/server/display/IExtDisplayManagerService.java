package com.android.server.display;

import android.hardware.display.ExtDisplayManagerInternal;
import android.hardware.display.IDisplayManagerExt;
import android.pico.utils.IExtBase;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayManagerService extends IExtBase {
    void configDefaultDisplayResolutionIfNeeded();

    boolean dump(FileDescriptor r1, PrintWriter r2, String[] r3);

    IDisplayManagerExt getIExt();

    ExtDisplayManagerInternal getLocalService();

    void onBootPhase(int r1);

    void requestDisplayStateInternal(int r1, int r2, float r3, float r4, int r5);

    void setBrightness(int r1, float r2);

    void setHighBrightnessModeData(LogicalDisplay r1);

    void setTemporaryAutoBrightnessAdjustment(float r1);

    float setTemporaryBrightness(int r1, float r2);
}
