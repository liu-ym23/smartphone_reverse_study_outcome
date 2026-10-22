package kotlin.sequences;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2336, 2341}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", SlideCard.KEY_INDEX}, s = {"L$0", "L$0", "L$1", "I$0"})
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function3<Integer, Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(Object r10, Sequence<Object> r11, Function3<? super Integer, Object, Object, Object> r12, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> r13) {
        this.$initial = r10;
        this.$this_runningFoldIndexed = r11;
        this.$operation = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 r12 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, r11);
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
        if (r12 != 2) goto L8;
        int r13 = this.I$0;
        Iterator<Object> r14 = (Iterator) this.L$2;
        Object r15 = this.L$1;
        g r16 = (g) this.L$0;
        kotlin.c.b(r10);
        Object r17 = r15;
        int r18 = r13;
    L15:
        if (r14.hasNext() == false) goto L24;
        Object r19 = r14.next();
        Function3<Integer, Object, Object, Object> r20 = this.$operation;
        int r21 = r18 + 1;
        if (r18 >= 0) goto L19;
        t.q();
    L19:
        Object r22 = r20.invoke(tf.a.c(r18), r17, r19);
        this.L$0 = r16;
        this.L$1 = r22;
        this.L$2 = r14;
        this.I$0 = r21;
        this.label = 2;
        if (r16.a(r22, this) == r11) goto L21;
        r17 = r22;
        r18 = r21;
        goto L15
    L21:
        return r11;
    L24:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        g r23 = (g) this.L$0;
        kotlin.c.b(r10);
    L13:
        r17 = this.$initial;
        r14 = this.$this_runningFoldIndexed.iterator();
        r18 = 0;
        r16 = r23;
        goto L15
    L10:
        kotlin.c.b(r10);
        r23 = (g) this.L$0;
        Object r24 = this.$initial;
        this.L$0 = r23;
        this.label = 1;
        if (r23.a(r24, this) != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
