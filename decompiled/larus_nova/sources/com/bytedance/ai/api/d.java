package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletBottomSheetButtonRole f34005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34006b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f34005a == r101.f34005a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34006b, r101.f34006b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f34005a.hashCode() * 31) + this.f34006b.hashCode();
    }

    public final String toString() {
        return "AppletBottomSheetButton(role=" + this.f34005a + ", text=" + this.f34006b + ')';
    }

    public d(AppletBottomSheetButtonRole r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "role");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f34005a = r100;
        this.f34006b = r101;
    }
}
