package com.bytedance.android.ec.core.imagex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Long f44668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Long f44669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Integer f44670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile g f44671d;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f44668a, r101.f44668a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f44669b, r101.f44669b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44670c, r101.f44670c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f44671d, r101.f44671d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f44668a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f44669b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f44670c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        g r110 = this.f44671d;
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
        return "ECImageFinalSetData(requestEndTime=" + this.f44668a + ", finalImageSetTime=" + this.f44669b + ", imageFrom=" + this.f44670c + ", reportData=" + this.f44671d + ")";
    }

    public f(int r100) {
        this.f44668a = null;
        this.f44669b = null;
        this.f44670c = null;
        this.f44671d = null;
    }
}
