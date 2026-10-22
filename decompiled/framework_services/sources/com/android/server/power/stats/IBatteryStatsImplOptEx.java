package com.android.server.power.stats;

import android.os.DebugSmtEx;
import android.os.Parcel;
import android.util.Printer;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IBatteryStatsImplOptEx {
    default void init(BatteryStatsImpl stats) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void initTimerOpt() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void resetAllStatsOptLocked() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void readSummaryFromParcelOpt(Parcel in) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void writeSummaryToParcelOpt(Parcel out, long now_real_sys) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void readFromParcelOptLocked(Parcel in) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void writeToParcelOptLocked(Parcel out, long uSecRealtime) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpOptLocked(Printer pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpOptLocked(PrintWriter pw, long rawRealtime, String prefix, StringBuilder sb, int which) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void collectBeforeReset(Object object, String str) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpPowerLog(PrintWriter pw) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
