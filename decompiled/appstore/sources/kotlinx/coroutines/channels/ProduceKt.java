package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ProduceKt {
    public static final Object a(ProducerScope r10, Function0 r11, Continuation r12) {
        if ((r12 instanceof ProduceKt$awaitClose$1) == false) goto L7;
        ProduceKt$awaitClose$1 r13 = (ProduceKt$awaitClose$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        r11 = (Function0) r13.L$1;
        ProducerScope r18 = (ProducerScope) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
    L25:
        r11.invoke();
        return Unit.f21064a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        if (r13.getContext().get(Job.Key) != r10) goto L30;
        r13.L$0 = r10;     // Catch: Throwable -> L14
        r13.L$1 = r11;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        final n r19 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r13), 1);     // Catch: Throwable -> L14
        r19.initCancellability();     // Catch: Throwable -> L14
        r10.invokeOnClose(new ProduceKt$awaitClose$4$1(r19));     // Catch: Throwable -> L14
        Object r20 = r19.q();     // Catch: Throwable -> L14
        if (r20 != kotlin.coroutines.intrinsics.a.d()) goto L23;
        tf.d.c(r13);     // Catch: Throwable -> L14
    L23:
        if (r20 != r16) goto L25;
        return r16;
    L30:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
    L14:
        th = move-exception;
        r11.invoke();
        throw th;
    L7:
        r13 = new ProduceKt$awaitClose$1(r12);
        goto L8
    }

    public static final ReceiveChannel b(CoroutineScope r10, CoroutineContext r11, int r12, Function2 r13) {
        return c(r10, r11, r12, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r13);
    }

    public static final ReceiveChannel c(CoroutineScope r10, CoroutineContext r11, int r12, BufferOverflow r13, CoroutineStart r14, Function1 r15, Function2 r16) {
        Channel r17 = e.b(r12, r13, null, 4, null);
        j r18 = new j(CoroutineContextKt.e(r10, r11), r17);
        if (r15 == null) goto L5;
        r18.invokeOnCompletion(r15);
    L5:
        r18.q0(r14, r18, r16);
        return r18;
    }

    public static /* synthetic */ ReceiveChannel d(CoroutineScope r10, CoroutineContext r11, int r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = 0;
    L9:
        return b(r10, r11, r12, r13);
    }

    public static /* synthetic */ ReceiveChannel e(CoroutineScope r10, CoroutineContext r11, int r12, BufferOverflow r13, CoroutineStart r14, Function1 r15, Function2 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        r11 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r19 = r11;
        if ((r17 & 2) == 0) goto L8;
        r12 = 0;
    L8:
        int r20 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        BufferOverflow r21 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = CoroutineStart.DEFAULT;
    L14:
        CoroutineStart r22 = r14;
        if ((r17 & 16) == 0) goto L18;
        r15 = null;
    L18:
        return c(r10, r19, r20, r21, r22, r15, r16);
    }
}
