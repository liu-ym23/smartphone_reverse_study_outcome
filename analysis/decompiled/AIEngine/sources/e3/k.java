package e3;

import com.fasterxml.jackson.core.JsonLocation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8610a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonLocation f8611b;

    /* renamed from: c, reason: collision with root package name */
    public final Class<?> f8612c;

    public k(Object obj, Class<?> cls, JsonLocation jsonLocation) {
        this.f8610a = obj;
        this.f8612c = cls;
        this.f8611b = jsonLocation;
    }

    public final String toString() {
        return String.format("Object id [%s] (for %s) at %s", this.f8610a, com.fasterxml.jackson.databind.util.a.y(this.f8612c), this.f8611b);
    }
}
