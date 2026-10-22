package com.bytedance.android.latch.prefetch.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d0> f58490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f58491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f58492d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f58489a, r101.f58489a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f58490b, r101.f58490b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f58491c, r101.f58491c) == true) goto L18;
        return false;
    L18:
        if (this.f58492d == r101.f58492d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f58489a.hashCode() * 31) + this.f58490b.hashCode()) * 31) + this.f58491c.hashCode()) * 31) + this.f58492d;
    }

    public final String toString() {
        return "PagePrefetchConfig(version=" + this.f58489a + ", requestConfigs=" + this.f58490b + ", jsbPaths=" + this.f58491c + ", latchJsonVersion=" + this.f58492d + ')';
    }

    public t(String r100, Map<String, d0> r101, JSONObject r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "version");
        Intrinsics.checkNotNullParameter(r101, "requestConfigs");
        Intrinsics.checkNotNullParameter(r102, "jsbPaths");
        this.f58489a = r100;
        this.f58490b = r101;
        this.f58491c = r102;
        this.f58492d = r103;
    }
}
