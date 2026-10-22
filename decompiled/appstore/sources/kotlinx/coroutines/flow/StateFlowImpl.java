package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StateFlowImpl extends kotlinx.coroutines.flow.internal.a implements MutableStateFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21505f = null;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21506e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {384, 396, 401}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl this$0;

        public AnonymousClass1(StateFlowImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    static {
        f21505f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    }

    public StateFlowImpl(Object r10) {
        this._state = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, kotlinx.coroutines.flow.g1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.flow.g1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00c6 -> B:32:0x0094). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d8 -> B:32:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        ?? r16 = r12.label;
        if (r16 != 0) goto L11;
        kotlin.c.b(r14);
        r16 = (g1) c();
    L30:
        ?? r17 = this;
        FlowCollector r18 = r10;
        Job r19 = (Job) r12.getContext().get(Job.Key);     // Catch: Throwable -> L27
        Object r20 = null;
        r16 = r16;
    L32:
        Object r110 = f21505f.get(r17);     // Catch: Throwable -> L17
        if (r19 == null) goto L35;
        kotlinx.coroutines.h1.i(r19);     // Catch: Throwable -> L17
    L35:
        if (r20 == null) goto L39;
        ?? r21 = r16;
        ?? r22 = r17;
        if (kotlin.jvm.internal.q.b(r20, r110) == false) goto L39;
    L46:
        boolean r111 = r21.h();     // Catch: Throwable -> L17
        r16 = r21;
        r17 = r22;
        if (r111 == true) goto L32;
        r12.L$0 = r22;     // Catch: Throwable -> L17
        r12.L$1 = r18;     // Catch: Throwable -> L17
        r12.L$2 = r21;     // Catch: Throwable -> L17
        r12.L$3 = r19;     // Catch: Throwable -> L17
        r12.L$4 = r20;     // Catch: Throwable -> L17
        r12.label = 3;     // Catch: Throwable -> L17
        Object r112 = r21.e(r12);     // Catch: Throwable -> L17
        r16 = r21;
        r17 = r22;
        if (r112 != r15) goto L32;
        return r15;
    L39:
        if (r110 != kotlinx.coroutines.flow.internal.m.f21551a) goto L41;
        Object r23 = null;
    L42:
        r12.L$0 = r17;     // Catch: Throwable -> L17
        r12.L$1 = r18;     // Catch: Throwable -> L17
        r12.L$2 = r16;     // Catch: Throwable -> L17
        r12.L$3 = r19;     // Catch: Throwable -> L17
        r12.L$4 = r110;     // Catch: Throwable -> L17
        r12.label = 2;     // Catch: Throwable -> L17
        if (r18.emit(r23, r12) != r15) goto L45;
        return r15;
    L45:
        r20 = r110;
        r21 = r16;
        r22 = r17;
        goto L46
    L41:
        r23 = r110;
    L27:
        th = move-exception;
        r17 = this;
        th = th;
    L51:
        r17.f(r16);
        throw th;
    L11:
        if (r16 == 1) goto L24;
        if (r16 == 2) goto L21;
        if (r16 != 3) goto L20;
        r20 = r12.L$4;
        r19 = (Job) r12.L$3;
        g1 r24 = (g1) r12.L$2;
        r18 = (FlowCollector) r12.L$1;
        StateFlowImpl r25 = (StateFlowImpl) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L17
        r16 = r24;
        r17 = r25;
        goto L32
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r20 = r12.L$4;
        r19 = (Job) r12.L$3;
        g1 r26 = (g1) r12.L$2;
        r18 = (FlowCollector) r12.L$1;
        StateFlowImpl r27 = (StateFlowImpl) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L17
        r21 = r26;
        r22 = r27;
        goto L46
    L24:
        r16 = (g1) r12.L$2;
        r10 = (FlowCollector) r12.L$1;
        StateFlowImpl this = (StateFlowImpl) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L27
        r16 = r16;
    L17:
        th = th;
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(Object r10, Object r11) {
        if (r10 != null) goto L4;
        r10 = kotlinx.coroutines.flow.internal.m.f21551a;
    L4:
        if (r11 != null) goto L7;
        r11 = kotlinx.coroutines.flow.internal.m.f21551a;
    L7:
        return k(r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c d() {
        return i();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c[] e(int r10) {
        return j(r10);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object r10, Continuation r11) {
        setValue(r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow fuse(CoroutineContext r10, int r11, BufferOverflow r12) {
        return f1.d(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List getReplayCache() {
        return kotlin.collections.s.e(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public Object getValue() {
        kotlinx.coroutines.internal.b0 r10 = kotlinx.coroutines.flow.internal.m.f21551a;
        Object r11 = f21505f.get(this);
        if (r11 != r10) goto L6;
        return null;
    L6:
        return r11;
    }

    public g1 i() {
        return new g1();
    }

    public g1[] j(int r10) {
        return new g1[r10];
    }

    public final boolean k(Object r10, Object r11) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r12 = f21505f;     // Catch: Throwable -> L10
        Object r13 = r12.get(this);     // Catch: Throwable -> L10
        if (r10 == null) goto L13;
        if (kotlin.jvm.internal.q.b(r13, r10) == true) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (kotlin.jvm.internal.q.b(r13, r11) == false) goto L16;
        monitor-exit(this);
        return true;
    L16:
        r12.set(this, r11);     // Catch: Throwable -> L10
        int r14 = this.f21506e;     // Catch: Throwable -> L10
        if ((r14 & 1) != 0) goto L42;
        int r15 = r14 + 1;     // Catch: Throwable -> L10
        this.f21506e = r15;     // Catch: Throwable -> L10
        kotlinx.coroutines.flow.internal.c[] r16 = h();     // Catch: Throwable -> L10
        Unit r17 = Unit.f21064a;     // Catch: Throwable -> L10
        monitor-exit(this);
    L20:
        g1[] r18 = (g1[]) r16;
        if (r18 == null) goto L28;
        int r19 = r18.length;
        int r20 = 0;
    L23:
        if (r20 >= r19) goto L28;
        g1 r21 = r18[r20];
        if (r21 == null) goto L27;
        r21.g();
    L27:
        r20 = r20 + 1;
    L28:
        monitor-enter(this);
        int r22 = this.f21506e;     // Catch: Throwable -> L34
        if (r22 == r15) goto L31;
        kotlinx.coroutines.flow.internal.c[] r23 = h();     // Catch: Throwable -> L34
        Unit r24 = Unit.f21064a;     // Catch: Throwable -> L34
        monitor-exit(this);
        r16 = r23;
        r15 = r22;
        goto L20
    L31:
        this.f21506e = r15 + 1;     // Catch: Throwable -> L34
        monitor-exit(this);
        return true;
    L34:
        th = move-exception;
        throw th;
    L42:
        this.f21506e = r14 + 2;     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(Object r10) {
        if (r10 != null) goto L4;
        r10 = kotlinx.coroutines.flow.internal.m.f21551a;
    L4:
        k(null, r10);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(Object r10) {
        setValue(r10);
        return true;
    }
}
