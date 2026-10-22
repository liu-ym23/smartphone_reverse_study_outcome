package io.ktor.network.selector;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002'&B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\t¨\u0006("}, d2 = {"Lio/ktor/network/selector/LockFreeMPSCQueueCore;", "", ExifInterface.LONGITUDE_EAST, "", "capacity", "<init>", "(I)V", "", "close", "()Z", "element", "addLast", "(Ljava/lang/Object;)I", "index", "Lio/ktor/network/selector/Core;", "fillPlaceholder", "(ILjava/lang/Object;)Lio/ktor/network/selector/LockFreeMPSCQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lio/ktor/network/selector/LockFreeMPSCQueueCore;", "next", "()Lio/ktor/network/selector/LockFreeMPSCQueueCore;", "", "markFrozen", "()J", VoiceWakeupReceiver.EXTRA_STATE, "allocateOrGetNextCopy", "(J)Lio/ktor/network/selector/LockFreeMPSCQueueCore;", "allocateNextCopy", "I", "mask", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "isEmpty", "Companion", "Placeholder", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class LockFreeMPSCQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    private static final int CAPACITY_BITS = 30;
    private static final long CLOSED_MASK = 2305843009213693952L;
    private static final int CLOSED_SHIFT = 61;
    private static final long FROZEN_MASK = 1152921504606846976L;
    private static final int FROZEN_SHIFT = 60;
    private static final long HEAD_MASK = 1073741823;
    private static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    private static final int MAX_CAPACITY_MASK = 1073741823;
    private static final long TAIL_MASK = 1152921503533105152L;
    private static final int TAIL_SHIFT = 30;
    private final AtomicReferenceArray<Object> array;
    private final int capacity;
    private final int mask;
    private volatile /* synthetic */ Object nextRef = null;
    private volatile /* synthetic */ long stateRef = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Object REMOVE_FROZEN = new Object() { // from class: io.ktor.network.selector.LockFreeMPSCQueueCore$Companion$REMOVE_FROZEN$1
        public String toString() {
            return "REMOVE_FROZEN";
        }
    };
    private static final /* synthetic */ AtomicReferenceFieldUpdater nextRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeMPSCQueueCore.class, Object.class, "nextRef");
    private static final /* synthetic */ AtomicLongFieldUpdater stateRef$FU = AtomicLongFieldUpdater.newUpdater(LockFreeMPSCQueueCore.class, "stateRef");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000bJ4\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u000e*\u00020\u00042\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\b*\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010\u0016R\u0014\u0010&\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010\u0016¨\u0006'"}, d2 = {"Lio/ktor/network/selector/LockFreeMPSCQueueCore$Companion;", "", "<init>", "()V", "", "other", "wo", "(JJ)J", "", "newHead", "updateHead", "(JI)J", "newTail", "updateTail", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "block", "withState", "(JLp9/p;)Ljava/lang/Object;", "addFailReason", "(J)I", "INITIAL_CAPACITY", "I", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "HEAD_MASK", "J", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "REMOVE_FROZEN", "Ljava/lang/Object;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int addFailReason(long j10) {
            return (j10 & LockFreeMPSCQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long updateHead(long j10, int i10) {
            return wo(j10, LockFreeMPSCQueueCore.HEAD_MASK) | i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long updateTail(long j10, int i10) {
            return wo(j10, LockFreeMPSCQueueCore.TAIL_MASK) | (i10 << 30);
        }

        private final <T> T withState(long j10, p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.invoke(Integer.valueOf((int) (LockFreeMPSCQueueCore.HEAD_MASK & j10)), Integer.valueOf((int) ((j10 & LockFreeMPSCQueueCore.TAIL_MASK) >> 30)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long wo(long j10, long j11) {
            return j10 & (~j11);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/network/selector/LockFreeMPSCQueueCore$Placeholder;", "", "", "index", "<init>", "(I)V", "I", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i10) {
            this.index = i10;
        }
    }

    public LockFreeMPSCQueueCore(int i10) {
        this.capacity = i10;
        int i11 = i10 - 1;
        this.mask = i11;
        this.array = new AtomicReferenceArray<>(i10);
        if (i11 > MAX_CAPACITY_MASK) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final LockFreeMPSCQueueCore<E> allocateNextCopy(long state) {
        LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = new LockFreeMPSCQueueCore<>(this.capacity * 2);
        int i10 = (int) (HEAD_MASK & state);
        int i11 = (int) ((TAIL_MASK & state) >> 30);
        while (true) {
            int i12 = this.mask;
            if ((i10 & i12) == (i11 & i12)) {
                lockFreeMPSCQueueCore.stateRef = INSTANCE.wo(state, FROZEN_MASK);
                return lockFreeMPSCQueueCore;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = lockFreeMPSCQueueCore.array;
            int i13 = lockFreeMPSCQueueCore.mask & i10;
            Object placeholder = this.array.get(i12 & i10);
            if (placeholder == null) {
                placeholder = new Placeholder(i10);
            }
            atomicReferenceArray.set(i13, placeholder);
            i10++;
        }
    }

    private final LockFreeMPSCQueueCore<E> allocateOrGetNextCopy(long state) {
        while (true) {
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) this.nextRef;
            if (lockFreeMPSCQueueCore != null) {
                return lockFreeMPSCQueueCore;
            }
            nextRef$FU.compareAndSet(this, null, allocateNextCopy(state));
        }
    }

    private final LockFreeMPSCQueueCore<E> fillPlaceholder(int index, E element) {
        Object obj = this.array.get(this.mask & index);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != index) {
            return null;
        }
        this.array.set(index & this.mask, element);
        return this;
    }

    private final long markFrozen() {
        while (true) {
            long j10 = this.stateRef;
            if ((j10 & FROZEN_MASK) != 0) {
                return j10;
            }
            long j11 = j10 | FROZEN_MASK;
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = this;
            if (stateRef$FU.compareAndSet(lockFreeMPSCQueueCore, j10, j11)) {
                return j11;
            }
            this = lockFreeMPSCQueueCore;
        }
    }

    private final LockFreeMPSCQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        while (true) {
            long j10 = this.stateRef;
            int i10 = (int) (HEAD_MASK & j10);
            if (i10 != oldHead) {
                throw new IllegalStateException("This queue can have only one consumer");
            }
            if ((FROZEN_MASK & j10) != 0) {
                return this.next();
            }
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = this;
            if (stateRef$FU.compareAndSet(lockFreeMPSCQueueCore, j10, INSTANCE.updateHead(j10, newHead))) {
                lockFreeMPSCQueueCore.array.set(lockFreeMPSCQueueCore.mask & i10, null);
                return null;
            }
            this = lockFreeMPSCQueueCore;
        }
    }

    public final int addLast(E element) {
        kotlin.jvm.internal.p.i(element, "element");
        while (true) {
            long j10 = this.stateRef;
            if ((3458764513820540928L & j10) != 0) {
                return INSTANCE.addFailReason(j10);
            }
            int i10 = (int) (HEAD_MASK & j10);
            int i11 = (int) ((TAIL_MASK & j10) >> 30);
            int i12 = this.mask;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = this;
            if (stateRef$FU.compareAndSet(lockFreeMPSCQueueCore, j10, INSTANCE.updateTail(j10, (i11 + 1) & MAX_CAPACITY_MASK))) {
                lockFreeMPSCQueueCore.array.set(lockFreeMPSCQueueCore.mask & i11, element);
                LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCoreFillPlaceholder = lockFreeMPSCQueueCore;
                while ((lockFreeMPSCQueueCoreFillPlaceholder.stateRef & FROZEN_MASK) != 0 && (lockFreeMPSCQueueCoreFillPlaceholder = lockFreeMPSCQueueCoreFillPlaceholder.next().fillPlaceholder(i11, element)) != null) {
                }
                return 0;
            }
            this = lockFreeMPSCQueueCore;
        }
    }

    public final boolean close() {
        while (true) {
            long j10 = this.stateRef;
            if ((j10 & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j10) != 0) {
                return false;
            }
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = this;
            if (stateRef$FU.compareAndSet(lockFreeMPSCQueueCore, j10, j10 | CLOSED_MASK)) {
                return true;
            }
            this = lockFreeMPSCQueueCore;
        }
    }

    public final boolean isEmpty() {
        long j10 = this.stateRef;
        return ((int) (HEAD_MASK & j10)) == ((int) ((j10 & TAIL_MASK) >> 30));
    }

    public final LockFreeMPSCQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public final Object removeFirstOrNull() {
        Object obj;
        long j10 = this.stateRef;
        if ((FROZEN_MASK & j10) != 0) {
            return REMOVE_FROZEN;
        }
        int i10 = (int) (HEAD_MASK & j10);
        int i11 = (int) ((TAIL_MASK & j10) >> 30);
        int i12 = this.mask;
        if ((i11 & i12) == (i10 & i12) || (obj = this.array.get(i12 & i10)) == null || (obj instanceof Placeholder)) {
            return null;
        }
        int i13 = (i10 + 1) & MAX_CAPACITY_MASK;
        if (stateRef$FU.compareAndSet(this, j10, INSTANCE.updateHead(j10, i13))) {
            this.array.set(this.mask & i10, null);
            return obj;
        }
        LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCoreRemoveSlowPath = this;
        do {
            lockFreeMPSCQueueCoreRemoveSlowPath = lockFreeMPSCQueueCoreRemoveSlowPath.removeSlowPath(i10, i13);
        } while (lockFreeMPSCQueueCoreRemoveSlowPath != null);
        return obj;
    }
}
