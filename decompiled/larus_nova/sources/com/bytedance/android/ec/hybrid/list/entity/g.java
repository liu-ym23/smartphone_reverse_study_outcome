package com.bytedance.android.ec.hybrid.list.entity;

import com.bytedance.ai.event.MessageIndication;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f47104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f47105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<p> f47106c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f47104a, r101.f47104a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f47105b, r101.f47105b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f47106c, r101.f47106c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.f47104a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<h> r104 = this.f47105b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<p> r107 = this.f47106c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECHybridListPreloadCard(interrupt=" + this.f47104a + ", nativeCard=" + this.f47105b + ", lynxCard=" + this.f47106c + ")";
    }

    public g(List r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, MessageIndication.STATUS_INTERRUPT);
        this.f47104a = r100;
        this.f47105b = null;
        this.f47106c = r101;
    }
}
