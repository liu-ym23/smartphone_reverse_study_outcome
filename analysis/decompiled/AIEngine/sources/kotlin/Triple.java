package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Triple<A, B, C> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final A f9995a;

    /* renamed from: b, reason: collision with root package name */
    public final B f9996b;

    /* renamed from: c, reason: collision with root package name */
    public final C f9997c;

    /* JADX WARN: Multi-variable type inference failed */
    public Triple(Object obj, Serializable serializable, Object obj2) {
        this.f9995a = obj;
        this.f9996b = serializable;
        this.f9997c = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return g.b(this.f9995a, triple.f9995a) && g.b(this.f9996b, triple.f9996b) && g.b(this.f9997c, triple.f9997c);
    }

    public final int hashCode() {
        A a10 = this.f9995a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f9996b;
        int iHashCode2 = (iHashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c9 = this.f9997c;
        return iHashCode2 + (c9 != null ? c9.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f9995a + ", " + this.f9996b + ", " + this.f9997c + ')';
    }
}
