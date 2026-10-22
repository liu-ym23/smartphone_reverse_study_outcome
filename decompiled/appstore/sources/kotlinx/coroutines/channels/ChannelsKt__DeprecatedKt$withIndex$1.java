package kotlinx.coroutines.channels;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.f0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/f0;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", SlideCard.KEY_INDEX, "$this$produce", SlideCard.KEY_INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel r10, Continuation r11) {
        this.$this_withIndex = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$withIndex$1 r12 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007b -> B:11:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        int r13 = this.I$0;
        ChannelIterator r14 = (ChannelIterator) this.L$1;
        ProducerScope r15 = (ProducerScope) this.L$0;
        kotlin.c.b(r11);
        ProducerScope r16 = r15;
        int r17 = r13;
        ChannelIterator r18 = r14;
    L11:
        this.L$0 = r16;
        this.L$1 = r18;
        this.I$0 = r17;
        this.label = 1;
        Object r19 = r18.hasNext(this);
        if (r19 != r10) goto L14;
        return r10;
    L14:
        ProducerScope r20 = r16;
        r11 = r19;
        int r21 = r17;
        ChannelIterator r22 = r18;
        int r23 = r21;
    L16:
        if (((Boolean) r11).booleanValue() == false) goto L22;
        int r24 = r23 + 1;
        f0 r25 = new f0(r23, r22.next());
        this.L$0 = r20;
        this.L$1 = r22;
        this.I$0 = r24;
        this.label = 2;
        if (r20.send(r25, this) != r10) goto L20;
        return r10;
    L20:
        r18 = r22;
        r16 = r20;
        r17 = r24;
        goto L11
    L22:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r23 = this.I$0;
        r22 = (ChannelIterator) this.L$1;
        r20 = (ProducerScope) this.L$0;
        kotlin.c.b(r11);
        goto L16
    L10:
        kotlin.c.b(r11);
        r16 = (ProducerScope) this.L$0;
        r18 = this.$this_withIndex.iterator();
        r17 = 0;
        goto L11
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
