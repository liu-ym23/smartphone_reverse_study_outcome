package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes6.dex */
public final class ExecutorCompat {

    /* JADX INFO: loaded from: classes17.dex */
    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        public HandlerExecutor(Handler r100) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r100);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r100)) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    public static Executor create(Handler r100) {
        return new HandlerExecutor(r100);
    }
}
