package androidx.compose.ui.platform;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ4\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H¦@¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "LH7/f;", "R", "Lkotlin/Function1;", "LH7/c;", "", "block", "onInfiniteOperation", "(LS7/k;LH7/c;)Ljava/lang/Object;", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface InfiniteAnimationPolicy extends H7.f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(InfiniteAnimationPolicy infiniteAnimationPolicy, R r5, S7.n nVar) {
            return (R) z2.l.w(infiniteAnimationPolicy, r5, nVar);
        }

        public static <E extends H7.f> E get(InfiniteAnimationPolicy infiniteAnimationPolicy, H7.g gVar) {
            return (E) z2.l.x(infiniteAnimationPolicy, gVar);
        }

        @Deprecated
        public static H7.g getKey(InfiniteAnimationPolicy infiniteAnimationPolicy) {
            return InfiniteAnimationPolicy.super.getKey();
        }

        public static H7.h minusKey(InfiniteAnimationPolicy infiniteAnimationPolicy, H7.g gVar) {
            return z2.l.C(infiniteAnimationPolicy, gVar);
        }

        public static H7.h plus(InfiniteAnimationPolicy infiniteAnimationPolicy, H7.h hVar) {
            return z2.l.H(infiniteAnimationPolicy, hVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "LH7/g;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", AppAgent.CONSTRUCT, "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.platform.InfiniteAnimationPolicy$Key, reason: from kotlin metadata */
    public static final class Companion implements H7.g {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Override // H7.h
    /* synthetic */ Object fold(Object obj, S7.n nVar);

    @Override // H7.h
    /* synthetic */ H7.f get(H7.g gVar);

    @Override // H7.f
    default H7.g getKey() {
        return INSTANCE;
    }

    @Override // H7.h
    /* synthetic */ H7.h minusKey(H7.g gVar);

    <R> Object onInfiniteOperation(S7.k kVar, H7.c<? super R> cVar);

    @Override // H7.h
    /* synthetic */ H7.h plus(H7.h hVar);
}
