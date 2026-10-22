package androidx.compose.runtime;

import androidx.compose.animation.core.AnimationKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\b\"\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"R", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/Function1;", "", "onFrame", "withFrameMillis", "(Landroidx/compose/runtime/MonotonicFrameClock;LS7/k;LH7/c;)Ljava/lang/Object;", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "LH7/h;", "getMonotonicFrameClock", "(LH7/h;)Landroidx/compose/runtime/MonotonicFrameClock;", "getMonotonicFrameClock$annotations", "(LH7/h;)V", "monotonicFrameClock", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MonotonicFrameClockKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2, reason: invalid class name */
    public static final class AnonymousClass2 implements S7.k {
        final /* synthetic */ S7.k $onFrame;

        public AnonymousClass2(S7.k kVar) {
            this.$onFrame = kVar;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [R, java.lang.Object] */
        public final R invoke(long j5) {
            return this.$onFrame.invoke(Long.valueOf(j5 / AnimationKt.MillisToNanos));
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }
    }

    public static final MonotonicFrameClock getMonotonicFrameClock(H7.h hVar) {
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) hVar.get(MonotonicFrameClock.INSTANCE);
        if (monotonicFrameClock != null) {
            return monotonicFrameClock;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getMonotonicFrameClock$annotations(H7.h hVar) {
    }

    public static final <R> Object withFrameMillis(MonotonicFrameClock monotonicFrameClock, S7.k kVar, H7.c<? super R> cVar) {
        return monotonicFrameClock.withFrameNanos(new AnonymousClass2(kVar), cVar);
    }

    public static final <R> Object withFrameNanos(S7.k kVar, H7.c<? super R> cVar) {
        return getMonotonicFrameClock(cVar.getContext()).withFrameNanos(kVar, cVar);
    }

    public static final <R> Object withFrameMillis(S7.k kVar, H7.c<? super R> cVar) {
        return getMonotonicFrameClock(cVar.getContext()).withFrameNanos(new AnonymousClass2(kVar), cVar);
    }
}
