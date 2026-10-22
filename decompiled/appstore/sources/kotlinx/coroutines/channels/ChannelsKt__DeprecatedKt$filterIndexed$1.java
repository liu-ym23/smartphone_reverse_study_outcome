package kotlinx.coroutines.channels;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", SlideCard.KEY_INDEX, "$this$produce", "e", SlideCard.KEY_INDEX, "$this$produce", SlideCard.KEY_INDEX}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel r10, Function3 r11, Continuation r12) {
        this.$this_filterIndexed = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 r12 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        int r13 = this.I$0;
        ChannelIterator r14 = (ChannelIterator) this.L$1;
        ProducerScope r15 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
    L13:
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = null;
        this.I$0 = r13;
        this.label = 1;
        r12 = r14.hasNext(this);
        if (r12 != r10) goto L17;
        return r10;
    L17:
        if (((Boolean) r12).booleanValue() == false) goto L29;
        Object r16 = r14.next();
        Function3 r17 = this.$predicate;
        int r18 = r13 + 1;
        Integer r19 = tf.a.c(r13);
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r16;
        this.I$0 = r18;
        this.label = 2;
        Object r20 = r17.invoke(r19, r16, this);
        if (r20 != r10) goto L21;
        return r10;
    L21:
        ProducerScope r21 = r15;
        Object r22 = r16;
        r12 = r20;
        r13 = r18;
    L23:
        if (((Boolean) r12).booleanValue() == false) goto L27;
        this.L$0 = r21;
        this.L$1 = r14;
        this.L$2 = null;
        this.I$0 = r13;
        this.label = 3;
        if (r21.send(r22, this) != r10) goto L27;
        return r10;
    L27:
        r15 = r21;
        goto L13
    L30:
        r15 = r21;
        goto L13
    L29:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = this.I$0;
        Object r23 = this.L$2;
        ChannelIterator r24 = (ChannelIterator) this.L$1;
        r21 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
        r22 = r23;
        r14 = r24;
        goto L23
    L11:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        r15 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
        goto L17
    L12:
        kotlin.c.b(r12);
        r15 = (ProducerScope) this.L$0;
        r14 = this.$this_filterIndexed.iterator();
        r13 = 0;
        goto L13
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
