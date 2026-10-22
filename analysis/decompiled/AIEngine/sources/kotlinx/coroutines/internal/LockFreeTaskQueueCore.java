package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LockFreeTaskQueueCore<E> {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final /* synthetic */ AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;
    public static final Companion Companion = new Companion(null);
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater _state$volatile$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final int addFailReason(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long updateHead(long j10, int i10) {
            return wo(j10, 1073741823L) | i10;
        }

        public final long updateTail(long j10, int i10) {
            return wo(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long wo(long j10, long j11) {
            return j10 & (~j11);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i10) {
            this.index = i10;
        }
    }

    public LockFreeTaskQueueCore(int i10, boolean z) {
        this.capacity = i10;
        this.singleConsumer = z;
        int i11 = i10 - 1;
        this.mask = i11;
        this.array = new AtomicReferenceArray(i10);
        if (i11 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j10) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.mask;
            if ((i10 & i12) == (i12 & i11)) {
                _state$volatile$FU.set(lockFreeTaskQueueCore, Companion.wo(j10, 1152921504606846976L));
                return lockFreeTaskQueueCore;
            }
            Object placeholder = getArray().get(this.mask & i10);
            if (placeholder == null) {
                placeholder = new Placeholder(i10);
            }
            lockFreeTaskQueueCore.getArray().set(lockFreeTaskQueueCore.mask & i10, placeholder);
            i10++;
        }
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$volatile$FU;
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _next$volatile$FU;
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreAllocateNextCopy = allocateNextCopy(j10);
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, lockFreeTaskQueueCoreAllocateNextCopy) && atomicReferenceFieldUpdater2.get(this) == null) {
            }
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i10, E e10) {
        Object obj = getArray().get(this.mask & i10);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i10) {
            return null;
        }
        getArray().set(i10 & this.mask, e10);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray getArray() {
        return this.array;
    }

    private final long markFrozen() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            long j11 = 1152921504606846976L | j10;
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
            if (atomicLongFieldUpdater.compareAndSet(lockFreeTaskQueueCore, j10, j11)) {
                return j11;
            }
            this = lockFreeTaskQueueCore;
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i12 = (int) (1073741823 & j10);
            if ((1152921504606846976L & j10) != 0) {
                return this.next();
            }
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
            if (_state$volatile$FU.compareAndSet(lockFreeTaskQueueCore, j10, Companion.updateHead(j10, i11))) {
                lockFreeTaskQueueCore.getArray().set(lockFreeTaskQueueCore.mask & i12, null);
                return null;
            }
            this = lockFreeTaskQueueCore;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int addLast(E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = get_state$volatile$FU()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r12 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            int r12 = r12.addFailReason(r3)
            return r12
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.mask
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.singleConsumer
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.getArray()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.capacity
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = get_state$volatile$FU()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r5 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            long r5 = r5.updateTail(r3, r2)
            r2 = r12
            boolean r12 = r1.compareAndSet(r2, r3, r5)
            if (r12 == 0) goto L8d
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r2.getArray()
            r0 = r9 & r10
            r12.set(r0, r13)
            r12 = r2
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = get_state$volatile$FU()
            long r0 = r0.get(r12)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L8b
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r12 = r12.next()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r12 = r12.fillPlaceholder(r9, r13)
            if (r12 != 0) goto L72
        L8b:
            r12 = 0
            return r12
        L8d:
            r12 = r2
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
            if (atomicLongFieldUpdater.compareAndSet(lockFreeTaskQueueCore, j10, 2305843009213693952L | j10)) {
                return true;
            }
            this = lockFreeTaskQueueCore;
        }
    }

    public final int getSize() {
        long j10 = _state$volatile$FU.get(this);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final boolean isEmpty() {
        long j10 = _state$volatile$FU.get(this);
        return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return REMOVE_FROZEN;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = this.mask;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i11 & i10)) {
                return null;
            }
            Object obj = this.getArray().get(this.mask & i10);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                if (_state$volatile$FU.compareAndSet(lockFreeTaskQueueCore, j10, Companion.updateHead(j10, i12))) {
                    lockFreeTaskQueueCore.getArray().set(lockFreeTaskQueueCore.mask & i10, null);
                    return obj;
                }
                if (lockFreeTaskQueueCore.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreRemoveSlowPath = lockFreeTaskQueueCore;
                    do {
                        lockFreeTaskQueueCoreRemoveSlowPath = lockFreeTaskQueueCoreRemoveSlowPath.removeSlowPath(i10, i12);
                    } while (lockFreeTaskQueueCoreRemoveSlowPath != null);
                    return obj;
                }
                this = lockFreeTaskQueueCore;
            }
        }
    }
}
