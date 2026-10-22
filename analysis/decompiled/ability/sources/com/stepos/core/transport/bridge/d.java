package com.stepos.core.transport.bridge;

import kotlin.jvm.internal.k;
import z2.l;

/* loaded from: classes3.dex */
public final class d extends l {
    public final String m;
    public final c n;

    public d(String requestId, c cVar) {
        k.f(requestId, "requestId");
        this.m = requestId;
        this.n = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.b(this.m, dVar.m) && k.b(this.n, dVar.n);
    }

    public final int hashCode() {
        return this.n.hashCode() + (this.m.hashCode() * 31);
    }

    public final String toString() {
        return "Failure(requestId=" + this.m + ", error=" + this.n + ")";
    }
}
