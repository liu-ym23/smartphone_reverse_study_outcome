package com.android.server.criticalevents;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Slog;
import com.android.framework.protobuf.nano.MessageNanoPrinter;
import com.android.internal.util.RingBuffer;
import com.android.server.criticalevents.nano.CriticalEventLogProto;
import com.android.server.criticalevents.nano.CriticalEventLogStorageProto;
import com.android.server.criticalevents.nano.CriticalEventProto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CriticalEventLog {
    private static final int AID_SYSTEM = 1000;
    static final String FILENAME = "critical_event_log.pb";
    private static final String TAG = null;
    private static CriticalEventLog sInstance;
    private final ThreadSafeRingBuffer<CriticalEventProto> mEvents;
    private final Handler mHandler;
    private long mLastSaveAttemptMs;
    private final boolean mLoadAndSaveImmediately;
    private final File mLogFile;
    private final long mMinTimeBetweenSavesMs;
    private final Runnable mSaveRunnable;
    private final int mWindowMs;

    protected interface ILogLoader {
        void load(File r1, ThreadSafeRingBuffer<CriticalEventProto> r2);
    }

    static class LogLoader implements ILogLoader {
        LogLoader() {
        }

        @Override // com.android.server.criticalevents.CriticalEventLog.ILogLoader
        public void load(File logFile, ThreadSafeRingBuffer<CriticalEventProto> buffer) {
            CriticalEventProto[] r0 = loadLogFromFile(logFile).events;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            CriticalEventProto event = r0[r2];
            buffer.append(event);
            r2 = r2 + 1;
            goto L3
        }

        private static CriticalEventLogStorageProto loadLogFromFile(File logFile) {
            if (logFile.exists() == true) goto L12;
            Slog.i(CriticalEventLog.m3317$$Nest$sfgetTAG(), "No log found, returning empty log proto.");
            return new CriticalEventLogStorageProto();
        L12:
            return CriticalEventLogStorageProto.parseFrom(Files.readAllBytes(logFile.toPath()));
        L9:
            e = move-exception;
            Slog.e(CriticalEventLog.m3317$$Nest$sfgetTAG(), "Error reading log from disk.", e);
            return new CriticalEventLogStorageProto();
        }
    }

    private static class LogSanitizer {
        int mTraceProcessClassEnum;
        String mTraceProcessName;
        int mTraceUid;

        LogSanitizer(int traceProcessClassEnum, String traceProcessName, int traceUid) {
            this.mTraceProcessClassEnum = traceProcessClassEnum;
            this.mTraceProcessName = traceProcessName;
            this.mTraceUid = traceUid;
        }

        CriticalEventProto process(CriticalEventProto event) {
            if (event.hasAnr() == false) goto L10;
            CriticalEventProto.AppNotResponding anr = event.getAnr();
            if (shouldSanitize(anr.processClass, anr.process, anr.uid) == true) goto L7;
        L23:
            return event;
        L7:
            return sanitizeAnr(event);
        L10:
            if (event.hasJavaCrash() == false) goto L18;
            CriticalEventProto.JavaCrash crash = event.getJavaCrash();
            if (shouldSanitize(crash.processClass, crash.process, crash.uid) == false) goto L23;
            return sanitizeJavaCrash(event);
        L18:
            if (event.hasNativeCrash() == false) goto L23;
            CriticalEventProto.NativeCrash crash2 = event.getNativeCrash();
            if (shouldSanitize(crash2.processClass, crash2.process, crash2.uid) == false) goto L23;
            return sanitizeNativeCrash(event);
        }

        private boolean shouldSanitize(int processClassEnum, String processName, int uid) {
            if (processName != null) goto L5;
        L9:
            boolean sameApp = false;
        L10:
            if (processClassEnum == 1) goto L12;
            return false;
        L12:
            if (this.mTraceProcessClassEnum != 1) goto L17;
            if (sameApp == false) goto L15;
            return false;
        L15:
            return true;
        L17:
            return false;
        L5:
            if (processName.equals(this.mTraceProcessName) == false) goto L9;
            if (this.mTraceUid != uid) goto L9;
            sameApp = true;
            goto L10
        }

        private static CriticalEventProto sanitizeAnr(CriticalEventProto base) {
            CriticalEventProto.AppNotResponding anr = new CriticalEventProto.AppNotResponding();
            anr.processClass = base.getAnr().processClass;
            anr.uid = base.getAnr().uid;
            anr.pid = base.getAnr().pid;
            CriticalEventProto sanitized = sanitizeCriticalEventProto(base);
            sanitized.setAnr(anr);
            return sanitized;
        }

        private static CriticalEventProto sanitizeJavaCrash(CriticalEventProto base) {
            CriticalEventProto.JavaCrash crash = new CriticalEventProto.JavaCrash();
            crash.processClass = base.getJavaCrash().processClass;
            crash.uid = base.getJavaCrash().uid;
            crash.pid = base.getJavaCrash().pid;
            CriticalEventProto sanitized = sanitizeCriticalEventProto(base);
            sanitized.setJavaCrash(crash);
            return sanitized;
        }

        private static CriticalEventProto sanitizeNativeCrash(CriticalEventProto base) {
            CriticalEventProto.NativeCrash crash = new CriticalEventProto.NativeCrash();
            crash.processClass = base.getNativeCrash().processClass;
            crash.uid = base.getNativeCrash().uid;
            crash.pid = base.getNativeCrash().pid;
            CriticalEventProto sanitized = sanitizeCriticalEventProto(base);
            sanitized.setNativeCrash(crash);
            return sanitized;
        }

        private static CriticalEventProto sanitizeCriticalEventProto(CriticalEventProto base) {
            CriticalEventProto sanitized = new CriticalEventProto();
            sanitized.timestampMs = base.timestampMs;
            return sanitized;
        }
    }

    protected static class ThreadSafeRingBuffer<T> {
        private final RingBuffer<T> mBuffer;
        private final int mCapacity;

        ThreadSafeRingBuffer(Class<T> clazz, int capacity) {
            this.mCapacity = capacity;
            this.mBuffer = new RingBuffer(clazz, capacity);
        }

        synchronized void append(T t) {
            monitor-enter(this);
            this.mBuffer.append(t);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized T[] toArray() {
            monitor-enter(this);
            T[] r0 = (T[]) this.mBuffer.toArray();
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        int capacity() {
            return this.mCapacity;
        }
    }

    public static /* synthetic */ void $r8$lambda$lY5bRq3e1qTEzCvfI4SPBg_RsKI(CriticalEventLog r0, ILogLoader r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3317$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = CriticalEventLog.class.getSimpleName();
    }

    CriticalEventLog(String logDir, int capacity, int windowMs, long minTimeBetweenSavesMs, boolean loadAndSaveImmediately, final ILogLoader logLoader) {
        this.mLastSaveAttemptMs = 0;
        this.mSaveRunnable = new CriticalEventLog$$ExternalSyntheticLambda0(this);
        this.mLogFile = Paths.get(logDir, new String[]{FILENAME}).toFile();
        this.mWindowMs = windowMs;
        this.mMinTimeBetweenSavesMs = minTimeBetweenSavesMs;
        this.mLoadAndSaveImmediately = loadAndSaveImmediately;
        this.mEvents = new ThreadSafeRingBuffer(CriticalEventProto.class, capacity);
        HandlerThread thread = new HandlerThread("CriticalEventLogIO");
        thread.start();
        this.mHandler = new Handler(thread.getLooper());
        Runnable loadEvents = new CriticalEventLog$$ExternalSyntheticLambda1(this, logLoader);
        if (this.mLoadAndSaveImmediately == true) goto L5;
        this.mHandler.post(loadEvents);
        return;
    L5:
        loadEvents.run();
    }

    private /* synthetic */ void lambda$new$0(ILogLoader logLoader) {
        logLoader.load(this.mLogFile, this.mEvents);
    }

    private CriticalEventLog() {
        this("/data/misc/critical-events", 20, (int) Duration.ofMinutes(5).toMillis(), Duration.ofSeconds(2).toMillis(), false, new LogLoader());
    }

    public static CriticalEventLog getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new CriticalEventLog();
    L6:
        return sInstance;
    }

    public static void init() {
        getInstance();
    }

    protected long getWallTimeMillis() {
        return System.currentTimeMillis();
    }

    public void logExcessiveBinderCalls(int uid) {
        CriticalEventProto event = new CriticalEventProto();
        CriticalEventProto.ExcessiveBinderCalls calls = new CriticalEventProto.ExcessiveBinderCalls();
        calls.uid = uid;
        event.setExcessiveBinderCalls(calls);
        log(event);
    }

    public void logInstallPackagesStarted() {
        CriticalEventProto event = new CriticalEventProto();
        event.setInstallPackages(new CriticalEventProto.InstallPackages());
        log(event);
    }

    public void logSystemServerStarted() {
        CriticalEventProto event = new CriticalEventProto();
        event.setSystemServerStarted(new CriticalEventProto.SystemServerStarted());
        log(event);
    }

    public void logWatchdog(String subject, UUID uuid) {
        CriticalEventProto.Watchdog watchdog = new CriticalEventProto.Watchdog();
        watchdog.subject = subject;
        watchdog.uuid = uuid.toString();
        CriticalEventProto event = new CriticalEventProto();
        event.setWatchdog(watchdog);
        log(event);
    }

    public void logHalfWatchdog(String subject) {
        CriticalEventProto.HalfWatchdog halfWatchdog = new CriticalEventProto.HalfWatchdog();
        halfWatchdog.subject = subject;
        CriticalEventProto event = new CriticalEventProto();
        event.setHalfWatchdog(halfWatchdog);
        log(event);
    }

    public void logAnr(String subject, int processClassEnum, String processName, int uid, int pid) {
        CriticalEventProto.AppNotResponding anr = new CriticalEventProto.AppNotResponding();
        anr.subject = subject;
        anr.processClass = processClassEnum;
        anr.process = processName;
        anr.uid = uid;
        anr.pid = pid;
        CriticalEventProto event = new CriticalEventProto();
        event.setAnr(anr);
        log(event);
    }

    public void logJavaCrash(String exceptionClass, int processClassEnum, String processName, int uid, int pid) {
        CriticalEventProto.JavaCrash crash = new CriticalEventProto.JavaCrash();
        crash.exceptionClass = exceptionClass;
        crash.processClass = processClassEnum;
        crash.process = processName;
        crash.uid = uid;
        crash.pid = pid;
        CriticalEventProto event = new CriticalEventProto();
        event.setJavaCrash(crash);
        log(event);
    }

    public void logNativeCrash(int processClassEnum, String processName, int uid, int pid) {
        CriticalEventProto.NativeCrash crash = new CriticalEventProto.NativeCrash();
        crash.processClass = processClassEnum;
        crash.process = processName;
        crash.uid = uid;
        crash.pid = pid;
        CriticalEventProto event = new CriticalEventProto();
        event.setNativeCrash(crash);
        log(event);
    }

    private void log(CriticalEventProto event) {
        event.timestampMs = getWallTimeMillis();
        appendAndSave(event);
    }

    void appendAndSave(CriticalEventProto event) {
        this.mEvents.append(event);
        saveLogToFile();
    }

    public String logLinesForSystemServerTraceFile() {
        return logLinesForTraceFile(3, "AID_SYSTEM", 1000);
    }

    public String logLinesForTraceFile(int traceProcessClassEnum, String traceProcessName, int traceUid) {
        CriticalEventLogProto outputLogProto = getOutputLogProto(traceProcessClassEnum, traceProcessName, traceUid);
        return "--- CriticalEventLog ---\n" + MessageNanoPrinter.print(outputLogProto) + '\n';
    }

    protected CriticalEventLogProto getOutputLogProto(int traceProcessClassEnum, String traceProcessName, int traceUid) {
        CriticalEventLogProto log = new CriticalEventLogProto();
        log.timestampMs = getWallTimeMillis();
        log.windowMs = this.mWindowMs;
        log.capacity = this.mEvents.capacity();
        CriticalEventProto[] events = recentEventsWithMinTimestamp(log.timestampMs - ((long) this.mWindowMs));
        LogSanitizer sanitizer = new LogSanitizer(traceProcessClassEnum, traceProcessName, traceUid);
        int i = 0;
    L4:
        if (i >= events.length) goto L6;
        events[i] = sanitizer.process(events[i]);
        i = i + 1;
        goto L4
    L6:
        log.events = events;
        return log;
    }

    private CriticalEventProto[] recentEventsWithMinTimestamp(long minTimestampMs) {
        CriticalEventProto[] allEvents = this.mEvents.toArray();
        int i = 0;
    L4:
        if (i >= allEvents.length) goto L11;
        if (allEvents[i].timestampMs >= minTimestampMs) goto L8;
        i = i + 1;
        goto L4
    L8:
        return (CriticalEventProto[]) Arrays.copyOfRange(allEvents, i, allEvents.length);
    L11:
        return new CriticalEventProto[0];
    }

    private void saveLogToFile() {
        if (this.mLoadAndSaveImmediately == false) goto L7;
        saveLogToFileNow();
        return;
    L7:
        if (this.mHandler.hasCallbacks(this.mSaveRunnable) == false) goto L10;
        return;
    L10:
        if (this.mHandler.postDelayed(this.mSaveRunnable, saveDelayMs()) == true) goto L13;
        Slog.w(TAG, "Error scheduling save");
        return;
    }

    protected long saveDelayMs() {
        long nowMs = getWallTimeMillis();
        return Math.max(0, (this.mLastSaveAttemptMs + this.mMinTimeBetweenSavesMs) - nowMs);
    }

    protected void saveLogToFileNow() {
        this.mLastSaveAttemptMs = getWallTimeMillis();
        File logDir = this.mLogFile.getParentFile();
        if (logDir.exists() == true) goto L9;
        if (logDir.mkdir() == true) goto L9;
        Slog.e(TAG, "Error creating log directory: " + logDir.getPath());
        return;
    L9:
        if (this.mLogFile.exists() == false) goto L32;
    L15:
        CriticalEventLogStorageProto logProto = new CriticalEventLogStorageProto();
        logProto.events = this.mEvents.toArray();
        byte[] bytes = CriticalEventLogStorageProto.toByteArray(logProto);
        FileOutputStream stream = new FileOutputStream(this.mLogFile, false);     // Catch: IOException -> L20
        stream.write(bytes);     // Catch: Throwable -> L22
        stream.close();     // Catch: IOException -> L20
        return;
    L22:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: IOException -> L20
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Slog.e(TAG, "Error saving log to disk.", e);
        return;
    L32:
        this.mLogFile.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Error creating log file", e);
    }
}
