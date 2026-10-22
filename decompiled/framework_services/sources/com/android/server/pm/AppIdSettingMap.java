package com.android.server.pm;

import com.android.server.am.ProcessList;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.WatchedArrayList;
import com.android.server.utils.WatchedSparseArray;
import com.android.server.utils.Watcher;

/* JADX INFO: loaded from: classes2.dex */
final class AppIdSettingMap {
    private int mFirstAvailableAppId;
    private final WatchedArrayList<SettingBase> mNonSystemSettings;
    private final SnapshotCache<WatchedArrayList<SettingBase>> mNonSystemSettingsSnapshot;
    private final WatchedSparseArray<SettingBase> mSystemSettings;
    private final SnapshotCache<WatchedSparseArray<SettingBase>> mSystemSettingsSnapshot;

    AppIdSettingMap() {
        this.mFirstAvailableAppId = 10000;
        this.mNonSystemSettings = new WatchedArrayList();
        this.mNonSystemSettingsSnapshot = new SnapshotCache.Auto(this.mNonSystemSettings, this.mNonSystemSettings, "AppIdSettingMap.mNonSystemSettings");
        this.mSystemSettings = new WatchedSparseArray();
        this.mSystemSettingsSnapshot = new SnapshotCache.Auto(this.mSystemSettings, this.mSystemSettings, "AppIdSettingMap.mSystemSettings");
    }

    AppIdSettingMap(AppIdSettingMap orig) {
        this.mFirstAvailableAppId = 10000;
        this.mNonSystemSettings = orig.mNonSystemSettingsSnapshot.snapshot();
        this.mNonSystemSettingsSnapshot = new SnapshotCache.Sealed();
        this.mSystemSettings = orig.mSystemSettingsSnapshot.snapshot();
        this.mSystemSettingsSnapshot = new SnapshotCache.Sealed();
    }

    public boolean registerExistingAppId(int appId, SettingBase setting, Object name) {
        if (appId < 10000) goto L13;
        int size = this.mNonSystemSettings.size();
        int index = appId + ProcessList.INVALID_ADJ;
    L5:
        if (index < size) goto L8;
        this.mNonSystemSettings.add(null);
        size = size + 1;
        goto L5
    L8:
        if (this.mNonSystemSettings.get(index) == null) goto L11;
        PackageManagerService.reportSettingsProblem(5, "Adding duplicate app id: " + appId + " name=" + name);
        return false;
    L11:
        this.mNonSystemSettings.set(index, setting);
        return true;
    L13:
        if (this.mSystemSettings.get(appId) == null) goto L16;
        PackageManagerService.reportSettingsProblem(5, "Adding duplicate shared id: " + appId + " name=" + name);
        return false;
    L16:
        this.mSystemSettings.put(appId, setting);
        return true;
    }

    public SettingBase getSetting(int appId) {
        if (appId < 10000) goto L10;
        int size = this.mNonSystemSettings.size();
        int index = appId + ProcessList.INVALID_ADJ;
        if (index < size) goto L11;
        return null;
    L11:
        return this.mNonSystemSettings.get(index);
    L10:
        return this.mSystemSettings.get(appId);
    }

    public void removeSetting(int appId) {
        if (appId < 10000) goto L8;
        int size = this.mNonSystemSettings.size();
        int index = appId + ProcessList.INVALID_ADJ;
        if (index >= size) goto L9;
        this.mNonSystemSettings.set(index, null);
    L9:
        setFirstAvailableAppId(appId + 1);
        return;
    L8:
        this.mSystemSettings.remove(appId);
        goto L9
    }

    private void setFirstAvailableAppId(int uid) {
        if (uid <= this.mFirstAvailableAppId) goto L6;
        this.mFirstAvailableAppId = uid;
        return;
    }

    public void replaceSetting(int appId, SettingBase setting) {
        if (appId < 10000) goto L9;
        int size = this.mNonSystemSettings.size();
        int index = appId + ProcessList.INVALID_ADJ;
        if (index >= size) goto L7;
        this.mNonSystemSettings.set(index, setting);
        return;
    L7:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: calling replaceAppIdLpw to replace SettingBase at appId=" + appId + " but nothing is replaced.");
        return;
    L9:
        this.mSystemSettings.put(appId, setting);
    }

    public int acquireAndRegisterNewAppId(SettingBase obj) {
        int size = this.mNonSystemSettings.size();
        int i = this.mFirstAvailableAppId + ProcessList.INVALID_ADJ;
    L3:
        if (i >= size) goto L10;
        if (this.mNonSystemSettings.get(i) == null) goto L6;
        i = i + 1;
        goto L3
    L6:
        this.mNonSystemSettings.set(i, obj);
        return i + 10000;
    L10:
        if (size <= 9999) goto L13;
        return -1;
    L13:
        this.mNonSystemSettings.add(obj);
        return size + 10000;
    }

    public AppIdSettingMap snapshot() {
        return new AppIdSettingMap(this);
    }

    public void registerObserver(Watcher observer) {
        this.mNonSystemSettings.registerObserver(observer);
        this.mSystemSettings.registerObserver(observer);
    }
}
