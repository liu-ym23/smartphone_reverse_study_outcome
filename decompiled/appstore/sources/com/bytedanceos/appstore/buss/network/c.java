package com.bytedanceos.appstore.buss.network;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpResult f8797a;

    public c(HttpResult r10) {
        q.g(r10, "httpResult");
        super(null);
        this.f8797a = r10;
    }

    public final HttpResult a() {
        return this.f8797a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f8797a, ((c) r10).f8797a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f8797a.hashCode();
    }

    public String toString() {
        return "ApiSuccessResponse(httpResult=" + this.f8797a + ')';
    }
}
