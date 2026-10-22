package androidx.sqlite.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/sqlite/util/ProcessLock;", "", "name", "", "lockDir", "Ljava/io/File;", "processLock", "", "(Ljava/lang/String;Ljava/io/File;Z)V", "lockChannel", "Ljava/nio/channels/FileChannel;", "lockFile", "threadLock", "Ljava/util/concurrent/locks/Lock;", "lock", "", "unlock", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLock {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLiteLock";
    private static final Map<String, Lock> threadLocksMap = null;
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    private final Lock threadLock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/util/ProcessLock$Companion;", "", "()V", "TAG", "", "threadLocksMap", "", "Ljava/util/concurrent/locks/Lock;", "getThreadLock", "key", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final Lock getThreadLock(String r100) {
            Map r101 = ProcessLock.access$getThreadLocksMap$cp();
            monitor-enter(r101);
            Map r102 = ProcessLock.access$getThreadLocksMap$cp();     // Catch: Throwable -> L10
            Object r103 = r102.get(r100);     // Catch: Throwable -> L10
            if (r103 != null) goto L7;
            r103 = new ReentrantLock();     // Catch: Throwable -> L10
            r102.put(r100, r103);     // Catch: Throwable -> L10
        L7:
            Lock r104 = (Lock) r103;     // Catch: Throwable -> L10
            monitor-exit(r101);
            return r104;
        L10:
            th = move-exception;
            throw th;
        }

        public static final /* synthetic */ Lock access$getThreadLock(Companion r100, String r101) {
            return r100.getThreadLock(r101);
        }
    }

    static {
        Companion = new Companion(null);
        threadLocksMap = new HashMap();
    }

    public final void unlock() {
        FileChannel r100 = this.lockChannel;     // Catch: IOException -> L7
        if (r100 == null) goto L5;
        r100.close();     // Catch: IOException -> L7
    L5:
        this.threadLock.unlock();
    }

    public static final /* synthetic */ Map access$getThreadLocksMap$cp() {
        return threadLocksMap;
    }

    public final void lock(boolean r100) {
        this.threadLock.lock();
        if (r100 == false) goto L15;
        File r101 = this.lockFile;     // Catch: IOException -> L12
        if (r101 == null) goto L11;
        File r102 = r101.getParentFile();     // Catch: IOException -> L12
        if (r102 == null) goto L9;
        r102.mkdirs();     // Catch: IOException -> L12
    L9:
        FileChannel r103 = new FileOutputStream(this.lockFile).getChannel();     // Catch: IOException -> L12
        r103.lock();     // Catch: IOException -> L12
        this.lockChannel = r103;     // Catch: IOException -> L12
        return;
    L11:
        throw new IOException("No lock directory was provided.");     // Catch: IOException -> L12
    L12:
        this.lockChannel = null;
        return;
    }

    public ProcessLock(String r100, File r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.processLock = r102;
        if (r101 == null) goto L5;
        File r103 = new File(r101, r100 + ".lck");
    L6:
        this.lockFile = r103;
        this.threadLock = Companion.access$getThreadLock(Companion, r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static /* synthetic */ void lock$default(ProcessLock r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100.processLock;
    L5:
        r100.lock(r101);
    }
}
