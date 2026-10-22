package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ MutableSharedFlow<Object> $shared;
    final /* synthetic */ SharingStarted $started;
    final /* synthetic */ Flow<Object> $upstream;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(r11);
            r12.I$0 = ((Number) r10).intValue();
            return r12;
        }

        @Nullable
        public final Object invoke(int r10, @Nullable Continuation<? super Boolean> r11) {
            return ((AnonymousClass1) create(Integer.valueOf(r10), r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L11;
            kotlin.c.b(r10);
            if (this.I$0 <= 0) goto L7;
            boolean r11 = true;
        L9:
            return tf.a.a(r11);
        L7:
            r11 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Integer r10, Continuation<? super Boolean> r11) {
            return invoke(r10.intValue(), r11);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $initialValue;
        final /* synthetic */ MutableSharedFlow<Object> $shared;
        final /* synthetic */ Flow<Object> $upstream;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f21470a = null;

            static {
                int[] r10 = new int[SharingCommand.values().length];
                r10[SharingCommand.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r10[SharingCommand.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r10[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f21470a = r10;
            }
        }

        public AnonymousClass2(Flow<Object> r10, MutableSharedFlow<Object> r11, Object r12, Continuation<? super AnonymousClass2> r13) {
            this.$upstream = r10;
            this.$shared = r11;
            this.$initialValue = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(SharingCommand r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L21:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            SharingCommand r13 = (SharingCommand) this.L$0;
            int r14 = a.f21470a[r13.ordinal()];
            if (r14 != 1) goto L11;
            Flow<Object> r15 = this.$upstream;
            MutableSharedFlow<Object> r16 = this.$shared;
            this.label = 1;
            if (r15.collect(r16, this) != r11) goto L21;
            return r11;
        L11:
            if (r14 != 3) goto L21;
            Object r17 = this.$initialValue;
            if (r17 != b1.f21509a) goto L16;
            this.$shared.resetReplayCache();
            goto L21
        L16:
            this.$shared.tryEmit(r17);
            goto L21
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull SharingCommand r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public FlowKt__ShareKt$launchSharing$1(SharingStarted r10, Flow<Object> r11, MutableSharedFlow<Object> r12, Object r13, Continuation<? super FlowKt__ShareKt$launchSharing$1> r14) {
        this.$started = r10;
        this.$upstream = r11;
        this.$shared = r12;
        this.$initialValue = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, r11);
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
        if (r12 == 0) goto L13;
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L11;
        if (r12 == 3) goto L12;
        if (r12 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlin.c.b(r10);
    L23:
        Flow<Object> r13 = this.$upstream;
        MutableSharedFlow<Object> r14 = this.$shared;
        this.label = 3;
        if (r13.collect(r14, this) != r11) goto L30;
        return r11;
    L30:
        return Unit.f21064a;
    L12:
        kotlin.c.b(r10);
        goto L30
    L13:
        kotlin.c.b(r10);
        SharingStarted r15 = this.$started;
        SharingStarted.a r16 = SharingStarted.Companion;
        if (r15 != r16.c()) goto L19;
        Flow<Object> r17 = this.$upstream;
        MutableSharedFlow<Object> r18 = this.$shared;
        this.label = 1;
        if (r17.collect(r18, this) != r11) goto L30;
        return r11;
    L19:
        if (this.$started != r16.d()) goto L26;
        StateFlow<Integer> r19 = this.$shared.getSubscriptionCount();
        AnonymousClass1 r20 = new AnonymousClass1(null);
        this.label = 2;
        if (c.v(r19, r20, this) != r11) goto L23;
        return r11;
    L26:
        Flow r21 = c.n(this.$started.command(this.$shared.getSubscriptionCount()));
        AnonymousClass2 r22 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, null);
        this.label = 4;
        if (c.h(r21, r22, this) != r11) goto L30;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__ShareKt$launchSharing$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
