package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import lb.n;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {389, 401, 406}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateFlowImpl<T> stateFlowImpl, qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
            this.this$0 = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean updateState(Object obj, Object obj2) {
        int i10;
        StateFlowSlot[] slots;
        synchronized (this) {
            Object obj3 = _state$volatile$FU.get(this);
            if (obj != null && !g.b(obj3, obj)) {
                return false;
            }
            if (g.b(obj3, obj2)) {
                return true;
            }
            _state$volatile$FU.set(this, obj2);
            int i11 = this.sequence;
            if ((i11 & 1) != 0) {
                this.sequence = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.sequence = i12;
            StateFlowSlot[] slots2 = getSlots();
            n nVar = n.f10413a;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = slots2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.sequence;
                    if (i10 == i12) {
                        this.sequence = i12 + 1;
                        return true;
                    }
                    slots = getSlots();
                    n nVar2 = n.f10413a;
                }
                slots2 = slots;
                i12 = i10;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00aa, B:52:0x00e4], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:52:0x00e4, B:35:0x00aa], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b4, B:39:0x00b9, B:50:0x00de, B:52:0x00e4, B:41:0x00bf, B:45:0x00c6, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9 A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b4, B:39:0x00b9, B:50:0x00de, B:52:0x00e4, B:41:0x00bf, B:45:0x00c6, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b4, B:39:0x00b9, B:50:0x00de, B:52:0x00e4, B:41:0x00bf, B:45:0x00c6, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e2 -> B:35:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f4 -> B:35:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r11, qb.b<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, qb.b):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t8, T t10) {
        if (t8 == null) {
            t8 = (T) NullSurrogateKt.NULL;
        }
        if (t10 == null) {
            t10 = (T) NullSurrogateKt.NULL;
        }
        return updateState(t8, t10);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t8, qb.b<? super n> bVar) {
        setValue(t8);
        return n.f10413a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(d dVar, int i10, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, dVar, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t8 = (T) _state$volatile$FU.get(this);
        if (t8 == symbol) {
            return null;
        }
        return t8;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t8) {
        if (t8 == null) {
            t8 = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t8);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t8) {
        setValue(t8);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int i10) {
        return new StateFlowSlot[i10];
    }
}
