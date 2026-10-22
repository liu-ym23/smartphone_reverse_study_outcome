package com.stepos.core.transport.bridge;

import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3828a;
    public final Content b;

    public b(String requestId, Content content) {
        k.f(requestId, "requestId");
        this.f3828a = requestId;
        this.b = content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.b(this.f3828a, bVar.f3828a) && k.b(this.b, bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f3828a.hashCode() * 31);
    }

    public final String toString() {
        return "InferenceRequest(requestId=" + this.f3828a + ", input=" + this.b + ")";
    }
}
