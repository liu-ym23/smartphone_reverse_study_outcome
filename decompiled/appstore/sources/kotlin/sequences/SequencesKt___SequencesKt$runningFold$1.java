package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2308, 2312}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public SequencesKt___SequencesKt$runningFold$1(Object r10, Sequence<Object> r11, Function2<Object, Object, Object> r12, Continuation<? super SequencesKt___SequencesKt$runningFold$1> r13) {
        this.$initial = r10;
        this.$this_runningFold = r11;
        this.$operation = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt___SequencesKt$runningFold$1 r12 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0068 -> B:7:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        Iterator<Object> r13 = (Iterator) this.L$2;
        Object r14 = this.L$1;
        g r15 = (g) this.L$0;
        kotlin.c.b(r10);
    L7:
        Object r16 = r14;
    L16:
        if (r13.hasNext() == false) goto L21;
        Object r17 = r13.next();
        r14 = this.$operation.mo0invoke(r16, r17);
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.label = 2;
        if (r15.a(r14, this) != r11) goto L7;
        return r11;
    L21:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        g r18 = (g) this.L$0;
        kotlin.c.b(r10);
    L14:
        r16 = this.$initial;
        r15 = r18;
        r13 = this.$this_runningFold.iterator();
        goto L16
    L11:
        kotlin.c.b(r10);
        r18 = (g) this.L$0;
        Object r19 = this.$initial;
        this.L$0 = r18;
        this.label = 1;
        if (r18.a(r19, this) != r11) goto L14;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
