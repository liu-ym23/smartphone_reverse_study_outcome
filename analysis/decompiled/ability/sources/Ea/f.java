package Ea;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class f extends h {

    /* renamed from: a, reason: collision with root package name */
    public final String f504a;

    public f(String str) {
        this.f504a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && k.b(this.f504a, ((f) obj).f504a);
    }

    public final int hashCode() {
        return this.f504a.hashCode();
    }

    public final String toString() {
        return B7.a.m("Failure(message=", this.f504a, ")");
    }
}
