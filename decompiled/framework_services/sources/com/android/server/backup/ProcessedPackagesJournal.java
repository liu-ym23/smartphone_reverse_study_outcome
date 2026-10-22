package com.android.server.backup;

import android.util.Slog;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class ProcessedPackagesJournal {
    private static final String JOURNAL_FILE_NAME = "processed";
    private static final String TAG = "ProcessedPackagesJournal";
    private final Set<String> mProcessedPackages;
    private final File mStateDirectory;

    ProcessedPackagesJournal(File stateDirectory) {
        this.mProcessedPackages = new HashSet();
        this.mStateDirectory = stateDirectory;
    }

    void init() {
        Set<String> r0 = this.mProcessedPackages;
        monitor-enter(r0);
        loadFromDisk();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasBeenProcessed(String packageName) {
        Set<String> r0 = this.mProcessedPackages;
        monitor-enter(r0);
        boolean r1 = this.mProcessedPackages.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void addPackage(String packageName) {
        Set<String> r0 = this.mProcessedPackages;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProcessedPackages.add(packageName) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        File journalFile = new File(this.mStateDirectory, JOURNAL_FILE_NAME);     // Catch: Throwable -> L8
        RandomAccessFile out = new RandomAccessFile(journalFile, "rws");     // Catch: Throwable -> L8 IOException -> L15
        out.seek(out.length());     // Catch: Throwable -> L17
        out.writeUTF(packageName);     // Catch: Throwable -> L17
        out.close();     // Catch: Throwable -> L8 IOException -> L15
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        th = move-exception;
        out.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L8 IOException -> L15
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 IOException -> L15
        goto L22
    L24:
        Slog.e(TAG, "Can't log backup of " + packageName + " to " + journalFile);     // Catch: Throwable -> L8
        goto L25
    }

    Set<String> getPackagesCopy() {
        Set<String> r0 = this.mProcessedPackages;
        monitor-enter(r0);
        HashSet r1 = new HashSet(this.mProcessedPackages);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void reset() {
        Set<String> r0 = this.mProcessedPackages;
        monitor-enter(r0);
        this.mProcessedPackages.clear();     // Catch: Throwable -> L7
        File journalFile = new File(this.mStateDirectory, JOURNAL_FILE_NAME);     // Catch: Throwable -> L7
        journalFile.delete();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void loadFromDisk() {
        File journalFile = new File(this.mStateDirectory, JOURNAL_FILE_NAME);
        if (journalFile.exists() == true) goto L25;
        return;
    L25:
        DataInputStream oldJournal = new DataInputStream(new BufferedInputStream(new FileInputStream(journalFile)));     // Catch: IOException -> L14 EOFException -> L16
    L21:
        String packageName = oldJournal.readUTF();     // Catch: Throwable -> L8
        Slog.d(TAG, "   + " + packageName);     // Catch: Throwable -> L8
        this.mProcessedPackages.add(packageName);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        oldJournal.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IOException -> L14 EOFException -> L16
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14 EOFException -> L16
    L14:
        e = move-exception;
        Slog.e(TAG, "Error reading processed packages journal", e);
        return;
    }
}
