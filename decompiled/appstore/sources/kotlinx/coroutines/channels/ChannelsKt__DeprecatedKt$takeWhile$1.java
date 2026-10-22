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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel r10, Function2 r11, Continuation r12) {
        this.$this_takeWhile = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$takeWhile$1 r12 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0097 -> B:13:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        ChannelIterator r13 = (ChannelIterator) this.L$1;
        ProducerScope r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L13:
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 1;
        r10 = r13.hasNext(this);
        if (r10 != r11) goto L17;
        return r11;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L31;
        Object r15 = r13.next();
        Function2 r16 = this.$predicate;
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r15;
        this.label = 2;
        Object r17 = r16.mo0invoke(r15, this);
        if (r17 != r11) goto L21;
        return r11;
    L21:
        ChannelIterator r18 = r13;
        Object r19 = r15;
        r10 = r17;
        ProducerScope r20 = r14;
        ChannelIterator r21 = r18;
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L25;
        this.L$0 = r20;
        this.L$1 = r21;
        this.L$2 = null;
        this.label = 3;
        if (r20.send(r19, this) != r11) goto L29;
        return r11;
    L29:
        r13 = r21;
        r14 = r20;
        goto L13
    L25:
        return Unit.f21064a;
    L31:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r19 = this.L$2;
        r21 = (ChannelIterator) this.L$1;
        r20 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L23
    L11:
        r13 = (ChannelIterator) this.L$1;
        r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L17
    L12:
        kotlin.c.b(r10);
        ProducerScope r22 = (ProducerScope) this.L$0;
        r13 = this.$this_takeWhile.iterator();
        r14 = r22;
        goto L13
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
