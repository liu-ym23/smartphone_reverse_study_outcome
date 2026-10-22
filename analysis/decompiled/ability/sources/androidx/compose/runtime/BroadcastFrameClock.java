package androidx.compose.runtime;

import C7.r;
import S7.n;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$IntRef;
import m9.C1718k;
import m9.InterfaceC1717j;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002,-B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u00032\f\b\u0002\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R \u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0011\u0010+\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/Function0;", "LC7/r;", "onNewAwaiters", AppAgent.CONSTRUCT, "(LS7/a;)V", "", "cause", "fail", "(Ljava/lang/Throwable;)V", "", "timeNanos", "sendFrame", "(J)V", "R", "Lkotlin/Function1;", "onFrame", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancellationException", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "LS7/a;", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "failureCause", "Ljava/lang/Throwable;", "Landroidx/compose/runtime/BroadcastFrameClock$AtomicAwaitersCount;", "pendingAwaitersCountUnlocked", "Landroidx/compose/runtime/internal/AtomicInt;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "awaiters", "Landroidx/collection/MutableObjectList;", "spareList", "", "getHasAwaiters", "()Z", "hasAwaiters", "FrameAwaiter", "AtomicAwaitersCount", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private MutableObjectList<FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final Object lock;
    private final S7.a onNewAwaiters;
    private final AtomicInt pendingAwaitersCountUnlocked;
    private MutableObjectList<FrameAwaiter<?>> spareList;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0083@\u0018\u0000 /2\u00020\u0001:\u0001/B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0014\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010%\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0019\u0010\u0015\u001a\u00020\u0011*\u00020\u00118Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0019\u0010\u001e\u001a\u00020\u0011*\u00020\u00118Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010-\u0088\u0001\u0005\u0092\u0001\u00020\u0004¨\u00060"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$AtomicAwaitersCount;", "", "constructor-impl", "()Landroidx/compose/runtime/internal/AtomicInt;", "Landroidx/compose/runtime/internal/AtomicInt;", "value", "(Landroidx/compose/runtime/internal/AtomicInt;)Landroidx/compose/runtime/internal/AtomicInt;", "", "hasAwaiters-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Z", "hasAwaiters", "LC7/r;", "incrementVersionAndResetCount-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)V", "incrementVersionAndResetCount", "Lkotlin/Function0;", "ifFirstAwaiter", "", "incrementCountAndGetVersion-impl", "(Landroidx/compose/runtime/internal/AtomicInt;LS7/a;)I", "incrementCountAndGetVersion", "version", "decrementCount-impl", "(Landroidx/compose/runtime/internal/AtomicInt;I)V", "decrementCount", "Lkotlin/Function1;", "calculation", "update-impl", "(Landroidx/compose/runtime/internal/AtomicInt;LS7/k;)I", "update", "count", "pack-impl", "(Landroidx/compose/runtime/internal/AtomicInt;II)I", "pack", "", "toString-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Ljava/lang/String;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/runtime/internal/AtomicInt;", "getVersion-impl", "(Landroidx/compose/runtime/internal/AtomicInt;I)I", "getCount-impl", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AtomicAwaitersCount {
        private static final int COUNT_BITS = 27;
        private static final int VERSION_BITS = 4;
        private final AtomicInt value;

        private /* synthetic */ AtomicAwaitersCount(AtomicInt atomicInt) {
            this.value = atomicInt;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AtomicAwaitersCount m3396boximpl(AtomicInt atomicInt) {
            return new AtomicAwaitersCount(atomicInt);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static AtomicInt m3398constructorimpl(AtomicInt atomicInt) {
            return atomicInt;
        }

        /* renamed from: decrementCount-impl, reason: not valid java name */
        public static final void m3399decrementCountimpl(AtomicInt atomicInt, int i) {
            int i6;
            do {
                i6 = atomicInt.get();
            } while (!atomicInt.compareAndSet(i6, ((i6 >>> 27) & 15) == i ? i6 - 1 : i6));
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m3400equalsimpl(AtomicInt atomicInt, Object obj) {
            return (obj instanceof AtomicAwaitersCount) && kotlin.jvm.internal.k.b(atomicInt, ((AtomicAwaitersCount) obj).getValue());
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3401equalsimpl0(AtomicInt atomicInt, AtomicInt atomicInt2) {
            return kotlin.jvm.internal.k.b(atomicInt, atomicInt2);
        }

        /* renamed from: getCount-impl, reason: not valid java name */
        private static final int m3402getCountimpl(AtomicInt atomicInt, int i) {
            return 134217727 & i;
        }

        /* renamed from: getVersion-impl, reason: not valid java name */
        private static final int m3403getVersionimpl(AtomicInt atomicInt, int i) {
            return (i >>> 27) & 15;
        }

        /* renamed from: hasAwaiters-impl, reason: not valid java name */
        public static final boolean m3404hasAwaitersimpl(AtomicInt atomicInt) {
            return (atomicInt.get() & 134217727) > 0;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m3405hashCodeimpl(AtomicInt atomicInt) {
            return atomicInt.hashCode();
        }

        /* renamed from: incrementCountAndGetVersion-impl, reason: not valid java name */
        public static final int m3406incrementCountAndGetVersionimpl(AtomicInt atomicInt, S7.a aVar) {
            int i;
            int i6;
            do {
                i = atomicInt.get();
                i6 = i + 1;
            } while (!atomicInt.compareAndSet(i, i6));
            if ((134217727 & i6) == 1) {
                aVar.invoke();
            }
            return (i6 >>> 27) & 15;
        }

        /* renamed from: incrementVersionAndResetCount-impl, reason: not valid java name */
        public static final void m3407incrementVersionAndResetCountimpl(AtomicInt atomicInt) {
            int i;
            do {
                i = atomicInt.get();
            } while (!atomicInt.compareAndSet(i, m3408packimpl(atomicInt, ((i >>> 27) & 15) + 1, 0)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: pack-impl, reason: not valid java name */
        public static final int m3408packimpl(AtomicInt atomicInt, int i, int i6) {
            return ((i & 15) << 27) | (134217727 & i6);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m3409toStringimpl(AtomicInt atomicInt) {
            int i = atomicInt.get();
            StringBuilder sb = new StringBuilder("AtomicAwaitersCount(version = ");
            sb.append((i >>> 27) & 15);
            sb.append(", count = ");
            return B7.a.o(sb, i & 134217727, ')');
        }

        /* renamed from: update-impl, reason: not valid java name */
        private static final int m3410updateimpl(AtomicInt atomicInt, S7.k kVar) {
            int i;
            int iIntValue;
            do {
                i = atomicInt.get();
                iIntValue = ((Number) kVar.invoke(Integer.valueOf(i))).intValue();
            } while (!atomicInt.compareAndSet(i, iIntValue));
            return iIntValue;
        }

        public boolean equals(Object other) {
            return m3400equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m3405hashCodeimpl(this.value);
        }

        public String toString() {
            return m3409toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ AtomicInt getValue() {
            return this.value;
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static AtomicInt m3397constructorimpl() {
            return m3398constructorimpl(new AtomicInt(0));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "Lkotlin/Function1;", "", "onFrame", "Lm9/j;", "continuation", AppAgent.CONSTRUCT, "(LS7/k;Lm9/j;)V", "LC7/r;", "cancel", "()V", "timeNanos", "resume", "(J)V", "", "exception", "resumeWithException", "(Ljava/lang/Throwable;)V", "LS7/k;", "Lm9/j;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FrameAwaiter<R> {
        private InterfaceC1717j continuation;
        private S7.k onFrame;

        public FrameAwaiter(S7.k kVar, InterfaceC1717j interfaceC1717j) {
            this.onFrame = kVar;
            this.continuation = interfaceC1717j;
        }

        public final void cancel() {
            this.onFrame = null;
            this.continuation = null;
        }

        public final void resume(long timeNanos) {
            InterfaceC1717j interfaceC1717j;
            Object objA;
            S7.k kVar = this.onFrame;
            if (kVar == null || (interfaceC1717j = this.continuation) == null) {
                return;
            }
            try {
                objA = kVar.invoke(Long.valueOf(timeNanos));
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            interfaceC1717j.resumeWith(objA);
        }

        public final void resumeWithException(Throwable exception) {
            InterfaceC1717j interfaceC1717j = this.continuation;
            if (interfaceC1717j != null) {
                interfaceC1717j.resumeWith(kotlin.b.a(exception));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable cause) {
        int i;
        synchronized (this.lock) {
            try {
                if (this.failureCause != null) {
                    return;
                }
                this.failureCause = cause;
                MutableObjectList<FrameAwaiter<?>> mutableObjectList = this.awaiters;
                Object[] objArr = mutableObjectList.content;
                int i6 = mutableObjectList._size;
                for (int i10 = 0; i10 < i6; i10++) {
                    ((FrameAwaiter) objArr[i10]).resumeWithException(cause);
                }
                this.awaiters.clear();
                AtomicInt atomicInt = this.pendingAwaitersCountUnlocked;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, AtomicAwaitersCount.m3408packimpl(atomicInt, ((i >>> 27) & 15) + 1, 0)));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void cancel(CancellationException cancellationException) {
        fail(cancellationException);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, gVar);
    }

    public final boolean getHasAwaiters() {
        return (this.pendingAwaitersCountUnlocked.get() & 134217727) > 0;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h minusKey(H7.g gVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h plus(H7.h hVar) {
        return MonotonicFrameClock.DefaultImpls.plus(this, hVar);
    }

    public final void sendFrame(long timeNanos) {
        int i;
        int i6;
        synchronized (this.lock) {
            try {
                MutableObjectList<FrameAwaiter<?>> mutableObjectList = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = mutableObjectList;
                AtomicInt atomicInt = this.pendingAwaitersCountUnlocked;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, AtomicAwaitersCount.m3408packimpl(atomicInt, ((i >>> 27) & 15) + 1, 0)));
                int size = mutableObjectList.getSize();
                for (i6 = 0; i6 < size; i6++) {
                    mutableObjectList.get(i6).resume(timeNanos);
                }
                mutableObjectList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(S7.k kVar, H7.c<? super R> cVar) {
        int i;
        int i6;
        boolean z10 = true;
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final FrameAwaiter frameAwaiter = new FrameAwaiter(kVar, c1718k);
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f4918a = -1;
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                c1718k.resumeWith(kotlin.b.a(th));
            } else {
                AtomicInt atomicInt = this.pendingAwaitersCountUnlocked;
                do {
                    i = atomicInt.get();
                    i6 = i + 1;
                } while (!atomicInt.compareAndSet(i, i6));
                if ((134217727 & i6) != 1) {
                    z10 = false;
                }
                ref$IntRef.f4918a = (i6 >>> 27) & 15;
                this.awaiters.add(frameAwaiter);
                c1718k.j(new S7.k() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$2
                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return r.f317a;
                    }

                    public final void invoke(Throwable th2) {
                        int i10;
                        frameAwaiter.cancel();
                        AtomicInt atomicInt2 = this.pendingAwaitersCountUnlocked;
                        int i11 = ref$IntRef.f4918a;
                        do {
                            i10 = atomicInt2.get();
                        } while (!atomicInt2.compareAndSet(i10, ((i10 >>> 27) & 15) == i11 ? i10 - 1 : i10));
                    }
                });
                if (z10 && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public BroadcastFrameClock(S7.a aVar) {
        this.onNewAwaiters = aVar;
        this.lock = new Object();
        this.pendingAwaitersCountUnlocked = AtomicAwaitersCount.m3397constructorimpl();
        this.awaiters = new MutableObjectList<>(0, 1, null);
        this.spareList = new MutableObjectList<>(0, 1, null);
    }

    public /* synthetic */ BroadcastFrameClock(S7.a aVar, int i, kotlin.jvm.internal.e eVar) {
        this((i & 1) != 0 ? null : aVar);
    }
}
