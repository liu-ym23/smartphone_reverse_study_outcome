package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes17.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        private final Handler mMainThreadHandler;
        private Runnable mMainThreadRunnable;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;

        private void sendMessage(SyncQueueItem r100) {
            this.mQueue.sendMessage(r100);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        public AnonymousClass1(MessageThreadUtil r100, ThreadUtil.MainThreadCallback r101) {
            this.this$0 = r100;
            this.val$callback = r101;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new RunnableC01971(this);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int r100, TileList.Tile<T> r101) {
            sendMessage(SyncQueueItem.obtainMessage(2, r100, r101));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int r100, int r101) {
            sendMessage(SyncQueueItem.obtainMessage(3, r100, r101));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int r100, int r101) {
            sendMessage(SyncQueueItem.obtainMessage(1, r100, r101));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        private Runnable mBackgroundRunnable;
        AtomicBoolean mBackgroundRunning;
        private final Executor mExecutor;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true) == false) goto L6;
            this.mExecutor.execute(this.mBackgroundRunnable);
            return;
        }

        private void sendMessage(SyncQueueItem r100) {
            this.mQueue.sendMessage(r100);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem r100) {
            this.mQueue.sendMessageAtFrontOfQueue(r100);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> r100) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, r100));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int r100) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, r100, null));
        }

        public AnonymousClass2(MessageThreadUtil r100, ThreadUtil.BackgroundCallback r101) {
            this.this$0 = r100;
            this.val$callback = r101;
            this.mQueue = new MessageQueue();
            this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            this.mBackgroundRunning = new AtomicBoolean(false);
            this.mBackgroundRunnable = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int r100, int r101) {
            sendMessage(SyncQueueItem.obtainMessage(3, r100, r101));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int r100, int r101, int r110, int r111, int r112) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, r100, r101, r110, r111, r112, null));
        }
    }

    public static class MessageQueue {
        private SyncQueueItem mRoot;

        public MessageQueue() {
        }

        public synchronized SyncQueueItem next() {
            monitor-enter(this);
            SyncQueueItem r100 = this.mRoot;     // Catch: Throwable -> L11
            if (r100 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            this.mRoot = r100.next;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r100;
        L11:
            th = move-exception;
            throw th;
        }

        public synchronized void removeMessages(int r100) {
            monitor-enter(this);
        L22:
            SyncQueueItem r101 = this.mRoot;     // Catch: Throwable -> L19
            if (r101 == null) goto L8;
            if (r101.what != r100) goto L8;
            this.mRoot = r101.next;     // Catch: Throwable -> L19
            r101.recycle();     // Catch: Throwable -> L19
        L8:
            if (r101 == null) goto L17;
            SyncQueueItem r102 = r101.next;     // Catch: Throwable -> L19
        L10:
            if (r102 == null) goto L17;
            SyncQueueItem r103 = r102.next;     // Catch: Throwable -> L19
            if (r102.what != r100) goto L15;
            r101.next = r103;     // Catch: Throwable -> L19
            r102.recycle();     // Catch: Throwable -> L19
        L16:
            r102 = r103;
            goto L10
        L15:
            r101 = r102;
        L17:
            monitor-exit(this);
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public synchronized void sendMessage(SyncQueueItem r100) {
            monitor-enter(this);
            SyncQueueItem r101 = this.mRoot;     // Catch: Throwable -> L14
            if (r101 != null) goto L8;
            this.mRoot = r100;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L8:
            SyncQueueItem r102 = r101.next;     // Catch: Throwable -> L14
            if (r102 == null) goto L11;
            r101 = r102;
            goto L8
        L11:
            r101.next = r100;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem r100) {
            monitor-enter(this);
            r100.next = this.mRoot;     // Catch: Throwable -> L6
            this.mRoot = r100;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = null;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        public SyncQueueItem() {
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object r100 = sPoolLock;
            monitor-enter(r100);
            SyncQueueItem r101 = sPool;     // Catch: Throwable -> L10
            if (r101 == null) goto L7;
            this.next = r101;     // Catch: Throwable -> L10
        L7:
            sPool = this;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        static {
            sPoolLock = new Object();
        }

        public static SyncQueueItem obtainMessage(int r100, int r101, int r102) {
            return obtainMessage(r100, r101, r102, 0, 0, 0, null);
        }

        public static SyncQueueItem obtainMessage(int r100, int r101, Object r102) {
            return obtainMessage(r100, r101, 0, 0, 0, 0, r102);
        }

        public static SyncQueueItem obtainMessage(int r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            Object r107 = sPoolLock;
            monitor-enter(r107);
            SyncQueueItem r108 = sPool;     // Catch: Throwable -> L11
            if (r108 != null) goto L7;
            r108 = new SyncQueueItem();     // Catch: Throwable -> L11
        L8:
            r108.what = r100;     // Catch: Throwable -> L11
            r108.arg1 = r101;     // Catch: Throwable -> L11
            r108.arg2 = r102;     // Catch: Throwable -> L11
            r108.arg3 = r103;     // Catch: Throwable -> L11
            r108.arg4 = r104;     // Catch: Throwable -> L11
            r108.arg5 = r105;     // Catch: Throwable -> L11
            r108.data = r106;     // Catch: Throwable -> L11
            monitor-exit(r107);     // Catch: Throwable -> L11
            return r108;
        L7:
            sPool = r108.next;     // Catch: Throwable -> L11
            r108.next = null;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }
    }

    public MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> r100) {
        return new AnonymousClass2(this, r100);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> r100) {
        return new AnonymousClass1(this, r100);
    }
}
