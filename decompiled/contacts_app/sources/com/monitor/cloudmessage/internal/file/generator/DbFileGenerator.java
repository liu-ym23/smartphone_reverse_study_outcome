package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class DbFileGenerator {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile = false;
    private static String specificFileName = null;
    private static String uploadFileName = "db.zip";

    static {
    }

    public DbFileGenerator() {
    }

    public static File copyDbFiles(Context r7, String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        fetchSpecificFile = true;
        specificFileName = r8;
    L5:
        String r9 = r7.getApplicationInfo().dataDir + File.separator + DB_SOURCE_DIR_NAME;
        String r10 = r7.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME;
        String r0 = r10 + File.separator + "/tmp";
        File r1 = new File(r9);
        if (r1.exists() == false) goto L32;
        File[] r11 = r1.listFiles();
        int r2 = r11.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L32;
        File r4 = r11[r3];
        String r5 = r4.getName();
        if (r5.endsWith(DB_SUFFIX) == false) goto L17;
        if (fetchSpecificFile == true) goto L17;
        if (FileUtils.copyFile(r4.getAbsolutePath(), r0, r5) == true) goto L17;
        return null;
    L17:
        if (fetchSpecificFile == false) goto L25;
        if (TextUtils.isEmpty(specificFileName) == true) goto L25;
        if (specificFileName.equals(r5) == false) goto L25;
        if (FileUtils.copyFile(r4.getAbsolutePath(), r0, r5) == true) goto L25;
        return null;
    L25:
        r3 = r3 + 1;
    L32:
        FileUtils.zip(r0, r10 + File.separator + uploadFileName);     // Catch: Exception -> L29
        FileUtils.removeDir(r0);
        return new File(r10 + File.separator + uploadFileName);
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean checkSize(File r4) {
        if (r4.exists() == true) goto L5;
        return true;
    L5:
        if (r4.length() <= 52428800) goto L10;
        return false;
    L10:
        return true;
    }

    public static void clearData(Context r1) {
        FileUtils.removeDir(r1.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME);
    }
}
