package androidx.compose.runtime;

import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ*\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H¦@¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MonotonicFrameClock;", "LH7/f;", "R", "Lkotlin/Function1;", "", "onFrame", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MonotonicFrameClock extends H7.f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(MonotonicFrameClock monotonicFrameClock, R r5, n nVar) {
            return (R) z2.l.w(monotonicFrameClock, r5, nVar);
        }

        public static <E extends H7.f> E get(MonotonicFrameClock monotonicFrameClock, H7.g gVar) {
            return (E) z2.l.x(monotonicFrameClock, gVar);
        }

        @Deprecated
        public static H7.g getKey(MonotonicFrameClock monotonicFrameClock) {
            return MonotonicFrameClock.super.getKey();
        }

        public static H7.h minusKey(MonotonicFrameClock monotonicFrameClock, H7.g gVar) {
            return z2.l.C(monotonicFrameClock, gVar);
        }

        public static H7.h plus(MonotonicFrameClock monotonicFrameClock, H7.h hVar) {
            return z2.l.H(monotonicFrameClock, hVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/MonotonicFrameClock$Key;", "LH7/g;", "Landroidx/compose/runtime/MonotonicFrameClock;", AppAgent.CONSTRUCT, "()V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.MonotonicFrameClock$Key, reason: from kotlin metadata */
    public static final class Companion implements H7.g {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Override // H7.h
    /* synthetic */ Object fold(Object obj, n nVar);

    @Override // H7.h
    /* synthetic */ H7.f get(H7.g gVar);

    @Override // H7.f
    default H7.g getKey() {
        return INSTANCE;
    }

    @Override // H7.h
    /* synthetic */ H7.h minusKey(H7.g gVar);

    @Override // H7.h
    /* synthetic */ H7.h plus(H7.h hVar);

    <R> Object withFrameNanos(S7.k kVar, H7.c<? super R> cVar);
}
