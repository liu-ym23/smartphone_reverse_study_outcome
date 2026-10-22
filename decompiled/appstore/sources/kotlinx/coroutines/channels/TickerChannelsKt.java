package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TickerChannelsKt {
    public static final /* synthetic */ Object a(long r10, long r11, SendChannel r12, Continuation r13) {
        return c(r10, r11, r12, r13);
    }

    public static final /* synthetic */ Object b(long r10, long r11, SendChannel r12, Continuation r13) {
        return d(r10, r11, r12, r13);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    public static final Object c(long r10, long r11, SendChannel r12, Continuation r13) {
        if ((r13 instanceof TickerChannelsKt$fixedDelayTicker$1) == false) goto L7;
        TickerChannelsKt$fixedDelayTicker$1 r14 = (TickerChannelsKt$fixedDelayTicker$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L19;
        if (r18 == 1) goto L18;
        if (r18 == 2) goto L17;
        if (r18 != 3) goto L16;
        r10 = r14.J$0;
        SendChannel r19 = (SendChannel) r14.L$0;
        kotlin.c.b(r16);
    L14:
        r12 = r19;
    L22:
        Unit r20 = Unit.f21064a;
        r14.L$0 = r12;
        r14.J$0 = r10;
        r14.label = 2;
        if (r12.send(r20, r14) != r17) goto L25;
        return r17;
    L25:
        r19 = r12;
    L26:
        r14.L$0 = r19;
        r14.J$0 = r10;
        r14.label = 3;
        if (DelayKt.b(r10, r14) != r17) goto L14;
        return r17;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = r14.J$0;
        r19 = (SendChannel) r14.L$0;
        kotlin.c.b(r16);
        goto L26
    L18:
        r10 = r14.J$0;
        r12 = (SendChannel) r14.L$0;
        kotlin.c.b(r16);
        goto L22
    L19:
        kotlin.c.b(r16);
        r14.L$0 = r12;
        r14.J$0 = r10;
        r14.label = 1;
        if (DelayKt.b(r11, r14) != r17) goto L22;
        return r17;
    L7:
        r14 = new TickerChannelsKt$fixedDelayTicker$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ec -> B:27:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0102 -> B:15:0x003d). Please report as a decompilation issue!!! */
    public static final Object d(long r18, long r20, SendChannel r22, Continuation r23) {
        if ((r23 instanceof TickerChannelsKt$fixedPeriodTicker$1) == false) goto L7;
        TickerChannelsKt$fixedPeriodTicker$1 r10 = (TickerChannelsKt$fixedPeriodTicker$1) r23;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = kotlin.coroutines.intrinsics.a.d();
        int r14 = r10.label;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L20;
        if (r14 == 3) goto L18;
        if (r14 != 4) goto L17;
        long r15 = r10.J$1;
        long r16 = r10.J$0;
        SendChannel r17 = (SendChannel) r10.L$0;
        kotlin.c.b(r12);
        char r19 = 4;
        char r21 = 3;
    L15:
        long r110 = r15;
        long r24 = r16;
        long r25 = r110;
        SendChannel r26 = r17;
    L27:
        long r27 = r24 + r25;
        Unit r28 = Unit.f21064a;
        r10.L$0 = r26;
        r10.J$0 = r27;
        r10.J$1 = r25;
        r10.label = 2;
        if (r26.send(r28, r10) != r13) goto L30;
        return r13;
    L30:
        r17 = r26;
        r15 = r25;
        r16 = r27;
    L31:
        kotlinx.coroutines.c.a();
        long r111 = System.nanoTime();
        long r112 = bg.h.e(r16 - r111, 0);
        if (r112 == 0) goto L34;
    L39:
        r21 = 3;
        long r29 = u0.c(r112);
        r10.L$0 = r17;
        r10.J$0 = r16;
        r10.J$1 = r15;
        r19 = 4;
        r10.label = 4;
        if (DelayKt.b(r29, r10) != r13) goto L15;
        return r13;
    L34:
        if (r15 == 0) goto L39;
        long r30 = r15 - ((r111 - r16) % r15);
        long r31 = r111 + r30;
        long r32 = u0.c(r30);
        r10.L$0 = r17;
        r10.J$0 = r31;
        r10.J$1 = r15;
        char r33 = 3;
        r10.label = 3;
        if (DelayKt.b(r32, r10) == r13) goto L37;
    L19:
        long r113 = r15;
        r24 = r31;
        r25 = r113;
        r26 = r17;
        goto L27
    L37:
        return r13;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r15 = r10.J$1;
        r31 = r10.J$0;
        r17 = (SendChannel) r10.L$0;
        kotlin.c.b(r12);
        r33 = 3;
        goto L19
    L20:
        r15 = r10.J$1;
        r16 = r10.J$0;
        r17 = (SendChannel) r10.L$0;
        kotlin.c.b(r12);
        goto L31
    L21:
        r24 = r10.J$1;
        long r34 = r10.J$0;
        SendChannel r35 = (SendChannel) r10.L$0;
        kotlin.c.b(r12);
        r26 = r35;
        long r114 = r34;
    L26:
        r25 = u0.d(r114);
        goto L27
    L22:
        kotlin.c.b(r12);
        kotlinx.coroutines.c.a();
        long r36 = System.nanoTime() + u0.d(r20);
        r26 = r22;
        r10.L$0 = r26;
        r114 = r18;
        r10.J$0 = r114;
        r10.J$1 = r36;
        r10.label = 1;
        if (DelayKt.b(r20, r10) != r13) goto L25;
        return r13;
    L25:
        r24 = r36;
    L7:
        r10 = new TickerChannelsKt$fixedPeriodTicker$1(r23);
        goto L8
    }

    public static final ReceiveChannel e(long r10, long r11, CoroutineContext r13, TickerMode r14) {
        if (r10 < 0) goto L11;
        if (r11 < 0) goto L9;
        return ProduceKt.b(y0.f21772a, l0.d().plus(r13), 0, new TickerChannelsKt$ticker$3(r14, r10, r11, null));
    L9:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r11 + " ms").toString());
    L11:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r10 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel f(long r10, long r11, CoroutineContext r12, TickerMode r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = r10;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = EmptyCoroutineContext.INSTANCE;
    L9:
        if ((r14 & 8) == 0) goto L12;
        r13 = TickerMode.FIXED_PERIOD;
    L12:
        return e(r10, r11, r12, r13);
    }
}
