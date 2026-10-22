package com.android.server.backup;

import android.app.IBackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackup;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.backup.keyvalue.KeyValueBackupTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueAdbRestoreEngine implements Runnable {
    private static final boolean DEBUG = false;
    private static final String TAG = "KeyValueAdbRestoreEngine";
    private final IBackupAgent mAgent;
    private final UserBackupManagerService mBackupManagerService;
    private final File mDataDir;
    private final ParcelFileDescriptor mInFD;
    private final FileMetadata mInfo;
    private final int mToken;

    public KeyValueAdbRestoreEngine(UserBackupManagerService backupManagerService, File dataDir, FileMetadata info, ParcelFileDescriptor inFD, IBackupAgent agent, int token) {
        this.mBackupManagerService = backupManagerService;
        this.mDataDir = dataDir;
        this.mInfo = info;
        this.mInFD = inFD;
        this.mAgent = agent;
        this.mToken = token;
    }

    @Override // java.lang.Runnable
    public void run() {
        File restoreData = prepareRestoreData(this.mInfo, this.mInFD);     // Catch: IOException -> L4
        invokeAgentForAdbRestore(this.mAgent, this.mInfo, restoreData);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private File prepareRestoreData(FileMetadata info, ParcelFileDescriptor inFD) throws IOException {
        String pkg = info.packageName;
        File restoreDataName = new File(this.mDataDir, pkg + ".restore");
        File sortedDataName = new File(this.mDataDir, pkg + ".sorted");
        FullBackup.restoreFile(inFD, info.size, info.type, info.mode, info.mtime, restoreDataName);
        sortKeyValueData(restoreDataName, sortedDataName);
        return sortedDataName;
    }

    private void invokeAgentForAdbRestore(IBackupAgent agent, FileMetadata info, File restoreData) throws IOException {
        String pkg = info.packageName;
        File newStateName = new File(this.mDataDir, pkg + KeyValueBackupTask.NEW_STATE_FILE_SUFFIX);
        ParcelFileDescriptor backupData = ParcelFileDescriptor.open(restoreData, 268435456);     // Catch: RemoteException -> L11 IOException -> L13
        ParcelFileDescriptor newState = ParcelFileDescriptor.open(newStateName, 1006632960);     // Catch: RemoteException -> L11 IOException -> L13
        Slog.i(TAG, "Starting restore of package " + pkg + " for version code " + info.version);     // Catch: RemoteException -> L11 IOException -> L13
    L20:
        agent.doRestore(backupData, info.version, newState, this.mToken, this.mBackupManagerService.getBackupManagerBinder());     // Catch: RemoteException -> L7 IOException -> L9
    L22:
        return;
    L7:
        e = move-exception;
        RemoteException e = e;
    L15:
        Slog.e(TAG, "Exception calling doRestore on agent: " + e);
        return;
    L9:
        e = move-exception;
        IOException e2 = e;
    L16:
        Slog.e(TAG, "Exception opening file. " + e2);
        return;
    L11:
        e = move-exception;
        e = e;
    L13:
        e = move-exception;
        e2 = e;
        goto L16
    }

    private void sortKeyValueData(File restoreData, File sortedData) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        inputStream = new FileInputStream(restoreData);     // Catch: Throwable -> L6
        outputStream = new FileOutputStream(sortedData);     // Catch: Throwable -> L6
        BackupDataInput reader = new BackupDataInput(inputStream.getFD());     // Catch: Throwable -> L6
        BackupDataOutput writer = new BackupDataOutput(outputStream.getFD());     // Catch: Throwable -> L6
        copyKeysInLexicalOrder(reader, writer);     // Catch: Throwable -> L6
        IoUtils.closeQuietly(inputStream);
        IoUtils.closeQuietly(outputStream);
        return;
    L6:
        th = move-exception;
        if (inputStream == null) goto L9;
        IoUtils.closeQuietly(inputStream);
    L9:
        if (outputStream == null) goto L11;
        IoUtils.closeQuietly(outputStream);
    L11:
        throw th;
    }

    private void copyKeysInLexicalOrder(BackupDataInput in, BackupDataOutput out) throws IOException {
        Map<String, byte[]> data = new HashMap();
    L4:
        if (in.readNextHeader() == false) goto L9;
        String key = in.getKey();
        int size = in.getDataSize();
        if (size < 0) goto L7;
        byte[] value = new byte[size];
        in.readEntityData(value, 0, size);
        data.put(key, value);
        goto L4
    L7:
        in.skipEntityData();
        goto L4
    L9:
        List<String> keys = new ArrayList(data.keySet());
        Collections.sort(keys);
        Iterator<String> r2 = keys.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        String key2 = r2.next();
        byte[] value2 = data.get(key2);
        out.writeEntityHeader(key2, value2.length);
        out.writeEntityData(value2, value2.length);
        goto L11
    }
}
