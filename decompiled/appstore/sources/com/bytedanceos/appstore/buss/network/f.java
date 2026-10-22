package com.bytedanceos.appstore.buss.network;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssistantHttpResult f8805a;

    public f(AssistantHttpResult r10) {
        q.g(r10, "httpResult");
        super(null);
        this.f8805a = r10;
    }

    public final AssistantHttpResult a() {
        return this.f8805a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f8805a, ((f) r10).f8805a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f8805a.hashCode();
    }

    public String toString() {
        return "AssistantApiSuccessResponse(httpResult=" + this.f8805a + ')';
    }
}
