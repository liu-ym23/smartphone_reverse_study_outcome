package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f38183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f38184b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f38183a, r101.f38183a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f38184b, r101.f38184b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<e> r100 = this.f38183a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<h> r104 = this.f38184b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LabelConfigDsl(labelList=" + this.f38183a + ", condition=" + this.f38184b + ')';
    }

    public c() {
        this(CollectionsKt.emptyList(), null);
    }

    public c(List<e> r100, List<h> r101) {
        this.f38183a = r100;
        this.f38184b = r101;
    }
}
