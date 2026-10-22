package com.android.server.locksettings.recoverablekeystore.storage;

import android.content.Context;
import android.os.ServiceSpecificException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Log;
import com.android.server.locksettings.recoverablekeystore.WrappedKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CleanupManager {
    private static final String TAG = "CleanupManager";
    private final ApplicationKeyStorage mApplicationKeyStorage;
    private final RecoverableKeyStoreDb mDatabase;
    private Map<Integer, Long> mSerialNumbers;
    private final RecoverySnapshotStorage mSnapshotStorage;
    private final UserManager mUserManager;

    public static CleanupManager getInstance(Context context, RecoverySnapshotStorage snapshotStorage, RecoverableKeyStoreDb recoverableKeyStoreDb, ApplicationKeyStorage applicationKeyStorage) {
        return new CleanupManager(snapshotStorage, recoverableKeyStoreDb, UserManager.get(context), applicationKeyStorage);
    }

    CleanupManager(RecoverySnapshotStorage snapshotStorage, RecoverableKeyStoreDb recoverableKeyStoreDb, UserManager userManager, ApplicationKeyStorage applicationKeyStorage) {
        this.mSnapshotStorage = snapshotStorage;
        this.mDatabase = recoverableKeyStoreDb;
        this.mUserManager = userManager;
        this.mApplicationKeyStorage = applicationKeyStorage;
    }

    public synchronized void registerRecoveryAgent(int userId, int uid) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mSerialNumbers != null) goto L8;
        verifyKnownUsers();     // Catch: Throwable -> L6
    L8:
        Long storedSerialNumber = this.mSerialNumbers.get(Integer.valueOf(userId));     // Catch: Throwable -> L6
        if (storedSerialNumber != null) goto L13;
        storedSerialNumber = -1L;
    L13:
        if (storedSerialNumber.longValue() == (-1)) goto L16;
        monitor-exit(this);
        return;
    L16:
        long currentSerialNumber = this.mUserManager.getSerialNumberForUser(UserHandle.of(userId));     // Catch: Throwable -> L6
        if (currentSerialNumber == (-1)) goto L19;
        storeUserSerialNumber(userId, currentSerialNumber);     // Catch: Throwable -> L6
    L19:
        monitor-exit(this);
    }

    public synchronized void verifyKnownUsers() {
        monitor-enter(this);
        this.mSerialNumbers = this.mDatabase.getUserSerialNumbers();     // Catch: Throwable -> L9
        List<Integer> deletedUserIds = new AnonymousClass1(this);     // Catch: Throwable -> L9
        Iterator<Map.Entry<Integer, Long>> r1 = this.mSerialNumbers.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L21;
        Map.Entry<Integer, Long> entry = r1.next();     // Catch: Throwable -> L9
        Integer userId = entry.getKey();     // Catch: Throwable -> L9
        Long storedSerialNumber = entry.getValue();     // Catch: Throwable -> L9
        if (storedSerialNumber != null) goto L11;
        storedSerialNumber = -1L;
    L11:
        long currentSerialNumber = this.mUserManager.getSerialNumberForUser(UserHandle.of(userId.intValue()));     // Catch: Throwable -> L9
        if (currentSerialNumber != (-1)) goto L15;
        deletedUserIds.add(userId);     // Catch: Throwable -> L9
        removeDataForUser(userId.intValue());     // Catch: Throwable -> L9
        goto L5
    L15:
        if (storedSerialNumber.longValue() != (-1)) goto L18;
        storeUserSerialNumber(userId.intValue(), currentSerialNumber);     // Catch: Throwable -> L9
        goto L5
    L18:
        if (storedSerialNumber.longValue() == currentSerialNumber) goto L5;
        deletedUserIds.add(userId);     // Catch: Throwable -> L9
        removeDataForUser(userId.intValue());     // Catch: Throwable -> L9
        storeUserSerialNumber(userId.intValue(), currentSerialNumber);     // Catch: Throwable -> L9
        goto L5
    L21:
        Iterator<Integer> r2 = deletedUserIds.iterator();     // Catch: Throwable -> L9
    L22:
        if (r2.hasNext() == false) goto L26;
        Integer deletedUser = r2.next();     // Catch: Throwable -> L9
        this.mSerialNumbers.remove(deletedUser);     // Catch: Throwable -> L9
        goto L22
    L26:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void storeUserSerialNumber(int userId, long userSerialNumber) {
        Log.d(TAG, "Storing serial number for user " + userId + ".");
        this.mSerialNumbers.put(Integer.valueOf(userId), Long.valueOf(userSerialNumber));
        this.mDatabase.setUserSerialNumber(userId, userSerialNumber);
    }

    private void removeDataForUser(int userId) {
        Log.d(TAG, "Removing data for user " + userId + ".");
        List<Integer> recoveryAgents = this.mDatabase.getRecoveryAgents(userId);
        Iterator<Integer> r1 = recoveryAgents.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer uid = r1.next();
        this.mSnapshotStorage.remove(uid.intValue());
        removeAllKeysForRecoveryAgent(userId, uid.intValue());
        goto L4
    L6:
        this.mDatabase.removeUserFromAllTables(userId);
    }

    private void removeAllKeysForRecoveryAgent(int userId, int uid) {
        int generationId = this.mDatabase.getPlatformKeyGenerationId(userId);
        Map<String, WrappedKey> allKeys = this.mDatabase.getAllKeys(userId, uid, generationId);
        Iterator<String> r2 = allKeys.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        String alias = r2.next();
        this.mApplicationKeyStorage.deleteEntry(userId, uid, alias);     // Catch: ServiceSpecificException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "Error while removing recoverable key " + alias + " : " + e);
        goto L4
    }
}
