package i7;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9552a;

    public b(String text) {
        g.f(text, "text");
        this.f9552a = text;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && g.b(this.f9552a, ((b) obj).f9552a);
    }

    public final int hashCode() {
        return this.f9552a.hashCode();
    }

    public final String toString() {
        return a0.a.k("StreamTextChunk(text=", this.f9552a, ")");
    }
}
