package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EmptyCoroutineContext implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyCoroutineContext f10057a = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f10057a;
    }

    @Override // kotlin.coroutines.d
    public final <R> R fold(R r, p<? super R, ? super d.a, ? extends R> operation) {
        g.f(operation, "operation");
        return r;
    }

    @Override // kotlin.coroutines.d
    public final <E extends d.a> E get(d.b<E> key) {
        g.f(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.d
    public final d minusKey(d.b<?> key) {
        g.f(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.d
    public final d plus(d context) {
        g.f(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
