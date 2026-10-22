package kotlin;

import java.io.Serializable;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InitializedLazyImpl<T> implements d<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final T f9982a;

    public InitializedLazyImpl(T t8) {
        this.f9982a = t8;
    }

    @Override // lb.d
    public final boolean a() {
        throw null;
    }

    @Override // lb.d
    public final T getValue() {
        return this.f9982a;
    }

    public final String toString() {
        return String.valueOf(this.f9982a);
    }
}
