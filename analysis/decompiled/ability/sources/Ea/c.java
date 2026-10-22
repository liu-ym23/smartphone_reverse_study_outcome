package Ea;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class c extends d {

    /* renamed from: a, reason: collision with root package name */
    public final String f502a;

    public c(String str) {
        this.f502a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && k.b(this.f502a, ((c) obj).f502a);
    }

    public final int hashCode() {
        return this.f502a.hashCode();
    }

    public final String toString() {
        return B7.a.m("Recovered(message=", this.f502a, ")");
    }
}
