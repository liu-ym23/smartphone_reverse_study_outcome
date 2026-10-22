package com.bytedanceos.appstore.buss.network.ad;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdHttpResult f8789a;

    public c(AdHttpResult r10) {
        q.g(r10, "httpResult");
        super(null);
        this.f8789a = r10;
    }

    public final AdHttpResult a() {
        return this.f8789a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f8789a, ((c) r10).f8789a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f8789a.hashCode();
    }

    public String toString() {
        return "AdApiSuccessResponse(httpResult=" + this.f8789a + ')';
    }
}
