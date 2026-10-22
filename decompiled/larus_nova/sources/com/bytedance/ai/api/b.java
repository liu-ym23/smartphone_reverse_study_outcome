package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34003b;

    public b() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f34002a, r101.f34002a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34003b, r101.f34003b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f34002a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f34003b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletBottomSheetAppInfo(name=" + this.f34002a + ", iconUrl=" + this.f34003b + ')';
    }

    public b(String r100, String r101) {
        this.f34002a = r100;
        this.f34003b = r101;
    }
}
