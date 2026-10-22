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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n468#1:480\n468#1:481,6\n468#1:487,2\n468#1:489\n468#1:490,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $other;
    final /* synthetic */ ReceiveChannel<Object> $this_zip;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<Object> r10, ReceiveChannel<Object> r11, Function2<Object, Object, Object> r12, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> r13) {
        this.$other = r10;
        this.$this_zip = r11;
        this.$transform = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$zip$2 r12 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r13) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L22;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L13;
        ChannelIterator<Object> r12 = (ChannelIterator) this.L$4;
        ReceiveChannel<Object> r14 = (ReceiveChannel) this.L$3;
        Function2<Object, Object, Object> r15 = (Function2) this.L$2;
        ChannelIterator<Object> r16 = (ChannelIterator) this.L$1;
        ProducerScope r17 = (ProducerScope) this.L$0;
        kotlin.c.b(r13);     // Catch: Throwable -> L10
    L24:
        this.L$0 = r17;     // Catch: Throwable -> L10
        this.L$1 = r16;     // Catch: Throwable -> L10
        this.L$2 = r15;     // Catch: Throwable -> L10
        this.L$3 = r14;     // Catch: Throwable -> L10
        this.L$4 = r12;     // Catch: Throwable -> L10
        this.L$5 = null;     // Catch: Throwable -> L10
        this.label = 1;     // Catch: Throwable -> L10
        r13 = r12.hasNext(this);     // Catch: Throwable -> L10
        if (r13 != r10) goto L28;
        return r10;
    L28:
        if (((Boolean) r13).booleanValue() == false) goto L39;
        Object r18 = r12.next();     // Catch: Throwable -> L10
        this.L$0 = r17;     // Catch: Throwable -> L10
        this.L$1 = r16;     // Catch: Throwable -> L10
        this.L$2 = r15;     // Catch: Throwable -> L10
        this.L$3 = r14;     // Catch: Throwable -> L10
        this.L$4 = r12;     // Catch: Throwable -> L10
        this.L$5 = r18;     // Catch: Throwable -> L10
        this.label = 2;     // Catch: Throwable -> L10
        Object r19 = r16.hasNext(this);     // Catch: Throwable -> L10
        if (r19 != r10) goto L32;
        return r10;
    L32:
        ReceiveChannel<Object> r110 = r14;
        Object r20 = r18;
        r13 = r19;
        ProducerScope r111 = r17;
        ChannelIterator<Object> r21 = r16;
        Function2<Object, Object, Object> r22 = r15;
        ReceiveChannel<Object> r23 = r110;
    L33:
        if (((Boolean) r13).booleanValue() == false) goto L38;
        Object r112 = r22.mo0invoke(r20, r21.next());     // Catch: Throwable -> L17
        this.L$0 = r111;     // Catch: Throwable -> L17
        this.L$1 = r21;     // Catch: Throwable -> L17
        this.L$2 = r22;     // Catch: Throwable -> L17
        this.L$3 = r23;     // Catch: Throwable -> L17
        this.L$4 = r12;     // Catch: Throwable -> L17
        this.L$5 = null;     // Catch: Throwable -> L17
        this.label = 3;     // Catch: Throwable -> L17
        if (r111.send(r112, this) != r10) goto L38;
        return r10;
    L38:
        r14 = r23;
        r15 = r22;
        r16 = r21;
        r17 = r111;
        goto L24
    L52:
        r14 = r23;
        r15 = r22;
        r16 = r21;
        r17 = r111;
    L17:
        th = th;
        r14 = r23;
    L48:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        h.b(r14, th);
        throw th;
    L39:
        Unit r113 = Unit.f21064a;     // Catch: Throwable -> L10
        h.b(r14, null);
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        Object r24 = this.L$5;
        ChannelIterator<Object> r25 = (ChannelIterator) this.L$4;
        r23 = (ReceiveChannel) this.L$3;
        r22 = (Function2) this.L$2;
        r21 = (ChannelIterator) this.L$1;
        r111 = (ProducerScope) this.L$0;
        kotlin.c.b(r13);     // Catch: Throwable -> L17
        r20 = r24;
        r12 = r25;
        goto L33
    L19:
        r12 = (ChannelIterator) this.L$4;
        r14 = (ReceiveChannel) this.L$3;
        r15 = (Function2) this.L$2;
        r16 = (ChannelIterator) this.L$1;
        r17 = (ProducerScope) this.L$0;
        kotlin.c.b(r13);     // Catch: Throwable -> L10
        goto L28
    L22:
        kotlin.c.b(r13);
        ProducerScope r114 = (ProducerScope) this.L$0;
        ChannelIterator<Object> r26 = this.$other.iterator();
        r14 = this.$this_zip;
        r15 = this.$transform;
        r17 = r114;
        r16 = r26;
        r12 = r14.iterator();     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L48
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
