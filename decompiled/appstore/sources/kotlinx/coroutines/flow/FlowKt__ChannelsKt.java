package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__ChannelsKt {
    public static final /* synthetic */ Object a(FlowCollector r10, ReceiveChannel r11, boolean r12, Continuation r13) {
        return c(r10, r11, r12, r13);
    }

    public static final Object b(FlowCollector r10, ReceiveChannel r11, Continuation r12) {
        Object r13 = c(r10, r11, true, r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public static final Object c(FlowCollector r10, ReceiveChannel r11, boolean r12, Continuation r13) {
        if ((r13 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r14 = (FlowKt__ChannelsKt$emitAllImpl$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L19;
        if (r18 != 2) goto L18;
        r12 = r14.Z$0;
        ChannelIterator r19 = (ChannelIterator) r14.L$2;
        r11 = (ReceiveChannel) r14.L$1;
        FlowCollector r20 = (FlowCollector) r14.L$0;
        kotlin.c.b(r16);     // Catch: Throwable -> L15
    L14:
        ChannelIterator r21 = r19;
        r10 = r20;
    L24:
        r14.L$0 = r10;     // Catch: Throwable -> L15
        r14.L$1 = r11;     // Catch: Throwable -> L15
        r14.L$2 = r21;     // Catch: Throwable -> L15
        r14.Z$0 = r12;     // Catch: Throwable -> L15
        r14.label = 1;     // Catch: Throwable -> L15
        Object r22 = r21.hasNext(r14);     // Catch: Throwable -> L15
        if (r22 != r17) goto L27;
        return r17;
    L27:
        r20 = r10;
        r19 = r21;
        r16 = r22;
    L29:
        if (((Boolean) r16).booleanValue() == false) goto L33;
        Object r23 = r19.next();     // Catch: Throwable -> L15
        r14.L$0 = r20;     // Catch: Throwable -> L15
        r14.L$1 = r11;     // Catch: Throwable -> L15
        r14.L$2 = r19;     // Catch: Throwable -> L15
        r14.Z$0 = r12;     // Catch: Throwable -> L15
        r14.label = 2;     // Catch: Throwable -> L15
        if (r20.emit(r23, r14) != r17) goto L14;
        return r17;
    L33:
        if (r12 == false) goto L36;
        kotlinx.coroutines.channels.h.b(r11, null);
    L36:
        return Unit.f21064a;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r12 = r14.Z$0;
        r19 = (ChannelIterator) r14.L$2;
        r11 = (ReceiveChannel) r14.L$1;
        r20 = (FlowCollector) r14.L$0;
        kotlin.c.b(r16);     // Catch: Throwable -> L15
        goto L29
    L22:
        kotlin.c.b(r16);
        c.s(r10);
        r21 = r11.iterator();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r12 == false) goto L41;
        kotlinx.coroutines.channels.h.b(r11, th);
    L41:
        throw th;
    L7:
        r14 = new FlowKt__ChannelsKt$emitAllImpl$1(r13);
        goto L8
    }

    public static final ReceiveChannel d(Flow r10, CoroutineScope r11) {
        return kotlinx.coroutines.flow.internal.d.b(r10).h(r11);
    }
}
