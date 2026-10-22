package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Pair<A, B> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final A f9985a;

    /* renamed from: b, reason: collision with root package name */
    public final B f9986b;

    public Pair(A a10, B b10) {
        this.f9985a = a10;
        this.f9986b = b10;
    }

    public final A a() {
        return this.f9985a;
    }

    public final B b() {
        return this.f9986b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return g.b(this.f9985a, pair.f9985a) && g.b(this.f9986b, pair.f9986b);
    }

    public final int hashCode() {
        A a10 = this.f9985a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f9986b;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f9985a + ", " + this.f9986b + ')';
    }
}
