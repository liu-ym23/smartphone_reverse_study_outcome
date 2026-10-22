package com.obric.appstore.network;

import com.obric.appstore.network.entity.HttpResp;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpResp f10964a;

    public d(HttpResp r10) {
        q.g(r10, "httpResult");
        super(null);
        this.f10964a = r10;
    }

    public final HttpResp a() {
        return this.f10964a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f10964a, ((d) r10).f10964a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f10964a.hashCode();
    }

    public String toString() {
        return "ApiSuccessResponse(httpResult=" + this.f10964a + ')';
    }
}
