package com.bytedance.android.shopping.buynow.eventcenter.handle;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<?, ?> f170941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f170943c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f170941a, r101.f170941a) == true) goto L8;
        return false;
    L8:
        if (this.f170942b == r101.f170942b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170943c, r101.f170943c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<?, ?> r100 = this.f170941a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f170942b) * 31;
        List<Integer> r104 = this.f170943c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CheckPayStatusParamsWrapper(checkPayStatusParams=" + this.f170941a + ", checkPayStatusTimes=" + this.f170942b + ", checkPayStatusTimesGaps=" + this.f170943c + ")";
    }

    public b(Map<?, ?> r100, int r101, List<Integer> r102) {
        this.f170941a = r100;
        this.f170942b = r101;
        this.f170943c = r102;
    }
}
