package com.android.server.appop;

import com.obric.utils.IObricBase;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface IObricAppOpsService extends IObricBase {
    default void updateMutePackage(int uid, String packageName, int activityType) {
    }

    default void updateMuteStatus(boolean shouldMute) {
    }

    default boolean isMutedApp(int uid, String packageName) {
        return false;
    }

    default int checkAudioOperation(int code, int usage, int uid, String packageName) {
        return 0;
    }

    default void resetMuteSessionState() {
    }

    default void setWhitelist(Set<String> whitelist) {
    }
}
