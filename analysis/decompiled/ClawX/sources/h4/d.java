package h4;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final w4.a f3020a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3021b;

    public d(w4.a expectedType, Object response) {
        p.e(expectedType, "expectedType");
        p.e(response, "response");
        this.f3020a = expectedType;
        this.f3021b = response;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return p.a(this.f3020a, dVar.f3020a) && p.a(this.f3021b, dVar.f3021b);
    }

    public final int hashCode() {
        return this.f3021b.hashCode() + (this.f3020a.hashCode() * 31);
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.f3020a + ", response=" + this.f3021b + ')';
    }
}
