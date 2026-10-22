package androidx.sqlite.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/sqlite/util/ProcessLock;", "", "", HintConstants.AUTOFILL_HINT_NAME, "Ljava/io/File;", "lockDir", "", "processLock", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/io/File;Z)V", "LC7/r;", "lock", "(Z)V", "unlock", "()V", "Z", "lockFile", "Ljava/io/File;", "Ljava/util/concurrent/locks/Lock;", "threadLock", "Ljava/util/concurrent/locks/Lock;", "Ljava/nio/channels/FileChannel;", "lockChannel", "Ljava/nio/channels/FileChannel;", "Companion", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class ProcessLock {
    private static final String TAG = "SupportSQLiteLock";
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    private final Lock threadLock;
    private static final Companion Companion = new Companion(null);
    private static final Map<String, Lock> threadLocksMap = new HashMap();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/sqlite/util/ProcessLock$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "threadLocksMap", "", "Ljava/util/concurrent/locks/Lock;", "getThreadLock", "key", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock getThreadLock(String key) {
            Lock lock;
            synchronized (ProcessLock.threadLocksMap) {
                try {
                    Map map = ProcessLock.threadLocksMap;
                    Object reentrantLock = map.get(key);
                    if (reentrantLock == null) {
                        reentrantLock = new ReentrantLock();
                        map.put(key, reentrantLock);
                    }
                    lock = (Lock) reentrantLock;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private Companion() {
        }
    }

    public ProcessLock(String name, File file, boolean z10) {
        k.f(name, "name");
        this.processLock = z10;
        this.lockFile = file != null ? new File(file, name.concat(".lck")) : null;
        this.threadLock = Companion.getThreadLock(name);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock, boolean z10, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z10 = processLock.processLock;
        }
        processLock.lock(z10);
    }

    public final void lock(boolean processLock) throws IOException {
        this.threadLock.lock();
        if (processLock) {
            try {
                File file = this.lockFile;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.lockFile).getChannel();
                channel.lock();
                this.lockChannel = channel;
            } catch (IOException e) {
                this.lockChannel = null;
                Log.w(TAG, "Unable to grab file lock.", e);
            }
        }
    }

    public final void unlock() throws IOException {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
