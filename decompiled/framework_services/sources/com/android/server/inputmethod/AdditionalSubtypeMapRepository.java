package com.android.server.inputmethod;

import android.os.Process;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class AdditionalSubtypeMapRepository {
    private static final String TAG = "AdditionalSubtypeMapRepository";
    private static final Object sMutationLock = null;
    private static volatile ImmutableSparseArray<AdditionalSubtypeMap> sPerUserMap;
    private static final SingleThreadedBackgroundWriter sWriter = null;

    static final class SingleThreadedBackgroundWriter {
        private final ReentrantLock mLock;
        private final Condition mLockNotifier;
        private final SparseArray<WriteTask> mPendingTasks;
        private final IntArray mRemovedUsers;
        private final Thread mWriterThread;

        /* JADX INFO: renamed from: com.android.server.inputmethod.AdditionalSubtypeMapRepository$SingleThreadedBackgroundWriter$1, reason: invalid class name */
        class AnonymousClass1 extends Thread {
            final /* synthetic */ SingleThreadedBackgroundWriter this$0;

            /* JADX INFO: renamed from: $r8$lambda$RCqI2JbWn22bsn-qIiScow8MfdA, reason: not valid java name */
            public static /* synthetic */ void m4628$r8$lambda$RCqI2JbWn22bsnqIiScow8MfdA(WriteTask r0) {
                lambda$run$0(r0);
            }

            AnonymousClass1(SingleThreadedBackgroundWriter this$0, String arg1) {
                this.this$0 = this$0;
                super(arg1);
            }

            private ArrayList<WriteTask> fetchNextTasks() {
                SingleThreadedBackgroundWriter.m4624$$Nest$fgetmLock(this.this$0).lock();
            L26:
            L20:
                th = move-exception;
                SingleThreadedBackgroundWriter.m4624$$Nest$fgetmLock(this.this$0).unlock();
                throw th;
            L4:
                if (SingleThreadedBackgroundWriter.m4626$$Nest$fgetmPendingTasks(this.this$0).size() != 0) goto L5;
                SingleThreadedBackgroundWriter.m4625$$Nest$fgetmLockNotifier(this.this$0).awaitUninterruptibly();     // Catch: Throwable -> L20
                goto L26
            L5:
                SparseArray<WriteTask> tasks = SingleThreadedBackgroundWriter.m4626$$Nest$fgetmPendingTasks(this.this$0).clone();     // Catch: Throwable -> L20
                SingleThreadedBackgroundWriter.m4626$$Nest$fgetmPendingTasks(this.this$0).clear();     // Catch: Throwable -> L20
                if (SingleThreadedBackgroundWriter.m4627$$Nest$fgetmRemovedUsers(this.this$0).size() != 0) goto L8;
                IntArray removedUsers = null;
            L9:
                SingleThreadedBackgroundWriter.m4624$$Nest$fgetmLock(this.this$0).unlock();
                int size = tasks.size();
                ArrayList<WriteTask> result = new ArrayList(size);
                int i = 0;
            L10:
                if (i >= size) goto L19;
                int userId = tasks.keyAt(i);
                if (removedUsers != null) goto L14;
            L16:
                result.add(tasks.valueAt(i));
            L17:
                i = i + 1;
                goto L10
            L14:
                if (removedUsers.contains(userId) == false) goto L16;
            L19:
                return result;
            L8:
                removedUsers = SingleThreadedBackgroundWriter.m4627$$Nest$fgetmRemovedUsers(this.this$0).clone();     // Catch: Throwable -> L20
                goto L9
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
            L3:
                ArrayList<WriteTask> tasks = fetchNextTasks();
                tasks.forEach(new AdditionalSubtypeMapRepository$SingleThreadedBackgroundWriter$1$$ExternalSyntheticLambda0());
                goto L3
            }

            private static /* synthetic */ void lambda$run$0(WriteTask task) {
                AdditionalSubtypeUtils.save(WriteTask.m4630$$Nest$fgetsubtypeMap(task), WriteTask.m4629$$Nest$fgetinputMethodMap(task), WriteTask.m4631$$Nest$fgetuserId(task));
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ ReentrantLock m4624$$Nest$fgetmLock(SingleThreadedBackgroundWriter r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLockNotifier, reason: not valid java name */
        static /* bridge */ /* synthetic */ Condition m4625$$Nest$fgetmLockNotifier(SingleThreadedBackgroundWriter r0) {
            return r0.mLockNotifier;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingTasks, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m4626$$Nest$fgetmPendingTasks(SingleThreadedBackgroundWriter r0) {
            return r0.mPendingTasks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRemovedUsers, reason: not valid java name */
        static /* bridge */ /* synthetic */ IntArray m4627$$Nest$fgetmRemovedUsers(SingleThreadedBackgroundWriter r0) {
            return r0.mRemovedUsers;
        }

        SingleThreadedBackgroundWriter() {
            this.mLock = new ReentrantLock();
            this.mLockNotifier = this.mLock.newCondition();
            this.mPendingTasks = new SparseArray();
            this.mRemovedUsers = new IntArray();
            this.mWriterThread = new AnonymousClass1(this, "android.ime.as");
        }

        void scheduleWriteTask(int userId, AdditionalSubtypeMap subtypeMap, InputMethodMap inputMethodMap) {
            WriteTask task = new WriteTask(userId, subtypeMap, inputMethodMap);
            this.mLock.lock();
        L10:
            th = move-exception;
            this.mLock.unlock();
            throw th;
        L4:
            if (this.mRemovedUsers.contains(userId) == false) goto L7;
            this.mLock.unlock();
            return;
        L7:
            this.mPendingTasks.put(userId, task);     // Catch: Throwable -> L10
            this.mLockNotifier.signalAll();     // Catch: Throwable -> L10
            this.mLock.unlock();
        }

        void onUserCreated(int userId) {
            this.mLock.lock();
            int i = this.mRemovedUsers.size() - 1;     // Catch: Throwable -> L9
        L4:
            if (i < 0) goto L12;
            if (this.mRemovedUsers.get(i) != userId) goto L11;
            this.mRemovedUsers.remove(i);     // Catch: Throwable -> L9
        L11:
            i = i - 1;
            goto L4
        L12:
            this.mLock.unlock();
            return;
        L9:
            th = move-exception;
            this.mLock.unlock();
            throw th;
        }

        void onUserRemoved(int userId) {
            this.mLock.lock();
            this.mRemovedUsers.add(userId);     // Catch: Throwable -> L6
            this.mPendingTasks.remove(userId);     // Catch: Throwable -> L6
            this.mLock.unlock();
            return;
        L6:
            th = move-exception;
            this.mLock.unlock();
            throw th;
        }

        void startThread() {
            this.mWriterThread.start();
        }
    }

    static final class WriteTask extends Record {
        private final InputMethodMap inputMethodMap;
        private final AdditionalSubtypeMap subtypeMap;
        private final int userId;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof WriteTask) == false) goto L12;
            WriteTask r4 = (WriteTask) r3;
            if (this.userId == r4.userId) goto L7;
            return false;
        L7:
            if (Objects.equals(this.subtypeMap, r4.subtypeMap) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.inputMethodMap, r4.inputMethodMap) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Integer.valueOf(this.userId), this.subtypeMap, this.inputMethodMap};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetinputMethodMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ InputMethodMap m4629$$Nest$fgetinputMethodMap(WriteTask r0) {
            return r0.inputMethodMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsubtypeMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ AdditionalSubtypeMap m4630$$Nest$fgetsubtypeMap(WriteTask r0) {
            return r0.subtypeMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4631$$Nest$fgetuserId(WriteTask r0) {
            return r0.userId;
        }

        WriteTask(int userId, AdditionalSubtypeMap subtypeMap, InputMethodMap inputMethodMap) {
            this.userId = userId;
            this.subtypeMap = subtypeMap;
            this.inputMethodMap = inputMethodMap;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return AdditionalSubtypeMapRepository$WriteTask$$ExternalSyntheticRecord0.m(this.userId, this.subtypeMap, this.inputMethodMap);
        }

        public InputMethodMap inputMethodMap() {
            return this.inputMethodMap;
        }

        public AdditionalSubtypeMap subtypeMap() {
            return this.subtypeMap;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), WriteTask.class, "userId;subtypeMap;inputMethodMap");
        }

        public int userId() {
            return this.userId;
        }
    }

    static {
        sMutationLock = new Object();
        sPerUserMap = ImmutableSparseArray.empty();
        sWriter = new SingleThreadedBackgroundWriter();
    }

    private AdditionalSubtypeMapRepository() {
    }

    static AdditionalSubtypeMap get(int userId) {
        AdditionalSubtypeMap map = sPerUserMap.get(userId);
        if (map != null) goto L6;
        Slog.e(TAG, "get(userId=" + userId + ") is called before loadInitialDataAndGet(). Returning an empty map");
        return AdditionalSubtypeMap.EMPTY_MAP;
    L6:
        return map;
    }

    static void initializeIfNecessary(int userId) {
        if (sPerUserMap.contains(userId) == false) goto L5;
        return;
    L5:
        AdditionalSubtypeMap map = AdditionalSubtypeUtils.load(userId);
        Object r1 = sMutationLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (sPerUserMap.contains(userId) == true) goto L12;
        sPerUserMap = sPerUserMap.cloneWithPutOrSelf(userId, map);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
    }

    static void putAndSave(int userId, AdditionalSubtypeMap map, InputMethodMap inputMethodMap) {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sPerUserMap = sPerUserMap.cloneWithPutOrSelf(userId, map);     // Catch: Throwable -> L7
        sWriter.scheduleWriteTask(userId, map, inputMethodMap);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void startWriterThread() {
        sWriter.startThread();
    }

    static void onUserCreated(int userId) {
        sWriter.onUserCreated(userId);
    }

    static void remove(int userId) {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sWriter.onUserRemoved(userId);     // Catch: Throwable -> L7
        sPerUserMap = sPerUserMap.cloneWithRemoveOrSelf(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
