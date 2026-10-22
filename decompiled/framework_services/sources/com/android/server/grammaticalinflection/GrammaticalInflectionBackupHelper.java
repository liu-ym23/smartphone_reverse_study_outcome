package com.android.server.grammaticalinflection;

import android.app.backup.BackupManager;
import android.content.AttributionSource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.util.Log;
import android.util.SparseArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GrammaticalInflectionBackupHelper {
    private static final Duration STAGE_DATA_RETENTION_PERIOD = null;
    private static final String SYSTEM_BACKUP_PACKAGE_KEY = "android";
    private static final String TAG = null;
    private final AttributionSource mAttributionSource;
    private final SparseArray<StagedData> mCache;
    private final Object mCacheLock;
    private final Clock mClock;
    private final GrammaticalInflectionService mGrammaticalGenderService;
    private final PackageManager mPackageManager;

    static class StagedData {
        final long mCreationTimeMillis;
        final HashMap<String, Integer> mPackageStates;

        StagedData(long creationTimeMillis) {
            this.mCreationTimeMillis = creationTimeMillis;
            this.mPackageStates = new HashMap();
        }
    }

    static {
        TAG = GrammaticalInflectionBackupHelper.class.getSimpleName();
        STAGE_DATA_RETENTION_PERIOD = Duration.ofDays(3);
    }

    public GrammaticalInflectionBackupHelper(AttributionSource attributionSource, GrammaticalInflectionService grammaticalGenderService, PackageManager packageManager) {
        this.mCache = new SparseArray();
        this.mCacheLock = new Object();
        this.mAttributionSource = attributionSource;
        this.mGrammaticalGenderService = grammaticalGenderService;
        this.mPackageManager = packageManager;
        this.mClock = Clock.systemUTC();
    }

    public byte[] getBackupPayload(int userId) {
        Object r0 = this.mCacheLock;
        monitor-enter(r0);
        cleanStagedDataForOldEntries();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        HashMap<String, Integer> pkgGenderInfo = new HashMap();
        Iterator r1 = this.mPackageManager.getInstalledApplicationsAsUser(PackageManager.ApplicationInfoFlags.of(0), userId).iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        ApplicationInfo appInfo = (ApplicationInfo) r1.next();
        int gender = this.mGrammaticalGenderService.getApplicationGrammaticalGender(appInfo.packageName, userId);
        if (gender == 0) goto L8;
        pkgGenderInfo.put(appInfo.packageName, Integer.valueOf(gender));
        goto L8
    L14:
        if (pkgGenderInfo.isEmpty() == false) goto L16;
        return null;
    L16:
        return convertToByteArray(pkgGenderInfo);
    L19:
        th = move-exception;
        throw th;
    }

    public void stageAndApplyRestoredPayload(byte[] payload, int userId) {
        Object r0 = this.mCacheLock;
        monitor-enter(r0);
        cleanStagedDataForOldEntries();     // Catch: Throwable -> L8
        HashMap<String, Integer> pkgInfo = readFromByteArray(payload);     // Catch: Throwable -> L8
        if (pkgInfo.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        StagedData stagedData = new StagedData(this.mClock.millis());     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, Integer>> r3 = pkgInfo.entrySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L22;
        Map.Entry<String, Integer> info = r3.next();     // Catch: Throwable -> L8
        if (isPackageInstalledForUser(info.getKey(), userId) == false) goto L19;
        if (hasSetBeforeRestoring(info.getKey(), userId) == true) goto L12;
        this.mGrammaticalGenderService.setRequestedApplicationGrammaticalGender(info.getKey(), userId, info.getValue().intValue());     // Catch: Throwable -> L8
        goto L12
    L19:
        if (info.getValue().intValue() == 0) goto L12;
        stagedData.mPackageStates.put(info.getKey(), info.getValue());     // Catch: Throwable -> L8
        goto L12
    L22:
        this.mCache.append(userId, stagedData);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public byte[] getSystemBackupPayload(int userId) {
        int gender = this.mGrammaticalGenderService.getSystemGrammaticalGender(userId);
        return intToByteArray(gender);
    }

    public void applyRestoredSystemPayload(byte[] payload, int userId) {
        int gender = convertByteArrayToInt(payload);
        this.mGrammaticalGenderService.setSystemWideGrammaticalGender(gender, userId);
    }

    private boolean hasSetBeforeRestoring(String pkgName, int userId) {
        if (this.mGrammaticalGenderService.getApplicationGrammaticalGender(pkgName, userId) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void onPackageAdded(String packageName, int uid) {
        Object r0 = this.mCacheLock;
        monitor-enter(r0);
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L11
        StagedData cache = this.mCache.get(userId);     // Catch: Throwable -> L11
        if (cache != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (cache.mPackageStates.containsKey(packageName) == false) goto L13;
        int grammaticalGender = cache.mPackageStates.get(packageName).intValue();     // Catch: Throwable -> L11
        if (grammaticalGender == 0) goto L13;
        this.mGrammaticalGenderService.setRequestedApplicationGrammaticalGender(packageName, userId, grammaticalGender);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void onPackageDataCleared() {
        notifyBackupManager();
    }

    public void onPackageRemoved() {
        notifyBackupManager();
    }

    public static void notifyBackupManager() {
        BackupManager.dataChanged("android");
    }

    private static byte[] convertToByteArray(HashMap<String, Integer> pkgGenderInfo) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();     // Catch: IOException -> L8
        ObjectOutputStream objStream = new ObjectOutputStream(out);     // Catch: Throwable -> L10
        objStream.writeObject(pkgGenderInfo);     // Catch: Throwable -> L12
        byte[] r2 = out.toByteArray();     // Catch: Throwable -> L12
        objStream.close();     // Catch: Throwable -> L10
        out.close();     // Catch: IOException -> L8
        return r2;
    L12:
        th = move-exception;
        objStream.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L10
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        out.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L8
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "cannot convert payload to byte array.", e);
        return null;
    }

    private static byte[] intToByteArray(int gender) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(gender);
        return bb.array();
    }

    private static int convertByteArrayToInt(byte[] intBytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(intBytes);
        return byteBuffer.getInt();
    }

    private static HashMap<String, Integer> readFromByteArray(byte[] payload) {
        HashMap<String, Integer> data = new HashMap();
        ByteArrayInputStream byteIn = new ByteArrayInputStream(payload);     // Catch: Throwable -> L10
        ObjectInputStream in = new ObjectInputStream(byteIn);     // Catch: Throwable -> L12
        data = (HashMap) in.readObject();     // Catch: Throwable -> L14
        in.close();     // Catch: Throwable -> L12
        byteIn.close();     // Catch: Throwable -> L10 Throwable -> L10
    L26:
        return data;
    L14:
        th = move-exception;
        in.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        byteIn.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L10 Throwable -> L10
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 Throwable -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "cannot convert payload to HashMap.", e);
        e.printStackTrace();
        goto L26
    }

    private void cleanStagedDataForOldEntries() {
        int i = 0;
    L4:
        if (i >= this.mCache.size()) goto L10;
        int userId = this.mCache.keyAt(i);
        StagedData stagedData = this.mCache.valueAt(userId);
        if (stagedData.mCreationTimeMillis >= (this.mClock.millis() - STAGE_DATA_RETENTION_PERIOD.toMillis())) goto L8;
        this.mCache.removeAt(i);
        i = i - 1;
    L8:
        i = i + 1;
        goto L4
    }

    private boolean isPackageInstalledForUser(String packageName, int userId) {
        PackageInfo pkgInfo = null;
        pkgInfo = this.mPackageManager.getPackageInfoAsUser(packageName, 0, userId);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (pkgInfo == null) goto L11;
        return true;
    L11:
        return false;
    }
}
