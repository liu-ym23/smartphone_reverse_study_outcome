package com.android.server.locksettings.recoverablekeystore.storage;

import android.os.Environment;
import android.security.keystore.recovery.KeyChainSnapshot;
import android.util.SparseArray;
import com.android.server.locksettings.recoverablekeystore.serialization.KeyChainSnapshotDeserializer;
import com.android.server.locksettings.recoverablekeystore.serialization.KeyChainSnapshotSerializer;
import com.android.server.utils.Slogf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class RecoverySnapshotStorage {
    private static final String ROOT_PATH = "system";
    private static final String STORAGE_PATH = "recoverablekeystore/snapshots/";
    private static final String TAG = "RecoverySnapshotStorage";
    private final SparseArray<KeyChainSnapshot> mSnapshotByUid;
    private final File rootDirectory;

    public static RecoverySnapshotStorage newInstance() {
        return new RecoverySnapshotStorage(new File(Environment.getDataDirectory(), "system"));
    }

    public RecoverySnapshotStorage(File rootDirectory) {
        this.mSnapshotByUid = new SparseArray();
        this.rootDirectory = rootDirectory;
    }

    public synchronized void put(int uid, KeyChainSnapshot snapshot) {
        monitor-enter(this);
        this.mSnapshotByUid.put(uid, snapshot);     // Catch: Throwable -> L8
        File snapshotFile = getSnapshotFile(uid);     // Catch: Throwable -> L8
        FileOutputStream fileOutputStream = new FileOutputStream(snapshotFile);     // Catch: Throwable -> L8 Throwable -> L10
        KeyChainSnapshotSerializer.serialize(snapshot, fileOutputStream);     // Catch: Throwable -> L12
        fileOutputStream.close();     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10
    L20:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        fileOutputStream.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10
    L10:
        e = move-exception;
        snapshotFile.delete();     // Catch: Throwable -> L8
        Slogf.e(TAG, e, "Error persisting snapshot for %d to disk", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized KeyChainSnapshot get(int uid) {
        monitor-enter(this);
        KeyChainSnapshot snapshot = this.mSnapshotByUid.get(uid);     // Catch: Throwable -> L14
        if (snapshot == null) goto L7;
        monitor-exit(this);
        return snapshot;
    L7:
        File snapshotFile = getSnapshotFile(uid);     // Catch: Throwable -> L14
        FileInputStream fileInputStream = new FileInputStream(snapshotFile);     // Catch: Throwable -> L14 Throwable -> L16 FileNotFoundException -> L18
        KeyChainSnapshot r4 = KeyChainSnapshotDeserializer.deserialize(fileInputStream);     // Catch: Throwable -> L20
        fileInputStream.close();     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 FileNotFoundException -> L18
        monitor-exit(this);
        return r4;
    L20:
        th = move-exception;
        fileInputStream.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 FileNotFoundException -> L18
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 FileNotFoundException -> L18
    L16:
        e = move-exception;
        snapshotFile.delete();     // Catch: Throwable -> L14
        Slogf.e(TAG, e, "Error reading snapshot for %d from disk", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L14
        return null;
    L31:
        Slogf.i(TAG, "Snapshot for uid %d not found", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void remove(int uid) {
        monitor-enter(this);
        this.mSnapshotByUid.remove(uid);     // Catch: Throwable -> L6
        getSnapshotFile(uid).delete();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private File getSnapshotFile(int uid) {
        File folder = getStorageFolder();
        String fileName = getSnapshotFileName(uid);
        return new File(folder, fileName);
    }

    private String getSnapshotFileName(int uid) {
        return String.format(Locale.US, "%d.xml", new Object[]{Integer.valueOf(uid)});
    }

    private File getStorageFolder() {
        File folder = new File(this.rootDirectory, STORAGE_PATH);
        folder.mkdirs();
        return folder;
    }
}
