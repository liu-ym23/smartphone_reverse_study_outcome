package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.keva.KevaImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {

    public interface ReadLineCallback {
        boolean onReadLine(String r1);
    }

    public FileUtils() {
    }

    public static BufferedReader openFile(File r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.exists() == true) goto L10;
        DebugLog.w("file:" + r3.getName() + " not exist");
        return null;
    L10:
        if (r3.canRead() == true) goto L18;
        DebugLog.w("file:" + r3.getName() + " can not read");
        return null;
    L18:
        return new BufferedReader(new FileReader(r3), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    L15:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));
        return null;
    }

    public static void closeFile(BufferedReader r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));
        return;
    }

    public static void readFile(File r1, ReadLineCallback r2) {
        if (r1 == null) goto L23;
        if (r2 == null) goto L24;
        BufferedReader r3 = openFile(r1);
        if (r3 != null) goto L8;
        return;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        String r4 = r3.readLine();     // Catch: IOException -> L14
        if (r4 == null) goto L16;
        r0 = r2.onReadLine(r4);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));
    L16:
        closeFile(r3);
        return;
    L24:
        return;
    }

    public static void readFile(String r1, ReadLineCallback r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        readFile(new File(r1), r2);
        return;
    L8:
        return;
    }

    public static void createFile(String r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        File r0 = new File(r3);
        if (r0.exists() == false) goto L9;
        DebugLog.i(r3 + " already exist");
        return;
    L9:
        if (r4 == false) goto L12;
        r0.mkdir();
        DebugLog.i(r3 + " created");
        return;
    L12:
        File r5 = new File(r0.getParent());
        if (r5.exists() == true) goto L20;
        r5.mkdir();
    L20:
        r0.createNewFile();     // Catch: IOException -> L17
        DebugLog.i(r3 + " created");     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static void deleteDir(File r4) {
        if (r4.isDirectory() == false) goto L7;
        File[] r0 = r4.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        deleteDir(r0[r2]);
        r2 = r2 + 1;
    L7:
        r4.delete();
    }
}
