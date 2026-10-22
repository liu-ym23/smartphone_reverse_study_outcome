package com.android.server.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.IPackageManagerSmtEx;
import android.util.Slog;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IPackageManagerSmtExBase extends IPackageManagerSmtEx.Stub {
    public IPackageManagerSmtExBase() {
    }

    public boolean performDexOptModeSmt(String packageName, boolean checkProfiles, String targetCompilerFilter, boolean force, boolean bootComplete, String splitName, boolean immediately) {
        return false;
    }

    public boolean isTaskPersist(String packagename, int userId) {
        return TaskPersistUtil.getInstance().isTaskPersist(packagename, userId);
    }

    public Map getAllTaskPersistPackages() {
        return TaskPersistUtil.getInstance().getAllTaskPersistPackages();
    }

    public void updateAppTypeInfo(String packageName, int flag) {
    }

    public void parseAppRefreshRate(String jsonStr) {
    }

    public void clearOverrideFlag(String packageName) {
    }

    public void updateAppInfo(String packageName, String appInfoJsonConfig, long appLastTime, boolean removeUnityChoreographerVsync, boolean permissionFlag, boolean isDexApp) {
        Slog.i("packageManagerServiceSmtBase", "In packageWhiteList: updateAppInfo out " + packageName);
        if (PackageManagerServiceSmtBase.getInstance() == null) goto L6;
        Slog.i("packageManagerServiceSmtBase", "In packageWhiteList: updateAppInfo in " + packageName);
        PackageManagerServiceSmtBase.getInstance().updateAppInfo(packageName, appInfoJsonConfig, appLastTime, removeUnityChoreographerVsync, permissionFlag, isDexApp);
        return;
    }

    public void setTaskPersist(String packageName, boolean enable, int userId) {
    }

    public boolean isTaskPersistUid(int uid, int userId) {
        return false;
    }

    public void updateChosenActivities(String componentName, int code, int userId) {
    }

    public Map getChosenActivities(int userId) {
        return null;
    }

    public void clearPreferredActivities(Intent intent) {
    }

    public int getAlwaysPreferredActivities(List<IntentFilter> outFilters, List<ComponentName> outActivities, String packageName) {
        return 0;
    }

    public void setPackageActiveState(String packageName, boolean active, int userId) {
    }

    public int getPackageActiveState(String packageName, int userId) {
        return 0;
    }
}
