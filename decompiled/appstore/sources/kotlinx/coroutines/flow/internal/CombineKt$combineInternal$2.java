package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.f0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.g2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 76, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Object[]> $arrayFactory;
    final /* synthetic */ Flow<Object>[] $flows;
    final /* synthetic */ FlowCollector<Object> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<Object>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<f0> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02961 implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Channel f21529a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f21530b;

            public C02961(Channel r10, int r11) {
                this.f21529a = r10;
                this.f21530b = r11;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r10, Continuation r11) {
                if ((r11 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
                CombineKt$combineInternal$2$1$1$emit$1 r12 = (CombineKt$combineInternal$2$1$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = kotlin.coroutines.intrinsics.a.d();
                int r16 = r12.label;
                if (r16 == 0) goto L16;
                if (r16 == 1) goto L15;
                if (r16 != 2) goto L14;
                kotlin.c.b(r14);
            L23:
                return Unit.f21064a;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                kotlin.c.b(r14);
            L19:
                r12.label = 2;
                if (g2.a(r12) != r15) goto L23;
                return r15;
            L16:
                kotlin.c.b(r14);
                Channel r17 = this.f21529a;
                f0 r18 = new f0(this.f21530b, r10);
                r12.label = 1;
                if (r17.send(r18, r12) != r15) goto L19;
                return r15;
            L7:
                r12 = new CombineKt$combineInternal$2$1$1$emit$1(this, r11);
                goto L8
            }
        }

        public AnonymousClass1(Flow<Object>[] r10, int r11, AtomicInteger r12, Channel<f0> r13, Continuation<? super AnonymousClass1> r14) {
            this.$flows = r10;
            this.$i = r11;
            this.$nonClosed = r12;
            this.$resultChannel = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L11;
            if (r12 != 1) goto L10;
            kotlin.c.b(r10);     // Catch: Throwable -> L7
        L15:
            if (this.$nonClosed.decrementAndGet() != 0) goto L19;
            SendChannel.a.a(this.$resultChannel, null, 1, null);
        L19:
            return Unit.f21064a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            kotlin.c.b(r10);
            Flow<Object>[] r13 = this.$flows;     // Catch: Throwable -> L7
            int r14 = this.$i;     // Catch: Throwable -> L7
            Flow<Object> r15 = r13[r14];     // Catch: Throwable -> L7
            C02961 r16 = new C02961(this.$resultChannel, r14);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r15.collect(r16, this) != r11) goto L15;
            return r11;
        L7:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L23;
            SendChannel.a.a(this.$resultChannel, null, 1, null);
        L23:
            throw th;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<Object>[] r10, Function0<Object[]> r11, Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> r12, FlowCollector<Object> r13, Continuation<? super CombineKt$combineInternal$2> r14) {
        this.$flows = r10;
        this.$arrayFactory = r11;
        this.$transform = r12;
        this.$this_combineInternal = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        CombineKt$combineInternal$2 r12 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0135 -> B:45:0x0137). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r24) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r12 = this.I$1;
        int r13 = this.I$0;
        byte[] r14 = (byte[]) this.L$2;
        Channel r15 = (Channel) this.L$1;
        Object[] r16 = (Object[]) this.L$0;
        kotlin.c.b(r24);
        int r21 = r12;
        byte[] r17 = r14;
        Channel r18 = r15;
    L45:
        Object[] r19 = r16;
    L20:
        int r20 = (byte) (r21 + 1);
        this.L$0 = r19;
        this.L$1 = r18;
        this.L$2 = r17;
        this.I$0 = r13;
        this.I$1 = r20;
        this.label = 1;
        Object r110 = r18.mo51receiveCatchingJP2dKIU(this);
        if (r110 != r10) goto L23;
        return r10;
    L23:
        r16 = r19;
    L24:
        f0 r111 = (f0) kotlinx.coroutines.channels.f.f(r110);
        if (r111 == null) goto L27;
    L28:
        int r112 = r111.a();
        Object r113 = r16[r112];
        r16[r112] = r111.b();
        if (r113 != m.f21552b) goto L32;
        r13 = r13 - 1;
    L32:
        if (r17[r112] == r20) goto L35;
        r17[r112] = (byte) r20;
        r111 = (f0) kotlinx.coroutines.channels.f.f(r18.mo52tryReceivePtdJZtk());
        if (r111 != null) goto L28;
    L35:
        if (r13 != 0) goto L44;
        Object[] r114 = this.$arrayFactory.invoke();
        if (r114 != null) goto L41;
        Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> r115 = this.$transform;
        FlowCollector<Object> r116 = this.$this_combineInternal;
        this.L$0 = r16;
        this.L$1 = r18;
        this.L$2 = r17;
        this.I$0 = r13;
        this.I$1 = r20;
        this.label = 2;
        if (r115.invoke(r116, r16, this) != r10) goto L44;
        return r10;
    L41:
        kotlin.collections.m.f(r16, r114, 0, 0, 0, 14, null);
        Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> r117 = this.$transform;
        FlowCollector<Object> r118 = this.$this_combineInternal;
        this.L$0 = r16;
        this.L$1 = r18;
        this.L$2 = r17;
        this.I$0 = r13;
        this.I$1 = r20;
        this.label = 3;
        if (r117.invoke(r118, r114, this) != r10) goto L44;
        return r10;
    L44:
        r21 = r20;
        goto L45
    L27:
        return Unit.f21064a;
    L11:
        int r22 = this.I$1;
        r13 = this.I$0;
        byte[] r23 = (byte[]) this.L$2;
        Channel r25 = (Channel) this.L$1;
        r16 = (Object[]) this.L$0;
        kotlin.c.b(r24);
        r110 = ((kotlinx.coroutines.channels.f) r24).l();
        r20 = r22;
        r17 = r23;
        r18 = r25;
        goto L24
    L12:
        kotlin.c.b(r24);
        CoroutineScope r26 = (CoroutineScope) this.L$0;
        int r119 = this.$flows.length;
        if (r119 == 0) goto L15;
        r19 = new Object[r119];
        kotlin.collections.m.j(r19, m.f21552b, 0, 0, 6, null);
        Channel r27 = kotlinx.coroutines.channels.e.b(r119, null, null, 6, null);
        AtomicInteger r120 = new AtomicInteger(r119);
        r21 = 0;
        int r121 = 0;
    L17:
        if (r121 >= r119) goto L19;
        int r122 = r121;
        kotlinx.coroutines.h.d(r26, null, null, new AnonymousClass1(this.$flows, r122, r120, r27, null), 3, null);
        r121 = r122 + 1;
        r120 = r120;
        goto L17
    L19:
        r17 = new byte[r119];
        r13 = r119;
        r18 = r27;
        goto L20
    L15:
        return Unit.f21064a;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((CombineKt$combineInternal$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
