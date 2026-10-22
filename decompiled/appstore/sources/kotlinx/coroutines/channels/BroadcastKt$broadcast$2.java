package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public BroadcastKt$broadcast$2(ReceiveChannel<Object> r10, Continuation<? super BroadcastKt$broadcast$2> r11) {
        this.$channel = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        BroadcastKt$broadcast$2 r12 = new BroadcastKt$broadcast$2(this.$channel, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:7:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        ChannelIterator<Object> r13 = (ChannelIterator) this.L$1;
        ProducerScope r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L7:
        ProducerScope r15 = r14;
    L12:
        this.L$0 = r15;
        this.L$1 = r13;
        this.label = 1;
        Object r16 = r13.hasNext(this);
        if (r16 != r11) goto L15;
        return r11;
    L15:
        r14 = r15;
        r10 = r16;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        Object r17 = r13.next();
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 2;
        if (r14.send(r17, this) != r11) goto L7;
        return r11;
    L22:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = (ChannelIterator) this.L$1;
        r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L17
    L11:
        kotlin.c.b(r10);
        r15 = (ProducerScope) this.L$0;
        r13 = this.$channel.iterator();
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((BroadcastKt$broadcast$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
