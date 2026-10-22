package androidx.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists() == false) goto L6;
        rename(this.mLegacyBackupName, this.mBaseName);
    L6:
        if (this.mNewName.exists() == false) goto L13;
        if (this.mBaseName.exists() == false) goto L13;
        if (this.mNewName.delete() == true) goto L13;
        Objects.toString(this.mNewName);
    L13:
        return new FileInputStream(this.mBaseName);
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists() == false) goto L16;
        rename(this.mLegacyBackupName, this.mBaseName);
    L16:
        return new FileOutputStream(this.mNewName);
    L8:
        if (this.mNewName.getParentFile().mkdirs() == false) goto L15;
        return new FileOutputStream(this.mNewName);
    L11:
        e = move-exception;
        throw new IOException("Failed to create new file " + this.mNewName, e);
    L15:
        throw new IOException("Failed to create directory for " + this.mNewName);
    }

    public byte[] readFully() throws IOException {
        FileInputStream r100 = openRead();
        byte[] r101 = new byte[r100.available()];     // Catch: Throwable -> L13
        int r102 = 0;
    L4:
        int r103 = r100.read(r101, r102, r101.length - r102);     // Catch: Throwable -> L13
        if (r103 <= 0) goto L6;
        r102 = r102 + r103;
        int r104 = r100.available();     // Catch: Throwable -> L13
        if (r104 <= (r101.length - r102)) goto L4;
        byte[] r105 = new byte[r104 + r102];     // Catch: Throwable -> L13
        System.arraycopy(r101, 0, r105, 0, r102);     // Catch: Throwable -> L13
        r101 = r105;
        goto L4
    L6:
        r100.close();
        return r101;
    L13:
        th = move-exception;
        r100.close();
        throw th;
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public AtomicFile(File r100) {
        this.mBaseName = r100;
        this.mNewName = new File(r100.getPath() + ".new");
        this.mLegacyBackupName = new File(r100.getPath() + ".bak");
    }

    private static boolean sync(FileOutputStream r100) {
        r100.getFD().sync();     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    public void failWrite(FileOutputStream r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sync(r100);
        r100.close();     // Catch: IOException -> L7
    L9:
        if (this.mNewName.delete() == true) goto L14;
        Objects.toString(this.mNewName);
        return;
    }

    public void finishWrite(FileOutputStream r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sync(r100);
        r100.close();     // Catch: IOException -> L8
    L6:
        rename(this.mNewName, this.mBaseName);
    }

    private static void rename(File r100, File r101) {
        if (r101.isDirectory() == false) goto L8;
        if (r101.delete() == true) goto L8;
        r101.toString();
    L8:
        if (r100.renameTo(r101) == true) goto L11;
        r100.toString();
        r101.toString();
        return;
    }
}
