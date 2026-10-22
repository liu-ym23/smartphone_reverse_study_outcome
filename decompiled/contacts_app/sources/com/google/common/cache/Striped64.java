package com.google.common.cache;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
abstract class Striped64 extends Number {
    static final int NCPU = 0;
    private static final AtomicLongFieldUpdater<Striped64> baseUpdater = null;
    private static final AtomicIntegerFieldUpdater<Striped64> busyUpdater = null;
    static final Random rng = null;
    static final ThreadLocal<int[]> threadHashCode = null;
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell[] cells;

    static final class Cell {
        private static final AtomicLongFieldUpdater<Cell> valueUpdater = null;
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        Cell(long r1) {
            this.value = r1;
        }

        final boolean cas(long r7, long r9) {
            return valueUpdater.compareAndSet(this, r7, r9);
        }

        static {
            valueUpdater = AtomicLongFieldUpdater.newUpdater(Cell.class, "value");
        }
    }

    abstract long fn(long r1, long r3);

    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        baseUpdater = AtomicLongFieldUpdater.newUpdater(Striped64.class, TraceStatsConsts.STATS_BASE_MODULE);
        busyUpdater = AtomicIntegerFieldUpdater.newUpdater(Striped64.class, "busy");
    }

    Striped64() {
    }

    final boolean casBase(long r7, long r9) {
        return baseUpdater.compareAndSet(this, r7, r9);
    }

    final boolean casBusy() {
        return busyUpdater.compareAndSet(this, 0, 1);
    }

    final void retryUpdate(long r17, int[] r19, boolean r20) {
        if (r19 != null) goto L8;
        int[] r6 = new int[1];
        threadHashCode.set(r6);
        int r5 = rng.nextInt();
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        r6[0] = r5;
    L9:
        boolean r8 = false;
        int r7 = r5;
        boolean r9 = r20;
    L10:
        Cell[] r10 = this.cells;
        if (r10 == null) goto L63;
        int r11 = r10.length;
        if (r11 <= 0) goto L63;
        Cell r12 = r10[(r11 - 1) & r7];
        if (r12 == null) goto L17;
        if (r9 == false) goto L39;
        long r13 = r12.value;
        if (r12.cas(r13, fn(r13, r17)) == true) goto L115;
        if (r11 >= NCPU) goto L37;
        if (this.cells != r10) goto L37;
        if (r8 == false) goto L49;
        if (this.busy != 0) goto L61;
        if (casBusy() == false) goto L61;
    L58:
        th = move-exception;
        this.busy = 0;
        throw th;
    L55:
        if (this.cells != r10) goto L57;
        Cell[] r14 = new Cell[r11 << 1];     // Catch: Throwable -> L58
        System.arraycopy(r10, 0, r14, 0, r11);     // Catch: Throwable -> L58
        this.cells = r14;     // Catch: Throwable -> L58
    L57:
        this.busy = 0;
        r8 = false;
    L61:
        int r15 = r7 ^ (r7 << 13);
        int r16 = r15 ^ (r15 >>> 17);
        r7 = r16 ^ (r16 << 5);
        r6[0] = r7;
        goto L10
    L49:
        r8 = true;
    L37:
        r8 = false;
        goto L61
    L115:
        return;
    L39:
        r9 = true;
        goto L61
    L17:
        if (this.busy != 0) goto L37;
        Cell r18 = new Cell(r17);
        if (this.busy != 0) goto L37;
        if (casBusy() == false) goto L37;
        Cell[] r110 = this.cells;     // Catch: Throwable -> L34
        if (r110 == null) goto L30;
        int r111 = r110.length;     // Catch: Throwable -> L34
        if (r111 <= 0) goto L30;
        int r112 = (r111 - 1) & r7;     // Catch: Throwable -> L34
        if (r110[r112] != null) goto L30;
        r110[r112] = r18;     // Catch: Throwable -> L34
        boolean r21 = true;
    L31:
        this.busy = 0;
        if (r21 == false) goto L10;
        return;
    L30:
        r21 = false;
    L34:
        th = move-exception;
        this.busy = 0;
        throw th;
    L63:
        if (this.busy != 0) goto L79;
        if (this.cells != r10) goto L79;
        if (casBusy() == false) goto L79;
    L76:
        th = move-exception;
        this.busy = 0;
        throw th;
    L69:
        if (this.cells != r10) goto L72;
        Cell[] r22 = new Cell[2];     // Catch: Throwable -> L76
        r22[r7 & 1] = new Cell(r17);     // Catch: Throwable -> L76
        this.cells = r22;     // Catch: Throwable -> L76
        boolean r23 = true;
    L73:
        this.busy = 0;
        if (r23 == false) goto L10;
        return;
    L72:
        r23 = false;
    L79:
        long r24 = this.base;
        if (casBase(r24, fn(r24, r17)) == false) goto L10;
        return;
    L8:
        r5 = r19[0];
        r6 = r19;
        goto L9
    }

    final void internalReset(long r4) {
        Cell[] r0 = this.cells;
        this.base = r4;
        if (r0 == null) goto L10;
        int r3 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L14;
        Cell r2 = r0[r1];
        if (r2 == null) goto L9;
        r2.value = r4;
    L9:
        r1 = r1 + 1;
        goto L5
    L14:
        return;
    }
}
