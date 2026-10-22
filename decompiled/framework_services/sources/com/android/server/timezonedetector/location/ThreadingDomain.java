package com.android.server.timezonedetector.location;

import com.android.internal.util.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
abstract class ThreadingDomain {
    private final Object mLockObject;

    final class SingleRunnableQueue {
        private long mDelayMillis;
        private boolean mIsQueued;
        final /* synthetic */ ThreadingDomain this$0;

        public static /* synthetic */ void $r8$lambda$yYI8FF6bFkcGsCu9bT9cgfmBorc(SingleRunnableQueue r0, Runnable r1) {
            r0.lambda$runDelayed$0(r1);
        }

        SingleRunnableQueue(ThreadingDomain this$0) {
            this.this$0 = this$0;
        }

        void runDelayed(final Runnable r, long delayMillis) {
            cancel();
            this.mIsQueued = true;
            this.mDelayMillis = delayMillis;
            this.this$0.postDelayed(new ThreadingDomain$SingleRunnableQueue$$ExternalSyntheticLambda0(this, r), this, delayMillis);
        }

        private /* synthetic */ void lambda$runDelayed$0(Runnable r) {
            this.mIsQueued = false;
            this.mDelayMillis = -2;
            r.run();
        }

        boolean hasQueued() {
            this.this$0.assertCurrentThread();
            return this.mIsQueued;
        }

        long getQueuedDelayMillis() {
            this.this$0.assertCurrentThread();
            if (this.mIsQueued == false) goto L7;
            return this.mDelayMillis;
        L7:
            throw new IllegalStateException("No item queued");
        }

        public void cancel() {
            this.this$0.assertCurrentThread();
            if (this.mIsQueued == false) goto L5;
            this.this$0.removeQueuedRunnables(this);
        L5:
            this.mIsQueued = false;
            this.mDelayMillis = -1;
        }
    }

    public static /* synthetic */ Object $r8$lambda$AAnkoh1zkrCPmFzSIJ5ZhoMMZ6A(Runnable r0) {
        return lambda$postAndWait$0(r0);
    }

    abstract Thread getThread();

    abstract void post(Runnable r1);

    abstract <V> V postAndWait(Callable<V> r1, long r2) throws Exception;

    abstract void postDelayed(Runnable r1, long r2);

    abstract void postDelayed(Runnable r1, Object r2, long r3);

    abstract void removeQueuedRunnables(Object r1);

    ThreadingDomain() {
        this.mLockObject = new Object();
    }

    Object getLockObject() {
        return this.mLockObject;
    }

    void assertCurrentThread() {
        if (Thread.currentThread() != getThread()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    void assertNotCurrentThread() {
        if (Thread.currentThread() == getThread()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    final void postAndWait(final Runnable runnable, long durationMillis) {
        postAndWait(new ThreadingDomain$$ExternalSyntheticLambda0(runnable), durationMillis);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static /* synthetic */ Object lambda$postAndWait$0(Runnable runnable) throws Exception {
        runnable.run();
        return null;
    }

    SingleRunnableQueue createSingleRunnableQueue() {
        return new SingleRunnableQueue(this);
    }
}
