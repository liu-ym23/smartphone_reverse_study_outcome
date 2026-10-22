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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n332#1:480\n332#1:481,6\n332#1:487,2\n332#1:489\n332#1:490,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_map;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<Object> r10, Function2<Object, ? super Continuation<Object>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$map$1> r12) {
        this.$this_map = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$map$1 r12 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c0 -> B:24:0x0075). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L22;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L13;
        ChannelIterator<Object> r13 = (ChannelIterator) this.L$3;
        ReceiveChannel<Object> r14 = (ReceiveChannel) this.L$2;
        Function2<Object, Continuation<Object>, Object> r15 = (Function2) this.L$1;
        ProducerScope r16 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);     // Catch: Throwable -> L10
        ProducerScope r17 = r16;
    L24:
        this.L$0 = r17;     // Catch: Throwable -> L10
        this.L$1 = r15;     // Catch: Throwable -> L10
        this.L$2 = r14;     // Catch: Throwable -> L10
        this.L$3 = r13;     // Catch: Throwable -> L10
        this.label = 1;     // Catch: Throwable -> L10
        Object r18 = r13.hasNext(this);     // Catch: Throwable -> L10
        if (r18 != r10) goto L27;
        return r10;
    L27:
        ProducerScope r19 = r17;
        r12 = r18;
    L29:
        if (((Boolean) r12).booleanValue() == false) goto L38;
        Object r110 = r13.next();     // Catch: Throwable -> L10
        this.L$0 = r19;     // Catch: Throwable -> L10
        this.L$1 = r15;     // Catch: Throwable -> L10
        this.L$2 = r14;     // Catch: Throwable -> L10
        this.L$3 = r13;     // Catch: Throwable -> L10
        this.L$4 = r19;     // Catch: Throwable -> L10
        this.label = 2;     // Catch: Throwable -> L10
        r12 = r15.mo0invoke(r110, this);     // Catch: Throwable -> L10
        if (r12 != r10) goto L33;
        return r10;
    L33:
        ProducerScope r20 = r19;
        Function2<Object, Continuation<Object>, Object> r21 = r15;
        ReceiveChannel<Object> r22 = r14;
        ChannelIterator<Object> r23 = r13;
        ProducerScope r24 = r20;
    L34:
        this.L$0 = r20;     // Catch: Throwable -> L17
        this.L$1 = r21;     // Catch: Throwable -> L17
        this.L$2 = r22;     // Catch: Throwable -> L17
        this.L$3 = r23;     // Catch: Throwable -> L17
        this.L$4 = null;     // Catch: Throwable -> L17
        this.label = 3;     // Catch: Throwable -> L17
        if (r24.send(r12, this) != r10) goto L37;
        return r10;
    L37:
        r13 = r23;
        r14 = r22;
        r15 = r21;
        r17 = r20;
    L17:
        th = th;
        r14 = r22;
    L49:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        h.b(r14, th);
        throw th;
    L38:
        Unit r111 = Unit.f21064a;     // Catch: Throwable -> L10
        h.b(r14, null);
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r24 = (ProducerScope) this.L$4;
        r23 = (ChannelIterator) this.L$3;
        r22 = (ReceiveChannel) this.L$2;
        r21 = (Function2) this.L$1;
        r20 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);     // Catch: Throwable -> L17
        goto L34
    L19:
        r13 = (ChannelIterator) this.L$3;
        r14 = (ReceiveChannel) this.L$2;
        r15 = (Function2) this.L$1;
        r19 = (ProducerScope) this.L$0;
        kotlin.c.b(r12);     // Catch: Throwable -> L10
        goto L29
    L22:
        kotlin.c.b(r12);
        r17 = (ProducerScope) this.L$0;
        r14 = this.$this_map;
        Function2<Object, Continuation<Object>, Object> r25 = this.$transform;
        r15 = r25;
        r13 = r14.iterator();     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L49
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
