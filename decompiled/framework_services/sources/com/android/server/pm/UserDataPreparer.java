package com.android.server.pm;

import android.content.Context;
import android.content.pm.UserInfo;
import android.os.Environment;
import android.os.FileUtils;
import android.os.RecoverySystem;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.utils.Slogf;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class UserDataPreparer {
    private static final String TAG = "UserDataPreparer";
    private static final String XATTR_SERIAL = "user.serial";
    private final Context mContext;
    private final PackageManagerTracedLock mInstallLock;
    private final Installer mInstaller;

    UserDataPreparer(Installer installer, PackageManagerTracedLock installLock, Context context) {
        this.mInstallLock = installLock;
        this.mContext = context;
        this.mInstaller = installer;
    }

    void prepareUserData(UserInfo userInfo, int flags) {
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);     // Catch: Throwable -> L9
        if (storage != null) goto L12;
        Log.e(TAG, "prepareUserData failed due to unable get StorageManager");     // Catch: Throwable -> L9
        if (installLock == null) goto L37;
        installLock.close();
        return;
    L37:
        return;
    L12:
        prepareUserDataLI(null, userInfo, flags, true);     // Catch: Throwable -> L9
        Iterator r2 = storage.getWritablePrivateVolumes().iterator();     // Catch: Throwable -> L9
    L14:
        if (r2.hasNext() == false) goto L20;
        VolumeInfo vol = (VolumeInfo) r2.next();     // Catch: Throwable -> L9
        String volumeUuid = vol.getFsUuid();     // Catch: Throwable -> L9
        if (volumeUuid == null) goto L14;
        prepareUserDataLI(volumeUuid, userInfo, flags, true);     // Catch: Throwable -> L9
        goto L14
    L20:
        if (installLock == null) goto L38;
        installLock.close();
        return;
    L38:
        return;
    L9:
        th = move-exception;
        if (installLock != null) goto L30;
    L28:
        throw th;
    L30:
        installLock.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    private void prepareUserDataLI(String volumeUuid, UserInfo userInfo, int flags, boolean allowRecover) {
        int userId = userInfo.id;
        int userSerial = userInfo.serialNumber;
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        if (userInfo.lastLoggedInTime != 0) goto L5;
        boolean isNewUser = true;
    L6:
        Slogf.d(TAG, "Preparing user data; volumeUuid=%s, userId=%d, flags=0x%x, isNewUser=%s", new Object[]{volumeUuid, Integer.valueOf(userId), Integer.valueOf(flags), Boolean.valueOf(isNewUser)});
        storage.prepareUserStorage(volumeUuid, userId, flags);     // Catch: Exception -> L12
        if ((flags & 1) == 0) goto L15;
        enforceSerialNumber(getDataUserDeDirectory(volumeUuid, userId), userSerial);     // Catch: Exception -> L12
        if (Objects.equals(volumeUuid, StorageManager.UUID_PRIVATE_INTERNAL) == false) goto L15;
        enforceSerialNumber(getDataSystemDeDirectory(userId), userSerial);     // Catch: Exception -> L12
    L15:
        if ((flags & 2) == 0) goto L19;
        enforceSerialNumber(getDataUserCeDirectory(volumeUuid, userId), userSerial);     // Catch: Exception -> L12
        if (Objects.equals(volumeUuid, StorageManager.UUID_PRIVATE_INTERNAL) == false) goto L19;
        enforceSerialNumber(getDataSystemCeDirectory(userId), userSerial);     // Catch: Exception -> L12
    L19:
        this.mInstaller.createUserData(volumeUuid, userId, userSerial, flags);     // Catch: Exception -> L12
        if ((flags & 2) == 0) goto L47;
        if (userId != 0) goto L48;
        String propertyName = "sys.user." + userId + ".ce_available";     // Catch: Exception -> L12
        Slog.d(TAG, "Setting property: " + propertyName + "=true");     // Catch: Exception -> L12
        SystemProperties.set(propertyName, "true");     // Catch: Exception -> L12
        return;
    L48:
        return;
    L47:
        return;
    L12:
        e = move-exception;
        if (isNewUser == false) goto L27;
        PackageManagerServiceUtils.logCriticalInfo(6, "Destroying user " + userId + " on volume " + volumeUuid + " because we failed to prepare: " + e);
        destroyUserDataLI(volumeUuid, userId, flags);
    L28:
        if (allowRecover == false) goto L44;
        prepareUserDataLI(volumeUuid, userInfo, flags | 1, false);
        return;
    L44:
        Log.e(TAG, "prepareUserData failed for user " + userId, e);     // Catch: IOException -> L36
        if (isNewUser == false) goto L49;
        if (userId != 0) goto L50;
        if (volumeUuid != null) goto L51;
        RecoverySystem.rebootPromptAndWipeUserData(this.mContext, "failed to prepare internal storage for system user");     // Catch: IOException -> L36
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L36:
        e2 = move-exception;
        throw new RuntimeException("error rebooting into recovery", e2);
    L27:
        PackageManagerServiceUtils.logCriticalInfo(6, "Failed to prepare user " + userId + " on volume " + volumeUuid + ": " + e);
        goto L28
    L5:
        isNewUser = false;
        goto L6
    }

    void destroyUserData(int userId, int flags) {
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);     // Catch: Throwable -> L11
        if (storage == null) goto L14;
        Iterator r2 = storage.getWritablePrivateVolumes().iterator();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L14;
        VolumeInfo vol = (VolumeInfo) r2.next();     // Catch: Throwable -> L11
        String volumeUuid = vol.getFsUuid();     // Catch: Throwable -> L11
        if (volumeUuid == null) goto L7;
        destroyUserDataLI(volumeUuid, userId, flags);     // Catch: Throwable -> L11
    L14:
        destroyUserDataLI(null, userId, flags);     // Catch: Throwable -> L11
        if (installLock == null) goto L31;
        installLock.close();
        return;
    L31:
        return;
    L11:
        th = move-exception;
        if (installLock != null) goto L26;
    L23:
        throw th;
    L26:
        installLock.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    }

    void destroyUserDataLI(String volumeUuid, int userId, int flags) {
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        this.mInstaller.destroyUserData(volumeUuid, userId, flags);     // Catch: Exception -> L8
        if (Objects.equals(volumeUuid, StorageManager.UUID_PRIVATE_INTERNAL) == true) goto L6;
    L13:
        if (storage == null) goto L21;
        storage.destroyUserStorage(volumeUuid, userId, flags);     // Catch: Exception -> L8
        return;
    L21:
        return;
    L6:
        if ((flags & 1) == 0) goto L11;
        FileUtils.deleteContentsAndDir(getUserSystemDirectory(userId));     // Catch: Exception -> L8
        FileUtils.deleteContents(getDataSystemDeDirectory(userId));     // Catch: Exception -> L8
    L11:
        if ((flags & 2) == 0) goto L13;
        FileUtils.deleteContents(getDataSystemCeDirectory(userId));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        PackageManagerServiceUtils.logCriticalInfo(5, "Failed to destroy user " + userId + " on volume " + volumeUuid + ": " + e);
    }

    void reconcileUsers(String volumeUuid, List<UserInfo> validUsersList) {
        List<File> files = new ArrayList();
        Collections.addAll(files, FileUtils.listFilesOrEmpty(Environment.getDataUserDeDirectory(volumeUuid)));
        Collections.addAll(files, FileUtils.listFilesOrEmpty(Environment.getDataUserCeDirectory(volumeUuid)));
        Collections.addAll(files, FileUtils.listFilesOrEmpty(Environment.getDataSystemDeDirectory()));
        Collections.addAll(files, FileUtils.listFilesOrEmpty(Environment.getDataSystemCeDirectory()));
        Collections.addAll(files, FileUtils.listFilesOrEmpty(Environment.getDataMiscCeDirectory()));
        reconcileUsers(volumeUuid, validUsersList, files);
    }

    void reconcileUsers(String volumeUuid, List<UserInfo> validUsersList, List<File> files) {
        int userCount = validUsersList.size();
        SparseArray<UserInfo> users = new SparseArray(userCount);
        int i = 0;
    L3:
        if (i >= userCount) goto L5;
        UserInfo user = validUsersList.get(i);
        users.put(user.id, user);
        i = i + 1;
        goto L3
    L5:
        Iterator<File> r2 = files.iterator();
    L7:
        if (r2.hasNext() == false) goto L34;
        File file = r2.next();
        if (file.isDirectory() == false) goto L7;
        int userId = Integer.parseInt(file.getName());     // Catch: NumberFormatException -> L32
        UserInfo info = users.get(userId);     // Catch: NumberFormatException -> L32
        boolean destroyUser = false;
        if (info != null) goto L37;
        PackageManagerServiceUtils.logCriticalInfo(5, "Destroying user directory " + file + " because no matching user was found");
        destroyUser = true;
    L19:
        if (destroyUser == false) goto L7;
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();
        destroyUserDataLI(volumeUuid, userId, 3);     // Catch: Throwable -> L24
        if (installLock == null) goto L7;
        installLock.close();
    L24:
        th = move-exception;
        if (installLock != null) goto L41;
    L30:
        throw th;
    L41:
        installLock.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);
        goto L30
    L37:
        enforceSerialNumber(file, info.serialNumber);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        PackageManagerServiceUtils.logCriticalInfo(5, "Destroying user directory " + file + " because we failed to enforce serial number: " + e);
        destroyUser = true;
    L33:
        Slog.w(TAG, "Invalid user directory " + file);
        goto L7
    }

    protected File getDataMiscCeDirectory(int userId) {
        return Environment.getDataMiscCeDirectory(userId);
    }

    protected File getDataSystemCeDirectory(int userId) {
        return Environment.getDataSystemCeDirectory(userId);
    }

    protected File getDataMiscDeDirectory(int userId) {
        return Environment.getDataMiscDeDirectory(userId);
    }

    protected File getUserSystemDirectory(int userId) {
        return Environment.getUserSystemDirectory(userId);
    }

    protected File getDataUserCeDirectory(String volumeUuid, int userId) {
        return Environment.getDataUserCeDirectory(volumeUuid, userId);
    }

    protected File getDataSystemDeDirectory(int userId) {
        return Environment.getDataSystemDeDirectory(userId);
    }

    protected File getDataUserDeDirectory(String volumeUuid, int userId) {
        return Environment.getDataUserDeDirectory(volumeUuid, userId);
    }

    void enforceSerialNumber(File file, int serialNumber) throws IOException {
        int foundSerial = getSerialNumber(file);
        Slog.v(TAG, "Found " + file + " with serial number " + foundSerial);
        if (foundSerial != (-1)) goto L9;
        Slog.d(TAG, "Serial number missing on " + file + "; assuming current is valid");
        setSerialNumber(file, serialNumber);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to set serial number on " + file, e);
        return;
    L9:
        if (foundSerial != serialNumber) goto L12;
        return;
    L12:
        throw new IOException("Found serial number " + foundSerial + " doesn't match expected " + serialNumber);
    }

    private static void setSerialNumber(File file, int serialNumber) throws IOException {
        byte[] buf = Integer.toString(serialNumber).getBytes(StandardCharsets.UTF_8);     // Catch: ErrnoException -> L4
        Os.setxattr(file.getAbsolutePath(), XATTR_SERIAL, buf, OsConstants.XATTR_CREATE);     // Catch: ErrnoException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsIOException();
    }

    static int getSerialNumber(File file) throws IOException {
        byte[] buf = Os.getxattr(file.getAbsolutePath(), XATTR_SERIAL);     // Catch: ErrnoException -> L5
        String serial = new String(buf);     // Catch: ErrnoException -> L5
        return Integer.parseInt(serial);
    L9:
        throw new IOException("Bad serial number: " + serial);     // Catch: ErrnoException -> L5
    L5:
        e = move-exception;
        if (e.errno != OsConstants.ENODATA) goto L15;
        return -1;
    L15:
        throw e.rethrowAsIOException();
    }
}
