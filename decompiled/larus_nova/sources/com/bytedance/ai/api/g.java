package com.bytedance.ai.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f34019d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f34016a, r101.f34016a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34017b, r101.f34017b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34018c, r101.f34018c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34019d, r101.f34019d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f34016a.hashCode() * 31) + this.f34017b.hashCode()) * 31) + this.f34018c.hashCode()) * 31) + this.f34019d.hashCode();
    }

    public final String toString() {
        return "AppletRequestLunaMusicConfig(clientKey=" + this.f34016a + ", scope=" + this.f34017b + ", state=" + this.f34018c + ", traceInfo=" + this.f34019d + ')';
    }

    public g(String r100, String r101, String r102, HashMap<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        this.f34016a = r100;
        this.f34017b = r101;
        this.f34018c = r102;
        this.f34019d = r103;
    }
}
