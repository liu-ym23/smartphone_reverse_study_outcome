package com.stepos.core.callback;

/* loaded from: classes3.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3827a;
    public final String b;

    public b(int i, String str) {
        this.f3827a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3827a == bVar.f3827a && this.b.equals(bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f3827a) * 31);
    }

    public final String toString() {
        return "InferResult.Error(" + this.f3827a + ": " + this.b + ")";
    }
}
