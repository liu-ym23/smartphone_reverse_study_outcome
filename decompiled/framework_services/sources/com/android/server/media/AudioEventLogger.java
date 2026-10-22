package com.android.server.media;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AudioEventLogger {
    private static final String BASE_DUMP_FILE_NAME = "mm-mediasession";
    private static final String DUMP_PATH = "/data/syslog/monitor/mm-audio";
    private static final int FILE_COUNT = 5;
    private static final int SINGEL_FILE_SIZE = 2097152;
    private static final String TAG = "AudioEventLoggerMediaSession";
    private static final String[] mFileNames = null;
    private final LinkedList<Event> mEvents;
    private final int mMemSize;
    private final String mTitle;

    public static abstract class Event {
        private static final SimpleDateFormat sFormat = null;
        private final long mTimestamp;

        public abstract String eventToString();

        static {
            sFormat = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
        }

        Event() {
            this.mTimestamp = System.currentTimeMillis();
        }

        public String toString() {
            return sFormat.format(new Date(this.mTimestamp)) + " " + eventToString();
        }

        public Event printLog(String tag) {
            Log.i(tag, eventToString());
            return this;
        }
    }

    public static class StringEvent extends Event {
        private final String mMsg;

        public StringEvent(String msg) {
            this.mMsg = msg;
        }

        @Override // com.android.server.media.AudioEventLogger.Event
        public String eventToString() {
            return this.mMsg;
        }
    }

    public AudioEventLogger(int size, String title) {
        this.mEvents = new LinkedList();
        this.mMemSize = size;
        this.mTitle = title;
    }

    static {
        mFileNames = new String[]{"/data/syslog/monitor/mm-audio/mm-mediasession", "/data/syslog/monitor/mm-audio/mm-mediasession.001", "/data/syslog/monitor/mm-audio/mm-mediasession.002", "/data/syslog/monitor/mm-audio/mm-mediasession.003", "/data/syslog/monitor/mm-audio/mm-mediasession.004"};
    }

    private boolean createDumpPathIfNecessary() {
        File parent = new File(DUMP_PATH);
        if (parent.exists() == true) goto L5;
    L7:
        Log.d(TAG, "create audio event log dir:/data/syslog/monitor/mm-audio");
        parent.mkdirs();
        if (parent.isDirectory() == true) goto L10;
    L14:
        Log.e(TAG, "Dir:" + parent.toString() + " is not available");
        return false;
    L10:
        if (parent.canWrite() == false) goto L14;
        return true;
    L5:
        if (parent.isFile() == false) goto L7;
        parent.delete();
        goto L7
    }

    private void saveEventsInFile(String fileName) {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(fileName, true));     // Catch: Throwable -> L8 Exception -> L10
        Iterator<Event> r3 = this.mEvents.iterator();     // Catch: Throwable -> L8 Exception -> L10
    L5:
        if (r3.hasNext() == false) goto L36;
        Event evt = r3.next();     // Catch: Throwable -> L8 Exception -> L10
        writer.append(evt.toString());     // Catch: Throwable -> L8 Exception -> L10
        writer.append("\n");     // Catch: Throwable -> L8 Exception -> L10
    L36:
        writer.close();     // Catch: Exception -> L15
        return;
    L15:
        e = e;
        StringBuilder r4 = new StringBuilder();
    L17:
        r4.append("close error");
        r4.append(e);
        Log.e(TAG, r4.toString());
        return;
    L8:
        th = move-exception;
        if (writer != null) goto L38;
    L32:
        throw th;
    L38:
        writer.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e(TAG, "close error" + e);
    L10:
        e = move-exception;
        Log.e(TAG, "save audio events error:" + e);     // Catch: Throwable -> L8
        if (writer == null) goto L43;
        writer.close();     // Catch: Exception -> L23
        return;
    L23:
        e = e;
        r4 = new StringBuilder();
        goto L17
    }

    private void changeDumpFilesPermission() {
        Set<PosixFilePermission> perms = EnumSet.allOf(PosixFilePermission.class);
        File file = new File(DUMP_PATH);     // Catch: Exception -> L6
        if (file.exists() == false) goto L8;
        Files.setPosixFilePermissions(file.toPath(), perms);     // Catch: Exception -> L6
    L8:
        String[] r2 = mFileNames;     // Catch: Exception -> L6
        int r3 = r2.length;     // Catch: Exception -> L6
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L22;
        String fileName = r2[r4];     // Catch: Exception -> L6
        File file2 = new File(fileName);     // Catch: Exception -> L6
        if (file2.exists() == false) goto L13;
        Files.setPosixFilePermissions(file2.toPath(), perms);     // Catch: Exception -> L6
    L13:
        r4 = r4 + 1;
        goto L9
    L22:
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "set file permissions failed:" + e);
    }

    private void dumpToFile() {
        createDumpPathIfNecessary();
        if (new File(mFileNames[0]).length() >= 2097152) goto L5;
        saveEventsInFile(mFileNames[0]);
    L16:
        changeDumpFilesPermission();
        return;
    L5:
        int i = 4;
    L6:
        if (i < 0) goto L15;
        File file = new File(mFileNames[i]);
        if (file.length() == 0) goto L14;
        if (i != 4) goto L13;
        file.delete();
        goto L14
    L13:
        file.renameTo(new File(mFileNames[i + 1]));
    L14:
        i = i - 1;
        goto L6
    L15:
        saveEventsInFile(mFileNames[0]);
        goto L16
    }

    public synchronized void log(Event evt) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mEvents.size() < this.mMemSize) goto L8;
        dumpToFile();     // Catch: Throwable -> L6
        this.mEvents.clear();     // Catch: Throwable -> L6
    L8:
        this.mEvents.add(evt);     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public synchronized void dump(PrintWriter pw) {
        monitor-enter(this);
        pw.println("Audio event log: " + this.mTitle);     // Catch: Throwable -> L8
        Iterator<Event> r0 = this.mEvents.iterator();     // Catch: Throwable -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        Event evt = r0.next();     // Catch: Throwable -> L8
        pw.println(evt.toString());     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
