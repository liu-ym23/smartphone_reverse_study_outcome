package Ea;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class g extends h {

    /* renamed from: a, reason: collision with root package name */
    public final String f505a;

    public g(String str) {
        this.f505a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && k.b(this.f505a, ((g) obj).f505a);
    }

    public final int hashCode() {
        return this.f505a.hashCode();
    }

    public final String toString() {
        return B7.a.m("Success(message=", this.f505a, ")");
    }
}
