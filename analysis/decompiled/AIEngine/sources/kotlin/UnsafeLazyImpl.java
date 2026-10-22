package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.g;
import lb.d;
import lb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UnsafeLazyImpl<T> implements d<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public zb.a<? extends T> f9998a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9999b;

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // lb.d
    public final boolean a() {
        return this.f9999b != k.f10408a;
    }

    @Override // lb.d
    public final T getValue() {
        if (this.f9999b == k.f10408a) {
            zb.a<? extends T> aVar = this.f9998a;
            g.c(aVar);
            this.f9999b = aVar.invoke();
            this.f9998a = null;
        }
        return (T) this.f9999b;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
