package com.bytedance.ai.core.base;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f36152c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f36150a, r101.f36150a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f36151b, r101.f36151b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f36150a.hashCode() * 31) + this.f36151b.hashCode();
    }

    public final String toString() {
        return "RuntimeTask(sessionId=" + this.f36150a + ", taskName=" + this.f36151b + ')';
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "taskName");
        this.f36150a = r100;
        this.f36151b = r101;
        ConcurrentHashMap<String, String> r102 = x4.a.f562420a;
        UUID.randomUUID().toString();
        this.f36152c = new AtomicBoolean(false);
    }
}
