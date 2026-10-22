package com.android.server.location.eventlog;

import com.android.internal.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class LocalEventLog<T> {
    private static final int IS_FILLER_MASK = Integer.MIN_VALUE;
    private static final int IS_FILLER_OFFSET = 0;
    static final int MAX_TIME_DELTA = 0;
    private static final int TIME_DELTA_MASK = Integer.MAX_VALUE;
    private static final int TIME_DELTA_OFFSET = 0;
    final int[] mEntries;
    long mLastLogTime;
    int mLogEndIndex;
    final T[] mLogEvents;
    int mLogSize;
    long mModificationCount;
    long mStartTime;

    public interface LogConsumer<T> {
        void acceptLog(long r1, T r3);
    }

    protected final class LogIterator {
        private int mCount;
        private T mCurrentLogEvent;
        private long mCurrentTime;
        private int mIndex;
        private long mLogTime;
        private final long mModificationCount;
        final /* synthetic */ LocalEventLog this$0;

        public LogIterator(LocalEventLog this$0) {
            this.this$0 = this$0;
            monitor-enter(this$0);
            this.mModificationCount = this$0.mModificationCount;     // Catch: Throwable -> L7
            this.mLogTime = this$0.mStartTime;     // Catch: Throwable -> L7
            this.mIndex = -1;     // Catch: Throwable -> L7
            this.mCount = -1;     // Catch: Throwable -> L7
            increment();     // Catch: Throwable -> L7
            monitor-exit(this$0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean hasNext() {
            LocalEventLog r0 = this.this$0;
            monitor-enter(r0);
            checkModifications();     // Catch: Throwable -> L10
            if (this.mCount >= this.this$0.mLogSize) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
        L10:
            th = move-exception;
            throw th;
        }

        public void next() {
            LocalEventLog r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (hasNext() == false) goto L12;
            this.mCurrentTime = this.mLogTime + ((long) LocalEventLog.getTimeDelta(this.this$0.mEntries[this.mIndex]));     // Catch: Throwable -> L9
            T r1 = this.this$0.mLogEvents[this.mIndex];     // Catch: Throwable -> L9
            r1.getClass();     // Catch: Throwable -> L9
            this.mCurrentLogEvent = r1;     // Catch: Throwable -> L9
            increment();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            throw new NoSuchElementException();     // Catch: Throwable -> L9
        }

        public long getTime() {
            return this.mCurrentTime;
        }

        public T getLog() {
            return this.mCurrentLogEvent;
        }

        private void increment() {
            if (this.mIndex != (-1)) goto L5;
            long nextDeltaMs = 0;
        L6:
            this.mLogTime += nextDeltaMs;
            this.mIndex = this.this$0.incrementIndex(this.mIndex);
            int r2 = this.mCount + 1;
            this.mCount = r2;
            if (r2 >= this.this$0.mLogSize) goto L10;
            nextDeltaMs = LocalEventLog.getTimeDelta(this.this$0.mEntries[this.mIndex]);
        L10:
            if (this.mCount >= this.this$0.mLogSize) goto L13;
            if (LocalEventLog.isFiller(this.this$0.mEntries[this.mIndex]) == true) goto L6;
            return;
        L13:
            return;
        L5:
            nextDeltaMs = LocalEventLog.getTimeDelta(this.this$0.mEntries[this.mIndex]);
            goto L6
        }

        private void checkModifications() {
            if (this.mModificationCount != this.this$0.mModificationCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }
    }

    static {
        IS_FILLER_OFFSET = countTrailingZeros(Integer.MIN_VALUE);
        TIME_DELTA_OFFSET = countTrailingZeros(Integer.MAX_VALUE);
        MAX_TIME_DELTA = (1 << Integer.bitCount(Integer.MAX_VALUE)) - 1;
    }

    private static int countTrailingZeros(int i) {
        int c = 0;
    L3:
        if (i == 0) goto L7;
        if ((i & 1) != 0) goto L7;
        c = c + 1;
        i = i >>> 1;
    L7:
        return c;
    }

    private static int createEntry(boolean r3, int r4) {
        if (r4 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        Preconditions.checkArgument(r0);
        int r1 = IS_FILLER_OFFSET;
        return (((r3 ? 1 : 0) << r1) & Integer.MIN_VALUE) | ((r4 << TIME_DELTA_OFFSET) & Integer.MAX_VALUE);
    L4:
        if (r4 > MAX_TIME_DELTA) goto L6;
        r0 = true;
        goto L7
    }

    static int getTimeDelta(int entry) {
        return (Integer.MAX_VALUE & entry) >>> TIME_DELTA_OFFSET;
    }

    static boolean isFiller(int entry) {
        if ((Integer.MIN_VALUE & entry) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LocalEventLog(int r3, Class<T> r4) {
        if (r3 <= 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1);
        this.mEntries = new int[r3];
        this.mLogEvents = (T[]) ((Object[]) Array.newInstance(r4, r3));
        this.mLogSize = 0;
        this.mLogEndIndex = 0;
        this.mStartTime = -1;
        this.mLastLogTime = -1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    protected synchronized void addLog(long time, T logEvent) {
        monitor-enter(this);
        if (logEvent == null) goto L6;
        boolean r2 = true;
    L28:
        Preconditions.checkArgument(r2);     // Catch: Throwable -> L17
        long delta = 0;
        if (isEmpty() == true) goto L21;
        delta = time - this.mLastLogTime;     // Catch: Throwable -> L17
        if (delta >= 0) goto L12;
    L19:
        clear();     // Catch: Throwable -> L17
        delta = 0;
        goto L21
    L12:
        if ((delta / ((long) MAX_TIME_DELTA)) >= (this.mEntries.length - 1)) goto L19;
    L15:
        if (delta < MAX_TIME_DELTA) goto L21;
        addLogEventInternal(true, MAX_TIME_DELTA, null);     // Catch: Throwable -> L17
        delta = delta - ((long) MAX_TIME_DELTA);     // Catch: Throwable -> L17
    L21:
        if (isEmpty() == false) goto L23;
        this.mStartTime = time;     // Catch: Throwable -> L17
        this.mLastLogTime = this.mStartTime;     // Catch: Throwable -> L17
        this.mModificationCount++;     // Catch: Throwable -> L17
    L23:
        addLogEventInternal(false, (int) delta, logEvent);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    L6:
        r2 = false;
        goto L28
    }

    private void addLogEventInternal(boolean isFiller, int timeDelta, T logEvent) {
        boolean r0 = false;
        if (isFiller == true) goto L7;
        if (logEvent != null) goto L7;
        boolean r2 = false;
    L8:
        Preconditions.checkArgument(r2);
        if (this.mStartTime != (-1)) goto L11;
    L13:
        Preconditions.checkState(r0);
        if (this.mLogSize != this.mEntries.length) goto L16;
        this.mStartTime += (long) getTimeDelta(this.mEntries[startIndex()]);
        this.mModificationCount++;
    L17:
        this.mEntries[this.mLogEndIndex] = createEntry(isFiller, timeDelta);
        this.mLogEvents[this.mLogEndIndex] = logEvent;
        this.mLogEndIndex = incrementIndex(this.mLogEndIndex);
        this.mLastLogTime += (long) timeDelta;
        return;
    L16:
        this.mLogSize++;
        goto L17
    L11:
        if (this.mLastLogTime == (-1)) goto L13;
        r0 = true;
    L7:
        r2 = true;
        goto L8
    }

    public synchronized void clear() {
        monitor-enter(this);
        Arrays.fill(this.mLogEvents, null);     // Catch: Throwable -> L6
        this.mLogEndIndex = 0;     // Catch: Throwable -> L6
        this.mLogSize = 0;     // Catch: Throwable -> L6
        this.mModificationCount++;     // Catch: Throwable -> L6
        this.mStartTime = -1;     // Catch: Throwable -> L6
        this.mLastLogTime = -1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isEmpty() {
        if (this.mLogSize != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void iterate(LogConsumer<? super T> r5) {
        monitor-enter(this);
        LogIterator r0 = new LogIterator(this);     // Catch: Throwable -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        r0.next();     // Catch: Throwable -> L8
        r5.acceptLog(r0.getTime(), (T) r0.getLog());     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @SafeVarargs
    public static <T> void iterate(LogConsumer<? super T> r8, LocalEventLog<T>... r9) {
        ArrayList r0 = new ArrayList(r9.length);
        int r1 = r9.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        LocalEventLog<T> r3 = r9[r2];
        r3.getClass();
        LogIterator r4 = new LogIterator(r3);
        if (r4.hasNext() == false) goto L8;
        r0.add(r4);
        r4.next();
    L8:
        r2 = r2 + 1;
    L9:
        LocalEventLog<T>.LogIterator r5 = null;
        Iterator r6 = r0.iterator();
    L11:
        if (r6.hasNext() == false) goto L19;
        LocalEventLog<T>.LogIterator r7 = (LogIterator) r6.next();
        if (r7 == null) goto L11;
        if (r5 == null) goto L17;
        if (r7.getTime() >= r5.getTime()) goto L11;
    L17:
        r5 = r7;
        goto L11
    L19:
        if (r5 == null) goto L20;
        r8.acceptLog(r5.getTime(), r5.getLog());
        if (r5.hasNext() == true) goto L23;
        r0.remove(r5);
        goto L9
    L23:
        r5.next();
        goto L9
    }

    int startIndex() {
        return wrapIndex(this.mLogEndIndex - this.mLogSize);
    }

    int incrementIndex(int index) {
        if (index == (-1)) goto L5;
        if (index < 0) goto L10;
        return wrapIndex(index + 1);
    L10:
        throw new IllegalArgumentException();
    L5:
        return startIndex();
    }

    int wrapIndex(int index) {
        return ((index % this.mEntries.length) + this.mEntries.length) % this.mEntries.length;
    }
}
