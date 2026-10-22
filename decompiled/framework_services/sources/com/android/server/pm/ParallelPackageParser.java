package com.android.server.pm;

import android.os.Trace;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.ConcurrentUtils;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
class ParallelPackageParser {
    private static final int MAX_THREADS = 4;
    private static final int QUEUE_CAPACITY = 30;
    private final ExecutorService mExecutorService;
    private volatile String mInterruptedInThread;
    private final PackageParser2 mPackageParser;
    private final BlockingQueue<ParseResult> mQueue;

    static class ParseResult {
        ParsedPackage parsedPackage;
        File scanFile;
        Throwable throwable;

        ParseResult() {
        }

        public String toString() {
            return "ParseResult{parsedPackage=" + this.parsedPackage + ", scanFile=" + this.scanFile + ", throwable=" + this.throwable + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$uW6lAW1ixaCdJ_8ZINGbyQGIceg(ParallelPackageParser r0, File r1, int r2) {
        r0.lambda$submit$0(r1, r2);
    }

    static ExecutorService makeExecutorService() {
        return ConcurrentUtils.newFixedThreadPool(4, "package-parsing-thread", -2);
    }

    ParallelPackageParser(PackageParser2 packageParser, ExecutorService executorService) {
        this.mQueue = new ArrayBlockingQueue(30);
        this.mPackageParser = packageParser;
        this.mExecutorService = executorService;
    }

    public ParseResult take() {
    L6:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new IllegalStateException(e);
    L3:
        if (this.mInterruptedInThread != null) goto L9;
        return this.mQueue.take();
    L9:
        throw new InterruptedException("Interrupted in " + this.mInterruptedInThread);     // Catch: InterruptedException -> L6
    }

    public void submit(final File scanFile, final int parseFlags) {
        this.mExecutorService.submit(new ParallelPackageParser$$ExternalSyntheticLambda0(this, scanFile, parseFlags));
    }

    private /* synthetic */ void lambda$submit$0(File scanFile, int parseFlags) {
        ParseResult pr = new ParseResult();
        Trace.traceBegin(262144, "parallel parsePackage [" + scanFile + "]");
        pr.scanFile = scanFile;     // Catch: Throwable -> L5
        pr.parsedPackage = parsePackage(scanFile, parseFlags);     // Catch: Throwable -> L5
    L4:
        Trace.traceEnd(262144);
        this.mQueue.put(pr);     // Catch: InterruptedException -> L10
        return;
    L11:
        Thread.currentThread().interrupt();
        this.mInterruptedInThread = Thread.currentThread().getName();
        return;
    L5:
        e = move-exception;
        pr.throwable = e;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    protected ParsedPackage parsePackage(File scanFile, int parseFlags) throws PackageManagerException {
        return this.mPackageParser.parsePackage(scanFile, parseFlags, true);
    L4:
        e = move-exception;
        throw new PackageManagerException(e.error, e.getMessage(), e);
    }
}
