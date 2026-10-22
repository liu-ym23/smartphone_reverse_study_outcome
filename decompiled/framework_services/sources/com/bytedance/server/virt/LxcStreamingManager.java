package com.bytedance.server.virt;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.os.LxcClient;
import com.bytedance.virt.LxcCommandResult;
import com.bytedance.virt.LxcStreamingSession;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class LxcStreamingManager {
    private static final int MAX_ERROR_SUMMARY_CHARS = 1024;
    private static final long SESSION_RETENTION_MILLIS = 0;
    private static final String TAG = "LxcStreamingManager";
    private final ScheduledExecutorService mCleanupExecutor;
    private final ConcurrentHashMap<String, SessionRecord> mSessions;

    private static final class PipeOutputListener implements LxcClient.OutputListener {
        private final SessionRecord mRecord;
        private final OutputStream mStderrOut;
        private final OutputStream mStdoutOut;

        PipeOutputListener(SessionRecord record, OutputStream stdoutOut, OutputStream stderrOut) {
            this.mRecord = record;
            this.mStdoutOut = stdoutOut;
            this.mStderrOut = stderrOut;
        }

        public void onStdout(String chunk) {
            LxcStreamingManager.m10564$$Nest$smwriteChunk(this.mStdoutOut, this.mRecord.stdoutClosed, chunk);
        }

        public void onStderr(String chunk) {
            LxcStreamingManager.m10564$$Nest$smwriteChunk(this.mStderrOut, this.mRecord.stderrClosed, chunk);
        }
    }

    private static final class SessionRecord {
        final AtomicBoolean cleanedUp;
        volatile ScheduledFuture<?> cleanupFuture;
        final IBinder clientToken;
        final String containerName;
        volatile IBinder.DeathRecipient deathRecipient;
        final CountDownLatch done;
        final ParcelFileDescriptor gatewayFd;
        volatile LxcCommandResult result;
        final String sessionId;
        final AtomicBoolean stderrClosed;
        final ParcelFileDescriptor stderrWrite;
        final AtomicBoolean stdoutClosed;
        final ParcelFileDescriptor stdoutWrite;
        volatile Thread worker;

        SessionRecord(String sessionId, String containerName, IBinder clientToken, ParcelFileDescriptor stdoutWrite, ParcelFileDescriptor stderrWrite, ParcelFileDescriptor gatewayFd) {
            this.done = new CountDownLatch(1);
            this.cleanedUp = new AtomicBoolean(false);
            this.stdoutClosed = new AtomicBoolean(false);
            this.stderrClosed = new AtomicBoolean(false);
            this.sessionId = sessionId;
            this.containerName = containerName;
            this.clientToken = clientToken;
            this.stdoutWrite = stdoutWrite;
            this.stderrWrite = stderrWrite;
            this.gatewayFd = gatewayFd;
        }
    }

    public static /* synthetic */ void $r8$lambda$AdSo4UVLqkwXdyoXZzpnd6PZHzM(LxcStreamingManager r0, SessionRecord r1) {
        r0.lambda$linkClientDeath$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$AeuNkSCGMvF0CKl1yB3M57T_a_c(LxcStreamingManager r0, SessionRecord r1) {
        r0.lambda$scheduleSessionCleanup$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HTWIY3CvSTfVo-o9CGbfUe_fMhk, reason: not valid java name */
    public static /* synthetic */ void m10563$r8$lambda$HTWIY3CvSTfVoo9CGbfUe_fMhk(LxcStreamingManager r0, SessionRecord r1, String[] r2, int r3, int r4, int r5, String[] r6) {
        r0.lambda$startExecute$1(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Thread $r8$lambda$WjdbBbw4waLyNvWzOso96JSWA2I(Runnable r0) {
        return lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smwriteChunk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10564$$Nest$smwriteChunk(OutputStream r0, AtomicBoolean r1, String r2) {
        writeChunk(r0, r1, r2);
    }

    LxcStreamingManager() {
        this.mSessions = new ConcurrentHashMap();
        this.mCleanupExecutor = Executors.newSingleThreadScheduledExecutor(new LxcStreamingManager$$ExternalSyntheticLambda0());
    }

    static {
        SESSION_RETENTION_MILLIS = TimeUnit.MINUTES.toMillis(5);
    }

    private static /* synthetic */ Thread lambda$new$0(Runnable r) {
        Thread thread = new Thread(r, "LxcStreamCleanup");
        thread.setDaemon(true);
        return thread;
    }

    LxcStreamingSession startExecute(String containerName, final String[] args, final int timeoutSeconds, IBinder clientToken, final int privileged, final int callingUid, final String[] env) throws IOException {
        ParcelFileDescriptor[] stdoutPipe = null;
        ParcelFileDescriptor[] stderrPipe = null;
        ParcelFileDescriptor[] proxySocketPair = null;
        ParcelFileDescriptor stdoutClientRead = null;
        ParcelFileDescriptor stderrClientRead = null;
        ParcelFileDescriptor proxyClientFd = null;
        ParcelFileDescriptor[] stdoutPipe2 = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L33
        ParcelFileDescriptor[] stderrPipe2 = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L31
        ParcelFileDescriptor[] proxySocketPair2 = ParcelFileDescriptor.createSocketPair();     // Catch: Throwable -> L29
        String sessionId = UUID.randomUUID().toString();     // Catch: Throwable -> L27
        final SessionRecord record = new SessionRecord(sessionId, containerName, clientToken, stdoutPipe2[1], stderrPipe2[1], proxySocketPair2[1]);     // Catch: Throwable -> L27
        this.mSessions.put(sessionId, record);     // Catch: Throwable -> L27
        linkClientDeath(record);     // Catch: Throwable -> L27
        ParcelFileDescriptor stdoutClientRead2 = ParcelFileDescriptor.dup(stdoutPipe2[0].getFileDescriptor());     // Catch: Throwable -> L27
        stderrClientRead = ParcelFileDescriptor.dup(stderrPipe2[0].getFileDescriptor());     // Catch: Throwable -> L25
        proxyClientFd = ParcelFileDescriptor.dup(proxySocketPair2[0].getFileDescriptor());     // Catch: Throwable -> L23
        closeQuietly(stdoutPipe2[0]);     // Catch: Throwable -> L21
        closeQuietly(stderrPipe2[0]);     // Catch: Throwable -> L21
        closeQuietly(proxySocketPair2[0]);     // Catch: Throwable -> L21
        stdoutPipe2[0] = null;     // Catch: Throwable -> L21
        stderrPipe2[0] = null;     // Catch: Throwable -> L21
        proxySocketPair2[0] = null;     // Catch: Throwable -> L21
        Thread worker = new Thread(new LxcStreamingManager$$ExternalSyntheticLambda3(this, record, args, timeoutSeconds, privileged, callingUid, env), "LxcStream-" + sessionId);     // Catch: Throwable -> L19
        record.worker = worker;     // Catch: Throwable -> L19
        worker.start();     // Catch: Throwable -> L19
        return new LxcStreamingSession(sessionId, stdoutClientRead2, stderrClientRead, proxyClientFd);
    L19:
        e = e;
        stderrClientRead = stderrClientRead;
        proxyClientFd = proxyClientFd;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
        proxySocketPair = proxySocketPair2;
        stdoutClientRead = stdoutClientRead2;
    L35:
        closeQuietly(stdoutClientRead);
        closeQuietly(stderrClientRead);
        closeQuietly(proxyClientFd);
        if (stdoutPipe == null) goto L38;
        ParcelFileDescriptor r1 = stdoutPipe[0];
    L39:
        closeQuietly(r1);
        if (stdoutPipe == null) goto L42;
        ParcelFileDescriptor r2 = stdoutPipe[1];
    L43:
        closeQuietly(r2);
        if (stderrPipe == null) goto L46;
        ParcelFileDescriptor r3 = stderrPipe[r10];
    L47:
        closeQuietly(r3);
        if (stderrPipe == null) goto L50;
        ParcelFileDescriptor r4 = stderrPipe[r8];
    L51:
        closeQuietly(r4);
        if (proxySocketPair == null) goto L54;
        ParcelFileDescriptor r5 = proxySocketPair[r10];
    L55:
        closeQuietly(r5);
        if (proxySocketPair == null) goto L58;
        ParcelFileDescriptor r9 = proxySocketPair[r8];
    L59:
        closeQuietly(r9);
        throw e;
    L58:
        r9 = null;
        goto L59
    L54:
        r5 = null;
        goto L55
    L50:
        r4 = null;
        goto L51
    L46:
        r3 = null;
        goto L47
    L42:
        r2 = null;
        goto L43
    L38:
        r1 = null;
    L21:
        e = e;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
        proxySocketPair = proxySocketPair2;
        stdoutClientRead = stdoutClientRead2;
    L23:
        e = e;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
        proxySocketPair = proxySocketPair2;
        stdoutClientRead = stdoutClientRead2;
    L25:
        e = e;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
        proxySocketPair = proxySocketPair2;
        stdoutClientRead = stdoutClientRead2;
    L27:
        e = e;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
        proxySocketPair = proxySocketPair2;
    L29:
        e = e;
        stdoutPipe = stdoutPipe2;
        stderrPipe = stderrPipe2;
    L31:
        e = e;
        stdoutPipe = stdoutPipe2;
    L33:
        e = e;
        goto L35
    }

    private /* synthetic */ void lambda$startExecute$1(SessionRecord record, String[] args, int timeoutSeconds, int privileged, int callingUid, String[] env) {
        runExecute(record, args, timeoutSeconds, privileged, callingUid, env);
    }

    LxcCommandResult waitForResult(String sessionId) {
        SessionRecord record = this.mSessions.get(sessionId);
        if (record != null) goto L27;
        return new LxcCommandResult(-1, "", "Streaming session not found: " + sessionId);
    L27:
        record.done.await();     // Catch: Throwable -> L17 InterruptedException -> L19
        goto L20
    L9:
        if (1 == 0) goto L12;
        cleanupSession(record, false, "waitForResult finished");
    L12:
        if (record.result != null) goto L16;
        return new LxcCommandResult(-1, "", "No result returned");
    L16:
        return record.result;
    L17:
        th = move-exception;
        if (0 == 0) goto L26;
        cleanupSession(record, false, "waitForResult finished");
    L26:
        throw th;
    L20:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L17
        LxcCommandResult r7 = new LxcCommandResult(-1, "", "Interrupted while waiting for session result");     // Catch: Throwable -> L17
        if (0 == 0) goto L23;
        cleanupSession(record, false, "waitForResult finished");
    L23:
        return r7;
    }

    private void runExecute(SessionRecord record, String[] args, int timeoutSeconds, int privileged, int callingUid, String[] env) {
        OutputStream stdoutOut = new ParcelFileDescriptor.AutoCloseOutputStream(record.stdoutWrite);
        OutputStream stderrOut = new ParcelFileDescriptor.AutoCloseOutputStream(record.stderrWrite);
        LxcClient.LxcCommandResult result = LxcClient.sendLxcCommandStreaming("execute", record.containerName, args, timeoutSeconds, privileged, callingUid, env, new PipeOutputListener(record, stdoutOut, stderrOut), record.gatewayFd);     // Catch: Throwable -> L6 Exception -> L8
        if (result != null) goto L10;
        record.result = new LxcCommandResult(-1, "", "Streaming result is null");     // Catch: Throwable -> L6 Exception -> L8
    L18:
    L11:
        closeQuietly(stdoutOut);
        closeQuietly(stderrOut);
        record.done.countDown();
        scheduleSessionCleanup(record);
        return;
    L10:
        record.result = new LxcCommandResult(result.exitCode, "", summarize(result.stderr));     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "Streaming execution failed for session=" + record.sessionId, e);     // Catch: Throwable -> L6
        record.result = new LxcCommandResult(-1, "", summarize(e.toString()));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        closeQuietly(stdoutOut);
        closeQuietly(stderrOut);
        record.done.countDown();
        scheduleSessionCleanup(record);
        throw th;
    }

    private void linkClientDeath(final SessionRecord record) throws IOException {
        if (record.clientToken != null) goto L5;
        return;
    L5:
        record.deathRecipient = new LxcStreamingManager$$ExternalSyntheticLambda1(this, record);
        record.clientToken.linkToDeath(record.deathRecipient, 0);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to link death for session=" + record.sessionId, e);
        setSessionFailureIfAbsent(record, "Failed to observe client death");
        cleanupSession(record, true, "linkToDeath failed");
        throw new IOException("Client died before streaming session started", e);
    }

    private /* synthetic */ void lambda$linkClientDeath$2(SessionRecord record) {
        Log.w(TAG, "Client died, killing container for session=" + record.sessionId);
        setSessionFailureIfAbsent(record, "Client died before collecting streaming result");
        killContainer(record.containerName);
        cleanupSession(record, true, "client died");
    }

    private void unlinkClientDeath(SessionRecord record) {
        if (record.clientToken != null) goto L5;
        return;
    L5:
        if (record.deathRecipient == null) goto L16;
        record.clientToken.unlinkToDeath(record.deathRecipient, 0);     // Catch: NoSuchElementException -> L9
    L11:
        record.deathRecipient = null;
        return;
    L9:
        e = move-exception;
        Log.w(TAG, "Death recipient already unlinked for session=" + record.sessionId, e);
        goto L11
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private void killContainer(String containerName) {
        LxcClient.sendLxcCommand("kill", containerName, null, 0, 0, 1000);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to kill container " + containerName, e);
    }

    private void scheduleSessionCleanup(final SessionRecord record) {
        if (record.cleanedUp.get() == false) goto L5;
        return;
    L5:
        ScheduledFuture<?> previous = record.cleanupFuture;
        if (previous == null) goto L8;
        previous.cancel(false);
    L8:
        record.cleanupFuture = this.mCleanupExecutor.schedule(new LxcStreamingManager$$ExternalSyntheticLambda2(this, record), SESSION_RETENTION_MILLIS, TimeUnit.MILLISECONDS);
    }

    private /* synthetic */ void lambda$scheduleSessionCleanup$3(SessionRecord record) {
        cleanupSession(record, false, "result retention expired");
    }

    private void cleanupSession(SessionRecord record, boolean interruptWorker, String reason) {
        if (record.cleanedUp.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mSessions.remove(record.sessionId, record);
        ScheduledFuture<?> cleanupFuture = record.cleanupFuture;
        if (cleanupFuture == null) goto L8;
        cleanupFuture.cancel(false);
        record.cleanupFuture = null;
    L8:
        unlinkClientDeath(record);
        closeQuietly(record.stdoutWrite);
        closeQuietly(record.stderrWrite);
        closeQuietly(record.gatewayFd);
        if (interruptWorker == false) goto L15;
        Thread worker = record.worker;
        if (worker == null) goto L15;
        if (worker.isAlive() == false) goto L15;
        worker.interrupt();
    L15:
        Log.i(TAG, "Cleaned streaming session=" + record.sessionId + ", reason=" + reason);
    }

    private static void setSessionFailureIfAbsent(SessionRecord record, String message) {
        if (record.result != null) goto L5;
        record.result = new LxcCommandResult(-1, "", message);
    L5:
        record.done.countDown();
    }

    private static void writeChunk(OutputStream outputStream, AtomicBoolean closed, String chunk) {
        if (outputStream == null) goto L17;
        if (chunk != null) goto L5;
        return;
    L5:
        if (chunk.isEmpty() == false) goto L8;
        return;
    L8:
        if (closed.get() == false) goto L18;
        return;
    L18:
        outputStream.write(chunk.getBytes(StandardCharsets.UTF_8));     // Catch: IOException -> L12
        outputStream.flush();     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        if (closed.compareAndSet(false, true) == false) goto L20;
        Log.w(TAG, "Stopping streaming pipe after write failure", e);
        closeQuietly(outputStream);
        return;
    L20:
        return;
    }

    private static String summarize(String text) {
        if (text != null) goto L4;
        return "";
    L4:
        if (text.isEmpty() == false) goto L7;
        return "";
    L7:
        if (text.length() > 1024) goto L10;
        return text;
    L10:
        return text.substring(0, 1024) + "\n... (truncated)";
    }

    private static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) goto L9;
        return;
    L9:
        closeable.close();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to close resource", e);
    }
}
