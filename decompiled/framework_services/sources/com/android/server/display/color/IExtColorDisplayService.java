package com.android.server.display.color;

import android.content.Context;
import android.hardware.display.IColorDisplayManagerExt;
import android.pico.utils.IExtBase;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtColorDisplayService extends IExtBase {
    public static final String READ_MODE = "xui_read_mode_activated";

    void applyTint(TintController r1, boolean r2, float[] r3, float[] r4);

    int clampNightDisplayColorTemperature(int r1);

    void dumpInternal(PrintWriter r1, String[] r2);

    IColorDisplayManagerExt getExtInstance();

    float[] getMatrix(boolean r1, float[] r2);

    int getNightDisplayColorTemperatureDefault(int r1);

    void init(Context r1);

    void onBootPhase(int r1);

    void onUserChanged(int r1);

    void setEyeActivated(boolean r1);

    void setMatrix(int r1, float[] r2);
}
