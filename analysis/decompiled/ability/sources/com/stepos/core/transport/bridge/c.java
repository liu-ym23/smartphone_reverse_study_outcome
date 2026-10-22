package com.stepos.core.transport.bridge;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3829a;

    public c(String str) {
        this.f3829a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        cVar.getClass();
        return this.f3829a.equals(cVar.f3829a);
    }

    public final int hashCode() {
        return B7.a.c(Integer.hashCode(130001) * 31, 31, this.f3829a);
    }

    public final String toString() {
        return B7.a.m("InferenceResponseError(code=130001, message=", this.f3829a, ", cause=null)");
    }
}
