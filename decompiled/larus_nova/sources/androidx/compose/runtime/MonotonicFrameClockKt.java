package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086H¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086@¢\u0006\u0002\u0010\f\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086@¢\u0006\u0002\u0010\f\"\u001e\u0010\r\u001a\u00020\u0002*\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"withFrameMillis", "R", "Landroidx/compose/runtime/MonotonicFrameClock;", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeMillis", "(Landroidx/compose/runtime/MonotonicFrameClock;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withFrameNanos", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monotonicFrameClock", "Lkotlin/coroutines/CoroutineContext;", "getMonotonicFrameClock$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getMonotonicFrameClock", "(Lkotlin/coroutines/CoroutineContext;)Landroidx/compose/runtime/MonotonicFrameClock;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MonotonicFrameClockKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2<R> implements Function1<Long, R> {
        final /* synthetic */ Function1<Long, R> $onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Long, ? extends R> r100) {
            this.$onFrame = r100;
        }

        public final R invoke(long r100) {
            return this.$onFrame.invoke(Long.valueOf(r100 / 1000000));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Long r100) {
            return invoke(r100.longValue());
        }
    }

    public static /* synthetic */ void getMonotonicFrameClock$annotations(CoroutineContext r100) {
    }

    public static final MonotonicFrameClock getMonotonicFrameClock(CoroutineContext r100) {
        MonotonicFrameClock r101 = (MonotonicFrameClock) r100.get(MonotonicFrameClock.Key);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.".toString());
    }

    public static final <R> Object withFrameMillis(Function1<? super Long, ? extends R> r100, Continuation<? super R> r101) {
        return getMonotonicFrameClock(r101.getContext()).withFrameNanos(new AnonymousClass2(r100), r101);
    }

    public static final <R> Object withFrameNanos(Function1<? super Long, ? extends R> r100, Continuation<? super R> r101) {
        return getMonotonicFrameClock(r101.getContext()).withFrameNanos(r100, r101);
    }

    public static final <R> Object withFrameMillis(MonotonicFrameClock r100, Function1<? super Long, ? extends R> r101, Continuation<? super R> r102) {
        return r100.withFrameNanos(new AnonymousClass2(r101), r102);
    }

    private static final <R> Object withFrameMillis$$forInline(MonotonicFrameClock r100, Function1<? super Long, ? extends R> r101, Continuation<? super R> r102) {
        AnonymousClass2 r103 = new AnonymousClass2(r101);
        InlineMarker.mark(0);
        Object r104 = r100.withFrameNanos(r103, r102);
        InlineMarker.mark(1);
        return r104;
    }
}
