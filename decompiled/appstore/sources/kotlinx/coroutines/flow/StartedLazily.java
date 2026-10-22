package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StartedLazily implements SharingStarted {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
        final /* synthetic */ StateFlow<Integer> $subscriptionCount;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02951 implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f21501a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f21502b;

            public C02951(Ref$BooleanRef r10, FlowCollector r11) {
                this.f21501a = r10;
                this.f21502b = r11;
            }

            public final Object a(int r10, Continuation r11) {
                if ((r11 instanceof StartedLazily$command$1$1$emit$1) == false) goto L7;
                StartedLazily$command$1$1$emit$1 r12 = (StartedLazily$command$1$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = kotlin.coroutines.intrinsics.a.d();
                int r16 = r12.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                kotlin.c.b(r14);
            L22:
                return Unit.f21064a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                kotlin.c.b(r14);
                if (r10 <= 0) goto L24;
                Ref$BooleanRef r17 = this.f21501a;
                if (r17.element == true) goto L24;
                r17.element = true;
                FlowCollector r18 = this.f21502b;
                SharingCommand r19 = SharingCommand.START;
                r12.label = 1;
                if (r18.emit(r19, r12) != r15) goto L22;
                return r15;
            L24:
                return Unit.f21064a;
            L7:
                r12 = new StartedLazily$command$1$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Number) r10).intValue(), r11);
            }
        }

        public AnonymousClass1(StateFlow<Integer> r10, Continuation<? super AnonymousClass1> r11) {
            this.$subscriptionCount = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$subscriptionCount, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(FlowCollector<? super SharingCommand> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            kotlin.c.b(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            FlowCollector r13 = (FlowCollector) this.L$0;
            Ref$BooleanRef r14 = new Ref$BooleanRef();
            StateFlow<Integer> r15 = this.$subscriptionCount;
            C02951 r16 = new C02951(r14, r13);
            this.label = 1;
            if (r15.collect(r16, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull FlowCollector<? super SharingCommand> r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public StartedLazily() {
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow r10) {
        return c.A(new AnonymousClass1(r10, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
