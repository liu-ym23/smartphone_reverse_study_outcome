package com.android.server.display;

import android.content.Context;
import android.os.DebugSmtEx;
import com.android.server.display.mode.DisplayModeDirector;

/* JADX INFO: loaded from: classes2.dex */
public interface IDisplayModeDirectorOptEx {

    public static final class Vote {
        public static final int PRIORITY_THERMAL_MODE = 19;

        public Vote() {
        }
    }

    default void init(DisplayModeDirector displayModeDirector, Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDefaultPeakRefreshRate(float defaultPeakRefreshRate) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateThermalModeLocked(float peakRefreshRate) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
