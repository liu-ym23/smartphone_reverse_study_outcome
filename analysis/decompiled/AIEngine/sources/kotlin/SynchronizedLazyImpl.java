package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.g;
import lb.d;
import lb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class SynchronizedLazyImpl<T> implements d<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public zb.a<? extends T> f9992a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f9993b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9994c;

    public SynchronizedLazyImpl(zb.a initializer) {
        g.f(initializer, "initializer");
        this.f9992a = initializer;
        this.f9993b = k.f10408a;
        this.f9994c = this;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // lb.d
    public final boolean a() {
        return this.f9993b != k.f10408a;
    }

    @Override // lb.d
    public final T getValue() {
        T tInvoke;
        T t8 = (T) this.f9993b;
        k kVar = k.f10408a;
        if (t8 != kVar) {
            return t8;
        }
        synchronized (this.f9994c) {
            tInvoke = (T) this.f9993b;
            if (tInvoke == kVar) {
                zb.a<? extends T> aVar = this.f9992a;
                g.c(aVar);
                tInvoke = aVar.invoke();
                this.f9993b = tInvoke;
                this.f9992a = null;
            }
        }
        return tInvoke;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
