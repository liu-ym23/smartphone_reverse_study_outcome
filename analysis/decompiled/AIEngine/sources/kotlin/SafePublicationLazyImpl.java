package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lb.d;
import lb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class SafePublicationLazyImpl<T> implements d<T>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f9989c = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    public volatile zb.a<? extends T> f9990a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f9991b;

    public SafePublicationLazyImpl() {
        throw null;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // lb.d
    public final boolean a() {
        return this.f9991b != k.f10408a;
    }

    @Override // lb.d
    public final T getValue() {
        T t8 = (T) this.f9991b;
        k kVar = k.f10408a;
        if (t8 != kVar) {
            return t8;
        }
        zb.a<? extends T> aVar = this.f9990a;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> atomicReferenceFieldUpdater = f9989c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, kVar, tInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != kVar) {
                }
            }
            this.f9990a = null;
            return tInvoke;
        }
        return (T) this.f9991b;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
