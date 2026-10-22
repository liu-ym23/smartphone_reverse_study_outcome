package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SharedFlowImpl extends kotlinx.coroutines.flow.internal.a implements MutableSharedFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BufferOverflow f21487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object[] f21488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f21490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21492l;

    public static final class a implements DisposableHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedFlowImpl f21493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f21495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Continuation f21496d;

        public a(SharedFlowImpl r10, long r11, Object r12, Continuation r13) {
            this.f21493a = r10;
            this.f21494b = r11;
            this.f21495c = r12;
            this.f21496d = r13;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            SharedFlowImpl.i(this.f21493a, this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21497a = null;

        static {
            int[] r10 = new int[BufferOverflow.values().length];
            r10[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f21497a = r10;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {372, 379, 382}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl this$0;

        public AnonymousClass1(SharedFlowImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.v(this.this$0, null, this);
        }
    }

    public SharedFlowImpl(int r10, int r11, BufferOverflow r12) {
        this.f21485e = r10;
        this.f21486f = r11;
        this.f21487g = r12;
    }

    public static /* synthetic */ Object A(SharedFlowImpl r10, Object r11, Continuation r12) {
        if (r10.tryEmit(r11) == true) goto L5;
        Object r13 = r10.B(r11, r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r13;
    L10:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }

    public static final /* synthetic */ void i(SharedFlowImpl r10, a r11) {
        r10.t(r11);
    }

    public static final /* synthetic */ void j(SharedFlowImpl r10, Object r11) {
        r10.C(r11);
    }

    public static final /* synthetic */ Continuation[] k(SharedFlowImpl r10, Continuation[] r11) {
        return r10.D(r11);
    }

    public static final /* synthetic */ int l(SharedFlowImpl r10) {
        return r10.f21486f;
    }

    public static final /* synthetic */ long m(SharedFlowImpl r10) {
        return r10.F();
    }

    public static final /* synthetic */ int n(SharedFlowImpl r10) {
        return r10.f21492l;
    }

    public static final /* synthetic */ int o(SharedFlowImpl r10) {
        return r10.K();
    }

    public static final /* synthetic */ void p(SharedFlowImpl r10, int r11) {
        r10.f21492l = r11;
    }

    public static final /* synthetic */ boolean q(SharedFlowImpl r10, Object r11) {
        return r10.M(r11);
    }

    public static final /* synthetic */ long r(SharedFlowImpl r10, c1 r11) {
        return r10.O(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, kotlinx.coroutines.flow.c1] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.flow.c1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00be -> B:16:0x003e). Please report as a decompilation issue!!! */
    public static /* synthetic */ Object v(SharedFlowImpl r10, FlowCollector r11, Continuation r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r13 = (AnonymousClass1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 != 0) goto L11;
        kotlin.c.b(r15);
        c1 r18 = (c1) r10.c();
        ?? r19 = r11;
        r11 = r18;
        SharedFlowImpl r20 = r10;
    L46:
        Job r21 = (Job) r13.getContext().get(Job.Key);     // Catch: Throwable -> L42
        ?? r22 = r20;
        ?? r23 = r11;
        ?? r110 = r19;
    L31:
        ?? r24 = r22;
        Job r25 = r21;
        ?? r26 = r110;
        r11 = r23;
    L32:
        Object r111 = r24.P(r11);     // Catch: Throwable -> L17
        if (r111 != b1.f21509a) goto L37;
        r13.L$0 = r24;     // Catch: Throwable -> L17
        r13.L$1 = r26;     // Catch: Throwable -> L17
        r13.L$2 = r11;     // Catch: Throwable -> L17
        r13.L$3 = r25;     // Catch: Throwable -> L17
        r13.label = 2;     // Catch: Throwable -> L17
        if (r24.s(r11, r13) != r16) goto L32;
        return r16;
    L37:
        if (r25 == null) goto L39;
        kotlinx.coroutines.h1.i(r25);     // Catch: Throwable -> L17
    L39:
        r13.L$0 = r24;     // Catch: Throwable -> L17
        r13.L$1 = r26;     // Catch: Throwable -> L17
        r13.L$2 = r11;     // Catch: Throwable -> L17
        r13.L$3 = r25;     // Catch: Throwable -> L17
        r13.label = 3;     // Catch: Throwable -> L17
        Object r112 = r26.emit(r111, r13);     // Catch: Throwable -> L17
        ?? r27 = r26;
        ?? r28 = r24;
        ?? r29 = r11;
        if (r112 == r16) goto L41;
    L16:
        r110 = r27;
        r21 = r25;
        r22 = r28;
        r23 = r29;
        goto L31
    L41:
        return r16;
    L42:
        th = move-exception;
        r24 = r20;
        th = th;
    L44:
        r24.f(r11);
        throw th;
    L11:
        if (r17 == 1) goto L24;
        if (r17 == 2) goto L21;
        if (r17 != 3) goto L20;
        r25 = (Job) r13.L$3;
        c1 r30 = (c1) r13.L$2;
        FlowCollector r31 = (FlowCollector) r13.L$1;
        SharedFlowImpl r32 = (SharedFlowImpl) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L17
        r27 = r31;
        r28 = r32;
        r29 = r30;
        goto L16
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r25 = (Job) r13.L$3;
        c1 r33 = (c1) r13.L$2;
        FlowCollector r34 = (FlowCollector) r13.L$1;
        SharedFlowImpl r35 = (SharedFlowImpl) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L17
        r26 = r34;
        r24 = r35;
        r11 = r33;
        goto L32
    L24:
        r11 = (c1) r13.L$2;
        FlowCollector r36 = (FlowCollector) r13.L$1;
        SharedFlowImpl r37 = (SharedFlowImpl) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L27
        r19 = r36;
        r20 = r37;
        r11 = r11;
    L27:
        th = th;
        r24 = r37;
    L17:
        th = th;
    L7:
        r13 = new AnonymousClass1(r10, r12);
        goto L8
    }

    public final Object B(Object r11, Continuation r12) {
        kotlinx.coroutines.n r10 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r12), 1);
        r10.initCancellability();
        Continuation[] r13 = kotlinx.coroutines.flow.internal.b.f21545a;
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (q(this, r11) == false) goto L9;
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L7
        r10.resumeWith(Result.m35constructorimpl(Unit.f21064a));     // Catch: Throwable -> L7
        Continuation[] r15 = k(this, r13);     // Catch: Throwable -> L7
        a r16 = null;
    L13:
        monitor-exit(this);
        if (r16 == null) goto L16;
        kotlinx.coroutines.p.a(r10, r16);
    L16:
        int r17 = r15.length;
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L22;
        Continuation r19 = r15[r18];
        if (r19 == null) goto L21;
        Result.a r20 = Result.Companion;
        r19.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    L21:
        r18 = r18 + 1;
        goto L17
    L22:
        Object r110 = r10.q();
        if (r110 != kotlin.coroutines.intrinsics.a.d()) goto L26;
        tf.d.c(r12);
    L26:
        if (r110 != kotlin.coroutines.intrinsics.a.d()) goto L29;
        return r110;
    L29:
        return Unit.f21064a;
    L9:
        long r21 = m(this);     // Catch: Throwable -> L7
        a r22 = new a(this, ((long) o(this)) + r21, r11, r10);     // Catch: Throwable -> L7
        j(this, r22);     // Catch: Throwable -> L7
        p(this, n(this) + 1);     // Catch: Throwable -> L7
        if (l(this) != 0) goto L12;
        r13 = k(this, r13);     // Catch: Throwable -> L7
    L12:
        r15 = r13;
        r16 = r22;
        goto L13
    }

    public final void C(Object r10) {
        int r11 = K();
        Object[] r12 = this.f21488h;
        if (r12 != null) goto L6;
        r12 = L(null, 0, 2);
    L8:
        b1.d(r12, F() + ((long) r11), r10);
        return;
    L6:
        if (r11 < r12.length) goto L8;
        r12 = L(r12, r11, r12.length * 2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final Continuation[] D(Continuation[] r11) {
        int r10 = r11.length;
        if (kotlinx.coroutines.flow.internal.a.a(this) == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r12 = kotlinx.coroutines.flow.internal.a.b(this);
        if (r12 == null) goto L21;
        int r13 = r12.length;
        int r14 = 0;
        r11 = r11;
    L7:
        if (r14 >= r13) goto L21;
        kotlinx.coroutines.flow.internal.c r15 = r12[r14];
        if (r15 == null) goto L19;
        c1 r16 = (c1) r15;
        Continuation r17 = r16.f21511b;
        if (r17 == null) goto L19;
        if (O(r16) < 0) goto L19;
        int r18 = r11.length;
        r11 = r11;
        if (r10 < r18) goto L18;
        Object[] r19 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
        kotlin.jvm.internal.q.f(r19, "copyOf(this, newSize)");
        r11 = r19;
    L18:
        ((Continuation[]) r11)[r10] = r17;
        r16.f21511b = null;
        r10 = r10 + 1;
    L19:
        r14 = r14 + 1;
        r11 = r11;
    L21:
        return (Continuation[]) r11;
    }

    public final long E() {
        return F() + ((long) this.f21491k);
    }

    public final long F() {
        return Math.min(this.f21490j, this.f21489i);
    }

    public final Object G() {
        Object[] r10 = this.f21488h;
        kotlin.jvm.internal.q.d(r10);
        return b1.c(r10, (this.f21489i + ((long) J())) - 1);
    }

    public final Object H(long r10) {
        Object[] r11 = this.f21488h;
        kotlin.jvm.internal.q.d(r11);
        Object r12 = b1.c(r11, r10);
        if ((r12 instanceof a) == true) goto L5;
        return r12;
    L5:
        return ((a) r12).f21495c;
    }

    public final long I() {
        return (F() + ((long) this.f21491k)) + ((long) this.f21492l);
    }

    public final int J() {
        return (int) ((F() + ((long) this.f21491k)) - this.f21489i);
    }

    public final int K() {
        return this.f21491k + this.f21492l;
    }

    public final Object[] L(Object[] r10, int r11, int r12) {
        if (r12 <= 0) goto L11;
        Object[] r13 = new Object[r12];
        this.f21488h = r13;
        if (r10 != null) goto L6;
        return r13;
    L6:
        long r14 = F();
        int r15 = 0;
    L7:
        if (r15 >= r11) goto L9;
        long r16 = ((long) r15) + r14;
        b1.d(r13, r16, b1.c(r10, r16));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L11:
        throw new IllegalStateException("Buffer size overflow");
    }

    public final boolean M(Object r15) {
        if (g() != 0) goto L7;
        return N(r15);
    L7:
        if (this.f21491k >= this.f21486f) goto L9;
    L18:
        C(r15);
        int r16 = this.f21491k + 1;
        this.f21491k = r16;
        if (r16 <= this.f21486f) goto L22;
        z();
    L22:
        if (J() <= this.f21485e) goto L24;
        Q(this.f21489i + 1, this.f21490j, E(), I());
    L24:
        return true;
    L9:
        if (this.f21490j > this.f21489i) goto L18;
        BufferOverflow r10 = this.f21487g;
        int r11 = b.f21497a[r10.ordinal()];
        if (r11 != 1) goto L13;
        return false;
    L13:
        if (r11 != 2) goto L18;
        return true;
    }

    public final boolean N(Object r10) {
        if (this.f21485e != 0) goto L5;
        return true;
    L5:
        C(r10);
        int r11 = this.f21491k + 1;
        this.f21491k = r11;
        if (r11 <= this.f21485e) goto L8;
        z();
    L8:
        this.f21490j = F() + ((long) this.f21491k);
        return true;
    }

    public final long O(c1 r10) {
        long r11 = r10.f21510a;
        if (r11 >= E()) goto L6;
        return r11;
    L6:
        if (this.f21486f <= 0) goto L9;
        return -1;
    L9:
        if (r11 <= F()) goto L12;
        return -1;
    L12:
        if (this.f21492l != 0) goto L14;
        return -1;
    L14:
        return r11;
    }

    public final Object P(c1 r10) {
        Continuation[] r11 = kotlinx.coroutines.flow.internal.b.f21545a;
        monitor-enter(this);
        long r12 = O(r10);     // Catch: Throwable -> L7
        if (r12 >= 0) goto L9;
        Object r13 = b1.f21509a;     // Catch: Throwable -> L7
    L11:
        monitor-exit(this);
        int r14 = r11.length;
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L18;
        Continuation r16 = r11[r15];
        if (r16 == null) goto L17;
        Result.a r17 = Result.Companion;
        r16.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    L17:
        r15 = r15 + 1;
        goto L13
    L18:
        return r13;
    L9:
        long r18 = r10.f21510a;     // Catch: Throwable -> L7
        Object r19 = H(r12);     // Catch: Throwable -> L7
        r10.f21510a = r12 + 1;     // Catch: Throwable -> L7
        r11 = R(r18);     // Catch: Throwable -> L7
        r13 = r19;
    L7:
        th = move-exception;
        throw th;
    }

    public final void Q(long r10, long r11, long r12, long r13) {
        long r14 = Math.min(r11, r10);
        long r15 = F();
    L4:
        if (r15 >= r14) goto L6;
        Object[] r16 = this.f21488h;
        kotlin.jvm.internal.q.d(r16);
        b1.d(r16, r15, null);
        r15 = r15 + 1;
        goto L4
    L6:
        this.f21489i = r10;
        this.f21490j = r11;
        this.f21491k = (int) (r12 - r14);
        this.f21492l = (int) (r13 - r12);
    }

    public final Continuation[] R(long r22) {
        if (r22 > this.f21490j) goto L5;
        long r10 = F();
        long r11 = ((long) this.f21491k) + r10;
        if (this.f21486f != 0) goto L12;
        if (this.f21492l <= 0) goto L12;
        r11 = r11 + 1;
    L12:
        if (kotlinx.coroutines.flow.internal.a.a(this) == 0) goto L26;
        kotlinx.coroutines.flow.internal.c[] r12 = kotlinx.coroutines.flow.internal.a.b(this);
        if (r12 == null) goto L26;
        int r13 = r12.length;
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L26;
        kotlinx.coroutines.flow.internal.c r15 = r12[r14];
        if (r15 == null) goto L24;
        long r16 = ((c1) r15).f21510a;
        if (r16 < 0) goto L24;
        if (r16 >= r11) goto L24;
        r11 = r16;
    L24:
        r14 = r14 + 1;
    L26:
        if (r11 <= this.f21490j) goto L28;
        long r17 = E();
        if (g() <= 0) goto L32;
        int r18 = (int) (r17 - r11);
        int r19 = Math.min(this.f21492l, this.f21486f - r18);
    L33:
        Continuation[] r110 = kotlinx.coroutines.flow.internal.b.f21545a;
        long r111 = ((long) this.f21492l) + r17;
        if (r19 <= 0) goto L47;
        r110 = new Continuation[r19];
        Object[] r112 = this.f21488h;
        kotlin.jvm.internal.q.d(r112);
        long r20 = r17;
        int r113 = 0;
    L37:
        if (r17 >= r111) goto L46;
        Object r114 = b1.c(r112, r17);
        long r115 = r11;
        kotlinx.coroutines.internal.b0 r21 = b1.f21509a;
        if (r114 == r21) goto L44;
        kotlin.jvm.internal.q.e(r114, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r116 = (a) r114;
        int r23 = r113 + 1;
        long r117 = r111;
        r110[r113] = r116.f21496d;
        b1.d(r112, r17, r21);
        b1.d(r112, r20, r116.f21495c);
        long r118 = 1;
        r20 = r20 + 1;
        if (r23 >= r19) goto L43;
        r113 = r23;
    L45:
        r17 = r17 + r118;
        r11 = r115;
        r111 = r117;
    L43:
        r17 = r20;
    L48:
        int r24 = (int) (r17 - r10);
        if (g() != 0) goto L51;
        long r25 = r17;
    L52:
        long r26 = Math.max(this.f21489i, r17 - ((long) Math.min(this.f21485e, r24)));
        if (this.f21486f == 0) goto L55;
    L59:
        Q(r26, r25, r17, r117);
        u();
        if (r110.length != 0) goto L62;
        boolean r119 = true;
    L63:
        if (r119 == false) goto L65;
        return r110;
    L65:
        return D(r110);
    L62:
        r119 = false;
        goto L63
    L55:
        if (r26 >= r117) goto L59;
        Object[] r27 = this.f21488h;
        kotlin.jvm.internal.q.d(r27);
        if (kotlin.jvm.internal.q.b(b1.c(r27, r26), b1.f21509a) == false) goto L59;
        r17 = r17 + 1;
        r26 = r26 + 1;
        goto L59
    L51:
        r25 = r115;
        goto L52
    L44:
        r117 = r111;
        r118 = 1;
        goto L45
    L46:
        r115 = r11;
        r117 = r111;
        goto L43
    L47:
        r115 = r11;
        r117 = r111;
        goto L48
    L32:
        r19 = this.f21492l;
        goto L33
    L28:
        return kotlinx.coroutines.flow.internal.b.f21545a;
    L5:
        return kotlinx.coroutines.flow.internal.b.f21545a;
    }

    public final long S() {
        long r10 = this.f21489i;
        if (r10 >= this.f21490j) goto L5;
        this.f21490j = r10;
    L5:
        return r10;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        return v(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c d() {
        return x();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c[] e(int r10) {
        return y(r10);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object r10, Continuation r11) {
        return A(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow fuse(CoroutineContext r10, int r11, BufferOverflow r12) {
        return b1.e(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List getReplayCache() {
        monitor-enter(this);
        int r10 = J();     // Catch: Throwable -> L8
        if (r10 != 0) goto L10;
        List r11 = kotlin.collections.t.i();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        ArrayList r12 = new ArrayList(r10);     // Catch: Throwable -> L8
        Object[] r13 = this.f21488h;     // Catch: Throwable -> L8
        kotlin.jvm.internal.q.d(r13);     // Catch: Throwable -> L8
        int r14 = 0;
    L11:
        if (r14 >= r10) goto L14;
        r12.add(b1.c(r13, this.f21489i + ((long) r14)));     // Catch: Throwable -> L8
        r14 = r14 + 1;
        goto L11
    L14:
        monitor-exit(this);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        monitor-enter(this);
        Q(E(), this.f21490j, E(), I());     // Catch: Throwable -> L6
        Unit r10 = Unit.f21064a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final Object s(c1 r10, Continuation r11) {
        kotlinx.coroutines.n r12 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r11), 1);
        r12.initCancellability();
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r(this, r10) >= 0) goto L9;
        r10.f21511b = r12;     // Catch: Throwable -> L7
    L10:
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(this);
        Object r14 = r12.q();
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L16;
        tf.d.c(r11);
    L16:
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L19;
        return r14;
    L19:
        return Unit.f21064a;
    L9:
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L7
        r12.resumeWith(Result.m35constructorimpl(Unit.f21064a));     // Catch: Throwable -> L7
        goto L10
    }

    public final void t(a r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r10.f21494b >= F()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r11 = this.f21488h;     // Catch: Throwable -> L15
        kotlin.jvm.internal.q.d(r11);     // Catch: Throwable -> L15
        if (b1.c(r11, r10.f21494b) == r10) goto L12;
        monitor-exit(this);
        return;
    L12:
        b1.d(r11, r10.f21494b, b1.f21509a);     // Catch: Throwable -> L15
        u();     // Catch: Throwable -> L15
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(Object r10) {
        Continuation[] r11 = kotlinx.coroutines.flow.internal.b.f21545a;
        monitor-enter(this);
        int r12 = 0;
        if (M(r10) == false) goto L10;
        r11 = D(r11);     // Catch: Throwable -> L8
        boolean r13 = true;
    L11:
        monitor-exit(this);
        int r14 = r11.length;
    L13:
        if (r12 >= r14) goto L18;
        Continuation r15 = r11[r12];
        if (r15 == null) goto L17;
        Result.a r16 = Result.Companion;
        r15.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    L17:
        r12 = r12 + 1;
        goto L13
    L18:
        return r13;
    L10:
        r13 = false;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u() {
        if (this.f21486f == 0) goto L5;
    L7:
        Object[] r10 = this.f21488h;
        kotlin.jvm.internal.q.d(r10);
    L9:
        if (this.f21492l <= 0) goto L13;
        if (b1.c(r10, (F() + ((long) K())) - 1) != b1.f21509a) goto L16;
        this.f21492l--;
        b1.d(r10, F() + ((long) K()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.f21492l > 1) goto L7;
    }

    public final void w(long r10) {
        if (kotlinx.coroutines.flow.internal.a.a(this) == 0) goto L16;
        kotlinx.coroutines.flow.internal.c[] r11 = kotlinx.coroutines.flow.internal.a.b(this);
        if (r11 == null) goto L16;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L16;
        kotlinx.coroutines.flow.internal.c r14 = r11[r13];
        if (r14 == null) goto L15;
        c1 r15 = (c1) r14;
        long r16 = r15.f21510a;
        if (r16 < 0) goto L15;
        if (r16 >= r10) goto L15;
        r15.f21510a = r10;
    L15:
        r13 = r13 + 1;
    L16:
        this.f21490j = r10;
    }

    public c1 x() {
        return new c1();
    }

    public c1[] y(int r10) {
        return new c1[r10];
    }

    public final void z() {
        Object[] r10 = this.f21488h;
        kotlin.jvm.internal.q.d(r10);
        b1.d(r10, F(), null);
        this.f21491k--;
        long r11 = F() + 1;
        if (this.f21489i >= r11) goto L6;
        this.f21489i = r11;
    L6:
        if (this.f21490j >= r11) goto L9;
        w(r11);
        return;
    }
}
