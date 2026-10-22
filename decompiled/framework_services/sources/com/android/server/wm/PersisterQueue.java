package com.android.server.wm;

import android.os.Process;
import android.os.SystemClock;
import android.util.Slog;
import java.util.ArrayList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class PersisterQueue {
    private static final boolean DEBUG = false;
    static final WriteQueueItem EMPTY_ITEM = null;
    private static final long FLUSH_QUEUE = -1;
    private static final long INTER_WRITE_DELAY_MS = 500;
    private static final int MAX_WRITE_QUEUE_LENGTH = 6;
    private static final long PRE_TASK_DELAY_MS = 3000;
    private static final String TAG = "PersisterQueue";
    private final long mInterWriteDelayMs;
    private final LazyTaskWriterThread mLazyTaskWriterThread;
    private final ArrayList<Listener> mListeners;
    private long mNextWriteTime;
    private final long mPreTaskDelayMs;
    private final ArrayList<WriteQueueItem> mWriteQueue;

    private class LazyTaskWriterThread extends Thread {
        final /* synthetic */ PersisterQueue this$0;

        /* synthetic */ LazyTaskWriterThread(PersisterQueue r1, String r2, PersisterQueueIA r3) {
            this(r1, r2);
        }

        private LazyTaskWriterThread(PersisterQueue r1, String name) {
            this.this$0 = r1;
            super(name);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
        L19:
            PersisterQueue r0 = this.this$0;     // Catch: InterruptedException -> L10
            monitor-enter(r0);     // Catch: InterruptedException -> L10
            boolean probablyDone = PersisterQueue.m10081$$Nest$fgetmWriteQueue(this.this$0).isEmpty();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            int i = PersisterQueue.m10080$$Nest$fgetmListeners(this.this$0).size() - 1;     // Catch: InterruptedException -> L10
        L8:
            if (i < 0) goto L12;
            ((Listener) PersisterQueue.m10080$$Nest$fgetmListeners(this.this$0).get(i)).onPreProcessItem(probablyDone);     // Catch: InterruptedException -> L10
            i = i - 1;     // Catch: InterruptedException -> L10
            goto L8
        L12:
            PersisterQueue.m10082$$Nest$mprocessNextItem(this.this$0);     // Catch: InterruptedException -> L10
            goto L19
        L14:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L10
        L17:
            Slog.e(PersisterQueue.TAG, "Persister thread is exiting. Should never happen in prod, butit's OK in tests.");
        }
    }

    interface Listener {
        void onPreProcessItem(boolean r1);
    }

    interface WriteQueueItem<T extends WriteQueueItem<T>> {
        void process();

        default void updateFrom(T item) {
        }

        default boolean matches(T item) {
            return false;
        }
    }

    public static /* synthetic */ void $r8$lambda$aGLsAUUZNbiBUDirsbqiXA8GNBQ() {
        lambda$static$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m10080$$Nest$fgetmListeners(PersisterQueue r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWriteQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m10081$$Nest$fgetmWriteQueue(PersisterQueue r0) {
        return r0.mWriteQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessNextItem, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10082$$Nest$mprocessNextItem(PersisterQueue r0) {
        r0.processNextItem();
    }

    static {
        EMPTY_ITEM = new PersisterQueue$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ void lambda$static$0() {
    }

    PersisterQueue() {
        this(500, 3000);
    }

    PersisterQueue(long interWriteDelayMs, long preTaskDelayMs) {
        this.mWriteQueue = new ArrayList();
        this.mListeners = new ArrayList();
        this.mNextWriteTime = 0;
        if (interWriteDelayMs < 0) goto L9;
        if (preTaskDelayMs < 0) goto L9;
        this.mInterWriteDelayMs = interWriteDelayMs;
        this.mPreTaskDelayMs = preTaskDelayMs;
        this.mLazyTaskWriterThread = new LazyTaskWriterThread(this, "LazyTaskWriterThread", null);
        return;
    L9:
        throw new IllegalArgumentException("Both inter-write delay and pre-task delay need tobe non-negative. inter-write delay: " + interWriteDelayMs + "ms pre-task delay: " + preTaskDelayMs);
    }

    boolean waitUntilWritingThreadIsWaiting(long timeoutMillis) {
        long timeoutTime = SystemClock.uptimeMillis() + timeoutMillis;
    L3:
        monitor-enter(this);
        Thread.State state = this.mLazyTaskWriterThread.getState();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (state == Thread.State.WAITING) goto L8;
        Thread.yield();
        if (SystemClock.uptimeMillis() < timeoutTime) goto L3;
        return false;
    L8:
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    synchronized void startPersisting() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mLazyTaskWriterThread.isAlive() == true) goto L9;
        this.mLazyTaskWriterThread.start();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    void stopPersisting() throws InterruptedException {
        if (this.mLazyTaskWriterThread.isAlive() == true) goto L5;
        return;
    L5:
        monitor-enter(this);
        this.mLazyTaskWriterThread.interrupt();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.mLazyTaskWriterThread.join();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    synchronized void addItem(WriteQueueItem item, boolean flush) {
        monitor-enter(this);
        this.mWriteQueue.add(item);     // Catch: Throwable -> L11
        if (flush == false) goto L6;
    L13:
        this.mNextWriteTime = -1;     // Catch: Throwable -> L11
    L14:
        notify();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.mWriteQueue.size() > 6) goto L13;
        if (this.mNextWriteTime != 0) goto L14;
        this.mNextWriteTime = SystemClock.uptimeMillis() + this.mPreTaskDelayMs;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    synchronized <T extends WriteQueueItem> T findLastItem(Predicate<T> predicate, Class<T> clazz) {
        monitor-enter(this);
        int i = this.mWriteQueue.size() - 1;     // Catch: Throwable -> L11
    L4:
        if (i < 0) goto L15;
        WriteQueueItem writeQueueItem = this.mWriteQueue.get(i);     // Catch: Throwable -> L11
        if (clazz.isInstance(writeQueueItem) == false) goto L13;
        T item = clazz.cast(writeQueueItem);     // Catch: Throwable -> L11
        if (predicate.test(item) == false) goto L13;
        monitor-exit(this);
        return item;
    L13:
        i = i - 1;
        goto L4
    L15:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized <T extends WriteQueueItem> void updateLastOrAddItem(final T item, boolean flush) {
        monitor-enter(this);
        item.getClass();     // Catch: Throwable -> L6
        WriteQueueItem r0 = findLastItem(new PersisterQueue$$ExternalSyntheticLambda1(item), item.getClass());     // Catch: Throwable -> L6
        if (r0 != null) goto L8;
        addItem(item, flush);     // Catch: Throwable -> L6
    L9:
        yieldIfQueueTooDeep();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r0.updateFrom(item);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    synchronized <T extends WriteQueueItem> void removeItems(Predicate<T> predicate, Class<T> clazz) {
        monitor-enter(this);
        int i = this.mWriteQueue.size() - 1;     // Catch: Throwable -> L11
    L4:
        if (i < 0) goto L15;
        WriteQueueItem writeQueueItem = this.mWriteQueue.get(i);     // Catch: Throwable -> L11
        if (clazz.isInstance(writeQueueItem) == false) goto L13;
        T item = clazz.cast(writeQueueItem);     // Catch: Throwable -> L11
        if (predicate.test(item) == false) goto L13;
        this.mWriteQueue.remove(i);     // Catch: Throwable -> L11
    L13:
        i = i - 1;
        goto L4
    L15:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void flush() {
        monitor-enter(this);
        this.mNextWriteTime = -1;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
    L17:
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
    L10:
        if (this.mNextWriteTime == (-1)) goto L17;
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void yieldIfQueueTooDeep() {
        boolean stall = false;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mNextWriteTime != (-1)) goto L7;
        stall = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (stall == false) goto L16;
        Thread.yield();
        return;
    }

    void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    boolean removeListener(Listener listener) {
        return this.mListeners.remove(listener);
    }

    private void processNextItem() throws InterruptedException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mNextWriteTime == (-1)) goto L9;
        this.mNextWriteTime = SystemClock.uptimeMillis() + this.mInterWriteDelayMs;     // Catch: Throwable -> L6
    L9:
        if (this.mWriteQueue.isEmpty() == false) goto L18;
        if (this.mNextWriteTime == 0) goto L14;
        this.mNextWriteTime = 0;     // Catch: Throwable -> L6
        notify();     // Catch: Throwable -> L6
    L14:
        if (Thread.currentThread().isInterrupted() == true) goto L17;
        wait();     // Catch: Throwable -> L6
        goto L9
    L17:
        throw new InterruptedException();     // Catch: Throwable -> L6
    L18:
        WriteQueueItem item = this.mWriteQueue.remove(0);     // Catch: Throwable -> L6
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L6
    L20:
        if (now >= this.mNextWriteTime) goto L23;
        wait(this.mNextWriteTime - now);     // Catch: Throwable -> L6
        now = SystemClock.uptimeMillis();     // Catch: Throwable -> L6
        goto L20
    L23:
        monitor-exit(this);     // Catch: Throwable -> L6
        item.process();
    }
}
