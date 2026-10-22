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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
public final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21358a = null;

        static {
            int[] r10 = new int[TickerMode.values().length];
            r10[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f21358a = r10;
        }
    }

    public TickerChannelsKt$ticker$3(TickerMode r10, long r11, long r12, Continuation<? super TickerChannelsKt$ticker$3> r13) {
        this.$mode = r10;
        this.$delayMillis = r11;
        this.$initialDelayMillis = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        TickerChannelsKt$ticker$3 r12 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 == 1) goto L6;
        if (r12 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        kotlin.c.b(r11);
    L20:
        return Unit.f21064a;
    L9:
        kotlin.c.b(r11);
        ProducerScope r13 = (ProducerScope) this.L$0;
        TickerMode r14 = this.$mode;
        int r15 = a.f21358a[r14.ordinal()];
        if (r15 == 1) goto L16;
        if (r15 != 2) goto L20;
        long r16 = this.$delayMillis;
        long r17 = this.$initialDelayMillis;
        SendChannel r18 = r13.getChannel();
        this.label = 2;
        if (TickerChannelsKt.a(r16, r17, r18, this) != r10) goto L20;
        return r10;
    L16:
        long r19 = this.$delayMillis;
        long r20 = this.$initialDelayMillis;
        SendChannel r110 = r13.getChannel();
        this.label = 1;
        if (TickerChannelsKt.b(r19, r20, r110, this) != r10) goto L20;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Unit> r10, @Nullable Continuation<? super Unit> r11) {
        return ((TickerChannelsKt$ticker$3) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
