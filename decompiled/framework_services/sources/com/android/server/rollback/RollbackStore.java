package com.android.server.rollback;

import android.content.pm.VersionedPackage;
import android.content.rollback.PackageRollbackInfo;
import android.content.rollback.RollbackInfo;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.system.ErrnoException;
import android.system.Os;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseIntArray;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class RollbackStore {
    private static final String TAG = "RollbackManager";
    private final File mRollbackDataDir;
    private final File mRollbackHistoryDir;

    RollbackStore(File rollbackDataDir, File rollbackHistoryDir) {
        this.mRollbackDataDir = rollbackDataDir;
        this.mRollbackHistoryDir = rollbackHistoryDir;
    }

    private static List<Rollback> loadRollbacks(File rollbackDataDir) {
        List<Rollback> rollbacks = new ArrayList();
        File[] rollbackDirs = rollbackDataDir.listFiles();
        if (rollbackDirs != null) goto L6;
        Slog.e(TAG, "Folder doesn't exist: " + rollbackDataDir);
        return rollbacks;
    L6:
        int r3 = rollbackDirs.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L15;
        File rollbackDir = rollbackDirs[r4];
        if (rollbackDir.isDirectory() == false) goto L14;
        rollbacks.add(loadRollback(rollbackDir));     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Unable to read rollback at " + rollbackDir, e);
        removeFile(rollbackDir);
    L14:
        r4 = r4 + 1;
        goto L7
    L15:
        return rollbacks;
    }

    List<Rollback> loadRollbacks() {
        return loadRollbacks(this.mRollbackDataDir);
    }

    List<Rollback> loadHistorialRollbacks() {
        return loadRollbacks(this.mRollbackHistoryDir);
    }

    private static List<Integer> toIntList(JSONArray jsonArray) throws JSONException {
        List<Integer> ret = new ArrayList();
        int i = 0;
    L4:
        if (i >= jsonArray.length()) goto L7;
        ret.add(Integer.valueOf(jsonArray.getInt(i)));
        i = i + 1;
        goto L4
    L7:
        return ret;
    }

    private static JSONArray fromIntList(List<Integer> list) {
        JSONArray jsonArray = new JSONArray();
        int i = 0;
    L4:
        if (i >= list.size()) goto L7;
        jsonArray.put(list.get(i));
        i = i + 1;
        goto L4
    L7:
        return jsonArray;
    }

    private static JSONArray convertToJsonArray(List<PackageRollbackInfo.RestoreInfo> list) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        Iterator<PackageRollbackInfo.RestoreInfo> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageRollbackInfo.RestoreInfo ri = r1.next();
        JSONObject jo = new JSONObject();
        jo.put("userId", ri.userId);
        jo.put("appId", ri.appId);
        jo.put("seInfo", ri.seInfo);
        jsonArray.put(jo);
        goto L4
    L6:
        return jsonArray;
    }

    private static ArrayList<PackageRollbackInfo.RestoreInfo> convertToRestoreInfoArray(JSONArray array) throws JSONException {
        ArrayList<PackageRollbackInfo.RestoreInfo> restoreInfos = new ArrayList();
        int i = 0;
    L4:
        if (i >= array.length()) goto L7;
        JSONObject jo = array.getJSONObject(i);
        restoreInfos.add(new PackageRollbackInfo.RestoreInfo(jo.getInt("userId"), jo.getInt("appId"), jo.getString("seInfo")));
        i = i + 1;
        goto L4
    L7:
        return restoreInfos;
    }

    private static JSONArray extensionVersionsToJson(SparseIntArray extensionVersions) throws JSONException {
        JSONArray array = new JSONArray();
        int i = 0;
    L4:
        if (i >= extensionVersions.size()) goto L7;
        JSONObject entryJson = new JSONObject();
        entryJson.put("sdkVersion", extensionVersions.keyAt(i));
        entryJson.put("extensionVersion", extensionVersions.valueAt(i));
        array.put(entryJson);
        i = i + 1;
        goto L4
    L7:
        return array;
    }

    private static SparseIntArray extensionVersionsFromJson(JSONArray json) throws JSONException {
        if (json == null) goto L4;
        SparseIntArray extensionVersions = new SparseIntArray(json.length());
        int i = 0;
    L7:
        if (i >= json.length()) goto L10;
        JSONObject entry = json.getJSONObject(i);
        extensionVersions.append(entry.getInt("sdkVersion"), entry.getInt("extensionVersion"));
        i = i + 1;
        goto L7
    L10:
        return extensionVersions;
    L4:
        return new SparseIntArray(0);
    }

    private static JSONObject rollbackInfoToJson(RollbackInfo rollback) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("rollbackId", rollback.getRollbackId());
        json.put("packages", toJson(rollback.getPackages()));
        json.put("isStaged", rollback.isStaged());
        json.put("causePackages", versionedPackagesToJson(rollback.getCausePackages()));
        json.put("committedSessionId", rollback.getCommittedSessionId());
        json.put("rollbackImpactLevel", rollback.getRollbackImpactLevel());
        return json;
    }

    private static RollbackInfo rollbackInfoFromJson(JSONObject json) throws JSONException {
        RollbackInfo rollbackInfo = new RollbackInfo(json.getInt("rollbackId"), packageRollbackInfosFromJson(json.getJSONArray("packages")), json.getBoolean("isStaged"), versionedPackagesFromJson(json.getJSONArray("causePackages")), json.getInt("committedSessionId"));
        rollbackInfo.setRollbackImpactLevel(json.optInt("rollbackImpactLevel", 0));
        return rollbackInfo;
    }

    Rollback createNonStagedRollback(int rollbackId, int originalSessionId, int userId, String installerPackageName, int[] packageSessionIds, SparseIntArray extensionVersions) {
        File backupDir = new File(this.mRollbackDataDir, Integer.toString(rollbackId));
        return new Rollback(rollbackId, backupDir, originalSessionId, false, userId, installerPackageName, packageSessionIds, extensionVersions);
    }

    Rollback createStagedRollback(int rollbackId, int originalSessionId, int userId, String installerPackageName, int[] packageSessionIds, SparseIntArray extensionVersions) {
        File backupDir = new File(this.mRollbackDataDir, Integer.toString(rollbackId));
        return new Rollback(rollbackId, backupDir, originalSessionId, true, userId, installerPackageName, packageSessionIds, extensionVersions);
    }

    private static boolean isLinkPossible(File oldFile, File newFile) {
        if (Os.stat(oldFile.getAbsolutePath()).st_dev != Os.stat(newFile.getAbsolutePath()).st_dev) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    static void backupPackageCodePath(Rollback rollback, String packageName, String codePath) throws IOException {
        File sourceFile = new File(codePath);
        File targetDir = new File(rollback.getBackupDir(), packageName);
        targetDir.mkdirs();
        File targetFile = new File(targetDir, sourceFile.getName());
        boolean fallbackToCopy = !isLinkPossible(sourceFile, targetDir);
        if (fallbackToCopy == false) goto L15;
    L12:
        if (fallbackToCopy == false) goto L17;
        Files.copy(sourceFile.toPath(), targetFile.toPath(), new CopyOption[0]);
        return;
    L17:
        return;
    L15:
        Os.link(sourceFile.getAbsolutePath(), targetFile.getAbsolutePath());     // Catch: ErrnoException -> L6
    L6:
        e = move-exception;
        boolean isRollbackTest = SystemProperties.getBoolean("persist.rollback.is_test", false);
        if (isRollbackTest == true) goto L11;
        fallbackToCopy = true;
        goto L12
    L11:
        throw new IOException(e);
    }

    static File[] getPackageCodePaths(Rollback rollback, String packageName) {
        File targetDir = new File(rollback.getBackupDir(), packageName);
        File[] files = targetDir.listFiles();
        if (files != null) goto L5;
        return null;
    L5:
        if (files.length == 0) goto L10;
        return files;
    L10:
        return null;
    }

    static void deletePackageCodePaths(Rollback rollback) {
        Iterator r0 = rollback.info.getPackages().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageRollbackInfo info = (PackageRollbackInfo) r0.next();
        File targetDir = new File(rollback.getBackupDir(), info.getPackageName());
        removeFile(targetDir);
        goto L4
    }

    private static void saveRollback(Rollback rollback, File backDir) {
        FileOutputStream fos = null;
        AtomicFile file = new AtomicFile(new File(backDir, "rollback.json"));
        backDir.mkdirs();     // Catch: Throwable -> L5
        JSONObject dataJson = new JSONObject();     // Catch: Throwable -> L5
        dataJson.put("info", rollbackInfoToJson(rollback.info));     // Catch: Throwable -> L5
        dataJson.put("timestamp", rollback.getTimestamp().toString());     // Catch: Throwable -> L5
        dataJson.put("rollbackLifetimeMillis", rollback.getRollbackLifetimeMillis());     // Catch: Throwable -> L5
        dataJson.put("originalSessionId", rollback.getOriginalSessionId());     // Catch: Throwable -> L5
        dataJson.put("state", rollback.getStateAsString());     // Catch: Throwable -> L5
        dataJson.put("stateDescription", rollback.getStateDescription());     // Catch: Throwable -> L5
        dataJson.put("restoreUserDataInProgress", rollback.isRestoreUserDataInProgress());     // Catch: Throwable -> L5
        dataJson.put("userId", rollback.getUserId());     // Catch: Throwable -> L5
        dataJson.putOpt("installerPackageName", rollback.getInstallerPackageName());     // Catch: Throwable -> L5
        dataJson.putOpt("extensionVersions", extensionVersionsToJson(rollback.getExtensionVersions()));     // Catch: Throwable -> L5
        fos = file.startWrite();     // Catch: Throwable -> L5
        fos.write(dataJson.toString().getBytes());     // Catch: Throwable -> L5
        fos.flush();     // Catch: Throwable -> L5
        file.finishWrite(fos);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to save rollback for: " + rollback.info.getRollbackId(), e);
        if (fos == null) goto L12;
        file.failWrite(fos);
        return;
    }

    static void saveRollback(Rollback rollback) {
        saveRollback(rollback, rollback.getBackupDir());
    }

    void saveRollbackToHistory(Rollback rollback) {
        String suffix = Long.toHexString(rollback.getTimestamp().getEpochSecond());
        String dirName = Integer.toString(rollback.info.getRollbackId());
        File backupDir = new File(this.mRollbackHistoryDir, dirName + "-" + suffix);
        saveRollback(rollback, backupDir);
    }

    static void deleteRollback(Rollback rollback) {
        removeFile(rollback.getBackupDir());
    }

    private static Rollback loadRollback(File backupDir) throws IOException {
        File rollbackJsonFile = new File(backupDir, "rollback.json");     // Catch: Throwable -> L4
        JSONObject dataJson = new JSONObject(IoUtils.readFileAsString(rollbackJsonFile.getAbsolutePath()));     // Catch: Throwable -> L4
        return rollbackFromJson(dataJson, backupDir);
    L4:
        e = move-exception;
        throw new IOException(e);
    }

    static Rollback rollbackFromJson(JSONObject dataJson, File backupDir) throws JSONException, ParseException {
        Rollback rollback = new Rollback(rollbackInfoFromJson(dataJson.getJSONObject("info")), backupDir, Instant.parse(dataJson.getString("timestamp")), dataJson.optInt("originalSessionId", dataJson.optInt("stagedSessionId", -1)), Rollback.rollbackStateFromString(dataJson.getString("state")), dataJson.optString("stateDescription"), dataJson.getBoolean("restoreUserDataInProgress"), dataJson.optInt("userId", UserHandle.SYSTEM.getIdentifier()), dataJson.optString("installerPackageName", ""), extensionVersionsFromJson(dataJson.optJSONArray("extensionVersions")));
        rollback.setRollbackLifetimeMillis(dataJson.optLong("rollbackLifetimeMillis"));
        return rollback;
    }

    private static JSONObject toJson(VersionedPackage pkg) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("packageName", pkg.getPackageName());
        json.put("longVersionCode", pkg.getLongVersionCode());
        return json;
    }

    private static VersionedPackage versionedPackageFromJson(JSONObject json) throws JSONException {
        String packageName = json.getString("packageName");
        long longVersionCode = json.getLong("longVersionCode");
        return new VersionedPackage(packageName, longVersionCode);
    }

    private static JSONObject toJson(PackageRollbackInfo info) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("versionRolledBackFrom", toJson(info.getVersionRolledBackFrom()));
        json.put("versionRolledBackTo", toJson(info.getVersionRolledBackTo()));
        List<Integer> pendingBackups = info.getPendingBackups();
        List<PackageRollbackInfo.RestoreInfo> pendingRestores = info.getPendingRestores();
        List<Integer> snapshottedUsers = info.getSnapshottedUsers();
        json.put("pendingBackups", fromIntList(pendingBackups));
        json.put("pendingRestores", convertToJsonArray(pendingRestores));
        json.put("isApex", info.isApex());
        json.put("isApkInApex", info.isApkInApex());
        json.put("installedUsers", fromIntList(snapshottedUsers));
        json.put("rollbackDataPolicy", info.getRollbackDataPolicy());
        return json;
    }

    private static PackageRollbackInfo packageRollbackInfoFromJson(JSONObject json) throws JSONException {
        VersionedPackage versionRolledBackFrom = versionedPackageFromJson(json.getJSONObject("versionRolledBackFrom"));
        VersionedPackage versionRolledBackTo = versionedPackageFromJson(json.getJSONObject("versionRolledBackTo"));
        List<Integer> pendingBackups = toIntList(json.getJSONArray("pendingBackups"));
        ArrayList<PackageRollbackInfo.RestoreInfo> pendingRestores = convertToRestoreInfoArray(json.getJSONArray("pendingRestores"));
        boolean isApex = json.getBoolean("isApex");
        boolean isApkInApex = json.getBoolean("isApkInApex");
        List<Integer> snapshottedUsers = toIntList(json.getJSONArray("installedUsers"));
        int rollbackDataPolicy = json.optInt("rollbackDataPolicy", 0);
        return new PackageRollbackInfo(versionRolledBackFrom, versionRolledBackTo, pendingBackups, pendingRestores, isApex, isApkInApex, snapshottedUsers, rollbackDataPolicy);
    }

    private static JSONArray versionedPackagesToJson(List<VersionedPackage> packages) throws JSONException {
        JSONArray json = new JSONArray();
        Iterator<VersionedPackage> r1 = packages.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        VersionedPackage pkg = r1.next();
        json.put(toJson(pkg));
        goto L4
    L6:
        return json;
    }

    private static List<VersionedPackage> versionedPackagesFromJson(JSONArray json) throws JSONException {
        List<VersionedPackage> packages = new ArrayList();
        int i = 0;
    L4:
        if (i >= json.length()) goto L7;
        packages.add(versionedPackageFromJson(json.getJSONObject(i)));
        i = i + 1;
        goto L4
    L7:
        return packages;
    }

    private static JSONArray toJson(List<PackageRollbackInfo> infos) throws JSONException {
        JSONArray json = new JSONArray();
        Iterator<PackageRollbackInfo> r1 = infos.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageRollbackInfo info = r1.next();
        json.put(toJson(info));
        goto L4
    L6:
        return json;
    }

    private static List<PackageRollbackInfo> packageRollbackInfosFromJson(JSONArray json) throws JSONException {
        List<PackageRollbackInfo> infos = new ArrayList();
        int i = 0;
    L4:
        if (i >= json.length()) goto L7;
        infos.add(packageRollbackInfoFromJson(json.getJSONObject(i)));
        i = i + 1;
        goto L4
    L7:
        return infos;
    }

    private static void removeFile(File file) {
        if (file.isDirectory() == false) goto L9;
        File[] r0 = file.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        File child = r0[r2];
        removeFile(child);
        r2 = r2 + 1;
    L9:
        if (file.exists() == false) goto L13;
        file.delete();
        return;
    }
}
