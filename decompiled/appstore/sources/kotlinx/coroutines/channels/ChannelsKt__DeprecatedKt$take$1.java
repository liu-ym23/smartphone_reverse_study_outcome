package kotlinx.coroutines.channels;

import com.ttnet.org.chromium.net.PrivateKeyType;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, PrivateKeyType.INVALID}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$take$1(int r10, ReceiveChannel r11, Continuation r12) {
        this.$n = r10;
        this.$this_take = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$take$1 r12 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
        return invoke((ProducerScope) r10, (Continuation) r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:7:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        int r13 = this.I$0;
        ChannelIterator r14 = (ChannelIterator) this.L$1;
        ProducerScope r15 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L7:
        ProducerScope r16 = r15;
        r13 = r13 - 1;
        if (r13 == 0) goto L32;
    L20:
        this.L$0 = r16;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 1;
        Object r17 = r14.hasNext(this);
        if (r17 != r11) goto L23;
        return r11;
    L23:
        r15 = r16;
        r10 = r17;
    L25:
        if (((Boolean) r10).booleanValue() == false) goto L34;
        Object r18 = r14.next();
        this.L$0 = r15;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 2;
        if (r15.send(r18, this) != r11) goto L7;
        return r11;
    L34:
        return Unit.f21064a;
    L32:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        r15 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L25
    L11:
        kotlin.c.b(r10);
        r16 = (ProducerScope) this.L$0;
        r13 = this.$n;
        if (r13 == 0) goto L14;
        if (r13 < 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == false) goto L36;
        r14 = this.$this_take.iterator();
        goto L20
    L36:
        throw new IllegalArgumentException(("Requested element count " + r13 + " is less than zero.").toString());
    L17:
        r19 = false;
        goto L18
    L14:
        return Unit.f21064a;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope r10, @Nullable Continuation r11) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
