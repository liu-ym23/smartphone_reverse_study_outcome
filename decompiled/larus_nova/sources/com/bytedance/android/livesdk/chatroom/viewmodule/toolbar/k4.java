package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f116368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f116369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f116370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f116371d;

    public k4() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k4) == false) goto L14;
        k4 r101 = (k4) r100;
        if (Intrinsics.areEqual(this.f116368a, r101.f116368a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f116369b, r101.f116369b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f116370c, r101.f116370c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f116371d, r101.f116371d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f116368a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f116369b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f116370c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f116371d;
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
        return "VSToolbarExtend(landscapeIcon=" + this.f116368a + ", landscapeName=" + this.f116369b + ", portraitIcon=" + this.f116370c + ", extraBgRes=" + this.f116371d + ")";
    }

    public k4(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.f116368a = r100;
        this.f116369b = r101;
        this.f116370c = r102;
        this.f116371d = r103;
    }
}
