package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class ChannelsKt__DeprecatedKt {
    public static final /* synthetic */ Object a(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$any$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$any$1 r12 = (ChannelsKt__DeprecatedKt$any$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r10 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L22:
        h.b(r10, null);
        return r14;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        ChannelIterator r17 = r10.iterator();     // Catch: Throwable -> L14
        r12.L$0 = r10;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        r14 = r17.hasNext(r12);     // Catch: Throwable -> L14
        if (r14 != r15) goto L22;
        return r15;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        h.b(r10, th);
        throw th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$any$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0060). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object b(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$count$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$count$1 r12 = (ChannelsKt__DeprecatedKt$count$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$2;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$1;
        Ref$IntRef r19 = (Ref$IntRef) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r14).booleanValue() == false) goto L28;
        r17.next();     // Catch: Throwable -> L14
        r19.element++;     // Catch: Throwable -> L14
        ReceiveChannel r20 = r18;
    L45:
        r12.L$0 = r19;     // Catch: Throwable -> L31
        r12.L$1 = r20;     // Catch: Throwable -> L31
        r12.L$2 = r17;     // Catch: Throwable -> L31
        r12.label = 1;     // Catch: Throwable -> L31
        Object r21 = r17.hasNext(r12);     // Catch: Throwable -> L31
        if (r21 != r15) goto L24;
        return r15;
    L24:
        r18 = r20;
        r14 = r21;
    L31:
        Throwable th = th;
        r18 = r20;
    L43:
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        h.b(r18, th);
        throw th;
    L28:
        Unit r22 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r18, null);
        return tf.a.c(r19.element);
    L14:
        th = th;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        r19 = new Ref$IntRef();
        r20 = r10;
        r17 = r10.iterator();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$count$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:25:0x0064). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object c(ReceiveChannel r10, int r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$elementAt$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAt$1 r13 = (ChannelsKt__DeprecatedKt$elementAt$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        int r18 = r13.I$1;
        r11 = r13.I$0;
        ChannelIterator r19 = (ChannelIterator) r13.L$1;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L34;
        Object r110 = r19.next();     // Catch: Throwable -> L14
        int r21 = r18 + 1;
        if (r11 != r18) goto L32;
        h.b(r20, null);
        return r110;
    L32:
        ChannelIterator r111 = r19;
        r10 = r20;
        int r22 = r21;
    L21:
        r13.L$0 = r10;     // Catch: Throwable -> L35
        r13.L$1 = r111;     // Catch: Throwable -> L35
        r13.I$0 = r11;     // Catch: Throwable -> L35
        r13.I$1 = r22;     // Catch: Throwable -> L35
        r13.label = 1;     // Catch: Throwable -> L35
        Object r23 = r111.hasNext(r13);     // Catch: Throwable -> L35
        if (r23 != r16) goto L24;
        return r16;
    L24:
        r20 = r10;
        r18 = r22;
        r19 = r111;
        r15 = r23;
        goto L26
    L34:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r11 + '.');     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L43:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        h.b(r20, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        if (r11 < 0) goto L38;
        r111 = r10.iterator();     // Catch: Throwable -> L35
        r22 = 0;
        goto L21
    L38:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r11 + '.');     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r20 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$elementAt$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0064 -> B:27:0x0068). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object d(ReceiveChannel r10, int r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r13 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        int r18 = r13.I$1;
        r11 = r13.I$0;
        ChannelIterator r19 = (ChannelIterator) r13.L$1;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
        int r21 = r18;
        r10 = r20;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r22 = r13;
        ChannelIterator r23 = r19;
    L27:
        if (((Boolean) r15).booleanValue() == false) goto L37;
        Object r110 = r23.next();     // Catch: Throwable -> L35
        int r24 = r21 + 1;
        if (r11 != r21) goto L34;
        h.b(r10, null);
        return r110;
    L34:
        ChannelIterator r111 = r23;
        r13 = r22;
        r21 = r24;
    L23:
        r13.L$0 = r10;     // Catch: Throwable -> L35
        r13.L$1 = r111;     // Catch: Throwable -> L35
        r13.I$0 = r11;     // Catch: Throwable -> L35
        r13.I$1 = r21;     // Catch: Throwable -> L35
        r13.label = 1;     // Catch: Throwable -> L35
        Object r25 = r111.hasNext(r13);     // Catch: Throwable -> L35
        if (r25 != r16) goto L26;
        return r16;
    L26:
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r26 = r13;
        r23 = r111;
        r15 = r25;
        r22 = r26;
        goto L27
    L37:
        h.b(r10, null);
        return null;
    L35:
        th = move-exception;
        r20 = r10;
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        h.b(r20, th);
        throw th;
    L14:
        th = th;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        if (r11 >= 0) goto L43;
        h.b(r10, null);
        return null;
    L43:
        r111 = r10.iterator();     // Catch: Throwable -> L35
        r21 = 0;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object e(ReceiveChannel r10, Collection r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r13 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) r12;
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
        Collection r20 = (Collection) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L31;
        Object r21 = r18.next();     // Catch: Throwable -> L14
        if (r21 == null) goto L30;
        r20.add(r21);     // Catch: Throwable -> L14
    L30:
        Collection r22 = r20;
    L21:
        r13.L$0 = r22;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r23 = r18.hasNext(r13);     // Catch: Throwable -> L14
        if (r23 != r16) goto L24;
        return r16;
    L24:
        r20 = r22;
        r15 = r23;
        goto L26
    L31:
        Unit r24 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r19, null);
        return r20;
    L14:
        Throwable th = th;
    L44:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L34
        r22 = r11;
    L34:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007a -> B:35:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0088 -> B:35:0x008b). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object f(ReceiveChannel r10, SendChannel r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 r13 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        SendChannel r20 = (SendChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
        ?? r21 = r20;
        ?? r22 = r19;
    L35:
        ChannelIterator r23 = r18;
        r10 = r22;
        ?? r24 = r21;
    L24:
        r13.L$0 = r24;     // Catch: Throwable -> L39
        r13.L$1 = r10;     // Catch: Throwable -> L39
        r13.L$2 = r23;     // Catch: Throwable -> L39
        r13.label = 1;     // Catch: Throwable -> L39
        Object r25 = r23.hasNext(r13);     // Catch: Throwable -> L39
        if (r25 != r16) goto L27;
        return r16;
    L27:
        ?? r26 = r24;
        r11 = r10;
        r18 = r23;
        r15 = r25;
        ?? r27 = r26;
    L29:
        if (((Boolean) r15).booleanValue() == false) goto L36;
        Object r28 = r18.next();     // Catch: Throwable -> L15
        r21 = r27;
        r22 = r11;
        if (r28 == null) goto L35;
        r13.L$0 = r27;     // Catch: Throwable -> L15
        r13.L$1 = r11;     // Catch: Throwable -> L15
        r13.L$2 = r18;     // Catch: Throwable -> L15
        r13.label = 2;     // Catch: Throwable -> L15
        Object r29 = r27.send(r28, r13);     // Catch: Throwable -> L15
        r21 = r27;
        r22 = r11;
        if (r29 != r16) goto L35;
        return r16;
    L36:
        Unit r30 = Unit.f21064a;     // Catch: Throwable -> L15
        h.b(r11, null);
        return r27;
    L39:
        th = move-exception;
        r11 = r10;
        th = th;
    L49:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        h.b(r11, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r31 = (ReceiveChannel) r13.L$1;
        SendChannel r32 = (SendChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
        r27 = r32;
        r11 = r31;
        goto L29
    L22:
        kotlin.c.b(r15);
        r23 = r10.iterator();     // Catch: Throwable -> L39
        r10 = r10;
        r24 = r11;
    L15:
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(r12);
        goto L8
    }

    public static final /* synthetic */ Object g(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$first$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$first$1 r12 = (ChannelsKt__DeprecatedKt$first$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L24:
        if (((Boolean) r14).booleanValue() == false) goto L29;
        Object r19 = r17.next();     // Catch: Throwable -> L14
        h.b(r18, null);
        return r19;
    L29:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L36:
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        h.b(r18, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        ChannelIterator r20 = r10.iterator();     // Catch: Throwable -> L30
        r12.L$0 = r10;     // Catch: Throwable -> L30
        r12.L$1 = r20;     // Catch: Throwable -> L30
        r12.label = 1;     // Catch: Throwable -> L30
        Object r21 = r20.hasNext(r12);     // Catch: Throwable -> L30
        if (r21 != r15) goto L22;
        return r15;
    L22:
        r18 = r10;
        r17 = r20;
        r14 = r21;
    L30:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$first$1(r11);
        goto L8
    }

    public static final /* synthetic */ Object h(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$firstOrNull$1 r12 = (ChannelsKt__DeprecatedKt$firstOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) r14).booleanValue() == true) goto L28;
        h.b(r18, null);
        return null;
    L28:
        Object r19 = r17.next();     // Catch: Throwable -> L14
        h.b(r18, null);
        return r19;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        h.b(r18, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        ChannelIterator r20 = r10.iterator();     // Catch: Throwable -> L31
        r12.L$0 = r10;     // Catch: Throwable -> L31
        r12.L$1 = r20;     // Catch: Throwable -> L31
        r12.label = 1;     // Catch: Throwable -> L31
        Object r21 = r20.hasNext(r12);     // Catch: Throwable -> L31
        if (r21 != r15) goto L22;
        return r15;
    L22:
        r18 = r10;
        r17 = r20;
        r14 = r21;
    L31:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$firstOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object i(ReceiveChannel r10, Object r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$indexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$indexOf$1 r13 = (ChannelsKt__DeprecatedKt$indexOf$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$3;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$2;
        Ref$IntRef r20 = (Ref$IntRef) r13.L$1;
        Object r21 = r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == true) goto L28;
        Unit r22 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r19, null);
        return tf.a.c(-1);
    L28:
        if (q.b(r21, r18.next()) == false) goto L32;
        Integer r23 = tf.a.c(r20.element);     // Catch: Throwable -> L14
        h.b(r19, null);
        return r23;
    L32:
        r20.element++;     // Catch: Throwable -> L14
        Object r24 = r21;
    L21:
        r13.L$0 = r24;     // Catch: Throwable -> L14
        r13.L$1 = r20;     // Catch: Throwable -> L14
        r13.L$2 = r19;     // Catch: Throwable -> L14
        r13.L$3 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r25 = r18.hasNext(r13);     // Catch: Throwable -> L14
        if (r25 != r16) goto L24;
        return r16;
    L24:
        r21 = r24;
        r15 = r25;
    L14:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        Ref$IntRef r26 = new Ref$IntRef();
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L36
        r20 = r26;
        r24 = r11;
    L36:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$indexOf$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0087 -> B:37:0x008b). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object j(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$last$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$last$1 r12 = (ChannelsKt__DeprecatedKt$last$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$2;
        ChannelIterator r18 = (ChannelIterator) r12.L$1;
        ReceiveChannel r19 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) r14).booleanValue() == false) goto L41;
        Object r20 = r18.next();     // Catch: Throwable -> L15
        r10 = r19;
    L33:
        r12.L$0 = r10;     // Catch: Throwable -> L43
        r12.L$1 = r18;     // Catch: Throwable -> L43
        r12.L$2 = r20;     // Catch: Throwable -> L43
        r12.label = 2;     // Catch: Throwable -> L43
        Object r21 = r18.hasNext(r12);     // Catch: Throwable -> L43
        if (r21 != r15) goto L36;
        return r15;
    L36:
        r19 = r10;
        r17 = r20;
        r14 = r21;
    L43:
        th = move-exception;
        ReceiveChannel r22 = r10;
        th = th;
    L53:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        h.b(r22, th);
        throw th;
    L41:
        h.b(r19, null);
        return r17;
    L15:
        th = th;
        r22 = r19;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r23 = (ChannelIterator) r12.L$1;
        r22 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == false) goto L46;
        r20 = r23.next();     // Catch: Throwable -> L22
        ReceiveChannel r24 = r22;
        r18 = r23;
        r10 = r24;
        goto L33
    L46:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L53
    L24:
        kotlin.c.b(r14);
        ChannelIterator r25 = r10.iterator();     // Catch: Throwable -> L43
        r12.L$0 = r10;     // Catch: Throwable -> L43
        r12.L$1 = r25;     // Catch: Throwable -> L43
        r12.label = 1;     // Catch: Throwable -> L43
        Object r26 = r25.hasNext(r12);     // Catch: Throwable -> L43
        if (r26 != r15) goto L28;
        return r15;
    L28:
        r22 = r10;
        r23 = r25;
        r14 = r26;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$last$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0072 -> B:25:0x0075). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object k(ReceiveChannel r10, Object r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 r13 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$4;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$3;
        Ref$IntRef r20 = (Ref$IntRef) r13.L$2;
        Ref$IntRef r21 = (Ref$IntRef) r13.L$1;
        Object r22 = r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == true) goto L28;
        Unit r23 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r19, null);
        return tf.a.c(r21.element);
    L28:
        if (q.b(r22, r18.next()) == false) goto L30;
        r21.element = r20.element;     // Catch: Throwable -> L14
    L30:
        r20.element++;     // Catch: Throwable -> L14
        Object r24 = r22;
    L21:
        r13.L$0 = r24;     // Catch: Throwable -> L14
        r13.L$1 = r21;     // Catch: Throwable -> L14
        r13.L$2 = r20;     // Catch: Throwable -> L14
        r13.L$3 = r19;     // Catch: Throwable -> L14
        r13.L$4 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r25 = r18.hasNext(r13);     // Catch: Throwable -> L14
        if (r25 != r16) goto L24;
        return r16;
    L24:
        r22 = r24;
        r15 = r25;
    L14:
        Throwable th = th;
    L40:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        Ref$IntRef r26 = new Ref$IntRef();
        r26.element = -1;
        r20 = new Ref$IntRef();
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L34
        r21 = r26;
        r24 = r11;
    L34:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008b -> B:39:0x008f). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object l(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastOrNull$1 r12 = (ChannelsKt__DeprecatedKt$lastOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$2;
        ChannelIterator r18 = (ChannelIterator) r12.L$1;
        ReceiveChannel r19 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L39:
        if (((Boolean) r14).booleanValue() == false) goto L43;
        Object r20 = r18.next();     // Catch: Throwable -> L15
        r10 = r19;
    L35:
        r12.L$0 = r10;     // Catch: Throwable -> L45
        r12.L$1 = r18;     // Catch: Throwable -> L45
        r12.L$2 = r20;     // Catch: Throwable -> L45
        r12.label = 2;     // Catch: Throwable -> L45
        Object r21 = r18.hasNext(r12);     // Catch: Throwable -> L45
        if (r21 != r15) goto L38;
        return r15;
    L38:
        r19 = r10;
        r17 = r20;
        r14 = r21;
    L45:
        th = move-exception;
        ReceiveChannel r22 = r10;
        th = th;
    L53:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        h.b(r22, th);
        throw th;
    L43:
        h.b(r19, null);
        return r17;
    L15:
        th = th;
        r22 = r19;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r23 = (ChannelIterator) r12.L$1;
        r22 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == true) goto L33;
        h.b(r22, null);
        return null;
    L33:
        r20 = r23.next();     // Catch: Throwable -> L22
        ReceiveChannel r24 = r22;
        r18 = r23;
        r10 = r24;
    L22:
        th = th;
        goto L53
    L24:
        kotlin.c.b(r14);
        ChannelIterator r25 = r10.iterator();     // Catch: Throwable -> L45
        r12.L$0 = r10;     // Catch: Throwable -> L45
        r12.L$1 = r25;     // Catch: Throwable -> L45
        r12.label = 1;     // Catch: Throwable -> L45
        Object r26 = r25.hasNext(r12);     // Catch: Throwable -> L45
        if (r26 != r15) goto L28;
        return r15;
    L28:
        r22 = r10;
        r23 = r25;
        r14 = r26;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$lastOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009f -> B:15:0x003d). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object m(ReceiveChannel r10, Comparator r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$maxWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$maxWith$1 r13 = (ChannelsKt__DeprecatedKt$maxWith$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L25;
        if (r17 == 1) goto L20;
        if (r17 != 2) goto L19;
        Object r18 = r13.L$3;
        ChannelIterator r19 = (ChannelIterator) r13.L$2;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$1;
        Comparator r21 = (Comparator) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$maxWith$1 r22 = r13;
        Object r23 = r18;
        r10 = r20;
    L15:
        ChannelsKt__DeprecatedKt$maxWith$1 r24 = r22;
        if (((Boolean) r15).booleanValue() == false) goto L48;
        Object r110 = r19.next();     // Catch: Throwable -> L46
        if (r21.compare(r23, r110) >= 0) goto L45;
    L44:
        r13 = r24;
    L36:
        r13.L$0 = r21;     // Catch: Throwable -> L46
        r13.L$1 = r10;     // Catch: Throwable -> L46
        r13.L$2 = r19;     // Catch: Throwable -> L46
        r13.L$3 = r110;     // Catch: Throwable -> L46
        r13.label = 2;     // Catch: Throwable -> L46
        Object r25 = r19.hasNext(r13);     // Catch: Throwable -> L46
        if (r25 != r16) goto L39;
        return r16;
    L39:
        r22 = r13;
        r23 = r110;
        r15 = r25;
        goto L15
    L45:
        r110 = r23;
        goto L44
    L48:
        h.b(r10, null);
        return r23;
    L46:
        th = move-exception;
        ReceiveChannel r26 = r10;
        th = th;
    L56:
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        h.b(r26, th);
        throw th;
    L16:
        th = th;
        r26 = r20;
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r27 = (ChannelIterator) r13.L$2;
        r26 = (ReceiveChannel) r13.L$1;
        Comparator r28 = (Comparator) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r15).booleanValue() == true) goto L34;
        h.b(r26, null);
        return null;
    L34:
        r110 = r27.next();     // Catch: Throwable -> L23
        r21 = r28;
        ReceiveChannel r29 = r26;
        r19 = r27;
        r10 = r29;
    L23:
        th = th;
        goto L56
    L25:
        kotlin.c.b(r15);
        ChannelIterator r111 = r10.iterator();     // Catch: Throwable -> L46
        r13.L$0 = r11;     // Catch: Throwable -> L46
        r13.L$1 = r10;     // Catch: Throwable -> L46
        r13.L$2 = r111;     // Catch: Throwable -> L46
        r13.label = 1;     // Catch: Throwable -> L46
        Object r30 = r111.hasNext(r13);     // Catch: Throwable -> L46
        if (r30 != r16) goto L29;
        return r16;
    L29:
        r26 = r10;
        r27 = r111;
        r15 = r30;
        r28 = r11;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$maxWith$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009f -> B:15:0x003d). Please report as a decompilation issue!!! */
    public static final /* synthetic */ Object n(ReceiveChannel r10, Comparator r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$minWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$minWith$1 r13 = (ChannelsKt__DeprecatedKt$minWith$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L25;
        if (r17 == 1) goto L20;
        if (r17 != 2) goto L19;
        Object r18 = r13.L$3;
        ChannelIterator r19 = (ChannelIterator) r13.L$2;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$1;
        Comparator r21 = (Comparator) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$minWith$1 r22 = r13;
        Object r23 = r18;
        r10 = r20;
    L15:
        ChannelsKt__DeprecatedKt$minWith$1 r24 = r22;
        if (((Boolean) r15).booleanValue() == false) goto L48;
        Object r110 = r19.next();     // Catch: Throwable -> L46
        if (r21.compare(r23, r110) <= 0) goto L45;
    L44:
        r13 = r24;
    L36:
        r13.L$0 = r21;     // Catch: Throwable -> L46
        r13.L$1 = r10;     // Catch: Throwable -> L46
        r13.L$2 = r19;     // Catch: Throwable -> L46
        r13.L$3 = r110;     // Catch: Throwable -> L46
        r13.label = 2;     // Catch: Throwable -> L46
        Object r25 = r19.hasNext(r13);     // Catch: Throwable -> L46
        if (r25 != r16) goto L39;
        return r16;
    L39:
        r22 = r13;
        r23 = r110;
        r15 = r25;
        goto L15
    L45:
        r110 = r23;
        goto L44
    L48:
        h.b(r10, null);
        return r23;
    L46:
        th = move-exception;
        ReceiveChannel r26 = r10;
        th = th;
    L56:
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        h.b(r26, th);
        throw th;
    L16:
        th = th;
        r26 = r20;
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r27 = (ChannelIterator) r13.L$2;
        r26 = (ReceiveChannel) r13.L$1;
        Comparator r28 = (Comparator) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r15).booleanValue() == true) goto L34;
        h.b(r26, null);
        return null;
    L34:
        r110 = r27.next();     // Catch: Throwable -> L23
        r21 = r28;
        ReceiveChannel r29 = r26;
        r19 = r27;
        r10 = r29;
    L23:
        th = th;
        goto L56
    L25:
        kotlin.c.b(r15);
        ChannelIterator r111 = r10.iterator();     // Catch: Throwable -> L46
        r13.L$0 = r11;     // Catch: Throwable -> L46
        r13.L$1 = r10;     // Catch: Throwable -> L46
        r13.L$2 = r111;     // Catch: Throwable -> L46
        r13.label = 1;     // Catch: Throwable -> L46
        Object r30 = r111.hasNext(r13);     // Catch: Throwable -> L46
        if (r30 != r16) goto L29;
        return r16;
    L29:
        r26 = r10;
        r27 = r111;
        r15 = r30;
        r28 = r11;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$minWith$1(r12);
        goto L8
    }

    public static final /* synthetic */ Object o(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$none$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$none$1 r12 = (ChannelsKt__DeprecatedKt$none$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r10 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L22:
        Boolean r17 = tf.a.a(!((Boolean) r14).booleanValue());     // Catch: Throwable -> L14
        h.b(r10, null);
        return r17;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        ChannelIterator r18 = r10.iterator();     // Catch: Throwable -> L14
        r12.L$0 = r10;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        r14 = r18.hasNext(r12);     // Catch: Throwable -> L14
        if (r14 != r15) goto L22;
        return r15;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        h.b(r10, th);
        throw th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$none$1(r11);
        goto L8
    }

    public static final /* synthetic */ Object p(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$single$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$single$1 r12 = (ChannelsKt__DeprecatedKt$single$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L36:
        if (((Boolean) r14).booleanValue() == true) goto L40;
        h.b(r18, null);
        return r17;
    L40:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L15
    L15:
        Throwable th = th;
        ReceiveChannel r19 = r18;
    L49:
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r20 = (ChannelIterator) r12.L$1;
        r19 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == false) goto L42;
        Object r21 = r20.next();     // Catch: Throwable -> L22
        r12.L$0 = r19;     // Catch: Throwable -> L22
        r12.L$1 = r21;     // Catch: Throwable -> L22
        r12.label = 2;     // Catch: Throwable -> L22
        Object r22 = r20.hasNext(r12);     // Catch: Throwable -> L22
        if (r22 != r15) goto L34;
        return r15;
    L34:
        r18 = r19;
        r14 = r22;
        r17 = r21;
        goto L36
    L42:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L49
    L24:
        kotlin.c.b(r14);
        ChannelIterator r23 = r10.iterator();     // Catch: Throwable -> L43
        r12.L$0 = r10;     // Catch: Throwable -> L43
        r12.L$1 = r23;     // Catch: Throwable -> L43
        r12.label = 1;     // Catch: Throwable -> L43
        Object r24 = r23.hasNext(r12);     // Catch: Throwable -> L43
        if (r24 != r15) goto L28;
        return r15;
    L28:
        r19 = r10;
        r20 = r23;
        r14 = r24;
    L43:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$single$1(r11);
        goto L8
    }

    public static final /* synthetic */ Object q(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$singleOrNull$1 r12 = (ChannelsKt__DeprecatedKt$singleOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) r14).booleanValue() == false) goto L41;
        h.b(r18, null);
        return null;
    L41:
        h.b(r18, null);
        return r17;
    L15:
        Throwable th = th;
        ReceiveChannel r19 = r18;
    L53:
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r20 = (ChannelIterator) r12.L$1;
        r19 = (ReceiveChannel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == true) goto L33;
        h.b(r19, null);
        return null;
    L33:
        Object r21 = r20.next();     // Catch: Throwable -> L22
        r12.L$0 = r19;     // Catch: Throwable -> L22
        r12.L$1 = r21;     // Catch: Throwable -> L22
        r12.label = 2;     // Catch: Throwable -> L22
        Object r22 = r20.hasNext(r12);     // Catch: Throwable -> L22
        if (r22 != r15) goto L36;
        return r15;
    L36:
        r18 = r19;
        r14 = r22;
        r17 = r21;
    L22:
        th = th;
        goto L53
    L24:
        kotlin.c.b(r14);
        ChannelIterator r23 = r10.iterator();     // Catch: Throwable -> L43
        r12.L$0 = r10;     // Catch: Throwable -> L43
        r12.L$1 = r23;     // Catch: Throwable -> L43
        r12.label = 1;     // Catch: Throwable -> L43
        Object r24 = r23.hasNext(r12);     // Catch: Throwable -> L43
        if (r24 != r15) goto L28;
        return r15;
    L28:
        r19 = r10;
        r20 = r23;
        r14 = r24;
    L43:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$singleOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0088 -> B:14:0x0037). Please report as a decompilation issue!!! */
    public static final Object r(ReceiveChannel r10, SendChannel r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toChannel$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toChannel$1 r13 = (ChannelsKt__DeprecatedKt$toChannel$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        SendChannel r20 = (SendChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
        ?? r21 = r20;
        ?? r22 = r19;
    L14:
        ChannelIterator r23 = r18;
        r10 = r22;
        ?? r24 = r21;
    L24:
        r13.L$0 = r24;     // Catch: Throwable -> L36
        r13.L$1 = r10;     // Catch: Throwable -> L36
        r13.L$2 = r23;     // Catch: Throwable -> L36
        r13.label = 1;     // Catch: Throwable -> L36
        Object r25 = r23.hasNext(r13);     // Catch: Throwable -> L36
        if (r25 != r16) goto L27;
        return r16;
    L27:
        ?? r26 = r24;
        r11 = r10;
        r18 = r23;
        r15 = r25;
        ?? r27 = r26;
    L29:
        if (((Boolean) r15).booleanValue() == false) goto L33;
        Object r28 = r18.next();     // Catch: Throwable -> L15
        r13.L$0 = r27;     // Catch: Throwable -> L15
        r13.L$1 = r11;     // Catch: Throwable -> L15
        r13.L$2 = r18;     // Catch: Throwable -> L15
        r13.label = 2;     // Catch: Throwable -> L15
        Object r29 = r27.send(r28, r13);     // Catch: Throwable -> L15
        r21 = r27;
        r22 = r11;
        if (r29 != r16) goto L14;
        return r16;
    L33:
        Unit r30 = Unit.f21064a;     // Catch: Throwable -> L15
        h.b(r11, null);
        return r27;
    L36:
        th = move-exception;
        r11 = r10;
        th = th;
    L44:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        h.b(r11, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r31 = (ReceiveChannel) r13.L$1;
        SendChannel r32 = (SendChannel) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
        r27 = r32;
        r11 = r31;
        goto L29
    L22:
        kotlin.c.b(r15);
        r23 = r10.iterator();     // Catch: Throwable -> L36
        r10 = r10;
        r24 = r11;
    L15:
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$toChannel$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final Object s(ReceiveChannel r10, Collection r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toCollection$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toCollection$1 r13 = (ChannelsKt__DeprecatedKt$toCollection$1) r12;
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
        Collection r20 = (Collection) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        r20.add(r18.next());     // Catch: Throwable -> L14
        Collection r21 = r20;
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
        h.b(r19, null);
        return r20;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        h.b(r19, th);
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
        r13 = new ChannelsKt__DeprecatedKt$toCollection$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final Object t(ReceiveChannel r10, Map r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toMap$2) == false) goto L7;
        ChannelsKt__DeprecatedKt$toMap$2 r13 = (ChannelsKt__DeprecatedKt$toMap$2) r12;
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
        Map r20 = (Map) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        Pair r21 = (Pair) r18.next();     // Catch: Throwable -> L14
        r20.put(r21.getFirst(), r21.getSecond());     // Catch: Throwable -> L14
        Map r22 = r20;
    L21:
        r13.L$0 = r22;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r23 = r18.hasNext(r13);     // Catch: Throwable -> L14
        if (r23 != r16) goto L24;
        return r16;
    L24:
        r20 = r22;
        r15 = r23;
        goto L26
    L28:
        Unit r24 = Unit.f21064a;     // Catch: Throwable -> L14
        h.b(r19, null);
        return r20;
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        h.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L31
        r22 = r11;
    L31:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$toMap$2(r12);
        goto L8
    }
}
