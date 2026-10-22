package h7;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final e f9366a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9367b;

    public c(e decision, long j10) {
        g.f(decision, "decision");
        this.f9366a = decision;
        this.f9367b = j10;
    }

    public final long a() {
        return this.f9367b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return g.b(this.f9366a, cVar.f9366a) && this.f9367b == cVar.f9367b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9367b) + (this.f9366a.hashCode() * 31);
    }

    public final String toString() {
        return "ExecutionPlan(decision=" + this.f9366a + ", outerTimeoutMs=" + this.f9367b + ")";
    }
}
