package com.google.protobuf;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2530a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2531b;

    public t1(int i2, MessageLite messageLite) {
        this.f2530a = messageLite;
        this.f2531b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.f2530a == t1Var.f2530a && this.f2531b == t1Var.f2531b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f2530a) * 65535) + this.f2531b;
    }
}
