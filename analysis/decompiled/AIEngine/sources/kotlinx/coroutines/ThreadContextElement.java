package kotlinx.coroutines;

import kotlin.coroutines.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ThreadContextElement<S> extends d.a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static <S, R> R fold(ThreadContextElement<S> threadContextElement, R r, p<? super R, ? super d.a, ? extends R> pVar) {
            return (R) d.a.C0103a.a(threadContextElement, r, pVar);
        }

        public static <S> d plus(ThreadContextElement<S> threadContextElement, d dVar) {
            return d.a.C0103a.d(dVar, threadContextElement);
        }
    }

    void restoreThreadContext(d dVar, S s8);

    S updateThreadContext(d dVar);
}
