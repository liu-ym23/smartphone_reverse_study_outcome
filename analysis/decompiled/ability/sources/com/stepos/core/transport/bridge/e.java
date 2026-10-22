package com.stepos.core.transport.bridge;

import kotlin.jvm.internal.k;
import z2.l;

/* loaded from: classes3.dex */
public final class e extends l {
    public final String m;

    public e(String requestId) {
        k.f(requestId, "requestId");
        this.m = requestId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && k.b(this.m, ((e) obj).m);
    }

    public final int hashCode() {
        return this.m.hashCode();
    }

    public final String toString() {
        return B7.a.m("Success(requestId=", this.m, ")");
    }
}
