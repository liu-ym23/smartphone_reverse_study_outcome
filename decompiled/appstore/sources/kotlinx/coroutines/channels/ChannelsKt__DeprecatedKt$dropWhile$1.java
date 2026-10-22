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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel r10, Function2 r11, Continuation r12) {
        this.$this_dropWhile = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$dropWhile$1 r12 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009f -> B:16:0x0054). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ec -> B:10:0x0023). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L19;
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L15;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L13;
        if (r11 != 5) goto L12;
        ChannelIterator r13 = (ChannelIterator) this.L$1;
        ProducerScope r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
    L10:
        ChannelIterator r15 = r13;
        ProducerScope r16 = r14;
    L37:
        this.L$0 = r16;
        this.L$1 = r15;
        this.label = 4;
        Object r17 = r15.hasNext(this);
        if (r17 != r10) goto L40;
        return r10;
    L40:
        ProducerScope r18 = r16;
        r13 = r15;
        r12 = r17;
        r14 = r18;
    L42:
        if (((Boolean) r12).booleanValue() == false) goto L47;
        Object r19 = r13.next();
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 5;
        if (r14.send(r19, this) != r10) goto L10;
        return r10;
    L47:
        return Unit.f21064a;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r13 = (ChannelIterator) this.L$1;
        r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
        goto L42
    L14:
        r16 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
    L36:
        r15 = this.$this_dropWhile.iterator();
        goto L37
    L15:
        Object r20 = this.L$2;
        ChannelIterator r21 = (ChannelIterator) this.L$1;
        ProducerScope r22 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
        ChannelIterator r110 = r21;
        Object r23 = r20;
    L16:
        ChannelIterator r24 = r110;
        if (((Boolean) r12).booleanValue() == true) goto L35;
        this.L$0 = r22;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (r22.send(r23, this) != r10) goto L34;
        return r10;
    L34:
        r16 = r22;
        goto L36
    L35:
        ProducerScope r25 = r22;
    L20:
        this.L$0 = r25;
        this.L$1 = r24;
        this.L$2 = null;
        this.label = 1;
        r12 = r24.hasNext(this);
        if (r12 == r10) goto L22;
    L18:
        ProducerScope r111 = r25;
        ChannelIterator r26 = r24;
        r16 = r111;
        if (((Boolean) r12).booleanValue() == false) goto L36;
        Object r112 = r26.next();
        Function2 r27 = this.$predicate;
        this.L$0 = r16;
        this.L$1 = r26;
        this.L$2 = r112;
        this.label = 2;
        Object r28 = r27.mo0invoke(r112, this);
        if (r28 != r10) goto L28;
        return r10;
    L28:
        r110 = r26;
        r23 = r112;
        r12 = r28;
        r22 = r16;
        goto L16
    L22:
        return r10;
    L17:
        r24 = (ChannelIterator) this.L$1;
        r25 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);
        goto L18
    L19:
        kotlin.c.b(r12);
        ProducerScope r113 = (ProducerScope) this.L$0;
        r24 = this.$this_dropWhile.iterator();
        r25 = r113;
        goto L20
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
