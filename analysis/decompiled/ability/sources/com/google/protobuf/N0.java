package com.google.protobuf;

/* loaded from: classes3.dex */
public final class N0 {

    /* renamed from: a, reason: collision with root package name */
    public final C1004w0 f2859a;
    public final int b;

    public N0(C1004w0 c1004w0, int i) {
        this.f2859a = c1004w0;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof N0)) {
            return false;
        }
        N0 n02 = (N0) obj;
        return this.f2859a == n02.f2859a && this.b == n02.b;
    }

    public final int hashCode() {
        return (this.f2859a.hashCode() * 65535) + this.b;
    }
}
