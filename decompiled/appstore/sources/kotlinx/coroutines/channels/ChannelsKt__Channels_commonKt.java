package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final void a(ReceiveChannel r10, Throwable r11) {
        CancellationException r12 = null;
        if (r11 != null) goto L5;
    L9:
        r10.cancel(r12);
        return;
    L5:
        if ((r11 instanceof CancellationException) == false) goto L7;
        r12 = (CancellationException) r11;
    L7:
        if (r12 != null) goto L9;
        r12 = v0.a("Channel was consumed, consumer had failed", r11);
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0061 -> B:14:0x0038). Please report as a decompilation issue!!! */
    public static final Object b(BroadcastChannel r10, Function1 r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__Channels_commonKt$consumeEach$3) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$3 r13 = (ChannelsKt__Channels_commonKt$consumeEach$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L19;
        if (r17 != 1) goto L18;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        Function1 r20 = (Function1) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
        ChannelsKt__Channels_commonKt$consumeEach$3 r21 = r13;
        ReceiveChannel r22 = r19;
        r11 = r20;
    L14:
        ChannelsKt__Channels_commonKt$consumeEach$3 r23 = r21;
    L29:
        Throwable th = th;
        r19 = r22;
    L38:
        p.b(1);
        ReceiveChannel.DefaultImpls.a(r19, null, 1, null);
        p.a(1);
        throw th;
    L27:
        if (((Boolean) r15).booleanValue() == false) goto L31;
        r11.invoke(r18.next());     // Catch: Throwable -> L29
        ReceiveChannel r24 = r22;
        r13 = r23;
    L42:
        r13.L$0 = r11;     // Catch: Throwable -> L34
        r13.L$1 = r24;     // Catch: Throwable -> L34
        r13.L$2 = r18;     // Catch: Throwable -> L34
        r13.label = 1;     // Catch: Throwable -> L34
        Object r25 = r18.hasNext(r13);     // Catch: Throwable -> L34
        if (r25 != r16) goto L25;
        return r16;
    L25:
        r21 = r13;
        r22 = r24;
        r15 = r25;
    L34:
        th = th;
        r19 = r24;
        goto L38
    L31:
        Unit r26 = Unit.f21064a;     // Catch: Throwable -> L29
        p.b(1);
        ReceiveChannel.DefaultImpls.a(r22, null, 1, null);
        p.a(1);
        return Unit.f21064a;
    L15:
        th = th;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlin.c.b(r15);
        ReceiveChannel r27 = r10.openSubscription();
        r24 = r27;
        r18 = r27.iterator();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r19 = r27;
        th = th;
    L7:
        r13 = new ChannelsKt__Channels_commonKt$consumeEach$3(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final Object c(ReceiveChannel r10, Function1 r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__Channels_commonKt$consumeEach$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$1 r13 = (ChannelsKt__Channels_commonKt$consumeEach$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        Function1 r20 = (Function1) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        r20.invoke(r18.next());     // Catch: Throwable -> L14
        Function1 r21 = r20;
    L21:
        r13.L$0 = r21;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r22 = r18.hasNext(r13);     // Catch: Throwable -> L14
        if (r22 != r16) goto L24;
        return r16;
    L24:
        r20 = r21;
        r15 = r22;
        goto L26
    L28:
        Unit r23 = Unit.f21064a;     // Catch: Throwable -> L14
        p.b(1);
        h.b(r19, null);
        p.a(1);
        return Unit.f21064a;
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        p.b(1);
        h.b(r19, th);
        p.a(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L31
        r21 = r11;
    L31:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__Channels_commonKt$consumeEach$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    public static final Object d(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__Channels_commonKt$toList$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$toList$1 r12 = (ChannelsKt__Channels_commonKt$toList$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$3;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$2;
        List r19 = (List) r12.L$1;
        List r20 = (List) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r14).booleanValue() == false) goto L28;
        r19.add(r17.next());     // Catch: Throwable -> L14
        ReceiveChannel r21 = r18;
    L39:
        r12.L$0 = r20;     // Catch: Throwable -> L31
        r12.L$1 = r19;     // Catch: Throwable -> L31
        r12.L$2 = r21;     // Catch: Throwable -> L31
        r12.L$3 = r17;     // Catch: Throwable -> L31
        r12.label = 1;     // Catch: Throwable -> L31
        Object r22 = r17.hasNext(r12);     // Catch: Throwable -> L31
        if (r22 != r15) goto L24;
        return r15;
    L24:
        r18 = r21;
        r14 = r22;
    L31:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        h.b(r21, th);
        throw th;
    L28:
        Unit r23 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r18, null);
        return s.a(r20);
    L14:
        th = th;
        r21 = r18;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        List r24 = s.c();
        r19 = r24;
        r20 = r19;
        r21 = r10;
        r17 = r10.iterator();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r21 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__Channels_commonKt$toList$1(r11);
        goto L8
    }
}
