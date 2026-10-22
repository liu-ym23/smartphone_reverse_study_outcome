package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.server.SystemServiceManager;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AppOpMigrationHelperImpl implements AppOpMigrationHelper {
    private SparseArray<Map<Integer, Map<String, Integer>>> mAppIdAppOpModes;
    private final Object mLock;
    private SparseArray<Map<String, Map<String, Integer>>> mPackageAppOpModes;
    private int mVersionAtBoot;

    public AppOpMigrationHelperImpl() {
        this.mAppIdAppOpModes = null;
        this.mPackageAppOpModes = null;
        this.mLock = new Object();
    }

    @Override // com.android.server.appop.AppOpMigrationHelper
    public Map<Integer, Map<String, Integer>> getLegacyAppIdAppOpModes(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppIdAppOpModes != null) goto L9;
        readLegacyAppOpState();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mAppIdAppOpModes.get(userId, Collections.emptyMap());
    }

    @Override // com.android.server.appop.AppOpMigrationHelper
    public Map<String, Map<String, Integer>> getLegacyPackageAppOpModes(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageAppOpModes != null) goto L9;
        readLegacyAppOpState();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mPackageAppOpModes.get(userId, Collections.emptyMap());
    }

    private void readLegacyAppOpState() {
        File systemDir = SystemServiceManager.ensureSystemDir();
        AtomicFile appOpFile = new AtomicFile(new File(systemDir, "appops.xml"));
        SparseArray<SparseIntArray> uidAppOpModes = new SparseArray();
        SparseArray<ArrayMap<String, SparseIntArray>> packageAppOpModes = new SparseArray();
        LegacyAppOpStateParser parser = new LegacyAppOpStateParser();
        int version = parser.readState(appOpFile, uidAppOpModes, packageAppOpModes);
        switch(version) {
            case -2: goto L6;
            case -1: goto L5;
            default: goto L4;
        };
    L4:
        this.mVersionAtBoot = version;
    L7:
        this.mAppIdAppOpModes = getAppIdAppOpModes(uidAppOpModes);
        this.mPackageAppOpModes = getPackageAppOpModes(packageAppOpModes);
        return;
    L5:
        this.mVersionAtBoot = 0;
        goto L7
    L6:
        this.mVersionAtBoot = -1;
        goto L7
    }

    private SparseArray<Map<Integer, Map<String, Integer>>> getAppIdAppOpModes(SparseArray<SparseIntArray> uidAppOpModes) {
        SparseArray<Map<Integer, Map<String, Integer>>> userAppIdAppOpModes = new SparseArray();
        int size = uidAppOpModes.size();
        int uidIndex = 0;
    L3:
        if (uidIndex >= size) goto L9;
        int uid = uidAppOpModes.keyAt(uidIndex);
        int userId = UserHandle.getUserId(uid);
        Map<Integer, Map<String, Integer>> appIdAppOpModes = userAppIdAppOpModes.get(userId);
        if (appIdAppOpModes != null) goto L7;
        appIdAppOpModes = new ArrayMap();
        userAppIdAppOpModes.put(userId, appIdAppOpModes);
    L7:
        SparseIntArray appOpModes = uidAppOpModes.valueAt(uidIndex);
        appIdAppOpModes.put(Integer.valueOf(UserHandle.getAppId(uid)), getAppOpModesForOpName(appOpModes));
        uidIndex = uidIndex + 1;
        goto L3
    L9:
        return userAppIdAppOpModes;
    }

    private SparseArray<Map<String, Map<String, Integer>>> getPackageAppOpModes(SparseArray<ArrayMap<String, SparseIntArray>> legacyPackageAppOpModes) {
        SparseArray<Map<String, Map<String, Integer>>> userPackageAppOpModes = new SparseArray();
        int usersSize = legacyPackageAppOpModes.size();
        int userIndex = 0;
    L3:
        if (userIndex >= usersSize) goto L12;
        int userId = legacyPackageAppOpModes.keyAt(userIndex);
        Map<String, Map<String, Integer>> packageAppOpModes = userPackageAppOpModes.get(userId);
        if (packageAppOpModes != null) goto L7;
        packageAppOpModes = new ArrayMap();
        userPackageAppOpModes.put(userId, packageAppOpModes);
    L7:
        ArrayMap<String, SparseIntArray> legacyPackagesModes = legacyPackageAppOpModes.valueAt(userIndex);
        int packagesSize = legacyPackagesModes.size();
        int packageIndex = 0;
    L8:
        if (packageIndex >= packagesSize) goto L10;
        String packageName = legacyPackagesModes.keyAt(packageIndex);
        SparseIntArray modes = legacyPackagesModes.valueAt(packageIndex);
        packageAppOpModes.put(packageName, getAppOpModesForOpName(modes));
        packageIndex = packageIndex + 1;
        goto L8
    L10:
        userIndex = userIndex + 1;
        goto L3
    L12:
        return userPackageAppOpModes;
    }

    private Map<String, Integer> getAppOpModesForOpName(SparseIntArray appOpCodeModes) {
        int modesSize = appOpCodeModes.size();
        Map<String, Integer> appOpNameModes = new ArrayMap(modesSize);
        int modeIndex = 0;
    L3:
        if (modeIndex >= modesSize) goto L6;
        int opCode = appOpCodeModes.keyAt(modeIndex);
        int opMode = appOpCodeModes.valueAt(modeIndex);
        appOpNameModes.put(AppOpsManager.opToPublicName(opCode), Integer.valueOf(opMode));
        modeIndex = modeIndex + 1;
        goto L3
    L6:
        return appOpNameModes;
    }

    @Override // com.android.server.appop.AppOpMigrationHelper
    public int getLegacyAppOpVersion() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppIdAppOpModes == null) goto L11;
        if (this.mPackageAppOpModes == null) goto L11;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mVersionAtBoot;
    L11:
        readLegacyAppOpState();     // Catch: Throwable -> L9
        goto L12
    }

    @Override // com.android.server.appop.AppOpMigrationHelper
    public boolean hasLegacyAppOpState() {
        if (getLegacyAppOpVersion() <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
