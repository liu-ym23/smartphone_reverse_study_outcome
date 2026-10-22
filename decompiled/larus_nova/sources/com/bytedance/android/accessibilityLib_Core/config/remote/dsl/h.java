package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f38209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38211d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (this.f38208a == r101.f38208a) goto L8;
        return false;
    L8:
        if (this.f38209b == r101.f38209b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f38210c, r101.f38210c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38211d, r101.f38211d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f38208a * 31) + this.f38209b) * 31;
        String r101 = this.f38210c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f38211d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewIdentifyDsl(layoutId=" + this.f38208a + ", viewId=" + this.f38209b + ", layoutIdName=" + this.f38210c + ", viewIdName=" + this.f38211d + ')';
    }

    public h(int r100, int r101, String r102, String r103) {
        this.f38208a = r100;
        this.f38209b = r101;
        this.f38210c = r102;
        this.f38211d = r103;
    }
}
