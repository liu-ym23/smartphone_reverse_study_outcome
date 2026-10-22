package com.bytedance.monitor.util.jni;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.util.IoUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class SafelyLibraryLoader {
    private static final String LIB_DIR = "libso";
    private static List<String> sLoadedLibs;

    public SafelyLibraryLoader() {
    }

    static {
        sLoadedLibs = new ArrayList();
    }

    public static synchronized boolean loadLibrary(Context r6, String r7) {
        monitor-enter(SafelyLibraryLoader.class);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (sLoadedLibs.contains(r7) == false) goto L38;
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L38:
        System.loadLibrary(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        sLoadedLibs.add(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L28:
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L14:
        e = move-exception;
        File r4 = getLibraryFile(r6, r7);     // Catch: Throwable -> L32
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.exists() == false) goto L22;
        r4.delete();     // Catch: Throwable -> L32
    L22:
        String r8 = unpackLibrary(r6, r7, r4);     // Catch: Throwable -> L32
        if (r8 == null) goto L35;
        Log.e("loadLibrary", e.getMessage() + "[" + r8 + "]");     // Catch: Throwable -> L32
        return false;
    L35:
        System.load(r4.getAbsolutePath());     // Catch: Throwable -> L30
        sLoadedLibs.add(r7);     // Catch: Throwable -> L30
    L31:
        return false;
    L13:
        return false;
    }

    private static File getLibraryFolder(Context r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getFilesDir() == null) goto L12;
        File r0 = new File(r2.getFilesDir(), LIB_DIR);
        if (r0.exists() == true) goto L9;
        IoUtil.mkdir(r0.getAbsolutePath());
    L9:
        return r0;
    L12:
        return null;
    }

    private static File getLibraryFile(Context r1, String r2) {
        String r3 = System.mapLibraryName(r2);
        File r4 = getLibraryFolder(r1);
        if (r4 != null) goto L5;
        return null;
    L5:
        return new File(r4, r3);
    }

    public static String unpackLibrary(Context r8, String r9, File r10) {
        FileOutputStream r3 = null;
        ZipFile r4 = new ZipFile(new File(r8.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        ZipEntry r11 = r4.getEntry("lib/" + Build.CPU_ABI + LibrarianImpl.Constants.SEPARATOR + System.mapLibraryName(r9));     // Catch: Throwable -> L31
        if (r11 != null) goto L17;
        int r12 = Build.CPU_ABI.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r6 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        String r2 = Build.CPU_ABI;     // Catch: Throwable -> L31
        if (r12 > 0) goto L10;
        r12 = Build.CPU_ABI.length();     // Catch: Throwable -> L31
    L10:
        String r13 = r6.append(r2.substring(0, r12)).append(LibrarianImpl.Constants.SEPARATOR).append(System.mapLibraryName(r9)).toString();     // Catch: Throwable -> L31
        ZipEntry r14 = r4.getEntry(r13);     // Catch: Throwable -> L31
        if (r14 != null) goto L16;
        String r15 = "Library entry not found:" + r13;     // Catch: Throwable -> L31
        IoUtil.safeClose(null);
        IoUtil.safeClose(null);
    L14:
        IoUtil.safeClose(r4);
        return r15;
    L16:
        r11 = r14;
    L17:
        r10.createNewFile();     // Catch: Throwable -> L31
        InputStream r16 = r4.getInputStream(r11);     // Catch: Throwable -> L31
        FileOutputStream r17 = new FileOutputStream(r10);     // Catch: Throwable -> L29
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r1 = r16.read(r0);     // Catch: Throwable -> L27
        if (r1 <= 0) goto L24;
        r17.write(r0, 0, r1);     // Catch: Throwable -> L27
        goto L21
    L24:
        IoUtil.setPermissions(r10.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        IoUtil.safeClose(r17);
        IoUtil.safeClose(r16);
        IoUtil.safeClose(r4);
        return null;
    L27:
        th = move-exception;
        r3 = r17;
        InputStream r18 = r16;
        th = th;
    L40:
        r15 = th.getMessage();     // Catch: Throwable -> L37
        IoUtil.safeClose(r3);
        IoUtil.safeClose(r18);
    L37:
        th = move-exception;
        IoUtil.safeClose(r3);
        IoUtil.safeClose(r18);
        IoUtil.safeClose(r4);
        throw th;
    L29:
        th = move-exception;
        r18 = r16;
        th = th;
    L31:
        th = th;
        r18 = null;
    L33:
        th = th;
        r18 = null;
        r4 = null;
        goto L40
    }
}
