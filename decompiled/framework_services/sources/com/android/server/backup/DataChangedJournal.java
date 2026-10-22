package com.android.server.backup;

import android.util.Slog;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class DataChangedJournal {
    private static final int BUFFER_SIZE_BYTES = 8192;
    private static final String FILE_NAME_PREFIX = "journal";
    private static final String TAG = "DataChangedJournal";
    private final File mFile;

    DataChangedJournal(File file) {
        file.getClass();
        this.mFile = file;
    }

    public void addPackage(String packageName) throws IOException {
        RandomAccessFile out = new RandomAccessFile(this.mFile, "rws");
        out.seek(out.length());     // Catch: Throwable -> L6
        out.writeUTF(packageName);     // Catch: Throwable -> L6
        out.close();
        return;
    L6:
        th = move-exception;
        out.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public void forEach(Consumer<String> consumer) throws IOException {
        InputStream in = new FileInputStream(this.mFile);     // Catch: EOFException -> L25
        InputStream bufferedIn = new BufferedInputStream(in, 8192);     // Catch: Throwable -> L19
        DataInputStream dataInputStream = new DataInputStream(bufferedIn);     // Catch: Throwable -> L13
    L36:
        String packageName = dataInputStream.readUTF();     // Catch: Throwable -> L7
        consumer.accept(packageName);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        dataInputStream.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: Throwable -> L13
        goto L26
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        bufferedIn.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
        goto L26
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        in.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: EOFException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: EOFException -> L25
    }

    public List<String> getPackages() throws IOException {
        final List<String> packages = new ArrayList();
        forEach(new DataChangedJournal$$ExternalSyntheticLambda0(packages));
        return packages;
    }

    public boolean delete() {
        return this.mFile.delete();
    }

    public int hashCode() {
        return this.mFile.hashCode();
    }

    public boolean equals(Object object) {
        if ((object instanceof DataChangedJournal) == false) goto L6;
        DataChangedJournal that = (DataChangedJournal) object;
        return this.mFile.equals(that.mFile);
    L6:
        return false;
    }

    public String toString() {
        return this.mFile.toString();
    }

    static DataChangedJournal newJournal(File journalDirectory) throws IOException {
        journalDirectory.getClass();
        File file = File.createTempFile(FILE_NAME_PREFIX, null, journalDirectory);
        return new DataChangedJournal(file);
    }

    static ArrayList<DataChangedJournal> listJournals(File journalDirectory) {
        ArrayList<DataChangedJournal> journals = new ArrayList();
        File[] journalFiles = journalDirectory.listFiles();
        if (journalFiles != null) goto L6;
        Slog.w(TAG, "Failed to read journal files");
        return journals;
    L6:
        int r2 = journalFiles.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        File file = journalFiles[r3];
        journals.add(new DataChangedJournal(file));
        r3 = r3 + 1;
        goto L7
    L9:
        return journals;
    }
}
