package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"runBlocking", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class BuildersKt__BuildersKt {
    public static /* synthetic */ Object runBlocking$default(EmptyCoroutineContext r0, Function2 r1, int r2, Object r3) throws InterruptedException {
        if ((r2 & 1) == 0) goto L6;
        r0 = EmptyCoroutineContext.INSTANCE;
    L6:
        return BuildersKt.runBlocking(r0, r1);
    }

    public static final <T> T runBlocking(CoroutineContext r4, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r5) throws InterruptedException {
        Thread r0 = Thread.currentThread();
        ContinuationInterceptor r1 = (ContinuationInterceptor) r4.get(ContinuationInterceptor.Key);
        if (r1 != null) goto L5;
        EventLoop r2 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        CoroutineContext r6 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, r4.plus(r2));
    L18:
        BlockingCoroutine r3 = new BlockingCoroutine(r6, r0, r2);
        r3.start(CoroutineStart.DEFAULT, r3, r5);
        return (T) r3.joinBlocking();
    L5:
        EventLoop r7 = null;
        if ((r1 instanceof EventLoop) == false) goto L8;
        EventLoop r8 = (EventLoop) r1;
    L9:
        if (r8 != null) goto L11;
    L16:
        r2 = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
    L17:
        r6 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, r4);
        goto L18
    L11:
        if (r8.shouldBeProcessedFromContext() == false) goto L13;
        r7 = r8;
    L13:
        if (r7 == null) goto L16;
        r2 = r7;
        goto L17
    L8:
        r8 = null;
        goto L9
    }
}
