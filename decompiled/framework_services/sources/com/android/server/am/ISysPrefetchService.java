package com.android.server.am;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ISysPrefetchService {
    public static final boolean DEBUG_PREFETCH = true;
    public static final String PREFETCH_TAG = "smart_prefetch";

    default void systemReady(Context context, ActivityManagerService service) {
    }

    default boolean isDoPrefetch() {
        return false;
    }

    default void setDoPrefetch(boolean prefetch) {
    }

    default void setPrefetchProcessMaxSize(int maxSize) {
    }

    default void notifyPrefetched(String packageName, int uid, int pid) {
    }

    default void notifyPrefetchSuccess(String packageName, int uid) {
    }

    default void notifyPrefetchKilled(String packageName, int uid) {
    }

    default void addSystemAppNoPrefetch(String packageName) {
    }

    default boolean checkSystemAppNoPrefetch(String packageName) {
        return false;
    }

    default void addRecentPrefetch(String packageName) {
    }

    default void addAlivePrefetch(String packageName) {
    }

    default void notifyStartPrefetchApp() {
    }

    default void sendFreezeCurrentPrefetchMsg(int pid) {
    }

    default void sendPendingFreezePrefetchMsg() {
    }

    default void updatePrefetchApps(List<String> needPrefetchApps, int hour, int flag) {
    }

    default void updatePrefetchNextApp(List<String> nextAppList) {
    }

    default void updatePredictSceneData(ScenePredictData sceneData) {
    }

    default void removeAlivePrefetch(String packageName) {
    }

    default boolean isVirtualDisplayId(int displayId) {
        return false;
    }

    default void moveTaskToDisplay(String pkgName, boolean realStarting) {
    }

    default void notifyActivityStart(String pkgName, String activityName) {
    }

    default void temporaryStop(long duration) {
    }

    default void asyncStartPrefetchDelayed(String packageName, int delayTimeMs, boolean aliveProcMemSwapIn, int reason) {
    }

    default void notifyDensityChanged() {
    }

    default void uploadPredictHoursDataAsync(ArrayList<Pair<String, Float>> data, int hour) {
    }

    default void updateTopResumedApp(String pkgName) {
    }

    default void notifyBindFinishedOrLaunched(String pkgName, int pid, long time) {
    }

    default void notifyRealStart(String pkgName) {
    }

    default void notifyUnusedAndKilled(String pkgName) {
    }

    default boolean preloadTargetApp(Intent intent, String callingPackage, int userId) {
        return false;
    }

    default boolean asyncStartPrefetch(ArrayList<String> apps, Bundle options) {
        return false;
    }

    default int getPrefetchStateByInfo(String pkg, int uid) {
        return 0;
    }

    default int getPrefetchReasonByInfo(String pkg, int uid) {
        return 0;
    }

    default void setPrefetchStateByPid(int pid, int state) {
    }

    default void setPrefetchState(int uid, String pkg, int state) {
    }

    default void removePrefetchApp(int pid, int reason) {
    }

    default void addPrefetchApp(int pid, String packageName) {
    }

    default void removeUnLaunchedPrefetchProcess(int pid, ProcessRecord app) {
    }

    default void addUnLaunchedPrefetchProcess(int pid, ProcessRecord app) {
    }

    default void notifyPrefetchAppRealStart(ProcessRecord app) {
    }
}
