package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ITransferController {
    public static final String SCREEN_TYPE_PHONE = "smart_phone_screen";
    public static final String SCREEN_TYPE_TNT = "smart_tnt_screen";

    default void setAppSlowMainOperation(List<String> operations, int index) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void publish(Context context, boolean always) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void shutdown() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void systemReady() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void finishBooting() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDoJankLog(boolean doJankLog) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void startPerfettoForce(int auto) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void checkJankPerfettoForTest(int type, String layerName, long dur, int currentFpsMode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void reportAppDisplayed(String packageName, String activityName, int sysType, long windowsDrawnTime, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
