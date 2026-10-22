package kotlinx.coroutines;

import fc.i;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import lb.n;
import qb.b;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface Job extends d.a {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        public static <R> R fold(Job job, R r, p<? super R, ? super d.a, ? extends R> pVar) {
            return (R) d.a.C0103a.a(job, r, pVar);
        }

        public static <E extends d.a> E get(Job job, d.b<E> bVar) {
            return (E) d.a.C0103a.b(job, bVar);
        }

        public static d minusKey(Job job, d.b<?> bVar) {
            return d.a.C0103a.c(job, bVar);
        }

        public static d plus(Job job, d dVar) {
            return d.a.C0103a.d(dVar, job);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key implements d.b<Job> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    ChildHandle attachChild(ChildJob childJob);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    i<Job> getChildren();

    DisposableHandle invokeOnCompletion(l<? super Throwable, n> lVar);

    DisposableHandle invokeOnCompletion(boolean z, boolean z3, l<? super Throwable, n> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(b<? super n> bVar);

    boolean start();
}
