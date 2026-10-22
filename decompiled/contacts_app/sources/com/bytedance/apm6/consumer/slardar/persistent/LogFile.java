package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LogFile {
    private List<LogItem> logList;
    private File source;
    private long startID;
    private int totalBytes;
    private int totalCount;

    public LogFile(long r1, int r3, int r4, List<LogItem> r5) {
        this.startID = r1;
        this.totalCount = r3;
        this.totalBytes = r4;
        this.logList = r5;
    }

    public long getStartID() {
        return this.startID;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalBytes() {
        return this.totalBytes;
    }

    public List<LogItem> getLogList() {
        return this.logList;
    }

    public File getSource() {
        return this.source;
    }

    public static LogFile fromMemory(ByteBuffer r10) {
    L14:
        return null;
    L4:
        if (r10.getShort() == 2082) goto L6;
        return null;
    L6:
        long r4 = r10.getLong();     // Catch: Throwable -> L14
        int r6 = r10.getInt();     // Catch: Throwable -> L14
        int r7 = r10.getInt();     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L14
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r6) goto L12;
        int r3 = r10.getInt();     // Catch: Throwable -> L14
        r2 = r2 + r3;     // Catch: Throwable -> L14
        if (r2 > r7) goto L10;
        byte[] r5 = new byte[r3];     // Catch: Throwable -> L14
        r10.get(r5);     // Catch: Throwable -> L14
        r8.add(new LogItem(r5));     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new LogFile(r4, r6, r7, r8);
    }

    public static LogFile fromFile(File r2) {
        byte[] r0 = FileUtils.readFileToByteArray(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        LogFile r1 = fromMemory(ByteBuffer.wrap(r0));     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        r1.source = r2;     // Catch: Throwable -> L11
    L8:
        return r1;
    L7:
        Logger.e(Constants.TAG, "fromMemory bytes is null");     // Catch: Throwable -> L11
        goto L8
    L9:
        Logger.e(Constants.TAG, "fromFile bytes is null");     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        Logger.e(Constants.TAG, "fromFile", th);
        return null;
    }

    public String toString() {
        return "LogFile{startID=" + this.startID + ", totalCount=" + this.totalCount + ", totalBytes=" + this.totalBytes + ", source=" + this.source + ", logList=" + this.logList + '}';
    }
}
