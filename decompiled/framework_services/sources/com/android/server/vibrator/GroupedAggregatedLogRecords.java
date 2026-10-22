package com.android.server.vibrator;

import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
abstract class GroupedAggregatedLogRecords<T extends SingleLogRecord> {
    private final int mAggregationTimeLimitMs;
    private final SparseArray<ArrayDeque<AggregatedLogRecord<T>>> mGroupedRecords;
    private final int mSizeLimit;

    static final class AggregatedLogRecord<T extends SingleLogRecord> {
        private int mCount;
        private final T mFirst;
        private T mLatest;

        AggregatedLogRecord(T record) {
            this.mFirst = record;
            this.mLatest = record;
            this.mCount = 1;
        }

        T getLatest() {
            return this.mLatest;
        }

        synchronized boolean mayAggregate(T record, long timeLimitMs) {
            monitor-enter(this);
            long timeDeltaMs = Math.abs(this.mLatest.getCreateUptimeMs() - record.getCreateUptimeMs());     // Catch: Throwable -> L11
            if (this.mLatest.mayAggregate(record) == true) goto L6;
        L8:
            boolean r2 = false;
        L9:
            monitor-exit(this);
            return r2;
        L6:
            if (timeDeltaMs >= timeLimitMs) goto L8;
            r2 = true;
        L11:
            th = move-exception;
            throw th;
        }

        synchronized void record(T record) {
            monitor-enter(this);
            this.mLatest = record;     // Catch: Throwable -> L6
            this.mCount++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void dump(IndentingPrintWriter pw) {
            monitor-enter(this);
            this.mFirst.dump(pw);     // Catch: Throwable -> L11
            if (this.mCount != 1) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.mCount <= 2) goto L13;
            pw.println("-> Skipping " + (this.mCount - 2) + " aggregated entries, latest:");     // Catch: Throwable -> L11
        L13:
            this.mLatest.dump(pw);     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        synchronized void dump(ProtoOutputStream proto, long fieldId) {
            monitor-enter(this);
            this.mFirst.dump(proto, fieldId);     // Catch: Throwable -> L7
            if (this.mCount <= 1) goto L9;
            this.mLatest.dump(proto, fieldId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    interface SingleLogRecord {
        void dump(IndentingPrintWriter r1);

        void dump(ProtoOutputStream r1, long r2);

        long getCreateUptimeMs();

        int getGroupKey();

        boolean mayAggregate(SingleLogRecord r1);
    }

    abstract void dumpGroupHeader(IndentingPrintWriter r1, int r2);

    abstract long findGroupKeyProtoFieldId(int r1);

    GroupedAggregatedLogRecords(int sizeLimit, int aggregationTimeLimitMs) {
        this.mGroupedRecords = new SparseArray();
        this.mSizeLimit = sizeLimit;
        this.mAggregationTimeLimitMs = aggregationTimeLimitMs;
    }

    final synchronized AggregatedLogRecord<T> add(T record) {
        monitor-enter(this);
        int groupKey = record.getGroupKey();     // Catch: Throwable -> L6
        if (this.mGroupedRecords.contains(groupKey) == true) goto L8;
        this.mGroupedRecords.put(groupKey, new ArrayDeque(this.mSizeLimit));     // Catch: Throwable -> L6
    L8:
        ArrayDeque<AggregatedLogRecord<T>> records = this.mGroupedRecords.get(groupKey);     // Catch: Throwable -> L6
        if (this.mAggregationTimeLimitMs > 0) goto L11;
    L18:
        AggregatedLogRecord<T> removedRecord = null;
        if (records.size() < this.mSizeLimit) goto L22;
        removedRecord = records.removeFirst();     // Catch: Throwable -> L6
    L22:
        records.addLast(new AggregatedLogRecord(record));     // Catch: Throwable -> L6
        monitor-exit(this);
        return removedRecord;
    L11:
        if (records.isEmpty() == true) goto L18;
        AggregatedLogRecord<T> lastAggregatedRecord = records.getLast();     // Catch: Throwable -> L6
        if (lastAggregatedRecord.mayAggregate(record, this.mAggregationTimeLimitMs) == false) goto L18;
        lastAggregatedRecord.record(record);     // Catch: Throwable -> L6
        monitor-exit(this);
        return null;
    L6:
        th = move-exception;
        throw th;
    }

    final synchronized void dump(IndentingPrintWriter pw) {
        monitor-enter(this);
        int i = 0;
    L19:
        if (i >= this.mGroupedRecords.size()) goto L15;
        dumpGroupHeader(pw, this.mGroupedRecords.keyAt(i));     // Catch: Throwable -> L10
        pw.increaseIndent();     // Catch: Throwable -> L10
        Iterator<AggregatedLogRecord<T>> r1 = this.mGroupedRecords.valueAt(i).iterator();     // Catch: Throwable -> L10
    L8:
        if (r1.hasNext() == false) goto L12;
        AggregatedLogRecord<T> records = r1.next();     // Catch: Throwable -> L10
        records.dump(pw);     // Catch: Throwable -> L10
        goto L8
    L12:
        pw.decreaseIndent();     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        i = i + 1;
        goto L19
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    final synchronized void dump(ProtoOutputStream proto) {
        monitor-enter(this);
        int i = 0;
    L19:
    L11:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mGroupedRecords.size()) goto L15;
        long fieldId = findGroupKeyProtoFieldId(this.mGroupedRecords.keyAt(i));     // Catch: Throwable -> L11
        Iterator<AggregatedLogRecord<T>> r3 = this.mGroupedRecords.valueAt(i).iterator();     // Catch: Throwable -> L11
    L8:
        if (r3.hasNext() == false) goto L13;
        AggregatedLogRecord<T> records = r3.next();     // Catch: Throwable -> L11
        records.dump(proto, fieldId);     // Catch: Throwable -> L11
        goto L8
    L13:
        i = i + 1;
        goto L19
    L15:
        monitor-exit(this);
    }
}
