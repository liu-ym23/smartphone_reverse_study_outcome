package retrofit2;

import ad.b;
import ad.t;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CancellableContinuationImpl;
import lb.n;
import xd.f;
import xd.j;
import xd.q;
import xd.u;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<ResponseT, ReturnT> extends u<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    public final q f11811a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f11812b;

    /* renamed from: c, reason: collision with root package name */
    public final f<t, ResponseT> f11813c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: retrofit2.a$a, reason: collision with other inner class name */
    public static final class C0136a<ResponseT, ReturnT> extends a<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        public final xd.c<ResponseT, ReturnT> f11814d;

        public C0136a(q qVar, b.a aVar, f<t, ResponseT> fVar, xd.c<ResponseT, ReturnT> cVar) {
            super(qVar, aVar, fVar);
            this.f11814d = cVar;
        }

        @Override // retrofit2.a
        public final Object c(j jVar, Object[] objArr) {
            return this.f11814d.b(jVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b<ResponseT> extends a<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final xd.c<ResponseT, xd.b<ResponseT>> f11815d;

        public b(q qVar, b.a aVar, f fVar, xd.c cVar) {
            super(qVar, aVar, fVar);
            this.f11815d = cVar;
        }

        @Override // retrofit2.a
        public final Object c(j jVar, Object[] objArr) {
            final xd.b bVar = (xd.b) this.f11815d.b(jVar);
            qb.b bVar2 = (qb.b) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar2), 1);
                cancellableContinuationImpl.invokeOnCancellation(new l<Throwable, n>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
                    {
                        super(1);
                    }

                    @Override // zb.l
                    public final n invoke(Throwable th) {
                        bVar.cancel();
                        return n.f10413a;
                    }
                });
                bVar.K(new n8.c(cancellableContinuationImpl, 2));
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                return result;
            } catch (Exception e10) {
                return KotlinExtensions.a(e10, bVar2);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<ResponseT> extends a<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final xd.c<ResponseT, xd.b<ResponseT>> f11816d;

        public c(q qVar, b.a aVar, f<t, ResponseT> fVar, xd.c<ResponseT, xd.b<ResponseT>> cVar) {
            super(qVar, aVar, fVar);
            this.f11816d = cVar;
        }

        @Override // retrofit2.a
        public final Object c(j jVar, Object[] objArr) {
            final xd.b bVar = (xd.b) this.f11816d.b(jVar);
            qb.b bVar2 = (qb.b) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar2), 1);
                cancellableContinuationImpl.invokeOnCancellation(new l<Throwable, n>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
                    {
                        super(1);
                    }

                    @Override // zb.l
                    public final n invoke(Throwable th) {
                        bVar.cancel();
                        return n.f10413a;
                    }
                });
                bVar.K(new stepos.support.v7.app.palette.b(cancellableContinuationImpl, 13));
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                return result;
            } catch (Exception e10) {
                return KotlinExtensions.a(e10, bVar2);
            }
        }
    }

    public a(q qVar, b.a aVar, f<t, ResponseT> fVar) {
        this.f11811a = qVar;
        this.f11812b = aVar;
        this.f11813c = fVar;
    }

    @Override // xd.u
    public final ReturnT a(Object[] objArr) {
        return (ReturnT) c(new j(this.f11811a, objArr, this.f11812b, this.f11813c), objArr);
    }

    public abstract Object c(j jVar, Object[] objArr);
}
