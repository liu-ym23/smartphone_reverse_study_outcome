package com.google.common.hash;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.google.common.annotations.GwtIncompatible;
import java.security.AccessController;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
abstract class Striped64 extends Number {
    static final int NCPU = 0;
    private static final Unsafe UNSAFE = null;
    private static final long baseOffset = 0;
    private static final long busyOffset = 0;
    static final Random rng = null;
    static final ThreadLocal<int[]> threadHashCode = null;
    volatile transient long base;
    volatile transient int busy;

    @NullableDecl
    volatile transient Cell[] cells;

    public static final class Cell {
        private static final Unsafe UNSAFE = null;
        private static final long valueOffset = 0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        volatile long f10370p0;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        volatile long f10371p1;

        /* JADX INFO: renamed from: p2, reason: collision with root package name */
        volatile long f10372p2;

        /* JADX INFO: renamed from: p3, reason: collision with root package name */
        volatile long f10373p3;

        /* JADX INFO: renamed from: p4, reason: collision with root package name */
        volatile long f10374p4;

        /* JADX INFO: renamed from: p5, reason: collision with root package name */
        volatile long f10375p5;

        /* JADX INFO: renamed from: p6, reason: collision with root package name */
        volatile long f10376p6;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        volatile long f10377q0;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        volatile long f10378q1;

        /* JADX INFO: renamed from: q2, reason: collision with root package name */
        volatile long f10379q2;

        /* JADX INFO: renamed from: q3, reason: collision with root package name */
        volatile long f10380q3;

        /* JADX INFO: renamed from: q4, reason: collision with root package name */
        volatile long f10381q4;

        /* JADX INFO: renamed from: q5, reason: collision with root package name */
        volatile long f10382q5;

        /* JADX INFO: renamed from: q6, reason: collision with root package name */
        volatile long f10383q6;
        volatile long value;

        static {
            Unsafe r10 = Striped64.access$000();     // Catch: Exception -> L4
            UNSAFE = r10;     // Catch: Exception -> L4
            valueOffset = r10.objectFieldOffset(Cell.class.getDeclaredField(CommonKey.KEY_VALUE));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new Error(e);
        }

        public Cell(long r10) {
            this.value = r10;
        }

        public final boolean cas(long r10, long r11) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, r10, r11);
        }
    }

    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        Unsafe r10 = getUnsafe();     // Catch: Exception -> L5
        UNSAFE = r10;     // Catch: Exception -> L5
        baseOffset = r10.objectFieldOffset(Striped64.class.getDeclaredField(TraceStatsConsts.STATS_BASE_MODULE));     // Catch: Exception -> L5
        busyOffset = r10.objectFieldOffset(Striped64.class.getDeclaredField("busy"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new Error(e);
    }

    public Striped64() {
    }

    public static /* synthetic */ Unsafe access$000() {
        return getUnsafe();
    }

    private static Unsafe getUnsafe() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public final boolean casBase(long r10, long r11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, r10, r11);
    }

    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    public abstract long fn(long r10, long r11);

    public final void internalReset(long r10) {
        Cell[] r11 = this.cells;
        this.base = r10;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        Cell r14 = r11[r13];
        if (r14 == null) goto L9;
        r14.value = r10;
    L9:
        r13 = r13 + 1;
        goto L5
    L14:
        return;
    }

    public final void retryUpdate(long r17, @NullableDecl int[] r19, boolean r20) {
        if (r19 != null) goto L8;
        int[] r10 = new int[1];
        threadHashCode.set(r10);
        int r11 = rng.nextInt();
        if (r11 != 0) goto L7;
        r11 = 1;
    L7:
        r10[0] = r11;
    L9:
        boolean r12 = false;
        int r13 = r11;
        boolean r14 = r20;
    L10:
        Cell[] r15 = this.cells;
        if (r15 == null) goto L68;
        int r16 = r15.length;
        if (r16 <= 0) goto L68;
        Cell r18 = r15[(r16 - 1) & r13];
        if (r18 == null) goto L17;
        if (r14 == false) goto L40;
        long r110 = r18.value;
        if (r18.cas(r110, fn(r110, r17)) == true) goto L122;
        if (r16 >= NCPU) goto L38;
        if (this.cells != r15) goto L38;
        if (r12 == false) goto L50;
        if (this.busy != 0) goto L66;
        if (casBusy() == false) goto L66;
        if (this.cells != r15) goto L63;
        Cell[] r21 = new Cell[r16 << 1];     // Catch: Throwable -> L60
        int r111 = 0;
    L58:
        if (r111 >= r16) goto L62;
        r21[r111] = r15[r111];     // Catch: Throwable -> L60
        r111 = r111 + 1;     // Catch: Throwable -> L60
        goto L58
    L62:
        this.cells = r21;     // Catch: Throwable -> L60
    L63:
        this.busy = 0;
        r12 = false;
    L60:
        th = move-exception;
        this.busy = 0;
        throw th;
    L66:
        int r22 = r13 ^ (r13 << 13);
        int r23 = r22 ^ (r22 >>> 17);
        r13 = r23 ^ (r23 << 5);
        r10[0] = r13;
        goto L10
    L50:
        r12 = true;
    L38:
        r12 = false;
        goto L66
    L122:
        return;
    L40:
        r14 = true;
        goto L66
    L17:
        if (this.busy != 0) goto L38;
        Cell r24 = new Cell(r17);
        if (this.busy != 0) goto L38;
        if (casBusy() == false) goto L38;
        Cell[] r112 = this.cells;     // Catch: Throwable -> L30
        if (r112 == null) goto L32;
        int r113 = r112.length;     // Catch: Throwable -> L30
        if (r113 <= 0) goto L32;
        int r114 = (r113 - 1) & r13;     // Catch: Throwable -> L30
        if (r112[r114] != null) goto L32;
        r112[r114] = r24;     // Catch: Throwable -> L30
        boolean r25 = true;
    L33:
        this.busy = 0;
        if (r25 == false) goto L10;
        return;
    L32:
        r25 = false;
    L30:
        th = move-exception;
        this.busy = 0;
        throw th;
    L68:
        if (this.busy != 0) goto L85;
        if (this.cells != r15) goto L85;
        if (casBusy() == false) goto L85;
    L77:
        th = move-exception;
        this.busy = 0;
        throw th;
    L74:
        if (this.cells != r15) goto L79;
        Cell[] r26 = new Cell[2];     // Catch: Throwable -> L77
        r26[r13 & 1] = new Cell(r17);     // Catch: Throwable -> L77
        this.cells = r26;     // Catch: Throwable -> L77
        boolean r27 = true;
    L80:
        this.busy = 0;
        if (r27 == false) goto L10;
        return;
    L79:
        r27 = false;
    L85:
        long r28 = this.base;
        if (casBase(r28, fn(r28, r17)) == false) goto L10;
        return;
    L8:
        r11 = r19[0];
        r10 = r19;
        goto L9
    }
}
