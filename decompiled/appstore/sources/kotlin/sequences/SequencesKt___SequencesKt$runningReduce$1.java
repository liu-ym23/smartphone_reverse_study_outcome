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
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"S", "T", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2366, 2369}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public SequencesKt___SequencesKt$runningReduce$1(Sequence<Object> r10, Function2<Object, Object, Object> r11, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> r12) {
        this.$this_runningReduce = r10;
        this.$operation = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt___SequencesKt$runningReduce$1 r12 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Object r13 = this.L$2;
        Iterator<Object> r14 = (Iterator) this.L$1;
        g r15 = (g) this.L$0;
        kotlin.c.b(r10);
    L17:
        if (r14.hasNext() == false) goto L22;
        r13 = this.$operation.mo0invoke(r13, r14.next());
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.label = 2;
        if (r15.a(r13, this) != r11) goto L17;
        return r11;
    L22:
        return Unit.f21064a;
    L10:
        kotlin.c.b(r10);
        r15 = (g) this.L$0;
        Iterator<Object> r16 = this.$this_runningReduce.iterator();
        if (r16.hasNext() == false) goto L22;
        r13 = r16.next();
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r13;
        this.label = 1;
        if (r15.a(r13, this) != r11) goto L15;
        return r11;
    L15:
        r14 = r16;
        goto L17
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
