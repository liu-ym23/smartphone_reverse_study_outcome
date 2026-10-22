package com.bytedance.android.livesdk.chatroom.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f106964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f106965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f106966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f106967d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L14;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f106964a, r101.f106964a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106965b, r101.f106965b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f106966c, r101.f106966c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f106967d, r101.f106967d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f106964a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f106965b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f106966c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f106967d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ButtonInfo(toast=" + this.f106964a + ", disable=" + this.f106965b + ", schema=" + this.f106966c + ", clickToNext=" + this.f106967d + ")";
    }

    public r() {
        Boolean r100 = Boolean.FALSE;
        this.f106964a = "";
        this.f106965b = r100;
        this.f106966c = "";
        this.f106967d = r100;
    }
}
