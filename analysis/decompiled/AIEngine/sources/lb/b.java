package lb;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<T, R> extends a<T, R> implements qb.b<R> {

    /* renamed from: a, reason: collision with root package name */
    public q<? super a<?, ?>, Object, ? super qb.b<Object>, ? extends Object> f10392a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10393b;

    /* renamed from: c, reason: collision with root package name */
    public qb.b<Object> f10394c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10395d;

    @Override // lb.a
    public final void a(Object obj, qb.b bVar) {
        this.f10394c = bVar;
        this.f10393b = obj;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
    }

    @Override // qb.b
    public final kotlin.coroutines.d getContext() {
        return EmptyCoroutineContext.f10057a;
    }

    @Override // qb.b
    public final void resumeWith(Object obj) {
        this.f10394c = null;
        this.f10395d = obj;
    }
}
