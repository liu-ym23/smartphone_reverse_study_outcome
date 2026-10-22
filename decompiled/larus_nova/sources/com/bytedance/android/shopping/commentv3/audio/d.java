package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f172614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f172615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f172616c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f172614a == r101.f172614a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172615b, r101.f172615b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172616c, r101.f172616c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f172614a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.f172615b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f172616c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "AudioControlResult(success=" + this.f172614a + ", errorCode=" + this.f172615b + ", errorMsg=" + this.f172616c + ")";
    }

    public d(boolean r100, Integer r101, String r102) {
        this.f172614a = r100;
        this.f172615b = r101;
        this.f172616c = r102;
    }
}
