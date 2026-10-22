package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,222:1\n*E\n"})
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_transform;
    final /* synthetic */ Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f21443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f21444b;

        public AnonymousClass1(Function3 r10, FlowCollector r11) {
            this.f21443a = r10;
            this.f21444b = r11;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            if ((r11 instanceof FlowKt__EmittersKt$transform$1$1$emit$1) == false) goto L7;
            FlowKt__EmittersKt$transform$1$1$emit$1 r12 = (FlowKt__EmittersKt$transform$1$1$emit$1) r11;
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
        L18:
            return Unit.f21064a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r14);
            Function3 r17 = this.f21443a;
            FlowCollector r18 = this.f21444b;
            r12.label = 1;
            if (r17.invoke(r18, r10, r12) != r15) goto L18;
            return r15;
        L7:
            r12 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, r11);
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(Flow<Object> r10, Function3<? super FlowCollector<Object>, Object, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super FlowKt__EmittersKt$transform$1> r12) {
        this.$this_transform = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__EmittersKt$transform$1 r12 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(FlowCollector<Object> r10, Continuation<? super Unit> r11) {
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
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        FlowCollector r13 = (FlowCollector) this.L$0;
        Flow<Object> r14 = this.$this_transform;
        AnonymousClass1 r15 = new AnonymousClass1(this.$transform, r13);
        this.label = 1;
        if (r14.collect(r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object r10) {
        FlowCollector r11 = (FlowCollector) this.L$0;
        Flow<Object> r12 = this.$this_transform;
        AnonymousClass1 r13 = new AnonymousClass1(this.$transform, r11);
        kotlin.jvm.internal.p.c(0);
        r12.collect(r13, this);
        kotlin.jvm.internal.p.c(1);
        return Unit.f21064a;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__EmittersKt$transform$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
