package com.bytedance.android.ec.core.frontier;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44042b;

    public c() {
        this(null, null);
    }

    public final int hashCode() {
        String r100 = this.f44041a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f44042b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if ((r100 instanceof c) == false) goto L17;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f44041a, r101.f44041a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.f44042b, r101.f44042b) == false) goto L15;
        return true;
    }

    public c(String r100, String r101) {
        this.f44041a = r100;
        this.f44042b = r101;
    }
}
