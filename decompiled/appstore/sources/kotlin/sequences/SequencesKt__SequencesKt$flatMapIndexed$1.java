package kotlin.sequences;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "C", "R", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", SlideCard.KEY_INDEX}, s = {"L$0", "I$0"})
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Iterator<Object>> $iterator;
    final /* synthetic */ Sequence<Object> $source;
    final /* synthetic */ Function2<Integer, Object, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<Object> r10, Function2<? super Integer, Object, Object> r11, Function1<Object, ? extends Iterator<Object>> r12, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> r13) {
        this.$source = r10;
        this.$transform = r11;
        this.$iterator = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt__SequencesKt$flatMapIndexed$1 r12 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, r11);
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
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        int r13 = this.I$0;
        Iterator<Object> r14 = (Iterator) this.L$1;
        g r15 = (g) this.L$0;
        kotlin.c.b(r10);
        int r16 = r13;
    L10:
        if (r14.hasNext() == false) goto L19;
        Object r17 = r14.next();
        Function2<Integer, Object, Object> r18 = this.$transform;
        int r19 = r16 + 1;
        if (r16 >= 0) goto L14;
        t.q();
    L14:
        Iterator<Object> r20 = this.$iterator.invoke(r18.mo0invoke(tf.a.c(r16), r17));
        this.L$0 = r15;
        this.L$1 = r14;
        this.I$0 = r19;
        this.label = 1;
        if (r15.b(r20, this) == r11) goto L16;
        r16 = r19;
        goto L10
    L16:
        return r11;
    L19:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        r15 = (g) this.L$0;
        r16 = 0;
        r14 = this.$source.iterator();
        goto L10
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
