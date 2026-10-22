package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$drop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$drop$1(int r10, ReceiveChannel r11, Continuation r12) {
        this.$n = r10;
        this.$this_drop = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$drop$1 r12 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:23:0x0068). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a4 -> B:8:0x001c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L13;
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L11;
        if (r12 != 3) goto L10;
        ChannelIterator r13 = (ChannelIterator) this.L$1;
        ProducerScope r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L8:
        ProducerScope r15 = r14;
    L29:
        this.L$0 = r15;
        this.L$1 = r13;
        this.label = 2;
        Object r16 = r13.hasNext(this);
        if (r16 != r11) goto L32;
        return r11;
    L32:
        r14 = r15;
        r10 = r16;
    L34:
        if (((Boolean) r10).booleanValue() == false) goto L39;
        Object r17 = r13.next();
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 3;
        if (r14.send(r17, this) != r11) goto L8;
        return r11;
    L39:
        return Unit.f21064a;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r13 = (ChannelIterator) this.L$1;
        r14 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L34
    L12:
        int r18 = this.I$0;
        ChannelIterator r19 = (ChannelIterator) this.L$1;
        ProducerScope r20 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L24:
        if (((Boolean) r10).booleanValue() == false) goto L27;
        r19.next();
        r18 = r18 - 1;
        if (r18 == 0) goto L27;
    L20:
        this.L$0 = r20;
        this.L$1 = r19;
        this.I$0 = r18;
        this.label = 1;
        r10 = r19.hasNext(this);
        if (r10 != r11) goto L24;
        return r11;
    L27:
        r15 = r20;
    L28:
        r13 = this.$this_drop.iterator();
        goto L29
    L13:
        kotlin.c.b(r10);
        r15 = (ProducerScope) this.L$0;
        r18 = this.$n;
        if (r18 < 0) goto L16;
        boolean r21 = true;
    L17:
        if (r21 == false) goto L41;
        if (r18 <= 0) goto L28;
        r19 = this.$this_drop.iterator();
        r20 = r15;
        goto L20
    L41:
        throw new IllegalArgumentException(("Requested element count " + r18 + " is less than zero.").toString());
    L16:
        r21 = false;
        goto L17
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
