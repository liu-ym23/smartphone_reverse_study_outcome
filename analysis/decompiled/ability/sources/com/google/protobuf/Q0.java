package com.google.protobuf;

/* loaded from: classes3.dex */
public final class Q0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2866a;
    public final int b;

    public Q0(int i, X1 x12) {
        this.f2866a = x12;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Q0)) {
            return false;
        }
        Q0 q02 = (Q0) obj;
        return this.f2866a == q02.f2866a && this.b == q02.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f2866a) * 65535) + this.b;
    }
}
