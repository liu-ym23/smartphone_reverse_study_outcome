package kotlin.coroutines;

import kotlin.coroutines.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c extends d.a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements d.b<c> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10058a = new a();
    }

    <T> qb.b<T> interceptContinuation(qb.b<? super T> bVar);

    void releaseInterceptedContinuation(qb.b<?> bVar);
}
