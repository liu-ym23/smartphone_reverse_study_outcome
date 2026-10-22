package com.bytedance.server.security.behaviorrecord.data;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BehaviorRecordStorage {
    private static final int MAX_FILE_SIZE = 10485760;
    private static final long ONE_DAY_TIME = 86400000;
    private static final long ONE_WEEK_TIME = 604800000;
    private static final String PATH = "/data/misc/security/behaviorrecord/";
    private static final String START_NAME = "record_";
    private static final String STOP_RECORD_FILENAME = "stoprecord";
    private static final String TAG = "BehaviorRecordStorage";
    private List<Long> filesTime;
    private long size;

    public BehaviorRecordStorage() {
        this.size = 0;
        this.filesTime = new ArrayList();
        File directory = new File(PATH);     // Catch: Exception -> L16
        if (directory.exists() == true) goto L6;
        return;
    L6:
        File[] files = directory.listFiles();     // Catch: Exception -> L16
        if (files == null) goto L24;
        if (files.length == 0) goto L24;
        int r3 = files.length;     // Catch: Exception -> L16
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L20;
        File file = files[r4];     // Catch: Exception -> L16
        if (file.getName().startsWith(START_NAME) == false) goto L18;
        this.filesTime.add(Long.valueOf(Long.parseLong(file.getName().substring(START_NAME.length()))));     // Catch: Exception -> L16
        this.size += file.length();     // Catch: Exception -> L16
    L18:
        r4 = r4 + 1;     // Catch: Exception -> L16
        goto L12
    L20:
        if (this.filesTime.isEmpty() == false) goto L22;
        return;
    L22:
        this.filesTime.sort(null);     // Catch: Exception -> L16
        return;
    L24:
        return;
    L16:
        e = move-exception;
        Log.e(TAG, "BehaviorRecordStorage init failed, " + e.getMessage());
    }

    public void writeRecord(String data, long lastedTime) {
        checkMemorySize(lastedTime);
        if (this.filesTime.isEmpty() == false) goto L5;
        long fileTime = 0;
    L7:
        if ((lastedTime - fileTime) <= 86400000) goto L9;
        fileTime = lastedTime;
    L9:
        String fileName = "/data/misc/security/behaviorrecord/record_" + fileTime;
        BufferedWriter writer = null;
    L19:
        th = move-exception;
        if (0 != 0) goto L51;
    L45:
        throw th;
    L51:
        writer.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        Log.e(TAG, "writeRecord close write occur exception, " + e.getMessage());
    L21:
        e = move-exception;
        Log.e(TAG, "writeRecord occur exception, " + e.getMessage());     // Catch: Throwable -> L19
        if (0 != 0) goto L47;
        return;
    L47:
        writer.close();     // Catch: IOException -> L37
        return;
    L37:
        e = e;
        StringBuilder r7 = new StringBuilder();
    L31:
        r7.append("writeRecord close write occur exception, ");
        r7.append(e.getMessage());
        Log.e(TAG, r7.toString());
        return;
    L11:
        if (createIfNotExist(fileName).exists() == true) goto L24;
        Log.e(TAG, "file is not exist.");     // Catch: Throwable -> L19 IOException -> L21
        if (0 == 0) goto L55;
        writer.close();     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        Log.e(TAG, "writeRecord close write occur exception, " + e.getMessage());
        return;
    L55:
        return;
    L24:
        if (fileTime != lastedTime) goto L26;
        this.filesTime.add(Long.valueOf(fileTime));     // Catch: Throwable -> L19 IOException -> L21
    L26:
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName, true));     // Catch: Throwable -> L19 IOException -> L21
        writer2.write(data);     // Catch: Throwable -> L19 IOException -> L21
        this.size += (long) data.length();     // Catch: Throwable -> L19 IOException -> L21
        writer2.close();     // Catch: IOException -> L29
        return;
    L29:
        e = e;
        r7 = new StringBuilder();
        goto L31
    L5:
        fileTime = this.filesTime.get(this.filesTime.size() - 1).longValue();
        goto L7
    }

    public void stopRecord(boolean isStop) {
        Log.i(TAG, "stop record: " + isStop);
        if (isStop == false) goto L7;
        deleteAllRecord();     // Catch: IOException -> L5
        File file = new File("/data/misc/security/behaviorrecord/stoprecord");     // Catch: IOException -> L5
        file.createNewFile();     // Catch: IOException -> L5
        setFIlePermission(file);     // Catch: IOException -> L5
    L13:
        return;
    L7:
        File file2 = new File("/data/misc/security/behaviorrecord/stoprecord");     // Catch: IOException -> L5
        if (file2.exists() == false) goto L13;
        file2.delete();     // Catch: IOException -> L5
    L5:
        e = move-exception;
        Log.e(TAG, "stopRecord failed, " + e.getMessage());
    }

    private void deleteAllRecord() {
        File directory = new File(PATH);
        if (directory.exists() == true) goto L5;
        return;
    L5:
        File[] files = directory.listFiles();
        if (files != null) goto L8;
        return;
    L8:
        if (files.length == 0) goto L22;
        int r2 = files.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L16;
        File file = files[r3];
        if (file.getName().startsWith(START_NAME) == false) goto L15;
        file.delete();
    L15:
        r3 = r3 + 1;
        goto L11
    L16:
        Log.i(TAG, "delete all record.");
        return;
    }

    public boolean isStopRecord() {
        File file = new File("/data/misc/security/behaviorrecord/stoprecord");
        return file.exists();
    }

    private File createIfNotExist(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists() == true) goto L5;
        file.createNewFile();
        setFIlePermission(file);
    L5:
        return file;
    }

    private void checkMemorySize(long currentTime) {
        if (this.size <= 10485760) goto L10;
        File file = new File("/data/misc/security/behaviorrecord/record_" + this.filesTime.get(0));
        if (file.exists() == true) goto L7;
        return;
    L7:
        if (file.delete() == false) goto L33;
        this.filesTime.remove(0);
        Log.i(TAG, "old file have being delete.");
        return;
    L33:
        return;
    L10:
        List<Long> toRemove = new ArrayList();
        Iterator<Long> r4 = this.filesTime.iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        Long time = r4.next();
        if ((currentTime - time.longValue()) <= 604800000) goto L12;
        File file2 = new File("/data/misc/security/behaviorrecord/record_" + time);
        if (file2.exists() == false) goto L12;
        if (file2.delete() == false) goto L12;
        Log.i(TAG, "old file have being delete.");
        toRemove.add(time);
        goto L12
    L21:
        this.filesTime.removeAll(toRemove);
    }

    private void setFIlePermission(File file) {
        Set<PosixFilePermission> perms = new HashSet(7);
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Path path = Paths.get(file.getCanonicalPath(), new String[0]);     // Catch: IOException -> L5
        Files.setPosixFilePermissions(path, perms);     // Catch: IOException -> L5
        return;
    L6:
        Log.e(TAG, "setFilePermission: IOException");
    }
}
