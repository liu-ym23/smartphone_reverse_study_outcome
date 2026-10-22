package com.android.server.devicepolicy;

import android.content.ComponentName;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.JournaledFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PolicyVersionUpgrader {
    private static final String LOG_TAG = "DevicePolicyManager";
    private static final boolean VERBOSE_LOG = false;
    private final PolicyPathProvider mPathProvider;
    private final PolicyUpgraderDataProvider mProvider;

    PolicyVersionUpgrader(PolicyUpgraderDataProvider provider, PolicyPathProvider pathProvider) {
        this.mProvider = provider;
        this.mPathProvider = pathProvider;
    }

    public void upgradePolicy(int dpmsVersion) {
        int oldVersion = readVersion();
        if (oldVersion < dpmsVersion) goto L6;
        Slog.i(LOG_TAG, String.format("Current version %d, latest version %d, not upgrading.", new Object[]{Integer.valueOf(oldVersion), Integer.valueOf(dpmsVersion)}));
        return;
    L6:
        int[] allUsers = this.mProvider.getUsersForUpgrade();
        OwnersData ownersData = loadOwners(allUsers);
        SparseArray<DevicePolicyData> allUsersData = loadAllUsersData(allUsers, oldVersion, ownersData);
        int currentVersion = oldVersion;
        if (currentVersion != 0) goto L10;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        currentVersion = 1;
    L10:
        if (currentVersion != 1) goto L13;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        upgradeSensorPermissionsAccess(allUsers, ownersData, allUsersData);
        currentVersion = 2;
    L13:
        if (currentVersion != 2) goto L16;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        upgradeProtectedPackages(ownersData, allUsersData);
        currentVersion = 3;
    L16:
        if (currentVersion != 3) goto L19;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        upgradePackageSuspension(allUsers, ownersData, allUsersData);
        currentVersion = 4;
    L19:
        if (currentVersion != 4) goto L22;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        initializeEffectiveKeepProfilesRunning(allUsersData);
        currentVersion = 5;
    L22:
        if (currentVersion != 5) goto L24;
        Slog.i(LOG_TAG, String.format("Upgrading from version %d", new Object[]{Integer.valueOf(currentVersion)}));
        currentVersion = 6;
    L24:
        writePoliciesAndVersion(allUsers, allUsersData, ownersData, currentVersion);
    }

    private void upgradeSensorPermissionsAccess(int[] allUsers, OwnersData ownersData, SparseArray<DevicePolicyData> allUsersData) {
        int r0 = allUsers.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L19;
        int userId = allUsers[r1];
        DevicePolicyData userData = allUsersData.get(userId);
        if (userData == null) goto L18;
        Iterator<ActiveAdmin> r4 = userData.mAdminList.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        ActiveAdmin admin = r4.next();
        if (ownersData.mDeviceOwnerUserId != userId) goto L9;
        if (ownersData.mDeviceOwner == null) goto L9;
        if (ownersData.mDeviceOwner.admin.equals(admin.info.getComponent()) == false) goto L9;
        Slog.i(LOG_TAG, String.format("Marking Device Owner in user %d for permission grant ", new Object[]{Integer.valueOf(userId)}));
        admin.mAdminCanGrantSensorsPermissions = true;
    L18:
        r1 = r1 + 1;
        goto L3
    }

    private void upgradeProtectedPackages(OwnersData ownersData, SparseArray<DevicePolicyData> allUsersData) {
        if (ownersData.mDeviceOwner != null) goto L5;
        return;
    L5:
        List<String> protectedPackages = null;
        DevicePolicyData doUserData = allUsersData.get(ownersData.mDeviceOwnerUserId);
        if (doUserData != null) goto L10;
        Slog.e(LOG_TAG, "No policy data for do user");
        return;
    L10:
        if (ownersData.mDeviceOwnerProtectedPackages == null) goto L16;
        List<String> protectedPackages2 = ownersData.mDeviceOwnerProtectedPackages.get(ownersData.mDeviceOwner.packageName);
        protectedPackages = protectedPackages2;
        if (protectedPackages == null) goto L14;
        Slog.i(LOG_TAG, "Found protected packages in Owners");
    L14:
        ownersData.mDeviceOwnerProtectedPackages = null;
    L18:
        ActiveAdmin doAdmin = doUserData.mAdminMap.get(ownersData.mDeviceOwner.admin);
        if (doAdmin != null) goto L22;
        Slog.e(LOG_TAG, "DO admin not found in DO user");
        return;
    L22:
        if (protectedPackages == null) goto L25;
        doAdmin.protectedPackages = new ArrayList(protectedPackages);
        return;
    L25:
        return;
    L16:
        if (doUserData.mUserControlDisabledPackages == null) goto L18;
        Slog.i(LOG_TAG, "Found protected packages in DevicePolicyData");
        protectedPackages = doUserData.mUserControlDisabledPackages;
        doUserData.mUserControlDisabledPackages = null;
        goto L18
    }

    private void upgradePackageSuspension(int[] allUsers, OwnersData ownersData, SparseArray<DevicePolicyData> allUsersData) {
        if (ownersData.mDeviceOwner == null) goto L5;
        saveSuspendedPackages(allUsersData, ownersData.mDeviceOwnerUserId, ownersData.mDeviceOwner.admin);
    L5:
        int i = 0;
    L7:
        if (i >= ownersData.mProfileOwners.size()) goto L10;
        int ownerUserId = ownersData.mProfileOwners.keyAt(i).intValue();
        OwnersData.OwnerInfo ownerInfo = ownersData.mProfileOwners.valueAt(i);
        saveSuspendedPackages(allUsersData, ownerUserId, ownerInfo.admin);
        i = i + 1;
        goto L7
    }

    private void saveSuspendedPackages(SparseArray<DevicePolicyData> allUsersData, int ownerUserId, ComponentName ownerPackage) {
        DevicePolicyData ownerUserData = allUsersData.get(ownerUserId);
        if (ownerUserData != null) goto L6;
        Slog.e(LOG_TAG, "No policy data for owner user, cannot migrate suspended packages");
        return;
    L6:
        ActiveAdmin ownerAdmin = ownerUserData.mAdminMap.get(ownerPackage);
        if (ownerAdmin != null) goto L10;
        Slog.e(LOG_TAG, "No admin for owner, cannot migrate suspended packages");
        return;
    L10:
        ownerAdmin.suspendedPackages = this.mProvider.getPlatformSuspendedPackages(ownerUserId);
        Slog.i(LOG_TAG, String.format("Saved %d packages suspended by %s in user %d", new Object[]{Integer.valueOf(ownerAdmin.suspendedPackages.size()), ownerPackage, Integer.valueOf(ownerUserId)}));
    }

    private void initializeEffectiveKeepProfilesRunning(SparseArray<DevicePolicyData> allUsersData) {
        DevicePolicyData systemUserData = allUsersData.get(0);
        if (systemUserData != null) goto L5;
        return;
    L5:
        systemUserData.mEffectiveKeepProfilesRunning = false;
        Slog.i(LOG_TAG, "Keep profile running effective state set to false");
    }

    private OwnersData loadOwners(int[] allUsers) {
        OwnersData ownersData = new OwnersData(this.mPathProvider);
        ownersData.load(allUsers);
        return ownersData;
    }

    private void writePoliciesAndVersion(int[] allUsers, SparseArray<DevicePolicyData> allUsersData, OwnersData ownersData, int currentVersion) {
        boolean allWritesSuccessful = true;
        int r1 = allUsers.length;
        int r3 = 0;
    L3:
        boolean r4 = true;
        if (r3 >= r1) goto L12;
        int user = allUsers[r3];
        if (allWritesSuccessful == true) goto L8;
    L10:
        r4 = false;
    L11:
        allWritesSuccessful = r4;
        r3 = r3 + 1;
        goto L3
    L8:
        if (writeDataForUser(user, allUsersData.get(user)) == false) goto L10;
    L12:
        if (allWritesSuccessful == true) goto L14;
    L16:
        boolean allWritesSuccessful2 = false;
    L17:
        int r0 = allUsers.length;
        int r5 = 0;
    L18:
        if (r5 >= r0) goto L26;
        int user2 = allUsers[r5];
        if (allWritesSuccessful2 == true) goto L22;
    L24:
        boolean r6 = false;
    L25:
        allWritesSuccessful2 = r6;
        r5 = r5 + 1;
        goto L18
    L22:
        if (ownersData.writeProfileOwner(user2) == false) goto L24;
        r6 = true;
        goto L25
    L26:
        if (allWritesSuccessful2 == false) goto L28;
        writeVersion(currentVersion);
        return;
    L28:
        Slog.e(LOG_TAG, String.format("Error: Failed upgrading policies to version %d", new Object[]{Integer.valueOf(currentVersion)}));
        return;
    L14:
        if (ownersData.writeDeviceOwner() == false) goto L16;
        allWritesSuccessful2 = true;
        goto L17
    }

    private SparseArray<DevicePolicyData> loadAllUsersData(int[] allUsers, int loadVersion, OwnersData ownersData) {
        SparseArray<DevicePolicyData> allUsersData = new SparseArray();
        int r1 = allUsers.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int user = allUsers[r2];
        ComponentName owner = getOwnerForUser(ownersData, user);
        allUsersData.append(user, loadDataForUser(user, loadVersion, owner));
        r2 = r2 + 1;
        goto L3
    L5:
        return allUsersData;
    }

    private ComponentName getOwnerForUser(OwnersData ownersData, int user) {
        if (ownersData.mDeviceOwnerUserId != user) goto L8;
        if (ownersData.mDeviceOwner == null) goto L8;
        ComponentName owner = ownersData.mDeviceOwner.admin;
        return owner;
    L8:
        if (ownersData.mProfileOwners.containsKey(Integer.valueOf(user)) == false) goto L12;
        ComponentName owner2 = ownersData.mProfileOwners.get(Integer.valueOf(user)).admin;
        return owner2;
    L12:
        return null;
    }

    private DevicePolicyData loadDataForUser(int userId, int loadVersion, ComponentName ownerComponent) {
        DevicePolicyData policy = new DevicePolicyData(userId);
        if (loadVersion != 5) goto L6;
        if (userId != 0) goto L6;
        policy.mEffectiveKeepProfilesRunning = true;
    L6:
        DevicePolicyData.load(policy, this.mProvider.makeDevicePoliciesJournaledFile(userId), this.mProvider.getAdminInfoSupplier(userId), ownerComponent);
        return policy;
    }

    private boolean writeDataForUser(int userId, DevicePolicyData policy) {
        return DevicePolicyData.store(policy, this.mProvider.makeDevicePoliciesJournaledFile(userId));
    }

    private JournaledFile getVersionFile() {
        return this.mProvider.makePoliciesVersionJournaledFile(0);
    }

    private int readVersion() {
        JournaledFile versionFile = getVersionFile();
        File file = versionFile.chooseForRead();
        String versionString = Files.readAllLines(file.toPath(), Charset.defaultCharset()).get(0);     // Catch: Throwable -> L5 NoSuchFileException -> L7
        return Integer.parseInt(versionString);
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "Error reading version", e);
        return 0;
    L12:
        return 0;
    }

    private void writeVersion(int version) {
        JournaledFile versionFile = getVersionFile();
        File file = versionFile.chooseForWrite();
        byte[] versionBytes = String.format("%d", new Object[]{Integer.valueOf(version)}).getBytes();     // Catch: IOException -> L5
        Files.write(file.toPath(), versionBytes, new OpenOption[0]);     // Catch: IOException -> L5
        versionFile.commit();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, String.format("Writing version %d failed", new Object[]{Integer.valueOf(version)}), e);
        versionFile.rollback();
    }
}
