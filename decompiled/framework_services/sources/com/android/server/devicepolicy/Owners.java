package com.android.server.devicepolicy;

import android.app.ActivityManagerInternal;
import android.app.AppOpsManagerInternal;
import android.app.admin.SystemUpdateInfo;
import android.app.admin.SystemUpdatePolicy;
import android.content.ComponentName;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Owners {
    private static final boolean DEBUG = false;
    private static final String TAG = "DevicePolicyManagerService";
    private final ActivityManagerInternal mActivityManagerInternal;
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private final OwnersData mData;
    private final DeviceStateCacheImpl mDeviceStateCache;
    private final PackageManagerInternal mPackageManagerInternal;
    private boolean mSystemReady;
    private final UserManager mUserManager;
    private final UserManagerInternal mUserManagerInternal;

    public static /* synthetic */ int $r8$lambda$6w4HWUbvXPWGKa7vKtQD2v4JRdk(UserInfo r0) {
        return lambda$load$0(r0);
    }

    Owners(UserManager userManager, UserManagerInternal userManagerInternal, PackageManagerInternal packageManagerInternal, ActivityTaskManagerInternal activityTaskManagerInternal, ActivityManagerInternal activityManagerInternal, DeviceStateCacheImpl deviceStateCache, PolicyPathProvider pathProvider) {
        this.mUserManager = userManager;
        this.mUserManagerInternal = userManagerInternal;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mActivityTaskManagerInternal = activityTaskManagerInternal;
        this.mActivityManagerInternal = activityManagerInternal;
        this.mDeviceStateCache = deviceStateCache;
        this.mData = new OwnersData(pathProvider);
    }

    void load() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        int[] usersIds = this.mUserManager.getAliveUsers().stream().mapToInt(new Owners$$ExternalSyntheticLambda0()).toArray();     // Catch: Throwable -> L9
        this.mData.load(usersIds);     // Catch: Throwable -> L9
        int r3 = 0;
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == true) goto L7;
        this.mUserManagerInternal.setDeviceManaged(hasDeviceOwner());     // Catch: Throwable -> L9
        int r2 = usersIds.length;     // Catch: Throwable -> L9
    L16:
        if (r3 >= r2) goto L18;
        int userId = usersIds[r3];     // Catch: Throwable -> L9
        this.mUserManagerInternal.setUserManaged(userId, hasProfileOwner(userId));     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
    L18:
        notifyChangeLocked();     // Catch: Throwable -> L9
        pushDeviceOwnerUidToActivityTaskManagerLocked();     // Catch: Throwable -> L9
        pushProfileOwnerUidsToActivityTaskManagerLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (hasDeviceOwner() == false) goto L11;
        int deviceOwnerType = this.mData.mDeviceOwnerTypes.getOrDefault(this.mData.mDeviceOwner.packageName, 0).intValue();     // Catch: Throwable -> L9
        this.mDeviceStateCache.setDeviceOwnerType(deviceOwnerType);     // Catch: Throwable -> L9
    L12:
        int r4 = usersIds.length;     // Catch: Throwable -> L9
    L13:
        if (r3 >= r4) goto L18;
        int userId2 = usersIds[r3];     // Catch: Throwable -> L9
        this.mDeviceStateCache.setHasProfileOwner(userId2, hasProfileOwner(userId2));     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L13
    L11:
        this.mDeviceStateCache.setDeviceOwnerType(-1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ int lambda$load$0(UserInfo u) {
        return u.id;
    }

    private void notifyChangeLocked() {
        pushToDevicePolicyManager();
        pushToPackageManagerLocked();
        pushToActivityManagerLocked();
        pushToAppOpsLocked();
    }

    private void pushToDevicePolicyManager() {
        DevicePolicyManagerService.invalidateBinderCaches();
    }

    private void pushToPackageManagerLocked() {
        SparseArray<String> po = new SparseArray();
        int i = this.mData.mProfileOwners.size() - 1;
    L3:
        if (i < 0) goto L6;
        po.put(this.mData.mProfileOwners.keyAt(i).intValue(), this.mData.mProfileOwners.valueAt(i).packageName);
        i = i - 1;
        goto L3
    L6:
        if (this.mData.mDeviceOwner == null) goto L8;
        String doPackage = this.mData.mDeviceOwner.packageName;
    L9:
        this.mPackageManagerInternal.setDeviceAndProfileOwnerPackages(this.mData.mDeviceOwnerUserId, doPackage, po);
        return;
    L8:
        doPackage = null;
        goto L9
    }

    private void pushDeviceOwnerUidToActivityTaskManagerLocked() {
        this.mActivityTaskManagerInternal.setDeviceOwnerUid(getDeviceOwnerUidLocked());
    }

    private void pushProfileOwnerUidsToActivityTaskManagerLocked() {
        this.mActivityTaskManagerInternal.setProfileOwnerUids(getProfileOwnerUidsLocked());
    }

    private void pushToActivityManagerLocked() {
        this.mActivityManagerInternal.setDeviceOwnerUid(getDeviceOwnerUidLocked());
        ArraySet<Integer> profileOwners = new ArraySet();
        int poi = this.mData.mProfileOwners.size() - 1;
    L3:
        if (poi < 0) goto L8;
        int userId = this.mData.mProfileOwners.keyAt(poi).intValue();
        int profileOwnerUid = this.mPackageManagerInternal.getPackageUid(this.mData.mProfileOwners.valueAt(poi).packageName, 4333568, userId);
        if (profileOwnerUid < 0) goto L7;
        profileOwners.add(Integer.valueOf(profileOwnerUid));
    L7:
        poi = poi - 1;
        goto L3
    L8:
        this.mActivityManagerInternal.setProfileOwnerUid(profileOwners);
    }

    int getDeviceOwnerUidLocked() {
        if (this.mData.mDeviceOwner != null) goto L5;
        return -1;
    L5:
        return this.mPackageManagerInternal.getPackageUid(this.mData.mDeviceOwner.packageName, 4333568, this.mData.mDeviceOwnerUserId);
    }

    Set<Integer> getProfileOwnerUidsLocked() {
        Set<Integer> uids = new ArraySet();
        int i = 0;
    L4:
        if (i >= this.mData.mProfileOwners.size()) goto L7;
        int userId = this.mData.mProfileOwners.keyAt(i).intValue();
        OwnersData.OwnerInfo info = this.mData.mProfileOwners.valueAt(i);
        uids.add(Integer.valueOf(this.mPackageManagerInternal.getPackageUid(info.packageName, 4333568, userId)));
        i = i + 1;
        goto L4
    L7:
        return uids;
    }

    String getDeviceOwnerPackageName() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        String r1 = this.mData.mDeviceOwner.packageName;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = null;
        goto L10
    }

    int getDeviceOwnerUserId() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        int r1 = this.mData.mDeviceOwnerUserId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Pair<Integer, ComponentName> getDeviceOwnerUserIdAndComponent() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        Pair<Integer, ComponentName> r1 = Pair.create(Integer.valueOf(this.mData.mDeviceOwnerUserId), this.mData.mDeviceOwner.admin);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    ComponentName getDeviceOwnerComponent() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        ComponentName r1 = this.mData.mDeviceOwner.admin;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = null;
        goto L10
    }

    String getDeviceOwnerRemoteBugreportUri() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        String r1 = this.mData.mDeviceOwner.remoteBugreportUri;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = null;
        goto L10
    }

    String getDeviceOwnerRemoteBugreportHash() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        String r1 = this.mData.mDeviceOwner.remoteBugreportHash;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = null;
        goto L10
    }

    void setDeviceOwner(ComponentName admin, int userId) {
        if (userId >= 0) goto L5;
        Slog.e(TAG, "Invalid user id for device owner user: " + userId);
        return;
    L5:
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mDeviceOwner = new OwnersData.OwnerInfo(admin, null, null, true);     // Catch: Throwable -> L10
        this.mData.mDeviceOwnerUserId = userId;     // Catch: Throwable -> L10
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == false) goto L12;
        int deviceOwnerType = this.mData.mDeviceOwnerTypes.getOrDefault(this.mData.mDeviceOwner.packageName, 0).intValue();     // Catch: Throwable -> L10
        this.mDeviceStateCache.setDeviceOwnerType(deviceOwnerType);     // Catch: Throwable -> L10
    L13:
        notifyChangeLocked();     // Catch: Throwable -> L10
        pushDeviceOwnerUidToActivityTaskManagerLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.mUserManagerInternal.setDeviceManaged(true);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void clearDeviceOwner() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mDeviceOwnerTypes.remove(this.mData.mDeviceOwner.packageName);     // Catch: Throwable -> L7
        this.mData.mDeviceOwner = null;     // Catch: Throwable -> L7
        this.mData.mDeviceOwnerUserId = ProcessList.INVALID_ADJ;     // Catch: Throwable -> L7
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == false) goto L9;
        this.mDeviceStateCache.setDeviceOwnerType(-1);     // Catch: Throwable -> L7
    L10:
        notifyChangeLocked();     // Catch: Throwable -> L7
        pushDeviceOwnerUidToActivityTaskManagerLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mUserManagerInternal.setDeviceManaged(false);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void setProfileOwner(ComponentName admin, int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mProfileOwners.put(Integer.valueOf(userId), new OwnersData.OwnerInfo(admin, null, null, false));     // Catch: Throwable -> L7
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == false) goto L9;
        this.mDeviceStateCache.setHasProfileOwner(userId, true);     // Catch: Throwable -> L7
    L10:
        notifyChangeLocked();     // Catch: Throwable -> L7
        pushProfileOwnerUidsToActivityTaskManagerLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mUserManagerInternal.setUserManaged(userId, true);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void removeProfileOwner(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mProfileOwners.remove(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == false) goto L9;
        this.mDeviceStateCache.setHasProfileOwner(userId, false);     // Catch: Throwable -> L7
    L10:
        notifyChangeLocked();     // Catch: Throwable -> L7
        pushProfileOwnerUidsToActivityTaskManagerLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mUserManagerInternal.setUserManaged(userId, false);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void transferProfileOwner(ComponentName target, int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        OwnersData.OwnerInfo ownerInfo = this.mData.mProfileOwners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        OwnersData.OwnerInfo newOwnerInfo = new OwnersData.OwnerInfo(target, ownerInfo.remoteBugreportUri, ownerInfo.remoteBugreportHash, ownerInfo.isOrganizationOwnedDevice);     // Catch: Throwable -> L7
        this.mData.mProfileOwners.put(Integer.valueOf(userId), newOwnerInfo);     // Catch: Throwable -> L7
        notifyChangeLocked();     // Catch: Throwable -> L7
        pushProfileOwnerUidsToActivityTaskManagerLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void transferDeviceOwnership(ComponentName target) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        Integer previousDeviceOwnerType = this.mData.mDeviceOwnerTypes.remove(this.mData.mDeviceOwner.packageName);     // Catch: Throwable -> L7
        OwnersData r2 = this.mData;     // Catch: Throwable -> L7
        r2.mDeviceOwner = new OwnersData.OwnerInfo(target, this.mData.mDeviceOwner.remoteBugreportUri, this.mData.mDeviceOwner.remoteBugreportHash, this.mData.mDeviceOwner.isOrganizationOwnedDevice);     // Catch: Throwable -> L7
        if (previousDeviceOwnerType == null) goto L9;
        this.mData.mDeviceOwnerTypes.put(this.mData.mDeviceOwner.packageName, previousDeviceOwnerType);     // Catch: Throwable -> L7
    L9:
        notifyChangeLocked();     // Catch: Throwable -> L7
        pushDeviceOwnerUidToActivityTaskManagerLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ComponentName getProfileOwnerComponent(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        OwnersData.OwnerInfo profileOwner = this.mData.mProfileOwners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (profileOwner == null) goto L9;
        ComponentName r2 = profileOwner.admin;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    String getProfileOwnerPackage(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        OwnersData.OwnerInfo profileOwner = this.mData.mProfileOwners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (profileOwner == null) goto L9;
        String r2 = profileOwner.packageName;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isProfileOwnerOfOrganizationOwnedDevice(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        OwnersData.OwnerInfo profileOwner = this.mData.mProfileOwners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (profileOwner == null) goto L9;
        boolean r2 = profileOwner.isOrganizationOwnedDevice;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = false;
    L7:
        th = move-exception;
        throw th;
    }

    Set<Integer> getProfileOwnerKeys() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        Set<Integer> r1 = this.mData.mProfileOwners.keySet();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    List<OwnerShellData> listAllOwners() {
        List<OwnerShellData> owners = new ArrayList();
        OwnersData r1 = this.mData;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        owners.add(OwnerShellData.forDeviceOwner(this.mData.mDeviceOwnerUserId, this.mData.mDeviceOwner.admin));     // Catch: Throwable -> L7
    L9:
        int i = 0;
    L11:
        if (i >= this.mData.mProfileOwners.size()) goto L14;
        int userId = this.mData.mProfileOwners.keyAt(i).intValue();     // Catch: Throwable -> L7
        OwnersData.OwnerInfo info = this.mData.mProfileOwners.valueAt(i);     // Catch: Throwable -> L7
        owners.add(OwnerShellData.forUserProfileOwner(userId, info.admin));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return owners;
    }

    SystemUpdatePolicy getSystemUpdatePolicy() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        SystemUpdatePolicy r1 = this.mData.mSystemUpdatePolicy;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setSystemUpdatePolicy(SystemUpdatePolicy systemUpdatePolicy) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mSystemUpdatePolicy = systemUpdatePolicy;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void clearSystemUpdatePolicy() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mSystemUpdatePolicy = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Pair<LocalDate, LocalDate> getSystemUpdateFreezePeriodRecord() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        Pair<LocalDate, LocalDate> r1 = new Pair(this.mData.mSystemUpdateFreezeStart, this.mData.mSystemUpdateFreezeEnd);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    String getSystemUpdateFreezePeriodRecordAsString() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        String r1 = this.mData.getSystemUpdateFreezePeriodRecordAsString();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean setSystemUpdateFreezePeriodRecord(LocalDate start, LocalDate end) {
        boolean changed = false;
        OwnersData r1 = this.mData;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mData.mSystemUpdateFreezeStart, start) == true) goto L10;
        this.mData.mSystemUpdateFreezeStart = start;     // Catch: Throwable -> L7
        changed = true;
    L10:
        if (Objects.equals(this.mData.mSystemUpdateFreezeEnd, end) == true) goto L12;
        this.mData.mSystemUpdateFreezeEnd = end;     // Catch: Throwable -> L7
        changed = true;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return changed;
    }

    boolean hasDeviceOwner() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    boolean isDeviceOwnerUserId(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mData.mDeviceOwnerUserId != userId) goto L11;
        r1 = true;
        goto L12
    }

    boolean isDefaultDeviceOwnerUserId(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner != null) goto L7;
    L13:
        boolean r1 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        if (this.mData.mDeviceOwnerUserId != userId) goto L13;
        if (getDeviceOwnerType(getDeviceOwnerPackageName()) != 0) goto L13;
        r1 = true;
        goto L14
    }

    boolean isFinancedDeviceOwnerUserId(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner != null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L7:
        if (this.mData.mDeviceOwnerUserId != userId) goto L13;
        r2 = true;
        if (getDeviceOwnerType(getDeviceOwnerPackageName()) != 1) goto L13;
        goto L13
    }

    boolean hasProfileOwner(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (getProfileOwnerComponent(userId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void setDeviceOwnerRemoteBugreportUriAndHash(String remoteBugreportUri, String remoteBugreportHash) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwner == null) goto L9;
        this.mData.mDeviceOwner.remoteBugreportUri = remoteBugreportUri;     // Catch: Throwable -> L7
        this.mData.mDeviceOwner.remoteBugreportHash = remoteBugreportHash;     // Catch: Throwable -> L7
    L9:
        writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void setProfileOwnerOfOrganizationOwnedDevice(int userId, boolean isOrganizationOwnedDevice) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        OwnersData.OwnerInfo profileOwner = this.mData.mProfileOwners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (profileOwner == null) goto L9;
        profileOwner.isOrganizationOwnedDevice = isOrganizationOwnedDevice;     // Catch: Throwable -> L7
    L10:
        writeProfileOwner(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.e(TAG, String.format("No profile owner for user %d to set org-owned flag.", new Object[]{Integer.valueOf(userId)}));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void setDeviceOwnerType(String packageName, int deviceOwnerType, boolean isAdminTestOnly) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasDeviceOwner() == true) goto L11;
        Slog.e(TAG, "Attempting to set a device owner type when there is no device owner");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        if (isAdminTestOnly == false) goto L13;
    L17:
        this.mData.mDeviceOwnerTypes.put(packageName, Integer.valueOf(deviceOwnerType));     // Catch: Throwable -> L9
        writeDeviceOwner();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        if (isDeviceOwnerTypeSetForDeviceOwner(packageName) == false) goto L17;
        Slog.e(TAG, "Setting the device owner type more than once is only allowed for test only admins");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    int getDeviceOwnerType(String packageName) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isDeviceOwnerTypeSetForDeviceOwner(packageName) == false) goto L11;
        int r1 = this.mData.mDeviceOwnerTypes.get(packageName).intValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    }

    boolean isDeviceOwnerTypeSetForDeviceOwner(String packageName) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mData.mDeviceOwnerTypes.isEmpty() == false) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mData.mDeviceOwnerTypes.containsKey(packageName) == false) goto L11;
        r1 = true;
        goto L12
    }

    void writeDeviceOwner() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        pushToDevicePolicyManager();     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void writeProfileOwner(int userId) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        pushToDevicePolicyManager();     // Catch: Throwable -> L7
        this.mData.writeProfileOwner(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean saveSystemUpdateInfo(SystemUpdateInfo newInfo) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(newInfo, this.mData.mSystemUpdateInfo) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mData.mSystemUpdateInfo = newInfo;     // Catch: Throwable -> L9
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    }

    public SystemUpdateInfo getSystemUpdateInfo() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        SystemUpdateInfo r1 = this.mData.mSystemUpdateInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markMigrationToPolicyEngine() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mMigratedToPolicyEngine = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isMigratedToPolicyEngine() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mMigratedToPolicyEngine;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markSecurityLoggingMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mSecurityLoggingMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void markPostUpgradeMigration() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mPoliciesMigratedPostUpdate = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSecurityLoggingMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mSecurityLoggingMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isRequiredPasswordComplexityMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mRequiredPasswordComplexityMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markRequiredPasswordComplexityMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mRequiredPasswordComplexityMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSuspendedPackagesMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mSuspendedPackagesMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markSuspendedPackagesMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mSuspendedPackagesMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isMigratedPostUpdate() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mPoliciesMigratedPostUpdate;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markResetPasswordWithTokenMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mResetPasswordWithTokenMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isResetPasswordWithTokenMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mResetPasswordWithTokenMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markMemoryTaggingMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mMemoryTaggingMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isMemoryTaggingMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mMemoryTaggingMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void markSetKeyguardDisabledFeaturesMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.mSetKeyguardDisabledFeaturesMigrated = true;     // Catch: Throwable -> L7
        this.mData.writeDeviceOwner();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSetKeyguardDisabledFeaturesMigrated() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        boolean r1 = this.mData.mSetKeyguardDisabledFeaturesMigrated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void pushToAppOpsLocked() {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        long ident = Binder.clearCallingIdentity();
        SparseIntArray owners = new SparseIntArray();     // Catch: Throwable -> L11
        if (this.mData.mDeviceOwner == null) goto L14;
        int uid = getDeviceOwnerUidLocked();     // Catch: Throwable -> L11
        if (uid < 0) goto L14;
        owners.put(this.mData.mDeviceOwnerUserId, uid);     // Catch: Throwable -> L11
    L14:
        if (this.mData.mProfileOwners == null) goto L21;
        int poi = this.mData.mProfileOwners.size() - 1;     // Catch: Throwable -> L11
    L16:
        if (poi < 0) goto L21;
        int uid2 = this.mPackageManagerInternal.getPackageUid(this.mData.mProfileOwners.valueAt(poi).packageName, 4333568, this.mData.mProfileOwners.keyAt(poi).intValue());     // Catch: Throwable -> L11
        if (uid2 < 0) goto L20;
        owners.put(this.mData.mProfileOwners.keyAt(poi).intValue(), uid2);     // Catch: Throwable -> L11
    L20:
        poi = poi - 1;     // Catch: Throwable -> L11
    L21:
        AppOpsManagerInternal appops = (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);     // Catch: Throwable -> L11
        if (appops != null) goto L24;
    L28:
        Binder.restoreCallingIdentity(ident);
        return;
    L24:
        if (owners.size() <= 0) goto L26;
        SparseIntArray r4 = owners;
    L27:
        appops.setDeviceAndProfileOwners(r4);     // Catch: Throwable -> L11
        goto L28
    L26:
        r4 = null;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void systemReady() {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mSystemReady = true;     // Catch: Throwable -> L8
        pushToActivityManagerLocked();     // Catch: Throwable -> L8
        pushToAppOpsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(IndentingPrintWriter pw) {
        OwnersData r0 = this.mData;
        monitor-enter(r0);
        this.mData.dump(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    File getDeviceOwnerFile() {
        return this.mData.getDeviceOwnerFile();
    }

    File getProfileOwnerFile(int userId) {
        return this.mData.getProfileOwnerFile(userId);
    }
}
