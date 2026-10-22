package com.obric.olog.salvage;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class LogFileCompressor {
    private static final int BUFFER_SIZE = 8192;
    private static final Logger LOGGER = null;

    public LogFileCompressor() {
    }

    static {
        LOGGER = Logger.getLogger(LogFileCompressor.class.getName());
    }

    public static void compressLogFiles(Context r8, String[] r9, String r10) throws IOException {
        File r0 = new File(r8.getFilesDir(), r10);
        if (r0.exists() == false) goto L40;
        r0.delete();
    L40:
        FileOutputStream r11 = new FileOutputStream(r0);     // Catch: IOException -> L33
        ZipOutputStream r1 = new ZipOutputStream(r11);     // Catch: Throwable -> L27
        int r2 = r9.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        String r4 = r9[r3];     // Catch: Throwable -> L21
        File r5 = new File(r4);     // Catch: Throwable -> L21
        if (r5.exists() == true) goto L13;
    L16:
        LOGGER.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r4);     // Catch: Throwable -> L21
    L17:
        r3 = r3 + 1;
        goto L9
    L13:
        if (r5.isDirectory() == false) goto L16;
        compressDirectoryToZipfile(r5, r5.getName(), r1);     // Catch: Throwable -> L21
        goto L17
    L18:
        r1.close();     // Catch: Throwable -> L27
        r11.close();     // Catch: IOException -> L33
        return;
    L21:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: IOException -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L33
    L33:
        e = move-exception;
        LOGGER.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r0.getAbsolutePath(), e.getMessage()});
        throw e;
    }

    private static void compressDirectoryToZipfile(File r8, String r9, ZipOutputStream r10) throws IOException {
        File[] r11 = r8.listFiles();
        if (r11 == null) goto L26;
        int r0 = r11.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L37;
        File r3 = r11[r2];
        if (r3.isDirectory() == false) goto L27;
        compressDirectoryToZipfile(r3, r9 + LibrarianImpl.Constants.SEPARATOR + r3.getName(), r10);
    L16:
        r2 = r2 + 1;
        goto L5
    L27:
        FileInputStream r4 = new FileInputStream(r3);     // Catch: IOException -> L23
        r10.putNextEntry(new ZipEntry(r9 + LibrarianImpl.Constants.SEPARATOR + r3.getName()));     // Catch: Throwable -> L17
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L17
    L11:
        int r6 = r4.read(r5);     // Catch: Throwable -> L17
        if (r6 < 0) goto L14;
        r10.write(r5, 0, r6);     // Catch: Throwable -> L17
        goto L11
    L14:
        r10.closeEntry();     // Catch: Throwable -> L17
        r4.close();     // Catch: IOException -> L23
        goto L16
    L17:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L23
    L23:
        e = move-exception;
        LOGGER.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r3.getAbsolutePath(), e.getMessage()});
        throw e;
    L37:
        return;
    }
}
