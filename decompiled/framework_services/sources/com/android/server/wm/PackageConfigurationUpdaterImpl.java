package com.android.server.wm;

import android.os.Binder;
import android.os.LocaleList;
import android.util.ArraySet;
import android.util.Slog;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
final class PackageConfigurationUpdaterImpl implements ActivityTaskManagerInternal.PackageConfigurationUpdater {
    private static final String TAG = "PackageConfigurationUpdaterImpl";
    private ActivityTaskManagerService mAtm;
    private int mGrammaticalGender;
    private LocaleList mLocales;
    private Integer mNightMode;
    private String mPackageName;
    private final Optional<Integer> mPid;
    private int mUserId;

    PackageConfigurationUpdaterImpl(int pid, ActivityTaskManagerService atm) {
        this.mPid = Optional.of(Integer.valueOf(pid));
        this.mAtm = atm;
    }

    PackageConfigurationUpdaterImpl(String packageName, int userId, ActivityTaskManagerService atm) {
        this.mPackageName = packageName;
        this.mUserId = userId;
        this.mAtm = atm;
        this.mPid = Optional.empty();
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.PackageConfigurationUpdater
    public ActivityTaskManagerInternal.PackageConfigurationUpdater setNightMode(int nightMode) {
        monitor-enter(this);
        this.mNightMode = Integer.valueOf(nightMode);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.PackageConfigurationUpdater
    public ActivityTaskManagerInternal.PackageConfigurationUpdater setLocales(LocaleList locales) {
        monitor-enter(this);
        this.mLocales = locales;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.PackageConfigurationUpdater
    public ActivityTaskManagerInternal.PackageConfigurationUpdater setGrammaticalGender(int gender) {
        monitor-enter(this);
        this.mGrammaticalGender = gender;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.PackageConfigurationUpdater
    public boolean commit() {
        monitor-enter(this);
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;     // Catch: Throwable -> L16
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L16
        monitor-enter(r0);     // Catch: Throwable -> L16
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L18
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L7:
        if (this.mPid.isPresent() == false) goto L23;
        WindowProcessController wpc = this.mAtm.mProcessMap.getProcess(this.mPid.get().intValue());     // Catch: Throwable -> L20
        if (wpc != null) goto L22;
        Slog.w(TAG, "commit: Override application configuration failed: cannot find pid " + this.mPid);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return false;
    L22:
        int uid = wpc.mUid;     // Catch: Throwable -> L20
        this.mUserId = wpc.mUserId;     // Catch: Throwable -> L20
        this.mPackageName = wpc.mInfo.packageName;     // Catch: Throwable -> L20
    L32:
        updateConfig(uid, this.mPackageName);     // Catch: Throwable -> L20
        boolean r3 = this.mAtm.mPackageConfigPersister.updateFromImpl(this.mPackageName, this.mUserId, this);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r3;
    L23:
        int uid2 = this.mAtm.getPackageManagerInternalLocked().getPackageUid(this.mPackageName, 131072, this.mUserId);     // Catch: Throwable -> L20
        if (uid2 >= 0) goto L31;
        Slog.w(TAG, "commit: update of application configuration failed: userId or packageName not valid " + this.mUserId);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return false;
    L31:
        uid = uid2;
    L18:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private void updateConfig(int uid, String packageName) {
        ArraySet<WindowProcessController> processes = this.mAtm.mProcessMap.getProcesses(uid);
        if (processes != null) goto L5;
        return;
    L5:
        if (processes.isEmpty() == true) goto L19;
        LocaleList localesOverride = LocaleOverlayHelper.combineLocalesIfOverlayExists(this.mLocales, this.mAtm.getGlobalConfiguration().getLocales());
        int i = processes.size() - 1;
    L8:
        if (i < 0) goto L14;
        WindowProcessController wpc = processes.valueAt(i);
        if (wpc.mInfo.packageName.equals(packageName) == false) goto L12;
        wpc.applyAppSpecificConfig(this.mNightMode, localesOverride, Integer.valueOf(this.mGrammaticalGender));
    L12:
        wpc.updateAppSpecificSettingsForAllActivitiesInPackage(packageName, this.mNightMode, localesOverride, this.mGrammaticalGender);
        i = i - 1;
        goto L8
    L14:
        return;
    }

    Integer getNightMode() {
        return this.mNightMode;
    }

    LocaleList getLocales() {
        return this.mLocales;
    }

    Integer getGrammaticalGender() {
        return Integer.valueOf(this.mGrammaticalGender);
    }
}
